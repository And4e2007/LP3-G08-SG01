package Ejercicio3;
import java.util.Map;

public class EmpleadoController {
	private EmpleadoView view;
	private EmpleadoModel model;

	public EmpleadoController(EmpleadoView view, EmpleadoModel model) {
		this.view = view;
		this.model = model;
	}
	
	public void iniciarGestor() {
		int opc = 0;
		while(opc != 5) {
			opc = view.mostrarMenu();
			if(opc == 1) {
				leerEmpleados();
			}
			else if(opc == 2) {
				crearEmpleado(model.cargarEmpleados());
			}
			else if(opc == 3) {
				buscarEmpleado(model.cargarEmpleados());
			}
			else if(opc == 4) {
				eliminarEmpleado(model.cargarEmpleados());
			}
			else if(opc == 5) {
				view.mostrarMensaje("Saliendo...");
				break;
			}
			else if(opc<0 || opc>5) {
				view.mostrarMensaje("Opción fuera de rango.");
			}
		}
	}
	
	public void leerEmpleados() {
		view.mostrarEmpleados(model.cargarEmpleados());
	}
	
	public void crearEmpleado(Map<Integer, Empleado> empleados) {
		Empleado nuevo = new Empleado(view.pedirNumero(), view.pedirNombre(), view.pedirSalario());
		if (empleados.containsKey(nuevo.getNumero())) {
			view.mostrarMensaje("Error: Ya existe un empleado con ese numero, no se añadio");
        }else {
            empleados.put(nuevo.getNumero(), nuevo);
            model.guardarEmpleados(empleados); // Guardado automático
            view.mostrarMensaje("Empleado " + nuevo.getNombre() + " añadido con éxito.");
        }
	}
	
	public void buscarEmpleado(Map<Integer, Empleado> empleados) {
		int numero = view.pedirNumero();
		Empleado empleado = empleados.get(numero);
		if (empleado != null) {
			view.mostrarMensaje("Información del empleado: " + empleado);
        } else {
           view.mostrarMensaje("Error: No se encontró ningún empleado con el numero " + numero);
        }
	}
	
	public void eliminarEmpleado(Map<Integer, Empleado> empleados) {
		int numero = view.pedirNumero();
		if (empleados.remove(numero) != null) {
			view.mostrarMensaje("Empleado " + numero + " borrado con éxito.");
            model.guardarEmpleados(empleados); // Guardado automático
        } else {
        	view.mostrarMensaje("Error: No se encontró ningún empleado con el numero" + numero + " para borrar.");
        }
	}
}
