package Actividad_2;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private boolean activa = true;

    // Constructor con validación
    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        if (saldo < 0) throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void transferir(CuentaBancaria destino, double monto)
            throws CuentaNoEncontradaException, SaldoInsuficienteException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta destino no existe.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferir.");
        }
        this.saldo -= monto;
        destino.saldo += monto;
    }

    public void cerrarCuenta() throws SaldoNoCeroException {
        if (saldo != 0) {
            throw new SaldoNoCeroException("No se puede cerrar la cuenta, saldo distinto de cero.");
        }
        activa = false;
    }

    public double getSaldo() {
        return saldo;
    }
}
