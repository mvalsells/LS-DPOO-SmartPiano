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
    private ArrayList<JPPlaylistSettings> jpPlaylistSettings;
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
        /*jpCardPanel.removeAll();
        jbNewPlaylist.removeAll();
        jbDeletePlaylist.removeAll();
        jdPlaylistCreator.removeAll();

        jdPlaylistCreator = new JDPlaylistCreator();

        jbNewPlaylist = new JBgeneral("Crear Playlist",ColorScheme.DARK_GREEN);
        jbNewPlaylist.setActionCommand(NEW_PLAYLIST);

        jbDeletePlaylist = new JBgeneral("Eliminar Playlist",ColorScheme.RED_DANGER);
        jbDeletePlaylist.setActionCommand(DELETE_PLAYLIST);*/

        for(int i = 0;i<hasPlayLists.size();i++){

            jcTriarPlaylist.addItem(hasPlayLists.get(i).getNom());

        }
        //jcTriarPlaylist.setSelectedIndex(0);

        jpPlaylistSettings = new ArrayList<>();

        for(int i = 0; i<hasPlayLists.size();i++){

            StringBuilder jpPlaylistSettingsStringName = new StringBuilder();
            jpPlaylistSettingsStringName.append(JP_PLAYLIST_SETTINGS_STRING);
            jpPlaylistSettingsStringName.append(hasPlayLists.get(i).getNom());
            System.out.println(jpPlaylistSettingsStringName);
            jpPlaylistSettings.add(new JPPlaylistSettings());
            jpPlaylistSettings.get(i).updateJPPlaylistSettings(songs,hasPlayLists.get(i));
            jpCardPanel.add(jpPlaylistSettings.get(i),jpPlaylistSettingsStringName.toString());

        }
        repaint();
    }

    public void updateJPPlaylistSettings(ArrayList<PlayList> hasPlayLists, ArrayList<Song> songs){

                System.out.println("Funciona?");
                jpPlaylistSettings.get(jcTriarPlaylist.getSelectedIndex()).updateJPPlaylistSettings(songs,hasPlayLists.get(jcTriarPlaylist.getSelectedIndex()));

    }

    public void updateWhenAddSong(Song song,ActionListener controller){

        jpPlaylistSettings.get(jcTriarPlaylist.getSelectedIndex()).updateWhenAddSong(song,controller);

    }
    public void updateWhenRemoveSong(Song song){

        jpPlaylistSettings.get(jcTriarPlaylist.getSelectedIndex()).updateWhenRemoveSong(song);

    }



    public void registerControllers(ActionListener controller,ItemListener itemListener) {


        jcTriarPlaylist.addItemListener(itemListener);
        jbNewPlaylist.addActionListener(controller);
        jbDeletePlaylist.addActionListener(controller);
        jdPlaylistCreator.registerControllerJDPlaylist(controller);
        if(jpPlaylistSettings!=null){

            for(int i=0;i<jpPlaylistSettings.size()-1;i++){
                jpPlaylistSettings.get(i).registerController(controller);
            }

        }

    }

    public void updateRegisterControllerForPlaylistSetting(ActionListener controller){

        if(jpPlaylistSettings!=null){

            for(int i=0;i<jpPlaylistSettings.size()-1;i++){
                jpPlaylistSettings.get(i).registerController(controller);
            }

        }

    }


    public void updateRegisterControllerWhenNewPlaylist(ActionListener controller,PlayList playlist,ArrayList<Song> songs){

        StringBuilder jpPlaylistSettingsStringName = new StringBuilder();
        jpPlaylistSettingsStringName.append(JP_PLAYLIST_SETTINGS_STRING);
        jpPlaylistSettingsStringName.append(playlist.getNom());

        jcTriarPlaylist.addItem(playlist.getNom());
        jpPlaylistSettings.add(new JPPlaylistSettings());
        jpPlaylistSettings.get(jpPlaylistSettings.size()-1).updateJPPlaylistSettings(songs,playlist);
        jpPlaylistSettings.get(jpPlaylistSettings.size()-1).registerController(controller);
        jpCardPanel.add(jpPlaylistSettings.get(jpPlaylistSettings.size()-1),jpPlaylistSettingsStringName.toString());
        repaint();

    }
    public void updateRegisterControllerWhenDeletePlaylist(){

        jpCardPanel.remove(jcTriarPlaylist.getSelectedIndex());
        jpPlaylistSettings.remove(jcTriarPlaylist.getSelectedIndex());
        jcTriarPlaylist.removeItemAt(jcTriarPlaylist.getSelectedIndex());



    }

    public void jdPlaylistCreatorRun()  {  jdPlaylistCreator.run();  }
    public void jdPlaylistCreatorClose(){  jdPlaylistCreator.close();}

    public String getJCSongAdderString(){return jpPlaylistSettings.get(jcTriarPlaylist.getSelectedIndex()).getJCSongAdderString();}
    public String getJCSongRemoveString(){return jpPlaylistSettings.get(jcTriarPlaylist.getSelectedIndex()).getJCSongRemoveString();}
    public String getJCTriarPlaylistString(){return (String)jcTriarPlaylist.getSelectedItem();}
    public String jdPlaylistGetTextFieldString(){return jdPlaylistCreator.getTextFieldString();}

    public void changeViewTo(String newView){

        StringBuilder sb = new StringBuilder();
        sb.append(JP_PLAYLIST_SETTINGS_STRING);
        sb.append(newView);
        System.out.println(sb.toString());
        cards.show(jpCardPanel,sb.toString());

    }

}
