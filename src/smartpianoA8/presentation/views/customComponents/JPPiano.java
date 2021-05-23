package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
/**
 *
 * Esta clase se encarga principalmente de mostrar el panel interactivo asociado al piano, aquí se le asignara no solamente
 * el panel general donde el piano esta incluido, sino que además, incluye los register controller al igual que las funciones las cuales pasan
 * la información de que tecla ha sido pulsada.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */

public class JPPiano extends JPanel {

    public static int OCTAVES = 3;
    private final WhiteKey[] whites = new WhiteKey[7 * OCTAVES + 1];
    private final BlackKey[] blacks = new BlackKey[5 * OCTAVES];

    public static final String START_RECORDING = "startRecording";
    public static final String PLAY_BUTTON = "startPlaying";
    public static final String NOTES_BUTTON = "notesButton";

    private JButton regButton;
    private JButton playButton;
    private JButton notesButton;

    /**
     * Constructor donde contiene todos los paneles de la clase piano.
     */
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
        for (int i = 0; i < blacks.length; i++) {
            blacks[i] = new BlackKey(i);
            teclat.add(blacks[i]);

        }
        for (int i = 0; i < whites.length; i++) {

            whites[i] = new WhiteKey(i);

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
        regButton.setActionCommand(START_RECORDING);

        /*East*/
        playButton = new JBPianoButton();
        playButton.setActionCommand(PLAY_BUTTON);

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
        textBotonsNorth.setText("     NOTAS");

        /*West*/
        notesButton = new JBPianoButton();
        notesButton.setActionCommand(NOTES_BUTTON);


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
        //panellTextBotonsSouthWest.add(textBotonsSouth);
        eastBotoPianoWest.add(panellTextBotonsNorthWest,BorderLayout.NORTH);
        eastBotoPianoWest.add(notesButton,BorderLayout.CENTER);
        //eastBotoPianoWest.add(panellTextBotonsSouthWest,BorderLayout.SOUTH);
        //eastBotoPianoWest.add(tipoButton);

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
        //sombrejatSud.setImgSize(1080,48);
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

    }// Cierre del constructor

    public void repaintAllTeclas(){

        for(int i = 0;i<whites.length-1;i++){
            whites[i].desclicarNota();
        }

        for(int i = 0;i<blacks.length-1;i++){
            blacks[i].desclicarNota();
            //blacks[i].requestFocusInWindow();
        }

    }

    /**
     * Método que envia el nuevo icono cuando el boton de reg es pulsado.
     * @param button boton asignado que cambiara el icono.
     */
    public void setPressedIcon(JButton button){
        button.setIcon(new ImageIcon("Imagen/ImagenesMenu/RegButtonPressed.jpg"));
    }//Cierre del método

    /**
     * Método que envia el icono cuando el boton de reg vuelve a ser pulsado.
     * @param button boton asignado que cambiara el icono.
     */
    public void setUnpressedIcon(JButton button){
        button.setIcon(new ImageIcon("Imagen/ImagenesMenu/RegButton.jpg"));
    }//Cierre del método

    public void setPlayButtonPressedIcon(){playButton.setIcon(new ImageIcon("Imagen/ImagenesMenu/RegButtonPressed.jpg"));}
    public void setPlayButtonUnpressedIcon(){playButton.setIcon(new ImageIcon("Imagen/ImagenesMenu/RegButton.jpg"));}

    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param controller controlador asocioado a los botones.
     * @param keyListener controlador asociado a las teclas del ordenador.
     * @param mouseListener controlador asociado al ratón.
     */

    public void registerController(ActionListener controller, KeyListener keyListener, MouseListener mouseListener){

        regButton.addActionListener(controller);
        playButton.addActionListener(controller);
        notesButton.addActionListener(controller);

        for (BlackKey black : blacks) {
            black.addKeyListener(keyListener);
            black.addMouseListener(mouseListener);
        }
        for (WhiteKey white : whites) {
            white.addKeyListener(keyListener);
            white.addMouseListener(mouseListener);
        }
    }//Cierre del método

    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param controller controlador asocioado a los botones.
     * @param mouseListener controlador asociado al ratón.
     */

