package smartpianoA8.Presentation.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LoginView extends JFrame {

    private static JLabel backgroundImage;

    public LoginView() {
        runLogin();
    }

    private void runLogin() {

        ImageView panel = new ImageView(new ImageIcon("Imagen/LoginImage.jpg").getImage());
        ImageIcon facebook = new ImageIcon("Imagen/IniciarSesionFacebook.jpg");
        ImageIcon google = new ImageIcon("Imagen/IniciarSesionGoogle.jpg");
        ImageIcon googlePressed = new ImageIcon("Imagen/IniciarSesionGooglePressed.png");
        ImageIcon facebookPressed = new ImageIcon("Imagen/IniciarSesionFacebookPressed.png");

        /*JPanel CapaSuperior = new JPanel();
        JFrame frame = new JFrame();

        frame.setLayout(new CardLayout());

        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        CapaSuperior.setLayout(new BorderLayout());


        CapaSuperior.setOpaque(false);

        JButton reg = new JButton("REGISTRAR-SE");
        reg.setBackground(Color.orange);
        reg.setSize(100,30);
        reg.setVisible(true);

        CapaSuperior.add(reg,BorderLayout.EAST);
        panel.add(CapaSuperior,BorderLayout.CENTER);




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add("Ref_1",panel);
        frame.pack();
        frame.setVisible(true);
        */
        /*FRAME*/
        JFrame frame = new JFrame();
        frame.setLayout(new CardLayout());


        /*Panell principal on anira imatge*/
        //JPanel panel = new JPanel();
        //panel.setBackground(Color.GRAY);
        panel.setLayout(new BorderLayout());

        /*-----------------------------------------PART SUPERIOR-----------------------------------------*/
        /*Panell secundari Nord*/
        JPanel PartSuperior = new JPanel();
        PartSuperior.setOpaque(false);
        PartSuperior.setLayout(new BorderLayout());


        /*Panell auxiliar posicionament botons Nord*/
        JPanel PosicionamentBotonsNord = new JPanel(); //Panel per situar els botons del Nord a la dreta
        PosicionamentBotonsNord.setOpaque(false);
        PosicionamentBotonsNord.setLayout(new FlowLayout());

        /*Botons i textos nord*/
        JLabel JaTensCompte = new JLabel(" ");
        JaTensCompte.setForeground(new Color(255,255,255));
        JaTensCompte.setPreferredSize(new Dimension(140,100));
        JaTensCompte.setFont(new Font("Verdana", Font.PLAIN, 11));



        /*------------------------------------------PART CENTRAL------------------------------------------*/

        /*Extra*/
        JPanel OmplirEstPanel = new JPanel();
        OmplirEstPanel.setOpaque(false);
        //OmplirEstPanel.setBackground(new Color(101,58,156));
        OmplirEstPanel.setLayout(new BoxLayout(OmplirEstPanel,BoxLayout.Y_AXIS));

        LineBorder OmplirEstBorder = new LineBorder(new Color(0,0,0,1),100);
        JLabel OmplirEstLabel = new JLabel();
        OmplirEstLabel.setMinimumSize(new Dimension(200,300));
        OmplirEstLabel.setBorder(OmplirEstBorder);

        JPanel OmplirOestPanel = new JPanel();
        OmplirOestPanel.setOpaque(false);
        //OmplirOestPanel.setBackground(new Color(101,58,156));
        OmplirOestPanel.setLayout(new BoxLayout(OmplirOestPanel,BoxLayout.Y_AXIS));

        LineBorder OmplirOestBorder = new LineBorder(new Color(0,0,0,1),85);
        JLabel OmplirOestLabel = new JLabel();
        OmplirOestLabel.setMinimumSize(new Dimension(200,300));
        OmplirOestLabel.setBorder(OmplirOestBorder);

        /*Panell secundari Central*/
        JPanel PartCentral = new JPanel();
        PartCentral.setOpaque(false);
        //PartCentral.setBackground(new Color(102,178,255));
        PartCentral.setLayout(new BorderLayout());


        /*-------------Part Centre-Nord-------------*/
        /*Text*/
        JLabel Titular = new JLabel();
        Titular.setPreferredSize(new Dimension(300,100));
        /*Creem un border per posicionar el text*/
        EmptyBorder TitularBorder = new EmptyBorder(50,0,0,0);
        Titular.setBorder(TitularBorder);

        /*-------------Part Centre-Est-------------*/
        JPanel PanelRegistre = new JPanel();
        PanelRegistre.setOpaque(false);
        PanelRegistre.setLayout(new BoxLayout(PanelRegistre,BoxLayout.Y_AXIS));

        /*Creem borders per posicionar componetns*/
        LineBorder TextFieldBorder = new LineBorder(new Color(255,255,255),2);
        LineBorder ButtonTextBorder = new LineBorder(new Color(255,255,255,0),0);
        EmptyBorder TopTextFieldBorder = new EmptyBorder(150,0,10,0);
        EmptyBorder EntreTextFieldBorder = new EmptyBorder(10,0,10, 0);
        EmptyBorder EntreButtonButtonBorder = new EmptyBorder(0,0,10,0);
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

        JLabel EntreTextButtonLabel = new JLabel();
        EntreTextButtonLabel.setPreferredSize(new Dimension(5,20));
        EntreTextButtonLabel.setBorder(EntreTextFieldBorder);

        JLabel EntreButtonButtonLabel = new JLabel();
        EntreButtonButtonLabel.setPreferredSize(new Dimension(5,20));
        EntreButtonButtonLabel.setBorder(EntreButtonButtonBorder);

        /*Creem les zones per escriure*/
        JTextField Nom = new JTextField("Nom",20);
        Nom.setMaximumSize(new Dimension(281,39));
        Nom.setForeground(new Color(255,255,255));
        Nom.setBorder(TextFieldBorder);
        Nom.setOpaque(false);

        JTextField Correu = new JTextField("Correu",20);
        Correu.setMaximumSize(new Dimension(281,39));
        Correu.setForeground(new Color(255,255,255));
        Correu.setBorder(TextFieldBorder);
        Correu.setOpaque(false);

        JTextField Contrasenya = new JTextField("Contrasenya",20);
        Contrasenya.setMaximumSize(new Dimension(281,39));
        Contrasenya.setForeground(new Color(255,255,255));
        Contrasenya.setBorder(TextFieldBorder);
        Contrasenya.setOpaque(false);

        JButton IniciarSessioButton = new JButton("Iniciar sesion");
        IniciarSessioButton.setFont(new Font("Verdana",Font.BOLD,12));
        IniciarSessioButton.setForeground(new Color(255,255,255));
        IniciarSessioButton.setBackground(new Color(249,171,15));
        IniciarSessioButton.setPreferredSize(new Dimension(170,35));
        IniciarSessioButton.setBorderPainted(false);
        IniciarSessioButton.setOpaque(true);
        IniciarSessioButton.setVisible(true);

        JButton NoTensCompteButton = new JButton("¿Aun no tienes cuenta?");
        NoTensCompteButton.setHorizontalTextPosition(SwingConstants.LEFT);
        NoTensCompteButton.setFont(new Font("Verdana",Font.BOLD,8));
        NoTensCompteButton.setForeground(new Color(255,255,255));
        NoTensCompteButton.setBackground(new Color(249,171,15));
        NoTensCompteButton.setPreferredSize(new Dimension(120,25));
        NoTensCompteButton.setBorder(ButtonTextBorder);
        NoTensCompteButton.setOpaque(false);
        NoTensCompteButton.setVisible(true);

        /*JTextField RepetirContrasenya = new JTextField("Repetir Contrasenya",20);
        RepetirContrasenya.setMaximumSize(new Dimension(240,45));
        RepetirContrasenya.setForeground(new Color(255,255,255));
        RepetirContrasenya.setBorder(TextFieldBorder);
        RepetirContrasenya.setOpaque(false);*/

        /*-------------Part Centre-Oest-------------*/
        JPanel PanelAccounts = new JPanel();
        PanelAccounts.setOpaque(false);
        //anelAccounts.setBackground(new Color(178,102,255));
        PanelAccounts.setLayout(new BoxLayout(PanelAccounts,BoxLayout.Y_AXIS));

        /*Creem borders per posicionar componetns*/
        EmptyBorder TopButtonBorder = new EmptyBorder(175,0,10,0);
        EmptyBorder EntreButtonBorder = new EmptyBorder(7,10,7, 0);
        LineBorder ButtonLineBorder = new LineBorder(new Color(255,255,255,1),0);
        /*Creem labels per establir espais entre components*/
        JLabel TopButtonLabel = new JLabel();
        TopButtonLabel.setPreferredSize(new Dimension(5,20));
        TopButtonLabel.setBorder(TopButtonBorder);

        JLabel EntreButtonLabel = new JLabel();
        EntreButtonLabel.setPreferredSize(new Dimension(5,20));
        EntreButtonLabel.setBorder(EntreButtonBorder);

        /*Botons*/
        JButton FaceBookButton = new JButton();
        FaceBookButton.setPreferredSize(new Dimension(270,50));
        FaceBookButton.setMaximumSize(new Dimension(281,40));
        FaceBookButton.setBorder(ButtonLineBorder);
        FaceBookButton.setIcon(facebook);
        FaceBookButton.setPressedIcon(facebookPressed);



        JButton GoogleButton = new JButton();
        GoogleButton.setPreferredSize(new Dimension(270,50));
        GoogleButton.setMaximumSize(new Dimension(281,40));
        GoogleButton.setBorder(ButtonLineBorder);
        GoogleButton.setIcon(google);
        GoogleButton.setPressedIcon(googlePressed);

        JLabel JaTensCompte2 = new JLabel(" ");
        JaTensCompte2.setPreferredSize(new Dimension(140,395));
        JaTensCompte2.setFont(new Font("Verdana", Font.PLAIN, 228));
        JaTensCompte2.setOpaque(false);




        /*Packin' area*/
        /*Part Superior*/
        //PartSuperior.add(OmplirEstPartSuperior);
        PosicionamentBotonsNord.add(JaTensCompte);
        //PosicionamentBotonsNord.add(IniciarSessio);
        //PosicionamentBotonsNord.add(Espai);
        PartSuperior.add(PosicionamentBotonsNord,BorderLayout.EAST);
        panel.add(PartSuperior,BorderLayout.NORTH);

        /*Part Central*/
        panel.add(PartCentral,BorderLayout.CENTER);

        /*Nord*/
        PartCentral.add(Titular,BorderLayout.NORTH);

        /*Est*/
        PanelRegistre.add(TopTextFieldLabel0);
        PanelRegistre.add(Nom);
        PanelRegistre.add(EntreTextFieldLabel0);
        PanelRegistre.add(Correu);
        PanelRegistre.add(EntreTextFieldLabel1);
        PanelRegistre.add(Contrasenya);
        //PanelRegistre.add(EntreTextFieldLabel2);
        //PanelRegistre.add(RepetirContrasenya);
        PanelRegistre.add(EntreTextButtonLabel);
        //PanelRegistre.add(IniciarSessioButton);
        //PanelRegistre.add(EntreButtonButtonLabel);
        //PanelRegistre.add(NoTensCompteButton);
        PartCentral.add(PanelRegistre, BorderLayout.EAST);
        /*Oest*/
        PanelAccounts.add(TopButtonLabel);
        PanelAccounts.add(FaceBookButton);
        PanelAccounts.add(EntreButtonLabel);
        PanelAccounts.add(GoogleButton);
        //PanelAccounts.add(JaTensCompte2);
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
