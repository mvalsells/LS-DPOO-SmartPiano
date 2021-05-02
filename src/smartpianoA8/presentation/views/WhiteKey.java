package smartpianoA8.presentation.views;

import javax.swing.*;

class WhiteKey  extends JButton implements Key {

    static int WWD = (int) (((WD * 3) / 2)*1.2);
    static int WHT = (HT * 3) / 2;
    final int note;

    public WhiteKey (int pos) {
        note = baseNote + 2 * pos
                - (pos + 4) / 7
                - pos / 7;
        int left = 10 + WWD * pos;
        // I think metal looks better!
       // setBackground (Color.WHITE);
        setBounds (left, 10, WWD, WHT);
        //setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
        setOpaque(false);

    }

    public int getNote () {
        return note;
    }


}