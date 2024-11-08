
package Clases;

import BaseDeDatos.UsuariosCreados;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Usuario extends Persona{
    private String nombreUsuario;
    private String clave;
    
    private static final Map<String, Usuario> usuarios = new HashMap<>();

    public Usuario(String nombre, String apellido, String nombreUsuario, 
                  String email, String clave, String genero, 
                  String fechaNacimiento) {
        super(nombre, apellido, email, genero, fechaNacimiento);
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }
    
    // Getters específicos de Usuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    // Setters específicos de Usuario
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public boolean registrar() {
        if (!UsuariosCreados.isUsernameAvailable(this.nombreUsuario)) {
        return false;
        }

        boolean resultado = UsuariosCreados.saveUserData(
            this.nombre,
            this.apellido,
            this.nombreUsuario,
            this.email,
            this.clave,
            this.genero,
            this.fechaNacimiento
        );

        if (resultado) {
            usuarios.put(this.nombreUsuario, this);
            return true;
        } else {
            return false;
        }
    }
    
     public boolean autenticar(String passwordIntento) {
        Usuario usuario = Usuario.cargarUsuario(this.nombreUsuario);
        return usuario != null && usuario.clave.equals(passwordIntento);
    }

    public static Usuario obtenerUsuario(String nombreUsuario) {
        return usuarios.get(nombreUsuario);
    }
    
    public static Usuario fromDataArray(String[] data) {
        if (data.length == 7) {
            return new Usuario(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
        } else {
            System.err.println("Datos insuficientes para crear Usuario");
            return null;
        }
    }
    
    public static Usuario cargarUsuario(String nombreUsuario) {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 7 && datos[2].trim().equals(nombreUsuario)) {
                    return new Usuario(
                        datos[0].trim(), // nombre
                        datos[1].trim(), // apellido
                        datos[2].trim(), // nombreUsuario
                        datos[3].trim(), // email
                        datos[4].trim(), // clave
                        datos[5].trim(), // genero
                        datos[6].trim()  // fechaNacimiento
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
               "nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", nombreUsuario='" + nombreUsuario + '\'' +
               ", email='" + email + '\'' +
               ", genero='" + genero + '\'' +
               ", fechaNacimiento='" + fechaNacimiento + '\'' +
               '}';
    }
}
