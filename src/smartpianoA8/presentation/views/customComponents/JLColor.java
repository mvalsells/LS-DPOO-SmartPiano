package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JLColor extends JLabel {
    public JLColor(String text, Color color){
        super(text);
        setForeground(color);
    }
    public JLColor(String text, Color color,Font font ){
        super(text);
        setForeground(color);
        setFont(font);

    }
}
