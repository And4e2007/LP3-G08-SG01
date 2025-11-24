package Ejercicio1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interfaz extends JFrame{
	private Producto producto;
	
	private JTextField nombre;
	private JTextField precio;
	private JTextField stock;
	private JTextField categoria;
	
	private JButton actualizarCat;
	
	private JLabel infoActualizada;
	
	public Interfaz() {
		super("Interfaz de producto");
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(6, 2, 5, 5));
		
		//modelo incial vacío
		producto = new Producto("", 0.0, 0, "");
		
		panelPrincipal.add(new JLabel("Nombre:"));
        nombre = new JTextField();
        panelPrincipal.add(nombre);

        panelPrincipal.add(new JLabel("Precio:"));
        precio = new JTextField();
        panelPrincipal.add(precio);

        panelPrincipal.add(new JLabel("Cantidad Stock:"));
        stock = new JTextField();
        panelPrincipal.add(stock);

        panelPrincipal.add(new JLabel("Categoría:"));
        categoria = new JTextField();
        panelPrincipal.add(categoria);

        actualizarCat = new JButton("Actualizar Producto");
        panelPrincipal.add(actualizarCat);

        infoActualizada = new JLabel("Datos del producto aparecerán aquí");
        panelPrincipal.add(infoActualizada);
        
        add(panelPrincipal);
        
     // Acción del botón
        actualizarCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    producto.setNombre(nombre.getText());
                    producto.setPrecio(Double.parseDouble(precio.getText()));
                    producto.setStock(Integer.parseInt(stock.getText()));
                    producto.setCategoria(categoria.getText());

                    infoActualizada.setText(producto.toString());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Error: Verifique los datos ingresados",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
	}
}
