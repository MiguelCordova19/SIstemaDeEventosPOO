
package Listar;

import Clases.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioList {
      List<Usuario> ListaUsuarios = new ArrayList<>();  
  public void agregar (Usuario u){
      ListaUsuarios.add(u);
  }
  public void quitar (Usuario u){
       ListaUsuarios.remove(u);
  }
  public Usuario obtener (int pag){
      return  ListaUsuarios.get(pag);
  }
  public List <Usuario> listar(){
      return this.ListaUsuarios;
  }
}

