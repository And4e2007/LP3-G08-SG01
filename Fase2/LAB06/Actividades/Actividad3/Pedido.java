package Actividad3;

public class Pedido {
    private String nombrePlato;
    private String tipo;
    private String estado; // Pendiente, Completo o Eliminado

    public Pedido(String nombrePlato, String tipo) {
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
        this.estado = "Pendiente";
    }

    public String getNombrePlato() { return nombrePlato; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return nombrePlato + " (" + tipo + ") - Estado: " + estado;
    }
}


