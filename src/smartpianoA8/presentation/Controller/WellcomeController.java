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
    public void changePanel(String string, CardLayout cards, JPanel panel){
        if(string.equals("ToRegister")){
            cards.show(panel,"RegisterView");
        }else if(string.equals("ToLogin")){
            cards.show(panel,"LoginView");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("ToRegister")){
            changePanel("ToRegister",wellcomeFrame.getCards(),wellcomeFrame.getMainPanel());
        }else if(e.getActionCommand().equals("ToLogin")){
            changePanel("ToLogin",wellcomeFrame.getCards(),wellcomeFrame.getMainPanel());
        }else if(e.getActionCommand().equals("TryRegister")){
            System.out.println(wellcomeFrame.getRegisterView().getNom().getText());
            System.out.println(wellcomeFrame.getRegisterView().getCorreu().getText());
            System.out.println(wellcomeFrame.getRegisterView().getContrasenya().getText());
            registerUser(wellcomeFrame.getRegisterView().getNom().getText(),wellcomeFrame.getRegisterView().getCorreu().getText(),wellcomeFrame.getRegisterView().getContrasenya().getText());
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
