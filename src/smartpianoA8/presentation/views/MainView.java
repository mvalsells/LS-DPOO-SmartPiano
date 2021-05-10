package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.ColorScheme;
import smartpianoA8.presentation.views.customComponents.JBNavBar;
import smartpianoA8.presentation.views.customComponents.JPPiano;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class MainView extends JPanel {


    public static final String chgToPiano = "jpPiano";
    public static final String chgToProfile = "jpProfile";
    public static final String chgToSongs = "jpSongs";
    public static final String chgToFavs = "jpFavs";



    private JPPiano jpPiano;
    private JPProfile jpUserAcountView;

    private CardLayout cards;
    private JPanel jpCardPanel;

    private JButton jbSong;
    private JButton jbMyFav;
    private JButton jbPiano;


    public MainView(){

        // ---- START MainView general Panel ----
        setLayout(new BorderLayout());
        setBackground(ColorScheme.MainView_Background);
        // ---- END MainView general Panel ----

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

        jbSong = new JBNavBar(iconSong, iconSongPressed);
        jbSong.setActionCommand(chgToSongs);
        jbMyFav = new JBNavBar(iconMyFav, iconMyFavPressed);
        jbMyFav.setActionCommand(chgToFavs);
        jbPiano = new JBNavBar(iconPiano, iconPianoPressed);
        jbPiano.setActionCommand(chgToPiano);



        jpNavBarNorth.add(Box.createVerticalStrut(BordersView.NavBar_EspaiEntreBotons/2));
        jpNavBarNorth.add(jbSong);
        jpNavBarNorth.add(Box.createVerticalStrut(BordersView.NavBar_EspaiEntreBotons));
        jpNavBarNorth.add(jbMyFav);
        jpNavBarNorth.add(Box.createVerticalStrut(BordersView.NavBar_EspaiEntreBotons));
        jpNavBarNorth.add(jbPiano);

        //Panell General south

        JButton jbSettings = new JBNavBar(iconSettings, iconSettings);

        //Navigation bar packing
        jpNavBar.add(jpNavBarNorth,BorderLayout.NORTH);
        jpNavBar.add(jbSettings, BorderLayout.SOUTH);
        // ---- END Navigation Bar (west) ----

        // Final Packing
        cards = new CardLayout();
        jpCardPanel = new JPanel(cards);
        jpPiano = new JPPiano();
        jpUserAcountView = new JPProfile();


        add(jpNavBar,BorderLayout.WEST);
        add(jpCardPanel,BorderLayout.CENTER);

        jpCardPanel.add(jpUserAcountView,chgToProfile);
        jpCardPanel.add(jpPiano,chgToPiano);




    }

    public void changeToJPPiano(){cards.show(jpCardPanel,chgToPiano); }
    public void changeToJPProfile(){cards.show(jpCardPanel,chgToProfile); }
    public void changeToJPSongs(){/*cards.show(,chgToSongs); */}
    public void changeToJPFavs(){/*cards.show(,chgToFavs); */}



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

    public void registerControllerJPNavBar(ActionListener controller){

        jbSong.addActionListener(controller);
        jbMyFav.addActionListener(controller);
        jbPiano.addActionListener(controller);

    }

    public void registerControllerJPPiano(ActionListener controller, KeyListener keyListener, MouseListener mouseListener) {
        jpPiano.registerController(controller,keyListener,mouseListener);
    }

}
