package Observer;

public class Usuario implements Observer {
    private String nombre;
    private String email;
    
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    @Override
    public void update(String mensaje) {
        System.out.println("Usuario: " + nombre + " | Email: " + email + " | Notificación: " + mensaje);
    }
    
    public String getNombre() { 
        return nombre; 
    }
    
    public String getEmail() { 
        return email; 
    }
}