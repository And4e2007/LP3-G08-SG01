package Actividad_4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReporteTransacciones {
    public void generarReporte(CuentaBancaria cuenta, String archivo)
            throws IOException, HistorialVacioException {
        if (cuenta.getSaldo() == 0) {
            throw new HistorialVacioException("No hay transacciones para reportar.");
        }

        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write("Cuenta: " + cuenta + " - Saldo: " + cuenta.getSaldo());
        }
    }

    public void leerReporte(String archivo) {
        try (Scanner sc = new Scanner(new java.io.File(archivo))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}