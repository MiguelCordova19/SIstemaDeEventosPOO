
package BaseDeDatos;

import Clases.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class UsuariosCreados {
    public static final String ARCHIVO_USUARIOS = "usuarios.txt";

    public static boolean isUsernameAvailable(String username) {
        createFileIfNotExists();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length > 2 && datos[2].equals(username)) {
                    return false; // Usuario ya existe
                }
            }
            return true; // Usuario disponible
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean saveUserData(String nombre, String apellido, String usuario, 
                                  String correo, String clave, String genero, 
                                  String fechaNacimiento) {
        createFileIfNotExists();

        try (FileWriter writer = new FileWriter(ARCHIVO_USUARIOS, true);
             BufferedWriter buffWriter = new BufferedWriter(writer)) {

            // Formato: nombre,apellido,usuario,correo,clave,genero,fechaNacimiento
            String userData = String.format("%s,%s,%s,%s,%s,%s,%s",
                nombre, apellido, usuario, correo, clave, genero, fechaNacimiento);

            buffWriter.write(userData);
            buffWriter.newLine();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void createFileIfNotExists() {
        try {
            File file = new File(ARCHIVO_USUARIOS);
            if (!file.exists()) {
                Files.createDirectories(file.getParentFile().toPath());
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Usuario> obtenerUsuarios() {
    List<Usuario> usuarios = new ArrayList<>();
    createFileIfNotExists();
    
    try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
        String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    Usuario usuario = new Usuario(
                        datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]
                    );
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}
