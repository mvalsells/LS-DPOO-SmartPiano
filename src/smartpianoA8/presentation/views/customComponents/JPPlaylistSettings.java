package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPPlaylistSettings extends JPMainView {

    //Buttons amb action listeners

    private JPTiraCancons jpTiraCancons;

    //Vista
    private JPPlailistEditor jpAdd;
    private JPPlailistEditor jpRemove;

    public static final String ADD = "add";
    public static final String REMOVE = "remove";

    public JPPlaylistSettings( ){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        /*GroupLayout groupLayout = new GroupLayout(this);*/

        JComboBox<String> jComboBoxADD = new JComboBox<>();
        JComboBox<String> jComboBoxRemove = new JComboBox<>();


        jpTiraCancons = new JPTiraCancons();
        jpAdd = new JPPlailistEditor("Cancion a añadir: ","Añadir",ADD,jComboBoxADD);
        jpRemove = new JPPlailistEditor("Cancion a eliminar: ","Eliminar",REMOVE,jComboBoxRemove);

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



        jpAdd.registerController(controller);
        jpRemove.registerController(controller);
        //System.out.println("action: "+jbAdder.getActionCommand());

    }

    public void updateJPPlaylistSettings(ArrayList<Song> songs, PlayList playList){

        jpTiraCancons.updateTira(playList.getSongs(),playList.getNom());

        jpAdd.updateJPPlailistEditor(songs,playList,ADD);
        jpRemove.updateJPPlailistEditor(songs, playList,REMOVE);
        repaint();

    }

    public String getJCSongAdderString(){return (String)jpAdd.getJCSongString();}
    public String getJCSongRemoveString(){return (String)jpRemove.getJCSongString();}


}
