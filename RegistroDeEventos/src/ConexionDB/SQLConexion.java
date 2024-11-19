
package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class SQLConexion {
    private static final String HOST = "byw8ilmjor2flk5wjro4-mysql.services.clever-cloud.com";
    private static final String PORT = "3306";
    private static final String DATABASE = "byw8ilmjor2flk5wjro4";
    private static final String USERNAME = "upvmeufz838enupc";
    private static final String PASSWORD = "spdQK2jykZ9sVRs3Obtn";
    
    private static final String URL = String.format(
        "jdbc:mysql://%s:%s/%s?useSSL=true&serverTimezone=UTC",
        HOST, PORT, DATABASE
    );
    
    static {
        try {
            // Cargar el driver explícitamente
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver MySQL: " + e.getMessage());
        }
    }
    
    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USERNAME);
        props.setProperty("password", PASSWORD);
        props.setProperty("useSSL", "true");
        props.setProperty("verifyServerCertificate", "false"); // Cambiado a false para pruebas
        props.setProperty("requireSSL", "false"); // Cambiado a false para pruebas
        
        Connection conn = DriverManager.getConnection(URL, props);
        if (conn == null) {
            throw new SQLException("No se pudo establecer la conexión");
        }
        return conn;
    }
    
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("¡Conexión exitosa a Clever Cloud!");
            
            try (PreparedStatement stmt = conn.prepareStatement("SELECT 1");
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Base de datos responde correctamente");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
