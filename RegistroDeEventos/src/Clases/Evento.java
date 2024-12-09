
package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Evento {
    private String nombre;
    private String descripcion;
    private double precio;
    private String ambiente;
    private int capacidad;
    private String fecha;
    private String lugar;
    private String estado;
    private List<Asiento> asientosDisponibles;
    
    // Constructor original para mantener compatibilidad con código existente
    public Evento(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.asientosDisponibles = new ArrayList<>();
    }
    
    // Nuevo constructor con todos los campos
    public Evento(String nombre, String descripcion, double precio, 
                 String ambiente, int capacidad, String fecha, 
                 String lugar, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.ambiente = ambiente;
        this.capacidad = capacidad;
        this.fecha = fecha;
        this.lugar = lugar;
        this.estado = estado;
        this.asientosDisponibles = new ArrayList<>();
    }
    
    // Getters originales
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getPrecio() {
        return this.precio;
    }
    
    // Nuevos getters
    public String getAmbiente() {
        return ambiente;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public String getLugar() {
        return lugar;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public List<Asiento> getAsientosDisponibles() {
        return asientosDisponibles;
    }
    
    // Setters
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    // Métodos para manejar asientos
    public void seleccionarAsiento(Asiento asiento) {
        if (!asiento.isOcupado()) {
            asiento.ocupar();
            System.out.println("Asiento seleccionado: " + asiento.getNumero());
        } else {
            System.out.println("El asiento ya está ocupado.");
        }
    }
    
    public void agregarAsiento(Asiento asiento) {
        asientosDisponibles.add(asiento);
    }
    
    // Métodos necesarios para HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return nombre.equals(evento.nombre);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    
    // Método toString para facilitar la depuración
    @Override
    public String toString() {
        return "Evento{" +
               "nombre='" + nombre + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", precio=" + precio +
               ", ambiente='" + ambiente + '\'' +
               ", capacidad=" + capacidad +
               ", fecha='" + fecha + '\'' +
               ", lugar='" + lugar + '\'' +
               ", estado='" + estado + '\'' +
               '}';
    }
}
