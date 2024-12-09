
package Clases;

public class AsientoSeleccionado {
    private int numAsiento;
    private double precio;
    private String clase; // Nuevo campo para la clase

    public AsientoSeleccionado(int numAsiento, double precio, String clase) { // Agrega el parámetro clase
        this.numAsiento = numAsiento;
        this.precio = precio;
        this.clase = clase; // Inicializa el campo clase
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public double getPrecio() {
        return precio;
    }

    public String getClase() { // Nuevo método para obtener la clase
        return clase;
    }
}
