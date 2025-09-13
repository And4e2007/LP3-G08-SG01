package Actividad_2;

//Saldo insuficiente
class SaldoInsuficienteException extends Exception {
public SaldoInsuficienteException(String mensaje) {
   super(mensaje);
}
}

//Cuenta no encontrada
class CuentaNoEncontradaException extends Exception {
public CuentaNoEncontradaException(String mensaje) {
   super(mensaje);
}
}

//Saldo no cero al cerrar cuenta
class SaldoNoCeroException extends Exception {
public SaldoNoCeroException(String mensaje) {
   super(mensaje);
}
}
