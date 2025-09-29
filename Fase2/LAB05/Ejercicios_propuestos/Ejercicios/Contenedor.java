package Ejercicios;
import java.util.ArrayList;

public class Contenedor <F, S>{
	 private ArrayList<Par<F, S>> listaPares;

	 public Contenedor() {
	        listaPares = new ArrayList<>();
	 }
	 
	// Agregar un nuevo par
	  public void agregarPar(F primero, S segundo) {
	      listaPares.add(new Par<>(primero, segundo));
	  }

	// Obtener par por índice
	  public Par<F, S> obtenerPar(int indice) {
	      if (indice >= 0 && indice < listaPares.size()) {
	          return listaPares.get(indice);
	      } else {
	          throw new IndexOutOfBoundsException("Índice fuera de rango");
	      }
	  }

	  // Obtener todos los pares
	  public ArrayList<Par<F, S>> obtenerTodosLosPares() {
		  return listaPares;
	  }

	  // Mostrar todos los pares
	  public void mostrarPares() {
		  for (Par<F, S> par : listaPares) {
			  System.out.println(par);
	      }
	  }
}
