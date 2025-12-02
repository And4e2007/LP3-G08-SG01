package Command;

public class ComandoBajarVolumen implements Comando {
    private Televisor televisor;
    
    public ComandoBajarVolumen(Televisor televisor) {
        this.televisor = televisor;
    }
    
    @Override
    public void ejecutar() {
        televisor.bajarVolumen();
    }
    
    @Override
    public void deshacer() {
        televisor.subirVolumen();
    }
}