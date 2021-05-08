package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.Song;

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
     * @param username l'usuari propietari de la cançó (actual)
     */
    @Override
    public void addSong(Song song, String username) {
        String query = "INSERT INTO Song(NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari) VALUES ('" +
                    0 + "', '" +
                song.getNom() + "', '" +
                song.getAutor() + "', '" +
                song.getDuracio() + "', '" +
                song.getDataEnregistrament() + "', '" +
                song.getDirectori() + "', '" +
                song.getPublic() + "', '" +
                username + "');";
        connector.insertQuery(query);
    }



    @Override
    public void addSongInMaster(Song song) {
        Song foundSong = getSongByNameInMaster(song.getNom());
        if(foundSong != null) {
            System.out.println("Song that should be added already exists in Master. this comment can be removed.");
        } else{
            addSong(song, "Master");
        }
    }


    /**
     * Elimina una caçó de la bbdd
     * @param IDSong cançó amb l' IdSong a borrar
     */
    @Override
    public void removeSong(int IDSong) {
        //borra la cançó total (data)
        String query = "DELETE FROM Users WHERE NomUsuari = " + IDSong + ";";
        connector.deleteQuery(query);
    }

    /**
     * Retorna una cançó existent segons l'IDSong d'una Song TENINT AQUEST.
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
                    return new Song(result.getInt("idSong"), result.getFloat("Duracio"), result.getString("Nom"), result.getString("Autor"), result.getString("DataEnregistrament"), result.getString("Directori"), result.getInt("isPublic"), result.getString("NomUsuari"), result.getString("Midi"));
                }
            }
        }catch (SQLException e){
            return null;
        }
        return null;
    }


    private Song getSongByNameInMaster(String songName) {
        String query = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari, Midi FROM Song WHERE Nom LIKE '" + songName + "' AND NomUsuari LIKE 'Master';";
        ResultSet result = connector.selectQuery(query);

        try {
            result.next();
            return (new Song(result.getInt("idSong"), result.getFloat("Duracio"), result.getString("Nom"), result.getString("Autor"), result.getString("DataEnregistrament"), result.getString("Directori"), result.getInt("isPublic"), result.getString("NomUsuari"), result.getString("Midi")));

        }catch(SQLException e){
            return null;
        }
    }



    /**
     * Metode que retorna les 5 top Songs per numero de reproduccions.
     * @return ArrayList<Song> amb les 5 millor songs
     */
    @Override
    public ArrayList<Song> getTop5() {
        ArrayList<Song> retorna = new ArrayList<>();
        String query = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari, Midi FROM Song WHERE isPublic = 1 ORDER BY NumReproduccions DESC LIMIT 5;";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()){
                retorna.add(new Song(result.getInt("NumReproduccions"), result.getInt("idSong"), result.getFloat("Duracio"), result.getString("Nom"), result.getString("Autor"), result.getString("DataEnregistrament"), result.getString("Directori"), result.getInt("isPublic"), result.getString("NomUsuari"), result.getString("Midi")));
            }
            return retorna;
        }catch (SQLException e){
            return retorna;
        }
    }

    /**
     * Metode que augmenta un cop el nombre de reproduccions d'una cançó per tots els usuaris pel top5
     * @param IDSong id de la cançó a la que augmentar el num de reproduccions
     */
    @Override
    public void SongPlayed(int IDSong){ //TODO cridar aixo quan es reprodueixi una cançó
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
