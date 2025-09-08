package Actividad01;

import java.util.Date;

public class Habitacion_1 {
    private int numero;
    private String tipo; // individual, doble, suite
    private double precioBase;
    private GestorDisponibilidadHabitacion_1 gestorDisponibilidad;

    public Habitacion_1(int numero, String tipo, double precioBase) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion_1(this);
    }

    // Métodos delegados a GestorDisponibilidad 
    public boolean verificarDisponibilidad(Date fechaInicio, Date fechaFin) {
        return gestorDisponibilidad.verificarDisponibilidad(fechaInicio, fechaFin);
    }

    public void marcarReservada() {
        gestorDisponibilidad.marcarReservada();
    }

    public void marcarDisponible() {
        gestorDisponibilidad.marcarDisponible();
    }

    //  Getters 
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public GestorDisponibilidadHabitacion_1 getGestorDisponibilidad() {
        return gestorDisponibilidad;
    }
}
