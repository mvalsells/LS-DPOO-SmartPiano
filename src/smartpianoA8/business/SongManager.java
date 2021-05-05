package smartpianoA8.business;

import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.persistence.dao.SongDAO;
import smartpianoA8.persistence.dao.UserDAO;

public class SongManager {

    private SongDAO songDAO;

    public SongManager(SongDAO songDAO){
        this.songDAO = songDAO;
    }

    public void addSong(Song song, String userName) {
        //songDAO.addSong(song,);
    }

}
