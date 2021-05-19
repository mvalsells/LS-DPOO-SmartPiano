package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.presentation.Controller.PresentationController;
import smartpianoA8.presentation.Controller.PresentationFacade;

import java.util.ArrayList;

/**
 * Interfície pel control de cançons a la bbdd
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface SongDAO {

    /**
     * Mètode per crear una cançó
     * @param song la cançó
     * @param username el propietari de la cançó
     */
    void addSong(Song song, String username);

    /**
     * Metodo que añade una canción en Master sin repetir.
     * @param song cancion a añadir sin repetir
     */
    void addSongInMaster(Song song);

    /**
     * Mètode que elimina una cançó
     * @param IDSong int l'ID de la cançó
     */
    void removeSong(int IDSong);

    /**
     * Mètode que retorna una cançó de la bbdd
     * @param IDSong int l'id de la cançó
     * @return la canço
     */
    Song getSong(int IDSong);

    /**
     * Metode que retorna les 5 top Songs per numero de reproduccions.
     * @return ArrayList<Song> amb les 5 millor songs
     */
    ArrayList<Song> getTop5();

    /**
     * Metode que augmenta un cop el nombre de reproduccions d'una cançó per tots els usuaris pel top5
     * @param IDSong id de la cançó a la que augmentar el num de reproduccions
     */
    void SongPlayed(int IDSong); //TODO cridar aixo quan es reprodueixi una cançó

    /**
     * Retorna totes les cançons de l'usuari "Master"
     * @return ArrayList<Song> amb les cançons
     */
    ArrayList<Song> getMasterSongs();

    /**
     * Retorna totes les cançons de l'usuari donat
     * @param username USERNAME (no email) de l'usuari
     * @return ArrayList<Song></Song> de les cançons de l'usuari
     */
    ArrayList<Song> getUserSongs(String username);

    /**
     * Reotorna les cançons de l'usuari, les públiques (i no usuari) i després les de Master, en aquest ordre
     * @param username nom d'usuari USERNAME (no email) per enviar a buscar cançons
     * @return ArrayList amb les cançons de l'usuari, les publiques (no de l'usuari) i les Master
     */
    ArrayList<Song> getUserAndMasterSongs(String username);

    /**
     * Retorna totes les cançons publiques i que no siguin de Master
     * @return Arraylist de cançons que no són de Master però sí públiques
     */
    ArrayList<Song> getPublicCreatedSongs();

    /**
     * Reotorna les cançons publiques i després les de Master, en aquest ordre
     * @return ArrayList de cançons publiques i després Master.
     */
    public ArrayList<Song> getPublicAndMasterSongs();

    /**
     * Mètode per registrar la Presentation Facade
     * @param presentationFacade la classe ja creada
     */
    void registerPresentationFacade(PresentationFacade presentationFacade);
}
