package smartpianoA8.persistence;

import smartpianoA8.business.entity.MidiSong;

import java.util.ArrayList;

public interface HtmlScrapping {

    public ArrayList<MidiSong> getMidiSongs();
    public boolean isNewData();

}
