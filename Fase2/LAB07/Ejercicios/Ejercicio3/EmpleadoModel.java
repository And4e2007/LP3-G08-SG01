package Ejercicio3;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class EmpleadoModel {
	private Map<Integer, Empleado> empleados;
    private final String nombreArchivo = "empleados.txt";
    
    public EmpleadoModel() {
        this.empleados = new HashMap<>();
    }
    
    public  Map<Integer, Empleado> cargarEmpleados() {
    	empleados.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    try {
                        int numero = Integer.parseInt(datos[0]);
                        String nombre = datos[1];
                        double sueldo = Double.parseDouble(datos[2]); 
                        empleados.put(numero, new Empleado(numero, nombre, sueldo));
                    } catch (Exception e) {
                        System.err.println("Advertencia: Se omitió una línea del archivo por datos inválidos. (" + e.getMessage() + ")");
                    }
                }
            }
            return empleados;
        } catch (FileNotFoundException e) {
            // No es un error, el archivo se creará después
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
		return empleados;
    }
    
    public void guardarEmpleados(Map<Integer, Empleado> empleados) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Empleado empleado : empleados.values()) {
                bw.write(empleado.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }
}
