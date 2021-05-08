package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.presentation.views.BordersView;

import javax.swing.*;

public class JTFsettings extends JTextField {
    public JTFsettings(){
        setForeground(ColorScheme.Primary);
        setBorder(BordersView.TextFieldBorder);
        setOpaque(false);
    }
}
