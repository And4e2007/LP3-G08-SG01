package Formas_E2;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Forma> formas = new ArrayList<>();
        formas.add(new Circulo());
        formas.add(new Rectangulo());
        formas.add(new Triangulo());
        
        for (Forma f : formas) {
            f.Dibujar();
        }
	}
}
