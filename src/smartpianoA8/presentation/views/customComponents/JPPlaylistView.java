package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPPlaylistView extends JPMainView {

    public static final String JP_PLAYLIST_SETTINGS_STRING = "PlaylistSettings_";
    
    private CardLayout cards;
    private JPanel jpCardPanel;
    private JPPlaylistSettings[] jpPlaylistSettings;
    private JComboBox jcTriarPlaylist;

    private ArrayList<PlayList> hasPlayLists;

    public JPPlaylistView(ArrayList<PlayList> hasPlayLists, ArrayList<Song> songs) {

        this.hasPlayLists = hasPlayLists;

        setBackground(new Color(12, 14, 22));
        setLayout(new BorderLayout());

        /*----------------------------------------Part Nord----------------------------------------*/

        JPanel panellNord = new JPMainView();
        panellNord.setLayout(new FlowLayout(FlowLayout.LEADING));

        String[] stringBox = new String[hasPlayLists.size()];

        for(int i = 0;i<hasPlayLists.size();i++){

            stringBox[i] = (hasPlayLists.get(i).getNom());

        }

        jcTriarPlaylist = new JComboBox(stringBox);
        jcTriarPlaylist.setSelectedIndex(0);
        panellNord.add(jcTriarPlaylist);

        /*----------------------------------------Part centre(CardPanel)----------------------------------------*/
        cards = new CardLayout();
        jpCardPanel = new JPanel(cards);
        
        jpPlaylistSettings = new JPPlaylistSettings[hasPlayLists.size()];
        
        for(int i = 0; i<hasPlayLists.size();i++){
            
            StringBuilder jpPlaylistSettingsStringName = new StringBuilder();
            jpPlaylistSettingsStringName.append(JP_PLAYLIST_SETTINGS_STRING);
            jpPlaylistSettingsStringName.append(i);
            jpPlaylistSettings[i] = new JPPlaylistSettings(songs,hasPlayLists.get(i));
            jpCardPanel.add(jpPlaylistSettings[i],jpPlaylistSettingsStringName.toString());
            
        }

        add(panellNord,BorderLayout.NORTH);
        add(jpCardPanel,BorderLayout.CENTER);

    }

    public void registerControllers(ActionListener controller) {
        for(int i = 0; i<hasPlayLists.size();i++) {
            jpPlaylistSettings[i].registerController(controller);
        }
    }

    public String getJCSongAdderString(){return jpPlaylistSettings[jcTriarPlaylist.getSelectedIndex()].getJCSongAdderString();}
    public String getJCSongRemoveString(){return jpPlaylistSettings[jcTriarPlaylist.getSelectedIndex()].getJCSongRemoveString();}
    public String getJCTriarPlaylistString(){return (String)jcTriarPlaylist.getSelectedItem();}


}
