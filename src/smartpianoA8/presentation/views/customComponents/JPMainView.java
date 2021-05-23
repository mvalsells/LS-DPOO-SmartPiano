package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
/**
 * Classe amb la vista principal que carrega el JPanel principal del fons
 * @version 1.0
 * @see JLabel
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class JPMainView extends JPanel {
    /**
     * Constructor que genera el primer background
     */
    public JPMainView(){
        super();
        setBackground(ColorScheme.MainView_Background);
    }
}
