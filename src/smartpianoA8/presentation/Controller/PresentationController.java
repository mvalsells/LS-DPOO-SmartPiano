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
import smartpianoA8.presentation.views.JFStatisticsView;
import smartpianoA8.presentation.views.JFTop5View;
import smartpianoA8.presentation.views.JFWellcomeFrame;
import smartpianoA8.presentation.views.customComponents.Tecla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * CLasse pel controlador general de presentaci√≥
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see PresentationController
 */
public class PresentationController implements PresentationFacade {

    // ---- Inici Atributs ----
    private BusinessFacade businessFacade;
    private MidiWritter midiWritter;
    public static final String ELIMINAR_FROM_SONGS = "eliminarFromSongs";
    public static final String ELIMINAR_FROM_PLAYLISTS = "eliminarFromPlaylists";
    public static final String ELIMINAR_FROM_SONGS_WHILE_IN_PLAYLISTS = "eliminarFromPlaylistsWhileInPlaylists";
    private boolean isUploaded = false;

    //Frame
    private JFMainFrame jfMainFrame;
    private JFWellcomeFrame jfWellcomeFrame;
    private JFStatisticsView jfStatisticsView;
    private JFTop5View jfTop5View;

    //Controllers
    private WellcomeController wellcomeController;
    private SongController songController;
    private PlaylistController playlistController;
    private ProfileController profileController;
    private PianoController pianoController;
    //private PianoCascadeController pianoCascadeController;
    private ObtainNotesWhilePlayingController obtainNotesWhilePlayingController;
    private Thread pianoCascadeThread;
    private PlayerController playerController;
    private MainFrameController mainFrameController;
    private Thread jpPlayerControllerThread;

    //Last id song pressed
    private int lastSongPressed;

    // ---- Fi Atributs ----

    /**
     * Constructor amb els constructors de les diferents vistes
     *
     * @param businessFacade fa√ßada de business
     * @param midiWritter    escriptor de midi
     */
    public PresentationController(BusinessFacade businessFacade, MidiWritter midiWritter) {
        this.businessFacade = businessFacade;
        this.midiWritter = midiWritter;
        //Frames

        //Controllers
        wellcomeController = new WellcomeController();

    }

    /**
     * M√®tode per registrar els controllers
     */

    public void loginOK() {


        //Crear les vistes
        jfStatisticsView = new JFStatisticsView(businessFacade.getNumMinutsCurrentUser(), businessFacade.getNumReproducionsCurrentUser());
        jfTop5View = new JFTop5View(businessFacade.getTop5());
        jfMainFrame = new JFMainFrame(businessFacade.getUserAndMasterSongs(getCurrentUser().getUsername()), businessFacade.getCurrentUser(), businessFacade.getCurrentUserPlaylist());
        if (jfWellcomeFrame != null) {
            jfWellcomeFrame.dispose();
        }

        //Crear els controllers
        songController = new SongController();
        playlistController = new PlaylistController();
        profileController = new ProfileController();
        pianoController = new PianoController(businessFacade.getHMTeclas(), midiWritter);
        mainFrameController = new MainFrameController();
        //pianoCascadeController = new PianoCascadeController(jfMainFrame.getJpPiano());
        obtainNotesWhilePlayingController = new ObtainNotesWhilePlayingController(jfMainFrame.getJpPiano());
        playerController = new PlayerController(jfMainFrame.getPlayerView());
        jpPlayerControllerThread = new Thread(playerController);

        //Thread
        //pianoCascadeThread = new Thread(pianoCascadeController);

        //Registar aquest controller als altres controllers
        songController.registerPresentationController(this);
        playlistController.registerPresentationController(this);
        profileController.registerPresentationController(this);
        pianoController.registerPresentationController(this);
        //pianoCascadeController.registerPresentationController(this);
        obtainNotesWhilePlayingController.registerPresentationController(this);
        playlistController.registerPresentationController(this);
        mainFrameController.registerPresentationController(this);
        playerController.registerPresentationController(this);

        //Registrar els controllers a les seves vistes
        jfMainFrame.registerSongViewControllers(songController);
        jfMainFrame.registerPlaylistViewControllers(playlistController,playlistController);
        jfMainFrame.registerProfileViewControllers(profileController, profileController, profileController);
        jfMainFrame.registerPianoViewControllers(pianoController, pianoController, pianoController);
        //jfMainFrame.registerPianoCascadeViewControllers(pianoCascadeController, pianoController, pianoController);
        jfMainFrame.registerMainFrameController(mainFrameController);

        jfMainFrame.setPlaylistsNames(getUserPlaylistsStrings());

        jpPlayerControllerThread.start();
    }

