package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JPPrimarySecondaryText extends JPMainView {
    public JPPrimarySecondaryText (String primary, String secondary){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel jlPrimary = new JLColor(primary, ColorScheme.PRIMARY);
        JLabel jlSecondary = new JLColor(secondary, ColorScheme.Secondary);
        add(jlPrimary);
        add(jlSecondary);
    }
}
