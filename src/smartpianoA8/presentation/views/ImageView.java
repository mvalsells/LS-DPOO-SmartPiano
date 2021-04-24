package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;


public class ImageView extends JPanel{

    private Image img;

    public ImageView(String img) {

        this(new ImageIcon(img).getImage());

    }

    public ImageView(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {

        g.drawImage(img, 0, 0, getWidth(),getHeight(),null);

    }

    @Override
    public boolean isOptimizedDrawingEnabled() {
        return false;
    }
}