    public void logoutOK() {
        if (jfMainFrame != null) {
            jfMainFrame.dispose();
        }
        if (jfTop5View != null) {
            jfTop5View.dispose();
        }
        if (jfStatisticsView!=null){
            jfTop5View.dispose();
        }
        //Crear la vista
        jfWellcomeFrame = new JFWellcomeFrame();

        //Crear el controlles
        wellcomeController = new WellcomeController();
        wellcomeController.registerPresentationController(this);

        //Registrar el controller a la vista
        jfWellcomeFrame.registerController(wellcomeController);

        }
    /**
     * Setter atribut atribuir el ID de l'lultima can√ßo que s'apreta
     *
     * @param songID
     */
    public void setLastSongPressed(int songID){this.lastSongPressed = songID;}
    /**
     * Getter per obtenir l'√ļltima can√ß√≥ clicada per operar amb ella
     *
     * @return l'id de la can√ß√≥
     */
    public int getLastSongPressed() {
        return lastSongPressed;
    }
    //Change views

    /**
     * M√®tode per canviar de view
     *
     * @param view la vista
     */
    public void changeView(String view) {
        jfMainFrame.changeViewTo(view);
    }

    // ---- Start Business Faced Methods

    /**
     * M√®tode per registrar un usuari, si el registre √©s correcte fa login
     * @param username nom d'usuari
     * @param email email
     * @param password contra
     * @param passwordRepetition contra x2
     * @param type tipus de compta
     * @throws PasswordException control d'errors de la contrassenya
     * @throws UserManagerException control d'erors de l'usuari i email
     */
    public void registerUser(String username, String email, String password, String passwordRepetition, String type) throws PasswordException, UserManagerException {
        businessFacade.registerUser(username, email, password, passwordRepetition, type);
        showWarningDialog("Registro correcto");
        businessFacade.login(username,password);
        loginOK();
    }

    /**
     * M√®tode per desloguejar-se
     */
    public void logout() {
        businessFacade.logoutCurrentUser();
        logoutOK();
        //Canviar de vista que surti el Login
    }

    /**
     * M√®tode per actualitzar l'username
     *
     * @param newUsername nou username
     * @return estat correcte o incorrecte
     */
    public boolean updateUsername(String newUsername){
        return businessFacade.modifyCurrentUserName(newUsername);
    }

    /**
     * M√®tode per actualitzar l'email
     *
     * @param newEmail nou email
     * @return estat correcte o incorrecte
     */
    public boolean updateEmail(String newEmail){
        return businessFacade.modifyCurrentUserEmail(newEmail);
    }

    /**
     * M√®tode per actualitzar la contrassenya
     * @param newPassword nova contra
     * @param newPasswordRepetition nova contra x2
     * @throws PasswordException control d'errors de la contrassenya
     */
    public void updatePassword(String newPassword, String newPasswordRepetition) throws PasswordException{
        businessFacade.modifyCurrentUserPassword(newPassword,newPasswordRepetition);
    }

    /**
     * M√®tode per obtenir les can√ßons
     *
     * @param id identificador de la can√ß√≥
     * @return la cna√ß√≥
     */
    public Song getSongByID(int id) {
        return businessFacade.getSong(id);
    }

