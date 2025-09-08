package Actividad02;

public class PoliticaCancelacionEstricta_2 implements PoliticaCancelacion_2 {
    @Override
    public boolean puedeCancelar(Reserva_2 reserva) {
        return false; // nunca permite cancelar
    }

    @Override
    public double calcularPenalizacion(Reserva_2 reserva) {
        return reserva.getMontoTotal(); // 100% de penalización
    }
}