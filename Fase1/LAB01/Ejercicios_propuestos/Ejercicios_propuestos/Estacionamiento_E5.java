package Ejercicios_propuestos;

public class Estacionamiento_E5 {
	// Funcion que calcula el monto segun las horas
    public static double calcularCargo(int horas) {
        double monto;

        if (horas <= 1) {
        	monto = 3.00; // hasta una hora
        } else {
            monto = 3.00 + (horas - 3) * 0.50; // 3 soles + adicionales
        }

        // Aplica el limite maximo diario
        if (monto > 12.00) {
        	monto = 12.00;
        }

        return monto;
    }

    // Metodo principal para probar la funcion
    public static void main(String[] args) {
        int horas1 = 1;
        int horas2 = 5;
        int horas3 = 30;

        System.out.println("Monto por " + horas1 + " horas: " + calcularCargo(horas1));
        System.out.println("Monto por " + horas2 + " horas: " + calcularCargo(horas2));
        System.out.println("Monto por " + horas3 + " horas: " + calcularCargo(horas3));
    }
}
