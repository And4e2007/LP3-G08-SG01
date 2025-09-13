package GestionNumerosNegativos_E3;

public class Main {

	public static void main(String[] args) {
		Numero num = new Numero();
		num.setValor(-8);
		
		try {
			System.out.println("El valor es: " + num.getValor());
		}catch(IllegalArgumentException e){
			System.out.println("Error de argumento: " + e.getMessage());
		}catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
        	System.out.println("Programa finalizado.");
        }
	}

}
