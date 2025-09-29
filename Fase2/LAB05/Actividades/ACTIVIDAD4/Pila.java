package ACTIVIDAD4;

public class Pila<E> {
    private final int tamanio;
    private int superior;
    private E[] elementos;

    @SuppressWarnings("unchecked")
    public Pila(int s) {
        tamanio = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamanio];
    }

    public Pila() {
        this(10);
    }

    public void push(E valor) {
        if (superior == tamanio - 1) {
            throw new ExcepcionPilaLlena("La pila está llena, no se puede agregar: " + valor);
        }
        elementos[++superior] = valor;
    }

    public E pop() {
        if (superior == -1) {
            throw new ExcepcionPilaVacia("La pila está vacía, no se puede extraer.");
        }
        return elementos[superior--];
    }

    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public boolean esIgual(Pila<E> otraPila) {
        if (this.superior != otraPila.superior) {
            return false;
        }
        for (int i = 0; i <= superior; i++) {
            if (!this.elementos[i].equals(otraPila.elementos[i])) {
                return false;
            }
        }
        return true;
    }

    public void mostrar() {
        for (int i = superior; i >= 0; i--) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>(3);
        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println("Elementos en la pila:");
        pila.mostrar();

        System.out.println("¿Contiene 20? " + pila.contains(20));
        System.out.println("¿Contiene 99? " + pila.contains(99));

        System.out.println("Sacando elemento: " + pila.pop());
        pila.mostrar();
    }
}
