package Actividad03;

//Clase Motor
public class Motor_3 {
private String tipo;
private int potencia;

public Motor_3(String tipo, int potencia) {
   this.tipo = tipo;
   this.potencia = potencia;
}

// Getters y setters
public String getTipo() { return tipo; }
public void setTipo(String tipo) { this.tipo = tipo; }

public int getPotencia() { return potencia; }
public void setPotencia(int potencia) { this.potencia = potencia; }

@Override
public String toString() {
   return "Motor{tipo='" + tipo + "', potencia=" + potencia + " HP}";
}
}
