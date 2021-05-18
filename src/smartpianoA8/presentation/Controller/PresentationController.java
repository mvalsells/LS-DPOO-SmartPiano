package smartpianoA8.presentation.Controller;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.persistence.MidiWritter;
import smartpianoA8.presentation.views.JFMainFrame;
import smartpianoA8.presentation.views.JFWellcomeFrame;
import smartpianoA8.presentation.views.customComponents.Teclas;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CLasse pel controlador general de presentació
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see PresentationController
 */
public class PresentationController implements PresentationFacade{

    // ---- Inici Atributs ----
    private BusinessFacade businessFacade;

    //Frame
    private JFMainFrame jfMainFrame;
    private JFWellcomeFrame jfWellcomeFrame;

    //Controllers
    private WellcomeController wellcomeController;
    private SongController songController;
    private FavController favController;
    private ProfileController profileController;
    private PianoController pianoController;
    private PianoCascadeController pianoCascadeController;
    private PlayerController playerController;


    // ---- Fi Atributs ----

    /**
     * Constructor amb els constructors de les diferents vistes
     * @param businessFacade façada de business
     * @param midiWritter escriptor de midi
     */
    public PresentationController(BusinessFacade businessFacade, MidiWritter midiWritter){
        this.businessFacade = businessFacade;

        //Controllers
        wellcomeController = new WellcomeController();
        jfMainFrame = new JFMainFrame(businessFacade.getMasterSongs(), businessFacade.getCurrentUser());
        songController = new SongController();
        favController = new FavController();
        profileController = new ProfileController();
        pianoController = new PianoController(businessFacade.getHMTeclas(),midiWritter);

        pianoCascadeController = new PianoCascadeController();
    }

    /**
     * Mètode per registrar els controllers
     */
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

    /**
     * Mètode per canviar de view
     * @param view la vista
     */
    public void changeView(String view){
        jfMainFrame.changeViewTo(view);
    }

    // ---- Start Business Faced Methods

    /**
     * Mètode per registrar un usuari
     * @param username nom d'usuari
     * @param email email
     * @param password contra
     * @param passwordRepetition contra x2
     * @param type tipus de compta
     * @throws PasswordException control d'errors de la contrassenya
     * @throws UserManagerException control d'erors de l'usuari i email
     */
    public void registerUser(String username, String email, String password, String passwordRepetition, String type) throws PasswordException, UserManagerException {
          businessFacade.registerUser(username, email, password, passwordRepetition,type);
    }

    /**
     * Mètode per desloguejar-se
     */
    public void logout(){
        businessFacade.logoutCurrentUser();
        //Canviar de vista que surti el Login
    }

    /**
     * Mètode per actualitzar l'username
     * @param newUsername nou username
     * @return estat correcte o incorrecte
     */
    public boolean updateUsername(String newUsername){
        return businessFacade.modifyCurrentUserName(newUsername);
    }

    /**
     * Mètode per actualitzar l'email
     * @param newEmail nou email
     * @return estat correcte o incorrecte
     */
    public boolean updateEmail(String newEmail){
        return businessFacade.modifyCurrentUserEmail(newEmail);
    }

    /**
     * Mètode per actualitzar la contrassenya
     * @param newPassword nova contra
     * @param newPasswordRepetition nova contra x2
     * @throws PasswordException control d'errors de la contrassenya
     */
    public void updatePassword(String newPassword, String newPasswordRepetition) throws PasswordException{
        businessFacade.modifyCurrentUserPassword(newPassword,newPasswordRepetition);
    }

    /**
     * Mètode per obtenir les cançons
     * @param id identificador de la cançó
     * @return la cnaçó
     */
    public Song getSongByID(int id){return businessFacade.getSong(id);}

    /**
     * Mètode per obtenir les notes per les cnaçons en cascada
     * @param song la cançó
     * @return ArrayList d'ArrayList de notes, notes per cada canal
     */
    public ArrayList<ArrayList<Notes>> getBusinesMidiNotes(Song song){return businessFacade.getMidiNotes(song);}

    /**
     * Mètode per obtenir informació sobre l'usuari logguejat actual
     * @return l'usuari
     */
    public User getCurrentUser(){return businessFacade.getCurrentUser();}
    // ---- END Business Faced Methods
    // ---- Start WellcomeFrame Methods
    // ---- End WellcomeFrame Methods
    // ---- Start SongView Methods

    /**
     * Mètode per obtenir l'última cançó clicada per operar amb ella
     * @return l'id de la cançó
     */
    public int songControllerGetLastSongPressed(){return songController.getLastSongPressed();}
    // ---- End SongView Methods

    /**
     * Mètode per obtenir noves cançons
     */
    @Override
    public void nuevasCanciones(){
        jfMainFrame.nuevaCanciones();
    }
    // ---- Start FavView Methods
    // ---- End FavView Methods
    // ---- Start PianoView Methods

    /**
     * Mètode per establir el botó de REC actiu
     */
    public void pianoViewSetRecordingPressedIcon(){
        jfMainFrame.pianoViewSetRecordingPressedIcon();
    }

    /**
     * Mètode per establir el botó de REC inactiu
     */
    public void pianoViewSetRecordingUnpressedIcon(){
        jfMainFrame.pianoViewSetRecordingUnpressedIcon();
    }

    /**
     * Mètode per activar el botó JD
     */
    public void pianoViewJDRun(){jfMainFrame.pianoViewJDRun();}

    /**
     * Mètode per desactivar/tancar el botó de JD
     */
    public void pianoViewJDClose(){jfMainFrame.pianoViewJDClose();}

    /**
     * Mètode per obtenir el text del JD
     * @return el text
     */
    public String pianoViewJDGetTextFieldString(){return jfMainFrame.pianoViewJDGetTextFieldString();}

    /**
     * Mètode per saber si el JD s'està clicant
     * @return boolean sobre l'estat
     */
    public boolean pianoViewJDIsCheckBoxSelected(){return jfMainFrame.pianoViewJDIsCheckBoxSelected();}
    // ---- End PianoView Methods
    // ---- Start PianoCascadeView Methods

    // ---- End PianoCascadeView Methods
    // ---- Start ProfileView Methods

    /**
     * Mètode per obtenir informació sobre el perfil
     * @return arraylist amb l'informació de cada tema (nou email, nou username, nova contra...)
     */
    public ArrayList<String> profileViewGetData(){
        return jfMainFrame.profileViewGetData();
    }
    public void profileViewRegenerate(){
        jfMainFrame.profileViewRegenerate();
    }
    // ---- End ProfileView Methods
    // ---- Start Dialog/popups Methods

    /**
     * Mètode per mostrar warnings
     * @param message el missatge a mostrar del warning
     */
    public void showWarningDialog(String message){
        JOptionPane.showMessageDialog(jfMainFrame,message,"Atención",JOptionPane.WARNING_MESSAGE);
    }
    // ---- End Dialog/popups Methods


}
