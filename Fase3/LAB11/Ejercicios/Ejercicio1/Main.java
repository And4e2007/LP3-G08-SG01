package Ejercicio1;

public class Main {

	public static void main(String[] args) {
		Notificacion noti = new Notificacion();
		
		Usuario user1 = new Usuario("André");
		Usuario user2 = new Usuario("Nicolas");
		Usuario user3 = new Usuario("Luis");
		
		noti.attach(user1);
		noti.attach(user2);
		noti.attach(user3);
		
		noti.notificarUsuarios("Promoción en pedidos de comidas");
	}

}
