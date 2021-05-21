package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
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
                    try {
                        presentationController.playlistRemoveSongToPlayList(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongRemoveString()), presentationController.playlistGetPlayListByName(presentationController.playlistViewGetJCTriarPlaylistString()));
                        //presentationController.playlistViewUpdateJPPlaylistSettings();
                        presentationController.playlistViewUpdateWhenRemove(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongRemoveString()));
                    }catch (NullPointerException exception){
                        JOptionPane.showMessageDialog(new Frame(),"Esta playlist ya esta vacia!\nAntes de eliminar una canicon deberias añadirla", "No hay canciones a eliminar!",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case JPPlaylistView.NEW_PLAYLIST:
                    presentationController.playlistJDPlaylistCreatorRun();
                    break;
                case JPPlaylistView.DELETE_PLAYLIST:

                    break;
                case JDPlaylistCreator.DISCARD_PLAYLIST:
                    JOptionPane.showMessageDialog(new Frame(),"Estas Seuro????????", "YO NO LO HARIA EHHHHHHHHH",JOptionPane.ERROR_MESSAGE);
                    presentationController.playlistJDPlaylistCreatorClose();
                    JOptionPane.showMessageDialog(new Frame(),"Te JODES", "PD: DOGECOIN",JOptionPane.ERROR_MESSAGE);
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
