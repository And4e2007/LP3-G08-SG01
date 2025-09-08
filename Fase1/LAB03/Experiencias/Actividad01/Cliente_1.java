package Actividad01;

public class Cliente_1 {
    private String nombre;
    private boolean esVIP;

    public Cliente_1(String nombre, boolean esVIP) {
        this.nombre = nombre;
        this.esVIP = esVIP;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isVIP() {
        return esVIP;
    }
}
