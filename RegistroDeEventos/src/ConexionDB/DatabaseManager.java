
package ConexionDB;

import Clases.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    public static void crearTabla(String sql) {
        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("Tabla creada exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al crear tabla: " + e.getMessage());
        }
    }
    
    public static boolean insertarRegistro(String sql, Object... params) {
        try (Connection conn = SQLConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }
    
    public static ResultSet consultarDatos(String sql) {
        try {
            Connection conn = SQLConexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public static boolean existeRegistro(String consulta, String parametro) {
        try (Connection conn = SQLConexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setString(1, parametro);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
