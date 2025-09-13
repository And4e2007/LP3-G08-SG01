package LeerEntrada_E1;

import java.io.IOException;
import java.util.Scanner;

public class LeerEntrada {
    private Scanner scanner;

    public LeerEntrada() {
        scanner = new Scanner(System.in);
    }

    public char getChar() throws IOException {
        String input = scanner.nextLine(); // lee la línea completa
        if (input.isEmpty()) {
            return ' '; // si el usuario solo da Enter, devolvemos un espacio
        }
        return input.charAt(0); // devolvemos solo el primer carácter
    }

    public void procesar() throws IOException, VocalException, NumeroException, BlancoException, SalidaException {
        char c = getChar();

        if ("aeiouAEIOU".indexOf(c) != -1) {
            throw new VocalException("Se ingresó una vocal: " + c);
        }
        if (Character.isDigit(c)) {
            throw new NumeroException("Se ingresó un número: " + c);
        }
        if (Character.isWhitespace(c)) {
            throw new BlancoException("Se ingresó un espacio en blanco (incluido Enter).");
        }
        if (c == 'x' || c == 'X') {
            throw new SalidaException("Se ingresó el carácter de salida. Finalizando programa...");
        }

        System.out.println("Carácter válido ingresado: " + c);
    }

    public static void main(String[] args) {
        LeerEntrada lector = new LeerEntrada();

        while (true) {
            try {
                System.out.print("Ingrese un carácter: ");
                lector.procesar();
            } catch (VocalException | NumeroException | BlancoException e) {
                System.out.println(e.getMessage());
            } catch (SalidaException e) {
                System.out.println(e.getMessage());
                break;
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            }
        }
    }
}

