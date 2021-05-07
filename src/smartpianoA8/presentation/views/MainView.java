package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel {

    private BordersView bordersView;
    public MainView(){
        bordersView = new BordersView();
        menuLateral();
    }

    private void menuLateral(){


        // ---- START ImageIcon ----
        ImageIcon canciones = new ImageIcon("Imagen/ImagenesMenu/Canciones.png");
        ImageIcon cancionesSelect = new ImageIcon("Imagen/ImagenesMenu/CancionesSelect.jpg");
        ImageIcon misFavoritas = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritas.jpg");
        ImageIcon misFavoritasSelect = new ImageIcon("Imagen/ImagenesMenu/Mis_favoritasSelect.jpg");
        ImageIcon piano = new ImageIcon("Imagen/ImagenesMenu/Piano.jpg");
        ImageIcon pianoSelect = new ImageIcon("Imagen/ImagenesMenu/PianoSelect.jpg");
        ImageIcon ajustes = new ImageIcon("Imagen/ImagenesMenu/Ajustes.jpg");
        ImageIcon botoRegPiano = new ImageIcon("Imagen/ImagenesMenu/RegButton.jpg");
        ImageIcon botoRegPianoPressed = new ImageIcon("Imagen/ImagenesMenu/RegButtonPressed.jpg");
        // ---- END ImageIcon ----


        JFrame jFramePiano = new JFrame();
        jFramePiano.setLayout(new CardLayout());

        JPanel panelMenu = new JPanel();

        panelMenu.setBackground(new Color(211,216,221));
        panelMenu.setLayout(new BorderLayout());

        /*-----------------------------------------PART WEST-----------------------------------------*/
        JPanel panelLateral = new JPanel();
        //panelLateral.setOpaque(true);
        panelLateral.setBackground(new Color(20,22,33));
        panelLateral.setLayout(new BorderLayout());

        /*Botons*/
        JPanel navBarNorth = new JPanel(); //Panel per situar els botons del Nord a la dreta
        navBarNorth.setOpaque(false);
        navBarNorth.setLayout(new BoxLayout(navBarNorth,BoxLayout.Y_AXIS));

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


        JButton botoAjustes = new JButton();
        //botoAjustes.setForeground(new Color(255,255,255));
        botoAjustes.setBackground(new Color(20,22,33));
        botoAjustes.setPreferredSize(new Dimension(68,68));
        botoAjustes.setBorderPainted(true);
        botoAjustes.setBorder(bordersView.getGoogleButtonBorder());
        botoAjustes.setIcon(ajustes);


        /*-----------------------------------------PART CENTRE-----------------------------------------*/





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


        /*Packin' area*/
        /*Part West Botons*/
        navBarNorth.add(topSeparacio0);
        navBarNorth.add(botoCanço);
        navBarNorth.add(entreSeparacio0);
        navBarNorth.add(botoPreferit);
        navBarNorth.add(entreSeparacio1);
        navBarNorth.add(botoPiano);
        navBarNorth.add(entreSeparacio2);
        navBarNorth.add(entreSeparacio3);
        navBarNorth.add(botoAjustes);
        panelLateral.add(navBarNorth,BorderLayout.NORTH);
        panelMenu.add(panelLateral,BorderLayout.WEST);


        jFramePiano.setResizable(true);
        jFramePiano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFramePiano.getContentPane().add("Ref_1",panelMenu);
        jFramePiano.setPreferredSize(new Dimension(1000,820));
        jFramePiano.pack();
        jFramePiano.setVisible(true);


    }

}