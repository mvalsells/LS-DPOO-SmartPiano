package smartpianoA8.business;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.persistence.HtmlScrapping;
import smartpianoA8.persistence.MidiParser;
import smartpianoA8.persistence.dao.PlayListDAO;
import smartpianoA8.persistence.dao.SongDAO;
import smartpianoA8.persistence.dao.StatsDAO;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.presentation.views.customComponents.JPPiano;
import smartpianoA8.presentation.views.customComponents.Teclas;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe amb les accions i mètodes d'accés i control de Business
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class BusinessFacadeImpl implements BusinessFacade{

    //Managers
    private UserManager userManager;
    private SongManager songManager;

    //DAOs
    private SongDAO songDAO;
    private PlayListDAO playListDAO;
    private StatsDAO statsDAO;

    /**
     * Constructor
     * @param userDAO DAO del control d'usuaris
     * @param songDAO DAO del control de cançons
     * @param playListDAO DAO del control de playlists
     * @param statsDAO DAO del control d'estadístiques
     * @param midiParser DAO de l'editor de MIDI
     */
    public BusinessFacadeImpl(UserDAO userDAO, SongDAO songDAO, PlayListDAO playListDAO, StatsDAO statsDAO, MidiParser midiParser){
        userManager = new UserManager(userDAO);
        songManager = new SongManager(songDAO, midiParser);

    }

    /**
     * Mètde per inicialitzar la BBDD
     * @return boolean true: creació correcte, false: incorrecta
     */
    @Override
    public boolean startDB() {
        return false;
    }

    // ------------------------------------------------------
    //  START user implementation
    // ------------------------------------------------------

    /**
     * Mètode per crear un usuari des de zero
     * @param username String nom
     * @param email String email
     * @param password String password
     * @param passwordRepetition  String la contrassenya un altre cop
     * @param type String el tipus d'usuari pel registre
     * @throws PasswordException Exepció de contrassenyes incorrectes o inadequades
     * @throws UserManagerException Exepció de problemes amb el nom o email
     */
    @Override
    public void registerUser(String username, String email, String password, String passwordRepetition, String type) throws PasswordException, UserManagerException {
        userManager.registerUser(username, email, password, passwordRepetition, type);
    }

    /**
     * Mètode que fa login d'un usuari
     * @param id int ID de l'usuari
     * @param password String passwd de l'usuari
     * @throws UserManagerException
     */
    @Override
    public void login(String id, String password) throws UserManagerException {
        userManager.login(id,password);
    }

    /**
     * Mètode que fa logout de l'usuari
     */
    @Override
    public void logoutCurrentUser() {
        userManager.logoutCurrentUser();
    }

    /**
     * Mètode que elimina per complert l'usuari
     */
    @Override
    public void removeCurrentUser() {
        userManager.removeCurrentUser();
    }

    /**
     * Mètode que modifica l'email de l'usuari
     * @param newEmail String nou email
     * @return true: complert false:error
     */
    @Override
    public boolean modifyCurrentUserEmail(String newEmail) {
        return userManager.modifyCurrentUserEmail(newEmail);
    }

    /**
     * Mètode que canvia la contrassenya d'un usuari
     * @param newPassword String nova contrassenya
     * @param newPasswordRepetition String repetició de la contrassenya
     * @return true: correcte false: hi ha hagut un problema en el canvi
     * @throws PasswordException Exepció de control de conrassenyes
     */
    @Override
    public boolean modifyCurrentUserPassword(String newPassword, String newPasswordRepetition) throws PasswordException {
        return userManager.modifyCurrentUserPassword(newPassword, newPasswordRepetition);
    }

    /**
     * Mètode que modifica el nom d'usuari
     * @param newUserName String el nom nou d'usuari
     * @return true: complert false: no s'ha pogut
     */
    @Override
    public boolean modifyCurrentUserName(String newUserName) {
        return userManager.modifyCurrentUserName(newUserName);
    }

    @Override
    public User getCurrentUser(){
        return userManager.getCurrentUser();
    }
    // ------------------------------------------------------
    //  END user implementation
    // ------------------------------------------------------
    // ------------------------------------------------------
    //  START song implementation
    // ------------------------------------------------------

    /**
     * Mètode que afegeix una cançó per l'usuari
     * @param song Song nova
     * @param username String nom d'usuari del propietari
     */
    @Override
    public void addSong(Song song, String username) {
        songManager.addSong(song,username);
    }

    /**
     * Mètode que obté les notes d'una cançó MIDI
     * @param song Song a obtenir les notes en MIDI
     * @return ArrayList<ArrayList<Notes>> amb les notes
     */
    @Override
    public ArrayList<ArrayList<Notes>> getMidiNotes(Song song) {
        return songManager.getMidiNotesParsed(song);
    }

    /**
     * Getter dels BPM actuals de la reproducció
     * @return float BPM
     */
    @Override
    public float getMidiBpm() {
        return songManager.getMidiBpm();
    }

    /**
     * Mètode que retorna el nombre de canals d'una cançó midi
     * @return int nombre de canals
     */
    @Override
    public int getNumTracks() {
        return songManager.getMidiNumTracks();
    }

    /**
     * Mètode per obtenir els segons per tick de la cançó
     * @return float SpT
     */
    @Override
    public float getSecondsPerTick() {
        return songManager.getMidiSecondsPerTick();
    }

    /**
     * Getter dels segons total de la cançó
     * @return float segons totals
     */
    @Override
    public float getTotalSongSeconds() {
        return songManager.getMidiTotalSongSeconds();
    }

    /**
     * Getter dels tics totals de la canço
     * @return long tics totals
     */
    @Override
    public long getTotalTicks() {
        return songManager.getMidiTotalTicks();
    }

    /**
     * Getter de la ressolució dels tracks de la canço
     * @return int ressolució
     */
    @Override
    public int getTrackResolution() {
        return songManager.getTrackResolution();
    }

    /**
     * Mètode epr obtenir les cançons públiques d'internet
     * @return ArrayList de Song amb les cançons
     */
    @Override
    public ArrayList<Song> getMasterSongs() {
        return songManager.getMasterSongs();
    }

    /**
     * Getter de MPQ de la cançó
     * @return flaot MPQ
     */
    @Override
    public float getMidiNotesMPQ() {
        return songManager.getMidiNotesMPQ();
    }

    /**
     * Getter microsegons per nota
     * @return
     */
    public float getµsPerTickMidiNotes() {
        return songManager.getµsPerTickMidiNotes();
    }

    /**
     * Mètode per obtenir un HashMap de notes en ordre
     * @return Hashmap complert de notes
     */
    public  HashMap<Integer, Teclas> getHMTeclas(){

        HashMap<Integer, Teclas> hmTeclas = new HashMap<>();

        int valorMusical = 48;
        int codeTecla = KeyEvent.VK_A;

        for(int i = 0; i< JPPiano.OCTAVES; i++){

            for(int j=0; j<12;j++){

                StringBuilder sb = new StringBuilder();

                sb.append(i);
                sb.append('_');
                sb.append(j);

                hmTeclas.put(codeTecla,new Teclas(/*sb.toString(),*/valorMusical));
                valorMusical++;
                codeTecla++;
                if(codeTecla==KeyEvent.VK_Z+1){
                    codeTecla = KeyEvent.VK_0;
                }
            }
        }
        return hmTeclas;
    }

    public Song getSong(int id){return songDAO.getSong(id);}


    // ------------------------------------------------------
    //  END song implementation
    // ------------------------------------------------------

}
