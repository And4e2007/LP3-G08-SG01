package Ejercicios_2_y_3;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem(String nombre, int cantidad, String tipo, String descripcion) {
        Item nuevo = new Item(nombre, cantidad, tipo, descripcion);
        modelo.agregarItem(nuevo);
        vista.mostrarMensaje("Item agregado: " + nombre);
    }
    
    public void eliminarItem(Item item) {
    	boolean enc = modelo.eliminarItem(item);
    	if(enc) {
    		vista.mostrarMensaje("Item elimiado del inventario");
    	}else {
    		vista.mostrarMensaje("Item no encontrado en el inventario");
    	}
    }

    public Item buscarItem(String nombre) {
        return modelo.buscarItem(nombre);
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }
    
    public void mostrarDetalles(Item item) {
    	vista.mostrarDetallesItem(item);
    }
}
