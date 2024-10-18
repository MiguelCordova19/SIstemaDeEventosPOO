
package Clases;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombre;
    private String descripcion;
    private double precio;
    private List<Asiento> asientosDisponibles;
    
    public Evento(String nombre, String descripcion, double precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.asientosDisponibles = new ArrayList<>();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public void seleccionarAsiento(Asiento asiento){
        if (!asiento.isOcupado()){
            asiento.ocupar();
            System.out.println("Asiento seleccionado: " + asiento.getNumero());
        } else {
            System.out.println("El asiento ya está ocupado.");
        }
    }
    
    public double obtenerPrecio(){
        return this.precio;
    }
    
    public void agregarAsiento(Asiento asiento){
        asientosDisponibles.add(asiento);
    }
}
