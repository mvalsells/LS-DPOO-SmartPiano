package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class JPPianoCascadeView extends JPMainView {
    // ---- Inici Atributs ----
    private JPNavBar jpNavBar;

    private JPPiano jpPiano;
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JPPianoCascadeView(){
        setLayout(new BorderLayout());


        add(new JLColor("Piano cascade", ColorScheme.PRIMARY));
        //JPPiano
        jpPiano  = new JPPiano();
        //Final Packing
        jpNavBar = new JPNavBar(JFMainFrame.SONGS);
        add(jpNavBar,BorderLayout.WEST);
        add(jpPiano,BorderLayout.SOUTH);
        //add(jpMain,BorderLayout.CENTER);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        jpNavBar.registerController(actionListener);
    }
}
