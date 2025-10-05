package Ejercicio1;
import java.util.*;

public class VistaProducto {
	public void listar_productos(ArrayList<Producto> lista_productos) {
		if(lista_productos.isEmpty()) {
			System.out.println("No hay productos añadidos");
		}else {
			for(Producto p : lista_productos) {
				System.out.println(p.getNombre() + " - " + p.getPrecio());
			}
		}
	}
	
	public void historial_compras(HashMap<Integer, ArrayList<Producto>> historial){
		for (int contador : historial.keySet()) {
            System.out.println("Compra " + contador + ":");
            for (Producto p : historial.get(contador)) {
                System.out.println("  - " + p.getNombre() + "con costo " + p.getPrecio());
            }
        }
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}
}
