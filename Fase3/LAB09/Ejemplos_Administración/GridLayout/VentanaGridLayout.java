package GridLayout;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class VentanaGridLayout extends JFrame implements ActionListener
{
 private final JButton[] botones;  // arreglo de botones
 private static final String[] etiquetas =
     { "uno", "dos", "tres", "cuatro", "cinco", "seis" };

 private boolean cambiar = true;     // alterna entre dos diseños
 private Container area;             // contenedor del marco
 private GridLayout diseño1;         // primer GridLayout
 private GridLayout diseño2;         // segundo GridLayout

 // Constructor
 public VentanaGridLayout()
 {
     super("Ejemplo GridLayout Calle y Lazo");

     diseño1 = new GridLayout(2, 3, 5, 5); // 2x3 con separaciones
     diseño2 = new GridLayout(3, 2);       // 3x2 sin separaciones

     area = getContentPane();
     setLayout(diseño1);

     botones = new JButton[etiquetas.length];

     for (int i = 0; i < etiquetas.length; i++)
     {
         botones[i] = new JButton(etiquetas[i]);
         botones[i].addActionListener(this); // registra escucha
         add(botones[i]);                    // agrega botón
     }
 }

 // Maneja eventos de botón alternando entre los diseños
 @Override
 public void actionPerformed(ActionEvent e)
 {
     if (cambiar)
         area.setLayout(diseño2);
     else
         area.setLayout(diseño1);

     cambiar = !cambiar;

     area.validate(); // redistribuye los componentes
 }
} // fin de la clase
