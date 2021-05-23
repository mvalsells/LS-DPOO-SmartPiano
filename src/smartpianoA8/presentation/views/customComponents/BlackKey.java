package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class BlackKey extends JButton implements Key {

    final int note;
    static int BWD = (int) (WD *1.2);
    public BlackKey(int pos) {
        note = baseNote + 1 + 2 * pos + (pos + 3) / 5 + pos / 5;
        int left = 10 + BWD
                + ((BWD * 3) / 2) * (pos + (pos / 5)
                + ((pos + 3) / 5));
        //this.setIcon((Icon) TeclaNegra);
        setBackground (Color.BLACK);
        setBounds (left, 10, BWD, HT);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,11));
        setOpaque(true);
        setForeground(Color.WHITE);
        setBorderPainted(true);
        //requestFocusInWindow();

    }

    public int getNote () {
        return note;
    }


    public void clicarNota(){setBackground(Color.RED); setBorder(BorderFactory.createLineBorder(Color.RED,11));}
    public void desclicarNota(){setBackground(Color.BLACK);setBorder(BorderFactory.createLineBorder(Color.BLACK,11));}
}