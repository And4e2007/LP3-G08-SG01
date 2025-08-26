package Actividad04;

public class Cuenta_4 {
    private String numeroCuenta;
    private double saldo;

    public Cuenta_4(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        if (saldo >= monto) saldo -= monto;
        else System.out.println("Saldo insuficiente.");
    }

    public double getSaldo() { return saldo; }

    @Override
    public String toString() {
        return "Cuenta{numero='" + numeroCuenta + "', saldo=" + saldo + "}";
    }
}