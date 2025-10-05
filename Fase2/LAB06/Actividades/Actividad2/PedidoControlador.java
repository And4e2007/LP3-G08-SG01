package Actividad2;

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
                case "1": agregarPedido(); break;
                case "2": mostrarPedidos(); break;
                case "3": eliminarPedido(); break;
                case "4": buscarPedido(); break;
                case "5": contarPedidos(); break;
                case "6": vista.mostrarMensaje("Saliendo..."); break;
                default: vista.mostrarMensaje("Opción no válida.");
            }
        } while (!opcion.equals("6"));
        vista.cerrar();
    }

    private void agregarPedido() {
        String nombre = vista.solicitarNombrePlato();
        String tipo = vista.solicitarTipo();
        modelo.agregarPedido(new Pedido(nombre, tipo));
        vista.mostrarMensaje("Pedido agregado: " + nombre);
    }

    private void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
    }

    private void eliminarPedido() {
        String nombre = vista.solicitarNombrePlato();
        if (modelo.eliminarPedido(nombre))
            vista.mostrarMensaje("Pedido eliminado.");
        else
            vista.mostrarMensaje("No se encontró el pedido.");
    }

    private void buscarPedido() {
        String nombre = vista.solicitarNombrePlato();
        Pedido pedido = modelo.buscarPedido(nombre);
        if (pedido != null)
            vista.mostrarMensaje("Encontrado: " + pedido);
        else
            vista.mostrarMensaje("Pedido no encontrado.");
    }

    private void contarPedidos() {
        vista.mostrarMensaje("Total de pedidos: " + modelo.contarPedidos());
    }
}


