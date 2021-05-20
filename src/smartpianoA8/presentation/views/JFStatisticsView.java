package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.GraficsStatisticsDreta;
import smartpianoA8.presentation.views.customComponents.GraficsStatisticsEsquerra;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JFStatisticsView extends JFrame {

    private static final Color color1 = new Color(255, 218,255);
    private static final Color color2 = new Color(194, 250, 255);
    private ArrayList<Double> valorsMinutsComu;
    private ArrayList<Integer> valorReproduccionsComu;
    private JPanel fons;
    private GraficsStatisticsEsquerra graficEsquerra;
    private GraficsStatisticsDreta graficDreta;

    /**
     * Constructor de la vista
     * @param valorsMinuts llista de valors de minuts (amb decimals).
     * @param valorsReproduccions llista de valors de reproduccions
     */
    public JFStatisticsView(ArrayList<Double> valorsMinuts, ArrayList<Integer> valorsReproduccions){
        //parametres
        this.valorsMinutsComu = valorsMinuts;
        this.valorReproduccionsComu = valorsReproduccions;
        this.fons = new JPanel();
        setResizable(true);
        setTitle("Estadístiques");
        setLocationRelativeTo(null);
        setSize(1000,800);
        setMinimumSize(new Dimension(1000,800));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        //pack();

        //fons |__|
        fons.setLayout(new BorderLayout());
        add(fons);

        Box box = Box.createHorizontalBox();
        box.setBackground(Color.blue);

        //panells bessos |[][]|
        JPanel dreta = new JPanel();
        JPanel esquerra = new JPanel();

        dreta.setLayout(new BorderLayout());
        esquerra.setLayout(new BorderLayout());
        dreta.setBackground(Color.white);
        esquerra.setBackground(Color.white);

        dreta.setPreferredSize(new Dimension(getWidth()/2, getHeight()));
        esquerra.setPreferredSize(new Dimension(getWidth()/2, getHeight()));
        box.add(esquerra);
        box.add(dreta);

        JLabel titol2 = new JLabel("Songs Played by User");
        titol2.setHorizontalAlignment(JLabel.CENTER);
        JLabel titol1 = new JLabel("Minutes Listened by User");
        titol1.setHorizontalAlignment(JLabel.CENTER);

        dreta.add(titol2, BorderLayout.NORTH);
        esquerra.add(titol1, BorderLayout.NORTH);
        box.setBackground(Color.white);
        fons.add(box, BorderLayout.CENTER);

        //------llegendes------//
        JPanel llegenda1 = new JPanel();
        JPanel llegenda2 = new JPanel();
        llegenda1.setLayout(new FlowLayout(FlowLayout.CENTER));
        llegenda2.setLayout(new FlowLayout(FlowLayout.CENTER));
        llegenda1.setBackground(Color.white);
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

        graficEsquerra = new GraficsStatisticsEsquerra(valorsMinuts, color1);
        graficDreta = new GraficsStatisticsDreta(valorReproduccionsComu, color2);
        graficDreta.setBackground(Color.white);
        graficEsquerra.setBackground(Color.white);
        esquerra.add(graficEsquerra, BorderLayout.CENTER);
        dreta.add(graficDreta, BorderLayout.CENTER);

    }

    /**
     * Mètode per actualitzar els valors de les grafiques
     * @param nousValorsMinuts ArrayList de minuts reproduits
     * @param nousValorsReproduccions ArrayList de reproduccions fetes
     */
    //TODO executar això quan tinguem noves dades de la bbdd, que és quan: -es reprodueixi una nova cançó
    public void updateStaticsView(ArrayList<Double> nousValorsMinuts, ArrayList<Integer> nousValorsReproduccions){
        this.valorsMinutsComu = nousValorsMinuts;
        this.valorReproduccionsComu = nousValorsReproduccions;
        //TODO porvar a treure això de sota a veure si funciona igual
        graficDreta.repaint();
        graficDreta.revalidate();

        graficEsquerra.repaint();
        graficDreta.revalidate();
    }
}