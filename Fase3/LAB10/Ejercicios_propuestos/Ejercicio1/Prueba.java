package Ejercicio1;

import javax.swing.*;

public class Prueba {

    public static void main(String[] args) {
    	Interfaz inter = new Interfaz();
        // Configuración de la ventana
        inter.setSize(350, 350);       // tamaño final
        inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inter.setLocationRelativeTo(null); // centrar ventana
        inter.setVisible(true);        // mostrar
    }
}

