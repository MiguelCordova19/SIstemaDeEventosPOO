
package Clases;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private List<Evento> eventos;
    private SistemaPago sistemaPago;
    private List<Usuario> usuarios;
    
    public Plataforma(SistemaPago sistemaPago) {
        this.eventos = new ArrayList<>();
        this.sistemaPago = sistemaPago;
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
    
    public boolean procesarPago(Pago pago){
        return sistemaPago.procesarPago(pago);
    }
}
