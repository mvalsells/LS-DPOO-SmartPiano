package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;

public class JPFsettings extends JPasswordField {
    public JPFsettings(String text){
        setForeground(ColorScheme.PRIMARY);
        setBorder(BordersView.TextFieldBorder);
        setOpaque(false);
        setColumns(20);
        setText(text);
    }
}
