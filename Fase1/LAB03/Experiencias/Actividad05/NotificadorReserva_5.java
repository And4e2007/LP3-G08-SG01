package Actividad05;

class NotificadorReserva_5 {
    private CanalNotificacion_5 canal;

    public NotificadorReserva_5(CanalNotificacion_5 canal) {
        this.canal = canal;
    }

    public void notificar(String mensaje) {
        canal.enviarNotificacion(mensaje);
    }
}
