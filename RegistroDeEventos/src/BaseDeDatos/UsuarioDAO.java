
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
    
    public static void crearTablaRoles() {
        String sql = "CREATE TABLE IF NOT EXISTS roles ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nombre_usuario VARCHAR(50) NOT NULL,"
                + "rol VARCHAR(20) NOT NULL DEFAULT 'Usuario',"
                + "FOREIGN KEY (nombre_usuario) REFERENCES usuarios(nombre_usuario)"
                + "ON DELETE CASCADE"
                + ")";

        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
            System.out.println("Tabla roles creada o verificada correctamente");

        } catch (SQLException e) {
            System.err.println("Error al crear la tabla de roles: " + e.getMessage());
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
    
    public static boolean eliminarUsuario(String nombreUsuario) {
        String sql = "DELETE FROM usuarios WHERE nombre_usuario = ?";
    
        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreUsuario);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
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
        String sql = "SELECT nombre, nombre_usuario, email, genero FROM usuarios";

        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getString("nombre"),
                    rs.getString("nombre_usuario"),
                    rs.getString("email"),
                    rs.getString("genero"),
                    "", // contraseña vacía ya que no la necesitamos mostrar
                    "Usuario", // rol por defecto
                    "" // fecha de nacimiento no necesaria para mostrar
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public static boolean asignarRolAUsuario(int idUsuario, int idRol) {
        String sql = "INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (?, ?)";

        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idRol);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al asignar rol al usuario: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean asignarRolAdministrador(String nombreUsuario) {
        String sql = "SELECT nombre_rol FROM roles WHERE nombre_usuario = ?";

        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Si el usuario ya tiene un rol, actualizarlo a "Administrador"
                String rolActual = rs.getString("nombre_rol");
                if (!"Administrador".equals(rolActual)) {
                    sql = "UPDATE roles SET nombre_rol = 'Administrador' WHERE nombre_usuario = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(sql)) {
                        updateStmt.setString(1, nombreUsuario);
                        return updateStmt.executeUpdate() > 0;
                    }
                } else {
                    // El usuario ya es administrador
                    return true;
                }
            } else {
                // Si el usuario no tiene un rol, insertarlo como "Administrador"
                sql = "INSERT INTO roles (nombre_usuario, nombre_rol) VALUES (?, 'Administrador')";
                try (PreparedStatement insertStmt = conn.prepareStatement(sql)) {
                    insertStmt.setString(1, nombreUsuario);
                    return insertStmt.executeUpdate() > 0;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al asignar rol de administrador: " + e.getMessage());
            return false;
        }
    }
    
    // Método para actualizar usuario
    public static boolean actualizarUsuario(Usuario usuario) {
        String sql = """
            UPDATE usuarios 
            SET nombre = ?, 
                apellido = ?, 
                email = ?, 
                clave = ?, 
                genero = ?, 
                fecha_nacimiento = ? 
            WHERE nombre_usuario = ?
        """;
        
        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getClave());
            stmt.setString(5, usuario.getGenero());
            stmt.setString(6, usuario.getFechaNacimiento());
            stmt.setString(7, usuario.getNombreUsuario());
            
            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }
    
    // Método de fábrica para crear Usuario desde ResultSet
    public static Usuario fromResultSet(ResultSet rs) throws SQLException {
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
    
    // Método para obtener rol de usuario
    public static String obtenerRolUsuario(String nombreUsuario) {
        String sql = "SELECT rol FROM roles WHERE nombre_usuario = ?";
        
        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("rol");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener rol de usuario: " + e.getMessage());
        }
        return "Usuario"; // Rol por defecto
    }
    
}
