package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;

public class GraficsStatisticsEsquerra extends JPanel {
    private final ArrayList<Double> minuts;
    private final Color rosa;


    public GraficsStatisticsEsquerra(ArrayList<Double> minuts, Color rosa){
        this.minuts = minuts;
        this.rosa = rosa;
    }

    @Override
    protected void paintComponent(Graphics grafics){
        super.paintComponent(grafics);

        int temp;
        int width = (int)(getWidth()*0.8);
        int heigh = (int)(getHeight()*0.8);
        double width_inicial = getWidth()/2.0 - width/2.0;
        double heigh_incial = getHeight()/2.0 - heigh/2.0;
        double escalaY = (getHeight() - 2*heigh_incial) / Collections.max(minuts);
        Graphics2D grafics2d = (Graphics2D) grafics;

        //grafic
        grafics.setColor(rosa);
        grafics2d.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for(int i = 0; i<23; i++){
            grafics2d.draw(new Line2D.Double(i*width/23.0 + width_inicial, getHeight() - minuts.get(i)*escalaY - heigh_incial, (i+1)*width/23.0 + width_inicial, getHeight() - minuts.get(i+1)*escalaY - heigh_incial));
        }

        //marge
        grafics.setColor(Color.gray);
        grafics2d.setStroke(new BasicStroke(2.8f));
        grafics.drawRect(getWidth()/2 - width/2,getHeight()/2 - heigh/2, width, heigh);

        //valors inferiors
        grafics.setColor(Color.black);
        grafics.setFont(new Font(null, Font.PLAIN, 12));
        for(int i = 0; i<24; i+=2) {
            drawRotate(grafics2d, i*width/23.0 + width_inicial, heigh + heigh_incial + 10, i + ":00");
        }

        //valors laterals
        Double max = Collections.max(minuts);
        double salt = max/24.0;
        for(int i = 0; i<24; i+=2) {
            temp = (int) (max - salt*i);
            grafics2d.drawString(Integer.toString(temp), (float) (getWidth() / 2 - width / 2) /*-24*/, (float) (i*heigh/23.0 + heigh_incial + 6));
        }

    }

    private void drawRotate(Graphics2D g2d, double x, double y, String text)
    {
        g2d.translate((float)x,(float)y);
        g2d.rotate(Math.toRadians(45));
        g2d.drawString(text,0,0);
        g2d.rotate(-Math.toRadians(45));
        g2d.translate(-(float)x,-(float)y);
    }


}
