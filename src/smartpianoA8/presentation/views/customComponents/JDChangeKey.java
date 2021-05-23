package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Classe que permet canviar de tecla del teclat físic de lletres i nombres de l'ordinador per cada tecla del piano virtual mostrant una
 * finestra de diàleg demanant una nova tecla
 * @version 1.0
 * @see JDialog
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class JDChangeKey extends JDialog {
    private JPPrimarySecondaryText jpText;

    /**
     * Constructor de la finestar de diàleg que demana la informació d'una nova tecla del teclat. Aquella tecla presa no s'emetrà com a so
     * o per la restya de l'ordinador exepte si és una telca de funció espacial (enter, borrar, F1 F2 Fx, CTR...
     */
    public JDChangeKey(){


        setVisible(false);
        setPreferredSize(new Dimension(400,100));
        setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);


        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        jPanel.setBackground(ColorScheme.PopUpsBackground);

        jpText = new JPPrimarySecondaryText("","");
        jpText.setBackground(ColorScheme.PopUpsBackground);

        add(jpText);
        pack();

    }

    /**
     * Mètode per regitrar un Listener per les tecles físiques (del teclat
     * @param keyListener KeyListener que escolta si es prem una tecla i quina
     */
    public void registerKeyListener(KeyListener keyListener){
        addKeyListener(keyListener);
    }

    /**
     * Mètode que mostra el dialeg llençant-lo
     * @param primary
     * @param secondary
     */
    public void show(String primary, String secondary){
        jpText.setPrimaryText(primary);
        jpText.setSecondaryText(secondary);
        setVisible(true);
    }

    /**
     * Mètode que tanca la finestra del diàleg
     */
    public void close() {
        setVisible(false);
    }
}
