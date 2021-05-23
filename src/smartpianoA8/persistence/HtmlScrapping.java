package smartpianoA8.persistence;

import smartpianoA8.business.entity.MidiSong;
import smartpianoA8.business.entity.Song;

import java.util.ArrayList;

/**
 * Interficie per l'scrapper de cançons d'internet
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface HtmlScrapping {
    /**
     * Mètode per obtenir l'ArrayList de cançons MIDI
     * @return ArrayList<Song> amb les cançons midi
     */
    public ArrayList<Song> getMidiSongs();

    /**
     * Mètode per descobrir si hi ha dades noves
     * @return true: si false: no
     */
    public boolean isNewData();

}
