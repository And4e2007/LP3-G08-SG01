package Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ControlRemoto {
    private Map<String, Comando> comandos;
    private Stack<Comando> historial;
    
    public ControlRemoto() {
        this.comandos = new HashMap<>();
        this.historial = new Stack<>();
    }
    
    public void setComando(String boton, Comando comando) {
        comandos.put(boton, comando);
    }
    
    public void presionarBoton(String boton) {
        Comando comando = comandos.get(boton);
        if (comando != null) {
            comando.ejecutar();
            historial.push(comando);
        }
    }
    
    public void presionarBotonDeshacer() {
        if (!historial.isEmpty()) {
            Comando comando = historial.pop();
            comando.deshacer();
        } else {
            System.out.println("No hay comandos para deshacer");
        }
    }
    
    public void mostrarEstado() {
        System.out.println("\n=== ESTADO DEL CONTROL ===");
        System.out.println("Comandos configurados: " + comandos.keySet());
        System.out.println("Historial de comandos: " + historial.size() + " comandos ejecutados");
    }
}
