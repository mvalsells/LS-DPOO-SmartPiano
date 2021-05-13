package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPSongsView extends JPMainView {
    // ---- Inici Atributs ----
    private JPNavBar jpNavBar;
    private JPSongs jpSongs;
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JPSongsView(){
        setLayout(new BorderLayout());
        jpSongs = new JPSongs();

        //Final Packing
        jpNavBar = new JPNavBar(JFMainFrame.SONGS);
        add(jpNavBar,BorderLayout.WEST);
        add(jpSongs,BorderLayout.CENTER);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerControllers(ActionListener actionListener) {
        jpNavBar.registerController(actionListener);
        jpSongs.registerController(actionListener);
    }
}
