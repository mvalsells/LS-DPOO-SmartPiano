package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


public class StatisticsView extends JFrame {
    /**
     * Constructor de la vista
     * @param valorsMinuts llista de valors de minuts (amb decimals).
     * @param valorsReproduccions llista de valors de reproduccions
     */
    public StatisticsView(ArrayList<Integer> valorsMinuts, ArrayList<Float> valorsReproduccions){
        //parametres
        int maxMinuts = Collections.max(valorsMinuts);
        int maxReproduccions = Collections.max(valorsReproduccions).intValue();



        setResizable(true);//TODO fer que sí ho sigui haha
        setTitle("Estadístiques");
        setLocationRelativeTo(null);
        setSize(700,400);
        setMinimumSize(new Dimension(700,400));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        //pack();

        //fons |__|
        JPanel fons = new JPanel();
        fons.setLayout(new BorderLayout());
        add(fons);

        Box box = Box.createHorizontalBox();


        //panells bessos |[][]|
        JPanel dreta = new JPanel();
        JPanel esquerra = new JPanel();

        dreta.setLayout(new BorderLayout());
        esquerra.setLayout(new BorderLayout());
        dreta.setBackground(Color.pink);
        esquerra.setBackground(Color.red);

        dreta.setPreferredSize(new Dimension(getWidth()/2, getHeight()));
        esquerra.setPreferredSize(new Dimension(getWidth()/2, getHeight()));
        box.add(esquerra);
        box.add(dreta);

        JLabel titol1 = new JLabel("Songs Played by user");
        titol1.setHorizontalAlignment(JLabel.CENTER);
        JLabel titol2 = new JLabel("Minutes Listened by user");
        titol2.setHorizontalAlignment(JLabel.CENTER);

        dreta.add(titol2, BorderLayout.NORTH);
        esquerra.add(titol1, BorderLayout.NORTH);

        fons.add(box, BorderLayout.CENTER);
        //fons.add(dreta, BorderLayout.EAST);



/*
        JPanel llegenda1 = new JPanel();
        JPanel llegenda2 = new JPanel();
        llegenda1.setLayout(new FlowLayout(FlowLayout.CENTER));
        llegenda2.setLayout(new FlowLayout(FlowLayout.CENTER));
        //llegenda1.add(); //linia blava
        llegenda1.add(new JLabel("#Songs"));
        //llegenda2.add(); //linia taronja
        llegenda2.add(new JLabel("#Minutes"));
        dreta.add(llegenda1, BorderLayout.SOUTH);
        esquerra.add(llegenda2, BorderLayout.SOUTH);


        JPanel llistaHores = new JPanel();
        llistaHores.setLayout(new FlowLayout(FlowLayout.CENTER))


        JPanel dretaIntern = new JPanel();
        dretaIntern.setLayout(new BorderLayout());
        JPanel esquerraIntern = new JPanel();
        esquerraIntern.setLayout(new BorderLayout());

        dreta.add(dretaIntern, BorderLayout.CENTER);
        esquerra.add(esquerraIntern, BorderLayout.CENTER);

        esquerraIntern.add(llistaHores, BorderLayout.SOUTH);
        dretaIntern.add(llistaHores, BorderLayout.SOUTH);
*/

    }

}
