package Actividad3;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenuFinal() {
        System.out.println("\n=== SISTEMA DE PEDIDOS (COMPLETO) ===");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Todos");
        System.out.println("3. Marcar Pedido como Completo");
        System.out.println("4. Mostrar por Estado");
        System.out.println("5. Ver Historial");
        System.out.println("6. Contar Pendientes");
        System.out.println("7. Salir");
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

    public String solicitarEstado() {
        System.out.print("Estado (Pendiente/Completo): ");
        return scanner.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos que mostrar.");
        } else {
            System.out.println("\nLista:");
            pedidos.forEach(p -> System.out.println("- " + p));
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
