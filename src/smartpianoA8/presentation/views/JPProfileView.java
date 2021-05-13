package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPProfileView extends JPMainView {
    // ---- Inici Atributs ----
    private JButton jbLogout;
    private JTextField jtfNewUsername;
    private JTextField jtfNewEmail;
    private JPasswordField jtfNewPasword;
    private JPasswordField jtfNewPaswordRepetition;
    private JButton jbSaveSettings;
    private JPNavBar jpNavBar;
    private JPanel jpMain;

    public static final String SaveSettings = "SaveSetting";
    public static final String Logout = "Logout";

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----

    public JPProfileView(){
        jpMain = new JPMainView();
        jpMain.setLayout(new BorderLayout());
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


        //JPProfileView pack
        jpMain.add(jpNorth, BorderLayout.NORTH);
        jpMain.add(jpCenter, BorderLayout.CENTER);
        jpMain.add(Box.createVerticalStrut(40),BorderLayout.SOUTH);

        //Final packing
        jpNavBar = new JPNavBar(JFMainFrame.SONGS);
        add(jpNavBar,BorderLayout.WEST);
        add(jpMain,BorderLayout.CENTER);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerControllers(ActionListener controller){
        jbLogout.addActionListener(controller);
        jbSaveSettings.addActionListener(controller);
        jpNavBar.registerController(controller);
    }

    public ArrayList<String> profileViewGetData() {
        return null;
    }
}
