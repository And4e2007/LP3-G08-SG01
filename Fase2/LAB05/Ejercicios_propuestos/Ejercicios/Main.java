package Ejercicios;

public class Main {
	public static <F, S> void imprimirPar(Par<F, S> par) {
		System.out.println(par);
	}
	
	public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Texto", 123);
        Par<Double, Boolean> par2 = new Par<>(3.14, true);
        
        // Uso del método imprimirPar
        imprimirPar(par1);
        imprimirPar(par2);
        
        //Testeamos el contenedor
        Contenedor<String, Integer> contenedor = new Contenedor<>();

        contenedor.agregarPar("Uno", 1);
        contenedor.agregarPar("Dos", 2);
        contenedor.agregarPar("Tres", 3);

        System.out.println("Mostrando pares en el contenedor:");
        contenedor.mostrarPares();

        System.out.println("Par en índice 1: " + contenedor.obtenerPar(1));
    }
}
