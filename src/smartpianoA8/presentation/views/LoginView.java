package smartpianoA8.Presentation.views;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class LoginView extends JFrame {

    private static JLabel backgroundImage;

    public LoginView() {
        runLogin();
    }

    private void runLogin() {

        JFrame frame = new JFrame();
        frame.setLayout(new CardLayout());


        /*Panell principal on anira imatge*/
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(new BorderLayout());

        /*-----------------------------------------PART SUPERIOR-----------------------------------------*/
        /*Panell secundari Nord*/
        JPanel PartSuperior = new JPanel();
        PartSuperior.setBackground(Color.BLACK);
        PartSuperior.setPreferredSize(new Dimension(140,100));
        PartSuperior.setLayout(new BorderLayout());


        /*------------------------------------------PART CENTRAL------------------------------------------*/

        /*Extra*/
        JPanel OmplirEstPanel = new JPanel();
        //OmplirEstPanel.setBackground(new Color(101,58,156));
        OmplirEstPanel.setLayout(new BoxLayout(OmplirEstPanel,BoxLayout.Y_AXIS));

        LineBorder OmplirEstBorder = new LineBorder(new Color(0,0,0,1),85);
        JLabel OmplirEstLabel = new JLabel();
        OmplirEstLabel.setMinimumSize(new Dimension(200,300));
        OmplirEstLabel.setBorder(OmplirEstBorder);

        JPanel OmplirOestPanel = new JPanel();
        //OmplirOestPanel.setBackground(new Color(101,58,156));
        OmplirOestPanel.setLayout(new BoxLayout(OmplirOestPanel,BoxLayout.Y_AXIS));

        LineBorder OmplirOestBorder = new LineBorder(new Color(0,0,0,1),85);
        JLabel OmplirOestLabel = new JLabel();
        OmplirOestLabel.setMinimumSize(new Dimension(200,300));
        OmplirOestLabel.setBorder(OmplirOestBorder);

        /*Panell secundari Central*/
        JPanel PartCentral = new JPanel();
        //PartCentral.setBackground(new Color(102,178,255));
        PartCentral.setLayout(new BorderLayout());


        /*-------------Part Centre-Nord-------------*/

        //Por si no se quiere texto
        /*JPanel parteSubSuperior = new JPanel();
        parteSubSuperior.setBackground(Color.GRAY);
        parteSubSuperior.setPreferredSize(new Dimension(300,100));
        parteSubSuperior.setLayout(new BorderLayout());*/

        //Pôr si se quiere con texto
        JLabel Titular = new JLabel("Inicie sesion con una cuenta de usuario");
        Titular.setPreferredSize(new Dimension(300,100));
        Titular.setFont(new Font("Verdana", Font.PLAIN, 30));
        EmptyBorder TitularBorder = new EmptyBorder(50,15,0,0);
        Titular.setBorder(TitularBorder);

        /*-------------Part Centre-Est-------------*/
        JPanel PanelRegistre = new JPanel();
        //PanelRegistre.setBackground(new Color(178,102,255));
        PanelRegistre.setLayout(new BoxLayout(PanelRegistre,BoxLayout.Y_AXIS));

        /*Creem borders per posicionar componetns*/
        LineBorder TextFieldBorder = new LineBorder(new Color(255,255,255),2);
        EmptyBorder TopTextFieldBorder = new EmptyBorder(150,0,10,0);
        EmptyBorder EntreTextFieldBorder = new EmptyBorder(10,0,10, 0);
        EmptyBorder EntreTextFieldBorder2 = new EmptyBorder(3,0,2, 0);
        /*Creem labels per establir espais entre components*/
        JLabel TopTextFieldLabel0 = new JLabel();
        TopTextFieldLabel0.setPreferredSize(new Dimension(5,20));
        TopTextFieldLabel0.setBorder(TopTextFieldBorder);

        JLabel EntreTextFieldLabel0 = new JLabel();
        EntreTextFieldLabel0.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel0.setBorder(EntreTextFieldBorder);

        JLabel EntreTextFieldLabel1 = new JLabel();
        EntreTextFieldLabel1.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel1.setBorder(EntreTextFieldBorder);

        JLabel EntreTextFieldLabel2 = new JLabel();
        EntreTextFieldLabel2.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel2.setBorder(EntreTextFieldBorder);

        JLabel EntreTextFieldLabel3 = new JLabel();
        EntreTextFieldLabel3.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel3.setBorder(EntreTextFieldBorder2);

        JLabel EntreTextFieldLabel4 = new JLabel();
        EntreTextFieldLabel4.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel4.setBorder(EntreTextFieldBorder2);

        /*Creem les zones per escriure*/
        JTextField Nom = new JTextField("Nombre",20);
        Nom.setMaximumSize(new Dimension(230,40));
        Nom.setForeground(new Color(255,255,255));
        Nom.setBorder(TextFieldBorder);
        Nom.setOpaque(false);

        JTextField Correu = new JTextField("Correo",20);
        Correu.setMaximumSize(new Dimension(220,40));
        Correu.setForeground(new Color(255,255,255));
        Correu.setBorder(TextFieldBorder);
        Correu.setOpaque(false);

        JTextField Contrasenya = new JTextField("Contraseña",20);
        Contrasenya.setMaximumSize(new Dimension(220,40));
        Contrasenya.setForeground(new Color(255,255,255));
        Contrasenya.setBorder(TextFieldBorder);
        Contrasenya.setOpaque(false);

        JButton loginBurron = new JButton("Iniciar Sesion");
        loginBurron.setPreferredSize(new Dimension(270,50));
        //FaceBookButton.setBackground(new Color(0,0,255));
        //FaceBookButton.setForeground(new Color(255,255,255));
        loginBurron.setMaximumSize(new Dimension(220,45));

        JLabel noCuenta = new JLabel("¿Aún no tienes cuenta?");
        noCuenta.setPreferredSize(new Dimension(5,20));
        noCuenta.setFont(new Font("Verdana", Font.PLAIN, 8));

        JButton passwordforgotten = new JButton("¿Has olvidado la contraseña?");
        passwordforgotten.setFont(new Font("Verdana", Font.PLAIN, 8));
        passwordforgotten.setBorderPainted(false);
        passwordforgotten.setFocusPainted(false);
        passwordforgotten.setContentAreaFilled(false);

        /*-------------Part Centre-Oest-------------*/
        JPanel PanelAccounts = new JPanel();
        //PanelAccounts.setBackground(new Color(178,102,255));
        PanelAccounts.setLayout(new BoxLayout(PanelAccounts,BoxLayout.Y_AXIS));

        /*Creem borders per posicionar componetns*/
        EmptyBorder TopButtonBorder = new EmptyBorder(150,0,10,0);
        EmptyBorder EntreButtonBorder = new EmptyBorder(7,10,7, 0);
        /*Creem labels per establir espais entre components*/
        JLabel TopButtonLabel = new JLabel();
        TopButtonLabel.setPreferredSize(new Dimension(5,20));
        TopButtonLabel.setBorder(TopButtonBorder);

        JLabel EntreButtonLabel = new JLabel();
        EntreButtonLabel.setPreferredSize(new Dimension(5,20));
        EntreButtonLabel.setBorder(EntreButtonBorder);




        /*Botons*/
        JButton FaceBookButton = new JButton("FACEBOOK");
        FaceBookButton.setPreferredSize(new Dimension(270,50));
        //FaceBookButton.setBackground(new Color(0,0,255));
        //FaceBookButton.setForeground(new Color(255,255,255));
        FaceBookButton.setMaximumSize(new Dimension(220,45));


        JButton GoogleButton = new JButton("Google");
        GoogleButton.setPreferredSize(new Dimension(270,50));
        //GoogleButton.setBackground(new Color(255,0,0));
        //GoogleButton.setForeground(new Color(255,255,255));
        GoogleButton.setMaximumSize(new Dimension(220,45));







        /*Packin' area*/
        /*Part Superior*/
        //PartSuperior.add(OmplirEstPartSuperior);
        panel.add(PartSuperior,BorderLayout.NORTH);

        /*Part Central*/
        panel.add(PartCentral,BorderLayout.CENTER);

        /*Nord*/
        //PartCentral.add(parteSubSuperior,BorderLayout.NORTH);
        PartCentral.add(Titular,BorderLayout.NORTH);

        /*Est*/
        PanelRegistre.add(TopTextFieldLabel0);
        PanelRegistre.add(Nom);
        PanelRegistre.add(EntreTextFieldLabel0);
        PanelRegistre.add(Correu);
        PanelRegistre.add(EntreTextFieldLabel1);
        PanelRegistre.add(Contrasenya);
        PanelRegistre.add(EntreTextFieldLabel2);
        PanelRegistre.add(loginBurron);
        PanelRegistre.add(EntreTextFieldLabel3);
        PanelRegistre.add(noCuenta);
        PanelRegistre.add(EntreTextFieldLabel4);
        PanelRegistre.add(passwordforgotten);
        //PanelRegistre.add(noCuenta);
        PartCentral.add(PanelRegistre, BorderLayout.EAST);
        /*Oest*/
        PanelAccounts.add(TopButtonLabel);
        PanelAccounts.add(FaceBookButton);
        PanelAccounts.add(EntreButtonLabel);
        PanelAccounts.add(GoogleButton);
        //nelAccounts.add(EntreButtonLabel);
        //PanelAccounts.add(EntreButtonLabel);
        PartCentral.add(PanelAccounts,BorderLayout.WEST);
        /*Part Dreta*/
        OmplirEstPanel.add(OmplirEstLabel);
        panel.add(OmplirEstPanel,BorderLayout.EAST);
        /*Part Esquerra*/
        OmplirOestPanel.add(OmplirOestLabel);
        panel.add(OmplirOestPanel,BorderLayout.WEST);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add("Ref_1",panel);
        frame.setPreferredSize(new Dimension(1000,820));
        frame.pack();
        frame.setVisible(true);


    }

}
