package Ejercicios_2_y_3;

import java.util.List;
import java.util.Random;

public class CombateModel {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private Random random = new Random();

    public CombateModel(Jugador jugador, List<Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
    }

    public Jugador getJugador() { return jugador; }
    public List<Enemigo> getEnemigos() { return enemigos; }

    public boolean todosEnemigosDerrotados() {
        for (Enemigo e : enemigos) {
            if (e.estaVivo()) return false;
        }
        return true;
    }

    public Enemigo enemigoAleatorio() {
        Enemigo e;
        do {
            e = enemigos.get(random.nextInt(enemigos.size()));
        } while (!e.estaVivo());
        return e;
    }
}
