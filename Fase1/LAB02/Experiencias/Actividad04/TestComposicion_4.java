package Actividad04;

public class TestComposicion_4 {
    public static void main(String[] args) {
        Persona_4 p1 = new Persona_4("Juan Pérez", "001", 1000);
        Persona_4 p2 = new Persona_4("María López", "002", 500);

        p1.depositar(200);
        p2.retirar(100);

        System.out.println(p1);
        System.out.println(p2);
    }
}
