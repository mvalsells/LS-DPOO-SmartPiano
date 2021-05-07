package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JBPianoButton extends JButton {

    public JBPianoButton() {
        ImageIcon normal = new ImageIcon("Imagen/ImagenesMenu/RegButton.jpg");
        ImageIcon pressed = new ImageIcon("Imagen/ImagenesMenu/RegButtonPressed.jpg");
        setIcon(normal);
        setPressedIcon(pressed);
        setPreferredSize(new Dimension(38,44));
        setBorder(BorderFactory.createEmptyBorder(0,10,25,0));
        setContentAreaFilled(false);
    }
}
