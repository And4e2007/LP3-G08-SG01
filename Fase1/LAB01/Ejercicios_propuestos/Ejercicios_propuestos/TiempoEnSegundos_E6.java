package Ejercicios_propuestos;

import java.util.Scanner;

public class TiempoEnSegundos_E6 {
	 // Funcion que convierte horas, minutos y segundos a segundos
    public static int convertirASegundos(int horas, int minutos, int segundos) {
        return (horas * 3600) + (minutos * 60) + segundos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada de datos
        System.out.print("Ingrese horas: ");
        int h = sc.nextInt();

        System.out.print("Ingrese minutos: ");
        int m = sc.nextInt();

        System.out.print("Ingrese segundos: ");
        int s = sc.nextInt();

        // Llamada a la funcion
        int total = convertirASegundos(h, m, s);

        // Salida
        System.out.println("El equivalente en segundos es: " + total);

        sc.close();
    }

}
