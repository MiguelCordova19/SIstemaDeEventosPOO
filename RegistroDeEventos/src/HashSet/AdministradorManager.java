
package HashSet;

import Clases.Administrador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AdministradorManager {
    private static final String ARCHIVO_ADMINS = "administradores.txt";
    private Set<Administrador> administradores;
    private static AdministradorManager instancia;
    
    // Constructor privado para patrón Singleton
    private AdministradorManager() {
        this.administradores = new HashSet<>();
        cargarAdministradores();
    }
    
    // Método para obtener la instancia única
    public static AdministradorManager obtenerInstancia() {
        if (instancia == null) {
            instancia = new AdministradorManager();
        }
        return instancia;
    }
    
    // Métodos para gestionar el HashSet
    public boolean agregarAdministrador(Administrador admin) {
        boolean agregado = administradores.add(admin);
        if (agregado) {
            guardarAdministradores();
        }
        return agregado;
    }
    
    public boolean eliminarAdministrador(Administrador admin) {
        boolean eliminado = administradores.remove(admin);
        if (eliminado) {
            guardarAdministradores();
        }
        return eliminado;
    }
    
    public Set<Administrador> obtenerAdministradores() {
        return new HashSet<>(administradores);
    }
    
    public Administrador buscarPorEmail(String email) {
        return administradores.stream()
            .filter(admin -> admin.getEmail().equals(email))
            .findFirst()
            .orElse(null);
    }
    
    // Métodos para persistencia en archivo
    private void guardarAdministradores() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_ADMINS))) {
            for (Administrador admin : administradores) {
                writer.write(String.format("%s,%s,%s,%s,%s%n",
                    admin.getNombre(),
                    admin.getApellido(),
                    admin.getEmail(),
                    admin.getGenero(),
                    admin.getFechaNacimiento()));
            }
        } catch (IOException e) {
            System.err.println("Error al guardar administradores: " + e.getMessage());
        }
    }
    
    private void cargarAdministradores() {
        File archivo = new File(ARCHIVO_ADMINS);
        
        if (!archivo.exists()) {
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_ADMINS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    Administrador admin = new Administrador(
                        datos[0], // nombre
                        datos[1], // apellido
                        datos[2], // email
                        datos[3], // genero
                        datos[4]  // fechaNacimiento
                    );
                    administradores.add(admin);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar administradores: " + e.getMessage());
        }
    }
}
