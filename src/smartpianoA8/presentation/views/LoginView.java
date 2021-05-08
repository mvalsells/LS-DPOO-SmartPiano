package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JPanel  {

    public static final String toRegister = "toRegister";
    public static final String tryLogin = "tryLogin";

    private static JLabel backgroundImage;

    private JButton registrarse;//Canviat
    private JTextField nom;
    private JTextField correu;
    private JTextField contrasenya;
    private JButton loginButton;

    public  LoginView() {

    }

    public ImageView runLogin() {

        smartpianoA8.presentation.views.ImageView panel = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesLogin/LoginImage.jpg").getImage());
        ImageIcon facebook = new ImageIcon("Imagen/ImagenesLogin/IniciarSesionFacebook.jpg");
        ImageIcon google = new ImageIcon("Imagen/ImagenesLogin/IniciarSesionGoogle.jpg");
        ImageIcon googlePressed = new ImageIcon("Imagen/ImagenesLogin/IniciarSesionGooglePressed.png");
        ImageIcon facebookPressed = new ImageIcon("Imagen/ImagenesLogin/IniciarSesionFacebookPressed.png");

        BordersView bordersView = new BordersView();

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
        /*JFrame frame = new JFrame();
        frame.setLayout(new CardLayout());*/


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

        registrarse = new JButton("Registrarse");
        registrarse.setForeground(new Color(255,255,255));
        registrarse.setBackground(new Color(249,171,15));
        registrarse.setPreferredSize(new Dimension(130,35));
        registrarse.setBorderPainted(false);
        registrarse.setOpaque(true);
        registrarse.setVisible(true);
        registrarse.setActionCommand(toRegister);

        JLabel Espai = new JLabel(" ");
        Espai.setForeground(new Color(255,255,255));
        Espai.setPreferredSize(new Dimension(20,100));
        Espai.setFont(new Font("Verdana", Font.PLAIN, 11));

        /*Botons i textos nord*/
        JLabel JaTensCompte = new JLabel(" ");
        JaTensCompte.setForeground(new Color(255,255,255));
        JaTensCompte.setPreferredSize(new Dimension(140,100));
        JaTensCompte.setFont(new Font("Verdana", Font.PLAIN, 11));

        /*------------------------------------------PART INFERIOR------------------------------------------*/
        /*Extra(omplir south)*/
        JPanel PanelSouth = new JPanel();
        PanelSouth.setOpaque(false);
        //PanelSouth.setBackground(new Color(0,0,255));
        PanelSouth.setLayout(new BoxLayout(PanelSouth,BoxLayout.PAGE_AXIS));

        /*Boto register*/
        JLabel UpperButtonLabel = new JLabel();
        UpperButtonLabel.setPreferredSize(new Dimension(5,20));
        UpperButtonLabel.setBorder(bordersView.getLoginButtonBorder());

        JPanel PartInferior = new JPanel();
        PartInferior.setLayout(new BorderLayout());
        PartInferior.setOpaque(false);


        JPanel ComplementLogin = new JPanel();
        ComplementLogin.setLayout(new BoxLayout(ComplementLogin,BoxLayout.Y_AXIS));
        ComplementLogin.setOpaque(false);

        loginButton = new JButton("Iniciar sesion");
        //RegisterButton.setAlignmentX(Container.RIGHT_ALIGNMENT);
        loginButton.setPreferredSize(new Dimension(220,39));
        loginButton.setBackground(new Color(249,171,15));
        loginButton.setForeground(new Color(255,255,255));
        loginButton.setBorderPainted(true);
        loginButton.setBorder(bordersView.getLoginButtonBorder());
        //IniciarSessio.setBorderPainted(false);
        loginButton.setOpaque(true);
        loginButton.setFont(new Font("Verdana",Font.BOLD,12));
        loginButton.setVisible(true);
        loginButton.setActionCommand(tryLogin);



        JPanel OmplirSouthPrincipalPanel = new JPanel();
        OmplirSouthPrincipalPanel.setOpaque(false);
        //OmplirSouthPrincipalPanel.setBackground(new Color(101,58,156));
        OmplirSouthPrincipalPanel.setLayout(new BoxLayout(OmplirSouthPrincipalPanel,BoxLayout.Y_AXIS));


        JLabel OmplirSouthPrincipalLabel = new JLabel();
        OmplirSouthPrincipalLabel.setOpaque(false);
        OmplirSouthPrincipalLabel.setMinimumSize(new Dimension(200,300));
        OmplirSouthPrincipalLabel.setBorder(bordersView.getOmplirSouthPrincipalBorder());




        /*------------------------------------------PART CENTRAL------------------------------------------*/

        /*Extra*/
        JPanel OmplirEstPanel = new JPanel();
        OmplirEstPanel.setOpaque(false);
        //OmplirEstPanel.setBackground(new Color(101,58,156));
        OmplirEstPanel.setLayout(new BoxLayout(OmplirEstPanel,BoxLayout.Y_AXIS));

        JLabel OmplirEstLabel = new JLabel();
        OmplirEstLabel.setMinimumSize(new Dimension(200,300));
        OmplirEstLabel.setBorder(bordersView.getOmplirEstBorder());

        JPanel OmplirOestPanel = new JPanel();
        OmplirOestPanel.setOpaque(false);
        //OmplirOestPanel.setBackground(new Color(101,58,156));
        OmplirOestPanel.setLayout(new BoxLayout(OmplirOestPanel,BoxLayout.Y_AXIS));

        JLabel OmplirOestLabel = new JLabel();
        OmplirOestLabel.setMinimumSize(new Dimension(200,300));
        OmplirOestLabel.setBorder(bordersView.getOmplirOestBorder());

        /*Panell secundari Central*/
        JPanel PartCentral = new JPanel();
        PartCentral.setOpaque(false);
        //PartCentral.setBackground(new Color(102,178,255));
        PartCentral.setLayout(new BorderLayout());


        /*-------------Part Centre-Nord-------------*/
        /*Text*/

        /*-------------Part Centre-Est-------------*/
        JPanel PanelRegistre = new JPanel();
        PanelRegistre.setOpaque(false);
        PanelRegistre.setLayout(new BoxLayout(PanelRegistre,BoxLayout.Y_AXIS));

        /*Creem borders per posicionar componetns*/

        /*Creem labels per establir espais entre components*/
        JLabel TopTextFieldLabel0 = new JLabel();
        TopTextFieldLabel0.setPreferredSize(new Dimension(5,20));
        TopTextFieldLabel0.setBorder(bordersView.getLoginTopTextFieldBorder());

        JLabel EntreTextFieldLabel0 = new JLabel();
        EntreTextFieldLabel0.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel0.setBorder(bordersView.getEntreTextFieldBorder());

        JLabel EntreTextFieldLabel1 = new JLabel();
        EntreTextFieldLabel1.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel1.setBorder(bordersView.getEntreTextFieldBorder());

        JLabel EntreTextFieldLabel2 = new JLabel();
        EntreTextFieldLabel2.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel2.setBorder(bordersView.getEntreTextFieldBorder());

        JLabel EntreTextButtonLabel = new JLabel();
        EntreTextButtonLabel.setPreferredSize(new Dimension(5,20));
        EntreTextButtonLabel.setBorder(bordersView.getEntreTextFieldBorder());

        JLabel EntreButtonButtonLabel = new JLabel();
        EntreButtonButtonLabel.setPreferredSize(new Dimension(5,20));
        EntreButtonButtonLabel.setBorder(bordersView.getEntreButtonButtonBorder());

        /*Creem les zones per escriure*/
        nom = new JTextField("  Nom",20);
        nom.setMaximumSize(new Dimension(281,39));
        nom.setForeground(new Color(255,255,255));
        nom.setBorder(BordersView.TextFieldBorder);
        nom.setOpaque(false);

        correu = new JTextField("  Correu",20);
        correu.setMaximumSize(new Dimension(281,39));
        correu.setForeground(new Color(255,255,255));
        correu.setBorder(BordersView.TextFieldBorder);
        correu.setOpaque(false);

        contrasenya = new JTextField("  Contrasenya",20);
        contrasenya.setMaximumSize(new Dimension(281,39));
        contrasenya.setForeground(new Color(255,255,255));
        contrasenya.setBorder(BordersView.TextFieldBorder);
        contrasenya.setOpaque(false);



        JButton NoTensCompteButton = new JButton("¿Aun no tienes cuenta?");
        NoTensCompteButton.setHorizontalTextPosition(SwingConstants.LEFT);
        NoTensCompteButton.setFont(new Font("Verdana",Font.BOLD,8));
        NoTensCompteButton.setForeground(new Color(255,255,255));
        NoTensCompteButton.setBackground(new Color(249,171,15));
        NoTensCompteButton.setPreferredSize(new Dimension(120,25));
        NoTensCompteButton.setBorder(bordersView.getButtonTextBorder());
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


        /*Creem labels per establir espais entre components*/
        JLabel TopButtonLabel = new JLabel();
        TopButtonLabel.setPreferredSize(new Dimension(5,20));
        TopButtonLabel.setBorder(bordersView.getTopButtonBorder());

        JLabel EntreButtonLabel = new JLabel();
        EntreButtonLabel.setPreferredSize(new Dimension(5,20));
        EntreButtonLabel.setBorder(bordersView.getEntreButtonBorder());

        /*Botons*/
        JButton FaceBookButton = new JButton();
        FaceBookButton.setPreferredSize(new Dimension(270,50));
        FaceBookButton.setMaximumSize(new Dimension(281,40));
        FaceBookButton.setBorder(bordersView.getFacebookButtonBorder());
        FaceBookButton.setIcon(facebook);
        FaceBookButton.setPressedIcon(facebookPressed);



        JButton GoogleButton = new JButton();
        GoogleButton.setPreferredSize(new Dimension(270,50));
        GoogleButton.setMaximumSize(new Dimension(281,40));
        GoogleButton.setBorder(bordersView.getGoogleButtonBorder());
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
        PosicionamentBotonsNord.add(registrarse);
        PosicionamentBotonsNord.add(Espai);
        PartSuperior.add(PosicionamentBotonsNord,BorderLayout.EAST);
        panel.add(PartSuperior,BorderLayout.NORTH);

        /*Part Central*/
        panel.add(PartCentral,BorderLayout.CENTER);

        /*Nord*/

        /*Est*/
        PanelRegistre.add(TopTextFieldLabel0);
        PanelRegistre.add(nom);
        PanelRegistre.add(EntreTextFieldLabel0);
        PanelRegistre.add(correu);
        PanelRegistre.add(EntreTextFieldLabel1);
        PanelRegistre.add(contrasenya);
        //PanelRegistre.add(EntreTextFieldLabel2);
        //PanelRegistre.add(RepetirContrasenya);
        PanelRegistre.add(EntreTextButtonLabel);
        //PanelRegistre.add(IniciarSessioButton);
        //PanelRegistre.add(EntreButtonButtonLabel);
        //PanelRegistre.add(NoTensCompteButton);
        PartCentral.add(PanelRegistre, BorderLayout.EAST);
        /*South*/
        ComplementLogin.add(loginButton);
        PartInferior.add(ComplementLogin,BorderLayout.EAST);
        PartCentral.add(PartInferior,BorderLayout.SOUTH);
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

        /*Part inferior*/
        OmplirSouthPrincipalPanel.add(OmplirSouthPrincipalLabel);
        PanelSouth.add(OmplirSouthPrincipalPanel);
        panel.add(PanelSouth,BorderLayout.SOUTH);


        /*frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add("Ref_1",panel);
        frame.setPreferredSize(new Dimension(1000,820));
        frame.pack();
        frame.setVisible(true);*/

        return panel;
    }

    public void registerController(ActionListener controller) {
        registrarse.addActionListener(controller);
        loginButton.addActionListener(controller);
    }

    public String getNomString(){
        return this.nom.getText();
    }
    public String getCorreuString(){
        return this.correu.getText();
    }
    public String getContrasenyaString(){
        return this.contrasenya.getText();
    }


}
