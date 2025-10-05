package Ejercicios_2_y_3;

import java.util.List;

public class InventarioView {
    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("=== INVENTARIO ===");
            for (Item i : items) {
                System.out.println(i);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Descripción: " + item.getDescripcion());
        } else {
            System.out.println("Item no encontrado.");
        }
    }
}
