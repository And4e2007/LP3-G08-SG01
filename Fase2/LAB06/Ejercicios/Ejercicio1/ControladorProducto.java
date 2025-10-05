package Ejercicio1;

import java.util.*;

public class ControladorProducto {
	private ArrayList<Producto> productos;
	private ArrayList<Producto> carrito;
	private HashMap<Integer, ArrayList<Producto>> historial;
	private VistaProducto vista;
	private int contadorCompras = 1;
	
	public ControladorProducto(VistaProducto vista) {
		this.vista = vista;
		this.productos = new ArrayList<>();
		this.carrito = new ArrayList<>();
		this.historial = new HashMap<>();
	}
	
	public void agregar_producto(String p_nombre, double p_precio) {
		Producto nuevo_producto = new Producto(p_nombre, p_precio);
		productos.add(nuevo_producto);
		vista.printMessage("Producto " + nuevo_producto.getNombre() + " añadido con exito");
	}
	
	public void agregar_producto_carrito(String nameProducto) {
		boolean encontrado = false;
		for(Producto p : productos) {
			if(p.getNombre().equalsIgnoreCase(nameProducto)) {
				carrito.add(p);
				vista.printMessage("Producto " + p.getNombre() + " añadido con exito al carrito");
				encontrado = true;
				break;
			}
		}
		if(!encontrado) {
			vista.printMessage("Producto no existente en la tienda");
		}
	}
	
	public void eliminar_producto_carrito(String nameProducto) {
		boolean encontrado = false;
		for(int i=0; i<carrito.size(); i++) {
			if(carrito.get(i).getNombre().equalsIgnoreCase(nameProducto)) {
				vista.printMessage("Producto " + carrito.get(i).getNombre() + " eliminado con exito del carrito");
				carrito.remove(i);
				encontrado = true;
				break;
			}
		}
		if(!encontrado) {
			vista.printMessage("Producto no existente en el carrito");
		}
	}
	
	public void aplicar_descuento(String nameProducto, int descuento) {
		boolean encontrado = false;
		for(int i=0; i<productos.size(); i++) {
			if(productos.get(i).getNombre().equalsIgnoreCase(nameProducto)) {
				productos.get(i).setPrecio(productos.get(i).getPrecio() - (productos.get(i).getPrecio()*descuento/100));
				vista.printMessage("Producto " + productos.get(i).getNombre() + " con descuento aplicado");
				encontrado = true;
				break;
			}
		}
		if(!encontrado) {
			vista.printMessage("Producto no existente en la tienda");
		}
	}
	
	public void realizar_compra() {
		if(carrito.isEmpty()) {
			vista.printMessage("No puede comprar porque tu carrito esta vacio");
		}else {
			historial.put(contadorCompras, new ArrayList<>(carrito));
			carrito.clear();
			this.contadorCompras++;
			vista.printMessage("Compra realizada");
		}
	}
	
	public void calcular_envio(double distancia) {
		double metro = 0.003;
		double costo_envio = 0.0;
		costo_envio = metro * distancia;
		vista.printMessage("El costo de envio es: " + costo_envio);
	}
	
	public void mostrarProductos(){
		vista.printMessage("Productos en tienda: ");
		vista.listar_productos(productos);
	}
	
	public void mostrarProductosCarrito() {
		vista.printMessage("Productos en tu carrito: ");
		vista.listar_productos(carrito);
	}
	
	public void mostrarHistorialCompras() {
		vista.historial_compras(historial);
	}
}
