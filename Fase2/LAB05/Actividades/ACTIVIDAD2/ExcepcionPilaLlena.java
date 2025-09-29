package ACTIVIDAD2;

public class ExcepcionPilaLlena extends RuntimeException {
    public ExcepcionPilaLlena(String mensaje) {
        super(mensaje);
    }

    public static void main(String[] args) {
        try {
            throw new ExcepcionPilaLlena("Pila llena!");
        } catch (ExcepcionPilaLlena e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}
