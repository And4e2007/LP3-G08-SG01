package Ejercicio2;

import java.util.List;

public class DescuentoFijo implements EstrategiaDescuento{
	@Override
	public double aplicarDescuento(List<Producto> productos) {
		 double total = 0;
	        for (Producto p : productos)
	            total += p.getPrecio();

	        return total * 90/100;
	}
}
