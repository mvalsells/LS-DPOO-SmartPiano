package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPSongs extends JPanel {
    public static final String SONG_PRESSED = "songPressed-";
    private ArrayList<Song> songs;
    private JPTiraCancons jpTiraCançonsMas;
    private JPTiraCancons jpTiraCançonsNew;
    public JPSongs(ArrayList<Song> songs){
        this.songs = songs;
        configureMenu();
    }
    BordersView bordersView = new BordersView();
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


        jpTiraCançonsMas = new JPTiraCancons(songs,"Mas escuchadas");
        jpTiraCançonsNew = new JPTiraCancons(songs,"Recientes");

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


    }

    public void registerController(ActionListener controller){

        jpTiraCançonsMas.registerController(controller);
        jpTiraCançonsNew.registerController(controller);

    }

    public void nuevasCanciones() {

    }


}
