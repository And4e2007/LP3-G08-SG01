package Ejercicio_1_y_2;

public class Personaje {
	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	private int alcance;
	private int nivel;
	
	public Personaje(String nombre, double vida, double ataque, double defensa, double alcance, double nivel) {
		setNombre(nombre);
		setVida(vida);
		setAtaque(ataque);
		setDefensa(defensa);
		setAlcance(alcance);
		 if (nivel < 1) {
	            throw new IllegalArgumentException("El nivel debe ser mayor a 0");
	        }
	        this.nivel = (int) nivel;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(double vida) {
		if (vida <= 0) {
			throw new IllegalArgumentException("La vida debe ser mayor que 0");
		}
		this.vida = (int) vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(double ataque) {
		if (ataque <= 0) {
			throw new IllegalArgumentException("El ataque debe ser mayor que 0");
		}
		this.ataque = (int) ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(double defensa) {
		if (defensa <= 0) {
			throw new IllegalArgumentException("La defensa debe ser mayor que 0");
		}
		this.defensa = (int) defensa;
	}

	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(double alcance) {
		if (alcance <= 0) {
			throw new IllegalArgumentException("El alcance debe ser mayor que 0");
		}
		this.alcance = (int) alcance;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void subirDeNivel() {
        this.nivel++;
        // Lógica de mejora: por cada nivel, gana +2 de vida y +1 en el resto.
        this.vida += 2;
        this.ataque += 1;
        this.defensa += 1;
        this.alcance += 1;
        System.out.println("¡" + this.nombre + " ha subido al nivel " + this.nivel + "!");
    }
	
	@Override
	public String toString() {
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance + "," + nivel;
    }
}
