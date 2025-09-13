package GestionNumerosNegativos_E3;

public class Numero {
	private double valor;
	
	public Numero() {}

	public double getValor() {
		if(valor < 0) {
			throw new IllegalArgumentException("El valor es negativo.");
		}
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}
