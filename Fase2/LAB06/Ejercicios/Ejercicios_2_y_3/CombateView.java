package Ejercicios_2_y_3;

import java.util.List;

public class CombateView {
    public void mostrarEstado(Jugador jugador, List<Enemigo> enemigos) {
        System.out.println("\n=== ESTADO DEL COMBATE ===");
        System.out.println(jugador.getNombre() + " - Salud: " + jugador.getSalud());
        for (Enemigo e : enemigos) {
            System.out.println(e.getNombre() + " - Salud: " + e.getSalud());
        }
        System.out.println("===========================\n");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
