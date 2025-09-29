package ACTIVIDAD1;

public class InvalidSubscriptException extends RuntimeException {
    public InvalidSubscriptException(String mensaje) {
        super(mensaje);
    }

    public static void main(String[] args) {
        // Prueba de excepción
        try {
            throw new InvalidSubscriptException("Índice fuera de rango!");
        } catch (InvalidSubscriptException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}
