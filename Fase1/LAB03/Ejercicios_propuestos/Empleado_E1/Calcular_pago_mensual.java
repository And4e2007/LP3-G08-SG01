package Empleado_E1;

public class Calcular_pago_mensual {
    public double calcularPagoMensual(Empleado empleado, int horasExtras) {
        double pagoHora = empleado.getSalario() / 720;
        double pagoExtra = pagoHora * horasExtras;
        return empleado.getSalario() + pagoExtra;
    }
}
