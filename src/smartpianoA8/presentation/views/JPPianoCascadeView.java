package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.*;
import smartpianoA8.presentation.views.customComponents.piano.JPPiano;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
/**
 *
 * Esta clase se encarga principalmente de mostrar el panel interactivo asociado al aprendizaje del piano, aquí se le asignara no solamente
 * el panel general donde estan todas la funciones ver las teclas variar en función de la canción, sino que además,
 * incluye la funcion del register controller.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1.0
 */
public class JPPianoCascadeView extends JPMainView {
    // ---- Inici Atributs ----
    private JPPiano jpPiano;
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----

    /**
     * Constructor de JPPianoCascadeView.
     */
    public JPPianoCascadeView(){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


        JPanel jpCascade = new JPanel();
        jpCascade.setBackground(Color.darkGray);
        jpCascade.setMinimumSize(new Dimension(750,500));
        jpCascade.setBorder(BorderFactory.createEmptyBorder(375,250,375,250));

        add(new JLColor("Piano cascade", ColorScheme.PRIMARY));
        //JPPiano
        jpPiano  = new JPPiano();
        //Final Packing

        add(jpCascade);
        add(jpPiano,BorderLayout.SOUTH);
    }//Cierre del constructor

    // ---- Inici Mètodes ----
    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param actionListener controlador asocioado a los botones.
     * @param keyListener controlador asociado a las teclas del ordenador.
     * @param mouseListener controlador asociado al ratón.
     */
    public void registerControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {}//Cierre del método
}//Cierre de la clase
