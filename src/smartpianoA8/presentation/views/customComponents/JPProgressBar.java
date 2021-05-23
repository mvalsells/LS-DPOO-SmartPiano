package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
/**
 *
 * Esta clase se emcarga principalmente de controlar la barra de progreso en el momento en el que el usuario quiere usar
 * el reproductor de canciones.
 *
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JPProgressBar extends JProgressBar {

    /**
     * Constructor de la clase donde se le asigna el color de la barra, al igual que la creación de esta y de sus
     * parámetros.
     */
    public JPProgressBar() {

        setUI(new BasicProgressBarUI() {

            @Override
            protected void paintDeterminate(Graphics g, JComponent c) {
                Graphics2D graphics2D = (Graphics2D) g;

                int ancho = getWidth();
                int alto = getHeight()-7;

                double progress = getPercentComplete();

                ancho = (int)(ancho*progress);

                g.setColor(Color.ORANGE);

                ((Graphics2D) g).setBackground(ColorScheme.NavBar_Background);

                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, ancho, alto, 4, 4);
                //Rectangle rectangle = new Rectangle(5,5, ancho, alto);
                graphics2D.fill(roundedRectangle);
            }
        });

        /*setOpaque(false);
        setBorderPainted(false);
        setForeground(Color.PINK);
        setBackground(Color.GRAY);*/
    }//Cierre del constructor

}//Cierre de la clase
