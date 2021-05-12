package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPProfile extends JPMainView {
    private JButton jbLogout;
    private JTextField jtfNewUsername;
    private JTextField jtfNewEmail;
    private JPasswordField jtfNewPasword;
    private JPasswordField jtfNewPaswordRepetition;
    private JButton jbSaveSettings;

    public static final String SaveSettings = "SaveSetting";
    public static final String Logout = "Logout";

    public JPProfile(){
        setLayout(new BorderLayout());
        setBackground(ColorScheme.MainView_Background);
        // ---- Start North ----
        JPanel jpNorth = new JPMainView();
        jpNorth.setLayout(new BorderLayout());

        JLabel jlNorth= new JLColor("My profile", ColorScheme.PRIMARY);
        jbLogout = new JBgeneral("Logout", ColorScheme.RED_DANGER);
        jbLogout.setActionCommand(Logout);

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
        jpUsername.setLayout(new BoxLayout(jpUsername,BoxLayout.Y_AXIS));
        jtfNewUsername = new JTFsettings("New username");
        jpUsername.add(new JPPrimarySecondaryText("Username", "pepito"));
        //jpUsername.add(Box.createHorizontalStrut(5));
        jpUsername.add(jtfNewUsername);
        jpUsername.setBorder(BorderFactory.createEmptyBorder(150,150,150,150));

        //Email
        JPanel jpEmail = new JPMainView();
        jtfNewEmail = new JTFsettings("New email");
        jpEmail.add(new JPPrimarySecondaryText("Email", "pepito@pepito.com"));
        jpUsername.add(Box.createHorizontalStrut(5));
        jpEmail.add(jtfNewEmail);

        //Password
        JPanel jpPassword = new JPMainView();
        jtfNewPasword = new JPFsettings("New password");
        jpPassword.add(new JPPrimarySecondaryText("Password","**********"));
        jpPassword.add(jtfNewPasword);

        //Save button
        jbSaveSettings = new JBgeneral("Save settings", ColorScheme.ORANGE_START);
        jbSaveSettings.setActionCommand(SaveSettings);

        //Center pack
        jpCenter.add(jpUsername);
        jpCenter.add(jpEmail);
        jpCenter.add(jpPassword);
        jpCenter.add(jbSaveSettings);
        // ---- End center


        //JPProfile pack
        add(jpNorth, BorderLayout.NORTH);
        add(jpCenter, BorderLayout.CENTER);
        add(Box.createVerticalStrut(40),BorderLayout.SOUTH);
    }

    public void registerController(ActionListener controller){
        jbLogout.addActionListener(controller);
        jbSaveSettings.addActionListener(controller);
    }
}
