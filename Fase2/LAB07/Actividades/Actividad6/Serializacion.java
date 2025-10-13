package Actividad6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializacion {

    // Clase Fecha serializable
    public static class Fecha implements Serializable {
        private static final long serialVersionUID = 1L;
        private final int dia, mes, anio;

        public Fecha(int dia, int mes, int anio) {
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
        }

        @Override
        public String toString() {
            return dia + "/" + mes + "/" + anio;
        }
    }

    // Clase Alumno serializable
    public static class Alumno implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String nombre;
        private final Fecha fechaNacimiento;

        public Alumno(String nombre, Fecha fechaNacimiento) {
            this.nombre = nombre;
            this.fechaNacimiento = fechaNacimiento;
        }

        @Override
        public String toString() {
            return nombre + " - Nacimiento: " + fechaNacimiento;
        }
    }

    public static void main(String[] args) {
        String rutaArchivo = "alumnos.dat";

        // Preparar datos (lista de alumnos)
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Carlos", new Fecha(5, 5, 2000)));
        alumnos.add(new Alumno("Ana",    new Fecha(10, 2, 2001)));
        alumnos.add(new Alumno("Luis",   new Fecha(1, 1, 1999)));

        // Serializar la lista completa (escribe un solo objeto: la lista)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(alumnos);
            System.out.println("Objetos serializados correctamente en '" + rutaArchivo + "'.");
        } catch (IOException e) {
            System.err.println("Error al serializar: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // Deserializar: leer la lista desde el archivo
        System.out.println("\n--- Lectura de objetos desde '" + rutaArchivo + "' ---");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                @SuppressWarnings("unchecked")
                List<Alumno> listaLeida = (List<Alumno>) obj;
                for (Alumno a : listaLeida) {
                    System.out.println(a);
                }
            } else {
                System.out.println("El contenido del archivo no es una lista de alumnos.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error: clase no encontrada al deserializar: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de E/S al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
