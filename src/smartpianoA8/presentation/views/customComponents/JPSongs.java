package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.presentation.views.BordersView;
import smartpianoA8.presentation.views.customComponents.ImageView;
import smartpianoA8.presentation.views.customComponents.JPPiano;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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

        /*Posicio Nord per separar*/
        JPanel SeparacioNord = new JPanel();
        SeparacioNord.setBackground(new Color(12,14,22));
        SeparacioNord.setLayout(new BorderLayout());

        JPanel SepaacioNord2 = new JPanel();
        SepaacioNord2.setBackground(Color.BLACK);
        SepaacioNord2.setLayout(new BorderLayout());

        JLabel MasEscuchadas = new JLabel("Mas escuchadas");
        MasEscuchadas.setForeground(new Color(255,255,255));
        MasEscuchadas.setPreferredSize(new Dimension(140,30));
        MasEscuchadas.setFont(new Font("Verdana", Font.BOLD, 15));

        JLabel Novedades = new JLabel("Novedades");
        Novedades.setForeground(new Color(255,255,255));
        Novedades.setPreferredSize(new Dimension(140,30));
        Novedades.setFont(new Font("Verdana", Font.BOLD, 15));

        JLabel EspaiNovedadesProva = new JLabel(" ");
        Novedades.setForeground(new Color(255,255,255));
        Novedades.setPreferredSize(new Dimension(140,30));
        Novedades.setFont(new Font("Verdana", Font.BOLD, 15));

        //SeparacioNord.setLayout(new BorderLayout());
        /*LLoc on estan les cancons mes escoltades*/
        JPanel CancionesMasEscuchadas = new JPanel();
        CancionesMasEscuchadas.setBackground(new Color(12,14,22));
        CancionesMasEscuchadas.setLayout(new BorderLayout());

        JPanel RecuadroMasEscuchadas = new JPanel();
        RecuadroMasEscuchadas.setBackground(Color.GRAY);
        RecuadroMasEscuchadas.setLayout(new BorderLayout());

        JPanel VisualitzarRecuadre = new JPanel();
        VisualitzarRecuadre.setBackground(new Color(12,14,22));

        /*Segona separacio*/
        JPanel SegonaSeparacio = new JPanel();
        SegonaSeparacio.setBackground(new Color(12,14,22));
        SegonaSeparacio.setLayout(new BorderLayout());

        JPanel SeparacioEspai = new JPanel();
        SeparacioEspai.setBackground(new Color(12,14,22));

        JPanel SeparacioPerNovedades = new JPanel();
        SeparacioPerNovedades.setBackground(new Color(12,14,22));
        SeparacioPerNovedades.setLayout(new BorderLayout());

        JPanel SeparacioNovedades = new JPanel();
        SeparacioNovedades.setBackground(new Color(12,14,22));
        SeparacioNovedades.setLayout(new BorderLayout());

        JPanel TerceraSeparacio = new JPanel();
        TerceraSeparacio.setBackground(new Color(12,14,22));
        TerceraSeparacio.setLayout(new BorderLayout());

        JPanel EspaiNovedades = new JPanel();
        EspaiNovedades.setBackground(Color.GRAY);
        EspaiNovedades.setLayout(new BorderLayout());
        //JPanel CancionesMasEscuchadas1 =

        JPanel EspaiNovedades2 = new JPanel();
        EspaiNovedades2.setBackground(Color.GRAY);

        JPanel MenuOpcions = new JPanel();
        MenuOpcions.setBackground(new Color(12,14,22));
        MenuOpcions.setLayout(new BorderLayout());

        //JPanel Desplegable = new JPanel();
        //Desplegable.setBackground(Color.RED);

        //Desplegable1.setLayout(new BorderLayout());






        /*Creem borders per posicionar componetns*/
        LineBorder Separacio = new LineBorder(new Color(255,255,255),2);
        EmptyBorder TopSeparacio = new EmptyBorder(20,0,10,0);
        EmptyBorder EntreSeparacio = new EmptyBorder(20,0,10, 0);
        EmptyBorder EntreSeparacioPatata = new EmptyBorder(300,0,10, 0);
        EmptyBorder EntreSeparacio02 = new EmptyBorder(40,0,500, 0);
        EmptyBorder EntreSeparacio03 = new EmptyBorder(0,0,0, 400);

        /*Creem labels per establir espais entre components*/
        JLabel TopSeparacio0 = new JLabel();
        TopSeparacio0.setPreferredSize(new Dimension(5,27));
        TopSeparacio0.setBorder(TopSeparacio);

        JLabel TopSeparacio1 = new JLabel();
        TopSeparacio1.setPreferredSize(new Dimension(5,27));
        TopSeparacio1.setBorder(TopSeparacio);

        JLabel TopSeparacio2 = new JLabel();
        TopSeparacio2.setPreferredSize(new Dimension(5,27));
        TopSeparacio2.setBorder(TopSeparacio);

        JLabel EntreSeparacio0 = new JLabel();
        EntreSeparacio0.setPreferredSize(new Dimension(5,20));
        EntreSeparacio0.setBorder(EntreSeparacio);

        JLabel EntreSeparacio1 = new JLabel();
        EntreSeparacio1.setPreferredSize(new Dimension(5,40));
        EntreSeparacio1.setBorder(EntreSeparacio);

        JLabel EntreSeparacio2 = new JLabel();
        EntreSeparacio2.setPreferredSize(new Dimension(5,40));
        EntreSeparacio2.setBorder(EntreSeparacio);

        JLabel EntreSeparacio3 = new JLabel();
        EntreSeparacio3.setBorder(EntreSeparacioPatata);

        JLabel EntreSeparacio4 = new JLabel();
        EntreSeparacio4.setPreferredSize(new Dimension(5,80));
        EntreSeparacio4.setBorder(EntreSeparacio);

        JLabel EntreSeparacio5 = new JLabel();
        EntreSeparacio5.setPreferredSize(new Dimension(5,175));
        EntreSeparacio5.setBorder(EntreSeparacio);

        JLabel EntreSeparacio6 = new JLabel();
        EntreSeparacio6.setPreferredSize(new Dimension(5,40));
        EntreSeparacio6.setBorder(EntreSeparacio);

        JLabel EntreSeparacio7 = new JLabel();
        EntreSeparacio7.setPreferredSize(new Dimension(5,160));
        EntreSeparacio7.setBorder(EntreSeparacio);

        JLabel EntreSeparacio8 = new JLabel();
        EntreSeparacio8.setPreferredSize(new Dimension(5,170));
        EntreSeparacio8.setBorder(EntreSeparacio02);

        JLabel EntreSeparacio9 = new JLabel();
        EntreSeparacio9.setPreferredSize(new Dimension(5,160));
        EntreSeparacio9.setBorder(EntreSeparacio02);

        JLabel EntreSeparacio10 = new JLabel();
        EntreSeparacio10.setPreferredSize(new Dimension(5,50));
        EntreSeparacio10.setBorder(EntreSeparacio);

        JLabel EntreSeparacio11 = new JLabel();
        EntreSeparacio11.setPreferredSize(new Dimension(170,50));
        EntreSeparacio11.setBorder(EntreSeparacio03);




        /*Packin' area*/
        /*Part West Botons*/
        
        

        /*Part Central*/
        SepaacioNord2.add(MasEscuchadas, BorderLayout.WEST);
        SepaacioNord2.add(TopSeparacio1);
        SeparacioNord.add(SepaacioNord2, BorderLayout.SOUTH);
        //SeparacioNord.add(CancionesMasEscuchadas,BorderLayout.SOUTH);
        SeparacioNord.add(EntreSeparacio4);

        //VisualitzarRecuadre.add(TopSeparacio2);
        RecuadroMasEscuchadas.add(VisualitzarRecuadre,BorderLayout.NORTH);
        RecuadroMasEscuchadas.add(EntreSeparacio5);
        CancionesMasEscuchadas.add(RecuadroMasEscuchadas,BorderLayout.NORTH);
        //SeparacioNovedades.add(EntreSeparacio6);
        //SeparacioNovedades.add(Novedades,BorderLayout.WEST);
        SeparacioEspai.add(EntreSeparacio6);
        //eparacioNovedades.add(Novedades,BorderLayout.WEST);
        SeparacioPerNovedades.add(Novedades,BorderLayout.NORTH);
        SegonaSeparacio.add(SeparacioPerNovedades,BorderLayout.CENTER);
        SegonaSeparacio.add(SeparacioEspai,BorderLayout.NORTH);
        CancionesMasEscuchadas.add(SegonaSeparacio,BorderLayout.CENTER);

        EspaiNovedades2.add(EntreSeparacio8);
        //EspaiNovedades2.add(EspaiNovedadesProva);
        //EspaiNovedades.add(Novedades,BorderLayout.WEST);
        EspaiNovedades.add(EspaiNovedades2,BorderLayout.NORTH);

        MenuOpcions.add(EntreSeparacio9);
        //MenuOpcions.add(EntreSeparacio9);
        TerceraSeparacio.add(EntreSeparacio7);
        //TerceraSeparacio.add()
        TerceraSeparacio.add(MenuOpcions,BorderLayout.CENTER);
        //TerceraSeparacio.add(EspaiNovedades, BorderLayout.NORTH);
        TerceraSeparacio.add(EspaiNovedades,BorderLayout.NORTH);
        CancionesMasEscuchadas.add(TerceraSeparacio,BorderLayout.SOUTH);


        add(CancionesMasEscuchadas,BorderLayout.CENTER);
        add(SeparacioNord,BorderLayout.NORTH);


    }
}
