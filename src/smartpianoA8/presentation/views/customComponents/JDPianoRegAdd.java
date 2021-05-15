package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDPianoRegAdd extends JDialog {

    public static final String GuardarRec = "saveRec";
    public static final String DiscardRec = "discardRec";
    public static final String playRec = "playRec";
    public static final String pauseRec = "pauseRec";


    private JTextField jTextField;
    private JButton jbAdd;
    private JButton jbDiscard;
    private JCheckBox jcbCheckBox;
    private JButton jbPlayButton;
    private JButton jbPauseButton;


    public JDPianoRegAdd(){

        ImageIcon playButton = new ImageIcon(new ImageIcon("Imagen/ImagenesMenu/playButton.png").getImage());
        ImageIcon pauseButton = new ImageIcon(new ImageIcon("Imagen/ImagenesMenu/pauseButton.png").getImage());

        this.setVisible(false);
        this.setPreferredSize(new Dimension(500,200));
        setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.setBackground(ColorScheme.PopUpsBackground);

        JLabel jlTextTitul = new JLColor("Nombre de la grabación", ColorScheme.PRIMARY,FontBase.TitularRegAdd);
        //.setBorder(BorderFactory.createEmptyBorder(0,0,0,this.getWidth()/2));
        jTextField = new JTextField();
        jTextField.setMaximumSize(new Dimension(295,48));
        jTextField.setBorder(BorderFactory.createLineBorder(ColorScheme.Secondary,2));
        JPanel jpExtraFlow = new JPanel(new FlowLayout());
        jpExtraFlow.setOpaque(false);
        jbAdd = new JBgeneral("Guradar",ColorScheme.BlueButton);
        jbAdd.setActionCommand(GuardarRec);
        jbDiscard = new JBgeneral("Descartar",ColorScheme.DarkButton);
        jbDiscard.setActionCommand(DiscardRec);
        jcbCheckBox = new JCheckBox();
        jcbCheckBox.setOpaque(false);
        jcbCheckBox.setForeground(Color.WHITE);


        JPanel jpExtraFlow2 = new JPanel(new FlowLayout());
        jpExtraFlow2.setOpaque(false);
        jbPlayButton = new JButton();
        jbPlayButton.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0),0));
        jbPlayButton.setIcon(playButton);
        jbPlayButton.setOpaque(false);
        jbPlayButton.setContentAreaFilled(false);
        jbPlayButton.setBorderPainted(false);
        jbPlayButton.setActionCommand(playRec);
        jbPauseButton = new JButton();
        jbPauseButton.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0),0));
        jbPauseButton.setIcon(pauseButton);
        jbPauseButton.setContentAreaFilled(false);
        jbPauseButton.setBorderPainted(false);
        jbPauseButton.setActionCommand(playRec);

        jbPauseButton.setActionCommand(pauseRec);


        jcbCheckBox.setText("Deseas hacerla publica?");


        panel.add(jlTextTitul);
        panel.add(jTextField);
        jpExtraFlow.add(jbAdd);
        jpExtraFlow.add(jbDiscard);
        jpExtraFlow.add(jcbCheckBox);
        panel.add(jpExtraFlow);
        jpExtraFlow2.add(jbPlayButton);
        jpExtraFlow2.add(jbPauseButton);
        panel.add(jpExtraFlow2);
        getContentPane().add(panel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        pack();
    }

    public void run(){
        System.out.println("patatarun"); this.setVisible(true);}
    public void close(){
        System.out.println("patataclose"); this.setVisible(false);}

    public String getTextFieldString(){return jTextField.getText();}
    public boolean isCheckBoxSelected(){return jcbCheckBox.isSelected();}

    public void registerControllerJDPianoRegAdd(ActionListener controller){
        jbAdd.addActionListener(controller);
        jbDiscard.addActionListener(controller);
    }

}
