package Ejercicio_1_y_2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Gestor {
    // Usamos un Mapa para acceder fácilmente a los personajes por su nombre
    private Map<String, Personaje> personajes;
    private final String nombreArchivo = "personajes.txt";

    public Gestor() {
        this.personajes = new HashMap<>();
        cargarPersonajes(); // Carga los datos del archivo al crear el gestor
    }

    public void cargarPersonajesPredeterminados() {
        if (personajes.isEmpty()) {
            System.out.println("No se encontraron personajes guardados. Cargando personajes predeterminados...");
            try {
                anadirPersonaje(new Personaje("Caballero", 4, 2, 4, 2, 1));
                anadirPersonaje(new Personaje("Guerrero", 2, 4, 2, 4, 1));
                anadirPersonaje(new Personaje("Arquero", 2, 4, 1, 8, 1));
            } catch (IllegalArgumentException e) {
                // Manejar error si los datos predeterminados fueran inválidos
                System.err.println("Error en datos predefinidos: " + e.getMessage());
            }
        }
    }
    
    public void mostrarPersonajesOrdenados(String atributo, boolean ascendente) {
        Comparator<Personaje> comparator;
        switch (atributo.toLowerCase()) {
            case "vida":
                comparator = Comparator.comparingInt(Personaje::getVida);
                break;
            case "ataque":
                comparator = Comparator.comparingInt(Personaje::getAtaque);
                break;
            case "defensa":
                comparator = Comparator.comparingInt(Personaje::getDefensa);
                break;
            case "alcance":
                comparator = Comparator.comparingInt(Personaje::getAlcance);
                break;
            case "nivel":
                comparator = Comparator.comparingInt(Personaje::getNivel);
                break;
            default:
                System.out.println("Atributo '" + atributo + "' no válido para ordenar.");
                return;
        }

        if (!ascendente) {
            comparator = comparator.reversed();
        }

        List<Personaje> listaOrdenada = personajes.values().stream().sorted(comparator).collect(Collectors.toList());

        System.out.println("\n--- LISTA ORDENADA POR '" + atributo.toUpperCase() + "' (" + (ascendente ? "Ascendente" : "Descendente") + ") ---");
        System.out.println(String.format("%-15s | %-5s | %-7s | %-7s | %-7s | %-5s", "Nombre", "Vida", "Ataque", "Defensa", "Alcance", "Nivel"));
        System.out.println("-------------------------------------------------------------------");
        for (Personaje p : listaOrdenada) {
            System.out.println(String.format("%-15s | %-5d | %-7d | %-7d | %-7d | %-5d",
                p.getNombre(), p.getVida(), p.getAtaque(), p.getDefensa(), p.getAlcance(), p.getNivel()));
        }
        System.out.println("-------------------------------------------------------------------");
    }
    
    public void actualizarAtributo(String nombre, String atributo, int nuevoValor) {
        Personaje personaje = personajes.get(nombre);
        if (personaje == null) {
            System.out.println("Error: No se encontró el personaje '" + nombre + "'.");
            return;
        }
        try {
            switch (atributo.toLowerCase()) {
                case "vida": personaje.setVida(nuevoValor); break;
                case "ataque": personaje.setAtaque(nuevoValor); break;
                case "defensa": personaje.setDefensa(nuevoValor); break;
                case "alcance": personaje.setAlcance(nuevoValor); break;
                default:
                    System.out.println("Atributo '" + atributo + "' no es válido para actualizar.");
                    return; // No guardamos si el atributo es incorrecto
            }
            System.out.println("Atributo '" + atributo + "' de '" + nombre + "' actualizado a " + nuevoValor + ".");
            guardarPersonajes(); // Guardado automático
        } catch (IllegalArgumentException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
    
    public void subirNivelPersonaje(String nombre) {
        Personaje personaje = personajes.get(nombre);
        if (personaje != null) {
            personaje.subirDeNivel();
            guardarPersonajes(); // Guardamos los nuevos stats
        } else {
            System.out.println("Error: No se encontró el personaje '" + nombre + "'.");
        }
    }
    
    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("\nNo hay personajes para calcular estadísticas.");
            return;
        }
        int totalPersonajes = personajes.size();
        double sumaVida = 0, sumaAtaque = 0, sumaDefensa = 0, sumaAlcance = 0;

        for (Personaje p : personajes.values()) {
            sumaVida += p.getVida();
            sumaAtaque += p.getAtaque();
            sumaDefensa += p.getDefensa();
            sumaAlcance += p.getAlcance();
        }

        System.out.println("\n--- ESTADÍSTICAS GENERALES ---");
        System.out.println("Total de Personajes: " + totalPersonajes);
        System.out.println(String.format("Vida Promedio:      %.2f", sumaVida / totalPersonajes));
        System.out.println(String.format("Ataque Promedio:    %.2f", sumaAtaque / totalPersonajes));
        System.out.println(String.format("Defensa Promedio:   %.2f", sumaDefensa / totalPersonajes));
        System.out.println(String.format("Alcance Promedio:   %.2f", sumaAlcance / totalPersonajes));
        System.out.println("------------------------------");
    }
    
    /**
     * Añade un nuevo personaje al gestor.
     * No se añade si ya existe uno con el mismo nombre.
     * Guarda los cambios automáticamente.
     */
    public void anadirPersonaje(Personaje personaje) {
        if (personajes.containsKey(personaje.getNombre())) {
            System.out.println("Error: Ya existe un personaje con el nombre '" + personaje.getNombre() + "'. No se ha añadido.");
        } else {
            personajes.put(personaje.getNombre(), personaje);
            System.out.println("Personaje '" + personaje.getNombre() + "' añadido con éxito.");
            guardarPersonajes(); // Guardado automático
        }
    }

    /**
     * Muestra todos los personajes actuales en un formato de tabla.
     */
    public void mostrarPersonajes() {
        System.out.println("\n--- LISTA DE PERSONAJES ---");
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes para mostrar.");
            return;
        }
        System.out.println(String.format("%-15s | %-5s | %-7s | %-7s | %-7s", "Nombre", "Vida", "Ataque", "Defensa", "Alcance"));
        System.out.println("----------------------------------------------------------");
        for (Personaje p : personajes.values()) {
            System.out.println(String.format("%-15s | %-5d | %-7d | %-7d | %-7d",
                p.getNombre(), p.getVida(), p.getAtaque(), p.getDefensa(), p.getAlcance()));
        }
        System.out.println("----------------------------------------------------------");
    }

    /**
     * Modifica las estadísticas de un personaje existente, buscándolo por su nombre.
     * Guarda los cambios automáticamente.
     */
    public void modificarPersonaje(String nombre, int nuevaVida, int nuevoAtaque, int nuevaDefensa, int nuevoAlcance) {
        Personaje personaje = personajes.get(nombre);
        if (personaje != null) {
            try {
                // Intentamos modificar los valores
                personaje.setVida(nuevaVida);
                personaje.setAtaque(nuevoAtaque);
                personaje.setDefensa(nuevaDefensa);
                personaje.setAlcance(nuevoAlcance);

                // Si todo sale bien, guardamos
                System.out.println("Personaje '" + nombre + "' modificado con éxito.");
                guardarPersonajes();
            } catch (IllegalArgumentException e) {
                // Si algún valor es inválido, capturamos la excepción y no guardamos nada
                System.out.println("Error al modificar a '" + nombre + "': " + e.getMessage());
                System.out.println("Los cambios no han sido guardados.");
            }
        } else {
            System.out.println("Error: No se encontró ningún personaje con el nombre '" + nombre + "'.");
        }
    }

    /**
     * Borra un personaje del gestor, buscándolo por su nombre.
     * Guarda los cambios automáticamente.
     */
    public void borrarPersonaje(String nombre) {
        if (personajes.remove(nombre) != null) {
            System.out.println("Personaje '" + nombre + "' borrado con éxito.");
            guardarPersonajes(); // Guardado automático
        } else {
            System.out.println("Error: No se encontró ningún personaje con el nombre '" + nombre + "' para borrar.");
        }
    }

    /**
     * Lee el archivo de texto y carga los personajes en el mapa.
     * Se ejecuta al iniciar el gestor.
     */
    private void cargarPersonajes() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) { // Debe tener 6 campos 
                    try {
                        String nombre = datos[0];
                        int vida = Integer.parseInt(datos[1]);
                        int ataque = Integer.parseInt(datos[2]);
                        int defensa = Integer.parseInt(datos[3]);
                        int alcance = Integer.parseInt(datos[4]);
                        int nivel = Integer.parseInt(datos[5]); // Cargar nivel
                        personajes.put(nombre, new Personaje(nombre, vida, ataque, defensa, alcance, nivel));
                    } catch (Exception e) {
                        System.err.println("Advertencia: Se omitió una línea del archivo por datos inválidos. (" + e.getMessage() + ")");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // No es un error, el archivo se creará después
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Guarda todos los personajes del mapa en el archivo de texto,
     * sobrescribiendo el contenido anterior.
     */
    private void guardarPersonajes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Personaje personaje : personajes.values()) {
                bw.write(personaje.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }
}