package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.JPMainView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.net.http.WebSocket;

public class MainFrame extends JFrame {

    public static final String mainViewString = "mainViewString";

    private MainView mainView;

    public MainFrame(MainView mainView){

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

    public void changePanel(String panel){ mainView.changePanel(panel); }

}
