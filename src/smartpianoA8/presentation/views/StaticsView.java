package smartpianoA8.presentation.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StaticsView extends JFrame {
    /**
     * Constructor de la vista
     * @param valorsMinuts llista de valors de minuts (amb decimals).
     * @param valorsReproduccions llista de valors de reproduccions
     */
    public StaticsView(ArrayList<Integer> valorsMinuts, ArrayList<Float> valorsReproduccions){
        //parametres
        int maxMinuts = Collections.max(valorsMinuts);
        int maxReproduccions = Collections.max(valorsReproduccions).intValue();



        setResizable(true);//TODO fer que sí ho sigui haha
        setTitle("Estadístiques");
        setLocationRelativeTo(null);
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // NO SÉ QUÈ FA AIXÒ HAHA

        //fons |__|
        JPanel fons = new JPanel();
        fons.setLayout(new BorderLayout());
        fons.setBackground(Color.yellow);

        //panells bessos |[][]|
        JPanel dreta = new JPanel();
        JPanel esquerra = new JPanel();

        dreta.setLayout(new BorderLayout());
        dreta.setBackground(Color.pink);
        esquerra.setBackground(Color.red);
        esquerra.setLayout(new BorderLayout());

        fons.add(dreta, BorderLayout.WEST);
        fons.add(esquerra, BorderLayout.EAST);

        dreta.add(new JLabel("#Songs"), BorderLayout.NORTH);
        esquerra.add(new JLabel("#Minutes"), BorderLayout.NORTH);

        JPanel llegenda1 = new JPanel();
        JPanel llegenda2 = new JPanel();
        llegenda1.setLayout(new FlowLayout(FlowLayout.CENTER));
        llegenda2.setLayout(new FlowLayout(FlowLayout.CENTER));
        //llegenda1.add(); //linia blava
        llegenda1.add(new JLabel("#Songs"));
        //llegenda2.add(); //linia taronja
        llegenda2.add(new JLabel("#Minutes"));
        dreta.add(llegenda2, BorderLayout.SOUTH);
        esquerra.add(llegenda1, BorderLayout.SOUTH);


        JPanel llistaHores = new JPanel();
        llistaHores.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel[] hores = new JLabel[24];
        for(int i=0; i<24;i++) {
            hores[i] = new JLabel(i + ":00");
            llistaHores.add(hores[i], FlowLayout.CENTER);
        }


        JPanel dretaIntern = new JPanel();
        dretaIntern.setLayout(new BorderLayout());
        JPanel esquerraIntern = new JPanel();
        esquerraIntern.setLayout(new BorderLayout());

        dreta.add(dretaIntern, BorderLayout.CENTER);
        esquerra.add(esquerraIntern, BorderLayout.CENTER);

        esquerraIntern.add(llistaHores, BorderLayout.SOUTH);
        dretaIntern.add(llistaHores, BorderLayout.SOUTH);



        //parametres finals
        add(fons);
        setMinimumSize(new Dimension(700, 400));
        pack();//TODO mirar si aixó ajuda o empitjora
        setVisible(true);
    }

}
