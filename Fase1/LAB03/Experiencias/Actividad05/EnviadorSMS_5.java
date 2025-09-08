package Actividad05;

class EnviadorSMS_5 implements CanalNotificacion_5 {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("SMS enviado: " + mensaje);
    }
}
