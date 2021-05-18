package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPPlaylistSettings extends JPMainView {

    private JComboBox<Song> jcSongAdder;
    private JComboBox<Song> jcSongRemover;

    private JButton jbAdder;
    private JButton jbRemover;

    public JPPlaylistSettings( ArrayList<Song> songs, PlayList playList){

        GroupLayout groupLayout = new GroupLayout(this);
        setLayout(groupLayout);

        JLabel jlAdd = new JLColor("Cancion a añadir: ", Color.WHITE);
        JLabel jlRemove = new JLColor("Cancion a eliminar: ", Color.WHITE);

        jcSongAdder= new JComboBox<Song>();
        jcSongRemover= new JComboBox<Song>();

        ArrayList<Song> songsPlaylistHas = playList.getSongs();

        for(int i = 0;i<songs.size();i++){
            if(!songsPlaylistHas.contains(songs.get(i))){
                jcSongAdder.addItem(songsPlaylistHas.get(i));
            }
        }

        for(int i = 0;i<songsPlaylistHas.size();i++){

            jcSongRemover.addItem(songsPlaylistHas.get(i));

        }

        //Buttons
        jbAdder = new JBgeneral("Añadir",ColorScheme.DARK_GREEN);
        jbRemover = new JBgeneral("Eliminar",ColorScheme.DARK_GREEN);

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING))
                    .addComponent(jlAdd)
                    .addComponent(jlRemove)
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING))
                    .addComponent(jcSongAdder)
                    .addComponent(jcSongRemover)
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING))
                    .addComponent(jbAdder)
                    .addComponent(jbRemover)
        );

    }

    public void registerController(ActionListener controller){

        jcSongAdder.addActionListener(controller);
        jcSongRemover.addActionListener(controller);

        jbAdder.addActionListener(controller);
        jbRemover.addActionListener(controller);

    }

}
