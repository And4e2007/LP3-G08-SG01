package Sistema_de_gestion_de_cursos_U;

public class Sistema_gestor {

	public static void main(String[] args) {
		 // Crear estudiantes
        Estudiante e1 = new Estudiante("Nicolas Calle", 20, 13.8);
        Estudiante e2 = new Estudiante("André Lazo", 22, 14.1);
        Estudiante e3 = new Estudiante("Sebastian Alvarez", 18, 13.0);
        Estudiante e4 = new Estudiante("Marcelo Mostajo", 23, 15.9);
        Estudiante e5 = new Estudiante("Brad Pitt", 25, 18.6);
        // Crear curso
        Curso cursoProgramacion = new Curso("Programación", 101, "Ana Torres", 40, 2500);
        Curso cursoMate = new Curso("Matemática", 102, "Luis Fernando", 50, 3000);
        
        // Inscribir estudiantes (agregación)
        cursoProgramacion.agregarEstudiante(e1);
        cursoProgramacion.agregarEstudiante(e2);
        cursoMate.agregarEstudiante(e3);
        cursoMate.agregarEstudiante(e4);

        // Mostrar información
        cursoProgramacion.mostrarInfo();

        // Polimorfismo
        Persona p1 = e5;
        Persona p2 = new Profesor("Carlos López", 45, 3000);

        System.out.println("\n--- Polimorfismo ---");
        p1.mostrarDatos(); // Llama versión de Estudiante
        p2.mostrarDatos(); // Llama versión de Profesor

        // Usar método de clase
        System.out.println("\nTotal de cursos creados: " + Curso.getTotalCursos());
        System.out.println("\nTotal de estudiantes inscritos: " + Curso.getTotalEstudiantes());
        
        //Usar método de instancia
        System.out.println("\nTotal de estudiantes en " + cursoMate.getNombre() + ": " + cursoMate.getTotalEstudiantesPorCurso());
    }
}
