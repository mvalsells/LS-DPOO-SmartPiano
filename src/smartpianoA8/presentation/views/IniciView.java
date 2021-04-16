package smartpianoA8.Presentation.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class IniciView extends JFrame {
    public IniciView(){
        configureMenu();
    }

    private void configureMenu(){
        JFrame jFrameMenu = new JFrame();
        jFrameMenu.setLayout(new CardLayout());

        /*Panell principal on anira imatge*/
        JPanel PanelMenu = new JPanel();
        PanelMenu.setBackground(Color.GRAY);
        PanelMenu.setLayout(new BorderLayout());

        /*-----------------------------------------PART NORD-----------------------------------------*/
        JPanel PanelLateral = new JPanel();
        //PanelLateral.setOpaque(true);
        PanelLateral.setBackground(Color.BLUE);
        PanelLateral.setLayout(new BorderLayout());

        /*Botons*/
        JPanel Botons = new JPanel(); //Panel per situar els botons del Nord a la dreta
        Botons.setOpaque(false);
        Botons.setLayout(new BoxLayout(Botons,BoxLayout.Y_AXIS));

        JButton BotoCanço = new JButton("Canciones");
        BotoCanço.setForeground(new Color(255,255,255));
        BotoCanço.setBackground(new Color(249,171,15));
        BotoCanço.setPreferredSize(new Dimension(84,50));
        BotoCanço.setBorderPainted(false);
        BotoCanço.setOpaque(true);
        BotoCanço.setVisible(true);

        JButton BotoPreferit = new JButton("Mis favoritas");
        BotoPreferit.setForeground(new Color(255,255,255));
        BotoPreferit.setBackground(new Color(249,171,15));
        BotoPreferit.setPreferredSize(new Dimension(85,50));
        BotoPreferit.setBorderPainted(false);
        BotoPreferit.setOpaque(true);
        BotoPreferit.setVisible(true);

        JButton BotoPiano = new JButton("Piano   ");
        BotoPiano.setForeground(new Color(255,255,255));
        BotoPiano.setBackground(new Color(249,171,15));
        BotoPiano.setPreferredSize(new Dimension(85,50));
        BotoPiano.setBorderPainted(false);
        BotoPiano.setOpaque(true);
        BotoPiano.setVisible(true);

        JButton BotoDescargar = new JButton("Descargar");
        BotoDescargar.setForeground(new Color(255,255,255));
        BotoDescargar.setBackground(new Color(249,171,15));
        BotoDescargar.setPreferredSize(new Dimension(85,50));
        BotoDescargar.setBorderPainted(false);
        BotoDescargar.setOpaque(true);
        BotoDescargar.setVisible(true);

        JButton BotoAjustes = new JButton("Ajustes");
        BotoAjustes.setForeground(new Color(255,255,255));
        BotoAjustes.setBackground(new Color(249,171,15));
        BotoAjustes.setPreferredSize(new Dimension(85,50));
        BotoAjustes.setBorderPainted(false);
        BotoAjustes.setOpaque(true);
        BotoAjustes.setVisible(true);

        /*-----------------------------------------PART CENTRAL-----------------------------------------*/
        /*Panell general centre*/
        JPanel PanellGeneralCentre = new JPanel();
        PanellGeneralCentre.setBackground(Color.PINK);
        PanellGeneralCentre.setLayout(new BorderLayout());

        /*Posicio Nord per separar*/
        JPanel SeparacioNord = new JPanel();
        SeparacioNord.setBackground(Color.RED);
        SeparacioNord.setLayout(new BorderLayout());

        JPanel SepaacioNord2 = new JPanel();
        SepaacioNord2.setBackground(Color.BLACK);
        SepaacioNord2.setLayout(new BorderLayout());

        JLabel MasEscuchadas = new JLabel("Mas escuchadas");
        MasEscuchadas.setForeground(new Color(255,255,255));
        MasEscuchadas.setPreferredSize(new Dimension(140,30));
        MasEscuchadas.setFont(new Font("Verdana", Font.BOLD, 15));

        //SeparacioNord.setLayout(new BorderLayout());

        JPanel CancionesMasEscuchadas = new JPanel();


        /*Creem borders per posicionar componetns*/
        LineBorder Separacio = new LineBorder(new Color(255,255,255),2);
        EmptyBorder TopSeparacio = new EmptyBorder(40,0,10,0);
        EmptyBorder EntreSeparacio = new EmptyBorder(500,0,10, 0);

        /*Creem labels per establir espais entre components*/
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
        EntreSeparacio3.setPreferredSize(new Dimension(5,340));
        EntreSeparacio3.setBorder(EntreSeparacio);

        JLabel EntreSeparacio4 = new JLabel();
        EntreSeparacio4.setPreferredSize(new Dimension(5,80));
        EntreSeparacio4.setBorder(EntreSeparacio);

        /*Packin' area*/
        /*Part Nord Botons*/
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
        SeparacioNord.add(SepaacioNord2, BorderLayout.SOUTH);
        SeparacioNord.add(EntreSeparacio4);

        PanellGeneralCentre.add(SeparacioNord,BorderLayout.NORTH);
        PanelMenu.add(PanellGeneralCentre,BorderLayout.CENTER);


        jFrameMenu.setResizable(false);
        jFrameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameMenu.getContentPane().add("Ref_1",PanelMenu);
        jFrameMenu.setPreferredSize(new Dimension(1000,820));
        jFrameMenu.pack();
        jFrameMenu.setVisible(true);

    }
}
