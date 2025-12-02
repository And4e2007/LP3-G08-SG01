package Command;

public class Televisor {
    private boolean encendido;
    private int volumen;
    private int canal;
    private String entrada;
    private boolean mute;
    private int volumenAntesMute;
    
    public Televisor() {
        this.encendido = false;
        this.volumen = 50;
        this.canal = 1;
        this.entrada = "HDMI1";
        this.mute = false;
    }
    
    public void encender() {
        this.encendido = true;
        System.out.println("Televisor encendido");
    }
    
    public void apagar() {
        this.encendido = false;
        System.out.println("Televisor apagado");
    }
    
    public void subirVolumen() {
        if (encendido && volumen < 100) {
            volumen++;
            System.out.println("Volumen: " + volumen);
        }
    }
    
    public void bajarVolumen() {
        if (encendido && volumen > 0) {
            volumen--;
            System.out.println("Volumen: " + volumen);
        }
    }
    
    public void cambiarCanal(int nuevoCanal) {
        if (encendido) {
            this.canal = nuevoCanal;
            System.out.println("Canal cambiado a: " + canal);
        }
    }
    
    public void silenciar() {
        if (encendido) {
            if (!mute) {
                volumenAntesMute = volumen;
                volumen = 0;
                mute = true;
                System.out.println("Televisor silenciado");
            } else {
                volumen = volumenAntesMute;
                mute = false;
                System.out.println("Sonido activado. Volumen: " + volumen);
            }
        }
    }
    
    public void cambiarEntrada(String nuevaEntrada) {
        if (encendido) {
            this.entrada = nuevaEntrada;
            System.out.println("Entrada cambiada a: " + entrada);
        }
    }
    
    public boolean isEncendido() { 
        return encendido; 
    }
    
    public int getVolumen() { 
        return volumen; 
    }
    
    public int getCanal() { 
        return canal; 
    }
    
    public String getEntrada() { 
        return entrada; 
    }
    
    public boolean isMute() { 
        return mute; 
    }
}