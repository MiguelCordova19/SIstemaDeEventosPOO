
package Listar;

import Clases.FormatoPago;
import java.util.ArrayList;
import java.util.List;

public class SistemaPagoList {
    List<FormatoPago> listaSistemaPagos = new ArrayList<>();  
  public void agregar (FormatoPago p){
      listaSistemaPagos.add(p);
  }
  public void quitar (FormatoPago p){
       listaSistemaPagos.remove(p);
  }
  public FormatoPago obtener (int pag){
      return  listaSistemaPagos.get(pag);
  }
  public List <FormatoPago> listar(){
      return this.listaSistemaPagos;
  }
}
