package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
/**
 * Calsse que representa una tecla negra del piano en vistes
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see Key
 * @see JButton
 */
public class BlackKey extends JButton implements Key {

    final int note;
    static int BWD = (int) (WD *1.2);

    /**
     * Constructor amb el paràmetre de posicionament al teclat
     * @param pos Int posició del teclat de la nota relativa del teclat
     */
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
        setForeground(Color.BLACK);
        setBorderPainted(true);
        //requestFocusInWindow();

    }

    /**
     * Mèotde per obtenir el codi de la nota
     * @return int codi absolut entre totes les octaves
     */
    @Override
    public int getNote () {
        return note;
    }

    /**
     * Mètode per pintar una nota quan és clicada
     */
    public void clicarNota(){setBackground(Color.RED); setBorder(BorderFactory.createLineBorder(Color.RED,11));}

    /**
     * Mèotde per despintar una nota i tornar-la al color incial
     */
    public void desclicarNota(){setBackground(Color.BLACK);setBorder(BorderFactory.createLineBorder(Color.BLACK,11));}
}