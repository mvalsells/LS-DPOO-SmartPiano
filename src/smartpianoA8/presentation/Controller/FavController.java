package smartpianoA8.presentation.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FavController implements ActionListener {

    // ---- Inici Atributs ----
    PresentationController presentationController;
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public FavController(){

    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerMasterController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
