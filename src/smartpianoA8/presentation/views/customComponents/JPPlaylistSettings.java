package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * Esta clase se encarga principalmente controlar todoas las acciones que puede hacerse en la playlist como lo son la de
 * añadir una canción o eliminarla.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JPPlaylistSettings extends JPMainView {

    //Buttons amb action listeners

    private JPTiraCancons jpTiraCancons;

    //Vista
    private JPPlailistEditor jpAdd;
    private JPPlailistEditor jpRemove;

    public static final String ADD = "add";
    public static final String REMOVE = "remove";

    /**
     * Constructor de la clase JPPlaylistSettings
     */
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

    }//Cierre del constructor

    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param controller Parámetro ascoiado al ActionListener
     */
    public void registerController(ActionListener controller){

        jpTiraCancons.registerController(controller);


        jpAdd.registerController(controller);
        jpRemove.registerController(controller);
        //System.out.println("action: "+jbAdder.getActionCommand());

    }

    /**
     * Método que actualiza la plyalist con la cancón indicada.
     * @param playList Parámetro que indica la playlist que selecciono.
     * @param songs Parámetro que indica la canción que selecciono.
     */
    public void updateJPPlaylistSettings(ArrayList<Song> songs, PlayList playList){

        jpTiraCancons.updateTira(playList.getSongs(),playList.getNom());

        jpAdd.updateJPPlailistEditor(songs,playList,ADD);
        jpRemove.updateJPPlailistEditor(songs, playList,REMOVE);
        repaint();

    }//Cierre del método

    /**
     * Método que actualiza cuando hay una nueva canción.
     * @param song Parámetro que indica la canción que selecciono.
     * @param controller Parámetro que controla el ActionListener de los botones
     */
    public void updateWhenAddSong(Song song,ActionListener controller){

        jpTiraCancons.updateWhenAdd(song);
        jpTiraCancons.registerControllerLastButton(controller);
        jpAdd.updateWhenAdd(song,ADD);
        jpRemove.updateWhenAdd(song,REMOVE);

    }//Cierre del método

    /**
     * Método que actualiza cuando hay una se borra una canción.
     * @param song Parámetro que indica la canción que selecciono.
     */
    public void updateWhenRemoveSong(Song song){

        jpTiraCancons.updateWhenRemove(song);
        jpAdd.updateWhenRemove(song,ADD);
        jpRemove.updateWhenRemove(song,REMOVE);

    }//Cierre del método

    /**
     * Método que añade la canción a la Playlist.
     * @param song Parámetro que indica la canción que selecciono.
     */
    public void addSongInJCBadder(Song song){
        jpAdd.addSongInJCBadder(song);
    }//Cierre del método

    /**
     * Método que devuelve la canción como string
     * @return la canción como string.
     */
    public String getJCSongAdderString(){return (String)jpAdd.getJCSongString();}//Cierre del método

    /**
     * Método que devuelve la canión en string que se quiere eliminar.
     * @return la canión en string que se quiere eliminar.
     */
    public String getJCSongRemoveString(){return (String)jpRemove.getJCSongString();}//Cierre del método


}//Cierre de la clase
