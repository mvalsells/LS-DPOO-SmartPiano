package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.User;
import smartpianoA8.presentation.views.customComponents.*;
import smartpianoA8.presentation.views.customComponents.profile.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * Esta clase se encarga principalmente de mostrar el panel interactivo asociado a la edicion del perfil del usaurio, aquí se le asignara no solamente
 * el panel general donde estan todas la funciones para editar el menu, sino que además, incluye los register controller al igual que la función
 * para controlar que los datos se pasen correctamente.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1.0
 */
public class JPProfileView extends JPMainView {
    // ---- Inici Atributs ----
    private JButton jbStats;
    private JButton jbTop5;
    private JButton jbLogout;
    private JButton jbDeleteAccount;
    private JTextField jtfNewUsername;
    private JTextField jtfNewEmail;
    private JPasswordField jpfNewPasword;
    private JPasswordField jpfRepeatNewPasword;
    private JButton jbSaveSettings;
    private JPTeclesTeclat jpTeclat;
    private JPPrimarySecondaryText jpUsernameText;
    private JPPrimarySecondaryText jpEmailText;
    private JDChangeKey jdSelectKey;


    //Placeholders
    private String PH_NEW_USERNAME = "  Nuevo nombre de usuario";
    private String PH_NEW_EMAIL = "  Nuevo email";
    private String PH_NEW_PASSWORD = "  Nueva contraseña";
    private String PH_REPEAT_PASSWORD = "  Repetición de la nueva contrasenya";

    public static final String SAVE_SETTING = "SaveSetting";
    public static final String LOGOUT = "Logout";
    public static final String DELETE_ACCOUNT = "DeleteAccount";
    public static final String STATS = "Stats";
    public static final String TOP_5 = "top5";
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----

