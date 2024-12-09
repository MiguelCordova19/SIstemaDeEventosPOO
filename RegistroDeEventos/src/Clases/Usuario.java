package Clases;

import BaseDeDatos.UsuarioDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Usuario extends Persona {
    private String nombreUsuario;
    private String clave;
    
    private static final Map<String, Usuario> usuarios = new HashMap<>();

    public Usuario(String nombre, String apellido, String nombreUsuario, 
                   String email, String clave, String genero, String fechaNacimiento) {
        super(nombre, apellido, email, genero, fechaNacimiento);
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }
    
    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
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
        try {
            // Hash de la contraseña antes de guardar
            this.clave = hashPassword(this.clave);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al hashear contraseña: " + e.getMessage());
            return false;
        }

        if (!UsuarioDAO.isUsernameAvailable(this.nombreUsuario)) {
            return false;
        }
        return UsuarioDAO.guardarUsuario(this);
    }
    
    public boolean autenticar(String passwordIntento) {
        Usuario usuarioEncontrado = UsuarioDAO.obtenerUsuarioPorUsername(this.nombreUsuario);
    
        if (usuarioEncontrado == null) {
            return false; // Usuario no encontrado
        }

        try {
            // Hash del password intentado
            String hashedPasswordIntento = hashPassword(passwordIntento);

            // Comparar hashes
            return usuarioEncontrado.clave.equals(hashedPasswordIntento);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error en autenticación: " + e.getMessage());
            return false;
        }
    }
     
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }
     
    public boolean actualizar() {
        return UsuarioDAO.actualizarUsuario(this);
    }

    public boolean eliminar() {
        return UsuarioDAO.eliminarUsuario(this.nombreUsuario);
    }

    public static Usuario obtenerUsuario(String nombreUsuario) {
        return usuarios.get(nombreUsuario);
    }
    
    public static List<Usuario> obtenerTodosLosUsuarios() {
        return UsuarioDAO.obtenerTodosLosUsuarios();
    }
    
    public static boolean existeUsuario(String nombreUsuario) {
        return UsuarioDAO.obtenerUsuarioPorUsername(nombreUsuario) != null;
    }
    
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
    
    @Override
    public String toString() {
        return "Usuario{" +
               "nombre='" + nombre + '\'' +
               ", nombreUsuario='" + nombreUsuario + '\'' +
               ", email='" + email + '\'' +
               ", genero='" + genero + '\'' +
               ", fechaNacimiento='" + fechaNacimiento + '\'' +
               '}';
    }
}