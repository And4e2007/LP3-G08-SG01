package Actividad03;

class CuentaPlazoFijo_3 extends CuentaBancaria_3 {
    public CuentaPlazoFijo_3(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void retirar(double monto) {
        throw new UnsupportedOperationException(
            "No se puede retirar de una Cuenta a Plazo Fijo antes del vencimiento"
        );
    }
}
