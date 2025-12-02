package Observer;
import java.util.ArrayList;
import java.util.List;

public class SistemaNotificaciones implements Subject {
    private List<Observer> observers;
    private String ultimaNotificacion;
    
    public SistemaNotificaciones() {
        this.observers = new ArrayList<>();
    }
    
    public void nuevaPromocion(String promocion) {
        this.ultimaNotificacion = "Nueva promoción: " + promocion;
        notificarObservers();
    }
    
    public void actualizacionProducto(String producto) {
        this.ultimaNotificacion = "Actualización de producto: " + producto;
        notificarObservers();
    }
    
    @Override
    public void registrarObserver(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.update(ultimaNotificacion);
        }
    }
}