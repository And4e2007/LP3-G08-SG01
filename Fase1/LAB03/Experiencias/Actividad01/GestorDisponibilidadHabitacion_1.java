package Actividad01;

import java.util.Date;

public class GestorDisponibilidadHabitacion_1 {
    private Habitacion_1 habitacion;
    private boolean disponible;

    public GestorDisponibilidadHabitacion_1(Habitacion_1 habitacion) {
        this.habitacion = habitacion;
        this.disponible = true; // por defecto disponible
    }

    public boolean verificarDisponibilidad(Date fechaInicio, Date fechaFin) {
        // Lógica simplificada: solo revisamos flag de disponibilidad
        return disponible;
    }

    public void marcarReservada() {
        this.disponible = false;
    }

    public void marcarDisponible() {
        this.disponible = true;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
