package smartpianoA8.presentation.Controller;


import com.mysql.cj.log.Log;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.LoginView;
import smartpianoA8.presentation.views.RegisterView;
import smartpianoA8.presentation.views.WellcomeFrame;

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
            case RegisterView.tryRegister:

                if(wellcomeFrame.isRegisterCheckBoxAcceptTandC()) {
                    System.out.println(wellcomeFrame.getRegisterNomString());
                    System.out.println(wellcomeFrame.getRegisterCorreuString());
                    System.out.println(wellcomeFrame.getRegisterContrasenyaString());
                    registerUser(wellcomeFrame.getRegisterNomString(),wellcomeFrame.getRegisterCorreuString(),wellcomeFrame.getRegisterContrasenyaString());

                }else {
                    System.out.println("No checkbox!!");
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
