package smartpianoA8.presentation.views.customComponents.statistics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe per la generació de gràfiques pel nombre de reproduccions, utilitzant Graphics i Graphics2D insertat en un JPanel que es pot unir
 * com a "embeded" a diferents vistes
 * @implNote No s'utilitza una herència per la sensillesa que suposaria la classe abstracte mare "GraficsStatistics"
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class GraficsStatisticsDreta extends JPanel {
    private final Color color;
    private ArrayList<Integer> reproduccions;

    /**
     * Constructor amb l'Array de dades de l'eix X i el color a utilitzar (modificable)
     * @param reproduccions ArrayList d'enters amb les variables Y de cada X de reproduccions
     * @param color color a utilitzar per la línia del gràfic
     */
    public GraficsStatisticsDreta(ArrayList<Integer> reproduccions, Color color){
        this.color = color;
        this.reproduccions = reproduccions;
    }

    /**
     * Mètode per printar les línies de gràfics sobre un JPanel, de X [0,23] i Y [0, infinit]
     * @param grafics objecte que s'utilitza per renderitzar els diferents objectes afegits sobre la vista bàsica
     * @see Graphics
     */
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

    /**
     * Mètode per printar un text rotat respecte la seva cantonada suiperior esquerra
     * @param g2d objecte Graphics2D que renderitza el text i proporciona les eines
     * @param x double posició X del text
     * @param y double posició Y del text
     * @param text String text a rotar
     */
    private void drawRotate(Graphics2D g2d, double x, double y, String text)
    {
        g2d.translate((float)x,(float)y);
        g2d.rotate(Math.toRadians(45));//sempre es rota a 45º
        g2d.drawString(text,0,0);
        g2d.rotate(-Math.toRadians(45));//sempre es rota a 45º
        g2d.translate(-(float)x,-(float)y);
    }

    /**
     * Mètode per actualitzar les estadístiques i la seva vista
     * @param dades nova arraylist de dades
     */
    public void actualitzaVista(ArrayList<Integer> dades){
        this.reproduccions = dades;
        //repaint();
        //revalidate();
        setVisible(false);
        setVisible(true);
    }
}
