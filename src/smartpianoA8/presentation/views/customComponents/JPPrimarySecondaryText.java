package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JPPrimarySecondaryText extends JPMainView {
    private JLabel jlPrimary;
    private JLabel jlSecondary;
    public JPPrimarySecondaryText (String primary, String secondary){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        jlPrimary = new JLColor(primary, ColorScheme.PRIMARY);
        jlSecondary = new JLColor(secondary, ColorScheme.Secondary);
        add(jlPrimary);
        add(jlSecondary);
    }

    public void setPrimaryText(String text){
        jlPrimary.setText(text);
    }
    public void setSecondaryText(String text){
        jlSecondary.setText(text);
    }
}
