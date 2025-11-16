package Lista_de_seleccion_multiple;

//Fig. 12.26: PruebaSeleccionMultiple.java
//Prueba de MarcoSeleccionMultiple.

import javax.swing.JFrame;

public class PruebaSeleccionMultiple {
 public static void main(String[] args) {
     MarcoSeleccionMultiple marcoSeleccionMultiple = new MarcoSeleccionMultiple();
     marcoSeleccionMultiple.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoSeleccionMultiple.setSize(400, 200);
     marcoSeleccionMultiple.setVisible(true);
 }
}
