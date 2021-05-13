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

public class WellcomeController implements ActionListener {


    // ---- Inici Atributs ----
    private JFWellcomeFrame JFWellcomeFrame;
    private PresentationController presentationController;

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public WellcomeController(){
        //this.JFWellcomeFrame = JFWellcomeFrame;
    }
    // ---- Fi Constructors ----
    // ---- Inici Metodes ----

    public void registerMasterController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }
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
                }else if(!JFWellcomeFrame.getRegisterContrasenyaString().equals(JFWellcomeFrame.getRegisterRepetirContrasenyaString())){
                    System.out.println("Contrasenyes no coincideixen");
                }else {
                    registerUser(JFWellcomeFrame.getRegisterNomString(), JFWellcomeFrame.getRegisterCorreuString(), JFWellcomeFrame.getRegisterContrasenyaString());
                }
                break;

            case JPLoginView.tryLogin:
                System.out.println(JFWellcomeFrame.getLoginNomString());
                System.out.println(JFWellcomeFrame.getLoginCorreuString());
                System.out.println(JFWellcomeFrame.getLoginContrasenyaString());
                registerUser(JFWellcomeFrame.getLoginNomString(), JFWellcomeFrame.getLoginCorreuString(), JFWellcomeFrame.getLoginContrasenyaString());

        }
    }



    private void registerUser(String username, String email, String password){
        try {

            presentationController.registerUser(username, email, password, User.TYPE_SMARTPIANO);
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
