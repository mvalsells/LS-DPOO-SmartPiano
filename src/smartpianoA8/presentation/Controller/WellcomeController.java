package smartpianoA8.presentation.Controller;


import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.LoginView;
import smartpianoA8.presentation.views.RegisterView;
import smartpianoA8.presentation.views.WellcomeFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WellcomeController implements ActionListener {
    
    WellcomeFrame wellcomeFrame;
    MasterController masterController;


    public WellcomeController(WellcomeFrame wellcomeFrame){
        this.wellcomeFrame = wellcomeFrame;
    }
    public void registerController(MasterController masterController){
        this.masterController =masterController;
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

        switch (e.getActionCommand()){
            case RegisterView.toLogin:
                wellcomeFrame.changePanel(WellcomeFrame.chgToLogin);
                break;
            case LoginView.toRegister:
                wellcomeFrame.changePanel(WellcomeFrame.chgToRegister);
                break;
        }

        /*if(e.getActionCommand().equals("ToRegister")){
            wellcomeFrame.changePanel("ToRegister");
        }else if(e.getActionCommand().equals("ToLogin")){
            wellcomeFrame.changePanel("ToLogin");
        }else */

        if(e.getActionCommand().equals("TryRegister")){
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
            masterController.registerUser(username, email, password, User.TYPE_SMARTPIANO);
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
