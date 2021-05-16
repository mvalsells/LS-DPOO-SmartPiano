/*package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class JFMainFrameOLD extends JFrame {
    /*

      ======================================================
      ====== HA D'ANAR AL CEMENTIRI ========================
      ======================================================

        *//*
    public static final String mainViewString = "mainViewString";

    private MainView mainView;

    public JFMainFrameOLD(MainView mainView){

        this.mainView = mainView;

        createAndShowGUI();
    }

    public void createAndShowGUI(){

        JFrame frame  = new JFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1085,455));


        frame.getContentPane().add(mainView);
        frame.pack();
        frame.setVisible(true);


    }

    public void registerControllerJPPiano(ActionListener controller, KeyListener keyListener, MouseListener mouseListener){
        mainView.registerControllerJPPiano(controller,keyListener,mouseListener);
    }

    public void registerControllerJPNavBar(ActionListener controller){

        mainView.registerControllerJPNavBar(controller);

    }

    public void registerControllerJDPianoRegAdd(ActionListener controller){
        mainView.registerControllerJDPianoRegAdd(controller);
    }

    public void changePanel(String panel){ mainView.changePanel(panel); }

    public void jpSetRecordingPressedIcon(){
        mainView.jpSetRecordingPressedIcon();
    }
    public void jpSetRecordingUnpressedIcon(){
        mainView.jpSetRecordingUnpressedIcon();
    }

    public void jdRun(){mainView.jdRun();}
    public void jdClose(){mainView.jdClose();}
    public String jdGetTextFieldString(){return mainView.jdGetTextFieldString();}
    public boolean jdIsCheckBoxSelected(){return mainView.jdIsCheckBoxSelected();}

}
*/