    /**
     * M√®tode per obtenir les notes per les cna√ßons en cascada
     *
     * @param song la can√ß√≥
     * @return ArrayList d'ArrayList de notes, notes per cada canal
     */
    public ArrayList<ArrayList<Notes>> getBusinesMidiNotes(Song song) {
        return businessFacade.getMidiNotes(song);
    }

    /**
     * M√®tode per obtenir informaci√≥ sobre l'usuari logguejat actual
     *
     * @return l'usuari
     */
    public User getCurrentUser() {
        return businessFacade.getCurrentUser();
    }
    /**
     * Metode que augmenta un cop el nombre de reproduccions d'una can√ß√≥ per tots els usuaris pel top5
     * @param IDsong id de la can√ß√≥ a la que augmentar el num de reproduccions
     */
    public void songPlayed(int IDsong){
        businessFacade.songPlayed(IDsong);
    }

    /**
     * M√®tode per obtenir les can√ßons de master
     * @return ArrayList de les can√ßons de master
     */
    //Temporal
    public ArrayList<Song> getMasterSongs(){return businessFacade.getMasterSongs();}

    /**
     * M√®tode per obtenir les can√ßons publiques i de master
     * @return Arraylist de les can√ßons
     */
    public ArrayList<Song> getPublicAndMasterSongs(){return businessFacade.getPublicAndMasterSongs();}

    /**
     * M√®tode per obtenir les palylists de l'usuari
     * @return ArrayList de PlayLists
     */
    public ArrayList<PlayList> getUserPlaylists(){return businessFacade.getCurrentUserPlaylist();}

    /**
     * M√®otde per
     * @return
     */
    public ArrayList<String> getUserPlaylistsStrings() {

        ArrayList<String> stringPlaylists = new ArrayList<>();
        ArrayList<PlayList> playLists = businessFacade.getCurrentUserPlaylist();

        for (PlayList playList : playLists) {
            stringPlaylists.add(playList.getNom());
        }


        return stringPlaylists;
    }

    public HashMap<Integer, Tecla> getHMteclas(){
     return businessFacade.getHMTeclas();
    }
    public void setHMteclas(HashMap<Integer, Tecla> hmTeclas){
        businessFacade.setHmTeclas(hmTeclas);
        pianoController.setHmTeclas(hmTeclas);
    }

    public void removeCurrentUser(){
        businessFacade.removeCurrentUser();
        logoutOK();
    }

    // ---- END Business Faced Methods
    // ---- Start WellcomeFrame Methods
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



    public void mainFrameControllerSetShowingPiano(Boolean showingPiano) { mainFrameController.setShowingPiano(showingPiano); }

    public void mainFrameControllerSetShowingPlaylists(Boolean showingPlaylists) { mainFrameController.setShowingPlaylists(showingPlaylists); }

    public void mainFrameControllerSetShowingProfile(Boolean showingProfile) { mainFrameController.setShowingProfile(showingProfile); }

    public void mainFrameControllerSetShowingSongs(Boolean showingSongs) { mainFrameController.setShowingSongs(showingSongs); }
    // ---- End WellcomeFrame Methods
    // ---- Start SongView Methods

    public void removeSongFromDBAndLocal(Song song){businessFacade.removeSongFromDBAndLocal(song);}



    // ---- End SongView Methods

    /**
     * M√®tode per obtenir noves can√ßons
     */
    @Override
    public void nuevasCanciones(Song song) {

        if (jfMainFrame != null) {
            jfMainFrame.nuevaCanciones(song, "SONGS", songController);
            jfMainFrame.nuevaCanciones(song, "PLAYLISTS", null);
        }
    }
    public void updateStatsView(){
        if(jfStatisticsView!=null){
            jfStatisticsView.updateStaticsView(businessFacade.getNumMinutsCurrentUser(), businessFacade.getNumReproducionsCurrentUser());
        }
        if (jfTop5View!=null){
            jfTop5View.updateTop5View(businessFacade.getTop5());
        }
    }

