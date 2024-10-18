
package Clases;

public class Asiento {
    private String numero;
    private boolean ocupado;
    
    public Asiento(String numero){
        this.numero = numero;
        this.ocupado = false;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public boolean isOcupado(){
        return ocupado;
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
