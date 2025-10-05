package Ejercicio1;

public class Main {
	 public static void main(String[] args) {
		 VistaProducto vista = new VistaProducto();
		 ControladorProducto control = new ControladorProducto(vista);
		 control.agregar_producto("Oreo", 2);
		 control.agregar_producto("Inka Cola", 3.5);
		 control.agregar_producto_carrito("Oreo");
		 control.aplicar_descuento("Oreo", 10);
		 control.aplicar_descuento("Inka Cola", 5);
		 control.aplicar_descuento("Morocha", 5);
		 control.mostrarProductosCarrito();
		 control.mostrarProductos();
		 control.eliminar_producto_carrito("Inka Cola");
		 control.eliminar_producto_carrito("Oreo");
		 control.mostrarProductosCarrito();
		 control.calcular_envio(1000);
		 control.realizar_compra();
		 control.agregar_producto_carrito("Oreo");
		 control.realizar_compra();
		 control.mostrarHistorialCompras();
	 }
}
