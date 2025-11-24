package Ejercicio2;

import javax.swing.*;
import java.awt.*;

public class PanelGrafico extends JPanel {

    private double[] datos;

    public PanelGrafico() {
        datos = new double[7];
    }

    public void setDatos(double[] datos) {
        this.datos = datos;
        repaint(); // vuelve a dibujar
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fondo blanco
        g.setColor(Color.WHITE);  //Ponemos el "lapiz" blanco 
        g.fillRect(0, 0, getWidth(), getHeight());  //pintamos un rectangulo de porte de todo el panel

        // Si no hay datos, salir
        if (datos == null) return;

        int w = getWidth();
        int h = getHeight();

        // Líneas guía
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(40, h - 40, w - 20, h - 40); // eje X
        g.drawLine(40, 20, 40, h - 40);         // eje Y

        // Dibujar gráfico
        g.setColor(Color.BLUE);

        int separacion = (w - 60) / 6; // espacio entre días

        int x = 40;

        // Escalado manual (factor de tamaño)
        double maxTemp = 50; // temperatura máxima estimada
        double escala = (h - 60) / maxTemp;

        // Dibujar puntos y líneas
        for (int i = 0; i < datos.length; i++) {

            int y = (int) (h - 40 - datos[i] * escala);

            // Dibujar punto
            g.fillOval(x - 4, y - 4, 8, 8);

            // Dibujar línea hacia el siguiente punto
            if (i < datos.length - 1) {
                int x2 = x + separacion;
                int y2 = (int) (h - 40 - datos[i + 1] * escala);
                g.drawLine(x, y, x2, y2);
            }

            x += separacion;
        }
    }
}
