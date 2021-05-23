package smartpianoA8.business;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.customComponents.Tecla;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interfície-façada per la implementació de mètodes i accions de la categoria de Business
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface BusinessFacade {

    //Usuari

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
    void registerUser(String username, String email, String password, String passwordRepetition, String type) throws PasswordException, UserManagerException;
    /**
     * Mètode que fa login d'un usuari
     * @param id int ID de l'usuari
     * @param password String passwd de l'usuari
     * @throws UserManagerException
     */
    void login(String id, String password) throws UserManagerException;
    /**
     * Mètode que fa logout de l'usuari
     */
    void logoutCurrentUser();
    /**
     * Mètode que elimina per complert l'usuari
     */
    void removeCurrentUser();
    /**
     * Mètode que modifica l'email de l'usuari
     * @param newEmail String nou email
     * @return true: complert false:error
     */
    boolean modifyCurrentUserEmail(String newEmail);
    /**
     * Mètode que canvia la contrassenya d'un usuari
     * @param newPassword String nova contrassenya
     * @param passwordRepetition String repetició de la contrassenya
     * @return true: correcte false: hi ha hagut un problema en el canvi
     * @throws PasswordException Exepció de control de conrassenyes
     */
    boolean modifyCurrentUserPassword(String newPassword, String passwordRepetition) throws PasswordException;
    /**
     * Mètode que modifica el nom d'usuari
     * @param newUserName String el nom nou d'usuari
     * @return true: complert false: no s'ha pogut
     */
    boolean modifyCurrentUserName(String newUserName);
    /**
     * Mètode per obtenir l'usuari actual loguejat
     * @return User loguejat
     */
    User getCurrentUser();


    //Cançons
    /**
     * Mètode que afegeix una cançó per l'usuari
     * @param song Song nova
     * @param username String nom d'usuari del propietari
     */
    void addSong(Song song, String username);
    /**
     * Mètode que obté les notes d'una cançó MIDI
     * @param song Song a obtenir les notes en MIDI
     * @return ArrayList<ArrayList<Notes>> amb les notes
     */
    ArrayList<ArrayList<Notes>> getMidiNotes(Song song);
    /**
     * Getter dels tics totals de la canço
     * @return long tics totals
     */
    long getTotalTicks();
    /**
     * Getter dels segons total de la cançó
     * @return float segons totals
     */
    float getTotalSongSeconds();
    /**
     * Mètode per obtenir els segons per tick de la cançó
     * @return float SpT
     */
    float getSecondsPerTick();
    /**
     * Mètode que retorna el nombre de canals d'una cançó midi
     * @return int nombre de canals
     */
    int getNumTracks();
    /**
     * Getter dels BPM actuals de la reproducció
     * @return float BPM
     */
    float getMidiBpm();
    /**
     * Mètode epr obtenir les cançons públiques d'internet
     * @return ArrayList de Song amb les cançons
     */
    ArrayList<Song> getMasterSongs();
    /**
     * Getter de la ressolució dels tracks de la canço
     * @return int ressolució
     */
    int getTrackResolution();
    /**
     * Getter de MPQ de la cançó
     * @return flaot MPQ
     */
    float getMidiNotesMPQ();
    /**
     * Getter microsegons per nota
     * @return
     */
    float getµsPerTickMidiNotes();
    /**
     * Mètode per obtenir una Song sol·licitada
     * @param id int id de la song
     * @return la Song en questió
     */
    Song getSong(int IDSong);
    Song getSongByName(String name);
    ArrayList<Song> getTop5();
    ArrayList<Song> getUserAndMasterSongs(String username);
    ArrayList<Song> getPublicAndMasterSongs();
    /**
     * Mètode per eliminar una cançó totalement
     * @param song la Song a borrar compelta
     */
    void removeSongFromDBAndLocal(Song song);
    //void removeSong(Song song);


    //Playlist
    //boolean newPlayList(String nom, String nomUsuari);
    //void removePlayList(int idPlayList);
    ArrayList<PlayList> getCurrentUserPlaylist();
    void addPlayList(String name, String username);
    void removePlayList(PlayList playList);
    void addSongToPlayList(Song song, PlayList playList);
    void removeSongFromPlayList(Song song,PlayList playList);
    PlayList getPlayListByName(String name);
    ArrayList<Song> getPlayListSongsByPlayListName(String name);

    Boolean doesPlayListExist(String nom);
    public Boolean isPlayListEmpty(String nom);

    //Stats
    ArrayList<Integer> getNumReproducionsCurrentUser();
    ArrayList<Double> getNumMinutsCurrentUser();
    void actualitzarEstadistiques(long microseconds);


    //Altres
    /**
     * Mètode per obtenir un HashMap de notes en ordre
     * @return Hashmap complert de notes
     */
    HashMap<Integer, Tecla> getHMTeclas();
    /**
     * Mèotde per configurar les notes del hashmap
     * @param hmTeclas Tecla a canviar el hashmap
     */
    void setHmTeclas(HashMap<Integer, Tecla> hmTeclas);
}
