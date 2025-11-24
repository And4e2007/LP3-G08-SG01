package Ejercicio3;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interfaz extends JFrame{
	private JButton aplausos;
	private JButton campana;
	private JButton explosion;
	
	public Interfaz() {
		super("Reproductor de audios");
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		aplausos = new JButton("Aplausos");
		campana = new JButton("Campana");
		explosion = new JButton("Explosión");
		
		// Ajustar tamaño máximo para que ocupen todo el ancho
        aplausos.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 50));
        campana.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 50));
        explosion.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 50));
		
        // Centrado del texto dentro del botón
        aplausos.setAlignmentX(CENTER_ALIGNMENT);
        campana.setAlignmentX(CENTER_ALIGNMENT);
        explosion.setAlignmentX(CENTER_ALIGNMENT);
        
        // Agregar botones al panel
        panelPrincipal.add(Box.createVerticalStrut(20));
        panelPrincipal.add(aplausos);
        panelPrincipal.add(Box.createVerticalStrut(15));
        panelPrincipal.add(campana);
        panelPrincipal.add(Box.createVerticalStrut(15));
        panelPrincipal.add(explosion);
        panelPrincipal.add(Box.createVerticalStrut(20));

		
		add(panelPrincipal);
		
		aplausos.addActionListener(e -> playAudio("aplausos-1.wav"));
		campana.addActionListener(e -> playAudio("bells-2.wav"));
		explosion.addActionListener(e -> playAudio("explosion-3.wav"));	
	}
	
	public static void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);

            // Validar existencia real del archivo
            if (!audioFile.exists()) {
                JOptionPane.showMessageDialog(null, 
                    "No se encontró el archivo:\n" + audioFile.getAbsolutePath(),
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null,
                "Error al reproducir el audio:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
