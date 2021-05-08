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
    private JTextField jtfNewEmail;
    private JTextField jtfNewPasword;
    private JButton jbSaveSettings;
    public JPUserAcountView(){
        setLayout(new BorderLayout());
        setBackground(ColorScheme.MainView_Background);
        // ---- Start North ----
        JPanel jpNorth = new JPMainView();
        jpNorth.setLayout(new BorderLayout());

        JLabel jlNorth= new JLColor("username", ColorScheme.Primary);
        jbLogout = new JButton("Logout");

        //North pack
        jpNorth.add(Box.createVerticalStrut(40),BorderLayout.NORTH);
        jpNorth.add(jlNorth,BorderLayout.WEST);
        jpNorth.add(jbLogout,BorderLayout.EAST);

        // ---- End north ----
        // ---- Start center ----
        JPanel jpCenter = new JPMainView();
        jpCenter.setLayout(new BoxLayout(jpCenter,BoxLayout.Y_AXIS));

        //Username
        JPanel jpUsername = new JPMainView();
        JLabel jlUsername = new JLColor("Current username: pepito. New username: ", ColorScheme.Primary);
        jtfNewUsername = new JTFsettings();
        jpUsername.add(jlUsername);
        jpUsername.add(jtfNewUsername);

        //Email
        JPanel jpEmail = new JPMainView();
        JLabel jlEmail = new JLColor("Current email: hola@hola.com", ColorScheme.Primary);
        jtfNewEmail = new JTFsettings();
        jpEmail.add(jlEmail);
        jpEmail.add(jtfNewEmail);

        //Password
        JPanel jpPassword = new JPMainView();
        JLabel jlPassword = new JLColor("New password: ", ColorScheme.Primary);
        jtfNewPasword = new JTFsettings();
        jpPassword.add(jlPassword);
        jpPassword.add(jtfNewPasword);

        //Save button
        jbSaveSettings = new JButton("Save settings");
        //Center pack
        jpCenter.add(jpUsername);
        jpCenter.add(jpEmail);
        jpCenter.add(jpPassword);
        jpCenter.add(jbSaveSettings);
        // ---- End center


        //JPUserAcountView pack
        add(jpNorth, BorderLayout.NORTH);
        add(jpCenter, BorderLayout.CENTER);
    }

    public void registerController(ActionListener controller){
        jbLogout.addActionListener(controller);
    }
}
