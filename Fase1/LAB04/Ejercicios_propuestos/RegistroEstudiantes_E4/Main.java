package RegistroEstudiantes_E4;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();

        try {
            // Caso válido
            registro.agregarEstudiante("Ana");
            registro.agregarEstudiante("Luis");

            // Caso inválido (lanza IllegalArgumentException)
            registro.agregarEstudiante("");

        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        }finally {
        	System.out.println("Parte para agregar finalizada.");
        }

        try {
            // Búsqueda válida
            System.out.println("Encontrado: " + registro.buscarEstudiante("Ana"));

            // Búsqueda inválida (lanza NoSuchElementException)
            System.out.println("Encontrado: " + registro.buscarEstudiante("Pedro"));

        } catch (NoSuchElementException e) {
            System.out.println("Error de búsqueda: " + e.getMessage());
        }finally {
        	System.out.println("Programa finalizado.");
        }
    }
}
