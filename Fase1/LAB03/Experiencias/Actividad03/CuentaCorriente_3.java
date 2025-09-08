package Actividad03;

class CuentaCorriente_3 extends CuentaBancaria_3 {
    private double sobregiro;

    public CuentaCorriente_3(double saldoInicial, double sobregiro) {
        super(saldoInicial);
        this.sobregiro = sobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (saldo + sobregiro >= monto) {
            saldo -= monto;
            System.out.println("Retiro exitoso de $" + monto + " con sobregiro");
        } else {
            System.out.println("Límite de sobregiro excedido en Cuenta Corriente");
        }
    }
}
