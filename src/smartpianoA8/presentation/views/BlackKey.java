package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;

public class BlackKey extends JButton implements Key {

    final int note;

    public BlackKey (int pos) {
        note = baseNote + 1 + 2 * pos + (pos + 3) / 5 + pos / 5;
        int left = 10 + WD
                + ((WD * 3) / 2) * (pos + (pos / 5)
                + ((pos + 3) / 5));
        //this.setIcon((Icon) TeclaNegra);
        setBackground (Color.BLACK);
        setBounds (left, 10, WD, HT);
    }

    public int getNote () {
        return note;
    }
}
