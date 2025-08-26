package Sistema_de_gestion_de_cursos_U;

public class Estudiante extends Persona{
	private Double promedio_semestre_pasado;

	public Estudiante(String nombre, int edad, Double promedio_semestre_pasado) {
		super(nombre, edad);
		this.promedio_semestre_pasado = promedio_semestre_pasado;
	}

	public Double getPromedio_semestre_pasado() {
		return promedio_semestre_pasado;
	}

	public void setPromedio_semestre_pasado(Double promedio_semestre_pasado) {
		this.promedio_semestre_pasado = promedio_semestre_pasado;
	}

	@Override
	public void mostrarDatos() {
		System.out.println("Estudiante: " + getNombre());
		System.out.println("Edad: " + getEdad());
		System.out.println("Promedio del semestre pasado: " + getPromedio_semestre_pasado());
	}
}
