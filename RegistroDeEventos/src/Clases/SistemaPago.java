
package Clases;

public class SistemaPago implements ProcesadorPago{
    
    @Override
    public boolean procesarPago(Pago pago){
        System.out.println("Procesando pago de: " + pago.obtenerMonto() + " en formato: " + pago.obtenerFormato());
        //Debo colocar algo para que procese el pago
        return true;
    }
}
