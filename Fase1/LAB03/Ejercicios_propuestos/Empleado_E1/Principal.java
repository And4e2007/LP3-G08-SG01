package Empleado_E1;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Empleado emp = new Empleado("Juan Pérez", 3000.0, "IT");
        Calcular_pago_mensual calculadora = new Calcular_pago_mensual();

        System.out.println("¿El empleado trabajó horas extras? (SI/NO): ");
        String r = scanner.nextLine();

        int horasExtras = 0;
        if (r.equalsIgnoreCase("SI") || r.equalsIgnoreCase("Si") || r.equalsIgnoreCase("si")) {
            System.out.print("Ingrese el número de horas extras trabajadas: ");
            horasExtras = scanner.nextInt();
        }

        double pago = calculadora.calcularPagoMensual(emp, horasExtras);

        System.out.println("El pago mensual de " + emp.getNombre() + " es: $" + pago);

        scanner.close();
    }

}
