package smartpianoA8.presentation.Controller;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.persistence.MidiWritter;
import smartpianoA8.presentation.views.JFMainFrame;
import smartpianoA8.presentation.views.JFWellcomeFrame;
import smartpianoA8.presentation.views.customComponents.JPPlayer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * CLasse pel controlador general de presentació
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see PresentationController
 */
public class PresentationController implements PresentationFacade{

    // ---- Inici Atributs ----
    private BusinessFacade businessFacade;
    private MidiWritter midiWritter;

    private boolean isUploaded = false;

    //Frame
    private JFMainFrame jfMainFrame;
    private JFWellcomeFrame jfWellcomeFrame;

    //Controllers
    private WellcomeController wellcomeController;
    private SongController songController;
    private PlaylistController playlistController;
    private ProfileController profileController;
    private PianoController pianoController;
    private PianoCascadeController pianoCascadeController;
    private PlayerController playerController;
    private MainFrameController mainFrameController;
    Thread jpPlayerControllerThread;


    // ---- Fi Atributs ----

    /**
     * Constructor amb els constructors de les diferents vistes
     * @param businessFacade façada de business
     * @param midiWritter escriptor de midi
     */
    public PresentationController(BusinessFacade businessFacade, MidiWritter midiWritter){
        this.businessFacade = businessFacade;
        this.midiWritter = midiWritter;
        //Frames

        //Controllers
        wellcomeController = new WellcomeController();

    }

    /**
     * Mètode per registrar els controllers
     */

    public void loginOK(){
        //TODO Tancar/eliminar JFrame Wellcome
        jfWellcomeFrame.dispose();

        //Crear les vistes
        jfMainFrame = new JFMainFrame(businessFacade.getMasterSongs(), businessFacade.getCurrentUser(), businessFacade.getCurrentUserPlaylist());

        //Crear els controllers
        songController = new SongController();
        playlistController = new PlaylistController();
        profileController = new ProfileController();
        pianoController = new PianoController(businessFacade.getHMTeclas(),midiWritter);
        mainFrameController = new MainFrameController();
        pianoCascadeController = new PianoCascadeController();
        playerController = new PlayerController();
        jpPlayerControllerThread = new Thread(playerController);

        //Registar aquest controller als altres controllers
        songController.registerPresentationController(this);
        playlistController.registerPresentationController(this);
        profileController.registerPresentationController(this);
        pianoController.registerPresentationController(this);
        pianoCascadeController.registerPresentationController(this);
        mainFrameController.registerPresentationController(this);

        //Registrar els controllers a les seves vistes
        jfMainFrame.registerSongViewControllers(songController);
        jfMainFrame.registerPlaylistViewControllers(playerController);
        jfMainFrame.registerProfileViewControllers(profileController);
        jfMainFrame.registerPianoViewControllers(pianoController, pianoController, pianoController);
        jfMainFrame.registerPianoCascadeViewControllers(pianoCascadeController, pianoController, pianoController);
        jfMainFrame.registerMainFrameController(mainFrameController);
    }

    public void logoutOK() {
        if (jfMainFrame != null){
            jfMainFrame.dispose();
        }
        //Crear la vista
        jfWellcomeFrame = new JFWellcomeFrame();

        //Crear el controlles
        wellcomeController = new WellcomeController();
        wellcomeController.registerPresentationController(this);

        //Registrar el controller a la vista
        jfWellcomeFrame.registerController(wellcomeController);
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
        logoutOK();
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

    public void newUserPlaylists(String username){} //TODO playlist manager

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

    public ArrayList<Song> getTop5(){
        return businessFacade.getTop5();
    }

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
    // ---- Start PlaylistView Methods
    public String playlistViewGetJCSongAdderString(){return jfMainFrame.playlistViewGetJCSongAdderString();}
    public String playlistViewGetJCSongRemoveString(){return jfMainFrame.playlistViewGetJCSongRemoveString();}
    public String playlistViewGetJCTriarPlaylistString(){return jfMainFrame.playlistViewGetJCTriarPlaylistString();}
    public void playlistAddSongToPlayList(Song song, PlayList playList){businessFacade.addSongToPlayList(song,playList);}
    public void playlistRemoveSongToPlayList(Song song, PlayList playList){businessFacade.removeSongFromPlayList(song,playList);}
    // ---- End PlaylistView Methods
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



    public void loadPlaylistInPlayer() {
        System.out.println("Yo, updating playlist...");
        isUploaded = true;
    }

    public void playStatusInPlayer() {
        System.out.println("Yo, i'm playing...");
        if(isUploaded) {
            System.out.println("Is plating");
            //todo
        }
    }

    public void pauseStatusInPlayer() {
        System.out.println("Yo, i'm paused...");
        if(isUploaded) {
            //todo
            System.out.println("Is pausing");
        }
    }

    public void nextStatusInPlayer() {
        System.out.println("Yo, changing to next song...");
        if(isUploaded) {
            System.out.println("Is nexting");
            //todo
        }
    }

    public void previousStatusInPlayer() {
        System.out.println("Yo, changing to previous song...");
        if(isUploaded) {
            System.out.println("Is previosing");
            //todo
        }
    }

    public void stopStatusInPlayer() {
        System.out.println("Yo, ended playing...");
        if(isUploaded) {
            System.out.println("Is stopped");
            JOptionPane.showMessageDialog(new Frame(), "You stopped the entire playlist.\nIf you want to play it again you have to re-upload the playlist.", "PLAYLIST STOPPED (NEED TO RE-UPDATE)", JOptionPane.ERROR_MESSAGE);
            //todo
        }
        isUploaded = false;

    }

    public void wellcomeChangePanel(String newPanel) {
        jfWellcomeFrame.changePanel(newPanel);
    }

    public ArrayList<String> wellcomeGetRegisterData(){
        return jfWellcomeFrame.getRegisterData();
    }

    public ArrayList<String> wellcomeGetLoginData() {
        return  jfWellcomeFrame.getLoginData();
    }

    public void login(String id, String password) throws UserManagerException{
        businessFacade.login(id, password);
        loginOK();
    }
}
