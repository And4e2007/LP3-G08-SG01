package Ejercicios_2_y_3;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo; // "Arma" o "Poción"
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() { 
    	return nombre; 
    	}
    public int getCantidad() { 
    	return cantidad; 
    	}
    public String getTipo() { 
    	return tipo; 
    	}
    public String getDescripcion() { 
    	return descripcion; 
    	}

    public void usarItem() {
        if (cantidad > 0) cantidad--;
    }
    
    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Cantidad: " + cantidad;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item other = (Item) obj;
        return nombre.equalsIgnoreCase(other.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

}
