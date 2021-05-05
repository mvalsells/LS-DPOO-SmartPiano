package smartpianoA8.presentation.Controller;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.LoginView;
import smartpianoA8.presentation.views.RegisterView;
import smartpianoA8.presentation.views.WellcomeFrame;

public class MasterController {
    BusinessFacade businessFacade;
    WellcomeController wellcomeController;
    WellcomeFrame wellcomeFrame;
    RegisterView registerView;
    LoginView loginView;
    public MasterController(BusinessFacade businessFacade){
        this.businessFacade=businessFacade;

        //Views
        registerView = new RegisterView();
        loginView = new LoginView();
        wellcomeFrame = new WellcomeFrame(registerView,loginView);

        //Controllers
        wellcomeController = new WellcomeController(wellcomeFrame,registerView,loginView);
    }

    public void registerAllControlers(){
        //Register this controller to other controllers
        wellcomeController.registerController(this);

        //Register other controllers to their views
        wellcomeFrame.registerController(wellcomeController);

    }
    //Change views

    //Business Faced Methods
    public void registerUser(String username, String email, String password, String type) throws PasswordException, UserManagerException {
        businessFacade.registerUser(username, email, password, type);
    }

}
