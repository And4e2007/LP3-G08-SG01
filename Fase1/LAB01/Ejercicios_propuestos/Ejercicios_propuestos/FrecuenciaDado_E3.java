package Ejercicios_propuestos;

import java.util.Random;

public class FrecuenciaDado_E3 {

	public static void main(String[] args) {
		int[] frecuencias = new int[6];
		Random random = new Random();
		
		int lanzamientos = 20000;
		for(int i = 0; i<lanzamientos; i++) {
			int cara = random.nextInt(6);
			frecuencias[cara]++;
		}
		
		for(int i = 0; i<frecuencias.length; i++) {
			System.out.println("Cara " + (i+1) + ": " + frecuencias[i] + " veces.");
		}
	}

}
