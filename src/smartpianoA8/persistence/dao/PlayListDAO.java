package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.util.ArrayList;

/**
 * Interficie pel control de playlists a la bbdd
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface PlayListDAO{

    /**
     * Mètode per crear una playlist
     * @param name nom de la playlist
     * @param username username propietari
     */
    void addPlayList(String name, String username);

    /**
     * Mètode per afegir una cançó a una playlist
     * @param song la cançó
     * @param playList la playlist
     */
    void addSongToPlayList(Song song, PlayList playList);

    /**
     * Mètode per eliminar una cançó d'una playlist
     * @param playList la playlist
     * @param song la cançó
     */
    void removeSongFromPlayList(PlayList playList, Song song);

    /**
     * Mètode per eliminar una playlist
     * @param playList la playlist
     */
    void removePlayList(PlayList playList);

    /**
     * Mètode per obtenir les playlist d'un usuari
     * @param user l'usuari
     * @return la playlist
     */
    ArrayList<PlayList> getPlayListsByUser(User user);

    /**
     * mètode per obtneir les dades d'una playlist
     * @param IDPlaylist la playlist ID
     * @return la playlist
     */
    PlayList getPlayListData(int IDPlaylist);

    /**
     * Mètode per obtenir les cançons d'una playlist
     * @param playList la playlist
     * @return Arraylist de cançons
     */
    ArrayList<Song> getPlayListSongs(PlayList playList);
}
