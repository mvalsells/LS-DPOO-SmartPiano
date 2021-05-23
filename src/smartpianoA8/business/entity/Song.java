package smartpianoA8.business.entity;

/**
 * Entity de cançó amb les dades pertinents
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
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

    /**
     * Constructor amb les dades de la cançó SI ÉS NOVA
     * @param idSong int ID identificador de la DDBB
     * @param duracio float duració
     * @param nom String nom de la canço
     * @param autor Stirng autor
     * @param datePublished String data de creació (String per compatibilitat amb la BBDD)
     * @param directori String amb l'url d'internet si es dona el cas
     * @param isPublic int indicatiu de si és públic o privat (int per compatibilitat amb la BBDD)
     * @param nomUsuari String nom del propietari de la cançó
     * @param midi String amb la ruta del fitxer MIDI
     */
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

    /**
     * Contructor amb les dades de la cançó si s'obté de la BBDD
     * @param numReproduccions int amb la quantitat de reproduccions fins al moment
     * @param idSong int ID identificatiu
     * @param duracio float duració
     * @param nom String nom
     * @param autor String autor
     * @param datePublished String data de creació (String per compatibilitat amb la BBDD)
     * @param directori String amb l'url d'internet si s'escau
     * @param isPublic int indicatiu de si és públic o privat (int per compatibuilitat amb la BBDD)
     * @param nomUsuari String nom del propietari de la cancço
     * @param midi Strinc amb la ruta del fitxer MIDI
     */
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

    /**
     * Setter de la data de creació
     * @param dataEnregistrament String amb la data de creació
     */
    public void setDataEnregistrament(String dataEnregistrament) {
        this.dataEnregistrament = dataEnregistrament;
    }

    /**
     * Mètode per canviar l'estat de la privacitat
     * @param newIsPublic int 0: privat 1: públic
     * @implNote int per la compatibilitat dels Booleans a la BBDD ja que no funciona un TINYINT en tots els casos
     */
    public void changePrivatePublic(int newIsPublic){
        this.isPublic = newIsPublic;
    }

    /**
     * Getter del nombre de reproduccions
     * @return int quantitat de reproduccions globals
     */
    public int getNumReproduccions() {
        return numReproduccions;
    }

    /**
     * Getter del nom de l'autor
     * @return String no,
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Getter del nom de la caçó
     * @return String nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter del nom de l'usuari creador
     * @return String de l'usuari; #Rand: usuari; internet: "Master"
     */
    public String getNomUsuari() {
        return nomUsuari;
    }

    /**
     * Getter de la furació
     * @return float duració en segons
     */
    public float getDuracio() {
        return duracio;
    }

    /**
     * Getter de la data de creació
     * @return String data de creació
     * @implNote String per la compatibilitat del fetcher d'internet ja que moltes són "unknow" o "Arround 'date'"
     */
    public String getDataEnregistrament() {
        return dataEnregistrament;
    }

    /**
     * Getter de la url
     * @return String url
     */
    public String getDirectori() {
        return directori;
    }

    /**
     * Getter de l'ID
     * @return int ID
     *
     */
    public int getIdSong() {
        return idSong;
    }

    /**
     * Getter de l'identificador de si és pública o no
     * @return int 1: públic int 0: privat
     * @implNote int en comptes de Bool per facilitat la compatibilitat amb la BBDD
     */
    public int getPublic() {
        return isPublic;
    }

    /**
     * Getter del directori MIDI
     * @return String ruta del MIDI
     */
    public String getMidi(){
        return midi;
    }

    /**
     * Mètode per comprovar si dos cançons són iguals
     * @param obj <Song></Song> a comprovar
     * @return boolean true: igual, boolean false: diferents
     * @see Song
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Song) {
            return this.nom.equals(((Song) obj).nom);
        }else {
            return false;
        }
    }
}
