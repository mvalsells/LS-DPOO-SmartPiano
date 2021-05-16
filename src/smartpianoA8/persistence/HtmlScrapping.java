package smartpianoA8.persistence;

import smartpianoA8.business.entity.MidiSong;
import smartpianoA8.business.entity.Song;

import java.util.ArrayList;

/**
 * Interficie per l'scrapper de cançons d'internet
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface HtmlScrapping {

    public ArrayList<Song> getMidiSongs();
    public boolean isNewData();

}
