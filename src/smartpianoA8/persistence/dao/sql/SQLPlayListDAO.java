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
     * @param user Usuari amb el UserName a buscar a les PlayLists de la bbdd
     * @return NULL si no n'ha trobat cap, una ArrayList<PlayList> amb les que ha trobat si n'ha trobat.
     */
    @Override
    public ArrayList<PlayList> getPlayListsByUser(User user) {
        ArrayList<PlayList> llista = null;

        String query = "SELECT Nom, NomUsuari, IDPlayList FROM PlayList WHERE NomUsuari LIKE '" + user.getUsername() + "';";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);
        try{
            while(result.next()) {
                llista.add(new PlayList(result.getString("Nom"), result.getInt("IDPlayList"), result.getString("NomUsuari")));
            }

        }catch (SQLException e){
            e.printStackTrace();//TODO aixo potser printa coses innecessaries
            return llista;
        }
        return null;
    }

    /**
     * Retorna la PlayList buscada amb IDPlayList.
     * @param IDPlaylist ID de la PlayList a buscar les dades.
     * @return  PlayList demanada completa.
     */
    @Override
    public PlayList getPlayListData(int IDPlaylist) {
        String query = "SELECT Nom, NomUsuari, IDPlayList FROM Users;";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);
        try{
            while(result.next()) {
                if(result.getInt("IDPlayList") == IDPlaylist){
                    return new PlayList(result.getString("Nom"), result.getInt("IDPlayList"), result.getString("NomUsuari"));
                }

            }
        }catch (SQLException e){
            e.printStackTrace();//TODO aixo potser printa coses innecessaries
        }
        return null;
    }

    /**
     * Retorna la llista de cançons d'una PlayList
     * @param playList la PlayList (amb l'ID que és l'important) a rebre les cançons
     * @return  ArrayList<Song> amb les cançons dins
     */
    @Override
    public ArrayList<Song> getPlayListSongs(PlayList playList) {
        ArrayList<Song> songs = null;
        String query = "SELECT idSong FROM SongPlaylist WHERE IDPlayList LIKE '" + playList.getIdPlayList() + "';";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);
        String query2;

        try{
            while(result.next()) {
                query2 = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari FROM Song WHERE IDSong = '" + result.getInt("idSong") + "';";
                ResultSet result2 = SQLConnector.getInstance().selectQuery(query2);
                songs.add(new Song(result2.getInt("IDSong"), result2.getTime("Duracio"), result2.getString("Nom"), result2.getString("Autor"), result2.getString("Directori"), result2.getBoolean("isPublic"), result2.getString("Nomusuari")));
            }
        }catch (SQLException e){
            e.printStackTrace();//TODO aixo potser printa coses innecessaries
            return songs;

        }
        return null;
    }
}
