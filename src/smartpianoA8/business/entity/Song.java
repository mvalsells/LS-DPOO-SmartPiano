package smartpianoA8.business.entity;

import java.sql.Time;
import java.time.LocalDate;

public class Song {

    private final int idSong;
    private final String nom;
    private final int numReproduccions;
    private final String autor;
    private final Time duracio;
    private final LocalDate dataEnregistrament;
    private final String directori;
    private Boolean isPublic;
    private final String nomUsuari;

    public Song(int idSong, Time duracio, String nom, String autor, String directori, Boolean isPublic, String nomUsuari){
        this.idSong = idSong;
        this.nom = nom;
        this. autor = autor;
        this.directori = directori;
        this.isPublic = isPublic;
        this. nomUsuari = nomUsuari;
        this.numReproduccions = 0;
        this.duracio = duracio;
        this.dataEnregistrament = LocalDate.now();
    }

    public void changePrivatePublic(Boolean newIsPublic){
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

    public Time getDuracio() {
        return duracio;
    }

    public LocalDate getDataEnregistrament() {
        return dataEnregistrament;
    }

    public String getDirectori() {
        return directori;
    }

    public int getIdSong() {
        return idSong;
    }

    public Boolean getPublic() {
        return isPublic;
    }
}
