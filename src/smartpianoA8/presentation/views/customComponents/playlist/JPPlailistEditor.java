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

    public void addSongInJCBadder(Song song){
        jComboBox.addItem(song.getNom());
    }

    public void registerController(ActionListener controller){
        this.jComboBox.addActionListener(controller);
        this.jButton.addActionListener(controller);
    }
    public String getJCSongString(){return (String)jComboBox.getSelectedItem();}
}
