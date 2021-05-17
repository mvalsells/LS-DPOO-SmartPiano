package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JBNavPlayer extends JButton {

    public JBNavPlayer(ImageIcon icon){
        setBackground(ColorScheme.NavBar_Background);
        setPreferredSize(new Dimension(80,80));
        setBorder(new BordersView().getGoogleButtonBorder());
        setBorderPainted(true);
        setIcon(icon);
        setPressedIcon(icon);
    }
}
