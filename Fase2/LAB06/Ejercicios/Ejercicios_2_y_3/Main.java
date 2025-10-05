package Ejercicios_2_y_3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear inventario
        InventarioModel inventario = new InventarioModel();
        InventarioView vistaInv = new InventarioView();
        InventarioController ctrlInv = new InventarioController(inventario, vistaInv);

        ctrlInv.agregarItem("Espada", 1, "Arma", "Espada básica de acero.");
        ctrlInv.agregarItem("Poción de Vida", 2, "Poción", "Restaura salud.");
        ctrlInv.verInventario();

        // Crear jugador y enemigos
        Jugador jugador = new Jugador("André", 100, 1, inventario);
        jugador.equiparItem("Espada");

        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new Enemigo("Goblin", 40, 1, "Tierra"));
        enemigos.add(new Enemigo("Orco", 60, 2, "Fuego"));

        // Crear modelo, vista y controlador del combate
        CombateModel modeloCombate = new CombateModel(jugador, enemigos);
        CombateView vistaCombate = new CombateView();
        CombateController ctrlCombate = new CombateController(modeloCombate, vistaCombate);

        // Iniciar combate
        ctrlCombate.iniciarCombate();
    }
}
