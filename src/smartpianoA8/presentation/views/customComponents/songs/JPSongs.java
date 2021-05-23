package smartpianoA8.presentation.views.customComponents.songs;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.BordersView;
import smartpianoA8.presentation.views.customComponents.ColorScheme;
import smartpianoA8.presentation.views.customComponents.FontBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * Esta clase se emcarga principalmente de controlar el JPanel asociado a las cancioens de esa manera el usuario
 * podra acceder al panel donde se encuentran todas las canciones.
 *
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JPSongs extends JPanel {
    public static final String SONG_PRESSED = "songPressed-";
    private ArrayList<Song> songs;
    private JPTiraCancons jpTiraCançonsMas;
    private JPTiraCancons jpTiraCançonsNew;
    BordersView bordersView = new BordersView();
    /**
     *Constructor de la clase JPSongs
     * @param songs Parámetro que indica la canción como un array de ellas.
     */
    public JPSongs(ArrayList<Song> songs){
        this.songs = songs;
        configureMenu();
    }//Cierre del constructor

    /**
     * Método donde se implementa todos los paneles y vistas asociadas a la clase.
     */
    private void configureMenu(){

        setBackground(new Color(12,14,22));
        setLayout(new BorderLayout());

        JPanel fons = new JPanel();
        fons.setLayout(new BoxLayout(fons, BoxLayout.Y_AXIS));


        JPanel partNort = new JPanel();
        partNort.setLayout(new BoxLayout(partNort, BoxLayout.Y_AXIS));

        JPanel partSud = new JPanel();
        partSud.setLayout(new BoxLayout(partSud,BoxLayout.Y_AXIS));

        JPanel masEscuhadasText = new JPanel();
        masEscuhadasText.setLayout(new BorderLayout());
        masEscuhadasText.setBackground(ColorScheme.MainView_Background);
        JPanel masEscuhadasPanel = new JPanel();
        masEscuhadasPanel.setLayout(new BorderLayout());
        masEscuhadasPanel.setBackground(ColorScheme.MainView_Background);

        JPanel novedadesText = new JPanel();
        novedadesText.setLayout(new BorderLayout());
        novedadesText.setBackground(ColorScheme.MainView_Background);
        JPanel novedadesPanel = new JPanel();
        novedadesPanel.setLayout(new BorderLayout());
        novedadesPanel.setBackground(ColorScheme.MainView_Background);

        /*//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        ArrayList<Song> patataSongs = new ArrayList<>();
        patataSongs.add(songs.get(0));
        patataSongs.add(songs.get(1));
        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/

        jpTiraCançonsMas = new JPTiraCancons();
        jpTiraCançonsMas.updateTira(songs,"Mas escuchadas");
        jpTiraCançonsNew = new JPTiraCancons();
        jpTiraCançonsNew.updateTira(songs,"Recientes");

        JLabel novedades = new JLabel("Novedades");
        novedades.setForeground(ColorScheme.PRIMARY);
        novedades.setBorder(BorderFactory.createEmptyBorder(0,0,10,10));
        novedades.setFont(FontBase.TitularRegAdd);

        JPanel news = new JPanel();
        news.setBackground(ColorScheme.MainView_Background);
        news.setBorder(BorderFactory.createEmptyBorder(0,0,10,2));
        news.setLayout(new GridLayout(1,songs.size()));


        novedadesText.add(novedades,BorderLayout.SOUTH);
        novedadesPanel.add(news, BorderLayout.CENTER);

        partNort.add(jpTiraCançonsMas);
        partSud.add(jpTiraCançonsNew);

        fons.add(partNort);
        fons.add(partSud);
        add(fons);


    }//Cierre del método

    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param controller controlador asocioado a los botones.
     */
    public void registerController(ActionListener controller){

        jpTiraCançonsMas.registerController(controller);
        jpTiraCançonsNew.registerController(controller);

    }//Cierre del método

    /**
     * Método que actualiza la vista cuando hay una nueva canción.
     * @param song Parámetro que indica que canción se le ha añadido.
     */
    public void nuevasCanciones(Song song,ActionListener controller) {

        jpTiraCançonsNew.updateWhenAdd(song);
        jpTiraCançonsNew.registerControllerLastButton(controller);
        jpTiraCançonsMas.updateWhenAdd(song);
        jpTiraCançonsMas.registerControllerLastButton(controller);


    }//Cierre del método

    public void updateWhenRemoveSong(Song song){

        jpTiraCançonsNew.updateWhenRemove(song);
        jpTiraCançonsMas.updateWhenRemove(song);
        revalidate();
    }

}//Cierre de la clase
