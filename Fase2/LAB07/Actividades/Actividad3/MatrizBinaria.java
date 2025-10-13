package Actividad3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MatrizBinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Número de columnas: ");
        int columnas = sc.nextInt();

        double[][] matriz = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("matriz.dat"))) {
            out.writeInt(filas);
            out.writeInt(columnas);

            for (double[] fila : matriz) {
                for (double valor : fila) {
                    out.writeDouble(valor);
                }
            }

            System.out.println("Matriz guardada correctamente en 'matriz.dat'.");
        } catch (IOException e) {
            System.out.println("Error al guardar la matriz: " + e.getMessage());
        }
    }
}
