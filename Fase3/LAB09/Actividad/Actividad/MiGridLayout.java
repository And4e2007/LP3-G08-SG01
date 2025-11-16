package Actividad;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MiGridLayout extends JFrame {

    public MiGridLayout() {
        super("GridLayout - Integrantes: Calle y Lazo");

        setLayout(new GridLayout(2, 3, 5, 5)); // 2 filas, 3 columnas

        add(new JButton("Uno"));
        add(new JButton("Dos"));
        add(new JButton("Tres"));
        add(new JButton("Cuatro"));
        add(new JButton("Cinco"));
        add(new JButton("Seis"));
    }

    public static void main(String[] args) {
        MiGridLayout ventana = new MiGridLayout();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);
        ventana.setVisible(true);
    }
}
