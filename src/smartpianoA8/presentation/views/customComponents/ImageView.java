package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Classe per la isnerció d'una imatge per sota d'unaltre conjunt d'elements com a background
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class ImageView extends JPanel{

    private Image img;

    /**
     * Contstructor que carrega una imatge
     * @param img la imatge a carregar
     */
    public ImageView(String img) {

        this(new ImageIcon(img).getImage());

    }

    /**
     * Constructor per actualitar l'imatge actual i reconstruir els parametres de característiques
     * @param img imatge nova a mostrar per sota la resta d'elements
     */
    public ImageView(Image img) {

        this.img = img;
        Dimension size = new Dimension(img.getWidth(this), img.getHeight(this));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    /**
     * Constructor per actualitar l'imatge actual i reconstruir els parametres de característiques
     * @param img imatge nova a mostrar per sota la resta d'elements
     * @param width amplada personalitzada
     * @param height altura personalitzada
     */
    public ImageView(Image img, int width, int height) {

        this.img = img.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        Dimension size = new Dimension(img.getWidth(this), img.getHeight(this));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        repaint();

    }

    /**
     * Mètode per actualitzar la imatge sense modificar cap característica, col·locació ràpida
     * @param img imatge a canviar de nou
     */
    public void setImg(Image img){

        this.img = img;

        repaint();

    }

    /**
     * Mètode per mnodificar la mida de la imatge manualment
     * @param width amplada nova
     * @param height altura nova
     */
    public void setImgSize(int width, int height){

        Image newImage = img.getScaledInstance(width,height,Image.SCALE_SMOOTH);

        setImg(newImage);

    }

    /**
     * Mètode per printar la vista (backgroud) amb la imatge
     * @param g Graphics per renderitzar la imatge
     */
    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(img, 0, 0, null);

    }
     /**
      * Mètode per indicar a la renderització que la imatge no està optimitzada per renderitzacions avançades
      * Cal cridar aquesta funció en la majoria d'ordinadors
    */
    @Override
    public boolean isOptimizedDrawingEnabled() {
        return false;
    }
}
