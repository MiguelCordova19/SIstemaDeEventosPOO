
package BaseDeDatos;

import Clases.Usuario;
import ConexionDB.SQLConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    // Crear la tabla si no existe
    public static void crearTablaUsuarios() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nombre VARCHAR(50) NOT NULL,"
                + "apellido VARCHAR(50) NOT NULL,"
                + "nombre_usuario VARCHAR(50) UNIQUE NOT NULL,"
                + "email VARCHAR(100) UNIQUE NOT NULL,"
                + "clave VARCHAR(50) NOT NULL,"
                + "genero VARCHAR(20),"
                + "fecha_nacimiento VARCHAR(20)"
                + ")";
                
        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.execute();
            System.out.println("Tabla usuarios creada o verificada correctamente");
            
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla de usuarios: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Guardar un nuevo usuario
    public static boolean guardarUsuario(Usuario usuario) {
        String sql = """
            INSERT INTO usuarios (nombre, apellido, nombre_usuario, email, clave, genero, fecha_nacimiento)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;
        
        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getNombreUsuario());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getClave());
            stmt.setString(6, usuario.getGenero());
            stmt.setString(7, usuario.getFechaNacimiento());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al guardar usuario: " + e.getMessage());
            return false;
        }
    }
    
    // Verificar si existe un nombre de usuario
    public static boolean isUsernameAvailable(String username) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE nombre_usuario = ?";
        
        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) == 0; // Si count es 0, el username está disponible
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Error al verificar username: " + e.getMessage());
            return false;
        }
    }
    
    // Obtener un usuario por su nombre de usuario
    public static Usuario obtenerUsuarioPorUsername(String username) {
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ?";
        
        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Usuario(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("nombre_usuario"),
                    rs.getString("email"),
                    rs.getString("clave"),
                    rs.getString("genero"),
                    rs.getString("fecha_nacimiento")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuario: " + e.getMessage());
        }
        return null;
    }
    
    // Obtener lista de todos los usuarios
    public static List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        
        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("nombre_usuario"),
                    rs.getString("email"),
                    rs.getString("clave"),
                    rs.getString("genero"),
                    rs.getString("fecha_nacimiento")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
        }
        return usuarios;
    }
}
