package smartpianoA8.presentation.Controller;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.WellcomeFrame;

public class MasterController {
    BusinessFacade businessFacade;
    WellcomeController wellcomeController;
    WellcomeFrame wellcomeFrame;
    public MasterController(BusinessFacade businessFacade){
        this.businessFacade=businessFacade;

        //Views
        wellcomeFrame = new WellcomeFrame();

        //Controllers
        wellcomeController = new WellcomeController(wellcomeFrame);
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
