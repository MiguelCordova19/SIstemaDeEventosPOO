
package Clases;

import BaseDeDatos.UsuariosCreados;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Plataforma {
    private Set<Evento> eventos;

    public Plataforma() {
        this.eventos = new HashSet<>();
    }

    public void agregarEventos(Evento evento) {
        eventos.add(evento);
    }

    public Set<Evento> obtenerEventos() {
        return new HashSet<>(eventos);
    }

    public void gestionarUsuarios(Usuario usuario) {
        UsuariosCreados.saveUserData(
            usuario.getNombre(),
            usuario.getApellido(),
            usuario.getNombreUsuario(),
            usuario.getEmail(),
            usuario.getClave(),
            usuario.getGenero(),
            usuario.getFechaNacimiento()
        );
    }

    public void eliminarUsuario(Usuario usuario) {
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        // Leer archivo y excluir el usuario que se desea eliminar
        try (BufferedReader reader = new BufferedReader(new FileReader(UsuariosCreados.ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7 && !datos[2].equals(usuario.getNombreUsuario())) {
                    lineas.add(linea);
                } else if (datos.length == 7 && datos[2].equals(usuario.getNombreUsuario())) {
                    encontrado = true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage());
            e.printStackTrace();
        }

        // Escribir las líneas actualizadas si se encontró el usuario
        if (encontrado) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(UsuariosCreados.ARCHIVO_USUARIOS))) {
                for (String l : lineas) {
                    writer.write(l);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Error al escribir el archivo de usuarios: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Usuario no encontrado: " + usuario.getNombreUsuario());
        }
    }

    public Set<Usuario> obtenerUsuarios() {
        Set<Usuario> usuarios = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(UsuariosCreados.ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    Usuario usuario = Usuario.fromDataArray(datos);
                    if (usuario != null) {
                        usuarios.add(usuario);
                    }
                } else {
                    System.err.println("Error: línea con formato incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage());
            e.printStackTrace();
        }
        return usuarios;
    }
}

