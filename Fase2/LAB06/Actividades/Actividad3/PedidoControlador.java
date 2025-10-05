package Actividad3;

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
            vista.mostrarMenuFinal();
            opcion = vista.leerOpcion();
            switch (opcion) {
                case "1": agregarPedido(); break;
                case "2": mostrarPedidos(); break;
                case "3": marcarCompleto(); break;
                case "4": mostrarPorEstado(); break;
                case "5": mostrarHistorial(); break;
                case "6": contarPendientes(); break;
                case "7": vista.mostrarMensaje("Saliendo..."); break;
                default: vista.mostrarMensaje("Opción no válida.");
            }
        } while (!opcion.equals("7"));
        vista.cerrar();
    }

    private void agregarPedido() {
        String nombre = vista.solicitarNombrePlato();
        String tipo = vista.solicitarTipo();
        modelo.agregarPedido(new Pedido(nombre, tipo));
        vista.mostrarMensaje("Pedido agregado.");
    }

    private void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
    }

    private void marcarCompleto() {
        String nombre = vista.solicitarNombrePlato();
        modelo.marcarCompleto(nombre);
        vista.mostrarMensaje("Pedido marcado como completo.");
    }

    private void mostrarPorEstado() {
        String estado = vista.solicitarEstado();
        List<Pedido> filtrados = modelo.filtrarPorEstado(estado);
        vista.mostrarPedidos(filtrados);
    }

    private void mostrarHistorial() {
        vista.mostrarPedidos(modelo.getHistorial());
    }

    private void contarPendientes() {
        vista.mostrarMensaje("Pedidos pendientes: " + modelo.contarPendientes());
    }
}


