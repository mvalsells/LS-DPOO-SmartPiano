package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class GraficsStatisticsDreta extends JPanel {
    public GraficsStatisticsDreta(){
    }

    @Override
    protected void paintComponent(Graphics grafics){
        super.paintComponent(grafics);

        grafics.setColor(Color.red);
        grafics.drawRect((int) (getWidth()/2 - getWidth()*0.9/2), (int)(getHeight()/2-getHeight()*0.9/2), (int)(getWidth()/2 - getWidth()*0.9/2), (int)(getHeight()/2-getHeight()*0.9/2));
        //aquí el custom
    }


}
