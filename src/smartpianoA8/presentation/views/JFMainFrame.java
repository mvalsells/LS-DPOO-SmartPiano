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
    public static final String PLAYLISTS = "playlists";
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
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1085,680));
        setLayout(new BorderLayout());
        //setLocationRelativeTo(null);

        //Panels (Navigation Bar options)
        jpSongs = new JPSongs(masterSongs);
        //jpFavView = new JPFavView(); //Substituida per JPPlaylistView
        jpPlaylistView = new JPPlaylistView();
        jpPianoView = new JPPianoView();
        jpProfileView = new JPProfileView(currentUser);
        jpPianoCascadeView = new JPPianoCascadeView();
        jpPlayer = new JPPlayer();
        jpNavBar = new JPNavBar();


        cards = new CardLayout();
        jpCardPanel = new JPanel(cards);
        jpCardPanel.add(jpSongs, SONGS);
        jpCardPanel.add(jpPlaylistView, PLAYLISTS);
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
        System.out.println("Comprovacio");
       jpPlaylistView.registerControllers(actionListener);
    }
    public void registerProfileViewControllers(ActionListener actionListener, MouseListener mouseListener){
        jpProfileView.registerControllers(actionListener, mouseListener);
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
            case PLAYLISTS:
                cards.show(jpCardPanel,PLAYLISTS);
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
    // ---- Start PlaylistView Methods
    public void playlistViewUpdateJPPlaylistView(ArrayList<PlayList> hasPlayLists, ArrayList<Song> songs){jpPlaylistView.updateJPPlaylistView(hasPlayLists,songs);}
    public void playlistViewUpdateJPPlaylistSettings(ArrayList<PlayList> hasPlayLists, ArrayList<Song> songs){ jpPlaylistView.updateJPPlaylistSettings(hasPlayLists,songs);}

    public void playlistViewUpdateWhenAdd(Song song){jpPlaylistView.updateWhenAdd(song);}
    public void playlistViewUpdateWhenRemove(Song song){jpPlaylistView.updateWhenRemove(song);}

    public void playlistViewChangeViewTo(String newView){jpPlaylistView.changeViewTo(newView);}

    public String playlistViewGetJCSongAdderString(){return jpPlaylistView.getJCSongAdderString();}
    public String playlistViewGetJCSongRemoveString(){return jpPlaylistView.getJCSongRemoveString();}
    public String playlistViewGetJCTriarPlaylistString(){return jpPlaylistView.getJCTriarPlaylistString();}
    // ---- End PlaylistView Methods
    // ---- Start PianoView Methods
    public void pianoViewSetRecordingPressedIcon(JButton button){ jpPianoView.setRecordingPressedIcon(button); }
    public void pianoViewSetRecordingUnpressedIcon(JButton button){
        jpPianoView.setRecordingUnpressedIcon(button);
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

    public void profileViewUpdateText(String username, String email){
        jpProfileView.updateText(username, email);
    }
    // ---- End ProfileView Methods








    public String getJComboBoxString() {
        return jpPlayer.getJComboBoxStringSelected();
    }



    public JPPlayer getPlayerView() {
        return jpPlayer;
    }


    public void setPlaylistsNames(ArrayList<String> playlistsNames) {

        jpPlayer.setPlaylistsNames(playlistsNames);

        //jpPlayer.removeAll();
        jpPlayer.validate();
        jpPlayer.repaint();
    }

}
