package Actividad;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MiBorderLayout extends JFrame {

    public MiBorderLayout() {
        super("BorderLayout - Integrantes: Calle y Lazo");

        setLayout(new BorderLayout());

        add(new JButton("Norte"), BorderLayout.NORTH);
        add(new JButton("Sur"), BorderLayout.SOUTH);
        add(new JButton("Este"), BorderLayout.EAST);
        add(new JButton("Oeste"), BorderLayout.WEST);
        add(new JButton("Centro"), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MiBorderLayout ventana = new MiBorderLayout();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);
        ventana.setVisible(true);
    }
}

