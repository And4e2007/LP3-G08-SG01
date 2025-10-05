package Ejercicios_2_y_3;

import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public void atacar(Jugador jugador) {
        Random rand = new Random();
        int daño = rand.nextInt(15) + 5; // Daño entre 5 y 20
        System.out.println(nombre + " (" + tipo + ") ataca a " + jugador.getNombre() + " causando " + daño + " de daño.");
        jugador.recibirDaño(daño);
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
        System.out.println(nombre + " recibe " + daño + " de daño. Salud restante: " + salud);
    }

    public String getNombre() { 
    	return nombre; 
   	}
    public int getSalud() { 
    	return salud; 
   	}
    public boolean estaVivo() { 
    	return salud > 0; 
    }
}
