package vista;
import java.util.List;
import modelo.Task;

public class TaskView {
	public void printTasks(List<Task> tasks) {
		for (Task task : tasks) {
			System.out.println(task.getName() + " - " + (task.isCompleted() ? "Completada" : "Pendiente"));
		}
	}
 
	public void printMessage(String message) {
		System.out.println(message);
	}
}