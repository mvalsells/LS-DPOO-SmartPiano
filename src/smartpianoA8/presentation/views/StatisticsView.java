package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.GraficsStatisticsDreta;
import smartpianoA8.presentation.views.customComponents.GraficsStatisticsEsquerra;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StatisticsView extends JFrame {

    private static final Color color1 = new Color(255,216,255);
    private static final Color color2 = new Color(255, 204, 139);

    /**
     * Constructor de la vista
     * @param valorsMinuts llista de valors de minuts (amb decimals).
     * @param valorsReproduccions llista de valors de reproduccions
     */
    public StatisticsView(ArrayList<Double> valorsMinuts, ArrayList<Integer> valorsReproduccions){
        //parametres

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
        dreta.setBackground(Color.lightGray);
        esquerra.setBackground(Color.gray);

        dreta.setPreferredSize(new Dimension(getWidth()/2, getHeight()));
        esquerra.setPreferredSize(new Dimension(getWidth()/2, getHeight()));
        box.add(esquerra);
        box.add(dreta);

        JLabel titol1 = new JLabel("Songs Played by User");
        titol1.setHorizontalAlignment(JLabel.CENTER);
        JLabel titol2 = new JLabel("Minutes Listened by User");
        titol2.setHorizontalAlignment(JLabel.CENTER);

        dreta.add(titol2, BorderLayout.NORTH);
        esquerra.add(titol1, BorderLayout.NORTH);

        fons.add(box, BorderLayout.CENTER);

        //------llegendes------//
        JPanel llegenda1 = new JPanel();
        JPanel llegenda2 = new JPanel();
        llegenda1.setLayout(new FlowLayout(FlowLayout.CENTER));
        llegenda2.setLayout(new FlowLayout(FlowLayout.CENTER));
        llegenda1.setBackground(Color.WHITE);
        llegenda2.setBackground(Color.white);

        JPanel liniaRosa = new JPanel();
        JPanel liniaTaronja = new JPanel();

        liniaRosa.setBackground(color1);
        liniaTaronja.setBackground(color2);
        liniaRosa.setPreferredSize(new Dimension(25,7));
        liniaTaronja.setPreferredSize(new Dimension(25,7));

        llegenda1.add(liniaTaronja);
        llegenda1.add(new JLabel("#Songs"));
        llegenda2.add(liniaRosa);
        llegenda2.add(new JLabel("#Minutes"));
        dreta.add(llegenda1, BorderLayout.SOUTH);
        esquerra.add(llegenda2, BorderLayout.SOUTH);

        GraficsStatisticsEsquerra graficEsquerra = new GraficsStatisticsEsquerra(valorsMinuts, color1);
        GraficsStatisticsEsquerra graficDreta = new GraficsStatisticsEsquerra(valorsMinuts,color2);
        esquerra.add(graficEsquerra, BorderLayout.CENTER);
        dreta.add(graficDreta, BorderLayout.CENTER);

    }
}