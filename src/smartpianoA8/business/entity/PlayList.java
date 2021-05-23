package smartpianoA8.business.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Entity de playlist
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class PlayList {
    private String nom;
    private final int idPlayList;
    private ArrayList<Song> songs;
    private final String nomUsuari;

    /**
     *
     * @param nom nom de la playlist
     * @param idPlayList codi identificador
     */
    public PlayList(String nom, int idPlayList, String nomUsuari){
        this.nom = nom;
        this.idPlayList = idPlayList;
        this.nomUsuari = nomUsuari;
        this.songs = new ArrayList<>();

    }

    /**
     * Setter del nom
     * @param nouNom String nom
     */
    public void changeName(String nouNom){
        this.nom = nouNom;
    }

    /**
     * Mètode que elimina una cançó ja existent
     * @param song Cançó de tipus Song a borrar
     */
    public void removeSong(Song song){
        songs.remove(song);
    }

    /**
     * Mètode per afegir una cançó ja existent
     * @param song Song a afegir
     */
    public void addSong(Song song){
        songs.add(song);
    }

    /**
     * Mètode per obtenir totes les cançons en ArrayList d'una playlist
     * @return ArrayList<Song></Song> amb les cançons
     */
    public ArrayList<Song> getSongs(){
        if(songs.size() == 0) {
            return null;
        }
        else {
            return this.songs;
        }
    }

    /**
     * Getter del propietari de la playlist
     * @return String nom del propietari (usuari)
     */
    public String getNomUsuari() {
        return nomUsuari;
    }

    /**
     * Getter del nom de la playlist
     * @return String nom de la playlist
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'ID de la playlist
     * @deprecated Sense ús
     * @return
     */
    public int getIdPlayList() {
        return idPlayList;
    }

    /**
     * Mètode que afageix en bulk cançons
     * @param songs les cançons
     */
    public void setSongs(ArrayList<Song> songs){
        this.songs = songs;
    }
}
