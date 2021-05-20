package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.BordersView;
import smartpianoA8.presentation.views.customComponents.ImageView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPRegisterView extends JPanel  {


    public static final String toLogin = "ToLogin";
    public static final String tryRegister = "tryRegister";

    private static final String PH_USERNAME = "  Nombre de usuario";
    private static final String PH_EMAIL = "  Correo";
    private static final String PH_PASSWORD = "  Contraseña";
    private static final String PH_PASSWORD_REPETITON = "  Repite la contraseña";

    private BordersView bordersView = new BordersView();


    private JTextField nom;
    private JTextField correu;
    private JPasswordField contrasenya;
    private JPasswordField repetirContrasenya;

    private JButton iniciarSessio;//Canivat
    private JButton registerButton;//canviat
    private JCheckBox acceptTandC;//Canviat

    public JPRegisterView() {
        iniciarSessio = new JButton();
        registerButton = new JButton();
    }

    public ImageView runRegister(){
        bordersView = new BordersView();

        ImageView panel = new ImageView(new ImageIcon("Imagen/ImagenesRegister/RegisterImage.jpg").getImage());
        ImageIcon facebook = new ImageIcon("Imagen/ImagenesRegister/RegistrarseFacebook.jpg");
        ImageIcon google = new ImageIcon("Imagen/ImagenesRegister/RegistrarseGoogle.jpg");
        ImageIcon googlePressed = new ImageIcon("Imagen/ImagenesRegister/RegistrarseGooglePressed.png");
        ImageIcon facebookPressed = new ImageIcon("Imagen/ImagenesRegister/RegistrarseFacebookPressed.png");


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
        iniciarSessio = new JButton("Iniciar sesion");
        iniciarSessio.setForeground(new Color(255,255,255));
        iniciarSessio.setBackground(new Color(249,171,15));
        iniciarSessio.setPreferredSize(new Dimension(130,35));
        iniciarSessio.setBorderPainted(false);
        iniciarSessio.setOpaque(true);
        iniciarSessio.setVisible(true);
        iniciarSessio.setActionCommand(toLogin);


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
        nom = new JTextField(PH_USERNAME,20);
        nom.setMaximumSize(new Dimension(281,39));
        nom.setForeground(new Color(255,255,255));
        nom.setBorder(BordersView.TextFieldBorder);
        nom.setOpaque(false);

        correu = new JTextField(PH_EMAIL,20);
        correu.setMaximumSize(new Dimension(281,39));
        correu.setForeground(new Color(255,255,255));
        correu.setBorder(BordersView.TextFieldBorder);
        correu.setOpaque(false);

        contrasenya = new JPasswordField(PH_PASSWORD,20);
        contrasenya.setMaximumSize(new Dimension(281,39));
        contrasenya.setForeground(new Color(255,255,255));
        contrasenya.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        contrasenya.setOpaque(false);

        repetirContrasenya = new JPasswordField(PH_PASSWORD_REPETITON,20);
        repetirContrasenya.setMaximumSize(new Dimension(281,39));
        repetirContrasenya.setForeground(new Color(255,255,255));
        repetirContrasenya.setBorder(BordersView.TextFieldBorder);
        repetirContrasenya.setOpaque(false);




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

        registerButton = new JButton("Registrarse");
        //RegisterButton.setAlignmentX(Container.RIGHT_ALIGNMENT);
        registerButton.setPreferredSize(new Dimension(220,39));
        registerButton.setBackground(new Color(249,171,15));
        registerButton.setForeground(new Color(255,255,255));
        registerButton.setBorderPainted(true);
        registerButton.setBorder(bordersView.getRegisterButtonBorder());
        //IniciarSessio.setBorderPainted(false);
        registerButton.setOpaque(true);
        registerButton.setFont(new Font("Verdana",Font.BOLD,12));
        registerButton.setVisible(true);
        registerButton.setActionCommand(tryRegister);

        acceptTandC = new JCheckBox("Acepto los términos y condiciones");
        acceptTandC.setOpaque(false);
        acceptTandC.setForeground(new Color(255,255,255));
        acceptTandC.setFont(new Font("Arial",Font.PLAIN,8));

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
        PosicionamentBotonsNord.add(iniciarSessio);
        PosicionamentBotonsNord.add(Espai);
        PartSuperior.add(PosicionamentBotonsNord,BorderLayout.EAST);
        panel.add(PartSuperior,BorderLayout.NORTH);

        /*Part Central*/
        panel.add(PartCentral,BorderLayout.CENTER);

        /*Nord*/
        PartCentral.add(Titular,BorderLayout.NORTH);

        /*Est*/
        PanelRegistre.add(TopTextFieldLabel0);
        PanelRegistre.add(nom);
        PanelRegistre.add(EntreTextFieldLabel0);
        PanelRegistre.add(correu);
        PanelRegistre.add(EntreTextFieldLabel1);
        PanelRegistre.add(contrasenya);
        PanelRegistre.add(EntreTextFieldLabel2);
        PanelRegistre.add(repetirContrasenya);
        PanelRegistre.add(EntreTextCheck);
        PartCentral.add(PanelRegistre, BorderLayout.EAST);

        /*South*/
        ComplementRegistre.add(acceptTandC);
        ComplementRegistre.add(registerButton);
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

    public void registerController(ActionListener controller) {
        iniciarSessio.addActionListener(controller);
        registerButton.addActionListener(controller);
    }

    /*
    public Boolean isCheckBoxAcceptTandC(){return acceptTandC.isSelected();}

    public String getNomString(){
        return nom.getText();
    }
    public String getCorreuString(){
        return correu.getText();
    }
    public String getContrasenyaString(){
        return contrasenya.getText();
    }
    public String getRepetirContrasenyaString(){
        return repetirContrasenya.getText();
    }
*/

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        data.add(String.valueOf(acceptTandC.isSelected()));
        if (nom.getText().equals(PH_USERNAME)){
            data.add(null);
        } else {
            data.add(nom.getText());
        }
        if (correu.getText().equals(PH_EMAIL)){
            data.add(null);
        } else {
            data.add(correu.getText());
        }
        String pass = String.valueOf(contrasenya.getPassword());
        if (pass.equals(PH_PASSWORD)){
            data.add(null);
        } else {
            data.add(pass);
        }
        pass = String.valueOf(repetirContrasenya.getPassword());
        if (pass.equals(PH_PASSWORD_REPETITON)){
            data.add(null);
        } else {
            data.add(pass);
        }
        return data;
    }
}
