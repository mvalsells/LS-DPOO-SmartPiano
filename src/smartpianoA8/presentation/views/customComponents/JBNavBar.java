package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.presentation.views.BordersView;

import javax.swing.*;
import java.awt.*;

public class JBNavBar extends JButton {
    public JBNavBar(ImageIcon normal, ImageIcon pressed){
        setBackground(ColorScheme.NavBar_Background);
        setPreferredSize(new Dimension(68,68));
        setBorder(new BordersView().getGoogleButtonBorder());
        setBorderPainted(true);
        setIcon(normal);
        setPressedIcon(pressed);
    }
}
