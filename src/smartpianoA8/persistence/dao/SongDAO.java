package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

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
     * @param IDSong
     * @return
     */
    Song getSong(int IDSong);
}
