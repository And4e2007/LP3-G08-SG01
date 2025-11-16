package Lista_de_seleccion_multiple;

//Fig. 12.25: MarcoSeleccionMultiple.java
//Objeto JList que permite selecciones múltiples.

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MarcoSeleccionMultiple extends JFrame {

 private final JList<String> listaJListColores; // lista para guardar los nombres de los colores
 private final JList<String> listaJListCopia;   // lista en la que se van a copiar los nombres
 private final JButton botonJButtonCopiar;      // botón para copiar los nombres seleccionados

 private static final String[] nombresColores = {
     "Negro", "Azul", "Cyan", "Gris oscuro", "Gris",
     "Verde", "Gris claro", "Magenta", "Naranja",
     "Rosa", "Rojo", "Blanco", "Amarillo"
 };

 // Constructor de MarcoSeleccionMultiple
 public MarcoSeleccionMultiple() {
     super("Listas de selección múltiple Calle y Lazo");
     setLayout(new FlowLayout());

     // Lista de nombres de colores
     listaJListColores = new JList<>(nombresColores);
     listaJListColores.setVisibleRowCount(5); // muestra cinco filas
     listaJListColores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
     add(new JScrollPane(listaJListColores)); // agrega lista con panel de desplazamiento

     // Botón para copiar
     botonJButtonCopiar = new JButton("Copiar >>>");
     botonJButtonCopiar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evento) {
             // coloca los valores seleccionados en listaJListCopia
             listaJListCopia.setListData(
                 listaJListColores.getSelectedValuesList().toArray(new String[0])
             );
         }
     });
     add(botonJButtonCopiar); // agrega el botón copiar a JFrame

     // Lista para los colores copiados
     listaJListCopia = new JList<>();
     listaJListCopia.setVisibleRowCount(5);
     listaJListCopia.setFixedCellWidth(100);
     listaJListCopia.setFixedCellHeight(15);
     listaJListCopia.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
     add(new JScrollPane(listaJListCopia)); // agrega lista con panel de desplazamiento
 }
}
