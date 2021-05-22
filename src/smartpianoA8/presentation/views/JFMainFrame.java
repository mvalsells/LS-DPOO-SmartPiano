package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * Esta clase se encarga principalmente de mostrar el frame donde se encuentran los paneles asociados al main,
 * además también podemos encotnrar los register controllers al igual que sus respectivas acciones.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JFMainFrame extends JFrame {
    // ---- Inici Atributs ----

    //Public constants
    public static final String PIANO = "piano";
    public static final String PROFILE = "profile";
    public static final String SONGS = "songs";
    public static final String PLAYLISTS = "playlists";
    public static final String PIANO_CASCADE = "piano_cascade";

    //Private
    private JPSongs jpSongs;
    //private JPFavView jpFavView; //Substituida per JPPlaylistView
    private JPPlaylistView jpPlaylistView;
    private JPPianoView jpPianoView;
    private JPProfileView jpProfileView;
    private JPPianoCascadeView jpPianoCascadeView;
    private JPNavBar jpNavBar;
    private JPPlayer jpPlayer;

    private CardLayout cards;
    private JPanel jpCardPanel;

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----

    /**
     * Constructor de la clase JFMainFrame
     * @param masterSongs Parámetro donde se encuentran las masterSongs en el arraylist.
     * @param currentUser Parámetro que indica el nombre del usuario.
     * @param hasPlayLists Parámetro donde se encuentran las hasPlayList en el arraylist.
     */
    public JFMainFrame(ArrayList<Song> masterSongs, User currentUser,ArrayList<PlayList> hasPlayLists){
        //Frame
        setTitle("SmartPiano");
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1085,680));
        setLayout(new BorderLayout());
        //setLocationRelativeTo(null);

        //Panels (Navigation Bar options)
        jpSongs = new JPSongs(masterSongs);
        //jpFavView = new JPFavView(); //Substituida per JPPlaylistView
        jpPlaylistView = new JPPlaylistView();
        jpPianoView = new JPPianoView();
        jpProfileView = new JPProfileView(currentUser);
        jpPianoCascadeView = new JPPianoCascadeView();
        jpPlayer = new JPPlayer();
        jpNavBar = new JPNavBar();


        cards = new CardLayout();
        jpCardPanel = new JPanel(cards);
        jpCardPanel.add(jpSongs, SONGS);
        jpCardPanel.add(jpPlaylistView, PLAYLISTS);
        jpCardPanel.add(jpPianoView, PIANO);
        jpCardPanel.add(jpProfileView, PROFILE);
        jpCardPanel.add(jpPianoCascadeView,PIANO_CASCADE);

        JPanel jpCenter = new JPMainView();
        jpCenter.setLayout(new BorderLayout());
        jpCenter.add(jpCardPanel, BorderLayout.CENTER);
        jpCenter.add(jpPlayer,BorderLayout.SOUTH);
        getContentPane().add(jpCenter, BorderLayout.CENTER);
        getContentPane().add(jpNavBar,BorderLayout.WEST);
        pack();
        setVisible(true);
    }//Cierre del constructor

    // ---- Inici Mètodes ----

    //Controllers Registration

    /**
     * Método que sirve para controlar los action listeners en el main frame.
     * @param actionListener Controlador asocioado a los actionListener.
     */
    public void registerMainFrameController(ActionListener actionListener){
        jpNavBar.registerController(actionListener);
        jpPlayer.registerController(actionListener);
    }//Cierre del método

    /**
     * Método que sirve para controlar los action listeners en el songs view.
     * @param actionListener Controlador asocioado a los actionListener.
     */
    public void registerSongViewControllers(ActionListener actionListener){
        jpSongs.registerController(actionListener);
    }//Cierre del método

    /**
     * Método para controlar los controlers de la clase PlayList
     * @param actionListener Controlador asocioado a los actionListener.
     * @param itemListener Controlador asocioado a los itemListener.
     */
    public void registerPlaylistViewControllers(ActionListener actionListener, ItemListener itemListener){
       jpPlaylistView.registerControllers(actionListener,itemListener);
    }//Cierre del método

    /**
     * Método con el que se controla todos los listeners generados en esta clase ProfileView.
     * @param actionListener controlador asocioado a los botones.
     * @param keyListener controlador asociado a las teclas del ordenador.
     * @param mouseListener controlador asociado al ratón.
     */
    public void registerProfileViewControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        jpProfileView.registerControllers(actionListener, mouseListener, keyListener);
    }//Cierre del método

    /**
     * Método con el que se controla todos los listeners generados en la clase PianoView.
     * @param actionListener controlador asocioado a los botones.
     * @param keyListener controlador asociado a las teclas del ordenador.
     * @param mouseListener controlador asociado al ratón.
     */
    public void registerPianoViewControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        jpPianoView.registerControllers(actionListener, mouseListener, keyListener);
    }//Cierre del método

    /**
     * Método con el que se controla todos los listeners generados en la clase PianoCascadeView.
     * @param actionListener controlador asocioado a los botones.
     * @param keyListener controlador asociado a las teclas del ordenador.
     * @param mouseListener controlador asociado al ratón.
     */
    public void registerPianoCascadeViewControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        jpPianoCascadeView.registerControllers(actionListener, mouseListener, keyListener);
    }//Cierre del método

    //Views managment

    /**
     * Método para poder cambiar mediante cards, de view.
     * @param newView Parámetro que indica la nueva vista a la que queremos cambiar.
     */
    public void changeViewTo(String newView){
        jpNavBar.changeActiveElement(newView);
        switch (newView){
            case SONGS:
                cards.show(jpCardPanel,SONGS);
                break;
            case PLAYLISTS:
                cards.show(jpCardPanel,PLAYLISTS);
                break;
            case PIANO:
                cards.show(jpCardPanel,PIANO);
                break;
            case PROFILE:
                cards.show(jpCardPanel,PROFILE);
                break;
            case PIANO_CASCADE:
                cards.show(jpCardPanel,PIANO_CASCADE);
                break;
        }
    }//Cierre del método


    // ---- Start SongView Methods
    //public int jpSongSetLastIDPressed(){jpSongsView.jpSongSetLastIDPressed();}

    /**
     * Método que inica la nueva canción
     */
    public void nuevaCanciones() {
        jpSongs.nuevasCanciones();
    }//Cierre del método
    // ---- End SongView Methods
    // ---- Start PlaylistView Methods

    /**
     * Método que indica la vista de la playlist
     * @param hasPlayLists Parámetro que indica el array de Playlist.
     * @param songs Parámetro que indica el array de songs.
     */
    public void playlistViewUpdateJPPlaylistView(ArrayList<PlayList> hasPlayLists, ArrayList<Song> songs){jpPlaylistView.updateJPPlaylistView(hasPlayLists,songs);}//Cierre del método

    /**
     * Método que indica los ajustes de la playlist
     * @param hasPlayLists Parámetro que indica el array de Playlist.
     * @param songs Parámetro que indica el array de songs.
     */
    public void playlistViewUpdateJPPlaylistSettings(ArrayList<PlayList> hasPlayLists, ArrayList<Song> songs){ jpPlaylistView.updateJPPlaylistSettings(hasPlayLists,songs);}//Cierre del método

    /**
     * Método que actualiza el playlist cuando se le añade una canción.
     * @param song Parámetro que indica el tipos song
     * @param controller Controlador asocioado al action listener.
     */
    public void playlistViewUpdateWhenAdd(Song song,ActionListener controller){jpPlaylistView.updateWhenAdd(song,controller);}//Cierre del método

    /**
     * Método que actualiza el playlist cuando se le elimina una canción.
     * @param song Parámetro que indica el tipos song.
     */
    public void playlistViewUpdateWhenRemove(Song song){jpPlaylistView.updateWhenRemove(song);}//Cierre del método

    /**
     * Método que te cambia la vista a la nueva.
     * @param newView Cambia la vista a la nueva.
     */
    public void playlistViewChangeViewTo(String newView){jpPlaylistView.changeViewTo(newView);}//Cierre del método

    /**
     * Método que se activa cuando empieza a run.
     */
    public void playlistJDPlaylistCreatorRun()  {  jpPlaylistView.jdPlaylistCreatorRun();  }//Cierre del método

    /**
     * Método que se activa cuando es close.
     */
    public void playlistJDPlaylistCreatorClose(){  jpPlaylistView.jdPlaylistCreatorClose();}//Cierre del método

    /**
     * Método que añade en el string a la canción
     * @return String a la canción.
     */
    public String playlistViewGetJCSongAdderString(){return jpPlaylistView.getJCSongAdderString();}//Cierre del método

    /**
     * Método que quita en el string a la canción
     * @return String a la canción.
     */
    public String playlistViewGetJCSongRemoveString(){return jpPlaylistView.getJCSongRemoveString();}//Cierre del método

    /**
     * Método que permite triar la canción.
     * @return La cancion triada.
     */
    public String playlistViewGetJCTriarPlaylistString(){return jpPlaylistView.getJCTriarPlaylistString();}//Cierre del método
    // ---- End PlaylistView Methods
    // ---- Start PianoView Methods

    /**
     * Método que se encarga del controlar el recording
     * @param button Controlador del botón.
     */
    public void pianoViewSetRecordingPressedIcon(JButton button){ jpPianoView.setRecordingPressedIcon(button); }//Cierre del método

    /**
     * Método que se encarga del controlar el recording
     * @param button Controlador del botón.
     */
    public void pianoViewSetRecordingUnpressedIcon(JButton button){
        jpPianoView.setRecordingUnpressedIcon(button);
    }//Cierre del método

    /**
     * Método que activa el PianoView
     */
    public void pianoViewJDRun(){jpPianoView.jdRun();}//Cierre del método

    /**
     * Método que para el PianoView
     */
    public void pianoViewJDClose(){jpPianoView.jdClose();}//Cierre del método

    /**
     * Método que retorna el TextField en String.
     * @return Retorna el TextField en String.
     */
    public String pianoViewJDGetTextFieldString(){return jpPianoView.getTextFieldString();}//Cierre del método

    /**
     * Método que se encarga de controlar que selecionas la CheckBox.
     * @return Retorna si el CheckBox esta bien.
     */
    public boolean pianoViewJDIsCheckBoxSelected(){return jpPianoView.isCheckBoxSelected();}//Cierre del método
    // ---- End PianoView Methods
    // ---- Start PianoCascadeView Methods
    // ---- End PianoCascadeView Methods
    // ---- Start ProfileView Methods

    /**
     * Método que retorna la información del perfil.
     * @return Retorna la información del perfil.
     */
    public ArrayList<String> profileViewGetData() {
        return jpProfileView.profileViewGetData();
    }//Cierre del método

    /**
     * Método en el que se actualiza el texto.
     * @param username Parámetro donde hay el nombre de usuario.
     * @param email Parámetro donde hay el correo.
     */
    public void profileViewUpdateText(String username, String email){
        jpProfileView.updateText(username, email);
    }//Cierre del método

    /**
     * Método en el que aparece el showDialog
     * @param primary Parámetro del texto primario.
     * @param secondary Parámetro del texto
     */
    public void profileViewShowDialog(String primary, String secondary){
        jpProfileView.showDialog(primary,secondary);
    }//Cierre del método

    /**
     * Método en el que se cierra el showDialog
     */
    public void profileViewCloseDialog(){
        jpProfileView.closeDialog();
    }//Cierre del método
    // ---- End ProfileView Methods

    /**
     * Método del ComboBox
     * @return Retorna el comboBox.
     */
    public String getJComboBoxString() {
        return jpPlayer.getJComboBoxStringSelected();
    }//Cierre del método

    /**
     * Método que retorna la playerview.
     * @return Retorna la playerview.
     */
    public JPPlayer getPlayerView() {
        return jpPlayer;
    }//Cierre del método

    /**
     * Método para mostrar la lista de nombres
     * @param playlistsNames Parámetro en el que estan los nombres en el arraylist
     */
    public void setPlaylistsNames(ArrayList<String> playlistsNames) {

        jpPlayer.setPlaylistsNames(playlistsNames);

        //jpPlayer.removeAll();
        jpPlayer.validate();
        jpPlayer.repaint();
    }//Cierre del método

}//Cierre de la clase
