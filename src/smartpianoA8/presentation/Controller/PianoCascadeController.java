package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.presentation.views.JFMainFrame;

import java.awt.event.*;
import java.util.ArrayList;

public class PianoCascadeController implements Runnable, ActionListener, KeyListener, MouseListener {

    // ---- Inici Atributs ----
    private PresentationController presentationController;
    private Float usPerTick;
    private ArrayList<ArrayList<Notes>> partitura;
    private int speed;
    // ---- Fi Atributs ----
    // ---- Inici Constructor ----
    public PianoCascadeController(ArrayList<ArrayList<Notes>> partitura, Float usPerTick) {//pasarle la cancion y datos
    this.partitura = partitura;
    this.usPerTick = usPerTick;
    this.speed = 1;     //-------canviar-------/
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerMasterController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }
    @Override
    public void run(){
        while(true){
                System.out.println("macbook pro");
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //codigo abajo







        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            //NavBar
            case JFMainFrame.SONGS:
                presentationController.changeView(JFMainFrame.SONGS);
                break;
            case JFMainFrame.FAVS:
                presentationController.changeView(JFMainFrame.FAVS);
                break;
            case JFMainFrame.PIANO:
                presentationController.changeView(JFMainFrame.PIANO_CASCADE);
                break;
            case JFMainFrame.PROFILE:
                presentationController.changeView(JFMainFrame.PROFILE);
                break;

            //PianoCascade View
            /*case bla:
                break;*/
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
