
package Clases;

import GUI.SistemaPago;
import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private List<Evento> eventos;
    private FormatoPago formatoPago;
    private List<Usuario> usuarios;
    
    public Plataforma(FormatoPago formatoPago) {
        this.eventos = new ArrayList<>();
        this.formatoPago = formatoPago;
        this.usuarios = new ArrayList<>();
    }
    
    public void buscarEventos(){
        System.out.println("Buscando eventos disponibles...");
    }
    
    public void agregarEventos(Evento evento){
        eventos.add(evento);
        System.out.println("Evento agregado: " + evento.getNombre());
    }
    
    public void gestionarUsuarios(Usuario usuario){
        usuarios.add(usuario);
        System.out.println("Usuarui gestionado: " + usuario.getNombre());
    }
    
}
