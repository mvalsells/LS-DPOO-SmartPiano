package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.JFMainFrame;
import smartpianoA8.presentation.views.customComponents.JPPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe pel control del frame principal on reposen les diferents pantalles
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see ActionListener
 */
public class MainFrameController implements ActionListener {
    // ---- Inici Atributs ----

    public static final Boolean SHOWING = true;
    public static final Boolean NOT_SHOWING = false;

    private PresentationController presentationController;

    private Boolean isShowingSongs = SHOWING;
    private Boolean isShowingPlaylists = NOT_SHOWING;
    private Boolean isShowingPiano = NOT_SHOWING;
    private Boolean isShowingProfile = NOT_SHOWING;
    //private Boolean isShowingPianoCascade = NOT_SHOWING;

    // ---- Fi Atributs ----
    // ---- Inici Constructor ----
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            //NavBar
            case JFMainFrame.SONGS:
                if(isShowingSongs==NOT_SHOWING) {
                    presentationController.changeView(JFMainFrame.SONGS);
                    isShowingSongs = SHOWING;
                    isShowingPlaylists=NOT_SHOWING;isShowingPiano=NOT_SHOWING; isShowingProfile=NOT_SHOWING;

                    presentationController.stopCascade();
                }
                break;
            case JFMainFrame.PLAYLISTS:
                if(isShowingPlaylists==NOT_SHOWING) {
                    presentationController.playlistViewUpdateJPPlaylistView(presentationController.getUserPlaylists(),presentationController.getMasterSongs());
                    presentationController.changeView(JFMainFrame.PLAYLISTS);
                    isShowingPlaylists = SHOWING;
                    isShowingSongs=NOT_SHOWING;isShowingPiano=NOT_SHOWING; isShowingProfile=NOT_SHOWING;

                    presentationController.stopCascade();
                }
                break;
            case JFMainFrame.PIANO:
                if(isShowingPiano==NOT_SHOWING) {
                    presentationController.changeView(JFMainFrame.PIANO);
                    isShowingPiano = SHOWING;
                    isShowingSongs=NOT_SHOWING;isShowingPlaylists=NOT_SHOWING; isShowingProfile=NOT_SHOWING;
                }
                break;
            case JFMainFrame.PROFILE:
                if(isShowingProfile==NOT_SHOWING) {
                    presentationController.changeView(JFMainFrame.PROFILE);
                    isShowingProfile = SHOWING;
                    isShowingSongs=NOT_SHOWING;isShowingPlaylists=NOT_SHOWING; isShowingPiano=NOT_SHOWING;

                    presentationController.stopCascade();
                }
                break;
            /*case JFMainFrame.PIANO_CASCADE:
                if(isShowingPianoCascade==NOT_SHOWING) {
                    presentationController.changeView(JFMainFrame.PIANO_CASCADE);
                    isShowingPianoCascade = SHOWING;
                    isShowingSongs=NOT_SHOWING;isShowingPlaylists=NOT_SHOWING; isShowingPiano=NOT_SHOWING;isShowingProfile=NOT_SHOWING;
                }
                break;*/
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

    public boolean isShowingSongs(){return isShowingSongs;}
    public boolean isShowingPlaylists(){return isShowingPlaylists;}

    public void registerPresentationController(PresentationController presentationController) {this.presentationController = presentationController; }

    public void setShowingPiano(Boolean showingPiano) {
        this.isShowingPiano = showingPiano;
    }

    //public void setShowingPianoCascade(Boolean showingPianoCascade) {this.isShowingPianoCascade = showingPianoCascade; }

    public void setShowingPlaylists(Boolean showingPlaylists) {
        this.isShowingPlaylists = showingPlaylists;
    }

    public void setShowingProfile(Boolean showingProfile) {
        this.isShowingProfile = showingProfile;
    }

    public void setShowingSongs(Boolean showingSongs) {
        this.isShowingSongs = showingSongs;
    }
}
