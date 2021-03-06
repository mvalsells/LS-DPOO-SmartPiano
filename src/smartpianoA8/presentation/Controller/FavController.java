package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.JFMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe controller de la vista de preferits
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
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
    public void registerPresentationController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }

    /**
     * Mètode per intercanviar la vsta
     * @param e ActionEvent del canvi de vista
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            //Fav View
            /*case bla:
                break;*/
        }
    }
}
