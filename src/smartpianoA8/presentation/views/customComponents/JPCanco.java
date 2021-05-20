package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPCanco extends JPMainView {

    //private JButton jButton;
    ImageIcon musicIcon = new ImageIcon("Imagen/ImagenesMenu/music.png");
    public JPCanco(JButton button, String songNomText,String songInfoText){

        button.setIcon(musicIcon);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JLabel jlTitul = new JLColor(songNomText, ColorScheme.PRIMARY);
        JLabel jlInfo = new JLColor(songInfoText,ColorScheme.Secondary);

        add(button);
        add(jlTitul);
        add(jlInfo);

    }

    /*public void registerController(ActionListener controller){

        this.jButton.addActionListener(controller);

    }*/

}
