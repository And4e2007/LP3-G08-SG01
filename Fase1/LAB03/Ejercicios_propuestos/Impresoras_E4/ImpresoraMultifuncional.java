package Impresoras_E4;

public class ImpresoraMultifuncional implements Imprimible, Escaneable{
	 @Override
	    public void imprimir() {
	        System.out.println("Imprimiendo documento en la multifuncional.");
	    }

	    @Override
	    public void escanear() {
	        System.out.println("Escaneando documento en la multifuncional.");
	    }
}
