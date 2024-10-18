
package Clases;

public class Pago {
    private double monto;
    private String formato;
    
    public Pago(double monto, String formato){
        this.monto = monto;
        this.formato = formato;
    }
    
    public double obtenerMonto(){
        return monto;
    }
    
    public String obtenerFormato(){
        return formato;
    }
}
