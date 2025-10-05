package Actividad3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Pedido> historial = new ArrayList<>();

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void marcarCompleto(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre)) {
                p.setEstado("Completo");
                historial.add(p);
                return;
            }
        }
    }

    public List<Pedido> filtrarPorEstado(String estado) {
        return pedidos.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public int contarPendientes() {
        return (int) pedidos.stream().filter(p -> p.getEstado().equals("Pendiente")).count();
    }

    public List<Pedido> getHistorial() {
        return historial;
    }
}

