
package HashSet;

import Clases.Administrador;
import Clases.Plataforma;
import Clases.Usuario;
import java.util.HashSet;
import java.util.Set;

public class AdministradorManager {
    private Set<Administrador> administradores;
    private Plataforma plataforma;
    private static AdministradorManager instancia;

    private AdministradorManager() {
        this.administradores = new HashSet<>();
        this.plataforma = new Plataforma();
        cargarAdministradores();
    }

    public static AdministradorManager obtenerInstancia() {
        if (instancia == null) {
            instancia = new AdministradorManager();
        }
        return instancia;
    }

    public boolean agregarAdministrador(Administrador admin) {
        boolean agregado = administradores.add(admin);
        if (agregado) {
            guardarAdministradores();
        }
        return agregado;
    }

    public boolean eliminarAdministrador(Administrador admin) {
        boolean eliminado = administradores.remove(admin);
        if (eliminado) {
            guardarAdministradores();
        }
        return eliminado;
    }

    public Set<Administrador> obtenerAdministradores() {
        return new HashSet<>(administradores);
    }

    public Administrador buscarPorEmail(String email) {
        return administradores.stream()
                .filter(admin -> admin.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Set<Usuario> obtenerUsuarios() {
        return new HashSet<>();
    }

    public void agregarUsuario(Usuario usuario) {
        plataforma.gestionarUsuarios(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        plataforma.eliminarUsuario(usuario);
    }

    private void guardarAdministradores() {
    }

    private void cargarAdministradores() {
    }
}
