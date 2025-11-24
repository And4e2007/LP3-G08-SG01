package Ejercicio4;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame {

    private JButton btnPlay;
    private JButton btnPause;
    private JButton btnResume;

    private Clip clip;                 // Reproductor
    private long pausePosition = 0;    // Guarda la posición donde se pausó

    public Interfaz() {
        super("Reproductor de Música");

        // --- CONFIGURACIÓN DE PANTALLA ---
        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 3, 10, 10));

        btnPlay = new JButton("Reproducir");
        btnPause = new JButton("Pausar");
        btnResume = new JButton("Reanudar");

        panelBotones.add(btnPlay);
        panelBotones.add(btnPause);
        panelBotones.add(btnResume);

        add(panelBotones, BorderLayout.CENTER);

        cargarAudio("Jarabe_de_Palo_-_La_flaca.wav"); // Cambia el nombre a tu archivo real

        // --- EVENTOS ---
        btnPlay.addActionListener(e -> reproducir());
        btnPause.addActionListener(e -> pausar());
        btnResume.addActionListener(e -> reanudar());
    }

    // ---------------- METODOS PRINCIPALES ----------------

    private void cargarAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            clip = AudioSystem.getClip();
            clip.open(audioStream);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el audio");
            e.printStackTrace();
        }
    }

    private void reproducir() {
        if (clip == null) return;

        clip.stop();
        clip.setMicrosecondPosition(0); // Desde el inicio
        pausePosition = 0;
        clip.start();
    }

    private void pausar() {
        if (clip != null && clip.isActive()) {
            pausePosition = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    private void reanudar() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(pausePosition);
            clip.start();
        }
    }
}
