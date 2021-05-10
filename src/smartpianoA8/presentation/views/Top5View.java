package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.ImageView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Top5View extends JFrame{
    private static final Color gris = new Color(40,45,53);

    public Top5View(ArrayList<Song> topSongs){
        setResizable(true);
        setTitle("Top 5 cançons");
        setLocationRelativeTo(null);
        setSize(600,350);
        setMinimumSize(new Dimension(600,350));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);

        Font negreta = new Font("Courier", Font.BOLD,14);


        //fons
        JPanel fons = new JPanel();
        fons.setLayout(new BoxLayout(fons, BoxLayout.Y_AXIS));
        fons.setBackground(Color.white);


        //titol
        //JLabel titol = new JLabel("TOP 5 CANÇONS REPRODUIDES WORLDWIDE");
        //titol.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        //fons.add(titol);
        //titol.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel fonsBox = new JPanel();
        fonsBox.setLayout(new BoxLayout(fonsBox, BoxLayout.Y_AXIS));

        JPanel boxDalt = new JPanel();
        JPanel boxBaix = new JPanel();

        fonsBox.add(boxDalt);
        fonsBox.add(boxBaix);

        //dalt
        boxDalt.setLayout(new BorderLayout());

        ImageView imatgeTop5 = new ImageView(new ImageIcon("Imagen/ImagenesTop5/top5.jpg").getImage());

        JPanel panellImatge = new JPanel();
        panellImatge.setBackground(gris);
        JPanel panellTitol = new JPanel();
        panellTitol.setBackground(gris);
        boxDalt.add(panellImatge, BorderLayout.WEST);
        boxDalt.add(panellTitol, BorderLayout.CENTER);

        panellImatge.add(imatgeTop5);
        panellImatge.setMaximumSize(new Dimension(30,30));
        panellTitol.setLayout(new BorderLayout());
        JLabel titol = new JLabel("TOP 5 DPOO SONGS");
        titol.setFont(new Font("Verdana",Font.BOLD, 22));
        titol.setBorder(BorderFactory.createEmptyBorder(5,1,100,20));
        panellTitol.add(titol, BorderLayout.WEST);
        titol.setForeground(Color.white);


        //baix
        //calaixos
        JPanel[] calaixos = new JPanel[5];
        JLabel[] top = new JLabel[5];
        JLabel[] nom = new JLabel[5];
        JLabel[] numrep = new JLabel[5];
        JLabel[] autor = new JLabel[5];
        JLabel[] data = new JLabel[5];

        //cada una
        for(int i = 0; i<5; i++) {
            calaixos[i] = new JPanel();
            if(i % 2 !=0){
                calaixos[i].setBackground(Color.white);
            }else{
                calaixos[i].setBackground(Color.lightGray);
            }

            top[i] = new JLabel("TOP " + (i+1));
            top[i].setFont(negreta);
            top[i].setBorder(BorderFactory.createEmptyBorder(5, 10, 1, 0));
            nom[i] = new JLabel(topSongs.get(i).getNom());
            nom[i].setBorder(BorderFactory.createEmptyBorder(5, 8, 1, 8));
            numrep[i] = new JLabel(topSongs.get(i).getNumReproduccions() + " PLAYS");
            numrep[i].setForeground(Color.orange);
            numrep[i].setBorder(BorderFactory.createEmptyBorder(5, 8, 1, 8));
            String strAutor = topSongs.get(i).getAutor();
            if (strAutor.compareTo("Master") == 0) strAutor = topSongs.get(i).getNomUsuari();
            autor[i] = new JLabel(strAutor);
            autor[i].setBorder(BorderFactory.createEmptyBorder(5, 8, 1, 8));
            data[i] = new JLabel(topSongs.get(i).getDataEnregistrament());
            data[i].setBorder(BorderFactory.createEmptyBorder(5, 0, 1, 8));

            calaixos[i].add(top[i]);
            calaixos[i].add(numrep[i]);
            calaixos[i].add(nom[i]);
            calaixos[i].add(autor[i]);
            calaixos[i].add(data[i]);
            fons.add(calaixos[i]);
        }
        add(fonsBox);


    }
}
