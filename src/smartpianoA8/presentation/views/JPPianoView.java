package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 *
 * Esta clase se encarga principalmente de mostrar el panel interactivo asociado al piano, aquí se le asignara no solamente
 * el panel general donde estan todas la funciones para editar el menu, sino que además, incluye las funciones para guardar las canciones gravadas al igual que ejecutar
 * esa accion de gravar.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1.0
 */
public class JPPianoView extends JPMainView {
    // ---- Inici Atributs ----
    private JPPiano jpPiano;
    private JDPianoRegAdd jdPianoRegAdd;

    // ---- Fi Atributs ----
    // ---- Inici Constructors ----

    /**
     * Constructor de JPPianoView
     */
    public JPPianoView(){
        setLayout(new BorderLayout());



        //ShowDialog
        jdPianoRegAdd = new JDPianoRegAdd();
        jpPiano = new JPPiano();
        //Final Packing
        add(jpPiano,BorderLayout.CENTER);
    }//Cierre del constructor

    // ---- Inici Mètodes ----

    /**
     * Método que una vez recibe que el boton esta recording, cambia la imagen
     * @param button Botón indicado en este caso para ejecutar la función de recording.
     */
    public void setPressedIcon(JButton button){ jpPiano.setPressedIcon(button); }//Cierre del método

    /**
     * Método que una vez recibe el boton ha acabado de hacer recording, cambia la imagen
     * @param button Botón indicado en este caso para ejecutar la función de recording.
     */
    public void setUnpressedIcon(JButton button){
        jpPiano.setUnpressedIcon(button);
    }//Cierre del método

    public void setPlayButtonPressedIcon(){jpPiano.setPlayButtonPressedIcon();}
    public void setPlayButtonUnpressedIcon(){jpPiano.setPlayButtonUnpressedIcon();}

    /**
     * Método con el que se controla todos los listeners generados en esta clase.
     * @param actionListener controlador asocioado a los botones.
     * @param keyListener controlador asociado a las teclas del ordenador.
     * @param mouseListener controlador asociado al ratón.
     */
    public void registerControllers(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        jdPianoRegAdd.registerControllerJDPianoRegAdd(actionListener);
        jpPiano.registerController(actionListener,keyListener,mouseListener);
    }//Cierre del método

    /**
     * Método que empieza la función de recording.
     */
    public void jdRun() {jdPianoRegAdd.run();    }//Cierre del método

    /**
     * Método que finaliza la función de recording.
     */
    public void jdClose() { jdPianoRegAdd.close();}//Cierre del método

    /**
     * Getter que debuelve el ànel del piano
     * @return
     */
    public JPPiano getJpPiano(){
        JPPiano extra =  this.jpPiano;

        return extra;}//Cierre del método

    /**
     * Método que coje el String que se guarda en el panel del reg.
     * @return El String que se guarda en el panel del reg.
     */
    public String getTextFieldString() { return jdPianoRegAdd.getTextFieldString();}//Cierre del método

    /**
     * Método que mira si el CheckBox está seleccionado.
     * @return Si el CheckBox está seleccionado.
     */
    public boolean isCheckBoxSelected() { return jdPianoRegAdd.isCheckBoxSelected();}//Cierre del método
}//Cierre de la clase
