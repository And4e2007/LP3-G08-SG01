package Actividad_3;

public class TestCuentaCredito {
    public static void main(String[] args) {
        try {
            CuentaCredito cc = new CuentaCredito("004", "Luis", 100, 200);

            System.out.println("=== Estado inicial ===");
            System.out.println("Saldo: " + cc.getSaldo() + " | Crédito disponible: " + cc.getLimiteCredito());

            // Primer retiro válido (usa saldo + parte del crédito)
            cc.retirarConCredito(250);
            System.out.println("\nDespués de retirar 250:");
            System.out.println("Saldo: " + cc.getSaldo() + " | Crédito disponible: " + cc.getLimiteCredito());

            // Segundo retiro (excede crédito → excepción)
            cc.retirarConCredito(100);
            System.out.println("\nDespués de retirar 100:");
            System.out.println("Saldo: " + cc.getSaldo() + " | Crédito disponible: " + cc.getLimiteCredito());

        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Otro error: " + e.getMessage());
        }
    }
}
