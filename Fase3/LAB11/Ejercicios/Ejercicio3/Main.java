package Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ReproductorMusica player = new ReproductorMusica();
        Command play = new PlayCommand(player);
        Command pause = new PauseCommand(player);

        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("\n------ MENU -------");
            System.out.println("1. Reproducir");
            System.out.println("2. Pausar");
            System.out.println("3. Salir");
            System.out.print("Elige: ");
            String opcion = sc.nextLine();

            if (opcion.equals("1")) {
                remote.setCommand(play);
                remote.pressButton();

            } else if (opcion.equals("2")) {
                remote.setCommand(pause);
                remote.pressButton();

            } else if (opcion.equals("3")) {
                System.out.println("Saliendo del programa...");
                break;

            } else {
                System.out.println("⚠ Opción no válida.");
            }
        }

        sc.close();
    }
}
