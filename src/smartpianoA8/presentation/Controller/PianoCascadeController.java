package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Notes;
import smartpianoA8.presentation.views.CascadePanel;
import javax.swing.*;
import java.util.ArrayList;

public class PianoCascadeController extends JPanel implements  Runnable{
    private CascadePanel cascada;
    private int speed;

    public PianoCascadeController(ArrayList<ArrayList<Notes>> partitura) {//pasarle la cancion y datos
    partitura.
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
