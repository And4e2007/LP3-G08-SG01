package Actividad05;

public class CuentaCorriente_5 extends Cuenta_5 {
    private int retiros;
    private static final int RETIROS_GRATIS = 3;
    private static final double COSTO_EXTRA = 3.0;

    public CuentaCorriente_5(String numeroCuenta, double saldoInicial) {
        super(numeroCuenta, saldoInicial);
        this.retiros = 0;
    }

    @Override
    public void retirar(double monto) {
        super.retirar(monto);
        retiros++;
        if (retiros > RETIROS_GRATIS) {
            saldo -= COSTO_EXTRA;
        }
    }

    @Override
    public void consultar() {
        retiros = 0;
    }
}
