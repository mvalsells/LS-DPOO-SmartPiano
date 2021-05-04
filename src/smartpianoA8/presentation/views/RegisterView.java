package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JPanel  {
    //ImageView imageView = new ImageView();
    BordersView bordersView = new BordersView();
    private JButton IniciarSessio;

    public RegisterView() {
        IniciarSessio = new JButton();
    }

    public ImageView runRegister(){
        smartpianoA8.presentation.views.ImageView panel = new smartpianoA8.presentation.views.ImageView(new ImageIcon("Imagen/ImagenesRegister/RegisterImage.jpg").getImage());
        ImageIcon facebook = new ImageIcon("Imagen/ImagenesRegister/RegistrarseFacebook.jpg");
        ImageIcon google = new ImageIcon("Imagen/ImagenesRegister/RegistrarseGoogle.jpg");
        ImageIcon googlePressed = new ImageIcon("Imagen/ImagenesRegister/RegistrarseGooglePressed.png");
        ImageIcon facebookPressed = new ImageIcon("Imagen/ImagenesRegister/RegistrarseFacebookPressed.png");

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
        /*Panell principal on anira imatge*/
        //JPanel panel = new JPanel();
        //panel.setBackground(Color.GRAY);
        panel.setLayout(new BorderLayout());

        /*-----------------------------------------PART SUPERIOR-----------------------------------------*/
        /*Panell secundari Nord*/
        JPanel PartSuperior = new JPanel();
        PartSuperior.setOpaque(false);
        //PartSuperior.setBackground(Color.BLUE);
        PartSuperior.setLayout(new BorderLayout());


        /*Panell auxiliar posicionament botons Nord*/
        JPanel PosicionamentBotonsNord = new JPanel(); //Panel per situar els botons del Nord a la dreta
        PosicionamentBotonsNord.setOpaque(false);
        PosicionamentBotonsNord.setLayout(new FlowLayout());
        //PosicionamentBotonsNord.setBackground(Color.GREEN);

        /*Botons i textos nord*/
        IniciarSessio = new JButton("Iniciar sesion");
        IniciarSessio.setForeground(new Color(255,255,255));
        IniciarSessio.setBackground(new Color(249,171,15));
        IniciarSessio.setPreferredSize(new Dimension(130,35));
        IniciarSessio.setBorderPainted(false);
        IniciarSessio.setOpaque(true);
        IniciarSessio.setVisible(true);
        IniciarSessio.setActionCommand("ToLogin");


        JLabel JaTensCompte = new JLabel("¿Ya tienes una cuenta?");
        JaTensCompte.setForeground(new Color(255,255,255));
        JaTensCompte.setPreferredSize(new Dimension(140,100));
        JaTensCompte.setFont(new Font("Verdana", Font.PLAIN, 11));

        JLabel Espai = new JLabel(" ");
        Espai.setForeground(new Color(255,255,255));
        Espai.setPreferredSize(new Dimension(20,100));
        Espai.setFont(new Font("Verdana", Font.PLAIN, 11));

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
        JLabel Titular = new JLabel("Crea una cuenta y empieze ahora");
        Titular.setForeground(new Color(255,255,255));
        Titular.setPreferredSize(new Dimension(300,100));
        Titular.setFont(new Font("Verdana", Font.PLAIN, 37));
        /*Creem un border per posicionar el text*/
        Titular.setBorder(bordersView.getRegisterTitularBorder());

        /*-------------Part Centre-Est-------------*/
        JPanel PanelRegistre = new JPanel();
        PanelRegistre.setOpaque(false);
        //PanelRegistre.setBackground(new Color(178,102,255));
        PanelRegistre.setLayout(new BoxLayout(PanelRegistre,BoxLayout.Y_AXIS));

        /*Creem labels per establir espais entre components*/
        JLabel TopTextFieldLabel0 = new JLabel();
        TopTextFieldLabel0.setPreferredSize(new Dimension(5,20));
        TopTextFieldLabel0.setBorder(bordersView.getRegisterTopTextFieldBorder());

        JLabel EntreTextFieldLabel0 = new JLabel();
        EntreTextFieldLabel0.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel0.setBorder(bordersView.getEntreTextFieldBorder());

        JLabel EntreTextFieldLabel1 = new JLabel();
        EntreTextFieldLabel1.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel1.setBorder(bordersView.getEntreTextFieldBorder());

        JLabel EntreTextFieldLabel2 = new JLabel();
        EntreTextFieldLabel2.setPreferredSize(new Dimension(5,20));
        EntreTextFieldLabel2.setBorder(bordersView.getEntreTextFieldBorder());

        JLabel EntreTextCheck = new JLabel();
        EntreTextCheck.setPreferredSize(new Dimension(5,20));
        EntreTextCheck.setBorder(bordersView.getEntreTextFieldBorder());


        /*Creem les zones per escriure*/
        JTextField Nom = new JTextField("  Nom",20);
        Nom.setMaximumSize(new Dimension(281,39));
        Nom.setForeground(new Color(255,255,255));
        Nom.setBorder(bordersView.getTextFieldBorder());
        Nom.setOpaque(false);

        JTextField Correu = new JTextField("  Correu",20);
        Correu.setMaximumSize(new Dimension(281,39));
        Correu.setForeground(new Color(255,255,255));
        Correu.setBorder(bordersView.getTextFieldBorder());
        Correu.setOpaque(false);

        JTextField Contrasenya = new JTextField("  Contrasenya",20);
        Contrasenya.setMaximumSize(new Dimension(281,39));
        Contrasenya.setForeground(new Color(255,255,255));
        Contrasenya.setBorder(bordersView.getTextFieldBorder());
        Contrasenya.setOpaque(false);

        JTextField RepetirContrasenya = new JTextField("  Repetir Contrasenya",20);
        RepetirContrasenya.setMaximumSize(new Dimension(281,39));
        RepetirContrasenya.setForeground(new Color(255,255,255));
        RepetirContrasenya.setBorder(bordersView.getTextFieldBorder());
        RepetirContrasenya.setOpaque(false);




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
        JaTensCompte2.setPreferredSize(new Dimension(140,393));
        JaTensCompte2.setFont(new Font("Verdana", Font.PLAIN, 285));
        JaTensCompte2.setOpaque(false);

        /*------------------------------------------PART INFERIOR------------------------------------------*/
        /*Extra(omplir south)*/
        JPanel PanelSouth = new JPanel();
        PanelSouth.setOpaque(false);
        //PanelSouth.setBackground(new Color(0,0,255));
        PanelSouth.setLayout(new BoxLayout(PanelSouth,BoxLayout.PAGE_AXIS));

        /*Boto register*/

        JLabel UpperButtonLabel = new JLabel();
        UpperButtonLabel.setPreferredSize(new Dimension(5,20));
        UpperButtonLabel.setBorder(bordersView.getRegisterButtonBorder());

        JPanel PartInferior = new JPanel();
        PartInferior.setLayout(new BorderLayout());
        PartInferior.setOpaque(false);


        JPanel ComplementRegistre = new JPanel();
        ComplementRegistre.setLayout(new BoxLayout(ComplementRegistre,BoxLayout.Y_AXIS));
        ComplementRegistre.setOpaque(false);

        JButton RegisterButton = new JButton("Registrarse");
        //RegisterButton.setAlignmentX(Container.RIGHT_ALIGNMENT);
        RegisterButton.setPreferredSize(new Dimension(220,39));
        RegisterButton.setBackground(new Color(249,171,15));
        RegisterButton.setForeground(new Color(255,255,255));
        RegisterButton.setBorderPainted(true);
        RegisterButton.setBorder(bordersView.getRegisterButtonBorder());
        //IniciarSessio.setBorderPainted(false);
        RegisterButton.setOpaque(true);
        RegisterButton.setFont(new Font("Verdana",Font.BOLD,12));
        RegisterButton.setVisible(true);

        JCheckBox AcceptTandC = new JCheckBox("Acepto los términos y condiciones");
        AcceptTandC.setOpaque(false);
        AcceptTandC.setForeground(new Color(255,255,255));
        AcceptTandC.setFont(new Font("Arial",Font.PLAIN,8));

        JPanel OmplirSouthPrincipalPanel = new JPanel();
        OmplirSouthPrincipalPanel.setOpaque(false);
        //OmplirSouthPrincipalPanel.setBackground(new Color(101,58,156));
        OmplirSouthPrincipalPanel.setLayout(new BoxLayout(OmplirSouthPrincipalPanel,BoxLayout.Y_AXIS));

        JLabel OmplirSouthPrincipalLabel = new JLabel();
        OmplirSouthPrincipalLabel.setOpaque(false);
        OmplirSouthPrincipalLabel.setMinimumSize(new Dimension(200,300));
        OmplirSouthPrincipalLabel.setBorder(bordersView.getOmplirSouthPrincipalBorder());

        

        /*Packin' area*/
        /*Part Superior*/
        //PartSuperior.add(OmplirEstPartSuperior);
        PosicionamentBotonsNord.add(JaTensCompte);
        PosicionamentBotonsNord.add(IniciarSessio);
        PosicionamentBotonsNord.add(Espai);
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
        PanelRegistre.add(EntreTextFieldLabel2);
        PanelRegistre.add(RepetirContrasenya);
        PanelRegistre.add(EntreTextCheck);
        PartCentral.add(PanelRegistre, BorderLayout.EAST);

        /*South*/
        ComplementRegistre.add(AcceptTandC);
        ComplementRegistre.add(RegisterButton);
        PartInferior.add(ComplementRegistre,BorderLayout.EAST);
        PartCentral.add(PartInferior,BorderLayout.SOUTH);

        /*Oest*/
        PanelAccounts.add(TopButtonLabel);
        PanelAccounts.add(FaceBookButton);
        PanelAccounts.add(EntreButtonLabel);
        PanelAccounts.add(GoogleButton);
        PanelAccounts.add(JaTensCompte2);
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

        return panel;




    }

    public JButton getIniciarSessio(){
        return this.IniciarSessio;
    }


}
