package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.ColorScheme;
import smartpianoA8.presentation.views.customComponents.JBNavBar;

import javax.swing.*;
import java.awt.*;

public class MainViewV2 extends JPanel {

    public MainViewV2(){

        // ---- START MainView general Panel ----
        setLayout(new BorderLayout());
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

        JButton jbSong = new JBNavBar(iconSong, iconSongPressed);
        jbSong.setBackground(Color.BLUE);
        jbSong.setBorder(BorderFactory.createEmptyBorder(80,0,0,275));
        JButton jbMyFav = new JBNavBar(iconMyFav, iconMyFavPressed);
        jbMyFav.setBackground(Color.CYAN);
        jbMyFav.setBorder(BorderFactory.createEmptyBorder(275,0,0,275));
        JButton jbPiano = new JBNavBar(iconPiano, iconPianoPressed);
        jbPiano.setBackground(Color.RED);
        jbPiano.setBorder(BorderFactory.createEmptyBorder(275,0,0,0));

        jpNavBarNorth.add(jbSong);
        jpNavBarNorth.add(jbMyFav);
        jpNavBarNorth.add(jbPiano);

        //Panell General south

        JButton jbSettings = new JBNavBar(iconSettings, iconSettings);

        //Navigation bar packing
        jpNavBar.add(jpNavBarNorth,BorderLayout.NORTH);
        jpNavBar.add(jbSettings, BorderLayout.SOUTH);
        // ---- END Navigation Bar (west) ----

        // Final Packing
        add(jpNavBar,BorderLayout.WEST);

    }
}
