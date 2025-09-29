package ACTIVIDAD3;

public class IgualGenerico {

    public static <T> boolean esIgualA(T a, T b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.equals(b);
    }

    public static void main(String[] args) {
        System.out.println("Comparando enteros: " + esIgualA(5, 5));
        System.out.println("Comparando String: " + esIgualA("Hola", "Hola"));
        System.out.println("Comparando null y objeto: " + esIgualA(null, "Texto"));
        System.out.println("Comparando null y null: " + esIgualA(null, null));
        System.out.println("Comparando Integer y String: " + esIgualA(10, (Object) "10"));
    }
}
