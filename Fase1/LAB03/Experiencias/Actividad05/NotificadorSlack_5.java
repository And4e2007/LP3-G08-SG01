package Actividad05;

class NotificadorSlack_5 implements CanalNotificacion_5 {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Mensaje enviado a Slack: " + mensaje);
    }
}
