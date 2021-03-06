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
     * @param IDSong int id de la song
     * @return la Song en questió
     */
    Song getSong(int IDSong);
    /**
     * Obtenir el nom d'una cançó
     * @param name Strin nom
     * @return la cançó DE L'USUARI amb el nom demanat
     */
    Song getSongByName(String name);
    /**
     * Mètode per obtenir el top5 de cançons
     * @return ArrayList del top 5 amb les songs
     */
    ArrayList<Song> getTop5();
    /**
     * Mèotde per obtenir les cançons d'un usuari pròpies i del Master
     * @param username nom d'usuari
     * @return Arraylist de les cançons
     */
    ArrayList<Song> getUserAndMasterSongs(String username);

    /**
     * Mètode per obtenir els cançons públiques i de Master per un usauri
     * @return Arraylist de cançons
     */
    ArrayList<Song> getPublicAndMasterSongs();
    /**
     * Mètode per eliminar una cançó totalement
     * @param song la Song a borrar compelta
     */
    void removeSongFromDBAndLocal(Song song);
    //void removeSong(Song song);
    /**
     * Metode que augmenta un cop el nombre de reproduccions d'una cançó per tots els usuaris pel top5
     * @param IDsong id de la cançó a la que augmentar el num de reproduccions
     */
    void songPlayed(int IDsong);



    //Playlist
    //boolean newPlayList(String nom, String nomUsuari);
    //void removePlayList(int idPlayList);
    /**
     * Mètode per obtenir les playlists de l'usuari
     * @return Arraylist de PlayLists
     */
    ArrayList<PlayList> getCurrentUserPlaylist();
    /**
     *Mètode per afegir una playlist a l'usuari
     * @param name Nom de la playlist
     * @param username nom de l'usuari
     */
    void addPlayList(String name, String username);
    /**
     * Mètode per eliminar una playlist
     * @param playList la nova playlist
     */
    void removePlayList(PlayList playList);
    /**
     * Afegir una cançó a la playlist
     * @param song
     * @param playList
     */
    void addSongToPlayList(Song song, PlayList playList);
    /**
     * Eliminar una cançó d'una playlist
     * @param song la cançó
     * @param playList la playlist a modificar
     */
    void removeSongFromPlayList(Song song,PlayList playList);
    /**
     * Mèotde per obtenir un aplylist per nom (i usuari)
     * @param name nom de la playlist
     * @return la playlist
     */
    PlayList getPlayListByName(String name);
    /**
     * Mètode per obtenir les cançons d'una playlist pel nom
     * @param name nom de la playlist
     * @return  les cançons de la playlist
     */
    ArrayList<Song> getPlayListSongsByPlayListName(String name);

    /**
     * Mètode per comprovar si una playlist existeix
     * @param nom nom de la playlist
     * @return true: existeix false: no existeix
     */
    Boolean doesPlayListExist(String nom);
    /**
     * Mèotde per coneixre si la playlist està buida
     * @param nom nom de la playlist a comprovar
     * @return true: si, false: nope
     */
    public Boolean isPlayListEmpty(String nom);

    //Stats
    /**
     * Mètode per obtenir la quantitat de reproduccions d'un usuari
     * @return ArrayList de valors de minuts per cada hora de 0 a 23
     */
    ArrayList<Integer> getNumReproducionsCurrentUser();
    /**
     * Mètode per obtenir la duració en minuts de la cançó actual
     * @return ArrayList de valors de minuts per cada hora de 0 a 23
     */
    ArrayList<Double> getNumMinutsCurrentUser();
    /**
     * Mètode per actualitzar les estadístiques
     * @param microseconds microsegons que dura la cançó reproduida
     */
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
