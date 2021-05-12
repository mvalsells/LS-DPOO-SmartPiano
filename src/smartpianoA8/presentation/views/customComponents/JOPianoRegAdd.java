package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class JOPianoRegAdd extends JPanel {

    private JTextField jTextField;
    private JButton jbAdd;
    JButton jbDiscard;
    JCheckBox jcbCheckBox;

    public JOPianoRegAdd (){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(ColorScheme.PopUpsBackground);

        JLabel jlTextTitul = new JLColor("Nombre de la grabación", ColorScheme.PRIMARY,FontBase.TitularRegAdd);
        jTextField = new JTextField();
        jTextField.setBorder(BorderFactory.createLineBorder(ColorScheme.Secondary,2));
        JPanel jpExtraFlow = new JPanel(new FlowLayout());
        jbAdd = new JBgeneral("Guradar",ColorScheme.BlueButton);
        jbDiscard = new JBgeneral("Descartar",ColorScheme.DarkButton);
        jcbCheckBox = new JCheckBox();
        jcbCheckBox.setText("Deseas hacerla publica?");



        add(jlTextTitul);
        add(jTextField);
        jpExtraFlow.add(jbAdd);
        jpExtraFlow.add(jbDiscard);
        jpExtraFlow.add(jcbCheckBox);
        add(jpExtraFlow);

    }

    public void displayGUI() {

        JOptionPane.showOptionDialog(null, this, null, JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
    }

    public String getNomRec(){ return jTextField.getText(); }
    public Boolean isCheckBoxSelected(){ return jcbCheckBox.isSelected(); }



}
