package smartpianoA8.persistence;

import smartpianoA8.business.entity.MidiSong;
import smartpianoA8.business.entity.Song;

import java.util.ArrayList;

public interface HtmlScrapping {

    public ArrayList<Song> getMidiSongs();
    public boolean isNewData();

}
