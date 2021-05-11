package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.presentation.views.BlackKey;
import smartpianoA8.presentation.views.WhiteKey;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class JPPiano extends JPanel {
    final int OCTAVES = 3;
    private final WhiteKey[] whites = new WhiteKey[7 * OCTAVES + 1];
    private final BlackKey[] blacks = new BlackKey[5 * OCTAVES];

    public static final String startRecording = "startRecording";

    private JButton regButton;

    public JPPiano() {

        ImageView sombrejatSud = new ImageView(new ImageIcon("Imagen/ImagenesMenu/SombrejatSud.jpg").getImage());
        ImageIcon botoRodaReal = new ImageIcon("Imagen/ImagenesMenu/BotoRodaReal.png");
        ImageIcon botoRodaMax = new ImageIcon("Imagen/ImagenesMenu/BotoRodaMax.png");
        ImageIcon pantallaPiano = new ImageIcon("Imagen/ImagenesMenu/PanellPiano.png");
        ImageIcon botoTriangleInferior = new ImageIcon("Imagen/ImagenesMenu/TriangleInferior.png");
        ImageIcon botoTriangleSuperior = new ImageIcon("Imagen/ImagenesMenu/TriangleSuperior.png");
        ImageView sombrejatWest = new ImageView(new ImageIcon("Imagen/ImagenesMenu/SombrejatWest.png").getImage());

        /* Panell borders piano*/
        setLayout(new BorderLayout());
        JPanel lateralWest =  new JPanel();
        lateralWest.setBackground(new Color(31,26,26));

        JPanel lateralEast = new JPanel();
        lateralEast.setBackground(new Color(31,26,26));

        JPanel posicioCentral= new JPanel();
        posicioCentral.setBackground(Color.green);
        posicioCentral.setLayout(new BorderLayout());

        JPanel partNord = new JPanel();
        partNord.setBackground(Color.GRAY);

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
        regButton = new JBPianoButton();
        regButton.setActionCommand(startRecording);

        /*East*/
        JButton playButton = new JBPianoButton();

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
        JLabel textBotonsNorth = new JTPianoButtonText( 20, 5, 5, 5);
        textBotonsNorth.setText("NOTAS - TIPO");

        /*West*/
        JButton notesButton = new JBPianoButton();


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
        JLabel textBotonsSouth = new JTPianoButtonText(0,50,5,0);
        textBotonsSouth.setText("MAX - REAL");


        /*Botons Piano East*/
        /*West piano East*/
        JPanel westBotoPianoEast = new JPanel();
        westBotoPianoEast.setLayout(new BoxLayout(westBotoPianoEast,BoxLayout.Y_AXIS));
        westBotoPianoEast.setBackground(Color.darkGray);

        JLabel textBotonCançonsEast = new JTPianoButtonText(25,5,5,25);
        textBotonCançonsEast.setText("CANCIONES");

        JButton cançonsButton = new JBPianoButton();


        /*Center piano East*/
        JPanel centerBotoPianoEast = new JPanel();
        centerBotoPianoEast.setLayout(new BoxLayout(centerBotoPianoEast,BoxLayout.Y_AXIS));
        centerBotoPianoEast.setBackground(Color.darkGray);
        /*Up*/
        JButton triangelSuperiorButton = new JButton();
        triangelSuperiorButton.setIcon(botoTriangleSuperior);
        triangelSuperiorButton.setPreferredSize(new Dimension(38,44));
        triangelSuperiorButton.setBorder(BorderFactory.createEmptyBorder(25,5,5,15));
        triangelSuperiorButton.setContentAreaFilled(false);
        /*Center*/
        JLabel textCentreTriangles = new JTPianoButtonText(5,5,5,5);
        textCentreTriangles.setText("TEMPO");


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

        JButton metroButton = new JBPianoButton();

        /*East*/
        JButton escalaButton = new JBPianoButton();

        /*North*/
        JPanel panellTextBotonsEast = new JPanel();
        panellTextBotonsEast.setOpaque(false);
        panellTextBotonsEast.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel textBotoMetroEast = new JTPianoButtonText(20,8,5,0);
        textBotoMetroEast.setText("METRO");

        JLabel textBotonEscalaEast = new JTPianoButtonText(20,0,5,8);
        textBotonEscalaEast.setText("ESCALA");


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
        westCentre.add(sombrejatWest);



        /*Bores*/
        //SombrejatSud.getScaledInsance(1250,48 ,Image.SCALE_SMOOTH);
        sudPanellCentre.add(separacioPanellCentreSud);
        //sombrejatSud.setImg(pantallaPiano.getImage());
        sombrejatSud.setImgSize(1080,48);
        sudPanellCentre.add(sombrejatSud, BorderLayout.CENTER);

        panelCentre.add(nordPanellCentre,BorderLayout.NORTH);
        panelCentre.add(centrePanellCentre, BorderLayout.CENTER);
        panelCentre.add(sudPanellCentre,BorderLayout.SOUTH);


        posicioCentral.add(partNord,BorderLayout.NORTH);
        posicioCentral.add(panelCentre,BorderLayout.CENTER);

        lateralEast.add(separacioLateralEast);
        lateralWest.add(separacioLateralWest);
        add(lateralEast,BorderLayout.EAST);
        add(lateralWest,BorderLayout.WEST);
        add(posicioCentral,BorderLayout.CENTER);
    }

    public void setPressedIcon(){
        regButton.setIcon(new ImageIcon("Imagen/ImagenesMenu/RegButtonPressed.jpg"));
    }
    public void setUnpressedIcon(){
        regButton.setIcon(new ImageIcon("Imagen/ImagenesMenu/RegButton.jpg"));
    }

    public void registerController(ActionListener controller, KeyListener keyListener, MouseListener mouseListener){

        regButton.addActionListener(controller);

        for (int i = 0; i < blacks.length; i++){
            blacks[i].addKeyListener(keyListener);
            blacks[i].addMouseListener(mouseListener);
        }
        for (int i = 0; i < whites.length; i++){
            whites[i].addKeyListener(keyListener);
            whites[i].addMouseListener(mouseListener);
        }
    }
}
