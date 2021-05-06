package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;

public class GraficsStatisticsEsquerra extends JPanel {
    public GraficsStatisticsEsquerra(){
    }

    @Override
    protected void paintComponent(Graphics grafics){
        super.paintComponent(grafics);

        grafics.setColor(Color.red);
        grafics.drawRect((int) (getWidth()/2 - getWidth()*0.9/2), (int)(getHeight()/2-getHeight()*0.9/2), (int)(getWidth()/2 - getWidth()*0.9/2), (int)(getHeight()/2-getHeight()*0.9/2));
        //aquí el custom
    }


}
