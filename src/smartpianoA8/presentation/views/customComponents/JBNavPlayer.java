package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JBNavPlayer extends JButton {

    public JBNavPlayer(ImageIcon icon){
        setBackground(ColorScheme.NavBar_Background);
        setPreferredSize(new Dimension(45,45));
        setBorder(new BordersView().getGoogleButtonBorder());
        setBorderPainted(true);
        setIcon(icon);
    }
}
