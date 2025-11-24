package Ejercicio4;

public class Prueba {
    public static void main(String[] args) {
        Interfaz ventana = new Interfaz();
        ventana.setSize(400, 150);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(Interfaz.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
