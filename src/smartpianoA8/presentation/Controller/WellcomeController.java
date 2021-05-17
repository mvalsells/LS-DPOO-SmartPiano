package smartpianoA8.presentation.Controller;


import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.JFWellcomeFrame;
import smartpianoA8.presentation.views.JPLoginView;
import smartpianoA8.presentation.views.JPRegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe del controllador de benvinguda login/regitre
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see ActionListener
 */
public class WellcomeController implements ActionListener {


    // ---- Inici Atributs ----
    private JFWellcomeFrame JFWellcomeFrame;
    private PresentationController presentationController;

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    /**
     * Constructor buit
     */
    public WellcomeController(){
        //this.JFWellcomeFrame = JFWellcomeFrame;
    }
    // ---- Fi Constructors ----
    // ---- Inici Metodes ----

    /**
     * Mètode per registrar el controller a la presentació
     * @param presentationController la presentació
     */
    public void registerMasterController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }

    /**
     * Mètode per detectar i canviar de vista
     * @param e action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case JPRegisterView.toLogin:
                JFWellcomeFrame.changePanel(JFWellcomeFrame.chgToLogin);
                break;
            case JPLoginView.toRegister:
                JFWellcomeFrame.changePanel(JFWellcomeFrame.chgToRegister);
                break;
            case JPRegisterView.tryRegister:

                if(!JFWellcomeFrame.isRegisterCheckBoxAcceptTandC()) {
                    System.out.println("No CheckBox");
                }else {
                    registerUser(JFWellcomeFrame.getRegisterNomString(), JFWellcomeFrame.getRegisterCorreuString(), JFWellcomeFrame.getRegisterContrasenyaString(), JFWellcomeFrame.getRegisterRepetirContrasenyaString());
                }
                break;

            case JPLoginView.tryLogin:
                System.out.println(JFWellcomeFrame.getLoginNomString());
                System.out.println(JFWellcomeFrame.getLoginCorreuString());
                System.out.println(JFWellcomeFrame.getLoginContrasenyaString());
                registerUser(JFWellcomeFrame.getLoginNomString(), JFWellcomeFrame.getLoginCorreuString(), JFWellcomeFrame.getLoginContrasenyaString(),JFWellcomeFrame.getRegisterRepetirContrasenyaString());

        }
    }


    /**
     * Mètode per registar un usuari
     * @param username nom
     * @param email email
     * @param password contra
     * @param passwordRepetition contra repetida x2
     */
    private void registerUser(String username, String email, String password, String passwordRepetition){
        try {

            presentationController.registerUser(username, email, password, passwordRepetition, User.TYPE_SMARTPIANO);
            System.out.println("patata pringada");
        } catch (PasswordException e) {

            StringBuilder sb = new StringBuilder();

            if (e.isHasNotLowerCase()) {
                sb.append("- No tiene minuscula/s\n");
                System.out.println("patata");
            }
            if (e.isHasNotNumber()) {
                sb.append("- No tiene numero/s\n");
                System.out.println("patata");
            }
            if (e.isHasNotUpperCase()) {
                sb.append("- No tiene mayuscula/s\n");
                System.out.println("patata");
            }
            if (e.isPasswordToShort()) {
                sb.append("- Es demasiado corta\n");
                System.out.println("patata");
            }

            JOptionPane.showMessageDialog(JFWellcomeFrame,sb.toString(),"Contraseña incorrecta",JOptionPane.WARNING_MESSAGE);

        } catch (UserManagerException e) {
            e.isUsernameExists();
        }
    }


}
