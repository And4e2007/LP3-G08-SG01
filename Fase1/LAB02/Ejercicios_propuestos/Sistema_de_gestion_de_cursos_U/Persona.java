package Sistema_de_gestion_de_cursos_U;

public abstract class Persona {
	// Atributos comunes
    protected String nombre;
    protected int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	// Método abstracto
    public abstract void mostrarDatos();
}
