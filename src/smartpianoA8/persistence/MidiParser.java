package smartpianoA8.persistence;

import smartpianoA8.business.entity.Notes;

import java.util.ArrayList;

public interface MidiParser {

    public void ParseMidi(String dir);
    public int numTracks();
    public ArrayList<ArrayList<Notes>> getTracks();
    public float getBPM();
    public float getSecondsPerTick();
    public float getTotalSongSeconds();
    public long getTotalTicks();

}
