package Strategy;

import java.util.*;

public class TestStrategy {
    private static Scanner scanner = new Scanner(System.in);
    private static CalculadoraPrecios calculadora = new CalculadoraPrecios();
    private static List<Producto> carrito = new ArrayList<>();
    
    public static void main(String[] args) {
        int opcion;
        
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    mostrarCarrito();
                    break;
                case 3:
                    aplicarEstrategia();
                    break;
                case 4:
                    vaciarCarrito();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE CÁLCULO DE PRECIOS ===");
        System.out.println("1. Agregar producto al carrito");
        System.out.println("2. Mostrar carrito");
        System.out.println("3. Aplicar estrategia de descuento");
        System.out.println("4. Vaciar carrito");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private static void agregarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        
        carrito.add(new Producto(nombre, precio));
        System.out.println("Producto agregado al carrito.");
    }
    
    private static void mostrarCarrito() {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        
        System.out.println("\n=== CARRITO DE COMPRAS ===");
        double total = 0;
        for (int i = 0; i < carrito.size(); i++) {
            Producto p = carrito.get(i);
            System.out.println((i + 1) + ". " + p);
            total += p.getPrecio();
        }
        System.out.println("Total sin descuento: $" + total);
    }
    
    private static void aplicarEstrategia() {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío. Agregue productos primero.");
            return;
        }
        
        System.out.println("\n=== ESTRATEGIAS DE DESCUENTO ===");
        System.out.println("1. Sin descuento");
        System.out.println("2. Descuento fijo (10%)");
        System.out.println("3. Descuento porcentual (30% para 2 productos iguales)");
        System.out.println("4. Descuento porcentual acumulado (50% en producto más barato para 3+ productos)");
        System.out.print("Seleccione estrategia: ");
        
        int estrategia = scanner.nextInt();
        scanner.nextLine();
        
        switch (estrategia) {
            case 1:
                calculadora.setEstrategia(new SinDescuento());
                break;
            case 2:
                calculadora.setEstrategia(new DescuentoFijo());
                break;
            case 3:
                calculadora.setEstrategia(new DescuentoPorcentual());
                break;
            case 4:
                calculadora.setEstrategia(new DescuentoPorcentualAcumulado());
                break;
            default:
                System.out.println("Estrategia inválida");
                return;
        }
        
        double precioFinal = calculadora.calcularPrecioFinal(carrito);
        double totalSinDescuento = carrito.stream().mapToDouble(Producto::getPrecio).sum();
        
        System.out.println("\n=== RESULTADO ===");
        System.out.println("Total sin descuento: $" + totalSinDescuento);
        System.out.println("Total con descuento: $" + precioFinal);
        System.out.println("Ahorro: $" + (totalSinDescuento - precioFinal));
    }
    
    private static void vaciarCarrito() {
        carrito.clear();
        System.out.println("Carrito vaciado.");
    }
}
