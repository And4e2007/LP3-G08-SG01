package Command;

public class ComandoEncender implements Comando {
    private Televisor televisor;
    
    public ComandoEncender(Televisor televisor) {
        this.televisor = televisor;
    }
    
    @Override
    public void ejecutar() {
        televisor.encender();
    }
    
    @Override
    public void deshacer() {
        televisor.apagar();
    }
}
