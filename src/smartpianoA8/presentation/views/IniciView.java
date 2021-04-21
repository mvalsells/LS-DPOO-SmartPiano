package smartpianoA8.presentation.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class IniciView extends JFrame {
    public IniciView(){
        configureMenu();
    }

    private void configureMenu(){

        smartpianoA8.presentation.views.ImageView Desplegable = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesMenu/Captura de pantalla 2021-04-18 a las 19.jpg").getImage());
        ImageIcon Canciones = new ImageIcon("Imagen/ImagenesMenu/CancionesSelect.jpg");
        ImageIcon Mis_Favoritas = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritas.jpg");
        ImageIcon Piano = new ImageIcon("Imagen/ImagenesMenu/Piano.jpg");
        ImageIcon Descargar = new ImageIcon("Imagen/ImagenesMenu/Descargas.jpg");
        ImageIcon Ajustes = new ImageIcon("Imagen/ImagenesMenu/Ajustes.jpg");
        JFrame jFrameMenu = new JFrame();
        jFrameMenu.setLayout(new CardLayout());

        /*Panell principal on anira imatge*/
        //CardLayout Menu = new CardLayout();
        JPanel PanelMenu = new JPanel();

        //JPanel Pro = new JPanel();
        PanelMenu.setBackground(Color.GRAY);
        PanelMenu.setLayout(new BorderLayout());

        /*-----------------------------------------PART NORD-----------------------------------------*/
        JPanel PanelLateral = new JPanel();
        //PanelLateral.setOpaque(true);
        PanelLateral.setBackground(new Color(20,22,33));
        PanelLateral.setLayout(new BorderLayout());

        /*Botons*/
        JPanel Botons = new JPanel(); //Panel per situar els botons del Nord a la dreta
        Botons.setOpaque(false);
        Botons.setLayout(new BoxLayout(Botons,BoxLayout.Y_AXIS));

        JButton BotoCanço = new JButton();
        //BotoCanço.setForeground(new Color(255,255,255));
        //BotoCanço.setBackground(new Color(249,171,15));
        BotoCanço.setPreferredSize(new Dimension(68,60));
        BotoCanço.setBorderPainted(false);
        BotoCanço.setOpaque(false);
        BotoCanço.setIcon(Canciones);
        BotoCanço.setVisible(true);

        JButton BotoPreferit = new JButton();
        //BotoPreferit.setForeground(new Color(255,255,255));
        //BotoPreferit.setBackground(new Color(249,171,15));
        BotoPreferit.setPreferredSize(new Dimension(68,68));
        BotoPreferit.setBorderPainted(false);
        BotoPreferit.setOpaque(false);
        BotoPreferit.setIcon(Mis_Favoritas);
        BotoPreferit.setVisible(true);

        JButton BotoPiano = new JButton();
        //BotoPiano.setForeground(new Color(255,255,255));
        //BotoPiano.setBackground(new Color(249,171,15));
        BotoPiano.setPreferredSize(new Dimension(68,68));
        BotoPiano.setBorderPainted(false);
        BotoPiano.setOpaque(false);
        BotoPiano.setIcon(Piano);
        BotoPiano.setVisible(true);

        JButton BotoDescargar = new JButton();
        //BotoDescargar.setForeground(new Color(255,255,255));
        //BotoDescargar.setBackground(new Color(249,171,15));
        BotoDescargar.setPreferredSize(new Dimension(68,68));
        BotoDescargar.setBorderPainted(false);
        BotoDescargar.setOpaque(false);
        BotoDescargar.setIcon(Descargar);
        BotoDescargar.setVisible(true);

        JButton BotoAjustes = new JButton();
        //BotoAjustes.setForeground(new Color(255,255,255));
        //BotoAjustes.setBackground(new Color(249,171,15));
        BotoAjustes.setPreferredSize(new Dimension(85,68));
        BotoAjustes.setBorderPainted(false);
        BotoAjustes.setOpaque(false);
        BotoAjustes.setIcon(Ajustes);
        BotoAjustes.setVisible(true);



        /*-----------------------------------------PART CENTRAL-----------------------------------------*/
        /*Panell general centre*/
        JPanel PanellGeneralCentre = new JPanel();
        PanellGeneralCentre.setBackground(new Color(12,14,22));
        PanellGeneralCentre.setLayout(new BorderLayout());

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

        JPanel EspaiDesplegable = new JPanel();
        EspaiDesplegable.setBackground(new Color(12,14,22));
        JPanel EspaiDesplegable2 = new JPanel();
        EspaiDesplegable2.setBackground(new Color(12,14,22));

        JPanel Desplega = new JPanel();
        Desplega.setBackground(new Color(20,22,33));
        //EspaiDesplegable.setLayout(new BorderLayout());




        /*Creem borders per posicionar componetns*/
        LineBorder Separacio = new LineBorder(new Color(255,255,255),2);
        EmptyBorder TopSeparacio = new EmptyBorder(40,0,10,0);
        EmptyBorder EntreSeparacio = new EmptyBorder(500,0,10, 0);
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
        EntreSeparacio0.setPreferredSize(new Dimension(5,40));
        EntreSeparacio0.setBorder(EntreSeparacio);

        JLabel EntreSeparacio1 = new JLabel();
        EntreSeparacio1.setPreferredSize(new Dimension(5,40));
        EntreSeparacio1.setBorder(EntreSeparacio);

        JLabel EntreSeparacio2 = new JLabel();
        EntreSeparacio2.setPreferredSize(new Dimension(5,40));
        EntreSeparacio2.setBorder(EntreSeparacio);

        JLabel EntreSeparacio3 = new JLabel();
        EntreSeparacio3.setPreferredSize(new Dimension(5,300));
        EntreSeparacio3.setBorder(EntreSeparacio);

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
        Botons.add(TopSeparacio0);
        Botons.add(BotoCanço);
        Botons.add(EntreSeparacio0);
        Botons.add(BotoPreferit);
        Botons.add(EntreSeparacio1);
        Botons.add(BotoPiano);
        Botons.add(EntreSeparacio2);
        Botons.add(BotoDescargar);
        Botons.add(EntreSeparacio3);
        Botons.add(BotoAjustes);
        PanelLateral.add(Botons,BorderLayout.NORTH);
        PanelMenu.add(PanelLateral,BorderLayout.WEST);

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
        EspaiDesplegable.add(EntreSeparacio10);
        Desplegable.add(EntreSeparacio11);
        MenuOpcions.add(EspaiDesplegable,BorderLayout.NORTH);
        Desplega.add(Desplegable);
        //MenuOpcions.add(EspaiDesplegable2,BorderLayout.SOUTH);
        MenuOpcions.add(Desplega, BorderLayout.WEST);
        MenuOpcions.add(EntreSeparacio9);
        //MenuOpcions.add(EntreSeparacio9);
        TerceraSeparacio.add(EntreSeparacio7);
        //TerceraSeparacio.add()
        TerceraSeparacio.add(MenuOpcions,BorderLayout.CENTER);
        //TerceraSeparacio.add(EspaiNovedades, BorderLayout.NORTH);
        TerceraSeparacio.add(EspaiNovedades,BorderLayout.NORTH);
        CancionesMasEscuchadas.add(TerceraSeparacio,BorderLayout.SOUTH);


        PanellGeneralCentre.add(CancionesMasEscuchadas,BorderLayout.CENTER);
        PanellGeneralCentre.add(SeparacioNord,BorderLayout.NORTH);
        PanelMenu.add(PanellGeneralCentre,BorderLayout.CENTER);
        //BotoAjustes.addActionListener(e -> Prova1.next(MenuOpcions));

        jFrameMenu.setResizable(false);
        jFrameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameMenu.getContentPane().add("Ref_1",PanelMenu);
        jFrameMenu.setPreferredSize(new Dimension(1000,820));
        jFrameMenu.pack();
        jFrameMenu.setVisible(true);

    }
}
