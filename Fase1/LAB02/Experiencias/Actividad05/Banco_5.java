package Actividad05;

import java.util.Scanner;

public class Banco_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cuenta_5[] cuentas = new Cuenta_5[4];
        cuentas[0] = new CuentaAhorro_5("001", 1000, 0.02);
        cuentas[1] = new CuentaCorriente_5("002", 800);
        cuentas[2] = new CuentaAhorro_5("003", 2000, 0.03);
        cuentas[3] = new CuentaCorriente_5("004", 1500);

        char opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("D) Depositar");
            System.out.println("R) Retirar");
            System.out.println("C) Consultar");
            System.out.println("S) Salir");
            opcion = sc.next().toUpperCase().charAt(0);

            switch (opcion) {
                case 'D':
                    System.out.print("Número de cuenta: ");
                    String nc = sc.next();
                    System.out.print("Monto: ");
                    double montoD = sc.nextDouble();
                    for (Cuenta_5 c : cuentas) {
                        if (c.numeroCuenta.equals(nc)) {
                            c.depositar(montoD);
                            System.out.println("Nuevo saldo: " + c.getSaldo());
                        }
                    }
                    break;

                case 'R':
                    System.out.print("Número de cuenta: ");
                    nc = sc.next();
                    System.out.print("Monto: ");
                    double montoR = sc.nextDouble();
                    for (Cuenta_5 c : cuentas) {
                        if (c.numeroCuenta.equals(nc)) {
                            c.retirar(montoR);
                            System.out.println("Nuevo saldo: " + c.getSaldo());
                        }
                    }
                    break;

                case 'C':
                    for (Cuenta_5 c : cuentas) {
                        c.consultar();
                        System.out.println("Cuenta " + c.numeroCuenta + " - Saldo: " + c.getSaldo());
                    }
                    break;
            }
        } while (opcion != 'S');

        sc.close();
    }
}