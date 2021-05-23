package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.Controller.PresentationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 *
 * Esta clase se encarga principalmente de mostrar el contenido generado en el apartado de las playlist
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
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

    /**
     * Constructor de la clase donde se definen los paneles y elementos que contiene la clase
     */
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

    }//Cierre del constructor

    /**
     * Método que actualiza la plyalist con la cancón indicada.
     * @param hasPlayLists Parámetro que indica la playlist que selecciono.
     * @param songs Parámetro que indica la canción que selecciono.
     */
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
        if(jcTriarPlaylist.getItemCount()>0) {
            jcTriarPlaylist.setSelectedIndex(0);
        }
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
    }//Cierre del método

    /**
     * Método que actualiza la plyalist con la cancón indicada.
     * @param hasPlayLists Parámetro que indica la playlist que selecciono.
     * @param songs Parámetro que indica la canción que selecciono.
     */
    public void updateJPPlaylistSettings(ArrayList<PlayList> hasPlayLists, ArrayList<Song> songs){

                System.out.println("Funciona?");
                jpPlaylistSettings.get(jcTriarPlaylist.getSelectedIndex()).updateJPPlaylistSettings(songs,hasPlayLists.get(jcTriarPlaylist.getSelectedIndex()));

    }//Cierre del método

    /**
     * Método que actualiza cuando hay una nueva canción.
     * @param song Parámetro que indica la canción que selecciono.
     * @param controller Parámetro que controla el ActionListener de los botones
     */
    public void updateWhenAddSong(Song song,ActionListener controller){

        jpPlaylistSettings.get(jcTriarPlaylist.getSelectedIndex()).updateWhenAddSong(song,controller);

    }//Cierre del método

    /**
     * Método que actualiza cuando hay una se borra una canción.
     * @param song Parámetro que indica la canción que selecciono.
     */
    public void updateWhenRemoveSong(Song song,String type){
        switch (type) {
            case PresentationController.ELIMINAR_FROM_PLAYLISTS:
                jpPlaylistSettings.get(jcTriarPlaylist.getSelectedIndex()).updateWhenRemoveSong(song);
                break;
            case PresentationController.ELIMINAR_FROM_SONGS_WHILE_IN_PLAYLISTS:

                for(int i = 0; i<jpPlaylistSettings.size();i++){ jpPlaylistSettings.get(i).updateWhenRemoveSong(song); }
                break;
        }
    }//Cierre del método

    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param controller Parámetro ascoiado al ActionListener
     * @param itemListener Parámetro asociado al ItemListener
     */
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

    }//Cierre del método

    /**
     * Método que actualiza el Register Controller en la clase.
     * @param controller Parámetro ascoiado al ActionListener.
     */
    public void updateRegisterControllerForPlaylistSetting(ActionListener controller){

        if(jpPlaylistSettings!=null){

            for(int i=0;i<jpPlaylistSettings.size();i++){
                jpPlaylistSettings.get(i).registerController(controller);
            }

        }

    }//Cierre del método

    /**
     * Método que actualiza el Register Controller cuando se añade una nueva canción.
     * @param controller Parámetro ascoiado al ActionListener.
     * @param playlist Parámetro sobre la playlist.
     * @param songs Parámetro que indica la canción que selecciono.
     */
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

    }//Cierre del método

    /**
     * Método que actualiza el Register Controller cuando se elimina la playlist
     */
    public void updateRegisterControllerWhenDeletePlaylist(){

        jpCardPanel.remove(jcTriarPlaylist.getSelectedIndex());
        jpPlaylistSettings.remove(jcTriarPlaylist.getSelectedIndex());
        jcTriarPlaylist.removeItemAt(jcTriarPlaylist.getSelectedIndex());

        repaint();

    }//Cierre del método

    /**
     * Método que añade la canción a la Playlist.
     * @param song Parámetro que indica la canción que selecciono.
     */
    public void addSongInJCBadder(Song song){
        for(int i = 0;i<jcTriarPlaylist.getItemCount();i++) {
            jpPlaylistSettings.get(i).addSongInJCBadder(song);
            repaint();
        }
    }//Cierre del método

    /**
     * Método para runear la playlist
     */
    public void jdPlaylistCreatorRun()  {  jdPlaylistCreator.run();  }//Cierre del método

    /**
     * Método para parar la playlist
     */
    public void jdPlaylistCreatorClose(){  jdPlaylistCreator.close();}//Cierre del método

    /**
     * Método que devuelve la canción como string
     * @return la canción como string.
     */
    public String getJCSongAdderString(){return jpPlaylistSettings.get(jcTriarPlaylist.getSelectedIndex()).getJCSongAdderString();}//Cierre del método

    /**
     * Método que devuelve la canión en string que se quiere eliminar.
     * @return la canión en string que se quiere eliminar.
     */
    public String getJCSongRemoveString(){return jpPlaylistSettings.get(jcTriarPlaylist.getSelectedIndex()).getJCSongRemoveString();}

    /**
     * Método que te permite triar la playlist visualizando el String.
     * @return la playlist visualizanda como String.
     */
    public String getJCTriarPlaylistString(){return (String)jcTriarPlaylist.getSelectedItem();}//Cierro del método

    /**
     * Método para obtener el titulo de la playlist introducido.
     * @return El titulo de la playlist introducido.
     */
    public String jdPlaylistGetTextFieldString(){return jdPlaylistCreator.getTextFieldString();}//Cierre del método

    /**
     * Método que permite cambiar la vista.
     * @param newView Parámetro que indica la nueva vista.
     */
    public void changeViewTo(String newView){

        StringBuilder sb = new StringBuilder();
        sb.append(JP_PLAYLIST_SETTINGS_STRING);
        sb.append(newView);
        System.out.println(sb.toString());
        cards.show(jpCardPanel,sb.toString());

    }//Cierre del método

}//Cierre de la clase
