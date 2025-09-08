package Actividad04;

class ImpresoraBasica_4 implements DispositivoImpresion_4 {
    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo: " + documento);
    }

    @Override
    public void escanear(String documento) {
        throw new UnsupportedOperationException("La impresora básica no puede escanear.");
    }

    @Override
    public void enviarFax(String documento) {
        throw new UnsupportedOperationException("La impresora básica no puede enviar fax.");
    }
}
