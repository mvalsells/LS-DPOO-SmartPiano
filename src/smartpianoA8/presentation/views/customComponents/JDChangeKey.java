package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class JDChangeKey extends JDialog {
    private JPPrimarySecondaryText jpText;

    public JDChangeKey(){


        setVisible(false);
        setPreferredSize(new Dimension(300,100));
        setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);


        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        jPanel.setBackground(ColorScheme.PopUpsBackground);

        jpText = new JPPrimarySecondaryText("","");
        jpText.setBackground(ColorScheme.PopUpsBackground);

        add(jpText);
        pack();

    }

    public void registerKeyListener(KeyListener keyListener){
        addKeyListener(keyListener);
    }

    public void show(String primary, String secondary){
        jpText.setPrimaryText(primary);
        jpText.setSecondaryText(secondary);
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }
}
