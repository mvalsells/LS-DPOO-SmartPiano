package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que permet utilitzar una barra de navegació igual i personalitzada en tot el projecte de manera sencilla un cop creada
 * @version 1.0
 * @see JButton
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class JBNavBar extends JButton {
    /**
     * Constructor que afegeix un sol botó de la barra de navegació amb una icona al centre del botó
     * @param icon la icona en format ImageIcon del botó
     */
    public JBNavBar(ImageIcon icon){
        setBackground(ColorScheme.NavBar_Background);
        setPreferredSize(new Dimension(68,68));
        setBorder(new BordersView().getGoogleButtonBorder());
        setBorderPainted(true);
        setIcon(icon);
        setPressedIcon(icon);
    }
}
