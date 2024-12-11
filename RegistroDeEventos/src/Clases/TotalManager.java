
package Clases;

import java.util.ArrayList;
import java.util.List;

public class TotalManager {
    private List<TotalObserver> observers = new ArrayList<>();
    private double total;
    
    public void registrarObservador(TotalObserver observer){
        observers.add(observer);
    }
    
    public void desregistrarObservador(TotalObserver observer){
        observers.remove(observer);
    }
    
    public void actualizarTotal(double nuevoTotal){
        this.total = nuevoTotal;
        notificarObservadores();
    }
    
    private void notificarObservadores(){
        for (TotalObserver observer : observers){
            observer.actualizarTotal(total);
        }
    }
    
    public double getTotal(){
        return total;
    }
}
