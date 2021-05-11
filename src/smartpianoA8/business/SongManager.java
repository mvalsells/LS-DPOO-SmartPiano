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

public class SongManager {

    private SongDAO songDAO;
    private MidiParser midiParser;

    public SongManager(SongDAO songDAO, MidiParser midiParser){
        this.songDAO = songDAO;
        this.midiParser = midiParser;
    }

    public void addSong(Song song, String userName) {
        songDAO.addSong(song, userName);
    }

    public ArrayList<ArrayList<Notes>> getMidiNotesParsed(Song song) {
        return midiParser.parseMidi(song.getDirectori());
    }

    public float getMidiBpm() {
        return midiParser.getBPM();
    }

    public int getMidiNumTracks() {
        return midiParser.numTracks();
    }

    public float getMidiSecondsPerTick() {
        return midiParser.getSecondsPerTick();
    }

    public float getMidiTotalSongSeconds() {
        return midiParser.getTotalSongSeconds();
    }

    public long getMidiTotalTicks() {
        return midiParser.getTotalTicks();
    }

    public int getTrackResolution() {
        return midiParser.getTrackResolution();
    }

    public ArrayList<Song> getMasterSongs() {
        return songDAO.getMasterSongs();
    }

}
