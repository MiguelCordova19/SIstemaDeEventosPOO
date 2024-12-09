
package HashSet;

import Clases.Asiento;
import Clases.Evento;
import java.util.HashSet;
import java.util.Set;
import ConexionDB.DatabaseManager;

public class EventoHashet {
     private static Set<Evento> listaEventos;
    
    public EventoHashet() {
        listaEventos = new HashSet<>();
        inicializarEventos();
        crearTablaEventos();
        insertarEventosEnBaseDeDatos();
    }
    
    private void crearTablaEventos() {
        String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS eventos (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "nombre VARCHAR(255) NOT NULL, " +
            "descripcion TEXT, " +
            "precio DECIMAL(10,2), " +
            "ambiente VARCHAR(100), " +
            "capacidad INT, " +
            "fecha VARCHAR(50), " +
            "lugar VARCHAR(255), " +
            "estado VARCHAR(50)" +
            ")";

        DatabaseManager.crearTabla(sqlCrearTabla);
    }
    
    public void insertarEventosEnBaseDeDatos() {
        String sqlInsert = "INSERT INTO eventos " +
        "(nombre, descripcion, precio, ambiente, capacidad, fecha, lugar, estado) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
        String sqlVerificar = "SELECT COUNT(*) FROM eventos WHERE nombre = ?";

        for (Evento evento : listaEventos) {
            // Primero verificamos si ya existe el evento
            boolean existe = DatabaseManager.existeRegistro(sqlVerificar, evento.getNombre());

            if (!existe) {
                boolean insertado = DatabaseManager.insertarRegistro(
                    sqlInsert, 
                    evento.getNombre(), 
                    evento.getDescripcion(), 
                    evento.getPrecio(), 
                    evento.getAmbiente(), 
                    evento.getCapacidad(), 
                    evento.getFecha(), 
                    evento.getLugar(), 
                    evento.getEstado()
                );

                if (insertado) {
                    System.out.println("Evento insertado: " + evento.getNombre());
                } else {
                    System.out.println("Error al insertar evento: " + evento.getNombre());
                }
            } else {
                System.out.println("Evento ya existe: " + evento.getNombre());
            }
        }
    }
    
    private void inicializarEventos() {
        Evento festival = new Evento(
            "Festival de Colores",
            "Únete a la explosión de colores en el festival más vibrante del año.",
            25.00,
            "Aire Libre",
            5000,
            "15/06/2024",
            "Parque Central",
            "Activo"
        );
        
        Evento carrera = new Evento(
            "Carrera Nocturna de Neon",
            "Vive la adrenalina de una carrera nocturna iluminada por luces de neón. 5km de diversión " +
            "con estaciones de música electrónica, zonas de foto y sorpresas luminosas en cada kilómetro.",
            20.00,
            "Urbano",
            2000,
            "22/07/2024",
            "Avenida Principal",
            "Próximo"
        );
        
        Evento cine = new Evento(
            "Noche de Cine al Aire Libre",
            "Disfruta de una noche mágica viendo tus películas favoritas bajo las estrellas. " +
            "Incluye área de picnic, servicio de snacks y mantas para el frío. Película: 'La La Land'.",
            15.00,
            "Aire Libre",
            300,
            "30/05/2024",
            "Jardín Botánico",
            "Disponible"
        );
        
        Evento concurso = new Evento(
            "Concurso de Talentos",
            "Si tienes un talento escondido o quieres mostrar tus habilidades, 'Showtime!' es el lugar perfecto para brillar. " +
            "Categorías: canto, baile, comedia y actos especiales. Premios en efectivo para los ganadores.",
            10.00,
            "Teatro",
            500,
            "08/06/2024",
            "Teatro Municipal",
            "Activo"
        );
        
        Evento laberinto = new Evento(
            "Escape Room",
            "¿Podrás resolver los acertijos y escapar a tiempo? Una experiencia inmersiva con temática de arqueología. " +
            "60 minutos para descubrir los secretos de la tumba perdida y encontrar la salida.",
            30.00,
            "Interior",
            50,
            "Todos los días",
            "Centro Comercial Plaza",
            "Disponible"
        );
        
        Evento conferenciaVirtual = new Evento(
            "Conferencia Tech Innovation 2024",
            "Sumérgete en el futuro de la tecnología con ponentes internacionales. Temas: IA, " +
            "Blockchain, Metaverso y Desarrollo Sostenible. Incluye sesiones de networking virtual " +
            "y acceso a contenido exclusivo por 30 días después del evento.",
            45.00,
            "Virtual",
            1000,
            "12/07/2024",
            "Plataforma Zoom",
            "Próximo"
        );

        Evento festivalMusica = new Evento(
            "Festival Virtual de Música Electrónica",
            "12 horas ininterrumpidas de música electrónica con DJs de talla mundial. " +
            "Experimenta sets en vivo, efectos visuales 3D, chat en vivo con otros asistentes " +
            "y la posibilidad de crear tu avatar personalizado para la pista de baile virtual.",
            35.00,
            "Virtual",
            3000,
            "28/06/2024",
            "Plataforma Metaverso",
            "Disponible"
        );
        
        listaEventos.add(festival);
        listaEventos.add(carrera);
        listaEventos.add(cine);
        listaEventos.add(concurso);
        listaEventos.add(laberinto);
        listaEventos.add(conferenciaVirtual);
        listaEventos.add(festivalMusica);
        
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
    
    public Set<Evento> getListaEventos() {
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
