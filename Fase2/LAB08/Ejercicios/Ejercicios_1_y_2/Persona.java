package Ejercicios_1_y_2;

public class Persona {
    private int id;
    private String nombre;
    private int edad;
    private String correo;

    // Constructor vacío
    public Persona() {}

    // Constructor con parámetros
    public Persona(int id, String nombre, int edad, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    // Getters y Setters
    public int getId() { 
    	return id; 
    	}
    public void setId(int id) { 
    	this.id = id; 
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

    public String getCorreo() { 
    	return correo; 
    	}
    public void setCorreo(String correo) { 
    	this.correo = correo; 
    	}
}
