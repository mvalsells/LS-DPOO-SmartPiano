package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.util.ArrayList;

public interface SongDAO {

    /**
     *
     * @param song
     * @param username
     */
    void addSong(Song song, String username);

    /**
     *
     * @param song
     */
    void removeSong(int IDSong);

    /**
     *
     * @param IDSong
     * @return
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
    void SongPlayed(int IDSong);
}
