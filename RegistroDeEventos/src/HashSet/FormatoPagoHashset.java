
package HashSet;

import Clases.FormatoPago;
import java.util.HashSet;
import java.util.Set;

public class FormatoPagoHashset {
    Set<FormatoPago> FormatosPagos = new HashSet <>();

      public void agregar (FormatoPago f){
      FormatosPagos.add(f);
         
  }
  public void quitar (FormatoPago f){
       FormatosPagos.remove(f);
  }
  
  public Set <FormatoPago> listar(){
      return this.FormatosPagos;
  }
}
   
