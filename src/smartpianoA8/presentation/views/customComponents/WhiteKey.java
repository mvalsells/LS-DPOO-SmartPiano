package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

/**
 *
 * Esta clase se encarga principalmente de crear el la nota blanca como tal, aqui no solamente se le define el color,
 * sino además se le define als dimensiones que ha de tener. Cabe recalcar que tambien dispone de los métodos para
 * devolver las nota correspondiente asi como los métodos de clicar y desclicar las notas
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */


public class WhiteKey  extends JButton implements Key {

    static int WWD = (int) (((WD * 3) / 2)*1.2);
    static int WHT = (HT * 3) / 2;
    final int note;

    /**
     * Constructor de la clase, donde se le asignara cual es la dimensión de la nota por cada una de las posiciones.
     * @param pos Cada una de las posiciones de la nota.
     */
    public WhiteKey (int pos) {
        note = baseNote + 2 * pos
                - (pos + 4) / 7
                - pos / 7;
        int left = 10 + WWD * pos;
        // I think metal looks better!
        setBackground (Color.white);
        setBounds (left, 10, WWD, WHT);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        setOpaque(true);
        setForeground(Color.WHITE);
    }//Cierre del constructor

    /**
     * Método que devuelve la nota que ha sido ejecutada.
     * @return La nota que ha sido ejecutada
     */
    public int getNote () {
        return note;
    }//Cierre del método

    /**
     * Método que indicara si se ha clicado la nota que color se le debe poner.
     */
    public void clicarNota(){setBackground(Color.BLUE);/*setBorder(BorderFactory.createLineBorder(Color.blue,1));*/}//Cierre del método

    /**
     * Método que indicara si se ha desclicado la nota que color se le debe poner.
     */
    public void desclicarNota(){ setBackground(Color.WHITE);/*setBorder(BorderFactory.createLineBorder(Color.white,1));*/ }//Cierre del método
}//Cierre de la clase