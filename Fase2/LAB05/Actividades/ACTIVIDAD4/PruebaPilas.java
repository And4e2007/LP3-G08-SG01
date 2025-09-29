package ACTIVIDAD4;

public class PruebaPilas {
    public static void main(String[] args) {
        Pila<Integer> pila1 = new Pila<>(5);
        Pila<Integer> pila2 = new Pila<>(5);

        pila1.push(1);
        pila1.push(2);
        pila1.push(3);

        pila2.push(1);
        pila2.push(2);
        pila2.push(3);

        System.out.println("¿Las pilas son iguales? " + pila1.esIgual(pila2));

        pila2.push(4);
        System.out.println("¿Las pilas son iguales después de agregar un elemento? " + pila1.esIgual(pila2));

        System.out.println("¿Pila1 contiene el número 2? " + pila1.contains(2));
        System.out.println("¿Pila1 contiene el número 99? " + pila1.contains(99));
    }
}

