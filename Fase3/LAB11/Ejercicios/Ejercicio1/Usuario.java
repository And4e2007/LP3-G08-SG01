package Ejercicio1;

public class Usuario {
	private String nombre;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
	}
	
	public void notiEvento(String message) {
		System.out.println(nombre + " recibio: " + message);
	}
}
