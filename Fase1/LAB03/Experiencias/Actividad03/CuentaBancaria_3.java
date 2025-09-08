package Actividad03;

abstract class CuentaBancaria_3 {
    protected double saldo;

    public CuentaBancaria_3(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    // Todas las cuentas permiten depositar
    public void depositar(double monto) {
        saldo += monto;
    }

    // Método abstracto: cada subclase define cómo se retira
    public abstract void retirar(double monto);
}
