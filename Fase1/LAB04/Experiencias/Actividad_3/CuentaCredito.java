package Actividad_3;

public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldo, double limiteCredito) {
        super(numeroCuenta, titular, saldo);
        this.limiteCredito = limiteCredito;
    }

    // Método corregido
    public void retirarConCredito(double monto) throws LimiteCreditoExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }

        // Verificar si saldo + crédito alcanza
        if (getSaldo() + limiteCredito < monto) {
            throw new LimiteCreditoExcedidoException("Operación excede el límite de crédito.");
        }

        if (monto <= getSaldo()) {
            // saldo suficiente, retirar normalmente
            try {
                super.retirar(monto);
            } catch (Exception e) {
                e.printStackTrace(); // nunca debería pasar
            }
        } else {
            // usar crédito
            double deficit = monto - getSaldo();
            setSaldo(0); // se gasta todo el saldo
            limiteCredito -= deficit; // se descuenta del crédito
        }
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
}

