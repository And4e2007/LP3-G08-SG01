package Actividad01;

public class Coche {
	//Definimos los atributos
	private String marca;
	private String modelo;
	private int añoFabricacion;
	private double precio;
	private boolean encendido;
	
	//Constructor por defecto
	public Coche() {
		this.marca = "Desconocida";
		this.modelo = "Genérico";
        this.añoFabricacion = 2000;
        this.precio = 10000;
        this.encendido = false;
	}
	
	//Constructor con parámetros
	public Coche(String nmarca, String nmodelo, int nañoFabricacion, double nprecio) {
		this.marca = nmarca;
		this.modelo = nmodelo;
		this.añoFabricacion = nañoFabricacion;
		this.precio = nprecio;
		this.encendido = false;
	}
	
	//Métodos
	public boolean aplicarDescuento(double descuento) {
		if(this.añoFabricacion < 2010) {
			this.precio-=this.precio * (descuento/100);
			return true;
		}
		return false;
	}
	
	//Getters y setters
	public String getMarca() {
        return marca;
    }

    public void setMarca(String nmarca) {
        this.marca = nmarca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String nmodelo) {
        this.modelo = nmodelo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int nañoFabricacion) {
        this.añoFabricacion = nañoFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double nprecio) {
        this.precio = nprecio;
    }
    
    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println(marca + " " + modelo + " encendido.");
        } else {
            System.out.println(marca + " " + modelo + " ya estaba encendido.");
        }
    }

    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println(marca + " " + modelo + " apagado.");
        } else {
            System.out.println(marca + " " + modelo + " ya estaba apagado.");
        }
    }

    public void acelerar() {
        if (encendido) {
            System.out.println(marca + " " + modelo + " está acelerando.");
        } else {
            System.out.println("No puedes acelerar, el coche está apagado.");
        }
    }

    public void frenar() {
        if (encendido) {
            System.out.println(marca + " " + modelo + " está frenando.");
        } else {
            System.out.println("No puedes frenar, el coche está apagado.");
        }
    }
}
