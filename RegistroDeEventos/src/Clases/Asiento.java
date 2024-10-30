
package Clases;

public class Asiento {
    private String numero;
    private boolean ocupado;
    private boolean desocupar;
    
    public Asiento(String numero, boolean ocupado){
        this.numero = numero;
        this.ocupado = ocupado;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public boolean isOcupado(){
        return ocupado;
    }
    
        public boolean isDesocupado() {
        return !ocupado;
    }
    
    public void desocupar() {
        if (ocupado) {
            ocupado = false;
            System.out.println("Asiento " + numero + " desocupado.");
        } else {
            System.out.println("El asiento ya estaba desocupado.");
        }
    }
    
    public void ocupar(){
        if (!ocupado){
            ocupado = true;
            System.out.println("Asiento " + numero + " ocupado.");
        } else {
            System.out.println("El asiento ya estaba ocupado.");
        }
    }
}
