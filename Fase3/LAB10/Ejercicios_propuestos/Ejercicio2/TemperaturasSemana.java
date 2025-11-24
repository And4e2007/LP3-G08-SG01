package Ejercicio2;

public class TemperaturasSemana {

    private double[] temperaturas; // 7 días

    public TemperaturasSemana() {
        temperaturas = new double[7];
    }

    public void setTemperatura(int dia, double valor) {
        temperaturas[dia] = valor;
    }

    public double[] getTemperaturas() {
        return temperaturas;
    }
}
