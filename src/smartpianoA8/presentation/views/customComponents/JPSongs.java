package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.presentation.views.BordersView;

import javax.swing.*;
import java.awt.*;

public class JPSongs extends JPanel {
    public JPSongs(){
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
        mas_Escuchadas.setLayout(new GridLayout(1,5));
        mas_Escuchadas.setBorder(BorderFactory.createEmptyBorder(0,0,10,2));


        JLabel novedades = new JLabel("Novedades");
        novedades.setForeground(ColorScheme.PRIMARY);
        novedades.setBorder(BorderFactory.createEmptyBorder(0,0,10,10));
        novedades.setFont(FontBase.TitularRegAdd);

        JPanel news = new JPanel();
        news.setBackground(ColorScheme.MainView_Background);
        news.setBorder(BorderFactory.createEmptyBorder(0,0,10,2));
        news.setLayout(new GridLayout(1,5));

        JPanel[] separacioMas = new JPanel[5];
        JPanel[] separacioNew = new JPanel[5];
        for(int i=0; i<5; i++){
            separacioMas[i] = new JPanel();
            separacioNew[i] = new JPanel();
            separacioNew[i].setBorder(BorderFactory.createLineBorder(ColorScheme.MainView_Background));
            separacioMas[i].setBorder(BorderFactory.createLineBorder(ColorScheme.MainView_Background));
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
}
