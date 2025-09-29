package ACTIVIDAD1;

public class PruebaMetodoGenerico {

    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }

    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) {
        if (subindiceInferior < 0 || subindiceSuperior > arregloEntrada.length
                || subindiceInferior >= subindiceSuperior) {
            throw new InvalidSubscriptException("Índices inválidos.");
        }

        int count = 0;
        for (int i = subindiceInferior; i < subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            count++;
        }
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        Integer[] arregloInteger = { 1, 2, 3, 4, 5, 6 };
        Double[] arregloDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };

        System.out.println("Arreglo Integer:");
        imprimirArreglo(arregloInteger);

        System.out.println("Arreglo Double (índices 2 a 5):");
        imprimirArreglo(arregloDouble, 2, 5);

        System.out.println("Arreglo Character:");
        imprimirArreglo(arregloCharacter);

        // Forzamos excepción
        try {
            imprimirArreglo(arregloInteger, 5, 2);
        } catch (InvalidSubscriptException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}