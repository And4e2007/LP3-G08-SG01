package FlowLayOut;


import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoFlowLayout extends JFrame
{
 private final JButton botonIzq;     // botón para alinear a la izquierda
 private final JButton botonCentro;  // botón para alinear al centro
 private final JButton botonDer;     // botón para alinear a la derecha
 private final FlowLayout layout;    // esquema de FlowLayout
 private final Container contenedor; // contenedor principal

 // Constructor: configura la interfaz
 public MarcoFlowLayout()
 {
     super("Ejemplo de FlowLayout Calle y Lazo");

     layout = new FlowLayout();
     contenedor = getContentPane();
     setLayout(layout);

     // Botón Izquierda
     botonIzq = new JButton("A la izquierda");
     add(botonIzq);
     botonIzq.addActionListener(
         new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 layout.setAlignment(FlowLayout.LEFT);
                 layout.layoutContainer(contenedor);
             }
         }
     );

     // Botón Centro
     botonCentro = new JButton("Al centro");
     add(botonCentro);
     botonCentro.addActionListener(
         new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 layout.setAlignment(FlowLayout.CENTER);
                 layout.layoutContainer(contenedor);
             }
         }
     );

     // Botón Derecha
     botonDer = new JButton("A la derecha");
     add(botonDer);
     botonDer.addActionListener(
         new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 layout.setAlignment(FlowLayout.RIGHT);
                 layout.layoutContainer(contenedor);
             }
         }
     );
 } // fin del constructor
} // fin de la clase
