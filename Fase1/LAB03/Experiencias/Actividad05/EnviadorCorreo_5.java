package Actividad05;

class EnviadorCorreo_5 implements CanalNotificacion_5 {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Correo enviado: " + mensaje);
    }
}

