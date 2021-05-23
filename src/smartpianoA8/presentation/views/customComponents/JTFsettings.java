package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;

/**
 *
 * Esta clase se encarga principalmente de crear un texto personalizado a traves del constructor, de esa manera reduciamos
 * esas lineas de codigo por vez ejecutada.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JTFsettings extends JTextField {

    /**
     * Constructor de la clase.
     * @param text Parámetro por el cual le viene el texto.
     */
    public JTFsettings(String text){
        setForeground(ColorScheme.PRIMARY);
        setBorder(BordersView.TextFieldBorder);
        setOpaque(false);
        setColumns(20);
        setText(text);
    }//Cierre del constructor
}//Cierre de la clase
