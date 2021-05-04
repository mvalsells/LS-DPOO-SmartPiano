package smartpianoA8.presentation.views;
import smartpianoA8.business.entity.EstadisticaMinuts;
import smartpianoA8.business.entity.EstadisticaReproduccions;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StaticsView extends JFrame {
    public  StaticsView(ArrayList<EstadisticaMinuts> valorsMinuts, ArrayList<EstadisticaReproduccions> valorsReproduccions){
        //la vista en si

        //parametres
        setResizable(true);
        setTitle("Estadístiques");
        setLocationRelativeTo(null);
        setSize(300,650);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // NO SÉ QUÈ FA AIXÒ HAHA

        //fons |__|
        JPanel fons = new JPanel();
        fons.setLayout(new BorderLayout());

        //panells bessos |[][]|
        JPanel dreta = new JPanel();
        JPanel esquerra = new JPanel();
        fons.add(dreta, BorderLayout.WEST);
        fons.add(esquerra, BorderLayout.EAST);

        //gràfic reproduccions
        //TODO crear gràfic dreta
        //TODO afegir el gráfic al panell "dreta"

        //gràfic minuts
        //TODO crear el gràfic esquerra
        //TODO afegir el gráfic al panell "esquerra"



        //parametres finals
        add(fons);
        setMinimumSize(new Dimension(200, 400));
        pack();//TODO mirar si aixó ajuda o empitjora
    }

}
