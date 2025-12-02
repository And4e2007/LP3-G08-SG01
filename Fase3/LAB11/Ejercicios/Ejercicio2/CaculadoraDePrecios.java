package Ejercicio2;

import java.util.List;

public class CaculadoraDePrecios {
	private EstrategiaDescuento estrategiaDes;
	
	public void setEstrategiaDes(EstrategiaDescuento estrategiaDes) {
		this.estrategiaDes = estrategiaDes;
	}
	
	public double calcularPrecio(List<Producto> productos) {
		return estrategiaDes.aplicarDescuento(productos);
	}
}
