package Command;

public class ComandoCambiarCanal implements Comando {
    private Televisor televisor;
    private int canalAnterior;
    private int nuevoCanal;
    
    public ComandoCambiarCanal(Televisor televisor, int canal) {
        this.televisor = televisor;
        this.nuevoCanal = canal;
        this.canalAnterior = televisor.getCanal();
    }
    
    @Override
    public void ejecutar() {
        canalAnterior = televisor.getCanal();
        televisor.cambiarCanal(nuevoCanal);
    }
    
    @Override
    public void deshacer() {
        televisor.cambiarCanal(canalAnterior);
    }
}