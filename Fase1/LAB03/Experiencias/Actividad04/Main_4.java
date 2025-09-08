package Actividad04;

public class Main_4 {
    public static void main(String[] args) {
    	String doc = "DOC Z";
        Impresora_4 impresoraBasica = new ImpresoraBasicaRefactor_4();
        impresoraBasica.imprimir("Documento A");
        impresoraBasica.imprimir(doc);

        ImpresoraMultifuncional_4 multifuncional = new ImpresoraMultifuncional_4();
        multifuncional.imprimir("Documento B");
        multifuncional.escanear("Documento C");
        multifuncional.enviarFax("Documento D");
        multifuncional.imprimir(doc);
    }
}

