package smartpianoA8.presentation.Controller;


import com.mysql.cj.log.Log;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.LoginView;
import smartpianoA8.presentation.views.RegisterView;
import smartpianoA8.presentation.views.WellcomeFrame;

import javax.sound.midi.MidiChannel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WellcomeController implements ActionListener {



    private WellcomeFrame wellcomeFrame;
    private MasterController masterController;

    public WellcomeController(WellcomeFrame wellcomeFrame){
        this.wellcomeFrame = wellcomeFrame;

    }

    public void registerController(MasterController masterController){
        this.masterController =masterController;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case RegisterView.toLogin:
                wellcomeFrame.changePanel(WellcomeFrame.chgToLogin);
                break;
            case LoginView.toRegister:
                wellcomeFrame.changePanel(WellcomeFrame.chgToRegister);
                break;
            case RegisterView.tryRegister:

                if(!wellcomeFrame.isRegisterCheckBoxAcceptTandC()) {
                    System.out.println("No CheckBox");
                }else if(!wellcomeFrame.getRegisterContrasenyaString().equals(wellcomeFrame.getRegisterRepetirContrasenyaString())){
                    System.out.println("Contrasenyes no coincideixen");
                }else {
                    registerUser(wellcomeFrame.getRegisterNomString(),wellcomeFrame.getRegisterCorreuString(),wellcomeFrame.getRegisterContrasenyaString());
                }
                break;

            case LoginView.tryLogin:
                System.out.println(wellcomeFrame.getLoginNomString());
                System.out.println(wellcomeFrame.getLoginCorreuString());
                System.out.println(wellcomeFrame.getLoginContrasenyaString());
                registerUser(wellcomeFrame.getLoginNomString(),wellcomeFrame.getLoginCorreuString(),wellcomeFrame.getLoginContrasenyaString());

        }
    }



    private void registerUser(String username, String email, String password){
        try {

            masterController.registerUser(username, email, password, User.TYPE_SMARTPIANO);
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

            JOptionPane.showMessageDialog(wellcomeFrame,sb.toString(),"Contraseña incorrecta",JOptionPane.WARNING_MESSAGE);

        } catch (UserManagerException e) {
            e.isUsernameExists();
        }
    }

}
