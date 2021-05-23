package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.JFMainFrame;
import smartpianoA8.presentation.views.customComponents.playlist.JDPlaylistCreator;
import smartpianoA8.presentation.views.customComponents.playlist.JPPlaylistSettings;
import smartpianoA8.presentation.views.customComponents.playlist.JPPlaylistView;
import smartpianoA8.presentation.views.customComponents.songs.JPSongs;
import smartpianoA8.presentation.views.customComponents.songs.JPTiraCancons;

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

            presentationController.changeView(JFMainFrame.PIANO);
            presentationController.mainFrameControllerSetShowingPiano(true);
            presentationController.mainFrameControllerSetShowingPlaylists(false);
            presentationController.mainFrameControllerSetShowingProfile(false);
            presentationController.mainFrameControllerSetShowingSongs(false);
            presentationController.startCascade();

        }else if(e.getActionCommand().contains(JPTiraCancons.PAPELERA)){
            System.out.println("ENTRA PROFA PLS V2");

            String[] split = e.getActionCommand().split("-");

            presentationController.playlistViewUpdateWhenRemoveSong(presentationController.getSongByID(Integer.parseInt(split[1])),PresentationController.ELIMINAR_FROM_SONGS_WHILE_IN_PLAYLISTS);
            presentationController.removeSongFromDBAndLocal(presentationController.getSongByID(Integer.parseInt(split[1])));
        }else {

            switch (e.getActionCommand()) {
                case JPPlaylistSettings.ADD:
                    System.out.println(presentationController.playlistViewGetJCSongAdderString());
                    presentationController.playlistAddSongToPlayList(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongAdderString()), presentationController.playlistGetPlayListByName(presentationController.playlistViewGetJCTriarPlaylistString()));
                    //presentationController.playlistViewUpdateJPPlaylistSettings();
                    presentationController.playlistViewUpdateWhenAddSong(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongAdderString()));
                    break;
                case JPPlaylistSettings.REMOVE:
                    try {
                        presentationController.playlistRemoveSongToPlayList(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongRemoveString()), presentationController.playlistGetPlayListByName(presentationController.playlistViewGetJCTriarPlaylistString()));
                        //presentationController.playlistViewUpdateJPPlaylistSettings();
                        presentationController.playlistViewUpdateWhenRemoveSong(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongRemoveString()),PresentationController.ELIMINAR_FROM_PLAYLISTS);
                    }catch (NullPointerException exception){
                        JOptionPane.showMessageDialog(new Frame(),"Esta playlist ya esta vacia!\nAntes de eliminar una canicon deberias añadirla", "No hay canciones a eliminar!",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case JPPlaylistView.NEW_PLAYLIST:
                    presentationController.playlistJDPlaylistCreatorRun();
                    break;
                case JPPlaylistView.DELETE_PLAYLIST:
                    presentationController.playlistRemovePlaylist(presentationController.playlistViewGetJCTriarPlaylistString());
                    break;
                case JDPlaylistCreator.CREATE_PLAYLIST:
                    if(!(presentationController.jdPlaylistGetTextFieldString().equals(""))&&!(presentationController.playlistDoesPlayListExists(presentationController.jdPlaylistGetTextFieldString()))) {
                        presentationController.playlistAddPlayList(presentationController.jdPlaylistGetTextFieldString());
                        //add presentation add to player
                        presentationController.playlistJDPlaylistCreatorClose();
                    }else if(presentationController.jdPlaylistGetTextFieldString().equals("")&&!(presentationController.playlistDoesPlayListExists(presentationController.jdPlaylistGetTextFieldString()))){
                        JOptionPane.showMessageDialog(new Frame(),"No le has puesto nombre a la Playlist!", "Dale un nombre!",JOptionPane.ERROR_MESSAGE);
                    }else if(!(presentationController.jdPlaylistGetTextFieldString().equals(""))&&(presentationController.playlistDoesPlayListExists(presentationController.jdPlaylistGetTextFieldString()))){
                        JOptionPane.showMessageDialog(new Frame(),"Esta Playlist ya existe, dale otro nombre.", "Ya tienes una Playlist con este nombre",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case JDPlaylistCreator.DISCARD_PLAYLIST:

                    presentationController.playlistJDPlaylistCreatorClose();

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
