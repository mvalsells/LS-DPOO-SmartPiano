/*package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class MainView extends JPanel {

    /*

   ======================================================
   ====== HA D'ANAR AL CEMENTIRI ========================
   ======================================================

     */

/*
    public static final String chgToPiano = "jpPiano";
    public static final String chgToProfile = "jpProfile";
    public static final String chgToSongs = "jpSongs";
    public static final String chgToFavs = "jpFavs";



    private JPPiano jpPiano;
    private JPProfileView jpUserAcountView;
    private JPSongs jpSongs;
    private JDPianoRegAdd jdPianoRegAdd;

    private CardLayout cards;
    private JPanel jpCardPanel;

    private JButton jbSong;
    private JButton jbMyFav;
    private JButton jbPiano;
    private JButton jbSettings;



    public MainView(){

        // ---- START MainView general Panel ----
        setLayout(new BorderLayout());
        setBackground(ColorScheme.MainView_Background);
        // ---- END MainView general Panel ----
        // ---- START JDPianoRegAdd ----
        jdPianoRegAdd = new JDPianoRegAdd();
        // ---- END JDPianoRegAdd ----
        // ---- START ImageIcon ----
        ImageIcon iconSong = new ImageIcon("Imagen/ImagenesMenu/Canciones.png");
        ImageIcon iconSongPressed = new ImageIcon("Imagen/ImagenesMenu/CancionesSelect.jpg");
        ImageIcon iconMyFav = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritas.jpg");
        ImageIcon iconMyFavPressed = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritasSelect.jpg");
        ImageIcon iconPiano = new ImageIcon("Imagen/ImagenesMenu/Piano.jpg");
        ImageIcon iconPianoPressed = new ImageIcon("Imagen/ImagenesMenu/PianoSelect.jpg");
        ImageIcon iconSettings = new ImageIcon("Imagen/ImagenesMenu/Ajustes.jpg");
        // ---- END ImageIcon ----

        // ---- START Navigation Bar (west) ----
        JPanel jpNavBar = new JPanel();
        jpNavBar.setLayout(new BorderLayout());
        jpNavBar.setBackground(ColorScheme.NavBar_Background);

        //Panell General north
        JPanel jpNavBarNorth = new JPanel();
        jpNavBarNorth.setOpaque(false);
        jpNavBarNorth.setLayout(new BoxLayout(jpNavBarNorth,BoxLayout.Y_AXIS));

        jbSong = null; //new JBNavBar(iconSong, iconSongPressed);
        jbSong.setActionCommand(chgToSongs);
        jbMyFav = null; //new JBNavBar(iconMyFav, iconMyFavPressed);
        jbMyFav.setActionCommand(chgToFavs);
        jbPiano = null; // new JBNavBar(iconPiano, iconPianoPressed);
        jbPiano.setActionCommand(chgToPiano);



        jpNavBarNorth.add(Box.createVerticalStrut(BordersView.NavBar_EspaiEntreBotons/2));
        jpNavBarNorth.add(jbSong);
        jpNavBarNorth.add(Box.createVerticalStrut(BordersView.NavBar_EspaiEntreBotons));
        jpNavBarNorth.add(jbMyFav);
        jpNavBarNorth.add(Box.createVerticalStrut(BordersView.NavBar_EspaiEntreBotons));
        jpNavBarNorth.add(jbPiano);

        //Panell General south

        jbSettings = null; //new JBNavBar(iconSettings, iconSettings);
        jbSettings.setActionCommand(chgToProfile);

        //Navigation bar packing
        jpNavBar.add(jpNavBarNorth,BorderLayout.NORTH);
        jpNavBar.add(jbSettings, BorderLayout.SOUTH);
        // ---- END Navigation Bar (west) ----

        // Final Packing
        cards = new CardLayout();
        jpCardPanel = new JPanel(cards);
        jpPiano = new JPPiano();
        //jpUserAcountView = new JPProfileView();
        //jpSongs = new JPSongs();


        add(jpNavBar,BorderLayout.WEST);
        add(jpCardPanel,BorderLayout.CENTER);

        jpCardPanel.add(jpUserAcountView,chgToProfile);
        jpCardPanel.add(jpPiano,chgToPiano);
        jpCardPanel.add(jpSongs,chgToSongs);




    }

    public void changeToJPPiano(){cards.show(jpCardPanel,chgToPiano); }
    public void changeToJPProfile(){cards.show(jpCardPanel,chgToProfile); }
    public void changeToJPSongs(){cards.show(jpCardPanel,chgToSongs); }
    public void changeToJPFavs(){/*cards.show(jpCardPanel,chgToFavs); }



    public void changePanel(String panel){

        switch (panel){

            case chgToPiano:
                changeToJPPiano();
                break;
            case chgToProfile:
                changeToJPProfile();
                break;
            case chgToSongs:
                changeToJPSongs();
                break;
            case chgToFavs:
                changeToJPFavs();
                break;
        }

    }

    public void jpSetRecordingPressedIcon(){
        jpPiano.setPressedIcon();
    }
    public void jpSetRecordingUnpressedIcon(){
        jpPiano.setUnpressedIcon();
    }

    public void jdRun(){jdPianoRegAdd.run();}
    public void jdClose(){jdPianoRegAdd.close();}
    public String jdGetTextFieldString(){return jdPianoRegAdd.getTextFieldString();}
    public boolean jdIsCheckBoxSelected(){return jdPianoRegAdd.isCheckBoxSelected();}



    public void registerControllerJPNavBar(ActionListener controller){

        jbSong.addActionListener(controller);
        jbMyFav.addActionListener(controller);
        jbPiano.addActionListener(controller);
        jbSettings.addActionListener(controller);

    }

    public void registerControllerJPPiano(ActionListener controller, KeyListener keyListener, MouseListener mouseListener) {
        jpPiano.registerController(controller,keyListener,mouseListener);
    }

    public void registerControllerJDPianoRegAdd(ActionListener controller){
        jdPianoRegAdd.registerControllerJDPianoRegAdd(controller);
    }

}
*/