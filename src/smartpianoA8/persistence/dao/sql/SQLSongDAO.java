package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLSongDAO implements SongDAO {
    private SQLConnector connector;
    public SQLSongDAO(String username, String password, int port, String ip, String databaseName){
        SQLConnector connector = new SQLConnector(username,  password,  ip,  port, databaseName);
    }


    /**
     * Afegeix una cançó a la bbdd
     * @param song la cançó completa a afegir
     * @param user l'usuari propietari de la cançó (actual)
     */
    @Override
    public void addSong(Song song, User user) {

        String query = "INSERT INTO Song(NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari) VALUES ('" +
                    0 + "', '" +
                song.getNom() + "', '" +
                song.getAutor() + "', '" +
                song.getDuracio() + "', '" +
                song.getDataEnregistrament() + "', '" +
                song.getDirectori() + "', '" +
                song.getPublic() + "', '" +
                user.getUsername() + "');";
        connector.insertQuery(query);
    }

    /**
     * Elimina una caçó de la bbdd
     * @param song cançó amb l' IdSong a borrar
     */
    @Override
    public void removeSong(Song song) {
        //borra la cançó total (data)
        String query = "DELETE FROM Users WHERE NomUsuari = " + song.getIdSong() + ";";
        connector.deleteQuery(query);

        //TODO borrar també la relació SongPlaylist també, però amb SQL no sé com fer la crida/query (preguntar POL)

    }

    /**
     * Retorna una cançó existent segons l'IDSong d'una Song.
     * @param IDSong Cançó amb IDSong a buscar
     * @return  La cançó SONG a buscar o FALSE si no es troba.
     */
    @Override
    public Song getSong(int IDSong) {
        String query = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari FROM Song;";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()) {
                if(result.getInt("IDSong") == IDSong) {
                    return new Song(result.getInt("IDSong"), result.getTime("Duracio"), result.getString("Nom"), result.getString("Autor"), result.getString("Directori"), result.getBoolean("isPublic"), result.getString("Nomusuari"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();//TODO aixo potser printa coses innecessaries
        }
        return null;
    }
}
