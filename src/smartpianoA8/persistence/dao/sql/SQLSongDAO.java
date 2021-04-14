package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.util.ArrayList;

public class SQLSongDAO implements SongDAO {
    /**
     *
     * @param song
     * @param user
     */
    @Override
    public void addSong(Song song, User user) {

    }

    /**
     *
     * @param song
     */
    @Override
    public void removeSong(Song song) {

    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public ArrayList<Song> getFavouriteSongs(User user) {
        return null;
    }

    /**
     *
     * @param song
     * @param user
     */
    @Override
    public void addSongToFavourite(Song song, User user) {

    }

    /**
     *
     * @param song
     * @return
     */
    @Override
    public Song getSong(Song song) {
        return null;
    }
}