    public void registerController(ActionListener controller, MouseListener mouseListener){

        regButton.addActionListener(controller);
        playButton.addActionListener(controller);
        notesButton.addActionListener(controller);

        for (BlackKey black : blacks) {
            black.addMouseListener(mouseListener);
        }
        for (WhiteKey white : whites) {
            white.addMouseListener(mouseListener);
        }
    }//Cierre del método

    /**
     * Método que encia la posición del array de blancas, de la tecla seleccionada.
     * @param note posición del array de blancas, de la tecla seleccionada.
     */
    public void pintarTeclaBlanca(int note){
        whites[note].clicarNota();
    }//Cierre del metodo

    /**
     * Método para resaltar las teclas negras cuando las blancas son pintadas. Le pasamos el valor de la tecla blanca asi sabemos que nregra resaltar.
     * @param nota
     */
    public void repainAllBlacks(int nota){
        switch (nota){

            case 0:
                blacks[0].requestFocusInWindow();
                break;
            case 1:
                blacks[0].requestFocusInWindow();
                blacks[1].requestFocusInWindow();
                break;
            case 2:
                blacks[1].requestFocusInWindow();
                break;
            case 3:
                blacks[2].requestFocusInWindow();
                break;
            case 4:
                blacks[2].requestFocusInWindow();
                blacks[3].requestFocusInWindow();
                break;
            case 5:
                blacks[3].requestFocusInWindow();
                blacks[4].requestFocusInWindow();
                break;
            case 6:
                blacks[4].requestFocusInWindow();
                break;
            case 7:
                blacks[5].requestFocusInWindow();
                break;
            case 8:
                blacks[5].requestFocusInWindow();
                blacks[6].requestFocusInWindow();
                break;
            case 9:
                blacks[6].requestFocusInWindow();
                break;
            case 10:
                blacks[7].requestFocusInWindow();
                break;
            case 11:
                blacks[7].requestFocusInWindow();
                blacks[8].requestFocusInWindow();
                break;
            case 12:
                blacks[8].requestFocusInWindow();
                blacks[9].requestFocusInWindow();
                break;
            case 13:
                blacks[9].requestFocusInWindow();
                break;
            case 14:
                blacks[10].requestFocusInWindow();
                break;
            case 15:
                blacks[10].requestFocusInWindow();
                blacks[11].requestFocusInWindow();
                break;
            case 16:
                blacks[11].requestFocusInWindow();
                break;
            case 17:
                blacks[12].requestFocusInWindow();
                break;
            case 18:
                blacks[12].requestFocusInWindow();
                blacks[13].requestFocusInWindow();
                break;
            case 19:
                blacks[13].requestFocusInWindow();
                blacks[14].requestFocusInWindow();
                break;
            case 20:
                blacks[14].requestFocusInWindow();
                break;

        }
    }
    /**
     * Método que encia la posición del array de blancas, de la tecla seleccionada.
     * @param note posición del array de blancas, de la tecla seleccionada.
     */
    public void despintarTeclaNegra(int note){
        blacks[note].desclicarNota();
    }//Cierre del metodo

    /**
     * Método que encia la posición del array de blancas, de la tecla seleccionada.
     * @param note posición del array de blancas, de la tecla seleccionada.
     */
    public void despintarTeclaBlanca(int note){
        whites[note].desclicarNota();
    }//Cierre del metodo

    /**
     * Método que encia la posición del array de blancas, de la tecla seleccionada.
     * @param note posición del array de blancas, de la tecla seleccionada.
     */
    public void pintarTeclaNegra(int note){
        blacks[note].clicarNota();
    }//Cierre del metodo
}//Cierre de la classe
