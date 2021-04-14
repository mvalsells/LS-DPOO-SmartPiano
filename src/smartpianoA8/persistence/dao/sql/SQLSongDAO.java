package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.SongDAO;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.util.ArrayList;

public class SQLSongDAO implements SongDAO {
    @Override
    public void addSong(Song song, User user) {

    }

    @Override
    public void removeSong(Song song) {

    }

    @Override
    public ArrayList<Song> getFavouriteSongs(User user) {
        return null;
    }

    @Override
    public void addSongToFavourite(Song song, User user) {

    }

    @Override
    public Song getSong(Song song) {
        return null;
    }
}
