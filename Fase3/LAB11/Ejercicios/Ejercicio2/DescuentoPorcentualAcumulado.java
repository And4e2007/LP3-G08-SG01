package Ejercicio2;

import java.util.List;

public class DescuentoPorcentualAcumulado implements EstrategiaDescuento{
	@Override
	public double aplicarDescuento(List<Producto> productos) {
		double total = 0;

        for (Producto p : productos)
            total += p.getPrecio();

        // aplica solo si hay 3 o más productos
        if (productos.size() >= 3) {

            Producto menor = productos.get(0);

            for (Producto p : productos)
                if (p.getPrecio() < menor.getPrecio())
                    menor = p;

            // descuento del 50% al más barato
            total = total - (menor.getPrecio() * 50/100);
        }

        return total;
	}
}
