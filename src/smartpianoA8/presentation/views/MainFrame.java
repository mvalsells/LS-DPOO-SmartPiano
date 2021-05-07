package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.JPPiano;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.net.http.WebSocket;

public class MainFrame extends JFrame {

    public static final String JPPianoString = "JPPianoString";

    private CardLayout cards;
    private JPanel mainPanel;
    private JPPiano JPPiano;

    public MainFrame(JPPiano JPPiano){

        cards = new CardLayout();
        mainPanel = new JPanel(cards);

        this.JPPiano = JPPiano;

        createAndShowGUI();
    }

    public void createAndShowGUI(){

        JFrame frame  = new JFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,820));

        mainPanel.add(JPPiano,JPPianoString);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }

    public void registerController(ActionListener controller, KeyListener keyListener, MouseListener mouseListener){

        JPPiano.registerController(controller,keyListener,mouseListener);

    }

    public void changePanel(String panel){

        switch (panel){

        }

    }

}
