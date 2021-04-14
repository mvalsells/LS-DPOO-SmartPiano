package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.util.ArrayList;

public interface PlayListDAO {

    /**
     *
     * @param name
     * @param username
     */
    void addPlayList(String name, String username);

    /**
     *
     * @param song
     * @param playList
     * @param user
     */
    void addSongToPlayList(Song song, PlayList playList, User user);

    /**
     *
     * @param playList
     * @param song
     */
    void removeSongFromPlayList(PlayList playList, Song song);

    /**
     *
     * @param playList
     */
    void removePlayList(PlayList playList);

    /**
     *
     * @param user
     * @return
     */
    ArrayList<PlayList> getPlayListsByUser(User user);

    /**
     *
     * @param playList
     * @return
     */
    PlayList getPlayListData(PlayList playList);

    /**
     *
     * @param playList
     * @return
     */
    ArrayList<Song> getPlayListSongs(PlayList playList);
}
