package smartpianoA8.business;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.persistence.HtmlScrapping;
import smartpianoA8.persistence.MidiParser;
import smartpianoA8.persistence.dao.SongDAO;
import smartpianoA8.persistence.dao.UserDAO;

import java.awt.font.TextHitInfo;
import java.util.ArrayList;

/**
 * Classe que controla les cançons, MANAGER
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class SongManager {

    private SongDAO songDAO;
    private MidiParser midiParser;

    /**
     * Constructor
     * @param songDAO DAO de cançons
     * @param midiParser editor de MIDI
     */
    public SongManager(SongDAO songDAO, MidiParser midiParser){
        this.songDAO = songDAO;
        this.midiParser = midiParser;
    }

    /**
     * Mètode per afegir cançons a un usuari
     * @param song Song a afegir
     * @param userName username del propietari
     */
    public void addSong(Song song, String userName) {
        songDAO.addSong(song, userName);
    }

    /**
     * Mètode per obtenir les notes midi ordenades i processades
     * @param song Song a obtenir les notes
     * @return ArrayList d'Arraylist de notes
     */
    public ArrayList<ArrayList<Notes>> getMidiNotesParsed(Song song) {
        return midiParser.parseMidi(song.getDirectori());
    }

    /**
     * Mètode per obtenir els BPM d'una cançó MIDI
     * @return float BPMs
     */
    public float getMidiBpm() {
        return midiParser.getBPM();
    }

    /**
     * Mètode per obtenir la quantitat de tracks d'una cançó MIDI
     * @return int tracks
     */
    public int getMidiNumTracks() {
        return midiParser.numTracks();
    }

    /**
     * Getter de segons pet tick d'una caçó MIDI
     * @return float SpT
     */
    public float getMidiSecondsPerTick() {
        return midiParser.getSecondsPerTick();
    }

    /**
     * Getter dels segons totals d'una cançó MIDI
     * @return float segons
     */
    public float getMidiTotalSongSeconds() {
        return midiParser.getTotalSongSeconds();
    }

    /**
     * Getter de la quantitat de ticks d'una cançó MIDI
     * @return long ticks
     */
    public long getMidiTotalTicks() {
        return midiParser.getTotalTicks();
    }

    /**
     * Getter de la ressolució dels tracks d'una cançó MIDI
     * @return int ressolució
     */
    public int getTrackResolution() {
        return midiParser.getTrackResolution();
    }

    /**
     * Getter de les cançons públiques d'internet MIDI (diferent format)
     * @return ArrayList de Songs
     */
    public ArrayList<Song> getMasterSongs() {
        return songDAO.getMasterSongs();
    }

    /**
     * Reotorna les cançons de l'usuari, les públiques (i no usuari) i després les de Master, en aquest ordre
     * @param username nom d'usuari USERNAME (no email) per enviar a buscar cançons
     * @return ArrayList amb les cançons de l'usuari, les publiques (no de l'usuari) i les Master
     */
    public ArrayList<Song> getUserAndMasterSongs(String username){return songDAO.getUserAndMasterSongs(username);}

    /**
     * Getter de MPQ de les notes MIDI
     * @return float MPQ
     */
    public float getMidiNotesMPQ() {
        return midiParser.getMPQ();
    }

    /**
     * Getter de micosegons per tick de notes MIDI en caçons MIDI
     * @return float microsegons per tick
     */
    public float getµsPerTickMidiNotes() {
        return midiParser.getusPerTick();
    }

    public ArrayList<Song> getTop5(){
        return songDAO.getTop5();
    }
    public Song getSong(int id){return songDAO.getSong(id);}

}
