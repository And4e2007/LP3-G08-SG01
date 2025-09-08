package Vehiculos_E3;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		 ArrayList<Vehiculo> vehiculos = new ArrayList<>();

	        vehiculos.add(new Bicicleta());
	        vehiculos.add(new Coche());
	        vehiculos.add(new Bicicleta());
	        vehiculos.add(new Coche());

	        for (Vehiculo v : vehiculos) {
	            v.acelerar();
	        }
	}
}
