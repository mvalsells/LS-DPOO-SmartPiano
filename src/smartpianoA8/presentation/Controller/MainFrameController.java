package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.*;

import javax.sound.midi.MidiChannel;
import java.awt.event.*;

public class MainFrameController{
    // ---- Inici Atributs ----
    private JFMainFrame jfMainFrame;
    private PresentationController presentationController;

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----

    public MainFrameController(MidiChannel midiChannel){
        this.jfMainFrame = new JFMainFrame();
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----

    //Controllers Registration
    public void registerMasterController(PresentationController presentationController){
        this.presentationController = presentationController;
    }

    public void registerSongViewControllers(ActionListener actionListener){
        jfMainFrame.registerSongViewControllers(actionListener);
    }

    public void registerFavViewControllers(ActionListener actionListener){
        jfMainFrame.registerFavViewControllers(actionListener);
    }
    public void registerProfileViewControllers(ActionListener actionListener){
        jfMainFrame.registerProfileViewControllers(actionListener);
    }
    public void registerPianoViewControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        jfMainFrame.registerPianoViewControllers(actionListener, mouseListener, keyListener);
    }
    public void registerPianoCascadeViewControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        jfMainFrame.registerPianoCascadeViewControllers(actionListener,mouseListener, keyListener);
    }


}
