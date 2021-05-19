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

        switch (e.getActionCommand()){
            case JPPlaylistSettings.ADD:
                presentationController.playlistViewGetJCSongAdderString();
                presentationController.playlistViewGetJCTriarPlaylistString();
                presentationController.playlistAddSongToPlayList(metode per obtenir canço a partir del seu nom,metode per obtenir playlist a partir del seu nom); //TODO getSongByName(String name),getPlaylistByName(String name)
                System.out.println(presentationController.playlistViewGetJCSongAdderString());
                break;
            case JPPlaylistSettings.REMOVE:
                presentationController.playlistViewGetJCSongRemoveString();
                presentationController.playlistViewGetJCTriarPlaylistString();
                presentationController.playlistRemoveSongToPlayList(metode per obtenir canço a partir del seu nom,metode per obtenir playlist a partir del seu nom); //TODO getSongByName(String name),getPlaylistByName(String name)
                System.out.println(presentationController.playlistViewGetJCSongRemoveString());
                break;


        }


    }


}
