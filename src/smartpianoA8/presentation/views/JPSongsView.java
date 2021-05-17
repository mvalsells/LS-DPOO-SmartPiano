package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.JPMainView;
import smartpianoA8.presentation.views.customComponents.JPNavBar;
import smartpianoA8.presentation.views.customComponents.JPNavPlayer;
import smartpianoA8.presentation.views.customComponents.JPSongs;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPSongsView extends JPMainView {
    // ---- Inici Atributs ----
    private JPNavBar jpNavBar;
    private JPNavPlayer jpNavPlayer;
    private JPSongs jpSongs;
    private JPMainView jpMain;
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JPSongsView(ArrayList<Song> masterSongs){
        jpMain = new JPMainView();
        jpNavPlayer = new JPNavPlayer();
        jpMain.setLayout(new BorderLayout());

        setLayout(new BorderLayout());
        jpSongs = new JPSongs(masterSongs);

        jpMain.add(jpSongs, BorderLayout.CENTER);
        jpMain.add(jpNavPlayer, BorderLayout.SOUTH);



        //Final Packing
        jpNavBar = new JPNavBar(JFMainFrame.SONGS);
        add(jpNavBar,BorderLayout.WEST);
        add(jpMain,BorderLayout.CENTER);
        //add(jpNavPlayer, BorderLayout.SOUTH);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    //public int jpSongSetLastIDPressed(){jpSongs.setLastSongID();}
    public void registerControllers(ActionListener actionListener) {
        jpNavBar.registerController(actionListener);
        jpSongs.registerController(actionListener);
    }

    public void nuevasCanciones() {
        jpSongs.nuevasCanciones();
    }
}
