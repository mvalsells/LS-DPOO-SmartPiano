package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.JFMainFrame;
import smartpianoA8.presentation.views.customComponents.JPPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController implements ActionListener {
    // ---- Inici Atributs ----
    private PresentationController presentationController;
    // ---- Fi Atributs ----
    // ---- Inici Constructor ----
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
            //Player
            case JPPlayer.PLAY_BUTTON:
                presentationController.playStatusInPlayer();
                break;
            case JPPlayer.PAUSE_BUTTON:
                presentationController.pauseStatusInPlayer();
                break;
            case JPPlayer.NEXT_BUTTON:
                presentationController.nextStatusInPlayer();
                break;
            case JPPlayer.PREVIOUS_BUTTON:
                presentationController.previousStatusInPlayer();
                break;
            case JPPlayer.STOP_BUTTON:
                presentationController.stopStatusInPlayer();
                break;
            case JPPlayer.UPLOAD_BUTTON:
                presentationController.loadPlaylistInPlayer();
                break;
        }
    }

    public void registerPresentationController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }
}
