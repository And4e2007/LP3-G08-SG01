package Ejercicio2;

import java.util.List;

public class DescuentoPorcentual implements EstrategiaDescuento{

	@Override
	public double aplicarDescuento(List<Producto> productos) {
		double total = 0;
        for (Producto p : productos)
            total += p.getPrecio();

        // verificar si hay al menos 2 productos iguales
        for (int i = 0; i < productos.size(); i++) {
            for (int j = i + 1; j < productos.size(); j++) {
                if (productos.get(i).getNombre().equals(productos.get(j).getNombre())) {
                    double totalIguales = productos.get(i).getPrecio() + productos.get(j).getPrecio();
                    total = total - totalIguales;
                    totalIguales = totalIguales*70/100;
                    total = total + totalIguales;
                }
            }
        }
        return total;
	}
}
