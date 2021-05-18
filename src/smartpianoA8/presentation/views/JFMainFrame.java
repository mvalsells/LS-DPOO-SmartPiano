package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JFMainFrame extends JFrame {
    // ---- Inici Atributs ----

    //Public constants
    public static final String PIANO = "piano";
    public static final String PROFILE = "profile";
    public static final String SONGS = "songs";
    public static final String FAVS = "favs";
    public static final String PIANO_CASCADE = "piano_cascade";

    //Private
    private JPSongs jpSongs;
    //private JPFavView jpFavView; //Substituida per JPPlaylistView
    private JPPlaylistView jpPlaylistView;
    private JPPianoView jpPianoView;
    private JPProfileView jpProfileView;
    private JPPianoCascadeView jpPianoCascadeView;
    private JPNavBar jpNavBar;
    private JPPlayer jpPlayer;

    private CardLayout cards;
    private JPanel jpCardPanel;

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JFMainFrame(ArrayList<Song> masterSongs, User currentUser,ArrayList<PlayList> hasPlayLists){
        //Frame
        setTitle("SmartPiano");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(1085,660));
        setLayout(new BorderLayout());

        //Panels (Navigation Bar options)
        jpSongs = new JPSongs(masterSongs);
        //jpFavView = new JPFavView(); //Substituida per JPPlaylistView
        jpPlaylistView = new JPPlaylistView(hasPlayLists,masterSongs);
        jpPianoView = new JPPianoView();
        jpProfileView = new JPProfileView(currentUser);
        jpPianoCascadeView = new JPPianoCascadeView();
        jpPlayer = new JPPlayer();
        jpNavBar = new JPNavBar();


        cards = new CardLayout();
        jpCardPanel = new JPanel(cards);
        jpCardPanel.add(jpSongs, SONGS);
        jpCardPanel.add(jpPlaylistView, FAVS);
        jpCardPanel.add(jpPianoView, PIANO);
        jpCardPanel.add(jpProfileView, PROFILE);
        jpCardPanel.add(jpPianoCascadeView,PIANO_CASCADE);

        JPanel jpCenter = new JPMainView();
        jpCenter.setLayout(new BorderLayout());
        jpCenter.add(jpCardPanel, BorderLayout.CENTER);
        jpCenter.add(jpPlayer,BorderLayout.SOUTH);
        getContentPane().add(jpCenter, BorderLayout.CENTER);
        getContentPane().add(jpNavBar,BorderLayout.WEST);
        pack();
        setVisible(true);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----

    //Controllers Registration
    public void registerMainFrameController(ActionListener actionListener){
        jpNavBar.registerController(actionListener);
        jpPlayer.registerController(actionListener);
    }
    public void registerSongViewControllers(ActionListener actionListener){
        jpSongs.registerController(actionListener);
    }

    public void registerPlaylistViewControllers(ActionListener actionListener){
        jpPlaylistView.registerControllers(actionListener);
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
        jpNavBar.changeActiveElement(newView);
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


    // ---- Start SongView Methods
    //public int jpSongSetLastIDPressed(){jpSongsView.jpSongSetLastIDPressed();}
    public void nuevaCanciones() {
        jpSongs.nuevasCanciones();
    }
    // ---- End SongView Methods
    // ---- Start FavView Methods
    // ---- End FavView Methods
    // ---- Start PianoView Methods
    public void pianoViewSetRecordingPressedIcon(){ jpPianoView.setRecordingPressedIcon(); }
    public void pianoViewSetRecordingUnpressedIcon(){
        jpPianoView.setRecordingUnpressedIcon();
    }

    public void pianoViewJDRun(){jpPianoView.jdRun();}
    public void pianoViewJDClose(){jpPianoView.jdClose();}
    public String pianoViewJDGetTextFieldString(){return jpPianoView.getTextFieldString();}
    public boolean pianoViewJDIsCheckBoxSelected(){return jpPianoView.isCheckBoxSelected();}
    // ---- End PianoView Methods
    // ---- Start PianoCascadeView Methods
    // ---- End PianoCascadeView Methods
    // ---- Start ProfileView Methods
    public ArrayList<String> profileViewGetData() {
        return jpProfileView.profileViewGetData();
    }

    public void profileViewRegenerate(){
        jpProfileView.removeAll();
        jpProfileView.revalidate();
        jpProfileView.repaint();
    }
    // ---- End ProfileView Methods

}
