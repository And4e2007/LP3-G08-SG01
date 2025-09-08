package Actividad02;

import java.util.Date;

public class PoliticaCancelacionModerada_2 implements PoliticaCancelacion_2 {
    @Override
    public boolean puedeCancelar(Reserva_2 reserva) {
        long horasRestantes = (reserva.getFechaCheckIn().getTime() - new Date().getTime()) / (1000 * 60 * 60);
        return horasRestantes >= 72;
    }

    @Override
    public double calcularPenalizacion(Reserva_2 reserva) {
        return reserva.getMontoTotal() * 0.5; // penalización 50%
    }
}
