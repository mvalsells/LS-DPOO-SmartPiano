package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe pel control de la bbdd de playlists
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class SQLPlayListDAO implements PlayListDAO{
    private SQLConnector connector;
    public SQLPlayListDAO(SQLConnector connector){
        this.connector = connector;
    }

    public String TERM_PLAYLIST1 = "Mi primera playlist";
    public String TERM_PLAYLIST2 = "My sejunda primera plailis";


    /**
     * Afegeix / Crea una Playlist a un usuari
     * @param name nom de la playlist
     * @param username nom de l'usuari propietari de la PlayList
     */
    @Override
    public void addPlayList(String name, String username) {
        String query = "INSERT INTO PlayList(Nom, NomUsuari) VALUES ('" +
                name + "', '" +
                username + "');";
        connector.insertQuery(query);
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
        connector.insertQuery(query);


    }

    /**
     * Borra una cançó d'una PlayList
     * @param playList playlist a modificar amb el seu ID
     * @param song cançó a treure de la PlayList amb el seu ID
     */
    @Override
    public void removeSongFromPlayList(Song song,PlayList playList) {
        String query = "DELETE FROM SongPlaylist WHERE idSong = " + song.getIdSong() + ";";
        connector.deleteQuery(query);
    }

    /**
     *   Borra una playlist segons el seu ID
     * @param playList playlist amb ID
     */
    @Override
    public void removePlayList(PlayList playList) {

        //borrar la playlist sencera (data playlist)
        String query = "DELETE FROM SongPlaylist WHERE IDPlayList = " + playList.getIdPlayList() + ";";
        connector.selectQuery(query);
    }

    /**
     * Retorna una ArrayList amb les PlayList que coincideixen amb el NomUsuari de l'usuari.
     * @param user Usuari amb el UserName a buscar a les PlayLists de la bbdd
     * @return NULL si no n'ha trobat cap, una ArrayList<PlayList> amb les que ha trobat si n'ha trobat.
     */
    @Override
    public ArrayList<PlayList> getPlayListsByUser(User user) {
        ArrayList<PlayList> llista = new ArrayList<>();

        String query = "SELECT * FROM PlayList WHERE NomUsuari LIKE '" + user.getUsername() + "';";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()) {
                llista.add(new PlayList(result.getString("Nom"), result.getInt("IDPlayList"), result.getString("NomUsuari")));

                ArrayList<Song> songs = getPlayListSongs(llista.get(llista.size()-1));
                llista.get(llista.size()-1).setSongs(songs);
            }
            return llista;

        }catch (SQLException e){
            System.out.println("PATATA 2k mecagun");
            //e.printStackTrace();
            return llista;
        }
    }

    /**
     * Retorna la PlayList buscada amb IDPlayList.
     * @param IDPlaylist ID de la PlayList a buscar les dades.
     * @return  PlayList demanada completa.
     * @deprecated intentar no fer servir, si es fa servir no passa res però no té cançons
     */
    @Override
    public PlayList getPlayListData(int IDPlaylist) {
        String query = "SELECT Nom, NomUsuari, IDPlayList FROM Users;";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()) {
                if(result.getInt("IDPlayList") == IDPlaylist){
                    return new PlayList(result.getString("Nom"), result.getInt("IDPlayList"), result.getString("NomUsuari"));
                }

            }
        }catch (SQLException e){
            //e.printStackTrace();
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
        ArrayList<Song> songs = new ArrayList<>();
        String query = "SELECT idSong FROM SongPlaylist WHERE IdPlayList = " + playList.getIdPlayList() + ";";
        ResultSet result = connector.selectQuery(query);

        String query2;
        try{
            while(result.next()) {
                query2 = "SELECT * FROM Song WHERE idSong = " + result.getInt("idSong") + ";";
                ResultSet result2 = connector.selectQuery(query2);
                result2.next();
                //System.out.println(result2.getInt("idSong"));
                songs.add(new Song(result2.getInt("idSong"), result2.getFloat("Duracio"), result2.getString("Nom"), result2.getString("Autor"), result2.getString("DataEnregistrament"), result2.getString("Directori"), result2.getInt("isPublic"), result2.getString("NomUsuari"), result2.getString("Midi")));
            }
            return songs;
        }catch (SQLException e){
           // e.printStackTrace();


        }
        return null;
    }

    @Override
    public void newUserPlaylists(String username){

        //1ra playlist
        String query = "INSERT INTO PlayList(Nom, NomUsuari) VALUES ('" +
                TERM_PLAYLIST1 + "', '" +
                username + "');";

        connector.insertQuery(query);

        //2na playlist
        query = "INSERT INTO PlayList(Nom, NomUsuari) VALUES ('" +
                TERM_PLAYLIST2 + "', '" +
                username + "');";

        connector.insertQuery(query);
    }

    /**
     * Mètode per obtenir una playlist pel usenrame d'un usuari
     * @param name nom de la playlist
     * @param username nom de l'username
     * @return la playlist
     */
    @Override
    public PlayList getPlayListByName(String name, String username){
        PlayList retorna = null;
        String query = "SELECT * FROM PlayList WHERE Nom LIKE '" + name +"' AND NomUsuari LIKE '" + username +"'";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()) {
                retorna = new PlayList(result.getString("Nom"), result.getInt("IDPlayList"), result.getString("NomUsuari"));
            }

            if(retorna != null) {
                ArrayList<Song> songs = getPlayListSongs(retorna);
                retorna.setSongs(songs);
                return retorna;
            }
            return retorna;

        }catch(SQLException e){
            //e.printStackTrace();
        }
        return retorna;
    }


    public ArrayList<Song> getPlayListSongsByPlayListName(String name, String username){
        ArrayList<Song> songs = new ArrayList<>();
        int IdPlayList = 0; //impedir que comenci a null

        //obtenir la id de la playlist
        String query = "SELECT IdPlayList FROM PlayList WHERE Nom LIKE '" + name + "' AND NomUsuari LIKE '" + username + "';";
        ResultSet result = connector.selectQuery(query);

        try {
            result.next();
            IdPlayList = result.getInt("IdPlayList");
        }catch (SQLException e){
            //e.printStackTrace();
            return songs;
        }

        //obtenir les idSong de la IdPlayList
        query = "SELECT idSong FROM SongPlaylist WHERE IdPlayList = " + IdPlayList + ";";
        result = connector.selectQuery(query);
        try{
            while(result.next()) {
                query = "SELECT * FROM Song WHERE idSong = " + result.getInt("idSong") + ";";
                ResultSet result2 = connector.selectQuery(query);
                result2.next();
                //System.out.println(result2.getInt("idSong"));
                songs.add(new Song(result2.getInt("idSong"), result2.getFloat("Duracio"), result2.getString("Nom"), result2.getString("Autor"), result2.getString("DataEnregistrament"), result2.getString("Directori"), result2.getInt("isPublic"), result2.getString("NomUsuari"), result2.getString("Midi")));
            }
            return songs;
        }catch (SQLException e){
            //e.printStackTrace();
            return songs;
        }
    }

    /**
     * Mètode que comprova si una playlist està buida
     * @param nom nom de la playlist
     * @param user nom de l'usuari
     * @return true: buida, false: plena
     */
    @Override
    public Boolean isPlayListEmpty(String nom, String user){
        PlayList playList = getPlayListByName(nom, user);
        int quant = playList.getSongs().size();

        if(playList.getSongs() == null || quant == 0){
            return true;
        }else{
           return false;
        }
    }

    /**
     * Mètode per mirar si una playlist existeix
     * @param nom nom de la playlist
     * @param user user de la playlist
     * @return true: existeix, false: no existeix
     */
    @Override
    public Boolean doesPlayListExist(String nom, String user){
        int id = 0;
        String query = "SELECT * FROM PlayList WHERE Nom LIKE '" + nom +"' AND NomUsuari LIKE '" + user +"'";
        ResultSet result = connector.selectQuery(query);
        try{
            result.next();
            id = result.getInt("IdPlayList");
            if(id == 0){
                return false;
            }else {
                return true;
            }
        }catch(SQLException e){
            //e.printStackTrace();
            return false;
        }
    }

}
