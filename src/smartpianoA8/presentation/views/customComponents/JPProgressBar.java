package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class JPProgressBar extends JProgressBar {

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

                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, ancho, alto, 4, 4);
                //Rectangle rectangle = new Rectangle(5,5, ancho, alto);
                graphics2D.fill(roundedRectangle);
            }
        });

        /*setOpaque(false);
        setBorderPainted(false);
        setForeground(Color.PINK);
        setBackground(Color.GRAY);*/
    }

}
