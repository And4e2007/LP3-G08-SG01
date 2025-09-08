package Actividad01;

public class GeneradorInformeOcupacion_1 {
    public String generarInforme(Habitacion_1 habitacion) {
        return "Habitación " + habitacion.getNumero() +
               " (" + habitacion.getTipo() + ") - " +
               (habitacion.getGestorDisponibilidad().isDisponible() ? "Disponible" : "Reservada") +
               " - Precio base: $" + habitacion.getPrecioBase();
    }
}
