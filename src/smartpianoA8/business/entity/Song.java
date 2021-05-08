package smartpianoA8.business.entity;

import java.sql.Time;
import java.time.LocalDate;

public class Song {

    public final static String Master = "Master";

    private final int idSong;
    private final String nom;
    private final int numReproduccions;
    private final String autor;
    private final float duracio;
    private String dataEnregistrament;
    private final String directori;
    private int isPublic;
    private final String nomUsuari;
    private final String midi;

    //TODO eliminar midi
    //todo implementar forma de obtener datos de canciones guardados en la BBDD segun el usuario quiera. (getAllSongsByName
    // y cuando se quiera alguna cancion en especifico recuperarla con una funcion que devuelva Song.)

    public Song(int idSong, float duracio, String nom, String autor, String datePublished, String directori, int isPublic, String nomUsuari, String midi) {
        this.idSong = idSong;
        this.nom = nom;
        this. autor = autor;
        this.directori = directori;
        this.isPublic = isPublic;
        this.nomUsuari = nomUsuari;
        this.numReproduccions = 0;
        this.duracio = duracio;
        this.dataEnregistrament = datePublished;
        this.midi = midi;
    }
    public Song(int numReproduccions, int idSong, float duracio, String nom, String autor, String datePublished, String directori, int isPublic, String nomUsuari, String midi) {
        this.idSong = idSong;
        this.nom = nom;
        this. autor = autor;
        this.directori = directori;
        this.isPublic = isPublic;
        this.nomUsuari = nomUsuari;
        this.numReproduccions = numReproduccions;
        this.duracio = duracio;
        this.dataEnregistrament = datePublished;
        this.midi = midi;
    }

    public void setDataEnregistrament(String dataEnregistrament) {
        this.dataEnregistrament = dataEnregistrament;
    }

    public void changePrivatePublic(int newIsPublic){
        this.isPublic = newIsPublic;
    }

    public int getNumReproduccions() {
        return numReproduccions;
    }

    public String getAutor() {
        return autor;
    }

    public String getNom() {
        return nom;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public float getDuracio() {
        return duracio;
    }

    public String getDataEnregistrament() {
        return dataEnregistrament;
    }

    public String getDirectori() {
        return directori;
    }

    public int getIdSong() {
        return idSong;
    }

    public int getPublic() {
        return isPublic;
    }

    public String getMidi(){
        return midi;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Song) {
            return this.nom.equals(((Song) obj).nom);
        }else {
            return false;
        }
    }
}
