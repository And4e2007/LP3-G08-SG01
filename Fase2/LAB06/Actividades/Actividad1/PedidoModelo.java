package Actividad1;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
 private List<Pedido> pedidos;

 public PedidoModelo() {
     this.pedidos = new ArrayList<>();
 }

 // Agregar un pedido
 public void agregarPedido(Pedido pedido) {
     pedidos.add(pedido);
 }

 // Obtener lista de pedidos
 public List<Pedido> getPedidos() {
     return pedidos;
 }
}
