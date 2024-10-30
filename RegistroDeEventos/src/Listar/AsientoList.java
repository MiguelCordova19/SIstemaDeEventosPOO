
package Listar;

import Clases.Asiento;
import java.util.ArrayList;
import java.util.List;

public class AsientoList {
    private List<Asiento> asientos;

    public AsientoList() {
        this.asientos = new ArrayList<>();
    }

    public void agregarAsiento(String numero, boolean ocupado) {
        Asiento nuevoAsiento = new Asiento(numero, ocupado);
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
        asiento.ocupar();
    }

    public void desocuparAsiento(Asiento asiento) {
        asiento.desocupar();
    }

    public int getNumeroAsientos() {
        return asientos.size();
    }
}
