package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPSongs extends JPanel {
    public static final String SONG_PRESSED = "songPressed";

    private int lastSongIDPressed;

    private ArrayList<Song> songs;
    private JButton[] newButon;
    private JButton[] masButon;
    public JPSongs(ArrayList<Song> songs){
        this.songs = songs;
        configureMenu();
    }
    BordersView bordersView = new BordersView();
    private void configureMenu(){
        
        
        

        ImageIcon Canciones = new ImageIcon("Imagen/ImagenesMenu/Canciones.png");
        ImageIcon CancionesSelect = new ImageIcon("Imagen/ImagenesMenu/CancionesSelect.jpg");
        ImageIcon Mis_Favoritas = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritas.jpg");
        ImageIcon Mis_FavoritasSelect = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritasSelect.jpg");
        ImageIcon Piano = new ImageIcon("Imagen/ImagenesMenu/Piano.jpg");
        ImageIcon PianoSelect = new ImageIcon("Imagen/ImagenesMenu/PianoSelect.jpg");
        ImageIcon Descargar = new ImageIcon("Imagen/ImagenesMenu/Descargas.jpg");
        ImageIcon Ajustes = new ImageIcon("Imagen/ImagenesMenu/Ajustes.jpg");



        /*-----------------------------------------PART NORD-----------------------------------------*/
        


        /*-----------------------------------------PART CENTRAL-----------------------------------------*/
        /*Panell general centre*/


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


        JLabel masEscuchadas = new JLabel("Mas escuchadas");
        masEscuchadas.setForeground(ColorScheme.PRIMARY);
        masEscuchadas.setBorder(BorderFactory.createEmptyBorder(0,0,10,10));
        masEscuchadas.setFont(FontBase.TitularRegAdd);


        JPanel mas_Escuchadas = new JPanel();
        mas_Escuchadas.setBackground(ColorScheme.MainView_Background);
        mas_Escuchadas.setLayout(new GridLayout(1,songs.size()));
        mas_Escuchadas.setBorder(BorderFactory.createEmptyBorder(0,0,10,2));


        JLabel novedades = new JLabel("Novedades");
        novedades.setForeground(ColorScheme.PRIMARY);
        novedades.setBorder(BorderFactory.createEmptyBorder(0,0,10,10));
        novedades.setFont(FontBase.TitularRegAdd);

        JPanel news = new JPanel();
        news.setBackground(ColorScheme.MainView_Background);
        news.setBorder(BorderFactory.createEmptyBorder(0,0,10,2));
        news.setLayout(new GridLayout(1,songs.size()));

        JPanel[] separacioMas = new JPanel[songs.size()];

        masButon = new JBgeneral[songs.size()];
        newButon = new JBgeneral[songs.size()];
        JPanel[] separacioNew = new JPanel[songs.size()];
        for(int i=0; i< songs.size(); i++){
            masButon[i] = new JBgeneral("Holi personi", ColorScheme.ORANGE_START);
            newButon[i] = new JBgeneral("Holi personi2", ColorScheme.ORANGE_START);
            masButon[i].setActionCommand( SONG_PRESSED );
            newButon[i].setActionCommand(SONG_PRESSED);
            separacioMas[i] = new JPanel();
            separacioMas[i].setLayout(new BorderLayout());
            separacioNew[i] = new JPanel();
            separacioNew[i].setLayout(new BorderLayout());
            //masButon[i].setBorder(BorderFactory.createEmptyBorder(0,0,10,2));
            //newButon[i].setBorder(BorderFactory.createEmptyBorder(0,0,10,2));
            separacioNew[i].setBorder(BorderFactory.createLineBorder(ColorScheme.MainView_Background));
            separacioMas[i].setBorder(BorderFactory.createLineBorder(ColorScheme.MainView_Background));
            separacioMas[i].add(masButon[i], BorderLayout.CENTER);
            separacioNew[i].add(newButon[i], BorderLayout.CENTER);
            news.add(separacioNew[i]);
            mas_Escuchadas.add(separacioMas[i]);
        }

        masEscuhadasText.add(masEscuchadas,BorderLayout.SOUTH);
        masEscuhadasPanel.add(mas_Escuchadas,BorderLayout.CENTER);

        novedadesText.add(novedades,BorderLayout.SOUTH);
        novedadesPanel.add(news, BorderLayout.CENTER);

        partNort.add(masEscuhadasText);
        partNort.add(masEscuhadasPanel);
        partSud.add(novedadesText);
        partSud.add(novedadesPanel);

        fons.add(partNort);
        fons.add(partSud);
        add(fons);


    }

    public void registerController(ActionListener controller){

        for(int i=0; i< songs.size(); i++){

            masButon[i].addActionListener(controller);
            newButon[i].addActionListener(controller);

        }

    }

    public void nuevasCanciones() {
        //Actualizar la vista
    }
    /*public int getSongPressedID(){re}
    public String getSongPressedIDString(int idButton){

        for(int i=0; i< songs.size(); i++){

            if(masButon.get)

        }

    }*/

}
