package Actividad01;

public class EjemploCoche {

	public static void main(String[] args) {
		// Crear objetos coche
        Coche cocheDeportivo = new Coche("Ferrari", "488", 2015, 250000);
        Coche cocheTodoTerreno = new Coche("Toyota", "Land Cruiser", 2005, 35000);

        // Verificar precios iniciales
        System.out.println("Precio original del " + cocheDeportivo.getMarca() + ": $" + cocheDeportivo.getPrecio());
        System.out.println("Precio original del " + cocheTodoTerreno.getMarca() + ": $" + cocheTodoTerreno.getPrecio());

        // Intentar aplicar descuentos
        if (cocheDeportivo.aplicarDescuento(10)) {
            System.out.println("Descuento aplicado al deportivo. Nuevo precio: $" + cocheDeportivo.getPrecio());
        } else {
            System.out.println("No se aplicó descuento al deportivo.");
        }

        if (cocheTodoTerreno.aplicarDescuento(10)) {
            System.out.println("Descuento aplicado al todoterreno. Nuevo precio: $" + cocheTodoTerreno.getPrecio());
        } else {
            System.out.println("No se aplicó descuento al todoterreno.");
        }

        System.out.println();

        // Encender coches
        cocheDeportivo.encender();
        cocheTodoTerreno.encender();

        // Acelerar y frenar
        cocheDeportivo.acelerar();
        cocheDeportivo.frenar();

        cocheTodoTerreno.acelerar();
        cocheTodoTerreno.frenar();

        // Apagar coches
        cocheDeportivo.apagar();
        cocheTodoTerreno.apagar();
	}
}
