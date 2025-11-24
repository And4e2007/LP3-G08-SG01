package Actividades;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class GraficosSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Gráficos en Swing");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new GraficosPanel());
            f.setSize(900,650);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}

class GraficosPanel extends JPanel {
    public GraficosPanel() {
        setLayout(new GridLayout(2,1));
        add(new GraficoBarrasPanel(sampleBarData()));
        add(new GraficoLineasPanel(sampleLineData()));
    }

    private Map<String,Integer> sampleBarData() {
        Map<String,Integer> m = new LinkedHashMap<>();
        m.put("Ene", 50); m.put("Feb", 75); m.put("Mar", 40); m.put("Abr", 90); m.put("May", 60);
        return m;
    }

    private java.util.List<Point2D.Double> sampleLineData() {
        java.util.List<Point2D.Double> pts = new ArrayList<>();
        pts.add(new Point2D.Double(0, 3));
        pts.add(new Point2D.Double(1, 5));
        pts.add(new Point2D.Double(2, 2));
        pts.add(new Point2D.Double(3, 8));
        pts.add(new Point2D.Double(4, 6));
        pts.add(new Point2D.Double(5, 9));
        return pts;
    }
}

class GraficoBarrasPanel extends JPanel {
    private Map<String,Integer> data;

    public GraficoBarrasPanel(Map<String,Integer> data){
        this.data=data;
        setBorder(BorderFactory.createTitledBorder("Gráfico de Barras"));
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int w=getWidth(), h=getHeight(), pad=40;

        int max=1;
        for(int v:data.values()) max=Math.max(max,v);

        int n=data.size();
        int barW=(w-2*pad)/n;
        int i=0;

        for(var e:data.entrySet()){
            int x=pad + i*barW + 10;
            int barH=(int)((h-2*pad)*( (double)e.getValue()/max ));
            int y=h-pad-barH;
            g2.fillRect(x,y,barW-20,barH);
            g2.drawString(e.getKey(),x,h-pad+15);
            g2.drawString(e.getValue()+"",x,y-5);
            i++;
        }
    }
}

class GraficoLineasPanel extends JPanel {
    private java.util.List<Point2D.Double> puntos;
    public GraficoLineasPanel(java.util.List<Point2D.Double> pts){
        puntos=pts;
        setBorder(BorderFactory.createTitledBorder("Gráfico de Líneas"));
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        int w=getWidth(), h=getHeight(), pad=50;

        g2.drawLine(pad,h-pad, w-pad,h-pad);
        g2.drawLine(pad,pad, pad,h-pad);

        double minX=0,maxX=puntos.size()-1;
        double minY=Double.POSITIVE_INFINITY,maxY=Double.NEGATIVE_INFINITY;
        for(var p:puntos){minY=Math.min(minY,p.y); maxY=Math.max(maxY,p.y);}    
        double dataW=maxX-minX;
        double dataH=maxY-minY;
        Point prev=null;

        for(var dp:puntos){
            int px=pad +(int)(((dp.x-minX)/dataW)*(w-2*pad));
            int py=h-pad -(int)(((dp.y-minY)/dataH)*(h-2*pad));

            if(prev!=null) g2.drawLine(prev.x,prev.y,px,py);
            g2.fillOval(px-4,py-4,8,8);
            prev=new Point(px,py);
        }
    }
}
