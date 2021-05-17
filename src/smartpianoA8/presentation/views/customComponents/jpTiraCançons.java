package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class jpTiraCançons extends JPMainView {

    private  JButton jbMasButton[];

    private ArrayList<Song> songs;

    ImageIcon musicIcon = new ImageIcon("Imagen/ImagenesMenu/music.png");

    public jpTiraCançons(ArrayList<Song> songs,String titul){

        this.songs = songs;

        setLayout(new BorderLayout());

        JPanel jpAmbSongs = new JPMainView();
        jpAmbSongs.setLayout(new FlowLayout(FlowLayout.LEADING));

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

            jpAmbSongs.add(jbMasButton[i]);

        }

        JScrollPane jsp = new JScrollPane(jpAmbSongs,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jsp.setOpaque(false);
        jsp.getHorizontalScrollBar().setOpaque(false);
        jsp.getHorizontalScrollBar().getComponent(1).setVisible(false);
        jsp.getHorizontalScrollBar().getComponent(0).setVisible(false);
        JLabel jlTitul = new JLColor(titul,Color.white);

        add(jlTitul,BorderLayout.NORTH);
        add(jsp,BorderLayout.CENTER);

    }

    public void registerController(ActionListener controller){

        for(int i=0; i< songs.size(); i++){

            jbMasButton[i].addActionListener(controller);
            //newButon[i].addActionListener(controller);

        }

    }


}
