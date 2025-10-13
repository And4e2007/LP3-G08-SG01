package Ejercicio_1_y_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GESTOR DE PERSONAJES MEJORADO ---");
        Gestor gestor = new Gestor();

        // Cargar personajes predeterminados si el archivo no existe o está vacío.
        gestor.cargarPersonajesPredeterminados();
        
        System.out.println("\n>> Estado inicial de los personajes:");
        gestor.mostrarPersonajesOrdenados("nivel", false); // Mostramos la lista inicial

        // Filtrar/Ordenar personajes por un atributo (ej: ataque descendente).
        System.out.println("\n>> Personajes ordenados por ATAQUE (de mayor a menor):");
        gestor.mostrarPersonajesOrdenados("ataque", false);

        // Actualizar un atributo individual (ej: la defensa del Caballero).
        System.out.println("\n>> Mejorando la defensa del Caballero a 6.");
        gestor.actualizarAtributo("Caballero", "defensa", 6);
        
        // Mejorar personaje subiendo de nivel (ej: el Arquero).
        System.out.println("\n>> El Arquero sube de nivel...");
        gestor.subirNivelPersonaje("Arquero");
        System.out.println(">> El Arquero sube de nivel otra vez...");
        gestor.subirNivelPersonaje("Arquero"); // Sube a nivel 3

        // Mostramos la lista para ver los cambios en el Caballero y el Arquero
        System.out.println("\n>> Lista actualizada con los cambios:");
        gestor.mostrarPersonajesOrdenados("nombre", true);

        // Mostrar estadísticas generales.
        System.out.println("\n>> Mostrando estadísticas finales del equipo:");
        gestor.mostrarEstadisticas();
        
        System.out.println("\n>> Proceso finalizado. Revisa 'personajes.txt' para ver el estado guardado.");
    }
}