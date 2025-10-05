package Actividad1;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
 private Scanner scanner;

 public PedidoVista() {
     scanner = new Scanner(System.in);
 }

 public void mostrarMenu() {
     System.out.println("\n=== Sistema de Pedidos (MVC) ===");
     System.out.println("1. Agregar Pedido");
     System.out.println("2. Mostrar Pedidos");
     System.out.println("3. Salir");
     System.out.print("Selecciona una opción: ");
 }

 public String solicitarNombrePlato() {
     System.out.print("Nombre del plato: ");
     return scanner.nextLine().trim();
 }

 public void mostrarPedidos(List<Pedido> pedidos) {
     if (pedidos.isEmpty()) {
         System.out.println("No hay pedidos en la lista.");
     } else {
         System.out.println("\nLista de Pedidos:");
         int i = 1;
         for (Pedido p : pedidos) {
             System.out.println(i + ". " + p.getNombrePlato());
             i++;
         }
     }
 }

 public void mostrarMensaje(String mensaje) {
     System.out.println(mensaje);
 }

 public String leerOpcion() {
     return scanner.nextLine().trim();
 }

 public void cerrar() {
     scanner.close();
 }
}
