package controlador;
import java.util.ArrayList;
import java.util.List;
import modelo.Task;
import vista.TaskView;

public class TaskController {
	private List<Task> tasks;
	private TaskView view;
	public TaskController(TaskView view) {
		this.view = view;
		this.tasks = new ArrayList<>();
	}
	
	public void addTask(String taskName) {
		Task task = new Task(taskName);
		tasks.add(task);
		view.printMessage("Tarea añadida: " + taskName);
	}
 
	public void completeTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			tasks.get(index).complete();
			view.printMessage("Tarea completada: " + tasks.get(index).getName());
		} else {
			view.printMessage("Índice de tarea inválido.");
		}
	}
 
	public void displayTasks() {
		view.printTasks(tasks);
	}
}
