package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.JPPlaylistSettings;
import smartpianoA8.presentation.views.customComponents.JPSongs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        System.out.println("PATATA MALDITAN ");
        switch (e.getActionCommand()){
            case JPPlaylistSettings.ADD:
                //TODO està bé això amb els paràmetres? (a sota)
                presentationController.playlistAddSongToPlayList(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongAdderString()),presentationController.playlistGetPlayListByName(presentationController.playlistViewGetJCTriarPlaylistString()));
                System.out.println(presentationController.playlistViewGetJCSongAdderString());
                break;
            case JPPlaylistSettings.REMOVE:
                //TODO està bé això amb els paràmetres? (a sota)
                presentationController.playlistViewGetJCSongRemoveString();
                presentationController.playlistViewGetJCTriarPlaylistString();
                presentationController.playlistRemoveSongToPlayList(presentationController.songGetSongByName(presentationController.playlistViewGetJCSongAdderString()), presentationController.playlistGetPlayListByName(presentationController.playlistViewGetJCTriarPlaylistString()));
                System.out.println(presentationController.playlistViewGetJCSongRemoveString());
                break;


        }


    }


}
