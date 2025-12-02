package Command;

public class TestCommand {
    public static void main(String[] args) {
        // Crear televisor
        Televisor miTV = new Televisor();
        
        // Crear control remoto
        ControlRemoto control = new ControlRemoto();
        
        // Configurar comandos
        control.setComando("power", new ComandoEncender(miTV));
        control.setComando("vol_up", new ComandoSubirVolumen(miTV));
        control.setComando("vol_down", new ComandoBajarVolumen(miTV));
        control.setComando("mute", new ComandoSilenciar(miTV));
        control.setComando("channel_5", new ComandoCambiarCanal(miTV, 5));
        control.setComando("channel_10", new ComandoCambiarCanal(miTV, 10));
        control.setComando("input_hdmi2", new ComandoCambiarEntrada(miTV, "HDMI2"));
        
        System.out.println("=== PRUEBA DEL CONTROL REMOTO ===");
        
        // Probar comandos
        control.presionarBoton("power");           // Encender
        control.presionarBoton("vol_up");          // Subir volumen
        control.presionarBoton("vol_up");          // Subir volumen
        control.presionarBoton("channel_5");       // Cambiar a canal 5
        control.presionarBoton("mute");            // Silenciar
        control.presionarBoton("input_hdmi2");     // Cambiar entrada
        control.presionarBoton("channel_10");      // Cambiar a canal 10
        
        System.out.println("\n=== PRUEBA DE DESHACER ===");
        
        // Deshacer comandos
        control.presionarBotonDeshacer(); // Deshacer canal 10
        control.presionarBotonDeshacer(); // Deshacer entrada HDMI2
        control.presionarBotonDeshacer(); // Deshacer mute
        
        control.mostrarEstado();
    }
}