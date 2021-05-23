package smartpianoA8.presentation.views.customComponents.profile;

import smartpianoA8.presentation.views.customComponents.BordersView;
import smartpianoA8.presentation.views.customComponents.ColorScheme;

import javax.swing.*;

/**
 * Clase que permite crear un password field ya configurado
 * finestra de diàleg demanant una nova tecla
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class JPFsettings extends JPasswordField {
    /**
     * Constructor donde se les pasa el texto deseado a mostrarse en el passwordfield(no se va a ver)
     * @param text
     */
    public JPFsettings(String text){
        setForeground(ColorScheme.PRIMARY);
        setBorder(BordersView.TextFieldBorder);
        setOpaque(false);
        setColumns(20);
        setText(text);
    }
}
