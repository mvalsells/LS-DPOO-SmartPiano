package smartpianoA8.presentation.Controller;

import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.presentation.views.JFMainFrame;
import smartpianoA8.presentation.views.JPProfileView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfileController implements ActionListener {
    // ---- Inici Atributs ----
    private PresentationController presentationController;
    // ---- Fi Atributs ----
    // ---- Inici Constructor ----
    public ProfileController(){

    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----

    public void registerMasterController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            //NavBar
            case JFMainFrame.SONGS:
                presentationController.changeView(JFMainFrame.SONGS);
                break;
            case JFMainFrame.FAVS:
                presentationController.changeView(JFMainFrame.FAVS);
                break;
            case JFMainFrame.PIANO:
                presentationController.changeView(JFMainFrame.PIANO);
                break;
            case JFMainFrame.PROFILE:
                presentationController.changeView(JFMainFrame.PROFILE);
                break;
            //Profile View
            case JPProfileView.Logout:
                presentationController.logout();
                break;
            case JPProfileView.SaveSettings:
                ArrayList<String> data = presentationController.profileViewGetData();
                StringBuilder errorMessage = new StringBuilder();
                try {
                    if (!data.get(0).equals("New username")) {
                        if(!presentationController.updateUsername(data.get(0))){
                           errorMessage.append("Username incorrecto o ya en uso\n");
                        }
                    }
                    if (!data.get(1).equals("New email")) {
                        if(!presentationController.updateEmail(data.get(1))){
                            errorMessage.append("Email incorrecto o ya en uso\n");
                        }
                    }
                    if (!data.get(2).equals("New password")) {
                        presentationController.updatePassword(data.get(2), data.get(3));
                    }
                } catch (PasswordException exeception){
                    errorMessage.append("La contraseña no cumple con los requisitos");
                    if (exeception.isHasNotLowerCase()) {
                        errorMessage.append("\t- No tiene minuscula/s\n");
                    }
                    if (exeception.isHasNotNumber()) {
                        errorMessage.append("\t- No tiene numero/s\n");
                    }
                    if (exeception.isHasNotUpperCase()) {
                        errorMessage.append("\t- No tiene mayuscula/s\n");
                    }
                    if (exeception.isPasswordToShort()) {
                        errorMessage.append("\t- Es demasiado corta\n");
                    }

                }
                if (!errorMessage.toString().equals("")){
                    presentationController.showWarningDialog(errorMessage.toString());
                }
                break;
        }
    }
}
