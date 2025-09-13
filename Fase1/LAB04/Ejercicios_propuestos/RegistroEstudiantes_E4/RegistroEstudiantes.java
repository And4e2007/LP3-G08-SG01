package RegistroEstudiantes_E4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
	private List<String> estudiantes;
	
	public RegistroEstudiantes() {
		estudiantes = new ArrayList<>();
	}
	
	// Método para agregar estudiantes
    public void agregarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede ser nulo o vacío.");
        }
        estudiantes.add(nombre);
        System.out.println("Estudiante agregado: " + nombre);
    }
    
    // Método para buscar estudiante
    public String buscarEstudiante(String nombre) {
        for (String est : estudiantes) {
            if (est.equalsIgnoreCase(nombre)) {
                return est;
            }
        }
        throw new NoSuchElementException("El estudiante '" + nombre + "' no se encuentra en el registro.");
    }
}
