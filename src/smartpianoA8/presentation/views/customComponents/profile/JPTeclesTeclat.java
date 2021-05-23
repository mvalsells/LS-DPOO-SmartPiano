package smartpianoA8.presentation.views.customComponents.profile;

import smartpianoA8.presentation.views.customComponents.piano.BlackKey;
import smartpianoA8.presentation.views.customComponents.piano.WhiteKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
/**
 *
 * Esta clase se encarga principalmente de crear una tecla en funcion de la cantidad de teclas blancas o negras que
 * se le han predefinido dependiendo de las octavas destinadas.
 *
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JPTeclesTeclat extends JPanel {
    public static int OCTAVES = 3;
    private final WhiteKey[] whites = new WhiteKey[7 * OCTAVES + 1];
    private final BlackKey[] blacks = new BlackKey[5 * OCTAVES];


    /**
     * Constructor de la clase JPTeclesTeclat
     */
    public JPTeclesTeclat(){
        setBackground(Color.BLACK);
        setLayout(null);
        //teclat.addKeyListener(this);
        for (int i = 0; i < blacks.length; i++) {
            blacks[i] = new BlackKey(i);
            add(blacks[i]);
        }
        for (int i = 0; i < whites.length; i++) {

            whites[i] = new WhiteKey(i);
            add(whites[i]);

        }
    }//Cierre del constructor

    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param mouseListener controlador asocioado al raton.
     */
    public void registerController(MouseListener mouseListener){
        for (BlackKey black : blacks) {
            black.addMouseListener(mouseListener);
        }
        for (WhiteKey white : whites) {
            white.addMouseListener(mouseListener);
        }
    }//Cierre del método

    @Override
    public Dimension getPreferredSize() {
        int count = getComponentCount();
        Component last = getComponent(count - 1);
        Rectangle bounds = last.getBounds();
        int width = 10 + bounds.x + bounds.width;
        int height = 10 + bounds.y + bounds.height;

        return new Dimension(width, height);
    }//Cierre del método
}//Cierre de la clase
