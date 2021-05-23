package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.JFMainFrame;
import smartpianoA8.presentation.views.customComponents.JPSongs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Classe controller de les cançons
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see ActionListener
 */
public class SongController implements ActionListener {

    // ---- Inici Atributs ----
    PresentationController presentationController;


    // ---- Fi Atributs ----
    // ---- Inici Constructors ----

    /**
     * Constructor buit
     */
    public SongController(){

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
        System.out.println("EING");
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

        }

    }

    /**
     * Mètode per obtenir quina ha sigut la última cançó clicada i operar amb ella
     * @return l'id de la cançó
     */


}
