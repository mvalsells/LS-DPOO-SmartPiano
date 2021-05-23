package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
/**
 *
 * Esta clase se encarga principalmente de crear el tipo de letra primaria y secundaria que se le asigna en el song,
 * de esa manera reduciamos
 * esas lineas de codigo por vez ejecutada.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JPPrimarySecondaryText extends JPMainView {
    private JLabel jlPrimary;
    private JLabel jlSecondary;

    /**
     * Constructor de la clase
     * @param primary Parámetro que indica que el string es del texto primario.
     * @param secondary Parámetro que indica que el string es del texto secundario.
     */
    public JPPrimarySecondaryText (String primary, String secondary){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        jlPrimary = new JLColor(primary, ColorScheme.PRIMARY);
        jlSecondary = new JLColor(secondary, ColorScheme.Secondary);
        add(jlPrimary);
        add(jlSecondary);
    }//Cierre del constructor

    /**
     * Método donde envia el tipo del texto primario.
     * @param text Parámetro donde se indica el contenido del String.
     */
    public void setPrimaryText(String text){
        jlPrimary.setText(text);
    }//Cierre del método

    /**
     * Método donde envia el tipo del texto secundario.
     * @param text Parámetro donde se indica el contenido del String.
     */
    public void setSecondaryText(String text){
        jlSecondary.setText(text);
    }//Cierre del método
}//Cierre de la clase
