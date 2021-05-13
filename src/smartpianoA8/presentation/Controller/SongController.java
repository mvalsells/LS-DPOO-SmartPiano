package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.JFMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongController implements ActionListener {

    // ---- Inici Atributs ----
    PresentationController presentationController;

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public SongController(){

    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerMasterController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            //NavBar
            case JFMainFrame.SONGS:
                presentationController.changeView(JFMainFrame.SONGS);
                break;
            case JFMainFrame.FAVS:
                presentationController.changeView(JFMainFrame.FAVS);
                break;
            case JFMainFrame.PIANO:
                presentationController.changeView(JFMainFrame.PIANO);
                break;
            case JFMainFrame.PROFILE:
                presentationController.changeView(JFMainFrame.PROFILE);
                break;
            case JFMainFrame.PIANO_CASCADE:
                presentationController.changeView(JFMainFrame.PIANO_CASCADE);
                break;
            //Song View
            /*case bla:
                break;*/
        }
    }
}
