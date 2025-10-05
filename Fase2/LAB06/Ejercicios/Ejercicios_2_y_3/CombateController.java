package Ejercicios_2_y_3;

import java.util.List;

public class CombateController {
    private CombateModel modelo;
    private CombateView vista;

    public CombateController(CombateModel modelo, CombateView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarCombate() {
        Jugador jugador = modelo.getJugador();
        List<Enemigo> enemigos = modelo.getEnemigos();

        vista.mostrarMensaje("¡Comienza el combate!");
        vista.mostrarEstado(jugador, enemigos);

        while (jugador.estaVivo() && !modelo.todosEnemigosDerrotados()) {
            Enemigo objetivo = modelo.enemigoAleatorio();
            jugador.atacar(objetivo);

            for (Enemigo e : enemigos) {
                if (e.estaVivo()) e.atacar(jugador);
            }

            vista.mostrarEstado(jugador, enemigos);
        }

        if (jugador.estaVivo()) {
            vista.mostrarMensaje("¡" + jugador.getNombre() + " ha ganado el combate!");
        } else {
            vista.mostrarMensaje("El jugador ha sido derrotado...");
        }
    }
}
