package Compra_de_pasajes;

import javax.swing.JFrame;

public class Prueba {
    public static void main(String[] args) throws Exception {
    	CompraDePasajes marcoCompra = new CompraDePasajes();
    	marcoCompra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	marcoCompra.setSize(450, 470);
    	marcoCompra.setVisible(true);
    }
}
