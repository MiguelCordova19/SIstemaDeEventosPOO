
package Clases;

import BaseDeDatos.UsuariosCreados;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import BaseDeDatos.UsuarioDAO;
import java.util.List;

public class Usuario extends Persona{
    private String nombreUsuario;
    private String clave;
    private String rol;
    
    private static final Map<String, Usuario> usuarios = new HashMap<>();

    public Usuario(String nombre, String nombreUsuario, String email, 
                   String genero, String clave, String rol, String fechaNacimiento) {
        super(nombre, null, email, genero, fechaNacimiento);
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.rol = rol;
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
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public boolean registrar() {
        if (!UsuarioDAO.isUsernameAvailable(this.nombreUsuario)) {
            return false;
        }
        return UsuarioDAO.guardarUsuario(this);
    }
    
     public boolean autenticar(String passwordIntento) {
        Usuario usuarioEncontrado = UsuarioDAO.obtenerUsuarioPorUsername(this.nombreUsuario);
        return usuarioEncontrado != null && usuarioEncontrado.clave.equals(passwordIntento);
    }
     
    public boolean actualizar() {
        return UsuarioDAO.actualizarUsuario(this);
    }

    // Método para eliminar usuario de la base de datos
    public boolean eliminar() {
        return UsuarioDAO.eliminarUsuario(this.nombreUsuario);
    }


    public static Usuario obtenerUsuario(String nombreUsuario) {
        return usuarios.get(nombreUsuario);
    }
    
    // Método estático para obtener todos los usuarios
    public static List<Usuario> obtenerTodosLosUsuarios() {
        return UsuarioDAO.obtenerTodosLosUsuarios();
    }
    
    public static boolean existeUsuario(String nombreUsuario) {
        return UsuarioDAO.obtenerUsuarioPorUsername(nombreUsuario) != null;
    }
    
    // Método para cambiar contraseña
    public boolean cambiarClave(String nuevaClave) {
        this.clave = nuevaClave;
        return actualizar();
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
    
    // Método toString mejorado
    @Override
    public String toString() {
        return "Usuario{" +
               "nombre='" + nombre + '\'' +
               ", nombreUsuario='" + nombreUsuario + '\'' +
               ", email='" + email + '\'' +
               ", genero='" + genero + '\'' +
               ", rol='" + rol + '\'' +
               ", fechaNacimiento='" + fechaNacimiento + '\'' +
               '}';
    }
}
