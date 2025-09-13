package Actividad_2;

public class TestExcepcionesPersonalizadas {
    public static void main(String[] args) {
        try {
            CuentaBancaria c1 = new CuentaBancaria("001", "Juan", 500);
            CuentaBancaria c2 = new CuentaBancaria("002", "Maria", 100);

            c1.transferir(c2, 600); // Error: saldo insuficiente
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            CuentaBancaria c3 = new CuentaBancaria("003", "Pedro", 50);
            c3.cerrarCuenta(); // Error: saldo no cero
        } catch (Exception e) {
            System.out.println("Error al cerrar cuenta: " + e.getMessage());
        }
    }
}
