package smartpianoA8.business;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.customComponents.Teclas;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interfície-façada per la implementació de mètodes i accions de la categoria de Business
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface BusinessFacade {

    //Usuari
    void registerUser(String username, String email, String password, String passwordRepetition, String type) throws PasswordException, UserManagerException;
    void login(String id, String password) throws UserManagerException;
    void logoutCurrentUser();
    void removeCurrentUser();
    boolean modifyCurrentUserEmail(String newEmail);
    boolean modifyCurrentUserPassword(String newPassword, String passwordRepetition) throws PasswordException;
    boolean modifyCurrentUserName(String newUserName);
    User getCurrentUser();


    //Cançons
    void addSong(Song song, String username);
    ArrayList<ArrayList<Notes>> getMidiNotes(Song song);
    long getTotalTicks();
    float getTotalSongSeconds();
    float getSecondsPerTick();
    int getNumTracks();
    float getMidiBpm();
    ArrayList<Song> getMasterSongs();
    int getTrackResolution();
    float getMidiNotesMPQ();
    float getµsPerTickMidiNotes();
    Song getSong(int IDSong);
    //void removeSong(Song song);


    //Playlist
    //boolean newPlayList(String nom, String nomUsuari);
    //void removePlayList(int idPlayList);


    //Altres
    boolean startDB();

    HashMap<Integer, Teclas> getHMTeclas();
}
