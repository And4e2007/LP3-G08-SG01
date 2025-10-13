package Actividad4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VisualizarArchivo {

    public static void main(String[] args) {
        try (FileInputStream file = new FileInputStream("src/archivos/TestFile.java")) {
            byte[] b = new byte[1024];
            int bytesLeidos = file.read(b); // cantidad real de bytes leídos
            String contenido = new String(b, 0, bytesLeidos);

            // Crear ventana y mostrar contenido
            ViewFile view = new ViewFile(contenido);
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.setSize(400, 200);
            view.setVisible(true);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
    }
}

// Clase interna para mostrar el contenido
class ViewFile extends JFrame {
    private JTextArea areaTexto;

    public ViewFile(String contenido) {
        super("Mostrando el contenido de un archivo");
        areaTexto = new JTextArea(10, 40);
        areaTexto.setText(contenido);
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll);
    }
}