    // ---- Start PlaylistView Methods
    public void playlistViewUpdateJPPlaylistView(ArrayList<PlayList> hasPlayLists){jfMainFrame.playlistViewUpdateJPPlaylistView(hasPlayLists,businessFacade.getUserAndMasterSongs(getCurrentUser().getUsername()));
        jfMainFrame.playlistViewUpdateRegisterControllerForPlaylistSetting(playlistController);
    }


    public void playlistViewUpdateWhenAddSong(Song song){jfMainFrame.playlistViewUpdateWhenAddSong(song,playlistController);}
    public void playlistViewUpdateWhenRemoveSong(Song song,String type){ jfMainFrame.UpdateWhenRemoveSong(song,type); }

    public void playlistAddPlayList(String playlistName){businessFacade.addPlayList(playlistName,getCurrentUser().getUsername());
        jfMainFrame.playlistViewUpdateRegisterControllersWhenNewPlaylist(playlistController,playlistGetPlayListByName(playlistName), businessFacade.getUserAndMasterSongs(getCurrentUser().getUsername()));jfMainFrame.setPlaylistsNames(getUserPlaylistsStrings());}
    public void playlistRemovePlaylist(String playlistName){
        if(playlistName!=null) {
            businessFacade.removePlayList(playlistGetPlayListByName(playlistName));
            jfMainFrame.playlistViewUpdateRegisterControllerWhenDeletePlaylist();
            jfMainFrame.setPlaylistsNames(getUserPlaylistsStrings());
            //System.out.println("eliminando...");
        }else{JOptionPane.showMessageDialog(jfMainFrame,"No hay playlists a eliminar! Crea una antes","Atenci√≥n",JOptionPane.WARNING_MESSAGE);}
    }

    /*public void playlistViewUpdateRegisterControllerWhenNewPlaylist(String playlistName){
        jfMainFrame.playlistViewUpdateRegisterControllersWhenNewPlaylist(playlistController,playlistName);
    }*/

    public void playlistViewChangeViewTo(String newView){jfMainFrame.playlistViewChangeViewTo(newView);}
    public void playlistJDPlaylistCreatorRun()  {  jfMainFrame.playlistJDPlaylistCreatorRun(); /*jfMainFrame.setPlaylistsNames(getUserPlaylistsStrings());*/ }
    public void playlistJDPlaylistCreatorClose(){  jfMainFrame.playlistJDPlaylistCreatorClose(); /*jfMainFrame.setPlaylistsNames(getUserPlaylistsStrings());*/}


    public String playlistViewGetJCSongAdderString(){return jfMainFrame.playlistViewGetJCSongAdderString();}
    public String playlistViewGetJCSongRemoveString(){return jfMainFrame.playlistViewGetJCSongRemoveString();}
    public String playlistViewGetJCTriarPlaylistString(){return jfMainFrame.playlistViewGetJCTriarPlaylistString();}
    public String jdPlaylistGetTextFieldString(){return jfMainFrame.jdPlaylistGetTextFieldString();}

    public void playlistAddSongToPlayList(Song song, PlayList playList){businessFacade.addSongToPlayList(song,playList);}
    public void playlistRemoveSongToPlayList(Song song, PlayList playList){businessFacade.removeSongFromPlayList(song,playList);}
    public PlayList playlistGetPlayListByName(String name){return businessFacade.getPlayListByName(name);}
    public Song songGetSongByName(String name){return businessFacade.getSongByName(name);}
    public ArrayList<Song> getPlayListSongsByPlayListName(String name){
        return businessFacade.getPlayListSongsByPlayListName(name);
    }
    public Boolean isPlayListEmpty(String nom){
        return businessFacade.isPlayListEmpty(nom);
    }
    public Boolean playlistDoesPlayListExists(String nom){
        return businessFacade.doesPlayListExist(nom);
    }

    // ---- End PlaylistView Methods
    // ---- Start PianoView Methods
    /**
     * M√©todo para resaltar las teclas negras cuando las blancas son pintadas. Le pasamos el valor de la tecla blanca asi sabemos que nregra resaltar.
     * @param nota
     */
    public void pianoViewRepainAllBlacks(int nota){jfMainFrame.pianoViewRepainAllBlacks(nota);}

