
package Listar;

import Clases.SistemaPago;
import java.util.ArrayList;
import java.util.List;

public class SistemaPagoList {
    List<SistemaPago> listaSistemaPagos = new ArrayList<>();  
  public void agregar (SistemaPago p){
      listaSistemaPagos.add(p);
  }
  public void quitar (SistemaPago p){
       listaSistemaPagos.remove(p);
  }
  public SistemaPago obtener (int pag){
      return  listaSistemaPagos.get(pag);
  }
  public List <SistemaPago> listar(){
      return this.listaSistemaPagos;
  }
}
