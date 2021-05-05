package smartpianoA8.presentation.Controller;


import com.mysql.cj.log.Log;
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
    RegisterView registerView;
    LoginView loginView;

    public WellcomeController(WellcomeFrame wellcomeFrame, RegisterView registerView,LoginView loginView){
        this.wellcomeFrame = wellcomeFrame;
        this.registerView = registerView;
        this.loginView = loginView;
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
                System.out.println(registerView.getNomString());
                System.out.println(registerView.getCorreuString());
                System.out.println(registerView.getContrasenyaString());
                registerUser(registerView.getNomString(),registerView.getCorreuString(),registerView.getContrasenyaString());
                break;
            case LoginView.tryLogin:
                System.out.println(loginView.getNomString());
                System.out.println(loginView.getCorreuString());
                System.out.println(loginView.getContrasenyaString());
                registerUser(loginView.getNomString(),loginView.getCorreuString(),loginView.getContrasenyaString());
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
