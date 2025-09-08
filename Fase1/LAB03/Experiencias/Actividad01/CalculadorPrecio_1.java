package Actividad01;

import java.util.Date;

public class CalculadorPrecio_1 {
    public double calcularPrecio(Habitacion_1 habitacion, Cliente_1 cliente, Date fecha) {
        double precioFinal = habitacion.getPrecioBase();

        switch (habitacion.getTipo().toLowerCase()) {
            case "doble":
                precioFinal *= 1.2;
                break;
            case "suite":
                precioFinal *= 1.5;
                break;
            default:
                break;
        }

        if (cliente != null && cliente.isVIP()) {
            precioFinal *= 0.9; // descuento 10%
        }

        return precioFinal;
    }
}