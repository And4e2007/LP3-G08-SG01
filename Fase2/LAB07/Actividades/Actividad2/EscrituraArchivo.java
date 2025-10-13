package Actividad2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscrituraArchivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta = "datos.txt";

        System.out.println("Escriba texto para guardar en el archivo (escriba 'fin' para terminar):");

        try (FileWriter fw = new FileWriter(ruta, true);
             PrintWriter pw = new PrintWriter(fw)) {

            while (true) {
                String linea = sc.nextLine();
                if (linea.equalsIgnoreCase("fin")) break;
                pw.println(linea);
            }

            System.out.println("Datos guardados correctamente en " + ruta);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

