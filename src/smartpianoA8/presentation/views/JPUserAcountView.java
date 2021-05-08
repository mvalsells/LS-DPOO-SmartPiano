package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.ColorScheme;
import smartpianoA8.presentation.views.customComponents.JLColor;
import smartpianoA8.presentation.views.customComponents.JPMainView;
import smartpianoA8.presentation.views.customComponents.JTFsettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPUserAcountView extends JPMainView {
    private JButton jbLogout;
    private JTextField jtfNewUsername;
    public JPUserAcountView(){
        setLayout(new BorderLayout());
        setBackground(ColorScheme.MainView_Background);
        // ---- Start North ----
        JPanel jpNorth = new JPMainView();
        jpNorth.setLayout(new BorderLayout());

        JLabel jlUsername = new JLColor("username", ColorScheme.Primary);
        jbLogout = new JButton("Logout");

        //North pack
        jpNorth.add(Box.createVerticalStrut(40),BorderLayout.NORTH);
        jpNorth.add(jlUsername,BorderLayout.WEST);
        jpNorth.add(jbLogout,BorderLayout.EAST);

        // ---- End north ----
        // ---- Start center ----
        JPanel jpCenter = new JPMainView();

        //Username
        JPanel jpUsername = new JPMainView();
        jpUsername.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel jlCuerrentUsername = new JLColor("Current username: pepito", ColorScheme.Primary);
        jtfNewUsername = new JTFsettings();
        jpUsername.add(jlCuerrentUsername);
        jpUsername.add(jtfNewUsername);

        //Center pack
        jpCenter.add(jpUsername);
        // ---- End center


        //JPUserAcountView pack
        add(jpNorth, BorderLayout.NORTH);
        add(jpCenter, BorderLayout.CENTER);
    }

    public void registerController(ActionListener controller){
        jbLogout.addActionListener(controller);
    }
}
