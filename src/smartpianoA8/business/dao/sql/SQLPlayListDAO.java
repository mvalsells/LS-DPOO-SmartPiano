package smartpianoA8.business.dao.sql;

import smartpianoA8.business.dao.PlayListDAO;
import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;

import java.util.ArrayList;

public class SQLPlayListDAO implements PlayListDAO {
    @Override
    public void addPlayList(String name, String username) {
        String query = "INSERT INTO playlist(Nom, NomUsuari) VALUES ('" +
                name + "', '" +
                username + "');";
    }

    @Override
    public void addSongToPlayList(Song song, PlayList playList, String username) {

    }

    @Override
    public void removeSongFromPlayList(PlayList playList, Song song) {

    }

    @Override
    public void removePlayList(PlayList playList) {

    }

    @Override
    public ArrayList<PlayList> getPlayListsByUsers(String username) {
        return null;
    }

    @Override
    public PlayList getPlayListData(PlayList playList) {
        return null;
    }

    @Override
    public ArrayList<Song> getPlayListSongs(PlayList playList) {
        return null;
    }
}