package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.JPPlayer;
import smartpianoA8.presentation.views.customComponents.JPPlaylistSettings;
import smartpianoA8.presentation.views.customComponents.JPPlaylistView;
import smartpianoA8.presentation.views.customComponents.JPSongs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PlaylistController implements ActionListener, ItemListener{

    // ---- Inici Atributs ----
    private PresentationController presentationController;
    // ---- Fi Atributs ----
    // ---- Inici Constructor ----

    /**
     * Consructor buit
     */
    public PlaylistController() {
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    /**
     * Mètode per registrar el controller a la presentaicó
     * @param presentationController la presentació
     */
    public void registerPresentationController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }

    /**
     * Mètode per detectar i canviar de vista
     * @param e action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().contains(JPSongs.SONG_PRESSED)){

            String[] split = e.getActionCommand().split("-");

            presentationController.setLastSongPressed(Integer.parseInt(split[1]));
            System.out.println(Integer.parseInt(split[1]));

        }else {

            switch (e.getActionCommand()) {
                case JPPlaylistSettings.ADD:
                    System.out.println(presentationController.playlistViewGetJCSongAdderString());
                    presentationController.playlistAddSongToPlayList(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongAdderString()), presentationController.playlistGetPlayListByName(presentationController.playlistViewGetJCTriarPlaylistString()));
                    //presentationController.playlistViewUpdateJPPlaylistSettings();
                    presentationController.playlistViewUpdateWhenAdd(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongAdderString()));
                    break;
                case JPPlaylistSettings.REMOVE:
                    presentationController.playlistRemoveSongToPlayList(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongRemoveString()), presentationController.playlistGetPlayListByName(presentationController.playlistViewGetJCTriarPlaylistString()));
                    //presentationController.playlistViewUpdateJPPlaylistSettings();
                    presentationController.playlistViewUpdateWhenRemove(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongRemoveString()));
                    break;

            }
        }

    }


    @Override
    public void itemStateChanged(ItemEvent e) {

        if(e.getStateChange()==ItemEvent.SELECTED){

            Object obj = e.getSource();
            if(obj instanceof JComboBox){
                JComboBox jcb = (JComboBox)obj;
                String selectedPlaylist = (String) jcb.getSelectedItem();
                presentationController.playlistViewChangeViewTo(selectedPlaylist);
            }

        }


    }
}
