package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.util.ArrayList;

public interface SongDAO {

    void addSong(Song song, User user);
    void removeSong(Song song);
    ArrayList<Song> getFavouriteSongs(User user);
    void addSongToFavourite(Song song, User user);
    Song getSong(Song song);
}
