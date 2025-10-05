package Actividad2;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE PEDIDOS ===");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Buscar Pedido");
        System.out.println("5. Contar Pedidos");
        System.out.println("6. Salir");
        System.out.print("Opción: ");
    }

    public String solicitarNombrePlato() {
        System.out.print("Nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipo() {
        System.out.print("Tipo del plato: ");
        return scanner.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            System.out.println("\nLista de Pedidos:");
            for (Pedido p : pedidos) {
                System.out.println("- " + p);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerOpcion() {
        return scanner.nextLine();
    }

    public void cerrar() {
        scanner.close();
    }
}
