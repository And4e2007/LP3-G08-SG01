package Ejercicio4;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class ContadorPalabras {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccione el archivo de texto");
        
        // Si el usuario solution un archivo
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            procesarArchivo(archivo);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

    public static void procesarArchivo(File archivo) {
        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;

        Map<String, Integer> frecuencia = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;

                // Contar caracteres (sin contar salto de línea)
                totalCaracteres += linea.length();

                // Separar palabras
                String[] palabras = linea.split("\\s+");
                for (String palabra : palabras) {
                    palabra = palabra.trim();

                    // Contar solo secuencias de letras o dígitos
                    if (!palabra.isEmpty() && Character.isLetterOrDigit(palabra.charAt(0))) {
                        totalPalabras++;
                        palabra = palabra.toLowerCase().replaceAll("[^a-z0-9]", "");
                        if (!palabra.isEmpty()) {
                            frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                        }
                    }
                }
            }

            // Mostrar resultados
            System.out.println("📄 Resultados del análisis:");
            System.out.println("Total de líneas: " + totalLineas);
            System.out.println("Total de palabras: " + totalPalabras);
            System.out.println("Total de caracteres: " + totalCaracteres);

            double promedio = totalLineas > 0 ? (double) totalPalabras / totalLineas : 0;
            System.out.printf("Promedio de palabras por línea: %.2f%n", promedio);

            // Palabras más frecuentes
            int maxFrecuencia = 0;
            for (int count : frecuencia.values()) {
                if (count > maxFrecuencia) maxFrecuencia = count;
            }

            System.out.println("\n🔠 Palabras más frecuentes:");
            for (Map.Entry<String, Integer> entrada : frecuencia.entrySet()) {
                if (entrada.getValue() == maxFrecuencia) {
                    System.out.println(entrada.getKey() + " → " + entrada.getValue() + " veces");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("⚠️ Error al leer el archivo: " + e.getMessage());
        }
    }
}
