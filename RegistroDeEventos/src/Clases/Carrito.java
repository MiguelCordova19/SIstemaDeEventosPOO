
package Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Carrito {
    private static Carrito instance;
    private HashMap<String, List<AsientoSeleccionado>> eventosAsientos;

    private Carrito() {
        eventosAsientos = new HashMap<>();
    }

    public static Carrito getInstance() {
        if (instance == null) {
            instance = new Carrito();
        }
        return instance;
    }

    public void agregarAsiento(String eventoId, AsientoSeleccionado asiento) {
        eventosAsientos.putIfAbsent(eventoId, new ArrayList<>());
        eventosAsientos.get(eventoId).add(asiento);
    }
    
    public void agregarEvento(String eventoId) {
        if (!eventosAsientos.containsKey(eventoId)) {
            eventosAsientos.put(eventoId, new ArrayList<>());
        }
    }

    public List<AsientoSeleccionado> getAsientosSeleccionados(String eventoId) {
        return eventosAsientos.getOrDefault(eventoId, new ArrayList<>());
    }

    public void limpiarCarrito(String eventoId) {
        if (eventosAsientos.containsKey(eventoId)) {
            eventosAsientos.get(eventoId).clear();
        }
    }
    
    public Set<String> getTodosLosEventos(){
        return eventosAsientos.keySet();
    }
    
    public void eliminarAsiento(String eventoId, AsientoSeleccionado asiento) {
        // Verifica si existe el evento
        if (eventosAsientos.containsKey(eventoId)) {
            // Obtiene la lista de asientos para ese evento y elimina el asiento específico
            List<AsientoSeleccionado> asientos = eventosAsientos.get(eventoId);
            asientos.remove(asiento);

            // Si la lista queda vacía, podrías opcionalmente eliminar el evento del HashMap
            if (asientos.isEmpty()) {
                eventosAsientos.remove(eventoId);
            }
        }
    }
}
