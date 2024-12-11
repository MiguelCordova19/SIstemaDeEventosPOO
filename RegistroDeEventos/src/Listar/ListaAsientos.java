
package Listar;

import Clases.Asiento;
import Clases.AsientoGeneral;
import Clases.AsientoPlatinum;
import Clases.AsientoVIP;
import java.util.ArrayList;
import java.util.List;

public class ListaAsientos {
    private List<Asiento> asientos;

    public ListaAsientos() {
        this.asientos = new ArrayList<>();
    }

    public void agregarAsiento(String numero, String clase) {
    Asiento nuevoAsiento;
    switch (clase) {
        case "Platinum":
            nuevoAsiento = new AsientoPlatinum(numero);
            break;
        case "VIP":
            nuevoAsiento = new AsientoVIP(numero);
            break;
        case "General":
            nuevoAsiento = new AsientoGeneral(numero);
            break;
        default:
            nuevoAsiento = new Asiento(numero, clase);
            break;
    }
    asientos.add(nuevoAsiento);
}

    public List<Asiento> getAsientosDisponibles() {
        List<Asiento> disponibles = new ArrayList<>();
        for (Asiento asiento : asientos) {
            if (asiento.isDesocupado()) {
                disponibles.add(asiento);
            }
        }
        return disponibles;
    }

    public void ocuparAsiento(Asiento asiento) {
        if (asiento instanceof Asiento) {
        asiento.ocupar();
        } else {
            System.out.println("El asiento no es del tipo Asiento.");
        }
    }

    public void desocuparAsiento(Asiento asiento) {
        if (asiento instanceof Asiento) {
        asiento.desocupar();
        } else {
            System.out.println("El asiento no es del tipo Asiento.");
        }
    }

    public int getNumeroAsientos() {
        return asientos.size();
    }
}
