package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDPlaylistCreator extends JDialog {

    public static final String CREATE_PLAYLIST = "createPlaylist";
    public static final String DISCARD_PLAYLIST = "discardPlaylist";


    private JTextField jTextField;
    private JButton jbCreate;
    private JButton jbDiscard;


    public JDPlaylistCreator (){

        this.setVisible(false);
        this.setPreferredSize(new Dimension(500,200));

        setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.setBackground(ColorScheme.PopUpsBackground);

        JPanel jpExtraFlow = new JPanel(new FlowLayout());
        jpExtraFlow.setOpaque(false);
        JLabel jlTextPlaylist = new JLColor("Nombre de la playlist", ColorScheme.PRIMARY,FontBase.TitularRegAdd);
        jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(295,24));
        jTextField.setBorder(BorderFactory.createLineBorder(ColorScheme.Secondary,2));

        JPanel jpExtraFlow2 = new JPanel(new FlowLayout());
        jpExtraFlow2.setOpaque(false);
        jbCreate = new JBgeneral("Crear",ColorScheme.BlueButton);
        jbCreate.setActionCommand(CREATE_PLAYLIST);
        jbDiscard = new JBgeneral("Descartar",ColorScheme.DarkButton);
        jbDiscard.setActionCommand(DISCARD_PLAYLIST);

        jpExtraFlow.add(jlTextPlaylist);
        jpExtraFlow.add(jTextField);
        panel.add(jpExtraFlow);

        jpExtraFlow2.add(jbCreate);
        jpExtraFlow2.add(jbDiscard);
        panel.add(jpExtraFlow2);

        getContentPane().add(panel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        pack();
    }

    /**
     * Funció per mostrar el JDiagram
     */
    public void run(){  this.setVisible(true);}

    /**
     * Funcio per a tencar el JDiagram
     */
    public void close(){
        this.setVisible(false);
    }

    /**
     * Getter per obtenir el titul de la Playlist introduït
     * @return String jTextField
     */
    public String getTextFieldString(){return jTextField.getText();}

    public void registerControllerJDPlaylist(ActionListener controller){
        jbCreate.addActionListener(controller);
        jbDiscard.addActionListener(controller);
    }

}
