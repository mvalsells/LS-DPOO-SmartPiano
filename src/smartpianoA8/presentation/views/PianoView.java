package smartpianoA8.presentation.views;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PianoView extends JFrame implements MouseListener, KeyListener {

    public PianoView(){
        configurePiano();
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            synth.loadAllInstruments(synth.getDefaultSoundbank());
            Instrument[] insts = synth.getLoadedInstruments();
            MidiChannel channels[] = synth.getChannels();
            for (int i = 0; i < channels.length; i++) {
                if (channels[i] != null) {
                    channel = channels[i];
                    break;
                }
            }

            for (int i = 0; i < insts.length; i++) {
                if (insts[i].toString()
                        .startsWith("Instrument MidiPiano")) {
                    channel.programChange(i);
                    break;
                }
            }
        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    BordersView bordersView = new BordersView();
    final int OCTAVES = 8; // change as desired

    private final WhiteKey[] whites = new WhiteKey[7 * OCTAVES + 1];
    private final BlackKey[] blacks = new BlackKey[5 * OCTAVES];
    private final Eventos eventos = new Eventos();


    MidiChannel channel;

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOn(key.getNote(), 127);
    }

    public void mouseReleased(MouseEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOff(key.getNote());
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOn(key.getNote(), 127);
    }

    public void keyReleased(KeyEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOff(key.getNote());
    }








    private void configurePiano(){

        smartpianoA8.presentation.views.ImageView SombrejatSud = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesMenu/SombrejatSud.jpg").getImage());

        smartpianoA8.presentation.views.ImageView SombrejatWest = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesMenu/SombrejatWest.png").getImage());
        smartpianoA8.presentation.views.ImageView Desplegable = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesMenu/Captura de pantalla 2021-04-18 a las 19.jpg").getImage());
        ImageIcon Canciones = new ImageIcon("Imagen/ImagenesMenu/Canciones.png");
        ImageIcon CancionesSelect = new ImageIcon("Imagen/ImagenesMenu/CancionesSelect.jpg");
        ImageIcon Mis_Favoritas = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritas.jpg");
        ImageIcon Mis_FavoritasSelect = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritasSelect.jpg");
        ImageIcon Piano = new ImageIcon("Imagen/ImagenesMenu/Piano.jpg");
        ImageIcon PianoSelect = new ImageIcon("Imagen/ImagenesMenu/PianoSelect.jpg");
        ImageIcon Descargar = new ImageIcon("Imagen/ImagenesMenu/Descargas.jpg");
        ImageIcon Ajustes = new ImageIcon("Imagen/ImagenesMenu/Ajustes.jpg");
        ImageIcon BotoRegPiano = new ImageIcon("Imagen/ImagenesMenu/RegButton.jpg");
        ImageIcon BotoRegPianoPressed = new ImageIcon("Imagen/ImagenesMenu/RegButtonPressed.jpg");





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
        BotoCanço.setAlignmentY(SwingConstants.RIGHT);
        BotoCanço.setBackground(new Color(20,22,33));
        BotoCanço.setPreferredSize(new Dimension(68,68));
        BotoCanço.setBorder(bordersView.getGoogleButtonBorder());
        BotoCanço.setBorderPainted(true);
        BotoCanço.setIcon(Canciones);
        BotoCanço.setPressedIcon(CancionesSelect);

        JButton BotoPreferit = new JButton();
        //BotoPreferit.setForeground(new Color(255,255,255));
        BotoPreferit.setBackground(new Color(20,22,33));
        BotoPreferit.setPreferredSize(new Dimension(68,68));
        BotoPreferit.setBorder(bordersView.getGoogleButtonBorder());
        BotoPreferit.setBorderPainted(true);
        BotoPreferit.setIcon(Mis_Favoritas);
        BotoPreferit.setPressedIcon(Mis_FavoritasSelect);

        JButton BotoPiano = new JButton();
        //BotoPiano.setForeground(new Color(255,255,255));
        BotoPiano.setBackground(new Color(20,22,33));
        BotoPiano.setPreferredSize(new Dimension(68,68));
        BotoPiano.setBorder(bordersView.getGoogleButtonBorder());
        BotoPiano.setBorderPainted(true);
        BotoPiano.setIcon(Piano);
        BotoPiano.setPressedIcon(PianoSelect);

        JButton BotoDescargar = new JButton();
        //BotoDescargar.setForeground(new Color(255,255,255));
        BotoDescargar.setBackground(new Color(20,22,33));
        BotoDescargar.setPreferredSize(new Dimension(68,68));
        BotoDescargar.setBorderPainted(true);
        BotoDescargar.setIcon(Descargar);
        BotoDescargar.setBorder(bordersView.getGoogleButtonBorder());


        JButton BotoAjustes = new JButton();
        //BotoAjustes.setForeground(new Color(255,255,255));
        BotoAjustes.setBackground(new Color(20,22,33));
        BotoAjustes.setPreferredSize(new Dimension(68,68));
        BotoAjustes.setBorderPainted(true);
        BotoAjustes.setBorder(bordersView.getGoogleButtonBorder());
        BotoAjustes.setIcon(Ajustes);


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

        JPanel Teclat = new JPanel(null){
            @Override
            public Dimension getPreferredSize() {
                int count = getComponentCount();
                Component last = getComponent(count - 1);
                Rectangle bounds = last.getBounds();
                int width = 10 + bounds.x + bounds.width;
                int height = 10 + bounds.y + bounds.height;

                return new Dimension(width, height);
            }


        };
        Teclat.setBackground(Color.BLACK);

        for (int i = 0; i < blacks.length; i++) {
            blacks[i] = new BlackKey(i);
            blacks[i].setBackground(Color.BLACK);
            //blacks[i].setOpaque(true);
            //blacks[i].setContentAreaFilled(true);
            Teclat.add(blacks[i]);
            blacks[i].addMouseListener( this);
        }
        for (int i = 0; i < whites.length; i++) {
            whites[i] = new WhiteKey(i);
            Teclat.add(whites[i]);
            whites[i].addMouseListener(this);
            whites[i].addKeyListener(this);
        }

        JPanel BordrePiano = new JPanel();
        BordrePiano.setBackground(Color.BLACK);

        /* Botons Piano*/

        JPanel SeparacioBotoWest = new JPanel();
        SeparacioBotoWest.setBackground(Color.PINK);
        SeparacioBotoWest.setLayout(new BorderLayout());

        JPanel SeparacioBotoCentre = new JPanel();
        SeparacioBotoCentre.setBackground(Color.RED);
        //SeparacioBotoCentre.setOpaque(true);
        //SeparacioBotoCentre.setBorder(new LineBorder(new Color(0,155,255),20));

        JPanel SeparacioBotoEast = new JPanel();
        SeparacioBotoEast.setBackground(Color.MAGENTA);
        SeparacioBotoEast.setLayout(new BorderLayout());

        /*Botons Piano West*/

        JPanel WestBotoPianoWest = new JPanel();
        WestBotoPianoWest.setBackground(Color.darkGray);
        WestBotoPianoWest.setLayout(new BorderLayout());

        /*West*/
        JButton regButton = new JButton();
        regButton.setIcon(BotoRegPiano);
        regButton.setPressedIcon(BotoRegPianoPressed);
        regButton.setPreferredSize(new Dimension(38,44));
        regButton.setBorder(BorderFactory.createEmptyBorder(0,10,25,0));
        regButton.setContentAreaFilled(false);
        /*East*/
        JButton playButton = new JButton();
        playButton.setIcon(BotoRegPiano);
        playButton.setPressedIcon(BotoRegPianoPressed);
        playButton.setPreferredSize(new Dimension(38,44));
        playButton.setBorder(BorderFactory.createEmptyBorder(0,0,25,10));
        playButton.setContentAreaFilled(false);
        /*North*/
        JPanel PanellTextBotonsWest = new JPanel();
        PanellTextBotonsWest.setOpaque(false);
        PanellTextBotonsWest.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel textBotonsWest = new JLabel("REG  -  PLAY");
        textBotonsWest.setBorder(BorderFactory.createEmptyBorder(20,5,5,5));
        textBotonsWest.setFont(new Font("Arial",Font.PLAIN,12));
        textBotonsWest.setForeground(new Color(255,255,255));
        textBotonsWest.setBackground(Color.darkGray);


        JPanel CenterBotoPianoWest = new JPanel();
        CenterBotoPianoWest.setBackground(Color.white);

        JPanel EastBotoPianoWest = new JPanel();
        EastBotoPianoWest.setBackground(Color.BLUE);

        /*Botons Piano East*/

        JPanel WestBotoPianoEast = new JPanel();
        WestBotoPianoEast.setBackground(Color.green);


        JPanel CenterBotoPianoEast = new JPanel();
        CenterBotoPianoEast.setBackground(Color.white);

        /*East piano East*/
        JPanel EastBotoPianoEast = new JPanel();
        EastBotoPianoEast.setLayout(new BorderLayout());
        EastBotoPianoEast.setBackground(Color.darkGray);

        JButton metroButton = new JButton();
        metroButton.setIcon(BotoRegPiano);
        metroButton.setPressedIcon(BotoRegPianoPressed);
        metroButton.setPreferredSize(new Dimension(38,44));
        metroButton.setBorder(BorderFactory.createEmptyBorder(0,0,25,0));
        metroButton.setContentAreaFilled(false);
        /*East*/
        JButton escalaButton = new JButton();
        escalaButton.setIcon(BotoRegPiano);
        escalaButton.setPressedIcon(BotoRegPianoPressed);
        escalaButton.setPreferredSize(new Dimension(38,44));
        escalaButton.setBorder(BorderFactory.createEmptyBorder(0,0,25,0));
        escalaButton.setContentAreaFilled(false);
        /*North*/
        JPanel PanellTextBotonsEast = new JPanel();
        PanellTextBotonsEast.setOpaque(false);
        PanellTextBotonsEast.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel textBotoMetroEast = new JLabel("METRO");
        textBotoMetroEast.setBorder(BorderFactory.createEmptyBorder(20,8,5,0));
        textBotoMetroEast.setFont(new Font("Arial",Font.PLAIN,12));
        textBotoMetroEast.setForeground(new Color(255,255,255));
        textBotoMetroEast.setBackground(Color.darkGray);

        JLabel textBotonEscalaEast = new JLabel("ESCALA");
        textBotonEscalaEast.setBorder(BorderFactory.createEmptyBorder(20,0,5,8));
        textBotonEscalaEast.setFont(new Font("Arial",Font.PLAIN,12));
        textBotonEscalaEast.setForeground(new Color(255,255,255));
        textBotonEscalaEast.setBackground(Color.darkGray);





        /*Creem borders per posicionar componetns*/
        LineBorder Separacio = new LineBorder(new Color(255,255,255),2);
        EmptyBorder TopSeparacio = new EmptyBorder(40,0,10,0);
        EmptyBorder EntreSeparacio02 = new EmptyBorder(40,0,500, 0);
        EmptyBorder EntreSeparacio03 = new EmptyBorder(0,0,0, 400);

        JLabel TopSeparacio0 = new JLabel();
        TopSeparacio0.setPreferredSize(new Dimension(5,27));
        TopSeparacio0.setBorder(BorderFactory.createEmptyBorder(40,0,10,0));

        JLabel EntreSeparacio0 = new JLabel();
        EntreSeparacio0.setPreferredSize(new Dimension(5,40));
        EntreSeparacio0.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel EntreSeparacio1 = new JLabel();
        EntreSeparacio1.setPreferredSize(new Dimension(5,40));
        EntreSeparacio1.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel EntreSeparacio2 = new JLabel();
        EntreSeparacio2.setPreferredSize(new Dimension(5,40));
        EntreSeparacio2.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel EntreSeparacio3 = new JLabel();
        EntreSeparacio3.setPreferredSize(new Dimension(5,300));
        EntreSeparacio3.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel EntreSeparacio4 = new JLabel();
        EntreSeparacio4.setPreferredSize(new Dimension(5,150));
        EntreSeparacio4.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel EntreSeparacio5 = new JLabel();
        EntreSeparacio5.setPreferredSize(new Dimension(5,200));
        EntreSeparacio5.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioLateralWest = new JLabel();
        SeparacioLateralWest.setPreferredSize(new Dimension(25,0));
        SeparacioLateralWest.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioLateralEast = new JLabel();
        SeparacioLateralEast.setPreferredSize(new Dimension(25,0));
        SeparacioLateralEast.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioPanellCentreNord = new JLabel();
        SeparacioPanellCentreNord.setPreferredSize(new Dimension(5,140));
        SeparacioPanellCentreNord.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioPanellCentreSud = new JLabel();
        SeparacioPanellCentreSud.setPreferredSize(new Dimension(5,28));
        SeparacioPanellCentreSud.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioCentreWest= new JLabel();
        SeparacioCentreWest.setPreferredSize(new Dimension(50,0));
        SeparacioCentreWest.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioCentreEast= new JLabel();
        SeparacioCentreEast.setPreferredSize(new Dimension(40,0));
        SeparacioCentreEast.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioRestaCentreNord = new JLabel();
        SeparacioRestaCentreNord.setPreferredSize(new Dimension(0,32));
        SeparacioRestaCentreNord.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioPosBotoWest = new JLabel();
        SeparacioPosBotoWest.setPreferredSize(new Dimension(280,0));
        SeparacioPosBotoWest.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioPosBotoEast = new JLabel();
        SeparacioPosBotoEast.setPreferredSize(new Dimension(280,0));
        SeparacioPosBotoEast.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioEastBotoWest = new JLabel();
        SeparacioEastBotoWest.setPreferredSize(new Dimension(200,0));
        SeparacioEastBotoWest.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel SeparacioWestBotoWest = new JLabel();
        SeparacioWestBotoWest.setPreferredSize(new Dimension(200,0));
        SeparacioWestBotoWest.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));











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
        /*Botons Piano East*/
        PanellTextBotonsEast.add(textBotonEscalaEast);
        PanellTextBotonsEast.add(textBotoMetroEast);
        EastBotoPianoEast.add(PanellTextBotonsEast,BorderLayout.NORTH);
        EastBotoPianoEast.add(escalaButton,BorderLayout.WEST);
        EastBotoPianoEast.add(metroButton,BorderLayout.EAST);

        //EastBotoPianoEast.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));
        WestBotoPianoEast.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
        CenterBotoPianoEast.setBorder(BorderFactory.createEmptyBorder(0,0,0,60));
        SeparacioBotoEast.add(WestBotoPianoEast,BorderLayout.WEST);
        SeparacioBotoEast.add(CenterBotoPianoEast,BorderLayout.CENTER);
        SeparacioBotoEast.add(EastBotoPianoEast,BorderLayout.EAST);

        /*Botons Piano West*/
        WestBotoPianoWest.add(regButton,BorderLayout.WEST);
        WestBotoPianoWest.add(playButton,BorderLayout.EAST);
        PanellTextBotonsWest.add(textBotonsWest);
        WestBotoPianoWest.add(PanellTextBotonsWest,BorderLayout.NORTH);

        EastBotoPianoWest.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));
        //WestBotoPianoWest.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
        CenterBotoPianoWest.setBorder(BorderFactory.createEmptyBorder(0,0,0,60));
        SeparacioBotoWest.add(WestBotoPianoWest,BorderLayout.WEST);
        SeparacioBotoWest.add(CenterBotoPianoWest,BorderLayout.CENTER);
        SeparacioBotoWest.add(EastBotoPianoWest,BorderLayout.EAST);

        SeparacioBotoEast.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        SeparacioBotoWest.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        SeparacioBotoCentre.setBorder(BorderFactory.createEmptyBorder(120,0,0,0));

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
        //SeparacioPanellCentreNord.add(SeparacioBotoCentre);
        //NordPanellCentre.add(SeparacioPanellCentreNord);
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

        jFramePiano.setResizable(true);
        jFramePiano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFramePiano.getContentPane().add("Ref_1",PanelMenu);
        jFramePiano.setPreferredSize(new Dimension(1000,820));
        jFramePiano.pack();
        jFramePiano.setVisible(true);


    }



}
