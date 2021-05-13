package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.presentation.views.JPCascadePanel;
import javax.swing.*;
import java.util.ArrayList;

public class PianoCascadeController extends JPanel implements  Runnable{

    // ---- Inici Atributs ----
    private PresentationController presentationController;
    private JPCascadePanel cascada;
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

}
