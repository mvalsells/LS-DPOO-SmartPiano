package smartpianoA8.presentation.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;


public class PianoView extends JFrame {

    public PianoView(){
        configurePiano();
    }

    private void configurePiano(){

        smartpianoA8.presentation.views.ImageView SombrejatSud = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesMenu/SombrejatSud.jpg").getImage());
        smartpianoA8.presentation.views.ImageView SombrejatWest = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesMenu/SombrejatWest.png").getImage());
        ImageIcon Canciones = new ImageIcon("Imagen/ImagenesMenu/Canciones.png");
        ImageIcon Mis_Favoritas = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritas.jpg");
        ImageIcon Piano = new ImageIcon("Imagen/ImagenesMenu/PianoSelect.png");
        ImageIcon Descargar = new ImageIcon("Imagen/ImagenesMenu/Descargas.jpg");
        ImageIcon Ajustes = new ImageIcon("Imagen/ImagenesMenu/Ajustes.jpg");



        JFrame jFramePiano = new JFrame();
        jFramePiano.setLayout(new CardLayout());

        JPanel PanelMenu = new JPanel();

        //JPanel Pro = new JPanel();
        PanelMenu.setBackground(new Color(211,216,221));
        PanelMenu.setLayout(new BorderLayout());

        /*-----------------------------------------PART WEST-----------------------------------------*/
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
        BotoPiano.setPreferredSize(new Dimension(70,70));
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


        /*-----------------------------------------PART CENTRE-----------------------------------------*/
        /*Panell general centre*/
        JPanel PanellGeneralCentre = new JPanel();
        PanellGeneralCentre.setBackground(Color.PINK);
        PanellGeneralCentre.setLayout(new BorderLayout());

        JPanel PanellNordGeneral = new JPanel();
        PanellNordGeneral.setBackground(new Color(211,216,221));

        JPanel PanellSudGeneral = new JPanel();
        PanellSudGeneral.setBackground(new Color(211,216,221));

        JPanel PanelCentralGeneral = new JPanel();
        PanelCentralGeneral.setBackground(Color.CYAN);
        PanelCentralGeneral.setLayout(new BorderLayout());

        /* Panell borders piano*/
        JPanel LateralWest =  new JPanel();
        LateralWest.setBackground(new Color(31,26,26));

        JPanel LateralEast = new JPanel();
        LateralEast.setBackground(new Color(31,26,26));

        JPanel PosicioCentral= new JPanel();
        PosicioCentral.setBackground(Color.green);
        PosicioCentral.setLayout(new BorderLayout());

        JPanel PartNort = new JPanel();
        PartNort.setBackground(Color.CYAN);

        JPanel PanelCentre = new JPanel();
        PanelCentre.setBackground(Color.PINK);
        PanelCentre.setLayout(new BorderLayout());

        JPanel NordPanellCentre = new JPanel();
        NordPanellCentre.setBackground(Color.GREEN);
        NordPanellCentre.setLayout(new BorderLayout());

        JPanel CentrePanellCentre = new JPanel();
        CentrePanellCentre.setBackground(Color.GRAY);
        CentrePanellCentre.setLayout(new BorderLayout());

        JPanel SudPanellCentre = new JPanel();
        SudPanellCentre.setBackground(Color.YELLOW);
        SudPanellCentre.setLayout(new BorderLayout());

        /*Part central piano*/

        JPanel WestCentre = new JPanel();
        WestCentre.setBackground(Color.PINK );
        WestCentre.setLayout(new BorderLayout());

        JPanel ResteCentre = new JPanel();
        ResteCentre.setBackground(Color.YELLOW);
        ResteCentre.setLayout(new BorderLayout());

        JPanel ResteCentreNord = new JPanel();
        ResteCentreNord.setBackground(new Color(43,43,44));

        JPanel ContinuacioCentre = new JPanel();
        ContinuacioCentre.setBackground(Color.orange);
        ContinuacioCentre.setLayout(new BorderLayout());

        JPanel EastCentre = new JPanel();
        EastCentre.setBackground(new Color(50,51,51));

        JPanel Teclat = new JPanel();
        Teclat.setBackground(Color.WHITE);

        /* Botons Piano*/

        JPanel SeparacioBotoWest = new JPanel();
        SeparacioBotoWest.setBackground(Color.PINK);
        SeparacioBotoWest.setLayout(new BorderLayout());

        JPanel SeparacioBotoCentre = new JPanel();
        SeparacioBotoCentre.setBackground(Color.RED);

        JPanel SeparacioBotoEast = new JPanel();
        SeparacioBotoEast.setBackground(Color.MAGENTA);

        /*Botons Piano West*/

        JPanel WestBotoPianoWest = new JPanel();
        WestBotoPianoWest.setBackground(Color.green);

        JPanel CenterBotoPianoWest = new JPanel();
        CenterBotoPianoWest.setBackground(Color.DARK_GRAY);

        JPanel EastBotoPianoWest = new JPanel();
        EastBotoPianoWest.setBackground(Color.BLUE);
        //EastBotoPianoWest.setLayout(new BorderLayout());











        /*Creem borders per posicionar componetns*/
        LineBorder Separacio = new LineBorder(new Color(255,255,255),2);
        EmptyBorder TopSeparacio = new EmptyBorder(40,0,10,0);
        EmptyBorder EntreSeparacio = new EmptyBorder(500,0,10, 0);
        EmptyBorder EntreSeparacio02 = new EmptyBorder(40,0,500, 0);
        EmptyBorder EntreSeparacio03 = new EmptyBorder(0,0,0, 400);

        JLabel TopSeparacio0 = new JLabel();
        TopSeparacio0.setPreferredSize(new Dimension(5,27));
        TopSeparacio0.setBorder(TopSeparacio);

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
        EntreSeparacio4.setPreferredSize(new Dimension(5,150));
        EntreSeparacio4.setBorder(EntreSeparacio);

        JLabel EntreSeparacio5 = new JLabel();
        EntreSeparacio5.setPreferredSize(new Dimension(5,200));
        EntreSeparacio5.setBorder(EntreSeparacio);

        JLabel SeparacioLateralWest = new JLabel();
        SeparacioLateralWest.setPreferredSize(new Dimension(25,0));
        SeparacioLateralWest.setBorder(EntreSeparacio);

        JLabel SeparacioLateralEast = new JLabel();
        SeparacioLateralEast.setPreferredSize(new Dimension(25,0));
        SeparacioLateralEast.setBorder(EntreSeparacio);

        JLabel SeparacioPanellCentreNord = new JLabel();
        SeparacioPanellCentreNord.setPreferredSize(new Dimension(5,140));
        SeparacioPanellCentreNord.setBorder(EntreSeparacio);

        JLabel SeparacioPanellCentreSud = new JLabel();
        SeparacioPanellCentreSud.setPreferredSize(new Dimension(5,28));
        SeparacioPanellCentreSud.setBorder(EntreSeparacio);

        JLabel SeparacioCentreWest= new JLabel();
        SeparacioCentreWest.setPreferredSize(new Dimension(50,0));
        SeparacioCentreWest.setBorder(EntreSeparacio);

        JLabel SeparacioCentreEast= new JLabel();
        SeparacioCentreEast.setPreferredSize(new Dimension(40,0));
        SeparacioCentreEast.setBorder(EntreSeparacio);

        JLabel SeparacioRestaCentreNord = new JLabel();
        SeparacioRestaCentreNord.setPreferredSize(new Dimension(0,32));
        SeparacioRestaCentreNord.setBorder(EntreSeparacio);

        JLabel SeparacioPosBotoWest = new JLabel();
        SeparacioPosBotoWest.setPreferredSize(new Dimension(280,0));
        SeparacioPosBotoWest.setBorder(EntreSeparacio);

        JLabel SeparacioPosBotoEast = new JLabel();
        SeparacioPosBotoEast.setPreferredSize(new Dimension(280,0));
        SeparacioPosBotoEast.setBorder(EntreSeparacio);

        JLabel SeparacioEastBotoWest = new JLabel();
        SeparacioEastBotoWest.setPreferredSize(new Dimension(200,0));
        SeparacioEastBotoWest.setBorder(EntreSeparacio);

        JLabel SeparacioWestBotoWest = new JLabel();
        SeparacioWestBotoWest.setPreferredSize(new Dimension(200,0));
        SeparacioWestBotoWest.setBorder(EntreSeparacio);








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

        /*Part Piano*/
        /*Botons*/

        //EastBotoPianoWest.add(SeparacioEastBotoWest);

        //WestBotoPianoWest.add(SeparacioWestBotoWest);
        SeparacioBotoWest.add(WestBotoPianoWest,BorderLayout.WEST);
        SeparacioBotoWest.add(CenterBotoPianoWest,BorderLayout.CENTER);
        SeparacioBotoWest.add(EastBotoPianoWest,BorderLayout.EAST);



        SeparacioBotoWest.add(SeparacioPosBotoWest);
        SeparacioBotoEast.add(SeparacioPosBotoEast);

        NordPanellCentre.add(SeparacioBotoWest,BorderLayout.WEST);
        NordPanellCentre.add(SeparacioBotoCentre,BorderLayout.CENTER);
        NordPanellCentre.add(SeparacioBotoEast,BorderLayout.EAST);

        /*Centre Piano*/
        EastCentre.add(SeparacioCentreEast);
        ContinuacioCentre.add(EastCentre,BorderLayout.EAST);
        ContinuacioCentre.add(Teclat,BorderLayout.CENTER);

        ResteCentreNord.add(SeparacioRestaCentreNord);
        ResteCentre.add(ResteCentreNord,BorderLayout.NORTH);
        ResteCentre.add(ContinuacioCentre,BorderLayout.CENTER);

        WestCentre.add(SeparacioCentreWest);
        CentrePanellCentre.add(WestCentre,BorderLayout.WEST);
        CentrePanellCentre.add(ResteCentre,BorderLayout.CENTER);
        WestCentre.add(SombrejatWest);



        /*Bores*/
        NordPanellCentre.add(SeparacioPanellCentreNord);
        SudPanellCentre.add(SeparacioPanellCentreSud);
        SudPanellCentre.add(SombrejatSud, BorderLayout.CENTER);

        PanelCentre.add(NordPanellCentre,BorderLayout.NORTH);
        PanelCentre.add(CentrePanellCentre, BorderLayout.CENTER);
        PanelCentre.add(SudPanellCentre,BorderLayout.SOUTH);


        PosicioCentral.add(PartNort,BorderLayout.NORTH);
        PosicioCentral.add(PanelCentre,BorderLayout.CENTER);

        LateralEast.add(SeparacioLateralEast);
        LateralWest.add(SeparacioLateralWest);
        PanelCentralGeneral.add(LateralEast,BorderLayout.EAST);
        PanelCentralGeneral.add(LateralWest,BorderLayout.WEST);
        PanelCentralGeneral.add(PosicioCentral,BorderLayout.CENTER);



        /*Part Central*/
        PanellNordGeneral.add(EntreSeparacio4);
        PanellSudGeneral.add(EntreSeparacio5);
        PanellGeneralCentre.add(PanelCentralGeneral,BorderLayout.CENTER);
        PanellGeneralCentre.add(PanellSudGeneral,BorderLayout.SOUTH);
        PanellGeneralCentre.add(PanellNordGeneral,BorderLayout.NORTH);
        PanelMenu.add(PanellGeneralCentre,BorderLayout.CENTER);

        jFramePiano.setResizable(false);
        jFramePiano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFramePiano.getContentPane().add("Ref_1",PanelMenu);
        jFramePiano.setPreferredSize(new Dimension(1000,820));
        jFramePiano.pack();
        jFramePiano.setVisible(true);


    }

}