    /**
     * M√©todo que cambia el icono a un boton enviado como par√°metro.
     * @param button boton asignado que cambiara el icono.
     */
    public void pianoViewSetPressedIcon(JButton button){
        jfMainFrame.pianoViewSetPressedIcon(button);
    }

    /**
     * M√©todo que cambia el icono a un boton enviado como par√°metro.
     * @param button boton asignado que cambiara el icono.
     */
    public void pianoViewSetUnpressedIcon(JButton button){
        jfMainFrame.pianoViewSetUnpressedIcon(button);
    }

    /*public void pianoViewSetPlayButtonPressedIcon(){jfMainFrame.pianoViewSetPlayButtonPressedIcon();}
    public void pianoViewSetPlayButtonUnpressedIcon(){jfMainFrame.pianoViewSetPlayButtonUnpressedIcon();}*/

    /**
     * M√®tode per activar el bot√≥ JD
     */
    public void pianoViewJDRun(){jfMainFrame.pianoViewJDRun();}

    /**
     * M√®tode per desactivar/tancar el bot√≥ de JD
     */
    public void pianoViewJDClose(){jfMainFrame.pianoViewJDClose();}

    /**
     * M√®tode per obtenir el text del JD
     * @return el text
     */
    public String pianoViewJDGetTextFieldString(){return jfMainFrame.pianoViewJDGetTextFieldString();}

    /**
     * M√®tode per saber si el JD s'est√† clicant
     * @return boolean sobre l'estat
     */
    public boolean pianoViewJDIsCheckBoxSelected(){return jfMainFrame.pianoViewJDIsCheckBoxSelected();}
    // ---- End PianoView Methods
    // ---- Start PianoCascadeView Methods
    public Boolean pianoCascadeIsNoteWhite(int nota){return obtainNotesWhilePlayingController.isBlanca(nota);}
    public int pianoCascadeCanviNote(int note,boolean isNoteWhite){return obtainNotesWhilePlayingController.canviaNote(note,isNoteWhite);}
    public void startCascade() {
        /*pianoCascadeThread.start();*/

        obtainNotesWhilePlayingController.playAndGet(businessFacade.getSong(lastSongPressed));
        pianoController.setIsPlaying(true);
    }
    public void stopCascade(){
        obtainNotesWhilePlayingController.close();
        pianoController.setIsPlaying(false);

    }

    public float getMaxMilis(){
        return businessFacade.getTotalTicks();
    }


    /**
     * M√®tode per obtenir informaci√≥ sobre el perfil
     * @return arraylist amb l'informaci√≥ de cada tema (nou email, nou username, nova contra...)
     */
    public ArrayList<String> profileViewGetData(){
        return jfMainFrame.profileViewGetData();
    }
    public void profileViewUpdateText(){
        User tmpUser = businessFacade.getCurrentUser();
        jfMainFrame.profileViewUpdateText(tmpUser.getUsername(), tmpUser.getEmail());
    }
    public void profileViewShowDialog(String primary, String secondary){
        jfMainFrame.profileViewShowDialog(primary,secondary);
    }
    public void profileViewCloseDialog(){
        jfMainFrame.profileViewCloseDialog();
    }
    // ---- End ProfileView Methods
    // ---- Start Dialog/popups Methods

    /**
     * M√®tode per mostrar warnings
     * @param message el missatge a mostrar del warning
     */
    public void showWarningDialog(String message){
        JOptionPane.showMessageDialog(jfMainFrame,message,"Atenci√≥n",JOptionPane.WARNING_MESSAGE);
    }
    // ---- End Dialog/popups Methods



