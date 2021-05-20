package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.BordersView;
import smartpianoA8.presentation.views.customComponents.ImageView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPLoginView extends JPanel  {

    public static final String toRegister = "toRegister";
    public static final String tryLogin = "tryLogin";

    private static JLabel backgroundImage;

    private static final String PH_LOGIN = "  Nombre de usuario o correo";
    private static final String PH_PASSWORD = "  Contraseña";


    private JButton registrarse;//Canviat
    private JTextField nom;
    private JTextField correu;
    private JPasswordField contrasenya;
    private JButton loginButton;

    public JPLoginView() {

    }

    public ImageView runLogin() {

        ImageView panel = new ImageView(new ImageIcon("Imagen/ImagenesLogin/LoginImage.jpg").getImage());
        ImageIcon facebook = new ImageIcon("Imagen/ImagenesLogin/IniciarSesionFacebook.jpg");
        ImageIcon google = new ImageIcon("Imagen/ImagenesLogin/IniciarSesionGoogle.jpg");
        ImageIcon googlePressed = new ImageIcon("Imagen/ImagenesLogin/IniciarSesionGooglePressed.png");
        ImageIcon facebookPressed = new ImageIcon("Imagen/ImagenesLogin/IniciarSesionFacebookPressed.png");

        BordersView bordersView = new BordersView();

        panel.setLayout(new BorderLayout());

        /*-----------------------------------------PART SUPERIOR-----------------------------------------*/
        /*Panell secundari Nord*/
        JPanel PartSuperior = new JPanel();
        PartSuperior.setOpaque(false);
        PartSuperior.setLayout(new BorderLayout());


        /*Panell auxiliar posicionament botons Nord*/
        JPanel posicionamentBotonsNord = new JPanel(); //Panel per situar els botons del Nord a la dreta
        posicionamentBotonsNord.setOpaque(false);
        posicionamentBotonsNord.setLayout(new FlowLayout());

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
        JPanel panelSouth = new JPanel();
        panelSouth.setOpaque(false);
        //PanelSouth.setBackground(new Color(0,0,255));
        panelSouth.setLayout(new BoxLayout(panelSouth,BoxLayout.PAGE_AXIS));

        /*Boto register*/
        JLabel UpperButtonLabel = new JLabel();
        UpperButtonLabel.setPreferredSize(new Dimension(5,20));
        UpperButtonLabel.setBorder(bordersView.getLoginButtonBorder());

        JPanel partInferior = new JPanel();
        partInferior.setLayout(new BorderLayout());
        partInferior.setOpaque(false);


        JPanel complementLogin = new JPanel();
        complementLogin.setLayout(new BoxLayout(complementLogin,BoxLayout.Y_AXIS));
        complementLogin.setOpaque(false);

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



        JPanel omplirSouthPrincipalPanel = new JPanel();
        omplirSouthPrincipalPanel.setOpaque(false);
        //OmplirSouthPrincipalPanel.setBackground(new Color(101,58,156));
        omplirSouthPrincipalPanel.setLayout(new BoxLayout(omplirSouthPrincipalPanel,BoxLayout.Y_AXIS));


        JLabel OmplirSouthPrincipalLabel = new JLabel();
        OmplirSouthPrincipalLabel.setOpaque(false);
        OmplirSouthPrincipalLabel.setMinimumSize(new Dimension(200,300));
        OmplirSouthPrincipalLabel.setBorder(bordersView.getOmplirSouthPrincipalBorder());




        /*------------------------------------------PART CENTRAL------------------------------------------*/

        /*Extra*/
        JPanel omplirEstPanel = new JPanel();
        omplirEstPanel.setOpaque(false);
        //OmplirEstPanel.setBackground(new Color(101,58,156));
        omplirEstPanel.setLayout(new BoxLayout(omplirEstPanel,BoxLayout.Y_AXIS));

        JLabel OmplirEstLabel = new JLabel();
        OmplirEstLabel.setMinimumSize(new Dimension(200,300));
        OmplirEstLabel.setBorder(bordersView.getOmplirEstBorder());

        JPanel omplirOestPanel = new JPanel();
        omplirOestPanel.setOpaque(false);
        //OmplirOestPanel.setBackground(new Color(101,58,156));
        omplirOestPanel.setLayout(new BoxLayout(omplirOestPanel,BoxLayout.Y_AXIS));

        JLabel OmplirOestLabel = new JLabel();
        OmplirOestLabel.setMinimumSize(new Dimension(200,300));
        OmplirOestLabel.setBorder(bordersView.getOmplirOestBorder());

        /*Panell secundari Central*/
        JPanel partCentral = new JPanel();
        partCentral.setOpaque(false);
        //PartCentral.setBackground(new Color(102,178,255));
        partCentral.setLayout(new BorderLayout());


        /*-------------Part Centre-Nord-------------*/
        /*Text*/

        /*-------------Part Centre-Est-------------*/
        JPanel panelRegistre = new JPanel();
        panelRegistre.setOpaque(false);
        panelRegistre.setLayout(new BoxLayout(panelRegistre,BoxLayout.Y_AXIS));

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

        /*JLabel EntreTextFieldLabel2 = new JLabel();
        EntreTextFieldLabel2.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel2.setBorder(bordersView.getEntreTextFieldBorder());*/

        JLabel EntreTextButtonLabel = new JLabel();
        EntreTextButtonLabel.setPreferredSize(new Dimension(5,20));
        EntreTextButtonLabel.setBorder(bordersView.getEntreTextFieldBorder());

        JLabel EntreButtonButtonLabel = new JLabel();
        EntreButtonButtonLabel.setPreferredSize(new Dimension(5,20));
        EntreButtonButtonLabel.setBorder(bordersView.getEntreButtonButtonBorder());

        /*Creem les zones per escriure*/
        nom = new JTextField(PH_LOGIN,20);
        nom.setMaximumSize(new Dimension(281,39));
        nom.setForeground(new Color(255,255,255));
        nom.setBorder(BordersView.TextFieldBorder);
        nom.setOpaque(false);

        correu = new JTextField("  Correu",20);
        correu.setMaximumSize(new Dimension(281,39));
        correu.setForeground(new Color(255,255,255));
        correu.setBorder(BordersView.TextFieldBorder);
        correu.setOpaque(false);

        contrasenya = new JPasswordField(PH_PASSWORD,20);
        contrasenya.setMaximumSize(new Dimension(281,39));
        contrasenya.setForeground(new Color(255,255,255));
        contrasenya.setBorder(BordersView.TextFieldBorder);
        contrasenya.setOpaque(false);



        JButton noTensCompteButton = new JButton("¿Aun no tienes cuenta?");
        noTensCompteButton.setHorizontalTextPosition(SwingConstants.LEFT);
        noTensCompteButton.setFont(new Font("Verdana",Font.BOLD,8));
        noTensCompteButton.setForeground(new Color(255,255,255));
        noTensCompteButton.setBackground(new Color(249,171,15));
        noTensCompteButton.setPreferredSize(new Dimension(120,25));
        noTensCompteButton.setBorder(bordersView.getButtonTextBorder());
        noTensCompteButton.setOpaque(false);
        noTensCompteButton.setVisible(true);


        /*-------------Part Centre-Oest-------------*/
        JPanel panelAccounts = new JPanel();
        panelAccounts.setOpaque(false);
        //anelAccounts.setBackground(new Color(178,102,255));
        panelAccounts.setLayout(new BoxLayout(panelAccounts,BoxLayout.Y_AXIS));


        /*Creem labels per establir espais entre components*/
        JLabel topButtonLabel = new JLabel();
        topButtonLabel.setPreferredSize(new Dimension(5,20));
        topButtonLabel.setBorder(bordersView.getTopButtonBorder());

        JLabel entreButtonLabel = new JLabel();
        entreButtonLabel.setPreferredSize(new Dimension(5,20));
        entreButtonLabel.setBorder(bordersView.getEntreButtonBorder());

        /*Botons*/
        JButton faceBookButton = new JButton();
        faceBookButton.setPreferredSize(new Dimension(270,50));
        faceBookButton.setMaximumSize(new Dimension(281,40));
        faceBookButton.setBorder(bordersView.getFacebookButtonBorder());
        faceBookButton.setIcon(facebook);
        faceBookButton.setPressedIcon(facebookPressed);



        JButton googleButton = new JButton();
        googleButton.setPreferredSize(new Dimension(270,50));
        googleButton.setMaximumSize(new Dimension(281,40));
        googleButton.setBorder(bordersView.getGoogleButtonBorder());
        googleButton.setIcon(google);
        googleButton.setPressedIcon(googlePressed);

        JLabel jaTensCompte2 = new JLabel(" ");
        jaTensCompte2.setPreferredSize(new Dimension(140,395));
        jaTensCompte2.setFont(new Font("Verdana", Font.PLAIN, 228));
        jaTensCompte2.setOpaque(false);




        /*Packin' area*/
        /*Part Superior*/
        //PartSuperior.add(OmplirEstPartSuperior);
        posicionamentBotonsNord.add(JaTensCompte);
        posicionamentBotonsNord.add(registrarse);
        posicionamentBotonsNord.add(Espai);
        PartSuperior.add(posicionamentBotonsNord,BorderLayout.EAST);
        panel.add(PartSuperior,BorderLayout.NORTH);

        /*Part Central*/
        panel.add(partCentral,BorderLayout.CENTER);

        /*Nord*/

        /*Est*/
        panelRegistre.add(TopTextFieldLabel0);
        panelRegistre.add(nom);
        panelRegistre.add(EntreTextFieldLabel0);
        //PanelRegistre.add(correu);
        panelRegistre.add(EntreTextFieldLabel1);
        panelRegistre.add(contrasenya);
        //PanelRegistre.add(EntreTextFieldLabel2);
        //PanelRegistre.add(RepetirContrasenya);
        panelRegistre.add(EntreTextButtonLabel);
        //PanelRegistre.add(IniciarSessioButton);
        //PanelRegistre.add(EntreButtonButtonLabel);
        //PanelRegistre.add(NoTensCompteButton);
        partCentral.add(panelRegistre, BorderLayout.EAST);
        /*South*/
        complementLogin.add(loginButton);
        partInferior.add(complementLogin,BorderLayout.EAST);
        partCentral.add(partInferior,BorderLayout.SOUTH);
        /*Oest*/
        panelAccounts.add(topButtonLabel);
        panelAccounts.add(faceBookButton);
        panelAccounts.add(entreButtonLabel);
        panelAccounts.add(googleButton);
        //PanelAccounts.add(JaTensCompte2);
        //nelAccounts.add(EntreButtonLabel);
        //PanelAccounts.add(EntreButtonLabel);
        partCentral.add(panelAccounts,BorderLayout.WEST);
        /*Part Dreta*/
        omplirEstPanel.add(OmplirEstLabel);
        panel.add(omplirEstPanel,BorderLayout.EAST);
        /*Part Esquerra*/
        omplirOestPanel.add(OmplirOestLabel);
        panel.add(omplirOestPanel,BorderLayout.WEST);

        /*Part inferior*/
        omplirSouthPrincipalPanel.add(OmplirSouthPrincipalLabel);
        panelSouth.add(omplirSouthPrincipalPanel);
        panel.add(panelSouth,BorderLayout.SOUTH);


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
/*
    public String getNomString(){
        return this.nom.getText();
    }
    public String getCorreuString(){
        return this.correu.getText();
    }
    public String getContrasenyaString(){
        return this.contrasenya.getText();
    }

*/
    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        if (nom.getText().equals(PH_LOGIN)){
            data.add(null);
        } else {
            data.add(nom.getText());
        }
        String pass = String.valueOf(contrasenya.getPassword());
        if (pass.equals(PH_PASSWORD)){
            data.add(null);
        } else {
            data.add(pass);
        }
        return data;
    }
}
