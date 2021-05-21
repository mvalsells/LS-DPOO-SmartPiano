package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPCanco extends JPMainView {

    private JButton jButton;
    private ImageIcon musicIcon = new ImageIcon("Imagen/ImagenesMenu/music.png");
    public JPCanco(JButton button, String songNomText,String songInfoText){

        this.jButton = button;

        jButton.setIcon(musicIcon);
        jButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorderPainted(false);

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JLabel jlTitul = new JLColor(songNomText, ColorScheme.PRIMARY);
        JLabel jlInfo = new JLColor(songInfoText,ColorScheme.Secondary);

        add(jButton);
        add(jlTitul);
        add(jlInfo);

    }

    public String getIDButton(){

        String[] string =  jButton.getActionCommand().split("-");

        return string[1];
    }

    public void registerController(ActionListener controller){

        this.jButton.addActionListener(controller);

    }

}
