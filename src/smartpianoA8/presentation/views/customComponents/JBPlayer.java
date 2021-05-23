package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que permet utilitzar un botó pròpi personalitzat pel reproductor
 * @version 1.0
 * @see JButton
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class JBPlayer extends JButton {
    /**
     * Constructor que crea i afegeix el botó amb una imatge com a icona
     * @param icon icona ImageIcon per afegir al cnetre del botó
     */
    public JBPlayer(ImageIcon icon){
        setBackground(ColorScheme.NavBar_Background);
        setPreferredSize(new Dimension(45,30));
        setBorder(new BordersView().getGoogleButtonBorder());//utilitza el mateix marge que el botó de Google
        setBorderPainted(true);
        setIcon(icon);
    }
}
