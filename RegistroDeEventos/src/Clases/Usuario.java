
package Clases;

import BaseDeDatos.UsuariosCreados;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Usuario extends Persona{
    private String nombreUsuario;
    private String clave;
    
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
    
    // Método para registrar un nuevo usuario
    public boolean registrar() {
        try {
            if (!UsuariosCreados.isUsernameAvailable(this.nombreUsuario)) {
                return false;
            }
            
            UsuariosCreados.saveUserData(
                this.nombre,
                this.apellido,
                this.nombreUsuario,
                this.email,
                this.clave,
                this.genero,
                this.fechaNacimiento
            );
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Implementación del método abstracto de autenticación
    @Override
    public boolean autenticar(String passwordIntento) {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                // Verifica si el usuario y la contraseña coinciden
                if (datos.length >= 5 && 
                    datos[2].trim().equals(this.nombreUsuario) && 
                    datos[4].trim().equals(passwordIntento)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Método estático para cargar un usuario desde el archivo
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
