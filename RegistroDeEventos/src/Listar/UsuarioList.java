
package Listar;

import BaseDeDatos.UsuarioDAO;
import Clases.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioList {
    
  public List<Usuario> listar() {
        return UsuarioDAO.obtenerTodosLosUsuarios();
  }
    
  public void agregar(Usuario u) {
        u.registrar();
  }
  
}

