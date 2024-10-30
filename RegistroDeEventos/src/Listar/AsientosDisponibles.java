
package Listar;

import Clases.Asiento;
import java.util.ArrayList;
import java.util.List;

public class AsientosDisponibles {
    private List<Asiento> asientosDisponibles;

    public AsientosDisponibles() {
        this.asientosDisponibles = new ArrayList<>();
    }

    public void agregarAsiento(Asiento asiento) {
        asientosDisponibles.add(asiento);
    }

    public List<Asiento> getAsientosDisponibles() {
        return new ArrayList<>(asientosDisponibles);
    }

    public void ocuparAsiento(Asiento asiento) {
        asiento.ocupar();
    }

    public void desocuparAsiento(Asiento asiento) {
        asiento.desocupar();
    }

    public int getNumeroAsientos() {
        return asientosDisponibles.size();
    }
}
