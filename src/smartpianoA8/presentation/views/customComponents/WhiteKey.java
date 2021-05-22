package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.presentation.views.customComponents.Key;

import javax.swing.*;
import java.awt.*;

public class WhiteKey  extends JButton implements Key {

    static int WWD = (int) (((WD * 3) / 2)*1.2);
    static int WHT = (HT * 3) / 2;
    final int note;

    public WhiteKey (int pos) {
        note = baseNote + 2 * pos
                - (pos + 4) / 7
                - pos / 7;
        int left = 10 + WWD * pos;
        // I think metal looks better!
        setBackground (Color.WHITE);
        setBounds (left, 10, WWD, WHT);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        //setOpaque(true);
        //setForeground(Color.WHITE);
    }

    public int getNote () {
        return note;
    }



    public void clicarNota(){setBackground(Color.BLUE);/*setBorder(BorderFactory.createLineBorder(Color.blue,1));*/}
    public void desclicarNota(){ setBackground(Color.WHITE);/*setBorder(BorderFactory.createLineBorder(Color.white,1));*/ }
}