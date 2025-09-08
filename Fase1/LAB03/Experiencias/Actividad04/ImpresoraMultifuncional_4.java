package Actividad04;

class ImpresoraMultifuncional_4 implements Impresora_4, Escaner_4, Fax_4 {
    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo en multifuncional: " + documento);
    }

    @Override
    public void escanear(String documento) {
        System.out.println("Escaneando: " + documento);
    }

    @Override
    public void enviarFax(String documento) {
        System.out.println("Enviando fax: " + documento);
    }
}