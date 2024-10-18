
package Clases;

public class Usuario extends Persona{
    private String clave;
    
    public Usuario(String nombre, String email, String clave){
        super(nombre, email);
        this.clave = clave;
    }
    
    public void buscarEvento(Plataforma plataforma){
        plataforma.buscarEventos();
    }
    
    public void seleccionarAsiento(Evento evento, Asiento asiento){
        evento.seleccionarAsiento(asiento);
    }
    
    public void realizarPago(Plataforma plataforma, Pago pago){
        plataforma.procesarPago(pago);
    }
}
