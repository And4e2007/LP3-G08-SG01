package Impresoras_E4;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
        ArrayList<Imprimible> impresoras = new ArrayList<>();
        impresoras.add(new Impresora());
        impresoras.add(new ImpresoraMultifuncional());

        System.out.println("=== Impresoras ===");
        for (Imprimible imp : impresoras) {
            imp.imprimir();
        }

        System.out.println("\n=== Escáneres ===");
        ArrayList<Escaneable> escaners = new ArrayList<>();
        escaners.add(new ImpresoraMultifuncional());

        for (Escaneable esc : escaners) {
            esc.escanear();
        }
    }
}
