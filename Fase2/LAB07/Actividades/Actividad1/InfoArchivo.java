package Actividad1;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class InfoArchivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la ruta del archivo o directorio: ");
        String ruta = sc.nextLine();

        Path path = Paths.get(ruta);

        if (Files.exists(path)) {
            System.out.println("\n--- Información del archivo/directorio ---");
            System.out.println("Nombre: " + path.getFileName());
            System.out.println("Ruta absoluta: " + path.toAbsolutePath());
            System.out.println("¿Es directorio?: " + Files.isDirectory(path));
            System.out.println("¿Es archivo?: " + Files.isRegularFile(path));
            System.out.println("¿Ruta absoluta?: " + path.isAbsolute());

            try {
                BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println("Última modificación: " + attr.lastModifiedTime());
                System.out.println("Tamaño (bytes): " + attr.size());
            } catch (IOException e) {
                System.out.println("Error al obtener atributos del archivo: " + e.getMessage());
            }

            if (Files.isDirectory(path)) {
                System.out.println("\nContenido del directorio:");
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                    for (Path file : stream) {
                        System.out.println(" - " + file.getFileName());
                    }
                } catch (IOException e) {
                    System.out.println("Error al listar el contenido: " + e.getMessage());
                }
            }
        } else {
            System.out.println("El archivo o directorio no existe.");
        }
    }
}
