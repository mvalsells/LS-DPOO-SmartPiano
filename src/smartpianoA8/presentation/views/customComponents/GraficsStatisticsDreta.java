package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;

public class GraficsStatisticsDreta extends JPanel {
    private final Color color;
    private final ArrayList<Integer> reproduccions;

    public GraficsStatisticsDreta(ArrayList<Integer> reproduccions, Color color){
        this.color = color;
        this.reproduccions = reproduccions;
    }

    @Override
    protected void paintComponent(Graphics grafics){
        super.paintComponent(grafics);

        int temp;
        int width = (int)(getWidth()*0.8);
        int heigh = (int)(getHeight()*0.8);
        double width_inicial = getWidth()/2.0 - width/2.0;
        double heigh_inicial = getHeight()/2.0 - heigh/2.0;
        double escalaY = (getHeight() - 2*heigh_inicial) / Collections.max(reproduccions);
        Graphics2D grafics2d = (Graphics2D) grafics;

        //grafic
        grafics.setColor(color);
        grafics2d.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for(int i = 0; i<23; i++){
            grafics2d.draw(new Line2D.Double(i*width/23.0 + width_inicial, getHeight() - reproduccions.get(i)*escalaY - heigh_inicial, (i+1)*width/23.0 + width_inicial, getHeight() - reproduccions.get(i+1)*escalaY - heigh_inicial));
        }

        //marge
        grafics.setColor(Color.gray);
        grafics2d.setStroke(new BasicStroke(2.8f));
        grafics.drawRect(getWidth()/2 - width/2,getHeight()/2 - heigh/2, width, heigh);

        //valors inferiors
        grafics.setColor(Color.black);

        grafics.setFont(new Font(null, Font.PLAIN, 12));
        for(int i = 0; i<24; i+=2) {
            drawRotate(grafics2d, i*width/23.0 + width_inicial, heigh + heigh_inicial + 10, i + ":00");
        }

        //valors laterals

        Double max = Double.valueOf(Collections.max(reproduccions));
        double salt = max / 24.0;
        if(max == 0.0) {
            grafics2d.drawString("N/A", (float) (width + width_inicial + 7), (float) (1.0 * heigh / 23.0 + heigh_inicial + 5));

        }
        else {

            for (int i = 0; i < 24; i += 2) {
                temp = (int) (max - salt * i);
                grafics2d.drawString(Integer.toString(temp), (float) (width + width_inicial + 7), (float) (i * heigh / 23.0 + heigh_inicial + 5));
            }
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
