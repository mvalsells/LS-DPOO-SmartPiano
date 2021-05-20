package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;


public class JPPianoView extends JPMainView {
    // ---- Inici Atributs ----
    private JPPiano jpPiano;
    private JDPianoRegAdd jdPianoRegAdd;

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JPPianoView(){
        setLayout(new BorderLayout());



        //ShowDialog
        jdPianoRegAdd = new JDPianoRegAdd();
        jpPiano = new JPPiano();
        //Final Packing
        add(jpPiano,BorderLayout.CENTER);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----

    public void setRecordingPressedIcon(JButton button){ jpPiano.setPressedIcon(button); }
    public void setRecordingUnpressedIcon(JButton button){
        jpPiano.setUnpressedIcon(button);
    }


    public void registerControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        jdPianoRegAdd.registerControllerJDPianoRegAdd(actionListener);
        jpPiano.registerController(actionListener,keyListener,mouseListener);
    }

    public void jdRun() {jdPianoRegAdd.run();    }

    public void jdClose() { jdPianoRegAdd.close();}

    public String getTextFieldString() { return jdPianoRegAdd.getTextFieldString();}

    public boolean isCheckBoxSelected() { return jdPianoRegAdd.isCheckBoxSelected();}
}
