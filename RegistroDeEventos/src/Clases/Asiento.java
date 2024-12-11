
package Clases;

import java.util.HashMap;
import java.util.Map;

public class Asiento {
    private String numero;
    private boolean ocupado;
    private String clase;
    private static final Map<String, Double> PRECIOS_ASIENTOS = new HashMap<>();

    static {
        PRECIOS_ASIENTOS.put("Platinum", 100.0);
        PRECIOS_ASIENTOS.put("VIP", 50.0);
        PRECIOS_ASIENTOS.put("General", 25.0);
    }
    
    public Asiento(String numero, String clase) { // Agrega el parámetro clase
        this.numero = numero;
        this.ocupado = false;
        this.clase = clase; // Inicializa el campo clase
    }

    public String getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public boolean isDesocupado() {
        return !ocupado;
    }

    public String getClase() { // Nuevo método para obtener la clase
        return clase;
    }

    public String getNumAsiento() {
        return this.numero;
    }
    
    public void desocupar() {
        if (ocupado) {
            ocupado = false;
            System.out.println("Asiento " + numero + " de clase " + clase + " desocupado."); 
        } else {
            System.out.println("El asiento ya estaba desocupado.");
        }
    }

    public void ocupar() {
        if (!ocupado) {
            ocupado = true;
            System.out.println("Asiento " + numero + " de clase " + clase + " ocupado.");
        } else {
            System.out.println("El asiento ya estaba ocupado.");
        }
    }
    
    public double getPrecio() {
        return PRECIOS_ASIENTOS.getOrDefault(this.clase, 0.0);
    }
}
