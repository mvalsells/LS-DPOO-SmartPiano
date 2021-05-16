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
            case JPProfileView.LOGOUT:
                presentationController.logout();
                break;
            case JPProfileView.SAVE_SETTING:
                ArrayList<String> data = presentationController.profileViewGetData();
                StringBuilder message = new StringBuilder();
                try {
                    if (data.get(0) != null) {
                        if(!presentationController.updateUsername(data.get(0))){
                           message.append("·Nombre de usuari actualizado\n");
                        } else {
                            message.append("·Nombre de usuario incorrecto o ya en uso\n");
                        }
                    }
                    if (data.get(1) != null) {
                        if(presentationController.updateEmail(data.get(1))) {
                           message.append("·Email actualizado\n");
                        } else {
                                message.append("·Email incorrecto o ya en uso\n");
                        }
                    }
                    if (data.get(2) != null && data.get(3) != null) {
                        presentationController.updatePassword(data.get(2), data.get(3));
                        message.append("·Contraseña actualizada\n");
                    }
                } catch (PasswordException exeception){
                    message.append("· La contraseña no cumple con los requisitos:\n");
                    if (exeception.isHasNotLowerCase()) {
                        message.append("- No tiene minuscula/s\n");
                    }
                    if (exeception.isHasNotNumber()) {
                        message.append("- No tiene numero/s\n");
                    }
                    if (exeception.isHasNotUpperCase()) {
                        message.append("\t- No tiene mayuscula/s\n");
                    }
                    if (exeception.isPasswordToShort()) {
                        message.append("\t- Es demasiado corta\n");
                    }
                }
                if (!message.toString().equals("")){
                    presentationController.showWarningDialog(message.toString());
                }
                break;
        }
    }
}
