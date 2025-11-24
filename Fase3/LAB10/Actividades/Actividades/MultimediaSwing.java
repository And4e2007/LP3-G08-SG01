package Actividades;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.sound.sampled.*;

public class MultimediaSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Multimedia en Swing");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new MultimediaPanel());
            f.setSize(600,500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}

class MultimediaPanel extends JPanel {
    private JLabel lblImagen;
    private BufferedImage imagen;
    private Clip clip;

    public MultimediaPanel(){
        setLayout(new BorderLayout());
        lblImagen=new JLabel("Sin imagen",SwingConstants.CENTER);
        add(lblImagen,BorderLayout.CENTER);

        JPanel botones=new JPanel();
        JButton play=new JButton("Play");
        JButton pause=new JButton("Pause");
        JButton stop=new JButton("Stop");
        botones.add(play); botones.add(pause); botones.add(stop);
        add(botones,BorderLayout.SOUTH);

        try{
            File img=new File("C:\\Users\\NICOLAS\\Downloads\\patrick.gif");
            if(img.exists()){
                imagen=ImageIO.read(img);
                lblImagen.setIcon(new ImageIcon(imagen.getScaledInstance(400,-1,Image.SCALE_SMOOTH)));
                lblImagen.setText("");
            }
        }catch(Exception e){lblImagen.setText("Error cargando imagen");}

        try{
            File audio=new File("audio.wav");
            if(audio.exists()){
                AudioInputStream ais=AudioSystem.getAudioInputStream(audio);
                clip=AudioSystem.getClip();
                clip.open(ais);
            }
        }catch(Exception e){System.out.println("Error audio: "+e.getMessage());}

        play.addActionListener(e->{ if(clip!=null){clip.setFramePosition(0); clip.start();}});
        pause.addActionListener(e->{ if(clip!=null){clip.stop();}});
        stop.addActionListener(e->{ if(clip!=null){clip.stop(); clip.setFramePosition(0); }});
    }
}

