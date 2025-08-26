package Sistema_de_gestion_de_cursos_U;

import java.util.ArrayList;

public class Curso {
	
	private String nombre;
	private int codigo;
	private int totalEstudiantesPorCurso = 0;
	
	// Constante
    public static final int MAX_ESTUDIANTES = 30;

    // Variables de clase
    private static int totalCursos = 0;
    private static int totalEstudiantes = 0;
	
	// Composición: un curso tiene un profesor
    private Profesor profesor;

    // Asociación: un curso tiene estudiantes
    private ArrayList<Estudiante> estudiantes;

    public Curso(String nombre, int codigo, String nombreProfesor, int edadProfesor, int salarioProfesor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.profesor = new Profesor(nombreProfesor, edadProfesor, salarioProfesor);
        this.estudiantes = new ArrayList<>();
        totalCursos++;
    }
    
    // Método de clase
    public static int getTotalCursos() {
        return totalCursos;
    }
    
    // Método de instancia
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(estudiante);
            totalEstudiantes++;
            totalEstudiantesPorCurso++;
        } else {
            System.out.println("No se pueden inscribir más estudiantes en " + nombre);
        }
    }
    
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getTotalEstudiantesPorCurso() {
		return totalEstudiantesPorCurso;
	}
	
	public static int getTotalEstudiantes() {
		return totalEstudiantes;
	}
	
	// Mostrar información
    public void mostrarInfo() {
        System.out.println("Curso: " + nombre + " (" + codigo + ")");
        System.out.println("Profesor: " + profesor.getNombre());
        System.out.println("Estudiantes inscritos:");
        for (Estudiante e : estudiantes) {
            System.out.println("- " + e.getNombre());
        }
    }
}
