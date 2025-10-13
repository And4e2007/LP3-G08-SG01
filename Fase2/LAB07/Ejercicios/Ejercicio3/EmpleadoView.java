package Ejercicio3;
import java.util.Scanner;
import java.util.Map;

public class EmpleadoView {
	private Scanner sc = new Scanner(System.in);
	
	public int mostrarMenu() {
		System.out.println("\n===== GESTOR DE EMPLEADOS =====");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar empleado por su número");
        System.out.println("4. Eliminar empleado por su número");
        System.out.println("5. Salir del programa");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
	}
	
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	public int pedirNumero() {
		System.out.print("Ingrese el número del empleado: ");
        int numero = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        return numero;
	}

	public String pedirNombre() {
        System.out.print("Ingrese nombre del empleado: ");
        String nombre = sc.nextLine();
        return nombre;
	}

	public double pedirSalario() {
        System.out.print("Ingrese salario del empleado: ");
        double salario = sc.nextDouble();
        return salario;
	}
	
	public void mostrarEmpleados(Map<Integer, Empleado> empleados) {
		System.out.println("\n--- LISTA DE EMPLEADOS ---");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados para mostrar.");
            return;
        }
        System.out.println(String.format("%-15s | %-15s | %-7s", "Numero", "Nombre", "Salario"));
        System.out.println("----------------------------------------------------------");
        for (Empleado e : empleados.values()) {
            System.out.println(String.format("%-15d | %-15s | %-7.2f", e.getNumero(), e.getNombre(), e.getSueldo()));
        }
        System.out.println("----------------------------------------------------------");

	}
}
