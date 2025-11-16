package Compra_de_pasajes;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class CompraDePasajes extends JFrame {
	//Etiquetas
	private JLabel etiquetaNombre; 
	private JLabel etiquetaDNI;
	private JLabel etiquetaFecha;
	private JLabel etiquetaReinicio;
	private JLabel etiquetaMostrar;
	private JLabel etiquetaServicioAd;
	private JLabel etiquetaPiso;
	private JLabel etiquetaLugar;
	private JLabel etiquetaOrigen;
	private JLabel etiquetaDestino;
	private JLabel etiquetaCalidad;
	
	//Campos
	private final JTextField campoNombres;
	private final JTextField campoDNI;
	private final JTextField campoFecha;
	
	//Botones
	private final JButton botonReinicio;
	private final JButton botonMostrar;
	
	//Casillas de verificación
	private JCheckBox casillaAudifonos;
	private JCheckBox casillaManta;
	private JCheckBox casillaRevistas;
	
	//Botones de opción
	private final JRadioButton opcionPrimerPiso;
	private final JRadioButton opcionSegundoPiso;
	private ButtonGroup grupoBotones;
	
	//Cuadros combinados
	private final JComboBox<String> cuadroOrigen;
	private final JComboBox<String> cuadroDestino;
	
	//Lista
	private final JList<String> listaCalidades;
	
	public CompraDePasajes() {
		super("Compra de pasajes");
		
		//panel principal del diseño
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		//Creamos las etiquetas de campos
		etiquetaNombre = new JLabel("Ingrese su nombre completo: ");
		etiquetaNombre.setAlignmentX(CENTER_ALIGNMENT);   //Para poner la etique en el centro de manera horizontal

		etiquetaDNI = new  JLabel("Ingrese su DNI: ");
		etiquetaDNI.setAlignmentX(CENTER_ALIGNMENT);

		etiquetaFecha = new JLabel("Ingrese la fecha de vuelo:");
		etiquetaFecha.setAlignmentX(CENTER_ALIGNMENT);

		//Creamos las etiquetas de botones
		etiquetaReinicio = new JLabel("");
        etiquetaReinicio.setAlignmentX(CENTER_ALIGNMENT);

        etiquetaMostrar = new JLabel("");
        etiquetaMostrar.setAlignmentX(CENTER_ALIGNMENT);
        
        //Creamos la etiquetas de casillas de vefiricación
        etiquetaServicioAd = new JLabel("Marque que servicio/s desea:");
        etiquetaServicioAd.setAlignmentX(CENTER_ALIGNMENT);
        
        //Creamos la etiqueta de boton de opcion
        etiquetaPiso = new JLabel("Elija en que piso desea estar:");
        etiquetaPiso.setAlignmentX(CENTER_ALIGNMENT);
        
        //Creamos la etiqueta para los cuadros combinados
        etiquetaLugar = new JLabel("Elija el lugar de origen y de destino: ");
        etiquetaLugar.setAlignmentX(CENTER_ALIGNMENT);
        
        etiquetaOrigen = new JLabel("Origen");
        etiquetaOrigen.setAlignmentX(CENTER_ALIGNMENT);
        
        etiquetaDestino = new JLabel("Destino");
        etiquetaDestino.setAlignmentX(CENTER_ALIGNMENT);
        
        //Creamos la etiqueta para la lista
        etiquetaCalidad = new JLabel("Elige la calidad de tu vuelo: ");
        etiquetaCalidad.setAlignmentX(CENTER_ALIGNMENT);
        
		//Creamos los campos
		campoNombres = new JTextField(30);
		campoDNI = new JTextField(10);
		campoFecha = new JTextField(12);
		
		//Creamos los botones
		botonReinicio = new JButton("Reiniciar");
		botonMostrar = new JButton("Aceptar");
		
		// MOUSE LISTENERS
        botonReinicio.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                etiquetaReinicio.setText("Borra todos los datos ingresados");
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                etiquetaReinicio.setText("");
            }
        });

        botonMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                etiquetaMostrar.setText("Confirma la compra con los datos ingresados");
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                etiquetaMostrar.setText("");
            }
        });
        
        //Creamos las casillas de verificación
        casillaAudifonos = new JCheckBox("Audifonos");
        casillaManta = new JCheckBox("Manta");
        casillaRevistas = new JCheckBox("Revistas");
        
        //Creamos los botones de opción
        opcionPrimerPiso = new JRadioButton("1er Piso", false);
        opcionPrimerPiso.setAlignmentX(CENTER_ALIGNMENT);
        opcionSegundoPiso = new JRadioButton("2do Piso", false);
        opcionSegundoPiso.setAlignmentX(CENTER_ALIGNMENT);
        //Agrupar los radio buttons
        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(opcionPrimerPiso);
        grupoBotones.add(opcionSegundoPiso);

        
        //Creamos los cuadros combinados
        cuadroOrigen = new JComboBox<>(new String[] {"Lima", "Arequipa", "Cusco"});
        cuadroDestino = new JComboBox<>(new String[] {"Lima", "Arequipa", "Cusco"});
        
        //Creamos la lista
        listaCalidades = new JList<>(new String[] {"Económico", "Standard", "VIP"});
        listaCalidades.setVisibleRowCount(2); // Solo dos visibles
        listaCalidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //No se permite seleccion multiple
                
        //--------------Paneles---------------
        //Panel para los botones
      	JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
      	panelBotones.add(botonReinicio);
  		panelBotones.add(botonMostrar);
        
        //Panel para las casillas de verificación
        JPanel panelCasillas = new JPanel();
        panelCasillas.setLayout(new BoxLayout(panelCasillas, BoxLayout.Y_AXIS));
        
        // Alinear el panel de casillas al centro del panel principal
        panelCasillas.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Alinear cada casilla a la izquierda
        casillaAudifonos.setAlignmentX(Component.LEFT_ALIGNMENT);
        casillaManta.setAlignmentX(Component.LEFT_ALIGNMENT);
        casillaRevistas.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelCasillas.add(casillaAudifonos);
		panelCasillas.add(casillaManta);
		panelCasillas.add(casillaRevistas);
		
		//Panel para los cuadros combinados
		JPanel panelCuadrosCombi = new JPanel();
		panelCuadrosCombi.setLayout(new GridLayout(2, 2, 10, 10));
		panelCuadrosCombi.add(etiquetaOrigen);
		panelCuadrosCombi.add(etiquetaDestino);
		panelCuadrosCombi.add(cuadroOrigen);
		panelCuadrosCombi.add(cuadroDestino);
		
		//Agregamos todo al panel principal
		panelPrincipal.add(etiquetaNombre);
		panelPrincipal.add(campoNombres);
		panelPrincipal.add(etiquetaDNI);
		panelPrincipal.add(campoDNI);
		panelPrincipal.add(etiquetaFecha);
		panelPrincipal.add(campoFecha);
		panelPrincipal.add(etiquetaServicioAd);
		panelPrincipal.add(panelCasillas);
		panelPrincipal.add(etiquetaPiso);
		panelPrincipal.add(opcionPrimerPiso);
		panelPrincipal.add(opcionSegundoPiso);
		panelPrincipal.add(etiquetaLugar);
		panelPrincipal.add(panelCuadrosCombi);
		panelPrincipal.add(etiquetaCalidad);
		panelPrincipal.add(new JScrollPane(listaCalidades)); // Agregamos un scroll que contenga a la lista
		panelPrincipal.add(panelBotones);
		panelPrincipal.add(etiquetaReinicio);
        panelPrincipal.add(etiquetaMostrar);
        
        //Agregamos el panel principal
		add(panelPrincipal);
		
		//Conectar botones al manejador
		ManejadorDeEventos manejador = new ManejadorDeEventos();
		botonMostrar.addActionListener(manejador);
		botonReinicio.addActionListener(manejador);

	}
	
	// ================== MANEJADOR DE EVENTOS ==================
	private class ManejadorDeEventos implements java.awt.event.ActionListener {

	    @Override
	    public void actionPerformed(java.awt.event.ActionEvent e) {
	        Object fuente = e.getSource();

	        if (fuente == botonMostrar) {
	            mostrarResumen();
	        } 
	        else if (fuente == botonReinicio) {
	            reiniciarFormulario();
	        }
	    }
	}

	// ================== MÉTODO PARA MOSTRAR RESUMEN ==================
	private void mostrarResumen() {

	    String nombre = campoNombres.getText();
	    String dni = campoDNI.getText();
	    String fecha = campoFecha.getText();

	    String servicios = "";
	    if (casillaAudifonos.isSelected()) servicios += "Audífonos ";
	    if (casillaManta.isSelected()) servicios += "Manta ";
	    if (casillaRevistas.isSelected()) servicios += "Revistas ";
	    if (servicios.isEmpty()) servicios = "Ninguno";

	    String piso = opcionPrimerPiso.isSelected() ? "1er Piso" :
	                  opcionSegundoPiso.isSelected() ? "2do Piso" :
	                  "No seleccionado";

	    String origen = (String) cuadroOrigen.getSelectedItem();
	    String destino = (String) cuadroDestino.getSelectedItem();

	    String calidad = listaCalidades.getSelectedValue();
	    if (calidad == null) calidad = "No seleccionada";

	    String resumen = 
	        "RESUMEN DEL PASAJERO\n\n" +
	        "Nombre: " + nombre + "\n" +
	        "DNI: " + dni + "\n" +
	        "Fecha: " + fecha + "\n\n" +
	        "Servicios adicionales: " + servicios + "\n" +
	        "Piso: " + piso + "\n" +
	        "Origen: " + origen + "\n" +
	        "Destino: " + destino + "\n" +
	        "Calidad del vuelo: " + calidad;

	    JOptionPane.showMessageDialog(this, resumen, "Resumen", JOptionPane.INFORMATION_MESSAGE);
	}

	// ================== MÉTODO PARA REINICIAR ==================
	private void reiniciarFormulario() {

	    campoNombres.setText("");
	    campoDNI.setText("");
	    campoFecha.setText("");

	    casillaAudifonos.setSelected(false);
	    casillaManta.setSelected(false);
	    casillaRevistas.setSelected(false);

	    opcionPrimerPiso.setSelected(false);
	    opcionSegundoPiso.setSelected(false);

	    cuadroOrigen.setSelectedIndex(0);
	    cuadroDestino.setSelectedIndex(0);

	    listaCalidades.clearSelection();

	    etiquetaReinicio.setText("");
	    etiquetaMostrar.setText("");
	}
}
