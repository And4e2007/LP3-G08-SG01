package Actividad;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MiFlowLayout extends JFrame {

    public MiFlowLayout() {
        super("FlowLayout - Integrantes: Calle y Lazo");

        setLayout(new FlowLayout());

        add(new JButton("Botón 1"));
        add(new JButton("Botón 2"));
        add(new JButton("Botón 3"));
        add(new JButton("Botón 4"));
    }

    public static void main(String[] args) {
        MiFlowLayout ventana = new MiFlowLayout();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 120);
        ventana.setVisible(true);
    }
}
