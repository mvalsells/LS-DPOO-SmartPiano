package smartpianoA8.presentation.Controller;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;

public class PianoController {
    BusinessFacade businessFacade;
    WellcomeController wellcomeController;
    public PianoController(BusinessFacade businessFacade){
        this.businessFacade=businessFacade;
        wellcomeController = new WellcomeController();
    }

    public void registerAllControlers(){
        wellcomeController.registerController(this);
    }
    //Change views

    //Business Faced Methods
    public void registerUser(String username, String email, String password, String type) throws PasswordException, UserManagerException {
        businessFacade.registerUser(username, email, password, type);
    }

}
