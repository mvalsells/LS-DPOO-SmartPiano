package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.JBNavBar;

import javax.swing.*;
import java.awt.*;

public class MainViewV2 extends JPanel {

    private static final Color NavBar_Background = new Color(20,22,33);

    public MainViewV2(){

        // ---- START MainView general Panel ----
        setLayout(new BorderLayout());
        // ---- END MainView general Panel ----

        // ---- START ImageIcon ----
        ImageIcon canciones = new ImageIcon("Imagen/ImagenesMenu/Canciones.png");
        ImageIcon cancionesPressed = new ImageIcon("Imagen/ImagenesMenu/CancionesSelect.jpg");
        ImageIcon myFav = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritas.jpg");
        ImageIcon myFavPressed = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritasSelect.jpg");
        ImageIcon piano = new ImageIcon("Imagen/ImagenesMenu/Piano.jpg");
        ImageIcon pianoPressed = new ImageIcon("Imagen/ImagenesMenu/PianoSelect.jpg");
        ImageIcon ajustes = new ImageIcon("Imagen/ImagenesMenu/Ajustes.jpg");
        ImageIcon botoRegPiano = new ImageIcon("Imagen/ImagenesMenu/RegButton.jpg");
        ImageIcon botoRegPianoPressed = new ImageIcon("Imagen/ImagenesMenu/RegButtonPressed.jpg");
        // ---- END ImageIcon ----

        // ---- START Navigation Bar (west) ----
        JPanel jpNavBar = new JPanel();
        jpNavBar.setLayout(new BorderLayout());
        jpNavBar.setBackground(NavBar_Background);

        //Panell General north
        JPanel jpNavBarNorth = new JPanel();
        jpNavBarNorth.setOpaque(false);
        jpNavBarNorth.setLayout(new BoxLayout(jpNavBarNorth,BoxLayout.Y_AXIS));

        JButton jbSong = new JBNavBar(canciones, cancionesPressed);
        JButton jbMyFav = new JBNavBar(myFav, myFavPressed);
        JButton jbPiano = new JBNavBar(piano, pianoPressed);

        jpNavBarNorth.add(jbPiano);
        jpNavBarNorth.add(jbMyFav);
        jpNavBarNorth.add(jbSong);

        //Panell General south

        //Navigation bar packing
        jpNavBar.add(jpNavBarNorth,BorderLayout.NORTH);

        // ---- END Navigation Bar (west) ----

        // Final Packing
        add(jpNavBar,BorderLayout.WEST);

    }
}
