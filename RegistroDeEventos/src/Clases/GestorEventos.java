
package Clases;

import java.util.ArrayList;
import java.util.List;

public class GestorEventos {
    private static List<Evento> listaEventos;
    
    public GestorEventos() {
        listaEventos = new ArrayList<>();
        inicializarEventos();
    }
    
    private void inicializarEventos() {
        Evento festival = new Evento(
            "Festival de Colores",
            "Únete a la explosión de colores en el festival más vibrante del año.",
            25.00
        );
        
        Evento carrera = new Evento(
            "Carrera Nocturna de Neon",
            "Vive la adrenalina de una carrera nocturna iluminada por luces de neón.",
            20.00
        );
        
        Evento cine = new Evento(
            "Noche de Cine al Aire Libre",
            "Disfruta de una noche mágica viendo tus películas favoritas bajo las estrellas.",
            15.00
        );
        
        Evento concurso = new Evento(
            "Concurso de Talentos",
            "Si tienes un talento escondido o quieres mostrar tus habilidades, \"Showtime!\" es el lugar perfecto para brillar.",
            10.00
        );
        
        Evento laberinto = new Evento(
            "Escape Room",
            "¿Podrás resolver los acertijos y escapar a tiempo?",
            30.00
        );
        
        listaEventos.add(festival);
        listaEventos.add(carrera);
        listaEventos.add(cine);
        listaEventos.add(concurso);
        listaEventos.add(laberinto);
        
        // Agregar algunos asientos a cada evento
        for (Evento evento : listaEventos) {
            char[] filas = {'A', 'B', 'C', 'D', 'E'};
            for (char fila : filas) {
                for (int num = 1; num <= 10; num++) {
                    evento.agregarAsiento(new Asiento(String.format("%02d", num), false));
                }
            }
        }
    }
    
    public List<Evento> getListaEventos() {
        return listaEventos;
    }
    
    public Evento buscarEventoPorNombre(String nombre) {
        for (Evento evento : listaEventos) {
            if (evento.getNombre().equals(nombre)) {
                return evento;
            }
        }
        return null;
    }
}
