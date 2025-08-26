package Actividad05;

public class CuentaAhorro_5 extends Cuenta_5 {
    private double tasaInteres;
    private double saldoMinimo;

    public CuentaAhorro_5(String numeroCuenta, double saldoInicial, double tasaInteres) {
        super(numeroCuenta, saldoInicial);
        this.tasaInteres = tasaInteres;
        this.saldoMinimo = saldoInicial;
    }

    @Override
    public void retirar(double monto) {
        super.retirar(monto);
        if (saldo < saldoMinimo) {
            saldoMinimo = saldo;
        }
    }

    @Override
    public void consultar() {
        double interes = saldoMinimo * tasaInteres;
        depositar(interes);
        saldoMinimo = saldo;
    }
}