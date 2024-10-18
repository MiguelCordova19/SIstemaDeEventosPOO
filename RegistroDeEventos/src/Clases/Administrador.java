
package Clases;

public class Administrador extends Persona{
    public Administrador(String nombre, String email){
        super(nombre, email);
    }
    
    public void crearEvento(Plataforma plataforma, Evento evento){
        plataforma.agregarEventos(evento);
    }
    
    public void gestionarPrecios(Evento evento, double nuevoPrecio){
        evento.setPrecio(nuevoPrecio);
    }
    
    public void gestionarUsuarios(Plataforma plataforma, Usuario usuario){
        plataforma.gestionarUsuarios(usuario);
    }
}
