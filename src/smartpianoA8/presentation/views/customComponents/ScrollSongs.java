package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScrollSongs extends JScrollPane {

    private  JButton jbMasButton[];
    private ArrayList<Song> songs;

    ImageIcon musicIcon = new ImageIcon("Imagen/ImagenesMenu/music.png");

    public ScrollSongs(ArrayList<Song> songs){

        this.songs = songs;

        setLayout(new ScrollPaneLayout());
        setOpaque(false);
        setBackground(ColorScheme.MainView_Background);
        setBorder(BorderFactory.createEmptyBorder(0,0,10,2));
        
       jbMasButton = new JBgeneral[songs.size()];
        
        for(int i=0; i< songs.size(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(JPSongs.SONG_PRESSED);
            sb.append(songs.get(i).getIdSong());
            jbMasButton[i] = new JBgeneral("Holi personi", ColorScheme.ORANGE_START);
            jbMasButton[i].setIcon(musicIcon);
            jbMasButton[i].setActionCommand(sb.toString());

            jbMasButton[i].setBorder(BorderFactory.createEmptyBorder(0,0,0,15));

            jbMasButton[i].setOpaque(false);
            jbMasButton[i].setContentAreaFilled(false);
            jbMasButton[i].setBorderPainted(false);

            add(jbMasButton[i]);

        }


    }

    public void registerController(ActionListener controller){

        for(int i=0; i< songs.size(); i++){

            jbMasButton[i].addActionListener(controller);
            //newButon[i].addActionListener(controller);

        }

    }


}
