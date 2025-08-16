package Experiencias;

import java.util.Scanner;

public class Palindromo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce un número entero: ");
		int numero = scanner.nextInt();
		int original = numero;
		int inverso = 0;
		scanner.close();
		
		while(numero != 0) {
			inverso = inverso * 10 + (numero % 10);
			numero /=10;
		}
		
		if(original == inverso) {
			System.out.println(original + " es un palindromo.");
		}
		else {
			System.out.println(original + " no es un palindromo.");
		}
	}
}