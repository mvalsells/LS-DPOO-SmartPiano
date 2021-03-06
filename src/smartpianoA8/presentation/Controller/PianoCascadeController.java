package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.customComponents.piano.JPPiano;

import java.awt.event.*;

/**
 * Classe controller de la vista de les notes en cascada
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see Runnable
 * @see ActionListener
 * @see KeyListener
 * @see MouseListener
 */
public class PianoCascadeController implements Runnable, ActionListener, KeyListener, MouseListener {

    private PresentationController presentationController;
    //private ArrayList<ArrayList<Notes>> partitura;
    //private ArrayList<Notes> canal1;
    //private float maxMilis;
    private JPPiano jppiano;

    /**
     * Constructor
     */
    public PianoCascadeController(JPPiano jpPiano) {//pasarle la cancion y datos
        //this.partitura = null;
        //this.canal1 = null;
        //this.maxMilis = null;
        this.jppiano = jpPiano;

    }

    /**
     * Mètode per registrar el controller a la presentació
     * @param presentationController presentaicó
     */
    public void registerPresentationController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }

    /**
     * Mètode per executar la cançó
     * @see Runnable
     */
    @Override
    public void run(){
        /*Song song = presentationController.getSongByID(presentationController.getLastSongPressed());
        this.partitura = presentationController.getBusinesMidiNotes(song);
        this.canal1 = partitura.get(1);

        maxMilis = presentationController.getMaxMilis();

        long inicial = System.currentTimeMillis();
        long actual = System.currentTimeMillis()-inicial;


        int i = 0;
        Thread[] rectangle = new Thread[canal1.size()];
        while(actual <= maxMilis){
            actual = System.currentTimeMillis()-inicial;
            if(canal1.get(i).getStartTime() >= actual){
                rectangle[i] = new Thread(new RectanglesCascada(canal1.get(i).getNote(),canal1.get(i).getEndTime(), jppiano));
                rectangle[i].start();
                i++;
            }
            actual = System.currentTimeMillis()-inicial;
        }*/





    }


    public void setJppiano(JPPiano jpPiano){
        this.jppiano=jpPiano;}

    /**
     * @param e
     * @deprecated No hauria d'estar aquí sinó un controlador per sobre
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
