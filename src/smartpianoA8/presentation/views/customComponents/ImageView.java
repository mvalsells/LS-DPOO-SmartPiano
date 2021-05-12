package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;


public class ImageView extends JPanel{

    private Image img;

    public ImageView(String img) {

        this(new ImageIcon(img).getImage());

    }

    public ImageView(Image img) {

        this.img = img;
        Dimension size = new Dimension(img.getWidth(this), img.getHeight(this));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
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

    public void setImg(Image img){

        this.img = img;

        repaint();

    }

    public void setImgSize(int width, int height){

        Image newImage = img.getScaledInstance(width,height,Image.SCALE_SMOOTH);

        setImg(newImage);

    }

    public void paintComponent(Graphics g) {

        g.drawImage(img, 0, 0, null);

    }

    /*public void getScaledInsance(int width, int height,int hints){
         (width,height,hints);
    }*/

    @Override
    public boolean isOptimizedDrawingEnabled() {
        return false;
    }
}
