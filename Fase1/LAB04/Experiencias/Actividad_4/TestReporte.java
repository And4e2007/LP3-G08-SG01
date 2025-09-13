package Actividad_4;

public class TestReporte {
    public static void main(String[] args) {
        try {
            CuentaBancaria c1 = new CuentaBancaria("005", "Sofia", 0);
            ReporteTransacciones rpt = new ReporteTransacciones();
            rpt.generarReporte(c1, "reporte.txt");
        } catch (Exception e) {
            System.out.println("Error al generar reporte: " + e.getMessage());
        }
    }
}