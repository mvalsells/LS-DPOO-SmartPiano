package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class JPPlaylistView extends JPMainView {

    public static final String JP_PLAYLIST_SETTINGS_STRING = "PlaylistSettings_";
    public static final String NEW_PLAYLIST = "newPlaylist";
    public static final String DELETE_PLAYLIST = "deletePlaylist";





    private CardLayout cards;
    private JPanel jpCardPanel;
    private JPPlaylistSettings[] jpPlaylistSettings;
    private JComboBox jcTriarPlaylist;
    private JDPlaylistCreator jdPlaylistCreator;

    private JButton jbNewPlaylist;
    private JButton jbDeletePlaylist;

    //private ArrayList<PlayList> hasPlayLists;

    public JPPlaylistView(/**/) {

        //this.hasPlayLists = hasPlayLists;

        jdPlaylistCreator = new JDPlaylistCreator();

        setBackground(new Color(12, 14, 22));
        setLayout(new BorderLayout());

        /*----------------------------------------Part Nord----------------------------------------*/

        JPanel panellNord = new JPMainView();
        panellNord.setLayout(new FlowLayout(FlowLayout.LEADING));

        jbNewPlaylist = new JBgeneral("Crear Playlist",ColorScheme.DARK_GREEN);
        jbNewPlaylist.setActionCommand(NEW_PLAYLIST);

        jbDeletePlaylist = new JBgeneral("Eliminar Playlist",ColorScheme.RED_DANGER);
        jbDeletePlaylist.setActionCommand(DELETE_PLAYLIST);

        jcTriarPlaylist = new JComboBox();
        panellNord.add(jcTriarPlaylist);
        panellNord.add(jbNewPlaylist);
        panellNord.add(jbDeletePlaylist);


        /*----------------------------------------Part centre(CardPanel)----------------------------------------*/
        cards = new CardLayout();
        jpCardPanel = new JPanel(cards);

        /*jpPlaylistSettings = new JPPlaylistSettings[];

        for(int i = 0; i<hasPlayLists.size();i++){

            StringBuilder jpPlaylistSettingsStringName = new StringBuilder();
            jpPlaylistSettingsStringName.append(JP_PLAYLIST_SETTINGS_STRING);
            jpPlaylistSettingsStringName.append(i);
            jpPlaylistSettings[i] = new JPPlaylistSettings();
            jpCardPanel.add(jpPlaylistSettings[i],jpPlaylistSettingsStringName.toString());

        }*/

        add(panellNord,BorderLayout.NORTH);
        add(jpCardPanel,BorderLayout.CENTER);

    }

    public void updateJPPlaylistView(ArrayList<PlayList> hasPlayLists, ArrayList<Song> songs){

        jcTriarPlaylist.removeAllItems();
        jpCardPanel.removeAll();



        for(int i = 0;i<hasPlayLists.size();i++){

            jcTriarPlaylist.addItem(hasPlayLists.get(i).getNom());

        }
        //jcTriarPlaylist.setSelectedIndex(0);

        jpPlaylistSettings = new JPPlaylistSettings[hasPlayLists.size()];

        for(int i = 0; i<hasPlayLists.size();i++){

            StringBuilder jpPlaylistSettingsStringName = new StringBuilder();
            jpPlaylistSettingsStringName.append(JP_PLAYLIST_SETTINGS_STRING);
            jpPlaylistSettingsStringName.append(hasPlayLists.get(i).getNom());
            System.out.println(jpPlaylistSettingsStringName);
            jpPlaylistSettings[i] = new JPPlaylistSettings();
            jpPlaylistSettings[i].updateJPPlaylistSettings(songs,hasPlayLists.get(i));
            jpCardPanel.add(jpPlaylistSettings[i],jpPlaylistSettingsStringName.toString());

        }
        repaint();
    }

    public void updateJPPlaylistSettings(ArrayList<PlayList> hasPlayLists, ArrayList<Song> songs){

                System.out.println("Funciona?");
                jpPlaylistSettings[jcTriarPlaylist.getSelectedIndex()].updateJPPlaylistSettings(songs,hasPlayLists.get(jcTriarPlaylist.getSelectedIndex()));

    }

    public void updateWhenAdd(Song song,ActionListener controller){

        jpPlaylistSettings[jcTriarPlaylist.getSelectedIndex()].updateWhenAdd(song,controller);

    }
    public void updateWhenRemove(Song song){

        jpPlaylistSettings[jcTriarPlaylist.getSelectedIndex()].updateWhenRemove(song);

    }



    public void registerControllers(ActionListener controller,ItemListener itemListener) {
        jcTriarPlaylist.addItemListener(itemListener);
        jbNewPlaylist.addActionListener(controller);
        jbDeletePlaylist.addActionListener(controller);
        jdPlaylistCreator.registerControllerJDPlaylist(controller);
        if(jpPlaylistSettings!=null){

            for(int i=0;i<jpPlaylistSettings.length;i++){
                jpPlaylistSettings[i].registerController(controller);
            }

        }

    }

    public void jdPlaylistCreatorRun()  {  jdPlaylistCreator.run();  }
    public void jdPlaylistCreatorClose(){  jdPlaylistCreator.close();}

    public String getJCSongAdderString(){return jpPlaylistSettings[jcTriarPlaylist.getSelectedIndex()].getJCSongAdderString();}
    public String getJCSongRemoveString(){return jpPlaylistSettings[jcTriarPlaylist.getSelectedIndex()].getJCSongRemoveString();}
    public String getJCTriarPlaylistString(){return (String)jcTriarPlaylist.getSelectedItem();}


    public void changeViewTo(String newView){

        StringBuilder sb = new StringBuilder();
        sb.append(JP_PLAYLIST_SETTINGS_STRING);
        sb.append(newView);
        System.out.println(sb.toString());
        cards.show(jpCardPanel,sb.toString());

    }

}
