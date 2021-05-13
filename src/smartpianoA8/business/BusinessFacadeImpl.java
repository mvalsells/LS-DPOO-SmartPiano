package smartpianoA8.business;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.Song;
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

public class BusinessFacadeImpl implements BusinessFacade{

    //Managers
    private UserManager userManager;
    private SongManager songManager;

    //DAOs
    private SongDAO songDAO;
    private PlayListDAO playListDAO;
    private StatsDAO statsDAO;

    public BusinessFacadeImpl(UserDAO userDAO, SongDAO songDAO, PlayListDAO playListDAO, StatsDAO statsDAO, MidiParser midiParser){
        userManager = new UserManager(userDAO);
        songManager = new SongManager(songDAO, midiParser);

    }

    @Override
    public boolean startDB() {
        return false;
    }

    // ------------------------------------------------------
    //  START user implementation
    // ------------------------------------------------------
    @Override
    public void registerUser(String username, String email, String password, String passwordRepetition, String type) throws PasswordException, UserManagerException {
        userManager.registerUser(username, email, password, passwordRepetition, type);
    }

    @Override
    public void login(String id, String password) throws UserManagerException {
        userManager.login(id,password);
    }

    @Override
    public void logoutCurrentUser() {
        userManager.logoutCurrentUser();
    }

    @Override
    public void removeCurrentUser() {
        userManager.removeCurrentUser();
    }

    @Override
    public boolean modifyCurrentUserEmail(String newEmail) {
        return userManager.modifyCurrentUserEmail(newEmail);
    }

    @Override
    public boolean modifyCurrentUserPassword(String newPassword, String newPasswordRepetition) throws PasswordException {
        return userManager.modifyCurrentUserPassword(newPassword, newPasswordRepetition);
    }

    @Override
    public boolean modifyCurrentUserName(String newUserName) {
        return userManager.modifyCurrentUserName(newUserName);
    }
    // ------------------------------------------------------
    //  END user implementation
    // ------------------------------------------------------
    // ------------------------------------------------------
    //  START song implementation
    // ------------------------------------------------------

    @Override
    public void addSong(Song song, String username) {
        songManager.addSong(song,username);
    }

    @Override
    public ArrayList<ArrayList<Notes>> getMidiNotes(Song song) {
        return songManager.getMidiNotesParsed(song);
    }

    @Override
    public float getMidiBpm() {
        return songManager.getMidiBpm();
    }

    @Override
    public int getNumTracks() {
        return songManager.getMidiNumTracks();
    }

    @Override
    public float getSecondsPerTick() {
        return songManager.getMidiSecondsPerTick();
    }

    @Override
    public float getTotalSongSeconds() {
        return songManager.getMidiTotalSongSeconds();
    }

    @Override
    public long getTotalTicks() {
        return songManager.getMidiTotalTicks();
    }

    @Override
    public int getTrackResolution() {
        return songManager.getTrackResolution();
    }

    @Override
    public ArrayList<Song> getMasterSongs() {
        return songManager.getMasterSongs();
    }

    @Override
    public float getMidiNotesMPQ() {
        return songManager.getMidiNotesMPQ();
    }

    public float getµsPerTickMidiNotes() {
        return songManager.getµsPerTickMidiNotes();
    }

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


    // ------------------------------------------------------
    //  END song implementation
    // ------------------------------------------------------

}
