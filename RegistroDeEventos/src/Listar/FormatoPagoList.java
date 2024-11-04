
package Listar;

import Clases.FormatoPago;
import java.util.ArrayList;
import java.util.List;

public class FormatoPagoList {
  List<FormatoPago> listaFormatosPagos = new ArrayList<>();  
  public void agregar (FormatoPago f){
      listaFormatosPagos.add(f) ;
  }
  public void quitar (FormatoPago f){
       listaFormatosPagos.remove(f);
  }
  public FormatoPago obtener (int pag){
      return  listaFormatosPagos.get(pag);
  }
  public List <FormatoPago> listar(){
      return this.listaFormatosPagos;
  }
}  

