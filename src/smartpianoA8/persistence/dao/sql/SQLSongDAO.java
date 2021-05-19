package smartpianoA8.persistence.dao.sql;

import smartpianoA8.persistence.dao.*;
import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.Controller.PresentationFacade;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe pel control de cançons de la bbdd
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class SQLSongDAO implements SongDAO {
    private SQLConnector connector;
    public SQLSongDAO(SQLConnector connector){
        this.connector = connector;
    }
    private PresentationFacade presentationFacade;

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
        presentationFacade.nuevasCanciones();
    }


    /**
     * Mètode per afegir cançons Master d'internet
     * @param song cancion a añadir sin repetir
     */
    @Override
    public void addSongInMaster(Song song) {
        Song foundSong = getSongByNameInMaster(song.getNom());
        if(foundSong != null) {
            System.out.println("Song that should be added already exists in Master. this comment can be removed.");
        } else{
            addSong(song, Song.Master);
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

    /**
     * Mètode per obtenir cançon de Master pel nom
     * @param songName el nom
     * @return la cançó
     */
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

    /**
     * Mètode per obtenir les cançons d'un usuari
     * @param username USERNAME (no email) de l'usuari
     * @return arrayList de cançons
     */
    @Override
   public ArrayList<Song> getUserSongs(String username){
        ArrayList<Song> retorna = new ArrayList<>();
        String query = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari, Midi FROM Song WHERE NomUsuari LIKE '" + username + "';";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()){
                retorna.add(new Song(result.getInt("NumReproduccions"), result.getInt("idSong"), result.getFloat("Duracio"), result.getString("Nom"), result.getString("Autor"), result.getString("DataEnregistrament"), result.getString("Directori"), result.getInt("isPublic"), result.getString("NomUsuari"), result.getString("Midi")));
            }
            return retorna;

        }catch(SQLException e){
            return retorna;
        }
    }

    /**
     * Retorna totes les cançons publiques i que no siguin de Master
     * @return Arraylist de cançons que no són de Master però sí públiques
     */
    @Override
    public ArrayList<Song> getPublicCreatedSongs(){
        ArrayList<Song> retorna = new ArrayList<>();
        String query = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari, Midi FROM Song WHERE isPublic = 1 AND NOT NomUsuari 'Master';";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()){
                retorna.add(new Song(result.getInt("NumReproduccions"), result.getInt("idSong"), result.getFloat("Duracio"), result.getString("Nom"), result.getString("Autor"), result.getString("DataEnregistrament"), result.getString("Directori"), result.getInt("isPublic"), result.getString("NomUsuari"), result.getString("Midi")));
            }
            return retorna;

        }catch(SQLException e){
            return retorna;
        }
    }

    /**
     * Retorna les cançons de Master
     * @return ArrayList amb les cançons de Master
     */
    @Override
    public ArrayList<Song> getMasterSongs(){
       ArrayList<Song> retorna = new ArrayList<>();
       String query = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari, Midi FROM Song WHERE NomUsuari LIKE 'Master';";
       ResultSet result = connector.selectQuery(query);
       try{
           while(result.next()){
               retorna.add(new Song(result.getInt("NumReproduccions"), result.getInt("idSong"), result.getFloat("Duracio"), result.getString("Nom"), result.getString("Autor"), result.getString("DataEnregistrament"), result.getString("Directori"), result.getInt("isPublic"), result.getString("NomUsuari"), result.getString("Midi")));
           }
           return retorna;

       }catch(SQLException e){
           return retorna;
       }
   }



    /**
     * Reotorna les cançons de l'usuari i després les de Master, en aquest ordre
     * @param username nom d'usuari USERNAME (no email) per enviar a buscar cançons
     * @return ArrayList de Songs
     */
   @Override
   public ArrayList<Song> getUserAndMasterSongs(String username){
        ArrayList<Song> retorna;
        ArrayList<Song> retorna2;

        retorna = getUserSongs(username);
        retorna2 = getMasterSongs();

        if(!retorna2.isEmpty()){
            retorna.addAll(retorna2);
        }

        return retorna;

   }


    /**
     * Reotorna les cançons publiques i després les de Master, en aquest ordre
     * @return ArrayList amb les cançons
     */
    @Override
    public ArrayList<Song> getPublicAndMasterSongs(){
        ArrayList<Song> retorna;
        ArrayList<Song> retorna2;

        retorna = getPublicCreatedSongs();
        retorna2 = getMasterSongs();

        if(!retorna2.isEmpty()){
            retorna.addAll(retorna2);
        }

        return retorna;

    }

    /**
     *  Mètode per registrar la façada de presentació
     * @param presentationFacade la classe ja creada
     */
    @Override
    public void registerPresentationFacade(PresentationFacade presentationFacade) {
        this.presentationFacade=presentationFacade;
    }

    /**
     * Mèotde per obtenir una cançó pel seu nom i l'usuari propietari (pot ser Master)
     * @param name nom de la cançó
     * @param username nom de l'usauri
     * @return l'Arraylist de cançons
     */
    @Override
    public Song getSongByName(String name, String username){
        Song songToReturn = null;
        //String query = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari, Midi FROM Song WHERE NomUsuari LIKE '" + username + "' AND Nom '" + name + "';";
        String query = "SELECT IDSong, NumReproduccions, Nom, Autor, Duracio, DataEnregistrament, Directori, isPublic, NomUsuari, Midi FROM Song WHERE (NomUsuari LIKE '" + username + "' OR NomUsuari LIKE 'MASTER') AND Nom LIKE '" + name + "'";
        ResultSet result = connector.selectQuery(query);
        try{
            while(result.next()) {
                return (songToReturn = new Song(result.getInt("NumReproduccions"), result.getInt("idSong"), result.getFloat("Duracio"), result.getString("Nom"), result.getString("Autor"), result.getString("DataEnregistrament"), result.getString("Directori"), result.getInt("isPublic"), result.getString("NomUsuari"), result.getString("Midi")));
            }
            return songToReturn;
        }catch (SQLException e){
            e.printStackTrace();
            return songToReturn;
        }
    }

}
