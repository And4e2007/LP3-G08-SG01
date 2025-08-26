package Actividad05;

public abstract class Cuenta_5 {
    protected String numeroCuenta;
    protected double saldo;

    public Cuenta_5(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        if (saldo >= monto) saldo -= monto;
        else System.out.println("Saldo insuficiente en " + numeroCuenta);
    }

    public double getSaldo() { return saldo; }

    public abstract void consultar();
}