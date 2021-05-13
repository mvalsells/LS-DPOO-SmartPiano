package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class JFMainFrame extends JFrame {
    // ---- Inici Atributs ----

    //Public constants
    public static final String PIANO = "piano";
    public static final String PROFILE = "profile";
    public static final String SONGS = "songs";
    public static final String FAVS = "favs";
    public static final String PIANO_CASCADE = "piano_cascade";

    //Private
    private JPSongsView jpSongsView;
    private JPFavView jpFavView;
    private JPPianoView jpPianoView;
    private JPProfileView jpProfileView;
    private JPPianoCascadeView jpPianoCascadeView;

    private CardLayout cards;
    private JPanel jpCardPanel;

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JFMainFrame(){

        //Frame
        JFrame frame  = new JFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1085,455));

        //Panels (Navigation Bar options)
        jpSongsView = new JPSongsView();
        jpFavView = new JPFavView();
        jpPianoView = new JPPianoView();
        jpProfileView = new JPProfileView();
        jpPianoCascadeView = new JPPianoCascadeView();

        cards = new CardLayout();
        jpCardPanel = new JPanel(cards);

        jpCardPanel.add(jpSongsView, SONGS);
        jpCardPanel.add(jpFavView, FAVS);
        jpCardPanel.add(jpPianoView, PIANO);
        jpCardPanel.add(jpProfileView, PROFILE);
        jpCardPanel.add(jpPianoCascadeView,PIANO_CASCADE);
        frame.getContentPane().add(jpCardPanel);
        frame.pack();
        frame.setVisible(true);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----

    //Controllers Registration
    public void registerSongViewControllers(ActionListener actionListener){
        jpSongsView.registerControllers(actionListener);
    }

    public void registerFavViewControllers(ActionListener actionListener){
        jpFavView.registerControllers(actionListener);
    }
    public void registerProfileViewControllers(ActionListener actionListener){
        jpProfileView.registerControllers(actionListener);
    }
    public void registerPianoViewControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        jpPianoView.registerControllers(actionListener, mouseListener, keyListener);
    }
    public void registerPianoCascadeViewControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        jpPianoCascadeView.registerControllers(actionListener, mouseListener, keyListener);
    }

    //Views managment
    public void changeViewTo(String newView){
        switch (newView){
            case SONGS:
                cards.show(jpCardPanel,SONGS);
                break;
            case FAVS:
                cards.show(jpCardPanel,FAVS);
                break;
            case PIANO:
                cards.show(jpCardPanel,PIANO);
                break;
            case PROFILE:
                cards.show(jpCardPanel,PROFILE);
                break;
            case PIANO_CASCADE:
                cards.show(jpCardPanel,PIANO_CASCADE);
                break;
        }
    }

}
