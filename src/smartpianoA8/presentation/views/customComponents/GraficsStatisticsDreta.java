package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;

public class GraficsStatisticsDreta extends JPanel {
    public GraficsStatisticsDreta(){ }

    @Override
    protected void paintComponent(Graphics grafics){
        super.paintComponent(grafics);

        int width = (int)(getWidth()*0.8);
        int heigh = (int)(getHeight()*0.8);
        grafics.setColor(Color.black);
        grafics.drawRect(getWidth()/2 - width/2,getHeight()/2 - heigh/2, width, heigh);

    }


}
