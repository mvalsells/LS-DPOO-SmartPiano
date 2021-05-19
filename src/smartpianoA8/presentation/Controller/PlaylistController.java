package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.JPPlaylistSettings;
import smartpianoA8.presentation.views.customComponents.JPPlaylistView;
import smartpianoA8.presentation.views.customComponents.JPSongs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PlaylistController implements ActionListener {

    // ---- Inici Atributs ----
    private PresentationController presentationController;
    // ---- Fi Atributs ----
    // ---- Inici Constructor ----

    /**
     * Consructor buit
     */
    public PlaylistController(){

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

        switch (e.getActionCommand()){
            case JPPlaylistSettings.ADD:
                System.out.println(presentationController.playlistViewGetJCSongAdderString());
                presentationController.playlistAddSongToPlayList(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongAdderString()),presentationController.playlistGetPlayListByName(presentationController.playlistViewGetJCTriarPlaylistString()));
                presentationController.playlistViewUpdateJPPlaylistSettings();

                break;
            case JPPlaylistSettings.REMOVE:

                presentationController.playlistRemoveSongToPlayList(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongAdderString()), presentationController.playlistGetPlayListByName(presentationController.playlistViewGetJCTriarPlaylistString()));
                System.out.println(presentationController.playlistViewGetJCSongRemoveString());
                break;
            case JPPlaylistView.MOSTRAR_PLAYLIST:
                //System.out.println("PATATA MALDITAN ");
                presentationController.playlistViewChangeViewTo(presentationController.playlistViewGetJCTriarPlaylistString());
                break;

        }


    }




}
