package Actividad05;

public class Main_5 {
    public static void main(String[] args) {
        // Usar correo
        NotificadorReserva_5 notificadorCorreo = new NotificadorReserva_5(new EnviadorCorreo_5());
        notificadorCorreo.notificar("Reserva confirmada por correo.");

        // Usar SMS
        NotificadorReserva_5 notificadorSMS = new NotificadorReserva_5(new EnviadorSMS_5());
        notificadorSMS.notificar("Reserva confirmada por SMS.");

        // Usar Slack
        NotificadorReserva_5 notificadorSlack = new NotificadorReserva_5(new NotificadorSlack_5());
        notificadorSlack.notificar("Reserva confirmada en Slack.");
    }
}
