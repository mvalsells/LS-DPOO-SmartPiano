package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.ColorScheme;
import smartpianoA8.presentation.views.customComponents.JLColor;
import smartpianoA8.presentation.views.customComponents.JPMainView;
import smartpianoA8.presentation.views.customComponents.JPNavBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPFavView extends JPMainView {
    // ---- Inici Atributs ----
    private JPNavBar jpNavBar;
    private JPanel jpMain;
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JPFavView(){
        setLayout(new BorderLayout());



        //Main JPanel
        jpMain = new JPMainView();
        jpMain.add(new JLColor("FAV", ColorScheme.PRIMARY));


        //Packing
        jpNavBar = new JPNavBar(JFMainFrame.FAVS);
        add(jpNavBar,BorderLayout.WEST);
        add(jpMain,BorderLayout.CENTER);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerControllers(ActionListener actionListener) {
        jpNavBar.registerController(actionListener);
    }
}
