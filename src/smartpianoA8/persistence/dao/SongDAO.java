package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.util.ArrayList;

public interface SongDAO {

    /**
     *
     * @param song
     * @param user
     */
    void addSong(Song song, User user);

    /**
     *
     * @param song
     */
    void removeSong(Song song);

    /**
     *
     * @param user
     * @return
     */
    ArrayList<Song> getFavouriteSongs(User user);

    /**
     *
     * @param song
     * @param user
     */
    void addSongToFavourite(Song song, User user);

    /**
     *
     * @param song
     * @return
     */
    Song getSong(Song song);
}
