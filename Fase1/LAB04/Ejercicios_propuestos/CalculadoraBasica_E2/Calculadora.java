package CalculadoraBasica_E2;

public class Calculadora {

	public Calculadora() {}
	
	public int Suma(int a, int b) {
		return a + b;
	}
	
	public int Resta(int a, int b) {
	    if (a < b) {
	        throw new IllegalArgumentException("El minuendo no puede ser menor que el sustraendo");
	    }
	    return a - b;
	}
	
	public int Multiplicacion(int a, int b) {
		return a*b;
	}
	
	public int Division(int a, int b) throws DivisionPorCeroException {
		if(b==0) {
			throw new DivisionPorCeroException("Error: No se puede dividir entre cero.");
		}
		return a/b;
	}
}
