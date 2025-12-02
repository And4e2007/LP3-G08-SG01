package Ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Producto> productos = new ArrayList<>();
        CaculadoraDePrecios calc = new CaculadoraDePrecios();

        int op = 0;
        
        while(op!=4) {
            System.out.println("\n------ MENU -------");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Seleccionar estrategia y calcular precio");
            System.out.println("4. Salir");
            System.out.print("Elige: ");
            op = sc.nextInt();
            sc.nextLine();

            if(op == 1) {
                System.out.print("Nombre: ");
                String n = sc.nextLine();
                System.out.print("Precio: ");
                double p = sc.nextDouble();

                productos.add(new Producto(n, p));
                System.out.println("Producto agregado.");
            }

            else if(op == 2) {
                System.out.println("\nPRODUCTOS:");
                for(Producto pr : productos)
                    System.out.println(pr.getNombre() + " - $" + pr.getPrecio());
            }

            else if(op == 3) {
                System.out.println("\nEstrategias:");
                System.out.println("1. Sin descuento");
                System.out.println("2. Descuento fijo (10%)");
                System.out.println("3. Descuento porcentual (2 iguales → 30%)");
                System.out.println("4. Descuento acumulado (3+ → 50% al menor)");
                System.out.print("Opción: ");
                int est = sc.nextInt();

                if(est == 1) calc.setEstrategiaDes(new SinDescuento());
                if(est == 2) calc.setEstrategiaDes(new DescuentoFijo());
                if(est == 3) calc.setEstrategiaDes(new DescuentoPorcentual());
                if(est == 4) calc.setEstrategiaDes(new DescuentoPorcentualAcumulado());

                double total = calc.calcularPrecio(productos);
                System.out.println("\nTOTAL FINAL = $" + total);
            }

            else if(op == 4) {
                System.out.println("Saliendo...");
                break;
            }

            else {
                System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}
