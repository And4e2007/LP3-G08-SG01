package Actividad01;

import java.util.Date;

public class Main_1 {
    public static void main(String[] args) {
        Habitacion_1 h1 = new Habitacion_1(101, "suite", 200.0);
        Cliente_1 cliente = new Cliente_1("Ana", true);

        // Verificar disponibilidad
        System.out.println("Disponible: " + h1.verificarDisponibilidad(new Date(), new Date()));

        // Marcar reservada
        h1.marcarReservada();
        System.out.println("Disponible tras reserva: " + h1.verificarDisponibilidad(new Date(), new Date()));

        // Calcular precio
        CalculadorPrecio_1 calculador = new CalculadorPrecio_1();
        System.out.println("Precio final: $" + calculador.calcularPrecio(h1, cliente, new Date()));

        // Generar informe
        GeneradorInformeOcupacion_1 informe = new GeneradorInformeOcupacion_1();
        System.out.println(informe.generarInforme(h1));
    }
}
