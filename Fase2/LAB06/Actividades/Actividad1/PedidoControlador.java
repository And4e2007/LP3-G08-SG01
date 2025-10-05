package Actividad1;

import java.util.List;

public class PedidoControlador {
 private PedidoModelo modelo;
 private PedidoVista vista;

 public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
     this.modelo = modelo;
     this.vista = vista;
 }

 public void iniciar() {
     String opcion;
     do {
         vista.mostrarMenu();
         opcion = vista.leerOpcion();
         switch (opcion) {
             case "1":
                 agregarPedido();
                 break;
             case "2":
                 mostrarPedidos();
                 break;
             case "3":
                 vista.mostrarMensaje("Saliendo... ¡Hasta luego!");
                 break;
             default:
                 vista.mostrarMensaje("Opción no válida. Intenta de nuevo.");
         }
     } while (!opcion.equals("3"));
     vista.cerrar();
 }

 private void agregarPedido() {
     String nombre = vista.solicitarNombrePlato();
     if (nombre.isEmpty()) {
         vista.mostrarMensaje("El nombre del plato no puede estar vacío.");
         return;
     }
     Pedido pedido = new Pedido(nombre);
     modelo.agregarPedido(pedido);
     vista.mostrarMensaje("Pedido agregado: " + nombre);
 }

 private void mostrarPedidos() {
     List<Pedido> lista = modelo.getPedidos();
     vista.mostrarPedidos(lista);
 }
}

