package Actividad03;

public class TestAgregacion_3 {
    public static void main(String[] args) {
        Motor_3 motor1 = new Motor_3("Gasolina", 150);
        Motor_3 motor2 = new Motor_3("Eléctrico", 300);

        Automovil_3 auto1 = new Automovil_3("Toyota", "Corolla", motor1);
        Automovil_3 auto2 = new Automovil_3("Tesla", "Model 3", motor2);

        System.out.println(auto1);
        System.out.println(auto2);
    }
}