    /**
     *Constructor donde contiene todos los paneles de la clase para hacer login.
     * @param currentUser Parametro por el cual se pasa el usuario que quiere verificar sus datos.
     */
    public JPProfileView(User currentUser){
        setLayout(new BorderLayout());
        // ---- Start North ----
        JPanel jpTopBar = new JPMainView();
        jpTopBar.setLayout(new BorderLayout());

        JLabel jlNorth= new JLColor("Mi perfil", ColorScheme.PRIMARY);
        jbStats = new JBgeneral("Estadisticas", ColorScheme.ORANGE_START);
        jbStats.setActionCommand(STATS);
        jbTop5 = new JBgeneral("Top 5", ColorScheme.ORANGE_START);
        jbTop5.setActionCommand(TOP_5);
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
        jpTopRight.add(jbTop5,BorderLayout.EAST);
        jpTopRight.add(Box.createHorizontalStrut(3));
        jpTopRight.add(jbStats,BorderLayout.EAST);
        jpTopRight.add(Box.createHorizontalStrut(3));
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
        JPanel jpUserSettings = new JPMainView();
        jpUserSettings.setLayout(new BoxLayout(jpUserSettings,BoxLayout.Y_AXIS));

        //Username
        JPanel jpUsername = new JPMainView();
        jpUsername.setLayout(new BoxLayout(jpUsername,BoxLayout.Y_AXIS));
        jtfNewUsername = new JTFsettings(PH_NEW_USERNAME);
        jtfNewUsername.setMaximumSize(new Dimension(400, 20));
        jpUsernameText = new JPPrimarySecondaryText("Nombre de usuario", currentUser.getUsername());
        jpUsername.add(jpUsernameText);
        jpUsername.add(Box.createVerticalStrut(5));
        jpUsername.add(jtfNewUsername);
        jpUsername.add(Box.createVerticalStrut(10));

        //Email
        JPanel jpEmail = new JPMainView();
        jpEmail.setLayout(new BoxLayout(jpEmail,BoxLayout.Y_AXIS));
        jtfNewEmail = new JTFsettings(PH_NEW_EMAIL);
        jtfNewEmail.setMaximumSize(new Dimension(400, 20));
        jpEmailText = new JPPrimarySecondaryText("Email", currentUser.getEmail());
        jpEmail.add(jpEmailText);
        jpEmail.add(Box.createVerticalStrut(5));
        jpEmail.add(jtfNewEmail);
        jpEmail.add(Box.createVerticalStrut(10));

        //Password
        JPanel jpPassword = new JPMainView();
        jpPassword.setLayout(new BoxLayout(jpPassword,BoxLayout.Y_AXIS));
        jpfNewPasword = new JPFsettings(PH_NEW_PASSWORD);
        jpfNewPasword.setMaximumSize(new Dimension(400, 20));
        jpfRepeatNewPasword = new JPFsettings(PH_NEW_PASSWORD);
        jpfRepeatNewPasword.setMaximumSize(new Dimension(400, 20));
        jpPassword.add(new JPPrimarySecondaryText("Contraseña","**********"));
        jpPassword.add(Box.createVerticalStrut(5));
        jpPassword.add(jpfNewPasword);
        jpPassword.add(Box.createVerticalStrut(5));
        jpPassword.add(jpfRepeatNewPasword);
        jpPassword.add(Box.createVerticalStrut(10));

        //Save button
        jbSaveSettings = new JBgeneral("Guardar ajustes", ColorScheme.ORANGE_START);
        jbSaveSettings.setActionCommand(SAVE_SETTING);

        //userSettings pack
        jpUserSettings.add(jpUsername);
        jpUserSettings.add(jpEmail);
        jpUserSettings.add(jpPassword);
        jpUserSettings.add(jbSaveSettings);

        //Piano
        jpTeclat = new JPTeclesTeclat();
        //Center pack
        JPanel jpCenter = new JPMainView();
        jpCenter.add(jpUserSettings);
        jpCenter.add(jpTeclat);

        // ---- End center


        //JPProfileView pack
        add(jpTopBar, BorderLayout.NORTH);
        add(jpCenter, BorderLayout.CENTER);
        add(Box.createHorizontalStrut(40),BorderLayout.WEST);
        add(Box.createHorizontalStrut(40),BorderLayout.EAST);

        jdSelectKey = new JDChangeKey();
    }//Cierre constructor
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----

    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param actionListener controlador asocioado a los botones.
     * @param keyListener controlador asociado a las teclas del ordenador.
     * @param mouseListener controlador asociado al ratón.
     */
    public void registerControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        jbStats.addActionListener(actionListener);
        jbTop5.addActionListener(actionListener);
        jbLogout.addActionListener(actionListener);
        jbDeleteAccount.addActionListener(actionListener);
        jbSaveSettings.addActionListener(actionListener);
        jpTeclat.registerController(mouseListener);
        jdSelectKey.registerKeyListener(keyListener);
    }//Cierre del método

    /**
     *Método que comprueba si hay informacion rellenada en el perfil sino muestra ese espacio vacio.
     * @return Devuelve si hay infromacion rellenada en el perfil.
     */
    public ArrayList<String> profileViewGetData() {
        ArrayList<String> data = new ArrayList<>();
        if (jtfNewUsername.getText().equals(PH_NEW_USERNAME) || jtfNewUsername.getText().equals("")){
            data.add(null);
        } else {
            data.add(jtfNewUsername.getText());
        }
        if (jtfNewEmail.getText().equals(PH_NEW_EMAIL) || jtfNewEmail.getText().equals("")) {
            data.add(null);
        } else {
            data.add(jtfNewEmail.getText());
        }
        String newPassword = String.valueOf(jpfNewPasword.getPassword());
        if(newPassword.equals(PH_NEW_PASSWORD) || newPassword.equals("")){
            data.add(null);
        } else {
            data.add(newPassword);
        }
        String repetitionNewPassword = String.valueOf(jpfRepeatNewPasword.getPassword());
        if (repetitionNewPassword.equals(PH_REPEAT_PASSWORD) || repetitionNewPassword.equals("")){
            data.add(null);
        } else {
            data.add(repetitionNewPassword);
        }
        return data;
    }//Cierre del método

    /**
     * Método que compureba si los datos no sea null, si es asi muestran el texto indicado con el tipo secundario.
     * @param username Parámetro que indica el nombre del usuario.
     * @param email Parámetro que indica el correo del usuario.
     */
    public void updateText(String username, String email){
        if (username!= null) {
            jpUsernameText.setSecondaryText(username);
        }
        if (email!=null){
            jpEmailText.setSecondaryText(email);
        }
    }//Cierre del método

    /**
     * Método que indica si el texto es el primario o el secundario.
     * @param primary Parámetro que indica que el texto indiccado es primario
     * @param secondary Parámetro que indica que el texto indicado es secundario
     */
    public void showDialog(String primary, String secondary){
        jdSelectKey.show(primary,secondary);
    }//Cierre del método

    /**
     * Método que indica que se debe cerrar el Dialog
     */
    public void closeDialog(){
        jdSelectKey.close();
    }//Cierre del método

}//Cierre de la clase
