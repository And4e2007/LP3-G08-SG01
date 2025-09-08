package Actividad03;

public class Main_3 {
    public static void main(String[] args) {
        CuentaBancaria_3 ahorro = new CuentaAhorro_3(1000);
        CuentaBancaria_3 corriente = new CuentaCorriente_3(500, 300);
        CuentaBancaria_3 plazoFijo = new CuentaPlazoFijo_3(2000);

        //Cumplen LSP
        ahorro.retirar(200);
        corriente.retirar(700);

        // Viola LSP
        try {
            plazoFijo.retirar(100);
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
