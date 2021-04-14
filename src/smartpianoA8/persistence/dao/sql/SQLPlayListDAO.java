package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.persistence.dao.sql.SQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLPlayListDAO implements PlayListDAO{
    @Override
    public void addPlayList(String name, String username) {
        String query = "INSERT INTO playlist(Nom, NomUsuari) VALUES ('" +
                name + "', '" +
                username + "');";
    }

    @Override
    public void addSongToPlayList(Song song, PlayList playList, User user) {
        String query = "";

    }

    @Override
    public void removeSongFromPlayList(PlayList playList, Song song) {

    }

    @Override
    public void removePlayList(PlayList playList) {
        int id = playList.getIdPlayList();
        String query = "DELETE FROM playlist WHERE IdPlayList = '"
                + id + "';";
        SQLConnector.getInstance().deleteQuery(query);
    }

    @Override
    public ArrayList<PlayList> getPlayListsByUser(User user) {
        return null;
    }

    @Override
    public PlayList getPlayListData(PlayList playList) {
        PlayList returnedPlayList;
        String query = "SELECT Nom, idPlayList, NomUsuari FROM playlist;";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);

        //busca per cada playlist si l'id és igual. si ho és, retorna-la

        try{
            while(result.next()){
                if(result.getInt("idPlayList") == playList.getIdPlayList()){
                    String Nom = result.getString("Nom");
                    int id = result.getInt("idPlayList");
                    String NomUsuari = result.getString("NomUsuari");

                    returnedPlayList = new PlayList(Nom, id, NomUsuari);
                    return();
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Song> getPlayListSongs(PlayList playList) {
        ArrayList<Song> songs = new ArrayList<>();
        String query = "";

        return songs;
    }
}
