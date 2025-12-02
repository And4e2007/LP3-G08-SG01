package Command;

public class ComandoApagar implements Comando {
    private Televisor televisor;
    
    public ComandoApagar(Televisor televisor) {
        this.televisor = televisor;
    }
    
    @Override
    public void ejecutar() {
        televisor.apagar();
    }
    
    @Override
    public void deshacer() {
        televisor.encender();
    }
}