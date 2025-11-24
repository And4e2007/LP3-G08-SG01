package Ejercicio2;

import javax.swing.*;

public class Prueba {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Temperaturas de la Semana");

        ventana.setContentPane(new AppTemperaturas());

        ventana.setSize(750, 500); 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}

