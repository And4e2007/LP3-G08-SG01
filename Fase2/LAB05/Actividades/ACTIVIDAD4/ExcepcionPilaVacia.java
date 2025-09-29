package ACTIVIDAD4;

public class ExcepcionPilaVacia extends RuntimeException {
    public ExcepcionPilaVacia(String mensaje) {
        super(mensaje);
    }

    public static void main(String[] args) {
        try {
            throw new ExcepcionPilaVacia("Pila vacía!");
        } catch (ExcepcionPilaVacia e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}