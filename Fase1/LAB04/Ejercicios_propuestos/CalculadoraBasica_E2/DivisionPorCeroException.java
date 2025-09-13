package CalculadoraBasica_E2;

public class DivisionPorCeroException extends Exception{
	public DivisionPorCeroException() {}
	
	public DivisionPorCeroException(String message) {
		super(message);
	}
}
