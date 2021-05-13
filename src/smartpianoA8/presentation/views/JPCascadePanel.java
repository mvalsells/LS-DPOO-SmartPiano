package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.RectanglesCascada;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class JPCascadePanel extends JPanel {
    private RectanglesCascada nota;
    private ArrayList<RectanglesCascada> arrayRectangles = new ArrayList<>();
    private HashMap<Integer, ArrayList<RectanglesCascada>> notesVistes = new HashMap<>();
    private int finalPantalla;

    public JPCascadePanel(){
        //vista mínima
        setBackground(Color.white);
    }

    public void inscriureNota(int speed, int duracio, int startTime, int notaSo, int x, int canal){
        nota = new RectanglesCascada(canal, notaSo, speed, x, duracio, startTime);

        if(notesVistes.containsKey(startTime)){
            notesVistes.get(startTime).add(nota);
        }
        else{
            ArrayList<RectanglesCascada> rectangles = new ArrayList<>();
            rectangles.add(nota);
            notesVistes.put(startTime, rectangles);
        }
        arrayRectangles.add(nota);
    }

    @Override
    public void paintComponent(Graphics graphics){
        //defualt
        super.paintComponent(graphics);

        //custom
        Graphics2D graphics2d = (Graphics2D) graphics;
        RectanglesCascada temp;
        for(int i=0; i<arrayRectangles.size(); i++){
            temp = arrayRectangles.get(i);
            graphics2d.setColor(Color.black);
            if(temp.y < finalPantalla){
                graphics2d.fill(temp);
                graphics2d.setColor(Color.white);
                graphics2d.draw(temp);
            }else{
                arrayRectangles.remove(i);
                i--;
            }
        }
    }

    public HashMap<Integer, ArrayList<RectanglesCascada>> getNotesVistes(){
        return notesVistes;
    }
}
