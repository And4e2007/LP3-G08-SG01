package Ejercicios_2_y_3;
import java.util.ArrayList;
import java.util.List;

public class InventarioModel {
    private List<Item> items;

    public InventarioModel() {
        items = new ArrayList<>();
    }

    public void agregarItem(Item item) {
        items.add(item);
    }

    public boolean eliminarItem(Item item) {
    	boolean encontrado = false;
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).equals(item)) {
				items.remove(i);
				encontrado = true;
				return encontrado;
			}
		}
		return encontrado;
    }

    public List<Item> obtenerItems() {
        return items;
    }

    public Item buscarItem(String nombre) {
        for (Item i : items) {
            if (i.getNombre().equalsIgnoreCase(nombre))
                return i;
        }
        return null;
    }
}

