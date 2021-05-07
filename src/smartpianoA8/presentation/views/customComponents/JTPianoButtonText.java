package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JTPianoButtonText extends JLabel{

    public JTPianoButtonText(int top, int left, int bottom, int right) {
        setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
        setFont(new Font("Arial",Font.PLAIN,12));
        setForeground(new Color(255,255,255));
        setBackground(Color.darkGray);
    }
}
