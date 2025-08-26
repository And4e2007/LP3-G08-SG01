package Actividad04;

public class Persona_4 {
    private String nombre;
    private Cuenta_4 cuenta;

    public Persona_4(String nombre, String numeroCuenta, double saldoInicial) {
        this.nombre = nombre;
        this.cuenta = new Cuenta_4(numeroCuenta, saldoInicial);
    }

    public void depositar(double monto) {
        cuenta.depositar(monto);
    }

    public void retirar(double monto) {
        cuenta.retirar(monto);
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', " + cuenta + "}";
    }
}
