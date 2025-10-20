package Ejercicios_1_y_2;

import java.util.*;
import java.sql.Connection;

public class GestorPersonas {
    private List<Persona> listaPersonas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // 🔹 Cargar los datos de la base (desde PersonaDAO)
    public void cargarDesdeBD(Connection conn) {
        try {
            PersonaDAO dao = new PersonaDAO(conn);
            listaPersonas.clear(); // Limpia si había datos
            listaPersonas.addAll(dao.listar()); // Trae todos los registros
            System.out.println("Datos cargados en memoria (" + listaPersonas.size() + " personas)");
        } catch (Exception e) {
            System.out.println("Error al cargar datos desde la BD: " + e.getMessage());
        }
    }

    // 🔹 Mostrar registros con opciones simples
    public void Mostrar() {
        System.out.print("¿Qué campos deseas mostrar? (nombre, edad, correo o enter para todos): ");
        String campo = sc.nextLine().trim().toLowerCase();

        System.out.print("¿Deseas filtrar por algún campo? (nombre, edad, correo o enter para todos): ");
        String filtroCampo = sc.nextLine().trim().toLowerCase();

        String filtroValorStr = "";
        int filtroValorInt = -1;

        if (filtroCampo.equals("nombre")) {
            System.out.print("Introduce el nombre que quieres que muestre: ");
            filtroValorStr = sc.nextLine().trim().toLowerCase();
        } else if (filtroCampo.equals("edad")) {
            System.out.print("Introduce la edad que quieres que muestre: ");
            filtroValorInt = sc.nextInt();
            sc.nextLine();
        } else if (filtroCampo.equals("correo")) {
            System.out.print("Introduce el correo que quieres que muestre: ");
            filtroValorStr = sc.nextLine().trim().toLowerCase();
        }

        System.out.print("¿Deseas ordenar por algún campo? (nombre, edad, correo o enter para ninguno): ");
        String campoOrden = sc.nextLine().trim().toLowerCase();

        String orden = "asc";
        if (!campoOrden.isEmpty()) {
            System.out.print("¿Orden ascendente o descendente? (asc/desc o enter para asc): ");
            orden = sc.nextLine().trim().toLowerCase();
            if (orden.isEmpty()) orden = "asc";
        }

        System.out.print("¿Quieres limitar la cantidad de registros? (número o enter para todos): ");
        String limiteStr = sc.nextLine().trim();
        int limite = 0;
        if (!limiteStr.isEmpty()) {
            try {
                limite = Integer.parseInt(limiteStr);
            } catch (NumberFormatException e) {
                System.out.println("Límite inválido, se mostrarán todos los registros.");
            }
        }

        // 🔹 Filtrar
        List<Persona> resultado = new ArrayList<>();
        for (Persona p : listaPersonas) {
            boolean cumple = true;
            if (filtroCampo.equals("nombre")) {
                cumple = p.getNombre().toLowerCase().contains(filtroValorStr);
            } else if (filtroCampo.equals("edad")) {
                cumple = p.getEdad() == filtroValorInt;
            } else if (filtroCampo.equals("correo")) {
                cumple = p.getCorreo().toLowerCase().contains(filtroValorStr);
            }
            if (cumple) resultado.add(p);
        }

        // 🔹 Ordenar
        if (!campoOrden.isEmpty()) {
            Comparator<Persona> cmp = null;
            if (campoOrden.equals("nombre"))
                cmp = Comparator.comparing(Persona::getNombre, String.CASE_INSENSITIVE_ORDER);
            else if (campoOrden.equals("edad"))
                cmp = Comparator.comparingInt(Persona::getEdad);
            else if (campoOrden.equals("correo"))
                cmp = Comparator.comparing(Persona::getCorreo, String.CASE_INSENSITIVE_ORDER);

            if (cmp != null) {
                if (orden.equals("desc")) cmp = cmp.reversed();
                resultado.sort(cmp);
            }
        }

        // 🔹 Limitar resultados
        if (limite > 0 && limite < resultado.size()) {
            resultado = resultado.subList(0, limite);
        }

        // 🔹 Mostrar resultados
        System.out.println("\n=== RESULTADOS ===");
        for (Persona p : resultado) {
            if (campo.isEmpty()) { // todos los campos
                System.out.printf("%d - %s - %d - %s%n", p.getId(), p.getNombre(), p.getEdad(), p.getCorreo());
            } else {
                String[] campos = campo.split(",");
                StringBuilder sb = new StringBuilder();
                for (String c : campos) {
                    c = c.trim();
                    switch (c) {
                        case "nombre" -> sb.append(p.getNombre()).append(" ");
                        case "edad" -> sb.append(p.getEdad()).append(" ");
                        case "correo" -> sb.append(p.getCorreo()).append(" ");
                    }
                }
                System.out.println(sb.toString().trim());
            }
        }
        if (resultado.isEmpty()) System.out.println("No se encontraron registros.");
    }
}

