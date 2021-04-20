package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLSongDAO implements SongDAO {
    /**
     * Afegeix una cançó a la bbdd
     * @param song la cançó completa a afegir
     * @param user l'usuari propietari de la cançó (actual)
     */
    @Override
    public void addSong(Song song, User user) {
        String username = user.getUsername();

        String query = "INSERT INTO Song(NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari) VALUES ('" +
                    0 + "', '" +
                song.getNom() + "', '" +
                song.getAutor() + "', '" +
                song.getDuracio() + "', '" +
                song.getDataEnregistrament() + "', '" +
                song.getDirectori() + "', '" +
                song.getPublic() + "', '" +
                user.getUsername() + "');";
        SQLConnector.getInstance().insertQuery(query);
    }

    /**
     * Elimina una caçó de la bbdd
     * @param song cançó amb l' IdSong a borrar
     */
    @Override
    public void removeSong(Song song) {
        String query = "DELETE FROM Users WHERE NomUsuari = '" + song.getIdSong() + "';";
        SQLConnector.getInstance().deleteQuery(query);
    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public ArrayList<Song> getFavouriteSongs(User user) {
        return null;
    }

    /**
     *
     * @param song
     * @param user
     */
    @Override
    public void addSongToFavourite(Song song, User user) {

    }

    /**
     * Retorna una cançó existent segons l'IDSong d'una Song.
     * @param IDSong Cançó amb IDSong a buscar
     * @return  La cançó SONG a buscar o FALSE si no es troba.
     */
    @Override
    public Song getSong(int IDSong) {
        String query = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari FROM Song;";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);
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
