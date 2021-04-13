package smartpianoA8.business.dao;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;

import java.util.ArrayList;

public interface PlayListDAO {

    void addPlayList(String name, String username);

    void addSongToPlayList(Song song, PlayList playList, String username);

    void removeSongFromPlayList(PlayList playList, Song song);

    void removePlayList(PlayList playList);

    ArrayList<PlayList> getPlayListsByUsers(String username);

    PlayList getPlayListData(PlayList playList);

    ArrayList<Song> getPlayListSongs(PlayList playList);
}
