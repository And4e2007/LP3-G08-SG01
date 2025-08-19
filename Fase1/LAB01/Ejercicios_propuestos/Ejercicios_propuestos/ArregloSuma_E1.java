package Ejercicios_propuestos;

public class ArregloSuma_E1 {

	public static void main(String[] args) {
		int[] arreglo = {1, 2, 3, 4, 5};
		int suma = CalcularSumaArreglo(arreglo);
		System.out.println("La suma de elementos es: " + suma);
	}
	
	public static int  CalcularSumaArreglo(int [] arreglo) {
		int s = 0;
		for(int num : arreglo) {
			s+=num;
		}
		return s;
	}
}
