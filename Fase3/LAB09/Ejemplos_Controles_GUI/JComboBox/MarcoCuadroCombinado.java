package JComboBox;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class MarcoCuadroCombinado extends JFrame {

    private final JComboBox<String> imagenesJComboBox; // contiene los nombres de los iconos
    private final JLabel etiqueta; // muestra el icono seleccionado

    private static final String[] nombres = {
        "Opción 1",
        "Opción 2",
        "Opción 3",
        "Opción 4"
    };

    private final Icon[] iconos = {
        UIManager.getIcon("OptionPane.informationIcon"),
        UIManager.getIcon("OptionPane.warningIcon"),
        UIManager.getIcon("OptionPane.errorIcon"),
        UIManager.getIcon("OptionPane.questionIcon")
    };

    // Constructor
    public MarcoCuadroCombinado() {
        super("JComboBox Calle y Lazo");
        setLayout(new FlowLayout()); // establece el esquema del marco

        imagenesJComboBox = new JComboBox<>(nombres); // establece JComboBox
        imagenesJComboBox.setMaximumRowCount(3); // muestra tres filas

        // Evento para cambiar el icono
        imagenesJComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evento) {
                if (evento.getStateChange() == ItemEvent.SELECTED) {
                    etiqueta.setIcon(iconos[imagenesJComboBox.getSelectedIndex()]);
                }
            }
        });

        add(imagenesJComboBox);
        etiqueta = new JLabel(iconos[0]); // muestra el primer icono
        add(etiqueta);
    }

    public static void main(String[] args) {
        MarcoCuadroCombinado marco = new MarcoCuadroCombinado();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(350, 200);
        marco.setVisible(true);
    }
}


