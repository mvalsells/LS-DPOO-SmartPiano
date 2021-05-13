package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.presentation.views.JFMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPNavBar extends JPanel {
    // ---- Inici Atributs ----
    private JButton jbSong;
    private JButton jbMyFav;
    private JButton jbPiano;
    private JButton jbProfile;
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JPNavBar(String currentView){
        setLayout(new BorderLayout());
        setBackground(ColorScheme.NavBar_Background);

        //Panell General north
        JPanel jpNavBarNorth = new JPanel();
        jpNavBarNorth.setOpaque(false);
        jpNavBarNorth.setLayout(new BoxLayout(jpNavBarNorth,BoxLayout.Y_AXIS));

        // ---- START ImageIcon ----
        ImageIcon iconSong = new ImageIcon("Imagen/ImagenesMenu/Canciones.png");
        ImageIcon iconMyFav = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritas.jpg");
        ImageIcon iconPiano = new ImageIcon("Imagen/ImagenesMenu/Piano.jpg");
        ImageIcon iconProfile = new ImageIcon("Imagen/ImagenesMenu/Ajustes.jpg");

        //Canviem el de la view actual
        switch (currentView){
            case JFMainFrame.SONGS:
                iconSong = new ImageIcon("Imagen/ImagenesMenu/CancionesSelect.jpg");
                break;
            case JFMainFrame.FAVS:
                iconMyFav = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritasSelect.jpg");
                break;
            case JFMainFrame.PIANO:
                iconPiano = new ImageIcon("Imagen/ImagenesMenu/PianoSelect.jpg");
                break;
            case JFMainFrame.PROFILE:
                iconProfile = new ImageIcon("Imagen/ImagenesMenu/Ajustes.jpg");
                break;
        }
        // ---- END ImageIcon ----

        jbSong = new JBNavBar(iconSong);
        jbSong.setActionCommand(JFMainFrame.SONGS);
        jbMyFav = new JBNavBar(iconMyFav);
        jbMyFav.setActionCommand(JFMainFrame.FAVS);
        jbPiano = new JBNavBar(iconPiano);
        jbPiano.setActionCommand(JFMainFrame.PIANO);



        jpNavBarNorth.add(Box.createVerticalStrut(BordersView.NavBar_EspaiEntreBotons/2));
        jpNavBarNorth.add(jbSong);
        jpNavBarNorth.add(Box.createVerticalStrut(BordersView.NavBar_EspaiEntreBotons));
        jpNavBarNorth.add(jbMyFav);
        jpNavBarNorth.add(Box.createVerticalStrut(BordersView.NavBar_EspaiEntreBotons));
        jpNavBarNorth.add(jbPiano);

        //Panell General south
        jbProfile = new JBNavBar(iconProfile);
        jbProfile.setActionCommand(JFMainFrame.PROFILE);

        //Navigation bar packing
        add(jpNavBarNorth,BorderLayout.NORTH);
        add(jbProfile, BorderLayout.SOUTH);
    }

    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerController(ActionListener controller){
        jbSong.addActionListener(controller);
        jbMyFav.addActionListener(controller);
        jbPiano.addActionListener(controller);
        jbProfile.addActionListener(controller);

    }
}
