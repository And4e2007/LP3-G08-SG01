package Strategy;

import java.util.List;

public class DescuentoPorcentualAcumulado implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(List<Producto> productos) {
        if (productos.size() >= 3) {
            double precioMasBajo = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .min()
                .orElse(0);
            double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
            return total - (precioMasBajo * 0.5); // 50% de descuento en el más barato
        }
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}