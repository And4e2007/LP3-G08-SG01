package Actividades;

import javax.swing.*;
import java.awt.*;

public class BindingManual {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Binding Manual");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new BindingManualPanel());
            f.setSize(500,300);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}

class Persona {
    private String nombre;
    private int edad;
    private boolean activo;

    public Persona(String nombre, int edad, boolean activo) {
        this.nombre = nombre;
        this.edad = edad;
        this.activo = activo;
    }
    public String getNombre(){return nombre;}
    public void setNombre(String n){nombre=n;}
    public int getEdad(){return edad;}
    public void setEdad(int e){edad=e;}
    public boolean isActivo(){return activo;}
    public void setActivo(boolean a){activo=a;}
}

class BindingManualPanel extends JPanel{
    private Persona modelo;
    private JTextField txtNombre;
    private JSpinner spnEdad;
    private JCheckBox chkActivo;

    public BindingManualPanel(){
        modelo=new Persona("María Pérez",28,true);
        setLayout(new GridLayout(4,2));
        txtNombre=new JTextField();
        spnEdad=new JSpinner(new SpinnerNumberModel(28,0,120,1));
        chkActivo=new JCheckBox("Activo");

        add(new JLabel("Nombre:")); add(txtNombre);
        add(new JLabel("Edad:")); add(spnEdad);
        add(new JLabel("Estado:")); add(chkActivo);

        JButton guardar=new JButton("Guardar");
        JButton restaurar=new JButton("Restaurar");
        add(guardar); add(restaurar);

        restaurar.addActionListener(e->syncModelToView());
        guardar.addActionListener(e->syncViewToModel());
        syncModelToView();
    }

    private void syncModelToView(){
        txtNombre.setText(modelo.getNombre());
        spnEdad.setValue(modelo.getEdad());
        chkActivo.setSelected(modelo.isActivo());
    }
    private void syncViewToModel(){
        modelo.setNombre(txtNombre.getText());
        modelo.setEdad((int)spnEdad.getValue());
        modelo.setActivo(chkActivo.isSelected());
    }
}
