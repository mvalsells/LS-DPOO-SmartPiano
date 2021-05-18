package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPPlaylistSettings extends JPMainView {

    private JComboBox<String> jcSongAdder;
    private JComboBox<String> jcSongRemover;

    private JButton jbAdder;
    private JButton jbRemover;

    public static final String ADD = "add";
    public static final String REMOVE = "remove";

    public JPPlaylistSettings( ArrayList<Song> songs, PlayList playList){

        /*GroupLayout groupLayout = new GroupLayout(this);*/
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        JPanel jpAdd  = new JPMainView();
        jpAdd.setLayout(new FlowLayout());
        JPanel jpRemove  = new JPMainView();
        jpRemove.setLayout(new FlowLayout());

        JLabel jlAdd = new JLColor("Cancion a añadir: ", Color.WHITE);
        JLabel jlRemove = new JLColor("Cancion a eliminar: ", Color.WHITE);

        jcSongAdder= new JComboBox<String>();
        jcSongRemover= new JComboBox<String>();

        ArrayList<Song> songsPlaylistHas = playList.getSongs();

        if(songsPlaylistHas == null){

            for(int i = 0;i<songs.size();i++) {
                jcSongAdder.addItem(songs.get(i).getNom());
            }
        }else {
            for (int i = 0; i < songs.size(); i++) {
                if (!songsPlaylistHas.contains(songs.get(i))) {
                    jcSongAdder.addItem(songsPlaylistHas.get(i).getNom());
                }
            }
            for(int i = 0;i<songsPlaylistHas.size();i++){

                jcSongRemover.addItem(songsPlaylistHas.get(i).getNom());

            }
        }



        //Buttons
        jbAdder = new JBgeneral("Añadir",ColorScheme.DARK_GREEN);
        jbAdder.setActionCommand(ADD);
        jbRemover = new JBgeneral("Eliminar",ColorScheme.DARK_GREEN);
        jbRemover.setActionCommand(REMOVE);
        //Tira cançons
        JPTiraCancons jpTiraCancons = new JPTiraCancons(songsPlaylistHas,playList.getNom());

        jpAdd.add(jlAdd);
        jpAdd.add(jcSongAdder);
        jpAdd.add(jbAdder);
        jpRemove.add(jlRemove);
        jpRemove.add(jcSongRemover);
        jpRemove.add(jbRemover);

        add(jpTiraCancons);
        add(jpAdd);
        add(jpRemove);
        /*groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING))
                    .addComponent(jlAdd)
                    .addComponent(jlRemove)
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING))
                    .addComponent(jcSongAdder)
                    .addComponent(jcSongRemover)
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING))
                    .addComponent(jbAdder)
                    .addComponent(jbRemover)
        );*/

    }

    public void registerController(ActionListener controller){

        jcSongAdder.addActionListener(controller);
        jcSongRemover.addActionListener(controller);

        jbAdder.addActionListener(controller);
        jbRemover.addActionListener(controller);

    }

    public String getJCSongAdderString(){return (String)jcSongAdder.getSelectedItem();}
    public String getJCSongRemoveString(){return (String)jcSongRemover.getSelectedItem();}


}
