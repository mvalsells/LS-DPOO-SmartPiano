package smartpianoA8.persistence.dao;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;

import java.util.ArrayList;

public interface PlayListDAO {

    void addPlayList(String name, String username);

    void addSongToPlayList(Song song, PlayList playList, User user);

    void removeSongFromPlayList(PlayList playList, Song song);

    void removePlayList(PlayList playList);

    ArrayList<PlayList> getPlayListsByUser(User user);

    PlayList getPlayListData(PlayList playList);

    ArrayList<Song> getPlayListSongs(PlayList playList);
}
