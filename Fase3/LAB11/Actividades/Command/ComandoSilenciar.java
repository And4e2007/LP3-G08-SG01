package Command;

public class ComandoSilenciar implements Comando {
    private Televisor televisor;
    
    public ComandoSilenciar(Televisor televisor) {
        this.televisor = televisor;
    }
    
    @Override
    public void ejecutar() {
        televisor.silenciar();
    }
    
    @Override
    public void deshacer() {
        televisor.silenciar(); // Toggle
    }
}