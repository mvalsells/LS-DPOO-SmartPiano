package smartpianoA8.business.entity;

import java.sql.Time;
import java.time.LocalDate;

public class Song {

    public final static String Master = "Master";

    private final int idSong;
    private final String nom;
    private final int numReproduccions;
    private final String autor;
    private final Time duracio;
    private LocalDate dataEnregistrament;
    private String datePublished;
    private final String directori;
    private Boolean isPublic;
    private final String nomUsuari;
    private final String midi;

    public Song(int idSong, Time duracio, String nom, String autor, String directori, Boolean isPublic, String nomUsuari, String midi){
        this.idSong = idSong;
        this.nom = nom;
        this. autor = autor;
        this.directori = directori;
        this.isPublic = isPublic;
        this. nomUsuari = nomUsuari;
        this.numReproduccions = 0;
        this.duracio = duracio;
        this.dataEnregistrament = LocalDate.now();
        this.midi = midi;
    }

    public Song(int idSong, Time duracio, String nom, String autor, String datePublished, String directori, Boolean isPublic, String nomUsuari, String midi) {
        this.idSong = idSong;
        this.nom = nom;
        this. autor = autor;
        this.directori = directori;
        this.isPublic = isPublic;
        this. nomUsuari = nomUsuari;
        this.numReproduccions = 0;
        this.duracio = duracio;
        this.datePublished = datePublished;
        this.midi = midi;
    }

    public void setDataEnregistrament(LocalDate dataEnregistrament) {
        this.dataEnregistrament = dataEnregistrament;
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
