
package Clases;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String genero;
    protected String fechaNacimiento;
    
    public Persona(String nombre, String apellido, String email, String genero, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    // Método abstracto que las clases hijas deben implementar
    public abstract boolean autenticar(String credencial);
}
