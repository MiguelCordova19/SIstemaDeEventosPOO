
package Clases;

public class EventoManager {
    private static EventoSeleccionado eventoSeleccionado;

    public static void setEventoSeleccionado(EventoSeleccionado evento) {
        EventoManager.eventoSeleccionado = evento;
    }

    public static EventoSeleccionado getEventoSeleccionado() {
        return EventoManager.eventoSeleccionado;
    }
}
