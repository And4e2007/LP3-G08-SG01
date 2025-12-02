package Observer;

public class TestObserver {
    public static void main(String[] args) {
        // Crear sistema de notificaciones
        SistemaNotificaciones sistema = new SistemaNotificaciones();
        
        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan Pérez", "juan@email.com");
        Usuario usuario2 = new Usuario("María García", "maria@email.com");
        Usuario usuario3 = new Usuario("Carlos López", "carlos@email.com");
        
        // Registrar usuarios al sistema
        sistema.registrarObserver(usuario1);
        sistema.registrarObserver(usuario2);
        sistema.registrarObserver(usuario3);
        
        System.out.println("=== SISTEMA DE NOTIFICACIONES ===");
        
        // Enviar notificaciones
        sistema.nuevaPromocion("50% de descuento en electrónicos");
        System.out.println();
        
        sistema.actualizacionProducto("iPhone 15 ahora disponible");
        System.out.println();
        
        // Remover un usuario y enviar otra notificación
        sistema.removerObserver(usuario2);
        sistema.nuevaPromocion("Envío gratis en compras mayores a $100");
    }
}
