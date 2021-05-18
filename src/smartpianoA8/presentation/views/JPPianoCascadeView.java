package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class JPPianoCascadeView extends JPMainView {
    // ---- Inici Atributs ----
    private JPPiano jpPiano;
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JPPianoCascadeView(){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


        JPanel jpCascade = new JPanel();
        jpCascade.setBackground(Color.darkGray);
        jpCascade.setMinimumSize(new Dimension(750,500));
        jpCascade.setBorder(BorderFactory.createEmptyBorder(375,250,375,250));

        add(new JLColor("Piano cascade", ColorScheme.PRIMARY));
        //JPPiano
        jpPiano  = new JPPiano();
        //Final Packing

        add(jpCascade);
        add(jpPiano,BorderLayout.SOUTH);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
    }
}
