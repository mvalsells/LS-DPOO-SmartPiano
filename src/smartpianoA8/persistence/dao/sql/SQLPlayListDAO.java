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

    /**
     * Afegeix / Crea una Playlist a un usuari
     * @param name nom de la playlist
     * @param username nom de l'usuari propietari de la PlayList
     */
    @Override
    public void addPlayList(String name, String username) {
        String query = "INSERT INTO playlist(Nom, NomUsuari) VALUES ('" +
                name + "', '" +
                username + "');";
        SQLConnector.getInstance().insertQuery(query);
    }

    /**
     * Afegeix una cançó existent a una PlayList existent
     * @param song cançó existent a afegir
     * @param playList playlist a modificar
     */
    @Override
    public void addSongToPlayList(Song song, PlayList playList) {
        String query = "INSERT INTO SongPlaylist(idSong, IDPlayList) VALUES ('" +
                song.getIdSong() + "', '" + playList.getIdPlayList() + "');";
        SQLConnector.getInstance().insertQuery(query);
    }

    /**
     * Borra una cançó d'una PlayList
     * @param playList playlist a modificar amb el seu ID
     * @param song cançó a treure de la PlayList amb el seu ID
     */
    @Override
    public void removeSongFromPlayList(PlayList playList, Song song) {
        String query = "DELETE FROM SongPlaylist WHERE idSong = '" + song.getIdSong() + "';";
        SQLConnector.getInstance().deleteQuery(query);
    }

    /**
     *   Borra una playlist segons el seu ID
     * @param playList playlist amb ID
     */
    @Override
    public void removePlayList(PlayList playList) {
        String query = "DELETE FROM PlayList WHERE IDPlayList = '" + playList.getIdPlayList() + "';";
        SQLConnector.getInstance().deleteQuery(query);
    }

    /**
     * Retorna una ArrayList amb les PlayList que coincideixen amb el NomUsuari de l'usuari.
     * @param user
     * @return NULL si no n'ha trobat cap, una ArrayList<PlayList> amb les que ha trobat si n'ha trobat.
     */
    @Override
    public ArrayList<PlayList> getPlayListsByUser(User user) {
        ArrayList<PlayList> llista = null;

        String query = "SELECT Nom, NomUsuari, IDPlayList FROM PlayList WHERE NomUsuari = '" + user.getUsername() + "';";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);
        try{
            while(result.next()) {
                llista.add(new PlayList(result.getString("Nom"), result.getInt("IDPlayList"), result.getString("NomUsuari")));
            }
            return llista;
        }catch (SQLException e){
            e.printStackTrace();//TODO aixo potser printa coses innecessaries
        }
        return null;
    }

    /**
     *
     * @param playList
     * @return
     */
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
                    return(returnedPlayList);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return(null);
    }

    /**
     *
     * @param playList
     * @return
     */
    @Override
    public ArrayList<Song> getPlayListSongs(PlayList playList) {
        ArrayList<Song> songs = new ArrayList<>();
        String query = "";

        return songs;
    }
}
