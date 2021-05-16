package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.User;
import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPProfileView extends JPMainView {
    // ---- Inici Atributs ----
    private JButton jbLogout;
    private JButton jbDeleteAccount;
    private JTextField jtfNewUsername;
    private JTextField jtfNewEmail;
    private JPasswordField jpfNewPasword;
    private JPasswordField jpfRepeatNewPasword;
    private JButton jbSaveSettings;
    private JPNavBar jpNavBar;
    private JPanel jpMain;

    //Placeholders
    private String PH_NEW_USERNAME = "Nuevo nombre de usuario";
    private String PH_NEW_EMAIL = "Nuevo email";
    private String PH_NEW_PASSWORD = "Nueva contraseña";
    private String PH_REPEAT_PASSWORD = "Repetición de la nueva contrasenya";

    public static final String SAVE_SETTING = "SaveSetting";
    public static final String LOGOUT = "Logout";
    public static final String DELETE_ACCOUNT = "DeleteAccount";
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----

    public JPProfileView(User currentUser){
        setLayout(new BorderLayout());
        jpMain = new JPMainView();
        jpMain.setLayout(new BorderLayout());
        // ---- Start North ----
        JPanel jpTopBar = new JPMainView();
        jpTopBar.setLayout(new BorderLayout());

        JLabel jlNorth= new JLColor("Mi perfil", ColorScheme.PRIMARY);
        jbLogout = new JBgeneral("Cerrar session", ColorScheme.ORANGE_START);
        jbLogout.setActionCommand(LOGOUT);
        jbDeleteAccount = new JBgeneral("Eliminar cuenta", ColorScheme.RED_DANGER);
        jbDeleteAccount.setActionCommand(DELETE_ACCOUNT);

        //Top left
        JPanel jpTopLeft = new JPMainView();
        jpTopLeft.add(Box.createHorizontalStrut(20));
        jpTopLeft.add(jlNorth);

        //Top right
        JPanel jpTopRight = new JPMainView();
        jpTopRight.add(jbLogout,BorderLayout.EAST);
        jpTopRight.add(Box.createHorizontalStrut(3));
        jpTopRight.add(jbDeleteAccount);
        jpTopRight.add(Box.createHorizontalStrut(20));

        //Top pack
        jpTopBar.add(Box.createVerticalStrut(40),BorderLayout.NORTH);
        jpTopBar.add(jpTopLeft,BorderLayout.WEST);
        jpTopBar.add(jpTopRight,BorderLayout.EAST);

        // ---- End north ----
        // ---- Start center ----
        JPanel jpCenter = new JPMainView();
        //jpCenter.setLayout(new BoxLayout(jpCenter,BoxLayout.Y_AXIS));

        //Username
        JPanel jpUsername = new JPMainView();
        jpUsername.setLayout(new BoxLayout(jpUsername,BoxLayout.Y_AXIS));
        jtfNewUsername = new JTFsettings(PH_NEW_USERNAME);
        jpUsername.add(new JPPrimarySecondaryText("Nombre de usuario", currentUser.getUsername()));
        jpUsername.add(Box.createVerticalStrut(5));
        jpUsername.add(jtfNewUsername);

        //Email
        JPanel jpEmail = new JPMainView();
        jpEmail.setLayout(new BoxLayout(jpEmail,BoxLayout.Y_AXIS));
        jtfNewEmail = new JTFsettings(PH_NEW_EMAIL);
        jpEmail.add(new JPPrimarySecondaryText("Email", currentUser.getEmail()));
        jpEmail.add(Box.createVerticalStrut(5));
        jpEmail.add(jtfNewEmail);

        //Password
        JPanel jpPassword = new JPMainView();
        jpPassword.setLayout(new BoxLayout(jpPassword,BoxLayout.Y_AXIS));
        jpfNewPasword = new JPFsettings(PH_NEW_PASSWORD);
        jpfRepeatNewPasword = new JPFsettings(PH_NEW_PASSWORD);
        jpPassword.add(new JPPrimarySecondaryText("Contraseña","**********"));
        jpPassword.add(Box.createVerticalStrut(5));
        jpPassword.add(jpfNewPasword);
        jpPassword.add(Box.createVerticalStrut(5));
        jpPassword.add(jpfRepeatNewPasword);

        //Save button
        jbSaveSettings = new JBgeneral("Guardar ajustes", ColorScheme.ORANGE_START);
        jbSaveSettings.setActionCommand(SAVE_SETTING);

        //Center pack
        jpCenter.add(jpUsername);
        jpCenter.add(jpEmail);
        jpCenter.add(jpPassword);
        jpCenter.add(jbSaveSettings);
        // ---- End center


        //JPProfileView pack
        jpMain.add(jpTopBar, BorderLayout.NORTH);
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
        jbDeleteAccount.addActionListener(controller);
        jbSaveSettings.addActionListener(controller);
        jpNavBar.registerController(controller);
    }

    public ArrayList<String> profileViewGetData() {
        ArrayList<String> data = new ArrayList<>();
        if (jtfNewUsername.getText().equals(PH_NEW_USERNAME)){
            data.add(null);
        } else {
            data.add(jtfNewUsername.getText());
        }
        if (jtfNewEmail.getText().equals(PH_NEW_EMAIL)) {
            data.add(null);
        } else {
            data.add(jtfNewEmail.getText());
        }
        String newPassword = String.valueOf(jpfNewPasword.getPassword());
        if(newPassword.equals(PH_NEW_PASSWORD)){
            data.add(null);
        } else {
            data.add(newPassword);
        }
        String repetitionNewPassword = String.valueOf(jpfRepeatNewPasword.getPassword());
        if (repetitionNewPassword.equals(PH_REPEAT_PASSWORD)){
            data.add(null);
        } else {
            data.add(repetitionNewPassword);
        }
        return data;
    }
}
