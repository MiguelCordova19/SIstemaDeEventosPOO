
package Clases;

import BaseDeDatos.UsuariosCreados;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import BaseDeDatos.UsuarioDAO;

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
        if (!UsuarioDAO.isUsernameAvailable(this.nombreUsuario)) {
            return false;
        }
        return UsuarioDAO.guardarUsuario(this);
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
        return UsuarioDAO.obtenerUsuarioPorUsername(nombreUsuario);
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
