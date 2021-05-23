package smartpianoA8.presentation.views.customComponents.playlist;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.ColorScheme;
import smartpianoA8.presentation.views.customComponents.JBgeneral;
import smartpianoA8.presentation.views.customComponents.JLColor;
import smartpianoA8.presentation.views.customComponents.JPMainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPPlailistEditor extends JPMainView {

    private JComboBox<String> jComboBox;

    private JLColor jLabel;
    private JButton jButton;

    /**
     * Constructor que inicializa el panel para añadir/eliminar canciones de una playlists
     * @param info
     * @param buttonString
     * @param actionCommand
     * @param jComboBox
     */
    public JPPlailistEditor(String info,String buttonString,String actionCommand,JComboBox<String> jComboBox){
        setLayout(new FlowLayout());

        this.jComboBox = jComboBox;

        this.jLabel = new JLColor(info, Color.WHITE);

        this.jButton = new JBgeneral(buttonString, ColorScheme.DARK_GREEN);
        this.jButton.setActionCommand(actionCommand);
        add(jLabel);
        add(jComboBox);
        add(jButton);

    }

    /**
     * Método para inicializar/actualizar las conciones que se pueden añadir/eliminar del parametro Playlist.
     * @param songs
     * @param playList
     * @param type
     */
    public void updateJPPlailistEditor(ArrayList<Song> songs, PlayList playList,String type){

        setLayout(new FlowLayout());

        ArrayList<Song> songsPlaylistHas = playList.getSongs();
        jComboBox.removeAllItems();
        switch (type) {
            case JPPlaylistSettings.ADD:
                if (songsPlaylistHas == null) {
                    for (int i = 0; i < songs.size(); i++) {
                        jComboBox.addItem(songs.get(i).getNom());
                    }
                } else {
                    for (int i = 0; i < songs.size(); i++) {
                        if (!songsPlaylistHas.contains(songs.get(i))) {
                            jComboBox.addItem(songs.get(i).getNom());
                        }
                    }

                }
                jComboBox.setSelectedIndex(0);
                break;
            case JPPlaylistSettings.REMOVE:
                if (songsPlaylistHas != null) {
                    for(int i = 0;i<songsPlaylistHas.size();i++){

                        jComboBox.addItem(songsPlaylistHas.get(i).getNom());

                    }
                }

        }

    }

    /**
     * Método para acutalizar la combobox del panel dada una canción cuando fue añadida
     * @param song
     * @param type
     */
    public void updateWhenAdd(Song song, String type){
        switch (type){
            case JPPlaylistSettings.ADD:
                jComboBox.removeItem(song.getNom());
                break;
            case JPPlaylistSettings.REMOVE:
                jComboBox.addItem(song.getNom());
                break;
        }
    }
    /**
     * Método para acutalizar la combobox del panel dada una canción cuando fue eliminada
     * @param song
     * @param type
     */
    public void updateWhenRemove(Song song, String type){
        switch (type){
            case JPPlaylistSettings.ADD:
                jComboBox.addItem(song.getNom());
                break;
            case JPPlaylistSettings.REMOVE:
                jComboBox.removeItem(song.getNom());
                break;
        }
    }

    /**
     * Médoto para añadir una canción a la comboBox
     * @param song
     */
    public void addSongInJCBadder(Song song){
        jComboBox.addItem(song.getNom());
    }

    /**
     * Método para registrar los ActionListeners
     * @param controller
     */
    public void registerController(ActionListener controller){
        this.jComboBox.addActionListener(controller);
        this.jButton.addActionListener(controller);
    }

    /**
     * Getter para obtener el item seleccionado en la comboBox
     * @return
     */
    public String getJCSongString(){return (String)jComboBox.getSelectedItem();}
}
