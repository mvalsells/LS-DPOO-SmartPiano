package smartpianoA8.presentation.Controller;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.*;

public class MasterController {
    BusinessFacade businessFacade;
    //Controllers
    WellcomeController wellcomeController;
    MainController mainController;
    //Frames
    WellcomeFrame wellcomeFrame;
    MainFrame mainFrame;

    //Views
    RegisterView registerView;
    LoginView loginView;
    MainViewV2 mainViewV2;

    public MasterController(BusinessFacade businessFacade){
        this.businessFacade = businessFacade;

        //Views
        registerView = new RegisterView();  
        loginView = new LoginView();
        mainViewV2 = new MainViewV2();

        //Frames
        wellcomeFrame = new WellcomeFrame(registerView,loginView);
        mainFrame = new MainFrame(mainViewV2);

        //Controllers
        wellcomeController = new WellcomeController(wellcomeFrame);
        mainController = new MainController(mainFrame);
    }

    public void registerAllControlers(){
        //Register this controller to other controllers
        wellcomeController.registerController(this);
        mainController.registerController(this);

        //Register other controllers to their views
        wellcomeFrame.registerController(wellcomeController);
        mainFrame.registerController(mainController);
    }
    //Change views

    //Business Faced Methods
    public void registerUser(String username, String email, String password, String type) throws PasswordException, UserManagerException {
        //TODO ho he comentat donat que s'ha d'afegir la password repetition i llavors no compila
        //  businessFacade.registerUser(username, email, password, type);
    }

}
