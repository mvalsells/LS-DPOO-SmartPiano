package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.JFMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe controller de la vista de preferits
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see ActionListener
 */
public class FavController implements ActionListener {

    PresentationController presentationController;

    /**
     * Constructor buit
     */
    public FavController(){
    }

    /**
     * Mètode per registrar el controller
     * @param presentationController controlador de la presentació
     */
    public void registerMasterController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }

    /**
     * Mètode per intercanviar la vsta
     * @param e ActionEvent del canvi de vista
     */
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

            //Fav View
            /*case bla:
                break;*/
        }
    }
}
