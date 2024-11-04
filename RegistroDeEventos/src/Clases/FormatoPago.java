
package Clases;

public class FormatoPago {
    public double MontoPago;
    public String MetodoPago;
    
    public FormatoPago (double Montopago, String Metodopago){
        this.MontoPago = Montopago;
        this.MetodoPago = Metodopago;
    }

    public double getMontoPago() {
        return MontoPago;
    }

    public void setMontoPago(double MontoPago) {
        this.MontoPago = MontoPago;
    }

    public String getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(String MetodoPago) {
        this.MetodoPago = MetodoPago;
    }
    
}
