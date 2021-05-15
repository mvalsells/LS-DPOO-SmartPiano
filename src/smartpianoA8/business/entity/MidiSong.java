package smartpianoA8.business.entity;

import java.time.LocalDate;

/**
 * Entity de cançó codificada en MIDI
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class MidiSong {

    private String songName;
    private String author;
    private String datePublished;
    private String midiAddress;

    /**
     * Constructor buit
     */
    public MidiSong() {}

    /**
     * Constructor emplentant totes les dades
     * @param songName String nom de la cançó
     * @param author String nom de l'autor
     * @param datePublished String data de publicació
     * @param midiAddress String ruta del fitxer MIDI
     */
    public MidiSong(String songName, String author, String datePublished, String midiAddress) {
        this.songName = songName;
        this.author = author;
        this.datePublished = datePublished;
        this.midiAddress = midiAddress;
    }

    /**
     * Mètode per comprovar si dos MidiSong són iguals
     * @param obj MidiSong a comprovar
     * @return Boolean true: iguals
     *         false: diferents
     * @see MidiSong
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MidiSong) {
            return this.songName.equals(((MidiSong) obj).songName);
        }else {
            return false;
        }
    }

    /**
     * Getter del nom de la cançó
     * @return String amb el nom
     */
    public String getSongName() {
        return songName;
    }
}
