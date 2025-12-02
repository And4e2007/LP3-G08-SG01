package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Notificacion {
private List<Usuario> usuarios = new ArrayList<>();
	
	public void attach(Usuario user) {
		usuarios.add(user);
	}
	
	public void detach (Usuario user) {
		usuarios.remove(user);
	}
	
	public void notificarUsuarios(String message) {
		for(Usuario user : usuarios) {
			user.notiEvento(message);
		}
	}
	
}
