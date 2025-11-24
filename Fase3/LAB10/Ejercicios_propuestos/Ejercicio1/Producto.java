package Ejercicio1;

public class Producto {
	private String nombre;
	private Double precio;
	private int stock;
	private String categoria;
	public Producto(String nombre, Double precio, int stock, String categoria) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	 // Representación del objeto en texto
    @Override
    public String toString() {
        return "<html>Producto:<br>" +
               "Nombre: " + nombre + "<br>" +
               "Precio: S/ " + precio + "<br>" +
               "Stock: " + stock + "<br>" +
               "Categoría: " + categoria + "</html>";
    }
}
