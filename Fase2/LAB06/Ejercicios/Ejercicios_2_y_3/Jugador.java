package Ejercicios_2_y_3;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item equipado; // arma equipada

    public Jugador(String nombre, int salud, int nivel, InventarioModel inventario) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = inventario;
    }

    public void equiparItem(String nombreItem) {
        Item item = inventario.buscarItem(nombreItem);
        if (item != null) {
            equipado = item;
            System.out.println(nombre + " ha equipado " + item.getNombre());
        } else {
            System.out.println("El item no está en el inventario.");
        }
    }

    public void atacar(Enemigo enemigo) {
        if (equipado == null) {
            System.out.println(nombre + " no tiene ningún arma equipada.");
            return;
        }

        int daño = 10; // daño base
        if (equipado.getTipo().equalsIgnoreCase("Arma")) {
            daño += 10; // bonus por usar arma
        }
        System.out.println(nombre + " ataca a " + enemigo.getNombre() + " con " + equipado.getNombre() + " causando " + daño + " de daño.");
        enemigo.recibirDaño(daño);
    }

    public void usarObjeto(String nombreItem) {
        Item item = inventario.buscarItem(nombreItem);
        if (item != null && item.getTipo().equalsIgnoreCase("Poción")) {
            salud += 20;
            item.usarItem();
            System.out.println(nombre + " usa " + item.getNombre() + " y recupera salud.");
        } else {
            System.out.println("No se puede usar este objeto.");
        }
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
        System.out.println(nombre + " recibe " + daño + " de daño. Salud restante: " + salud);
    }

    public int getSalud() { return salud; }
    public String getNombre() { return nombre; }
    public boolean estaVivo() { return salud > 0; }
}
