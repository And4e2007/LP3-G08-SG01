package Actividad_1;

public class TestCuentaBancaria {
    public static void main(String[] args) {
        try {
            // Caso válido
            CuentaBancaria cuenta1 = new CuentaBancaria("001", "Juan", 100);
            cuenta1.depositar(50);
            System.out.println("Saldo actual: " + cuenta1.getSaldo());

            // Caso inválido: saldo inicial negativo
            CuentaBancaria cuenta2 = new CuentaBancaria("002", "Ana", -100);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            CuentaBancaria cuenta3 = new CuentaBancaria("003", "Pedro", 200);
            cuenta3.retirar(300); // Retiro mayor al saldo
        } catch (Exception e) {
            System.out.println("Error en retiro: " + e.getMessage());
        }
    }
}
