package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que modifica l'estètica d'un botó estàndar per utilityzar botons ja personalitzats directament al projecte
 * @version 1.0
 * @see JButton
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class JBgeneral extends JButton {
    /**
     * Constructor que genera el botó personalitzat
     * @param text String text a incloure al botó
     * @param backgroundColor Color del fons del botó
     */
    public JBgeneral(String text, Color backgroundColor){
        super(text);
        setForeground(ColorScheme.PRIMARY);
        setBackground(backgroundColor);
        setBorderPainted(false);
        setOpaque(true);
        setVisible(true);
    }
}
