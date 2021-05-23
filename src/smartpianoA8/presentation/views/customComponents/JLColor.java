package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
/**
 * Classe llibreria amb colors a utilitzar per etiquetes, mostra un color i un text amb una font
 * @version 1.0
 * @see JLabel
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class JLColor extends JLabel {
    /**
     * Mètode per establir el color i el text
     * @param text Text String a posar al Label
     * @param color Color del label
     */
    public JLColor(String text, Color color){
        super(text);
        setForeground(color);
    }
    /**
     * Mètode per establir el color i el text i una font
     * @param text Text String a posar al Label
     * @param color Color del label
     * @param font Font del text del label
     */
    public JLColor(String text, Color color,Font font ){
        super(text);
        setForeground(color);
        setFont(font);

    }
}
