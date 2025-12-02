package Command;

public class ComandoSubirVolumen implements Comando {
    private Televisor televisor;
    
    public ComandoSubirVolumen(Televisor televisor) {
        this.televisor = televisor;
    }
    
    @Override
    public void ejecutar() {
        televisor.subirVolumen();
    }
    
    @Override
    public void deshacer() {
        televisor.bajarVolumen();
    }
}