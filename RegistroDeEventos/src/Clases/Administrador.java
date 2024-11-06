
package Clases;

public class Administrador extends Persona{
    public Administrador(String nombre, String apellido, String email, String genero, String fechaNacimiento) {
        super(nombre, apellido, email, genero, fechaNacimiento);
    }
    
    @Override
    public boolean autenticar(String credencial) {
        return this.email.equals(credencial);
    }
    
    public void crearEvento(Plataforma plataforma, Evento evento) {
        plataforma.agregarEventos(evento);
    }
    
    public void gestionarPrecios(Evento evento, double nuevoPrecio) {
        evento.setPrecio(nuevoPrecio);
    }
    
    public void gestionarUsuarios(Plataforma plataforma, Usuario usuario) {
        plataforma.gestionarUsuarios(usuario);
    }
    
    @Override
    public String toString() {
        return String.format("Administrador{nombre='%s', apellido='%s', email='%s'}",
            getNombre(), getApellido(), getEmail());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrador)) return false;
        Administrador that = (Administrador) o;
        return email.equals(that.email);
    }
    
    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
