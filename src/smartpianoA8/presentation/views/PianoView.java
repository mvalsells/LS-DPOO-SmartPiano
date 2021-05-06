package smartpianoA8.presentation.views;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PianoView extends JFrame implements MouseListener, KeyListener {

    BordersView bordersView;
    final int OCTAVES = 8; // change as desired

    private final WhiteKey[] whites = new WhiteKey[7 * OCTAVES + 1];
    private final BlackKey[] blacks = new BlackKey[5 * OCTAVES];
    private final Eventos eventos = new Eventos();

    public PianoView(){
        bordersView = new BordersView();
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



    MidiChannel channel;

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOn(key.getNote(), 127);
    }

    public void mouseReleased(MouseEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOff(key.getNote(),127);
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key2 = e.getKeyCode();

        //WHITE KEYS
        if(key2 == KeyEvent.VK_A){
            channel.noteOn(48, 127);
        }
        if(key2 == KeyEvent.VK_B){
            channel.noteOn(50, 127);
        }
        if(key2 == KeyEvent.VK_C){
            channel.noteOn(52, 127);
        }
        if(key2 == KeyEvent.VK_D){
            channel.noteOn(53, 127);
        }
        if(key2 == KeyEvent.VK_E){
            channel.noteOn(55, 127);
        }
        if(key2 == KeyEvent.VK_F){
            channel.noteOn(57, 127);
        }
        if(key2 == KeyEvent.VK_G){
            channel.noteOn(59, 127);
        }
        if(key2 == KeyEvent.VK_H){
            channel.noteOn(60, 127);
        }
        if(key2 == KeyEvent.VK_I){
            channel.noteOn(62, 127);
        }
        if(key2 == KeyEvent.VK_J){
            channel.noteOn(64, 127);
        }
        if(key2 == KeyEvent.VK_K){
            channel.noteOn(65, 127);
        }
        if(key2 == KeyEvent.VK_L){
            channel.noteOn(67, 127);
        }
        if(key2 == KeyEvent.VK_M){
            channel.noteOn(69, 127);
        }
        if(key2 == KeyEvent.VK_N){
            channel.noteOn(71, 127);
        }
        if(key2 == KeyEvent.VK_O){
            channel.noteOn(72, 127);
        }
        if(key2 == KeyEvent.VK_P){
            channel.noteOn(74, 127);
        }
        if(key2 == KeyEvent.VK_Q){
            channel.noteOn(76, 127);
        }
        if(key2 == KeyEvent.VK_R){
            channel.noteOn(77, 127);
        }
        if(key2 == KeyEvent.VK_S){
            channel.noteOn(79, 127);
        }

        //BLACK KEYS
        if(key2 == KeyEvent.VK_0){
            channel.noteOn(49, 127);
        }
        if(key2 == KeyEvent.VK_1){
            channel.noteOn(51, 127);
        }
        if(key2 == KeyEvent.VK_2){
            channel.noteOn(54, 127);
        }
        if(key2 == KeyEvent.VK_3){
            channel.noteOn(56, 127);
        }
        if(key2 == KeyEvent.VK_4){
            channel.noteOn(58, 127);
        }
        if(key2 == KeyEvent.VK_5){
            channel.noteOn(61, 127);
        }
        if(key2 == KeyEvent.VK_6){
            channel.noteOn(63, 127);
        }
        if(key2 == KeyEvent.VK_7){
            channel.noteOn(66, 127);
        }
        if(key2 == KeyEvent.VK_8){
            channel.noteOn(68, 127);
        }
        if(key2 == KeyEvent.VK_9){
            channel.noteOn(70, 127);
        }
        if(key2 == KeyEvent.VK_ALT+58){
            channel.noteOn(73, 127);
        }
        if(key2 == KeyEvent.VK_ALT+59){
            channel.noteOn(75, 127);
        }
        if(key2 == KeyEvent.VK_ALT+60){
            channel.noteOn(78, 127);
        }



       
    }

    public void keyReleased(KeyEvent e) {
        /*Key key2 = (Key) e.getSource();
        channel.noteOff(key2.getNote());*7

         */
        int key2 = e.getKeyCode();

        //WHITE KEYS
        if(key2 == KeyEvent.VK_A){
            channel.noteOff(48, 127);
        }
        if(key2 == KeyEvent.VK_B){
            channel.noteOff(50, 127);
        }
        if(key2 == KeyEvent.VK_C){
            channel.noteOff(52, 127);
        }
        if(key2 == KeyEvent.VK_D){
            channel.noteOff(53, 127);
        }
        if(key2 == KeyEvent.VK_E){
            channel.noteOff(55, 127);
        }
        if(key2 == KeyEvent.VK_F){
            channel.noteOff(57, 127);
        }
        if(key2 == KeyEvent.VK_G){
            channel.noteOff(59, 127);
        }
        if(key2 == KeyEvent.VK_H){
            channel.noteOff(60, 127);
        }
        if(key2 == KeyEvent.VK_I){
            channel.noteOff(62, 127);
        }
        if(key2 == KeyEvent.VK_J){
            channel.noteOff(64, 127);
        }
        if(key2 == KeyEvent.VK_K){
            channel.noteOff(65, 127);
        }
        if(key2 == KeyEvent.VK_L){
            channel.noteOff(67, 127);
        }
        if(key2 == KeyEvent.VK_M){
            channel.noteOff(69, 127);
        }
        if(key2 == KeyEvent.VK_N){
            channel.noteOff(71, 127);
        }
        if(key2 == KeyEvent.VK_O){
            channel.noteOff(72, 127);
        }
        if(key2 == KeyEvent.VK_P){
            channel.noteOff(74, 127);
        }
        if(key2 == KeyEvent.VK_Q){
            channel.noteOff(76, 127);
        }
        if(key2 == KeyEvent.VK_R){
            channel.noteOff(77, 127);
        }
        if(key2 == KeyEvent.VK_S){
            channel.noteOff(79, 127);
        }

        //BLACK KEYS
        if(key2 == KeyEvent.VK_0){
            channel.noteOff(49, 127);
        }
        if(key2 == KeyEvent.VK_1){
            channel.noteOff(51, 127);
        }
        if(key2 == KeyEvent.VK_2){
            channel.noteOff(54, 127);
        }
        if(key2 == KeyEvent.VK_3){
            channel.noteOff(56, 127);
        }
        if(key2 == KeyEvent.VK_4){
            channel.noteOff(58, 127);
        }
        if(key2 == KeyEvent.VK_5){
            channel.noteOff(61, 127);
        }
        if(key2 == KeyEvent.VK_6){
            channel.noteOff(63, 127);
        }
        if(key2 == KeyEvent.VK_7){
            channel.noteOff(66, 127);
        }
        if(key2 == KeyEvent.VK_8){
            channel.noteOff(68, 127);
        }
        if(key2 == KeyEvent.VK_9){
            channel.noteOff(70, 127);
        }
        if(key2 == KeyEvent.VK_ALT+58){
            channel.noteOff(73, 127);
        }
        if(key2 == KeyEvent.VK_ALT+59){
            channel.noteOff(75, 127);
        }
        if(key2 == KeyEvent.VK_ALT+60){
            channel.noteOff(78, 127);
        }
    }








    private void configurePiano(){

        smartpianoA8.presentation.views.ImageView SombrejatSud = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesMenu/SombrejatSud.jpg").getImage());

        smartpianoA8.presentation.views.ImageView SombrejatWest = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesMenu/SombrejatWest.png").getImage());
        smartpianoA8.presentation.views.ImageView Desplegable = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesMenu/Captura de pantalla 2021-04-18 a las 19.jpg").getImage());
        ImageIcon canciones = new ImageIcon("Imagen/ImagenesMenu/Canciones.png");
        ImageIcon cancionesSelect = new ImageIcon("Imagen/ImagenesMenu/CancionesSelect.jpg");
        ImageIcon misFavoritas = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritas.jpg");
        ImageIcon misFavoritasSelect = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritasSelect.jpg");
        ImageIcon piano = new ImageIcon("Imagen/ImagenesMenu/Piano.jpg");
        ImageIcon pianoSelect = new ImageIcon("Imagen/ImagenesMenu/PianoSelect.jpg");
        ImageIcon descargar = new ImageIcon("Imagen/ImagenesMenu/Descargas.jpg");
        ImageIcon ajustes = new ImageIcon("Imagen/ImagenesMenu/Ajustes.jpg");
        ImageIcon botoRegPiano = new ImageIcon("Imagen/ImagenesMenu/RegButton.jpg");
        ImageIcon botoRegPianoPressed = new ImageIcon("Imagen/ImagenesMenu/RegButtonPressed.jpg");
        ImageIcon botoTriangleInferior = new ImageIcon("Imagen/ImagenesMenu/TriangleInferior.png");
        ImageIcon botoTriangleSuperior = new ImageIcon("Imagen/ImagenesMenu/TriangleSuperior.png");
        ImageIcon botoRodaReal = new ImageIcon("Imagen/ImagenesMenu/BotoRodaReal.png");
        ImageIcon botoRodaMax = new ImageIcon("Imagen/ImagenesMenu/BotoRodaMax.png");
        ImageIcon pantallaPiano = new ImageIcon("Imagen/ImagenesMenu/PanellPiano.png");



        JFrame jFramePiano = new JFrame();
        jFramePiano.setLayout(new CardLayout());

        JPanel panelMenu = new JPanel();

        //JPanel Pro = new JPanel();
        panelMenu.setBackground(new Color(211,216,221));
        panelMenu.setLayout(new BorderLayout());

        /*-----------------------------------------PART WEST-----------------------------------------*/
        JPanel panelLateral = new JPanel();
        //panelLateral.setOpaque(true);
        panelLateral.setBackground(new Color(20,22,33));
        panelLateral.setLayout(new BorderLayout());

        /*Botons*/
        JPanel botons = new JPanel(); //Panel per situar els botons del Nord a la dreta
        botons.setOpaque(false);
        botons.setLayout(new BoxLayout(botons,BoxLayout.Y_AXIS));

        JButton botoCanço = new JButton();
        //BotoCanço.setForeground(new Color(255,255,255));
        botoCanço.setAlignmentY(SwingConstants.RIGHT);
        botoCanço.setBackground(new Color(20,22,33));
        botoCanço.setPreferredSize(new Dimension(68,68));
        botoCanço.setBorder(bordersView.getGoogleButtonBorder());
        botoCanço.setBorderPainted(true);
        botoCanço.setIcon(canciones);
        botoCanço.setPressedIcon(cancionesSelect);

        JButton botoPreferit = new JButton();
        //botoPreferit.setForeground(new Color(255,255,255));
        botoPreferit.setBackground(new Color(20,22,33));
        botoPreferit.setPreferredSize(new Dimension(68,68));
        botoPreferit.setBorder(bordersView.getGoogleButtonBorder());
        botoPreferit.setBorderPainted(true);
        botoPreferit.setIcon(misFavoritas);
        botoPreferit.setPressedIcon(misFavoritasSelect);

        JButton botoPiano = new JButton();
        //botoPiano.setForeground(new Color(255,255,255));
        botoPiano.setBackground(new Color(20,22,33));
        botoPiano.setPreferredSize(new Dimension(68,68));
        botoPiano.setBorder(bordersView.getGoogleButtonBorder());
        botoPiano.setBorderPainted(true);
        botoPiano.setIcon(piano);
        botoPiano.setPressedIcon(pianoSelect);

        JButton botoDescargar = new JButton();
        //botoDescargar.setForeground(new Color(255,255,255));
        botoDescargar.setBackground(new Color(20,22,33));
        botoDescargar.setPreferredSize(new Dimension(68,68));
        botoDescargar.setBorderPainted(true);
        botoDescargar.setIcon(descargar);
        botoDescargar.setBorder(bordersView.getGoogleButtonBorder());


        JButton botoAjustes = new JButton();
        //botoAjustes.setForeground(new Color(255,255,255));
        botoAjustes.setBackground(new Color(20,22,33));
        botoAjustes.setPreferredSize(new Dimension(68,68));
        botoAjustes.setBorderPainted(true);
        botoAjustes.setBorder(bordersView.getGoogleButtonBorder());
        botoAjustes.setIcon(ajustes);


        /*-----------------------------------------PART CENTRE-----------------------------------------*/
        /*Panell general centre*/
        JPanel panellGeneralCentre = new JPanel();
        panellGeneralCentre.setBackground(Color.PINK);
        panellGeneralCentre.setLayout(new BorderLayout());

        JPanel panellNordGeneral = new JPanel();
        panellNordGeneral.setBackground(new Color(211,216,221));

        JPanel panellSudGeneral = new JPanel();
        panellSudGeneral.setBackground(new Color(211,216,221));

        JPanel panelCentralGeneral = new JPanel();
        panelCentralGeneral.setBackground(Color.CYAN);
        panelCentralGeneral.setLayout(new BorderLayout());

        /* Panell borders piano*/
        JPanel lateralWest =  new JPanel();
        lateralWest.setBackground(new Color(31,26,26));

        JPanel lateralEast = new JPanel();
        lateralEast.setBackground(new Color(31,26,26));

        JPanel posicioCentral= new JPanel();
        posicioCentral.setBackground(Color.green);
        posicioCentral.setLayout(new BorderLayout());

        JPanel partNord = new JPanel();
        partNord.setBackground(Color.CYAN);

        JPanel panelCentre = new JPanel();
        panelCentre.setBackground(Color.PINK);
        panelCentre.setLayout(new BorderLayout());

        JPanel nordPanellCentre = new JPanel();
        nordPanellCentre.setBackground(Color.GREEN);
        nordPanellCentre.setLayout(new BorderLayout());

        JPanel centrePanellCentre = new JPanel();
        centrePanellCentre.setBackground(Color.GRAY);
        centrePanellCentre.setLayout(new BorderLayout());

        JPanel sudPanellCentre = new JPanel();
        sudPanellCentre.setBackground(Color.YELLOW);
        sudPanellCentre.setLayout(new BorderLayout());

        /*Part central piano*/

        JPanel westCentre = new JPanel();
        westCentre.setBackground(Color.PINK );
        westCentre.setLayout(new BorderLayout());

        JPanel resteCentre = new JPanel();
        resteCentre.setBackground(Color.YELLOW);
        resteCentre.setLayout(new BorderLayout());

        JPanel resteCentreNord = new JPanel();
        resteCentreNord.setBackground(new Color(43,43,44));

        JPanel continuacioCentre = new JPanel();
        continuacioCentre.setBackground(Color.orange);
        continuacioCentre.setLayout(new BorderLayout());

        JPanel eastCentre = new JPanel();
        eastCentre.setBackground(new Color(50,51,51));

        JPanel teclat = new JPanel(null){
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
        teclat.setBackground(Color.BLACK);
        //teclat.addKeyListener(this);
        char lletresBlack = '0';
        for (int i = 0; i < blacks.length; i++) {
            blacks[i] = new BlackKey(i);

            if(lletresBlack < 'a'){
               blacks[i].setText(String.valueOf(lletresBlack));
                lletresBlack++;

            }else {
                lletresBlack = '0';
                blacks[i].setText(String.valueOf(lletresBlack));
            }
            blacks[i].setForeground(Color.WHITE);
            blacks[i].setFont(new Font("Verdana", Font.PLAIN, 6));
            teclat.add(blacks[i]);

            blacks[i].addKeyListener( this);
            blacks[i].addMouseListener( this);


        }

        char lletresWhite = 'a';
        for (int i = 0; i < whites.length; i++) {

            whites[i] = new WhiteKey(i);
            if(lletresWhite < 'z'){
                //whites[i].setAlignmentX(0);
                whites[i].setText(String.valueOf(lletresWhite));

                lletresWhite ++;
            }else {
                lletresWhite = 'a';
                whites[i].setText(String.valueOf(lletresWhite));
            }

            whites[i].addMouseListener(this);
            whites[i].addKeyListener(this);
            teclat.add(whites[i]);

        }

        JPanel bordrePiano = new JPanel();
        bordrePiano.setBackground(Color.BLACK);

        /* Botons Piano*/

        JPanel separacioBotoWest = new JPanel();
        separacioBotoWest.setBackground(Color.PINK);
        separacioBotoWest.setLayout(new BorderLayout());

        JPanel separacioBotoCentre = new JPanel();
        separacioBotoCentre.setBackground(Color.darkGray);
        //separacioBotoCentre.setOpaque(true);
        //separacioBotoCentre.setBorder(new LineBorder(new Color(0,155,255),20));
        ImageView pantallaPianoPanel = new ImageView(pantallaPiano.getImage());


        JPanel separacioBotoEast = new JPanel();
        separacioBotoEast.setBackground(Color.MAGENTA);
        separacioBotoEast.setLayout(new BorderLayout());

        /*Botons Piano West*/
        /*West piano West*/
        JPanel westBotoPianoWest = new JPanel();
        westBotoPianoWest.setBackground(Color.darkGray);
        westBotoPianoWest.setLayout(new BorderLayout());

        /*West*/
        JButton regButton = new JButton();
        regButton.setIcon(botoRegPiano);
        regButton.setPressedIcon(botoRegPianoPressed);
        regButton.setPreferredSize(new Dimension(38,44));
        regButton.setBorder(BorderFactory.createEmptyBorder(0,10,25,0));
        regButton.setContentAreaFilled(false);
        /*East*/
        JButton playButton = new JButton();
        playButton.setIcon(botoRegPiano);
        playButton.setPressedIcon(botoRegPianoPressed);
        playButton.setPreferredSize(new Dimension(38,44));
        playButton.setBorder(BorderFactory.createEmptyBorder(0,0,25,10));
        playButton.setContentAreaFilled(false);
        /*North*/
        JPanel panellTextBotonsWestWest = new JPanel();
        panellTextBotonsWestWest.setOpaque(false);
        panellTextBotonsWestWest.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel textBotonsWest = new JLabel("REG  -  PLAY");
        textBotonsWest.setBorder(BorderFactory.createEmptyBorder(20,5,5,5));
        textBotonsWest.setFont(new Font("Arial",Font.PLAIN,12));
        textBotonsWest.setForeground(new Color(255,255,255));
        textBotonsWest.setBackground(Color.darkGray);

        /*Centre piano West*/
        JPanel centerBotoPianoWest = new JPanel();
        centerBotoPianoWest.setBackground(Color.darkGray);

        /*East piano West*/
        JPanel eastBotoPianoWest = new JPanel();
        eastBotoPianoWest.setLayout(new BorderLayout());
        eastBotoPianoWest.setBackground(Color.darkGray);

        /*North*/
        JPanel panellTextBotonsNorthWest = new JPanel();
        panellTextBotonsNorthWest.setOpaque(false);
        panellTextBotonsNorthWest.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel textBotonsNorth = new JLabel("NOTAS - TIPO");
        textBotonsNorth.setBorder(BorderFactory.createEmptyBorder(20,5,5,5));
        textBotonsNorth.setFont(new Font("Arial",Font.PLAIN,12));
        textBotonsNorth.setForeground(new Color(255,255,255));
        textBotonsNorth.setBackground(Color.darkGray);

        /*West*/
        JButton notesButton = new JButton();
        notesButton.setIcon(botoRegPiano);
        notesButton.setPressedIcon(botoRegPianoPressed);
        notesButton.setPreferredSize(new Dimension(38,44));
        notesButton.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        notesButton.setContentAreaFilled(false);

        /*East*/
        JButton tipoButton = new JButton();
        tipoButton.setIcon(botoRodaReal);
        tipoButton.setPressedIcon(botoRodaMax);
        tipoButton.setPreferredSize(new Dimension(38,44));
        tipoButton.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        tipoButton.setContentAreaFilled(false);

        /*North*/
        JPanel panellTextBotonsSouthWest = new JPanel();
        panellTextBotonsSouthWest.setOpaque(false);
        panellTextBotonsSouthWest.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel textBotonsSouth = new JLabel("MAX - REAL");
        textBotonsSouth.setBorder(BorderFactory.createEmptyBorder(0,50,5,0));
        textBotonsSouth.setFont(new Font("Arial",Font.PLAIN,12));
        textBotonsSouth.setForeground(new Color(255,255,255));
        textBotonsSouth.setBackground(Color.darkGray);


        /*Botons Piano East*/
        /*West piano East*/
        JPanel westBotoPianoEast = new JPanel();
        westBotoPianoEast.setLayout(new BoxLayout(westBotoPianoEast,BoxLayout.Y_AXIS));
        westBotoPianoEast.setBackground(Color.darkGray);

        JLabel textBotonCançonsEast = new JLabel("CANCIONES");
        textBotonCançonsEast.setBorder(BorderFactory.createEmptyBorder(25,5,5,25));
        textBotonCançonsEast.setFont(new Font("Arial",Font.PLAIN,12));
        textBotonCançonsEast.setForeground(new Color(255,255,255));
        textBotonCançonsEast.setBackground(Color.darkGray);

        JButton cançonsButton = new JButton();
        cançonsButton.setIcon(botoRegPiano);
        cançonsButton.setPressedIcon(botoRegPianoPressed);
        cançonsButton.setPreferredSize(new Dimension(38,44));
        cançonsButton.setBorder(BorderFactory.createEmptyBorder(10,25,0,25));
        cançonsButton.setContentAreaFilled(false);


        /*Center piano East*/
        JPanel centerBotoPianoEast = new JPanel();
        centerBotoPianoEast.setLayout(new BoxLayout(centerBotoPianoEast,BoxLayout.Y_AXIS));
        centerBotoPianoEast.setBackground(Color.darkGray);
        /*Up*/
        JButton triangelSuperiorButton = new JButton();
        triangelSuperiorButton.setIcon(botoTriangleSuperior);
        triangelSuperiorButton.setPreferredSize(new Dimension(38,44));
        triangelSuperiorButton.setBorder(BorderFactory.createEmptyBorder(25,5,5,5));
        triangelSuperiorButton.setContentAreaFilled(false);
        /*Center*/
        JLabel textCentreTriangles = new JLabel("TEMPO");
        textCentreTriangles.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        textCentreTriangles.setFont(new Font("Arial",Font.PLAIN,12));
        textCentreTriangles.setForeground(new Color(255,255,255));
        textCentreTriangles.setBackground(Color.darkGray);
        /*Down*/
        JButton triangelInferiorButton = new JButton();
        triangelInferiorButton.setIcon(botoTriangleInferior);
        triangelInferiorButton.setPreferredSize(new Dimension(38,44));
        triangelInferiorButton.setBorder(BorderFactory.createEmptyBorder(5,5,0,5));
        triangelInferiorButton.setContentAreaFilled(false);



        /*East piano East*/
        JPanel eastBotoPianoEast = new JPanel();
        eastBotoPianoEast.setLayout(new BorderLayout());
        eastBotoPianoEast.setBackground(Color.darkGray);

        JButton metroButton = new JButton();
        metroButton.setIcon(botoRegPiano);
        metroButton.setPressedIcon(botoRegPianoPressed);
        metroButton.setPreferredSize(new Dimension(38,44));
        metroButton.setBorder(BorderFactory.createEmptyBorder(0,0,25,0));
        metroButton.setContentAreaFilled(false);
        /*East*/
        JButton escalaButton = new JButton();
        escalaButton.setIcon(botoRegPiano);
        escalaButton.setPressedIcon(botoRegPianoPressed);
        escalaButton.setPreferredSize(new Dimension(38,44));
        escalaButton.setBorder(BorderFactory.createEmptyBorder(0,0,25,0));
        escalaButton.setContentAreaFilled(false);
        /*North*/
        JPanel panellTextBotonsEast = new JPanel();
        panellTextBotonsEast.setOpaque(false);
        panellTextBotonsEast.setLayout(new FlowLayout(FlowLayout.CENTER));

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
        LineBorder separacio = new LineBorder(new Color(255,255,255),2);
        EmptyBorder topSeparacio = new EmptyBorder(40,0,10,0);
        EmptyBorder entreSeparacio02 = new EmptyBorder(40,0,500, 0);
        EmptyBorder entreSeparacio03 = new EmptyBorder(0,0,0, 400);

        JLabel topSeparacio0 = new JLabel();
        topSeparacio0.setPreferredSize(new Dimension(5,27));
        topSeparacio0.setBorder(BorderFactory.createEmptyBorder(40,0,10,0));

        JLabel entreSeparacio0 = new JLabel();
        entreSeparacio0.setPreferredSize(new Dimension(5,40));
        entreSeparacio0.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel entreSeparacio1 = new JLabel();
        entreSeparacio1.setPreferredSize(new Dimension(5,40));
        entreSeparacio1.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel entreSeparacio2 = new JLabel();
        entreSeparacio2.setPreferredSize(new Dimension(5,40));
        entreSeparacio2.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel entreSeparacio3 = new JLabel();
        entreSeparacio3.setPreferredSize(new Dimension(5,300));
        entreSeparacio3.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel entreSeparacio4 = new JLabel();
        entreSeparacio4.setPreferredSize(new Dimension(5,150));
        entreSeparacio4.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel entreSeparacio5 = new JLabel();
        entreSeparacio5.setPreferredSize(new Dimension(5,200));
        entreSeparacio5.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioLateralWest = new JLabel();
        separacioLateralWest.setPreferredSize(new Dimension(25,0));
        separacioLateralWest.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioLateralEast = new JLabel();
        separacioLateralEast.setPreferredSize(new Dimension(25,0));
        separacioLateralEast.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioPanellCentreNord = new JLabel();
        separacioPanellCentreNord.setPreferredSize(new Dimension(5,140));
        separacioPanellCentreNord.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioPanellCentreSud = new JLabel();
        separacioPanellCentreSud.setPreferredSize(new Dimension(5,28));
        separacioPanellCentreSud.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioCentreWest= new JLabel();
        separacioCentreWest.setPreferredSize(new Dimension(50,0));
        separacioCentreWest.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioCentreEast= new JLabel();
        separacioCentreEast.setPreferredSize(new Dimension(40,0));
        separacioCentreEast.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioRestaCentreNord = new JLabel();
        separacioRestaCentreNord.setPreferredSize(new Dimension(0,32));
        separacioRestaCentreNord.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioPosBotoWest = new JLabel();
        separacioPosBotoWest.setPreferredSize(new Dimension(280,0));
        separacioPosBotoWest.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioPosBotoEast = new JLabel();
        separacioPosBotoEast.setPreferredSize(new Dimension(280,0));
        separacioPosBotoEast.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioEastBotoWest = new JLabel();
        separacioEastBotoWest.setPreferredSize(new Dimension(200,0));
        separacioEastBotoWest.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));

        JLabel separacioWestBotoWest = new JLabel();
        separacioWestBotoWest.setPreferredSize(new Dimension(200,0));
        separacioWestBotoWest.setBorder(BorderFactory.createEmptyBorder(500,0,10, 0));











        /*Packin' area*/
        /*Part West Botons*/
        botons.add(topSeparacio0);
        botons.add(botoCanço);
        botons.add(entreSeparacio0);
        botons.add(botoPreferit);
        botons.add(entreSeparacio1);
        botons.add(botoPiano);
        botons.add(entreSeparacio2);
        botons.add(botoDescargar);
        botons.add(entreSeparacio3);
        botons.add(botoAjustes);
        panelLateral.add(botons,BorderLayout.NORTH);
        panelMenu.add(panelLateral,BorderLayout.WEST);

        /*Part Piano*/
        /*Botons*/
        /*Botons Piano East*/
        panellTextBotonsEast.add(textBotonEscalaEast);
        panellTextBotonsEast.add(textBotoMetroEast);
        eastBotoPianoEast.add(panellTextBotonsEast,BorderLayout.NORTH);
        eastBotoPianoEast.add(escalaButton,BorderLayout.WEST);
        eastBotoPianoEast.add(metroButton,BorderLayout.EAST);

        centerBotoPianoEast.add(triangelSuperiorButton);
        centerBotoPianoEast.add(textCentreTriangles);
        centerBotoPianoEast.add(triangelInferiorButton);

        westBotoPianoEast.add(textBotonCançonsEast);
        westBotoPianoEast.add(cançonsButton);

        //EastBotoPianoEast.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));
        //WestBotoPianoEast.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
        //CenterBotoPianoEast.setBorder(BorderFactory.createEmptyBorder(0,0,0,60));
        separacioBotoEast.add(westBotoPianoEast,BorderLayout.WEST);
        separacioBotoEast.add(centerBotoPianoEast,BorderLayout.CENTER);
        separacioBotoEast.add(eastBotoPianoEast,BorderLayout.EAST);

        /*Botons Piano West*/
        westBotoPianoWest.add(regButton,BorderLayout.WEST);
        westBotoPianoWest.add(playButton,BorderLayout.EAST);
        panellTextBotonsWestWest.add(textBotonsWest);
        westBotoPianoWest.add(panellTextBotonsWestWest,BorderLayout.NORTH);

        panellTextBotonsNorthWest.add(textBotonsNorth);
        panellTextBotonsSouthWest.add(textBotonsSouth);
        eastBotoPianoWest.add(panellTextBotonsNorthWest,BorderLayout.NORTH);
        eastBotoPianoWest.add(notesButton,BorderLayout.WEST);
        eastBotoPianoWest.add(panellTextBotonsSouthWest,BorderLayout.SOUTH);
        eastBotoPianoWest.add(tipoButton);

        //EastBotoPianoWest.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));
        //WestBotoPianoWest.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
        centerBotoPianoWest.setBorder(BorderFactory.createEmptyBorder(0,0,0,60));
        separacioBotoWest.add(westBotoPianoWest,BorderLayout.WEST);
        separacioBotoWest.add(centerBotoPianoWest,BorderLayout.CENTER);
        separacioBotoWest.add(eastBotoPianoWest,BorderLayout.EAST);

        separacioBotoEast.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        separacioBotoWest.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        separacioBotoCentre.setBorder(BorderFactory.createEmptyBorder(22,0,0,0));

        separacioBotoCentre.add(pantallaPianoPanel);
        //NordPanellCentre.add(pantallaPianoPanel,BorderLayout.CENTER);

        nordPanellCentre.add(separacioBotoWest,BorderLayout.WEST);
        nordPanellCentre.add(separacioBotoCentre,BorderLayout.CENTER);
        nordPanellCentre.add(separacioBotoEast,BorderLayout.EAST);

        /*Centre Piano*/
        eastCentre.add(separacioCentreEast);
        continuacioCentre.add(eastCentre,BorderLayout.EAST);
        continuacioCentre.add(teclat,BorderLayout.CENTER);

        resteCentreNord.add(separacioRestaCentreNord);
        resteCentre.add(resteCentreNord,BorderLayout.NORTH);
        resteCentre.add(continuacioCentre,BorderLayout.CENTER);

        westCentre.add(separacioCentreWest);
        centrePanellCentre.add(westCentre,BorderLayout.WEST);
        centrePanellCentre.add(resteCentre,BorderLayout.CENTER);
        westCentre.add(SombrejatWest);



        /*Bores*/
        //SeparacioPanellCentreNord.add(SeparacioBotoCentre);
        //NordPanellCentre.add(SeparacioPanellCentreNord);
        sudPanellCentre.add(separacioPanellCentreSud);
        sudPanellCentre.add(SombrejatSud, BorderLayout.CENTER);

        panelCentre.add(nordPanellCentre,BorderLayout.NORTH);
        panelCentre.add(centrePanellCentre, BorderLayout.CENTER);
        panelCentre.add(sudPanellCentre,BorderLayout.SOUTH);


        posicioCentral.add(partNord,BorderLayout.NORTH);
        posicioCentral.add(panelCentre,BorderLayout.CENTER);

        lateralEast.add(separacioLateralEast);
        lateralWest.add(separacioLateralWest);
        panelCentralGeneral.add(lateralEast,BorderLayout.EAST);
        panelCentralGeneral.add(lateralWest,BorderLayout.WEST);
        panelCentralGeneral.add(posicioCentral,BorderLayout.CENTER);



        /*Part Central*/
        panellNordGeneral.add(entreSeparacio4);
        panellSudGeneral.add(entreSeparacio5);
        panellGeneralCentre.add(panelCentralGeneral,BorderLayout.CENTER);
        panellGeneralCentre.add(panellSudGeneral,BorderLayout.SOUTH);
        panellGeneralCentre.add(panellNordGeneral,BorderLayout.NORTH);
        panelMenu.add(panellGeneralCentre,BorderLayout.CENTER);

        jFramePiano.setResizable(true);
        jFramePiano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFramePiano.getContentPane().add("Ref_1",panelMenu);
        jFramePiano.setPreferredSize(new Dimension(1000,820));
        jFramePiano.pack();
        jFramePiano.setVisible(true);


    }



}
