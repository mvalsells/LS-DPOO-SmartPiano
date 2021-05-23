package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.PlayList;
import smartpianoA8.business.entity.Song;
import smartpianoA8.business.entity.User;
import smartpianoA8.presentation.Controller.PresentationController;
import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * Esta clase se encarga principalmente de mostrar el frame donde se encuentran los paneles asociados a la parte del main
 * al igual que todas sus respectivas funciones para poder controlar el frame
 *
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @version 1.0
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
    //private JPPianoCascadeView jpPianoCascadeView;
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
        setPreferredSize(new Dimension(1085,760));
        setLayout(new BorderLayout());
        //setLocationRelativeTo(null);

        //Panels (Navigation Bar options)
        jpSongs = new JPSongs(masterSongs);
        //jpFavView = new JPFavView(); //Substituida per JPPlaylistView
        jpPlaylistView = new JPPlaylistView();
        jpPianoView = new JPPianoView();
        jpProfileView = new JPProfileView(currentUser);
        //jpPianoCascadeView = new JPPianoCascadeView();
        jpPlayer = new JPPlayer();
        jpNavBar = new JPNavBar();


        cards = new CardLayout();
        jpCardPanel = new JPanel(cards);
        jpCardPanel.add(jpSongs, SONGS);
        jpCardPanel.add(jpPlaylistView, PLAYLISTS);
        jpCardPanel.add(jpPianoView, PIANO);
        jpCardPanel.add(jpProfileView, PROFILE);
        //jpCardPanel.add(jpPianoCascadeView,PIANO_CASCADE);

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
     * Método para controlar los controles relacionados con la playlistView
     * @param controller Controlador asociado a los botones
     */
    public void playlistViewUpdateRegisterControllerForPlaylistSetting(ActionListener controller){
        jpPlaylistView.updateRegisterControllerForPlaylistSetting(controller);
    }//Cierre del método


    /**
     * Método con el que se controla todos los listeners generados en la clase PianoCascadeView.
     * @param actionListener controlador asocioado a los botones.
     * @param keyListener controlador asociado a las teclas del ordenador.
     * @param mouseListener controlador asociado al ratón.
     */
    public void registerProfileViewControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        jpProfileView.registerControllers(actionListener, mouseListener,keyListener);
    }//Cierre del método

    /**
     * Método con el que se controla todos los listeners generados en la clase PianoCascadeView.
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
    //public void registerPianoCascadeViewControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
     //   jpPianoCascadeView.registerControllers(actionListener, mouseListener, keyListener);
    //}//Cierre del método

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
            /*case PIANO_CASCADE:
                cards.show(jpCardPanel,PIANO_CASCADE);
                break;*/
        }
    }//Cierre del método


    // ---- Start SongView Methods
    //public int jpSongSetLastIDPressed(){jpSongsView.jpSongSetLastIDPressed();}

    /**
     * Método que inica la nueva canción
     */
    public void nuevaCanciones(Song song,String type,ActionListener controller) {
        switch (type) {
            case "SONGS":
                jpSongs.nuevasCanciones(song,controller);
                break;
            case "PLAYLISTS":
                jpPlaylistView.addSongInJCBadder(song);
                break;
        }
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
     * Método que se usa para el update de la playlist.
     * @param song Parámetro song que es de tipo song.
     * @param controller  controlador asocioado a los botones.
     */
    public void playlistViewUpdateWhenAddSong(Song song,ActionListener controller){jpPlaylistView.updateWhenAddSong(song,controller);}//Cierre del método

    /**
     * Método que se usa para el update de la playlist.
     * @param song Parámetro song que es de tipo song.
     */
    public void UpdateWhenRemoveSong(Song song, String type){

        switch (type) {
            case PresentationController.ELIMINAR_FROM_PLAYLISTS:
                jpPlaylistView.updateWhenRemoveSong(song,PresentationController.ELIMINAR_FROM_PLAYLISTS);
                break;
            case PresentationController.ELIMINAR_FROM_SONGS:
                jpSongs.updateWhenRemoveSong(song);
                break;
            case PresentationController.ELIMINAR_FROM_SONGS_WHILE_IN_PLAYLISTS:
                jpPlaylistView.updateWhenRemoveSong(song,PresentationController.ELIMINAR_FROM_SONGS_WHILE_IN_PLAYLISTS);
                break;
        }
    }//Cierre del método

    /**
     * Método que activa mediante el register controller cuando hay una nueva playlist
     * @param actionListener Controler para los botones.
     * @param playlist Array donde se encuentran todas las playlist
     * @param songs Parámetro song que es de tipo song.
     */
    public void playlistViewUpdateRegisterControllersWhenNewPlaylist(ActionListener actionListener,PlayList playlist,ArrayList<Song> songs){ jpPlaylistView.updateRegisterControllerWhenNewPlaylist(actionListener, playlist,songs); }//Cierre del método

    /**
     * Método que activa mediante el register controller cuando se elimina una playlist
     */
    public void playlistViewUpdateRegisterControllerWhenDeletePlaylist(){ jpPlaylistView.updateRegisterControllerWhenDeletePlaylist(); }//Cierre del método

    /**
     * Método para cambair la vista.
     * @param newView Parámetro que indica la nueva vista.
     */
    public void playlistViewChangeViewTo(String newView){jpPlaylistView.changeViewTo(newView);}//Cierre del método

    /**
     * Método para runear la playlist
     */
    public void playlistJDPlaylistCreatorRun()  {  jpPlaylistView.jdPlaylistCreatorRun();  }//Cierre del método

    /**
     * Método para parar la playlist
     */
    public void playlistJDPlaylistCreatorClose(){  jpPlaylistView.jdPlaylistCreatorClose();}//Cierre del método

    /**
     * Método para poner el textFiel.
     * @return el parámetro del texto.
     */
    public String jdPlaylistGetTextFieldString(){return jpPlaylistView.jdPlaylistGetTextFieldString();}

    /**
     * Método que indica en string la canción añadida.
     * @return la cancion añadida.
     */
    public String playlistViewGetJCSongAdderString(){return jpPlaylistView.getJCSongAdderString();}

    /**
     * Método para saber la canción que queremos borar.
     * @return la canción que queremos borar.
     */
    public String playlistViewGetJCSongRemoveString(){return jpPlaylistView.getJCSongRemoveString();}//Cierre del método

    /**
     * Método para triar la playlist.
     * @return playlist triada.
     */
    public String playlistViewGetJCTriarPlaylistString(){return jpPlaylistView.getJCTriarPlaylistString();}//Cierre del método
    // ---- End PlaylistView Methods
    // ---- Start PianoView Methods
    /**
     * Método para resaltar las teclas negras cuando las blancas son pintadas. Le pasamos el valor de la tecla blanca asi sabemos que nregra resaltar.
     * @param nota
     */
    public void pianoViewRepainAllBlacks(int nota){jpPianoView.repainAllBlacks(nota);}

    /**
     * Método para controlar cuando se apreta el boton de reg para gravar
     * @param button Controlador del boton de reg
     */
    public void pianoViewSetPressedIcon(JButton button){ jpPianoView.setPressedIcon(button); }//Cierre del método

    /**
     * Método para controlar cuando se apreta el boton de reg para guardar
     * @param button Controlador del boton de reg
     */
    public void pianoViewSetUnpressedIcon(JButton button){
        jpPianoView.setUnpressedIcon(button);
    }//Cierre del método

    public void pianoViewSetPlayButtonPressedIcon(){jpPianoView.setPlayButtonPressedIcon();}
    public void pianoViewSetPlayButtonUnpressedIcon(){jpPianoView.setPlayButtonUnpressedIcon();}

    /**
     * Método para runear la vista.
     */
    public void pianoViewJDRun(){jpPianoView.jdRun();}//Cierre del método

    /**
     * Método para parar la vista.
     */
    public void pianoViewJDClose(){jpPianoView.jdClose();}//Cierre del método

    /**
     * Método que debuelve el string de la canción
     * @return el string de la canción.
     */
    public String pianoViewJDGetTextFieldString(){return jpPianoView.getTextFieldString();}//Cierre del método

    /**
     * Método que comprueba que has seleccionado la CheckBox
     * @return si has seleccionado la CheckBox
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
     * Método que retorna el panel del piano.
     * @return
     */
    public JPPiano getJpPiano(){return jpPianoView.getJpPiano();}

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
