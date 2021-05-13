package smartpianoA8.presentation.Controller;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.JFMainFrame;
import smartpianoA8.presentation.views.JFWellcomeFrame;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PresentationController {

    // ---- Inici Atributs ----
    BusinessFacade businessFacade;

    //Frame
    JFMainFrame jfMainFrame;
    JFWellcomeFrame jfWellcomeFrame;

    //Controllers
    WellcomeController wellcomeController;
    SongController songController;
    FavController favController;
    ProfileController profileController;
    PianoController pianoController;
    PianoCascadeController pianoCascadeController;

    // ---- Fi Atributs ----

    public PresentationController(BusinessFacade businessFacade){
        this.businessFacade = businessFacade;

        //Controllers
        wellcomeController = new WellcomeController();
        jfMainFrame = new JFMainFrame();
        songController = new SongController();
        favController = new FavController();
        profileController = new ProfileController();
        pianoController = new PianoController();
        pianoCascadeController = new PianoCascadeController(null,0f);
    }

    public void registerAllControlers(){
        //Register this controller to other controllers
        wellcomeController.registerMasterController(this);
        songController.registerMasterController(this);
        favController.registerMasterController(this);
        profileController.registerMasterController(this);
        pianoController.registerMasterController(this);
        pianoCascadeController.registerMasterController(this);

        //Register views to their contrller
        //TODO falta wellcome controller, potser no es necessari
        jfMainFrame.registerSongViewControllers(songController);
        jfMainFrame.registerFavViewControllers(favController);
        jfMainFrame.registerProfileViewControllers(profileController);
        jfMainFrame.registerPianoViewControllers(pianoController, pianoController, pianoController);
        jfMainFrame.registerPianoCascadeViewControllers(pianoCascadeController, pianoController, pianoController);

    }
    //Change views
    public void changeView(String view){
        jfMainFrame.changeViewTo(view);
    }

    // ---- Start Business Faced Methods
    public void registerUser(String username, String email, String password, String passwordRepetition, String type) throws PasswordException, UserManagerException {
          businessFacade.registerUser(username, email, password, passwordRepetition,type);
    }
    public void logout(){
        businessFacade.logoutCurrentUser();
    }
    public boolean updateUsername(String newUsername){
        return businessFacade.modifyCurrentUserName(newUsername);
    }
    public boolean updateEmail(String newEmail){
        return businessFacade.modifyCurrentUserEmail(newEmail);
    }
    public void updatePassword(String newPassword, String newPasswordRepetition) throws PasswordException{
        businessFacade.modifyCurrentUserPassword(newPassword,newPasswordRepetition);
    }
    // ---- END Business Faced Methods
    // ---- Start WellcomeFrame Methods
    // ---- End WellcomeFrame Methods
    // ---- Start SongView Methods
    // ---- End SongView Methods
    // ---- Start FavView Methods
    // ---- End FavView Methods
    // ---- Start PianoView Methods
    // ---- End PianoView Methods
    // ---- Start ProfileView Methods
    public ArrayList<String> profileViewGetData(){
        return null;
    }
    // ---- End ProfileView Methods
    // ---- Start Dialog/popups Methods
    public void showWarningDialog(String message){
        JOptionPane.showMessageDialog(jfMainFrame,message,"Atención",JOptionPane.WARNING_MESSAGE);
    }
    // ---- End Dialog/popups Methods


}
