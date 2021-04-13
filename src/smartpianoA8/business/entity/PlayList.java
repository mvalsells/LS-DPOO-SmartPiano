package smartpianoA8.business.entity;

import java.util.ArrayList;

/**
 * Classe PlayList que representa una llista de reproducció
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
    PlayList(String nom, int idPlayList, String nomUsuari){
        this.nom = nom;
        this.idPlayList = idPlayList;
        this.nomUsuari = nomUsuari;
        ArrayList<Song> songs = new ArrayList<Song>();

    }

    public void changeName(String nouNom){
        this.nom = nouNom;
    }

    public void removeSong(Song song){
        songs.remove(song);
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public ArrayList<Song> getSongs(){
        return this.songs;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public String getNom() {
        return nom;
    }

    public int getIdPlayList() {
        return idPlayList;
    }
}
