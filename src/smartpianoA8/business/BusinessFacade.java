package smartpianoA8.business;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.Song;
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
    public void registerUser(String username, String email, String password, String passwordRepetition, String type) throws PasswordException, UserManagerException;
    public void login(String id, String password) throws UserManagerException;
    public void logoutCurrentUser();
    public void removeCurrentUser();
    public boolean modifyCurrentUserEmail(String newEmail);
    public boolean modifyCurrentUserPassword(String newPassword, String passwordRepetition) throws PasswordException;
    public boolean modifyCurrentUserName(String newUserName);


    //Cançons
    public void addSong(Song song, String username);
    public ArrayList<ArrayList<Notes>> getMidiNotes(Song song);
    public long getTotalTicks();
    public float getTotalSongSeconds();
    public float getSecondsPerTick();
    public int getNumTracks();
    public float getMidiBpm();
    public ArrayList<Song> getMasterSongs();
    public int getTrackResolution();
    public float getMidiNotesMPQ();
    public float getµsPerTickMidiNotes();
    //public void removeSong(Song song);


    //Playlist
    //public boolean newPlayList(String nom, String nomUsuari);
    //public void removePlayList(int idPlayList);


    //Altres
    public boolean startDB();

    HashMap<Integer, Teclas> getHMTeclas();
}
