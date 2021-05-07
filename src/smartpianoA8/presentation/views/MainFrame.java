package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public static final String mainViewV2String = "MainViewV2String";

    private CardLayout cards;
    private JPanel mainPanel;
    private MainViewV2 mainViewV2;

    public MainFrame(MainViewV2 mainViewV2){

        cards = new CardLayout();
        mainPanel = new JPanel(cards);

        this.mainViewV2 = mainViewV2;

    }

    public void createAndShowGUI(){

        JFrame frame  = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,820));

        mainPanel.add(mainViewV2,mainViewV2String);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }

    public void registerController(ActionListener controller){

        //mainViewV2.registerController(controller);

    }

    public void changePanel(String panel){

        switch (panel){

        }

    }

}
