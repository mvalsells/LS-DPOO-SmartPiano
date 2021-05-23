package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

/**
 *
 * Esta clase se encarga principalmente de crear un boton personalizado a traves del constructor, de esa manera reduciamos
 * esas lineas de codigo por vez ejecutada.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JTPianoButtonText extends JLabel{

    /**
     * Contructor del botón.
     * @param top Parámetro que indica el border de top.
     * @param left Parámetro que indica el border de left.
     * @param bottom Parámetro que indica el border de bottom.
     * @param right Parámetro que indica el border de right.
     */
    public JTPianoButtonText(int top, int left, int bottom, int right) {
        setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
        setFont(new Font("Arial",Font.PLAIN,12));
        setForeground(new Color(255,255,255));
        setBackground(Color.darkGray);
    }//Cierre del constructor
}//Cierre de la clase
