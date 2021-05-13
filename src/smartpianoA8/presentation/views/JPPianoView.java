package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.ColorScheme;
import smartpianoA8.presentation.views.customComponents.JLColor;
import smartpianoA8.presentation.views.customComponents.JPMainView;
import smartpianoA8.presentation.views.customComponents.JPNavBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;


public class JPPianoView extends JPMainView {
    // ---- Inici Atributs ----
    private JPNavBar jpNavBar;
    private JPanel jpMain;
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JPPianoView(){
        setLayout(new BorderLayout());



        //Main JPanel
        jpMain = new JPMainView();
        jpMain.add(new JLColor("PIANO", ColorScheme.PRIMARY));


        //Final Packing
        jpNavBar = new JPNavBar(JFMainFrame.PIANO);
        add(jpNavBar,BorderLayout.WEST);
        add(jpMain,BorderLayout.CENTER);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        jpNavBar.registerController(actionListener);
    }
}
