package JcheckBox;

//Botones JCheckBox y eventos de elementos.
//MarcoCasillaVerificacion.java
//Ejemplo con Negrita, Cursiva y Subrayado

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MarcoCasillaVerificacion extends JFrame {
 private JTextField campoTexto;
 private JCheckBox negritaJCheckBox;
 private JCheckBox cursivaJCheckBox;
 private JCheckBox subrayadoJCheckBox; // 🆕 Nueva casilla

 public MarcoCasillaVerificacion() {
     super("Prueba de JCheckBox con Subrayado");
     setLayout(new FlowLayout());

     // Campo de texto base
     campoTexto = new JTextField("Observe cómo cambia el estilo de letra", 25);
     campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
     add(campoTexto);

     // Casillas
     negritaJCheckBox = new JCheckBox("Negrita");
     cursivaJCheckBox = new JCheckBox("Cursiva");
     subrayadoJCheckBox = new JCheckBox("Subrayado"); // 🆕
     add(negritaJCheckBox);
     add(cursivaJCheckBox);
     add(subrayadoJCheckBox);

     // Manejador común
     ManejadorCheckBox manejador = new ManejadorCheckBox();
     negritaJCheckBox.addItemListener(manejador);
     cursivaJCheckBox.addItemListener(manejador);
     subrayadoJCheckBox.addItemListener(manejador);
 }

 // Clase interna para manejar eventos
 private class ManejadorCheckBox implements ItemListener {
     @Override
     public void itemStateChanged(ItemEvent evento) {
         int estilo = Font.PLAIN;

         // Define estilo base (negrita, cursiva o ambas)
         if (negritaJCheckBox.isSelected())
             estilo += Font.BOLD;
         if (cursivaJCheckBox.isSelected())
             estilo += Font.ITALIC;

         // Crea la fuente base
         Font fuente = new Font("Serif", estilo, 14);

         // Si se selecciona subrayado, añadimos atributo
         if (subrayadoJCheckBox.isSelected()) {
             Map<TextAttribute, Object> atributos = (Map<TextAttribute, Object>) fuente.getAttributes();
             atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
             fuente = new Font(atributos);
         }

         // Aplica al campo de texto
         campoTexto.setFont(fuente);
     }
 }
}
