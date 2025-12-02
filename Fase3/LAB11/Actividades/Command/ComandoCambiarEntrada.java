package Command;

public class ComandoCambiarEntrada implements Comando {
    private Televisor televisor;
    private String entradaAnterior;
    private String nuevaEntrada;
    
    public ComandoCambiarEntrada(Televisor televisor, String entrada) {
        this.televisor = televisor;
        this.nuevaEntrada = entrada;
        this.entradaAnterior = televisor.getEntrada();
    }
    
    @Override
    public void ejecutar() {
        entradaAnterior = televisor.getEntrada();
        televisor.cambiarEntrada(nuevaEntrada);
    }
    
    @Override
    public void deshacer() {
        televisor.cambiarEntrada(entradaAnterior);
    }
}