    public void loadPlaylistInPlayer() {
        //System.out.println("Yo, updating playlist...");

        /*ArrayList<Song> test2 = new ArrayList<>();
        Song song = new Song(0,0,null,null,null,"resources/midiFiles/ChristianTestLele/88196.mid",1,null,null);
        Song song2 = new Song(0,0,null,null,null,"resources/midiFiles/ChristianTestLele/37900.mid",1,null,null);
        Song song3 = new Song(0,0,null,null,null,"resources/midiFiles/ChristianTestLele/110325.mid",1,null,null);
        Song song4 = new Song(0,0,null,null,null,"resources/midiFiles/ChristianTestLele/298.mid",1,null,null);
        Song song5 = new Song(0,0,null,null,null,"resources/midiFiles/ChristianTestLele/85261.mid",1,null,null);
        test2.add(song5);
        test2.add(song3);
        test2.add(song2);
        test2.add(song4);
        test2.add(song);*/

        if(jfMainFrame.getJComboBoxString().equals("If you want to play your playlist you must select it before and update pressing the button ---->")) {
            JOptionPane.showMessageDialog(new Frame(), "This is not a valid playlist! :(\nSelect a valid one.", "PLAYLIST NOT VALID", JOptionPane.ERROR_MESSAGE);
        } else {
            if(!businessFacade.doesPlayListExist(jfMainFrame.getJComboBoxString())) {
                JOptionPane.showMessageDialog(new Frame(), "This playlist does not exist.. :(\nSelect a valid one.", "PLAYLIST NOT VALID", JOptionPane.ERROR_MESSAGE);
            } else if (businessFacade.isPlayListEmpty(jfMainFrame.getJComboBoxString())) {
                JOptionPane.showMessageDialog(new Frame(), "This playlist is empty.\nYou have to add songs to play them!", "PLAYLIST EMPTY", JOptionPane.ERROR_MESSAGE);
            } else {
                playerController.setSongsToBePlayed(businessFacade.getPlayListSongsByPlayListName(jfMainFrame.getJComboBoxString()));
                isUploaded = true;
            }
        }
        System.out.println(jfMainFrame.getJComboBoxString());

    }

    public void playStatusInPlayer() {
        //System.out.println("Yo, i'm playing...");
        if(isUploaded) {
            playerController.setActionToDo(0);
            //System.out.println("Is plating");

        } else {
            JOptionPane.showMessageDialog(new Frame(), "Action neede before play.\nYou need to upload a playlist first.", "ACTION NEEDED (NEED TO UPDATE)", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pauseStatusInPlayer() {
        //System.out.println("Yo, i'm paused...");
        if(isUploaded) {
            playerController.setActionToDo(1);
            //System.out.println("Is pausing");
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Action neede before play.\nYou need to upload a playlist first.", "ACTION NEEDED (NEED TO UPDATE)", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void nextStatusInPlayer() {
        //System.out.println("Yo, changing to next song...");
        if(isUploaded) {
            playerController.setActionToDo(2);
            //System.out.println("Is nexting");
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Action neede before play.\nYou need to upload a playlist first.", "ACTION NEEDED (NEED TO UPDATE)", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void previousStatusInPlayer() {
        //System.out.println("Yo, changing to previous song...");
        if(isUploaded) {
            playerController.setActionToDo(3);
            //System.out.println("Is previosing");
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Action neede before play.\nYou need to upload a playlist first.", "ACTION NEEDED (NEED TO UPDATE)", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void stopStatusInPlayer() {
        //System.out.println("Yo, ended playing...");
        if(isUploaded) {
            playerController.setActionToDo(4);
            //System.out.println("Is stopped");
            JOptionPane.showMessageDialog(new Frame(), "You stopped the entire playlist.\nIf you want to play it again you have to re-upload the playlist.", "PLAYLIST STOPPED (NEED TO RE-UPDATE)", JOptionPane.ERROR_MESSAGE);
        }
        isUploaded = false;

    }

    public void showTop5(){
        jfTop5View.setVisible(true);
    }

    public void showStatistics(){
        jfStatisticsView.setVisible(true);
    }

    public void actualitzarEstadistiques(long microseconds){
        businessFacade.actualitzarEstadistiques(microseconds);
    }

}
