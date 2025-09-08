package Actividad02;

import java.util.Date;

public class ControladorReservas_2 {
    public static void main(String[] args) {
        Date ahora = new Date();
        Date checkIn = new Date(ahora.getTime() + (1000 * 60 * 60 * 48)); // 48 horas después

        // Usuario elige política flexible
        PoliticaCancelacion_2 politica = new PoliticaCancelacionFlexible_2();

        Reserva_2 reserva = new Reserva_2(1, ahora, checkIn, 500.0, politica);

        // Intentar cancelar
        reserva.cancelar();
    }
}
