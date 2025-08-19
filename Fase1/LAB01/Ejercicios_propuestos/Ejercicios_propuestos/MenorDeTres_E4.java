package Ejercicios_propuestos;

public class MenorDeTres_E4 {

	//Funcion que devuelve el menor de tres numeros
	public static double menor(double a, double b, double c) {
		double menor = a;  // asumimos que el primero es el menor
		if (b < menor) {
			menor = b;
		}
        if (c < menor) {
        	menor = c;
        }
        return menor;
    }
	
	// Metodo para probar la función
	public static void main(String[] args) {
		double x = 4.5, y = 5.8, z = 7.3;
        System.out.println("El menor de los tres números es: " + menor(x, y, z));
    }
}
