package Ejercicio3;

public class main {
    public static void main(String[] args) {
        EmpleadoView vista = new EmpleadoView();
        EmpleadoModel modelo = new EmpleadoModel();
        EmpleadoController controlador = new EmpleadoController(vista, modelo);

        controlador.iniciarGestor();
    }
}
