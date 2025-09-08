package Actividad04;

class ImpresoraBasicaRefactor_4 implements Impresora_4 {
    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo en impresora básica: " + documento);
    }
}
