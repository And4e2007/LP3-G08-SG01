package Actividad5;

import java.io.*;
import java.util.*;

class Persona {
    String nombre, telefono, direccion;
    Persona(String n, String t, String d) {
        nombre = n; telefono = t; direccion = d;
    }
    public String getNombre() { return nombre; }
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Dirección: " + direccion;
    }
}

public class Agenda {
    public static void main(String[] args) {
        List<Persona> lista = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("agenda.txt"))) {
            while (sc.hasNextLine()) {
                String[] datos = sc.nextLine().split(",");
                if (datos.length == 3)
                    lista.add(new Persona(datos[0].trim(), datos[1].trim(), datos[2].trim()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo 'agenda.txt' no encontrado.");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Buscar contacto: ");
        String nombre = in.nextLine();
        boolean encontrado = false;
        for (Persona p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado:\n" + p);
                encontrado = true;
                break;
            }
        }
        if (!encontrado)
            System.out.println("Contacto no encontrado.");
    }
}
