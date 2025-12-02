package test;

import Observer.*;
import Strategy.*;
import Command.*;
import java.util.Arrays;
import java.util.List;

public class AplicacionCombinada {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA INTEGRADO DE COMERCIO ELECTRÓNICO ===\n");
        
        // 1. Sistema de Notificaciones (Observer)
        SistemaNotificaciones notificaciones = new SistemaNotificaciones();
        Usuario cliente1 = new Usuario("Ana Rodriguez", "ana@email.com");
        Usuario cliente2 = new Usuario("Pedro Martinez", "pedro@email.com");
        
        notificaciones.registrarObserver(cliente1);
        notificaciones.registrarObserver(cliente2);
        
        // 2. Sistema de Estrategias (Strategy)
        CalculadoraPrecios calculadora = new CalculadoraPrecios();
        List<Producto> productos = Arrays.asList(
            new Producto("Laptop", 1000),
            new Producto("Laptop", 1000),
            new Producto("Mouse", 50)
        );
        
        // 3. Sistema de Comandos (Command)
        Televisor tv = new Televisor();
        ControlRemoto controlTV = new ControlRemoto();
        controlTV.setComando("on", new ComandoEncender(tv));
        controlTV.setComando("channel7", new ComandoCambiarCanal(tv, 7));
        
        // Ejecutar sistemas integrados
        System.out.println("1. ENVIANDO NOTIFICACIONES...");
        notificaciones.nuevaPromocion("Oferta especial en electrónicos");
        
        System.out.println("\n2. CALCULANDO PRECIOS CON ESTRATEGIA...");
        calculadora.setEstrategia(new DescuentoPorcentual());
        double total = calculadora.calcularPrecioFinal(productos);
        System.out.println("Total con descuento: $" + total);
        
        System.out.println("\n3. CONTROLANDO TELEVISOR...");
        controlTV.presionarBoton("on");
        controlTV.presionarBoton("channel7");
        
        System.out.println("\n=== SISTEMA INTEGRADO FUNCIONANDO CORRECTAMENTE ===");
    }
}