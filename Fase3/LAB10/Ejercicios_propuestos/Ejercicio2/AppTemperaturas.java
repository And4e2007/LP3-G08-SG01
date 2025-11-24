package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppTemperaturas extends JPanel {

    private JTextField[] campos;
    private JButton btnMostrar;

    private TemperaturasSemana modelo;
    private PanelGrafico panelGrafico;

    public AppTemperaturas() {

        modelo = new TemperaturasSemana();
        panelGrafico = new PanelGrafico();

        setLayout(new BorderLayout());

        // Panel superior con campos
        JPanel panelDatos = new JPanel(new GridLayout(2, 7, 5, 5));

        JLabel[] etiquetas = {
            new JLabel("Lun"), new JLabel("Mar"), new JLabel("Mié"),
            new JLabel("Jue"), new JLabel("Vie"), new JLabel("Sáb"), new JLabel("Dom")
        };

        campos = new JTextField[7];
        for (int i = 0; i < 7; i++) {
            panelDatos.add(etiquetas[i]);
        }
        for (int i = 0; i < 7; i++) {
            campos[i] = new JTextField();
            panelDatos.add(campos[i]);
        }

        add(panelDatos, BorderLayout.NORTH);

        // Botón
        btnMostrar = new JButton("Mostrar Gráfico");
        add(btnMostrar, BorderLayout.SOUTH);

        // Panel gráfico
        panelGrafico.setPreferredSize(new Dimension(600, 300));
        add(panelGrafico, BorderLayout.CENTER);

        // Evento del botón
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    for (int i = 0; i < 7; i++) {
                        double temp = Double.parseDouble(campos[i].getText());
                        modelo.setTemperatura(i, temp);
                    }

                    panelGrafico.setDatos(modelo.getTemperaturas());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Error: Ingrese solo números.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }
}
