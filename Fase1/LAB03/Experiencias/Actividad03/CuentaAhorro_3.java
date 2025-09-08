package Actividad03;

class CuentaAhorro_3 extends CuentaBancaria_3 {
    public CuentaAhorro_3(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Retiro exitoso de $" + monto);
        } else {
            System.out.println("Fondos insuficientes en Cuenta de Ahorro");
        }
    }
}