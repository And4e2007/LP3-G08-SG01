package Strategy;

import java.util.List;

public class DescuentoPorcentual implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(List<Producto> productos) {
        if (productos.size() >= 2 && todosIguales(productos)) {
            double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
            return total * 0.7; // 30% de descuento
        }
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
    
    private boolean todosIguales(List<Producto> productos) {
        return productos.stream().allMatch(p -> p.getNombre().equals(productos.get(0).getNombre()));
    }
}
