package CalculadoraBasica_E2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el primer número: ");
            int a = sc.nextInt();

            System.out.print("Ingrese el segundo número: ");
            int b = sc.nextInt();

            System.out.println("Suma: " + calc.Suma(a, b));
            System.out.println("Resta: " + calc.Resta(a, b));
            System.out.println("Multiplicación: " + calc.Multiplicacion(a, b));
            System.out.println("División: " + calc.Division(a, b));

        } catch (DivisionPorCeroException e) {
            System.out.println("Excepción personalizada: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
        	System.out.println("Calculadora finalizada.");            sc.close();
        }
    }
}