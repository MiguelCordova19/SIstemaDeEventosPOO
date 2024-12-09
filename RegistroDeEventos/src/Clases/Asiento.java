
package Clases;

public class Asiento {
    private String numero;
    private boolean ocupado;
    private boolean desocupar;
    private String clase; // Nuevo campo para el tipo de clase

    public Asiento(String numero, boolean ocupado, String clase) { // Agrega el parámetro clase
        this.numero = numero;
        this.ocupado = ocupado;
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

    public void desocupar() {
        if (ocupado) {
            ocupado = false;
            System.out.println("Asiento " + numero + " de clase " + clase + " desocupado."); // Agrega la clase
        } else {
            System.out.println("El asiento ya estaba desocupado.");
        }
    }

    public void ocupar() {
        if (!ocupado) {
            ocupado = true;
            System.out.println("Asiento " + numero + " de clase " + clase + " ocupado."); // Agrega la clase
        } else {
            System.out.println("El asiento ya estaba ocupado.");
        }
    }
}
