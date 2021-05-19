package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPPlailistEditor extends JPMainView{

    private JComboBox<String> jComboBox;

    private JLColor jLabel;
    private JButton jButton;

    public JPPlailistEditor(String info,String buttonString,String actionCommand,JComboBox<String> jComboBox){
        setLayout(new FlowLayout());

        this.jComboBox = jComboBox;

        this.jLabel = new JLColor(info, Color.WHITE);

        this.jButton = new JBgeneral(buttonString,ColorScheme.DARK_GREEN);
        this.jButton.setActionCommand(actionCommand);
        add(jLabel);
        add(jButton);
        add(jComboBox);

    }

    public void updateJPPlailistEditor(ArrayList<Song> songs, PlayList playList,String type){

        setLayout(new FlowLayout());

        ArrayList<Song> songsPlaylistHas = playList.getSongs();
        jComboBox.removeAllItems();
        switch (type) {
            case JPPlaylistSettings.ADD:
                if (songsPlaylistHas == null) {
                    System.out.println("COM entri aqui mecaguntoto");
                    for (int i = 0; i < songs.size(); i++) {
                        jComboBox.addItem(songs.get(i).getNom());
                    }
                    jComboBox.setSelectedIndex(0);
                } else {
                    for (int i = 0; i < songs.size(); i++) {
                        if (!songsPlaylistHas.contains(songs.get(i))) {
                            jComboBox.addItem(songsPlaylistHas.get(i).getNom());
                        }
                    }

                    jComboBox.setSelectedIndex(0);
                }
                break;
            case JPPlaylistSettings.REMOVE:
                if (songsPlaylistHas == null) {

                } else {
                    for(int i = 0;i<songsPlaylistHas.size();i++){

                        jComboBox.addItem(songsPlaylistHas.get(i).getNom());

                    }
                    jComboBox.setSelectedIndex(0);
                }

        }

    }
    public void registerController(ActionListener controller){
        this.jComboBox.addActionListener(controller);
        this.jButton.addActionListener(controller);
    }
    public String getJCSongString(){return (String)jComboBox.getSelectedItem();}
}
