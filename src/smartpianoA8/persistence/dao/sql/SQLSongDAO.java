package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLSongDAO implements SongDAO {
    private SQLConnector connector;
    public SQLSongDAO(SQLConnector connector){
        this.connector = connector;
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
    }

    /**
     * Retorna una cançó existent segons l'IDSong d'una Song.
     * @param IDSong Cançó amb IDSong a buscar
     * @return  La cançó SONG a buscar o FALSE si no es troba.
     */
    @Override
    public Song getSong(int IDSong) {
        String query = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari, Midi FROM Song;";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()) {
                if(result.getInt("IDSong") == IDSong) {
                    return new Song(result.getInt("IDSong"), result.getTime("Duracio"), result.getString("Nom"), result.getString("Autor"), result.getString("Directori"), result.getBoolean("isPublic"), result.getString("Nomusuari"), result.getString("Midi"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();//TODO aixo potser printa coses innecessaries
        }
        return null;
    }


    /**
     * Metode que retorna les 5 top Songs per numero de reproduccions.
     * @return ArrayList<Song> amb les 5 millor songs
     */
    @Override
    public ArrayList<Song> getTop5() {

        return null;
    }

    /**
     * Metode que augmenta un cop el nombre de reproduccions d'una cançó per tots els usuaris pel top5
     * @param IDSong id de la cançó a la que augmentar el num de reproduccions
     */
    @Override
    public void SongPlayed(int IDSong){
        String query = "SELECT NumReproduccions FROM Song WHERE idSong = " + IDSong + ";";
        ResultSet result = connector.selectQuery(query);

        try {
            result.next();//get select once

            int reproduccions = result.getInt("NumReproduccions") + 1;
            query = "UPDATE Song SET NumReproduccions " + reproduccions + " WHERE idSong = " + IDSong + ";";
            connector.updateQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLSongDAO ERROR no s'ha pogut incrementar el valor de reproduccions de la cançó");
        }
    }
}
