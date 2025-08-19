package Ejercicios_propuestos;

import java.util.Scanner;

public class ArregloUnidimensional_E2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arreglo = new int[10];
		int copia = 0;
		int num = 0;
		System.out.print("Ingresa un numero positivo: ");
		copia = scanner.nextInt();
		arreglo[0] = copia;

		for(int i = 1; i<arreglo.length; i++) {
			System.out.print("Ingresa un número mayor al anterior: ");
			num = scanner.nextInt();
			while(copia>=num) {
				System.out.print("El número debe de ser mayor: ");
				num = scanner.nextInt();
			}
			copia = num;
			arreglo[i] = copia;
		}
		scanner.close();
		System.out.print("El arreglo final es: ");
		for (int i = 0; i < arreglo.length; i++){ 
			System.out.print(arreglo[i] + " "); 
		}
	}
}
