package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JBgeneral extends JButton {
    public JBgeneral(String text, Color backgroundColor){
        super(text);
        setForeground(ColorScheme.PRIMARY);
        setBackground(backgroundColor);
        setBorderPainted(false);
        setOpaque(true);
        setVisible(true);
    }
}
