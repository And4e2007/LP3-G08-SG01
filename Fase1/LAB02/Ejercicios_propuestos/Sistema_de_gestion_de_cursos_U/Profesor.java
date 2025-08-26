package Sistema_de_gestion_de_cursos_U;

public class Profesor extends Persona{
	private int salario;

	public Profesor(String nombre, int edad, int salario) {
		super(nombre, edad);
		this.salario = salario;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	@Override
	public void mostrarDatos() {
		System.out.println("Profesor: " + getNombre());
		System.out.println("Edad: " + getEdad());
		System.out.println("Salario: " + getSalario());
	}
}
