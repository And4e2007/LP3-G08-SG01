package Actividad03;

public class Automovil_3 {
    private String marca;
    private String modelo;
    private Motor_3 motor;

    public Automovil_3(String marca, String modelo, Motor_3 motor) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Motor_3 getMotor() { return motor; }
    public void setMotor(Motor_3 motor) { this.motor = motor; }

    @Override
    public String toString() {
        return "Automovil{marca='" + marca + "', modelo='" + modelo + "', motor=" + motor + "}";
    }
}
