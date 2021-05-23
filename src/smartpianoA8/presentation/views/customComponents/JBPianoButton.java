package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que permet utilitzar un botó d'eines del piano seguint la tematica de colors del mateix piano
 * @version 1.0
 * @see JButton
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class JBPianoButton extends JButton {
    /**
     * Constructor que crea i col·loca el botó amb dos estats: clicat i desseleccionat.
     */
    public JBPianoButton() {
        ImageIcon normal = new ImageIcon("Imagen/ImagenesMenu/RegButton.jpg");
        ImageIcon pressed = new ImageIcon("Imagen/ImagenesMenu/RegButtonPressed.jpg");
        setIcon(normal);
        setPressedIcon(pressed);
        setPreferredSize(new Dimension(38,44));
        setBorder(BorderFactory.createEmptyBorder(0,10,25,0));
        setContentAreaFilled(false);
    }
}
