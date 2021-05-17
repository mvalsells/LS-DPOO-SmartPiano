package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPSongs extends JPanel {
    public static final String SONG_PRESSED = "songPressed-";

    private int lastSongIDPressed;

    private ArrayList<Song> songs;
    private jpTiraCançons jpTiraCançonsMas;
    private jpTiraCançons jpTiraCançonsNew;
    private JButton[] newButon;
    private JButton[] masButon;
    public JPSongs(ArrayList<Song> songs){
        this.songs = songs;
        configureMenu();
    }
    BordersView bordersView = new BordersView();
    private void configureMenu(){




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

        /*JScrollPane scrollPane = new JScrollPane(new TextArea(100,100));
        scrollPane.setBounds(10,101,742,276);
        scrollPane.setHorizontalScrollBar();*/



        /*JLabel jlMasEscuchadasText = new JLabel("Mas escuchadas");
        jlMasEscuchadasText.setForeground(ColorScheme.PRIMARY);
        jlMasEscuchadasText.setBorder(BorderFactory.createEmptyBorder(0,0,10,10));
        jlMasEscuchadasText.setFont(FontBase.TitularRegAdd);*/


        /*JPanel jpMasEscuchadas = new JPanel();
        jpMasEscuchadas.setBackground(ColorScheme.MainView_Background);
        jpMasEscuchadas.setLayout(new GridLayout(1,songs.size()));
        jpMasEscuchadas.setBorder(BorderFactory.createEmptyBorder(0,0,10,2));*/

        jpTiraCançonsMas = new jpTiraCançons(songs,"Mas escuchadas");
        jpTiraCançonsNew = new jpTiraCançons(songs,"Recientes");

        JLabel novedades = new JLabel("Novedades");
        novedades.setForeground(ColorScheme.PRIMARY);
        novedades.setBorder(BorderFactory.createEmptyBorder(0,0,10,10));
        novedades.setFont(FontBase.TitularRegAdd);

        JPanel news = new JPanel();
        news.setBackground(ColorScheme.MainView_Background);
        news.setBorder(BorderFactory.createEmptyBorder(0,0,10,2));
        news.setLayout(new GridLayout(1,songs.size()));
        //scrollPane.setViewportView(news);
        //scrollPane.setViewportView(jpMasEscuchadas);

        /*JScrollPane scrollPane1= new JScrollPane (news,JScrollPane.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollBar scrollPane= scrollPane1.getHorizontalScrollBar();
        scrollPane.setValue(scrollPane.getMaximum());
        JPanel[] separacioMas = new JPanel[songs.size()];


        masButon = new JBgeneral[songs.size()];
        newButon = new JBgeneral[songs.size()];

        JPanel[] separacioNew = new JPanel[songs.size()];
        for(int i=0; i< songs.size(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(SONG_PRESSED);
            sb.append(songs.get(i).getIdSong());
            masButon[i] = new JBgeneral("Holi personi", ColorScheme.ORANGE_START);
            newButon[i] = new JBgeneral("Holi personi2", ColorScheme.ORANGE_START);
            masButon[i].setActionCommand(sb.toString());
            newButon[i].setActionCommand(sb.toString());
            separacioMas[i] = new JPanel();
            separacioMas[i].setLayout(new BorderLayout());
            separacioNew[i] = new JPanel();
            separacioNew[i].setLayout(new BorderLayout());
            masButon[i].setBorder(BorderFactory.createEmptyBorder(0,200,0,0));
            newButon[i].setBorder(BorderFactory.createEmptyBorder(0,200,0,0));
            separacioNew[i].setBorder(BorderFactory.createLineBorder(ColorScheme.MainView_Background));
            separacioMas[i].setBorder(BorderFactory.createLineBorder(ColorScheme.MainView_Background));
            separacioMas[i].add(masButon[i], BorderLayout.CENTER);
            separacioNew[i].add(newButon[i], BorderLayout.CENTER);
            news.add(separacioNew[i]);
            jpMasEscuchadas.add(separacioMas[i]);
            //news.add(scrollPane);
        }*/

        //masEscuhadasText.add(jlMasEscuchadasText,BorderLayout.SOUTH);
        //masEscuhadasPanel.add(jspMasSongs,BorderLayout.CENTER);

        novedadesText.add(novedades,BorderLayout.SOUTH);
        novedadesPanel.add(news, BorderLayout.CENTER);

        //partNort.add(masEscuhadasText);
        partNort.add(jpTiraCançonsMas);
        //partSud.add(novedadesText);
        partSud.add(jpTiraCançonsNew);

        fons.add(partNort);
        fons.add(partSud);
        add(fons);


    }

    public void registerController(ActionListener controller){

        jpTiraCançonsMas.registerController(controller);

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
