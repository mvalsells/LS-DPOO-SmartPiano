package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JBNavBar extends JButton {
    public JBNavBar(ImageIcon icon){
        setBackground(ColorScheme.NavBar_Background);
        setPreferredSize(new Dimension(68,68));
        setBorder(new BordersView().getGoogleButtonBorder());
        setBorderPainted(true);
        setIcon(icon);
        setPressedIcon(icon);
    }
}
