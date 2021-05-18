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
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Classe del controllador de benvinguda login/regitre
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see ActionListener
 */
public class WellcomeController implements ActionListener {


    // ---- Inici Atributs ----
    private PresentationController presentationController;

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    /**
     * Constructor buit
     */
    public WellcomeController(){
    }
    // ---- Fi Constructors ----
    // ---- Inici Metodes ----

    /**
     * Mètode per registrar el controller a la presentació
     * @param presentationController la presentació
     */
    public void registerPresentationController(PresentationController presentationController) {
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
                presentationController.wellcomeChangePanel(JFWellcomeFrame.chgToLogin);
                break;
            case JPLoginView.toRegister:
                presentationController.wellcomeChangePanel(JFWellcomeFrame.chgToRegister);
                break;
            case JPRegisterView.tryRegister:
                registerUser();
                break;

            case JPLoginView.tryLogin:
                loginUser();
                break;
        }
    }

    private void loginUser() {
        ArrayList<String> data = presentationController.wellcomeGetLoginData();
        if (data.get(0) == null && data.get(1) != null){
            try {
                presentationController.login(data.get(0), data.get(1));
            } catch (UserManagerException e){
                presentationController.showWarningDialog("Datos de login incorrectos");
            }
        }
    }


    /**
     * Mètode per registar un usuari
     *
     */
    private void registerUser(){
        ArrayList<String> data = presentationController.wellcomeGetRegisterData();
        if(data.get(0).equals("false")) {
            System.out.println("No CheckBox");
        }else {
            try {
                presentationController.registerUser(data.get(1), data.get(2), data.get(3), data.get(4), User.TYPE_SMARTPIANO);

            } catch (PasswordException e) {
                StringBuilder message = new StringBuilder();
                message.append("· La contraseña no cumple con los requisitos:\n");
                if (e.isHasNotLowerCase()) {
                    message.append("- No tiene minuscula/s\n");
                }
                if (e.isHasNotNumber()) {
                    message.append("- No tiene numero/s\n");
                }
                if (e.isHasNotUpperCase()) {
                    message.append("\t- No tiene mayuscula/s\n");
                }
                if (e.isPasswordToShort()) {
                    message.append("\t- Es demasiado corta\n");
                }
                presentationController.showWarningDialog(message.toString());
            } catch (UserManagerException e) {
                e.isUsernameExists();
            }
        }
    }


}
