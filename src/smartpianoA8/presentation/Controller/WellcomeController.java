package smartpianoA8.presentation.Controller;


import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.WellcomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WellcomeController implements ActionListener {
    
    WellcomeFrame wellcomeFrame;
    PianoController pianoController;
    public WellcomeController(){
        wellcomeFrame  = new WellcomeFrame();
        wellcomeFrame.registerController(this);
    }
    public void registerController(PianoController pianoController){
        this.pianoController=pianoController;
    }
    /*public void changePanel(String string, CardLayout cards, JPanel panel){
        if(string.equals("ToRegister")){
            cards.show(panel,"RegisterView");
        }else if(string.equals("ToLogin")){
            cards.show(panel,"LoginView");
        }
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("ToRegister")){
            wellcomeFrame.changePanel("ToRegister");
        }else if(e.getActionCommand().equals("ToLogin")){
            wellcomeFrame.changePanel("ToLogin");
        }else if(e.getActionCommand().equals("TryRegister")){
            System.out.println(wellcomeFrame.getRegisterViewNomString());
            System.out.println(wellcomeFrame.getRegisterViewCorreuString());
            System.out.println(wellcomeFrame.getRegisterViewContrasenyaString());
            registerUser(wellcomeFrame.getRegisterViewNomString(),wellcomeFrame.getRegisterViewCorreuString(),wellcomeFrame.getRegisterViewContrasenyaString());
        }else if(e.getActionCommand().equals("TryLogin")){
            registerUser(wellcomeFrame.getLoginViewNomString(),wellcomeFrame.getLoginViewCorreuString(),wellcomeFrame.getLoginViewContrasenyaString());
        }

    }



    private void registerUser(String username, String email, String password){
        try {
            pianoController.registerUser(username, email, password, User.TYPE_SMARTPIANO);
        } catch (PasswordException e) {
            e.isHasNotLowerCase();
            e.isHasNotNumber();
            e.isHasNotUpperCase();
            e.isPasswordToShort();
        } catch (UserManagerException e) {
            e.isUsernameExists();
        }
    }

}
