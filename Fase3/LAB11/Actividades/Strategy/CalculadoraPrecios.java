package Strategy;
import java.util.List;

public class CalculadoraPrecios {
    private EstrategiaDescuento estrategia;
    
    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }
    
    public double calcularPrecioFinal(List<Producto> productos) {
        if (estrategia == null) {
            return productos.stream().mapToDouble(Producto::getPrecio).sum();
        }
        return estrategia.aplicarDescuento(productos);
    }
}