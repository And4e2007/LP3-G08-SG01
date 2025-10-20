package Ejercicios_1_y_2;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuApp {
    private static final String CLAVE = "1234";

    public static void main(String[] args) {
        try (Connection conn = Conexion.Conectar()) {
            if (conn == null) return;
            PersonaDAO dao = new PersonaDAO(conn);
            Scanner sc = new Scanner(System.in);
            GestorPersonas gestor = new GestorPersonas();
            int opcion;

            do {
                System.out.println("\n=== MENÚ PERSONAS ===");
                System.out.println("1. Ingresar persona");
                System.out.println("2. Mostrar personas");
                System.out.println("3. Actualizar persona");
                System.out.println("4. Eliminar persona");
                System.out.println("5. Realizar consulta mdiante arreglo");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> {
                        Persona p = new Persona();
                        System.out.print("Nombre: ");
                        p.setNombre(sc.nextLine());
                        System.out.print("Edad: ");
                        p.setEdad(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Correo: ");
                        p.setCorreo(sc.nextLine());
                        if (pedirClave(sc)) {
                        	dao.insertar(p);
                        }else {
                        	System.out.println("Error en la clave, datos no guardadados");
                        }
                    }
                    case 2 -> {
                        List<Persona> personas = dao.listar();
                        for (Persona per : personas) {
                            System.out.printf("%d - %s - %d - %s%n",
                                    per.getId(), per.getNombre(), per.getEdad(), per.getCorreo());
                        }
                    }
                    case 3 -> {
                        Persona p = new Persona();
                        System.out.print("ID a actualizar: ");
                        p.setId(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Nuevo nombre: ");
                        p.setNombre(sc.nextLine());
                        System.out.print("Nueva edad: ");
                        p.setEdad(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Nuevo correo: ");
                        p.setCorreo(sc.nextLine());
                        if (pedirClave(sc)) {
                        	dao.actualizar(p);
                        }else {
                        	System.out.println("Contrase invalidad, cambios cacelados");
                        }
                    }
                    case 4 -> {
                        System.out.print("ID a eliminar: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        if (pedirClave(sc)) {
                        	dao.eliminar(id);
                        }else {
                        	System.out.println("Clave incorrecta; persona no eliminada");
                        }
                    }
                    case 5-> {
                    	gestor.cargarDesdeBD(conn);
                        // 🔹 Llama al método que pide los filtros y muestra resultados
                        gestor.Mostrar();
                    }
                    case 0 -> {
                    	conn.close();
                    	System.out.println("Saliendo...");
                    }
                    default -> System.out.println("Opción inválida");
                }
            } while (opcion != 0);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean pedirClave(Scanner sc) {
        System.out.print("Ingrese clave para confirmar: ");
        String clave = sc.nextLine();
        return clave.equals(CLAVE);
    }
}
