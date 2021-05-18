package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JBPlayer extends JButton {

    public JBPlayer(ImageIcon icon){
        setBackground(ColorScheme.NavBar_Background);
        setPreferredSize(new Dimension(45,30));
        setBorder(new BordersView().getGoogleButtonBorder());
        setBorderPainted(true);
        setIcon(icon);
    }
}
