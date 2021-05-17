package smartpianoA8.persistence;

import smartpianoA8.business.entity.Notes;

import java.util.ArrayList;

/**
 * Interficie per l'edició reproducció i creació de cançons MIDI
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface MidiParser {

    public ArrayList<ArrayList<Notes>> parseMidi(String dir);
    public int numTracks();
    //public ArrayList<ArrayList<Notes>> getTracks();
    public float getBPM();
    public float getSecondsPerTick();
    public float getTotalSongSeconds();
    public long getTotalTicks();
    public int getTrackResolution();
    public float getMPQ();
    public float getusPerTick();

}
