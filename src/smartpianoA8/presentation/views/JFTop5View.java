package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.ImageView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JFTop5View extends JFrame{
    private static final Color gris = new Color(40,45,53);
    private static final Color lletrta = new Color(186,189,191);

    public JFTop5View(ArrayList<Song> topSongs){
        setResizable(true);
        setTitle("Top 5 cançons");
        setLocationRelativeTo(null);
       // setSize(600,350);
        setMinimumSize(new Dimension(1400,450));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);

        Font negreta = new Font("ABeeZee", Font.PLAIN,14);


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
        //panellImatge.setMaximumSize(new Dimension(30,30));
        panellTitol.setLayout(new BorderLayout());
        JLabel titol = new JLabel("TOP 5 DPOO SONGS");
        titol.setFont(new Font("Verdana",Font.BOLD, 22));
        titol.setBorder(BorderFactory.createEmptyBorder(5,3,100,20));
        panellTitol.add(titol, BorderLayout.WEST);
        titol.setForeground(Color.white);


        //baix
        boxBaix.setLayout(new BorderLayout());
        JPanel panelBaix = new JPanel();
        panelBaix.setBackground(gris);
        panelBaix.setBorder(BorderFactory.createEmptyBorder(5,20,20, 5));
        panelBaix.setLayout(new BorderLayout());


        JPanel top = new JPanel();
        top.setBackground(gris);
        top.setLayout(new GridLayout(6,1));

        JPanel nom = new JPanel();
        nom.setBackground(gris);
        nom.setLayout(new GridLayout(6,1));

        JPanel numrep = new JPanel();
        numrep.setBackground(gris);
        numrep.setLayout(new GridLayout(6,1));

        JPanel autor = new JPanel();
        autor.setBackground(gris);
        autor.setLayout(new GridLayout(6,1));

        JPanel distincio = new JPanel();
        distincio.setLayout(new BorderLayout());

        /*Calaix top*/
       // Container calaixTop = this.getContentPane();
       // calaixTop.setLayout(new GridLayout(5,1));
        //GridLayout calaixTop = new GridLayout(5,1);
        JPanel[] calaixTop = new JPanel[6];
        JPanel[] calaixNom = new JPanel[6];
        JPanel[] calaixNumrep = new JPanel[6];
        JPanel[] calaixAutor = new JPanel[6];
        JLabel[] TOP = new JLabel[6];
        JLabel[] NOM = new JLabel[6];
        JLabel[] NUMREP = new JLabel[6];
        JLabel[] AUTOR = new JLabel[6];

        top.setBorder(BorderFactory.createEmptyBorder(0,0,130,30));
        nom.setBorder(BorderFactory.createEmptyBorder(0,0,130,180));
        autor.setBorder(BorderFactory.createEmptyBorder(0,50,130,150));
        numrep.setBorder(BorderFactory.createEmptyBorder(0,50,130,70));




        /*String[] tops = {"#","1","2","3","4","5"};
        String[] noms = {"TITULO","TOP","TOP","TOP","TOP","TOP"};
        String[] autors = {"ARTISTA","TOP","TOP","TOP","TOP","TOP"};
        String[] reps = {"REPRODUCCIONES",topSongs.get(0).getNumReproduccions(),topSongs.get(1).getNumReproduccions(),topSongs.get(2).getNumReproduccions(),topSongs.get(3).getNumReproduccions(),topSongs.get(4).getNumReproduccions()};
*/      int j = 0;
        for(int i = 0; i<6; i++ ){

            calaixTop[i] = new JPanel();
            calaixNom[i] = new JPanel();
            calaixAutor[i] = new JPanel();
            calaixNumrep[i] = new JPanel();

            if(i==0){
                TOP[i]= new JLabel("#");
                NOM[i]= new JLabel("TITULO");
                AUTOR[i]= new JLabel("ARTISTA");
                NUMREP[i]= new JLabel("REPRODUCCIONES");
            }else{
                String strAutor = topSongs.get(j).getAutor();
                TOP[i]= new JLabel(""+i);
                NOM[i]= new JLabel(topSongs.get(j).getNom());
                NUMREP[i]= new JLabel(String.valueOf(topSongs.get(j).getNumReproduccions()));
                AUTOR[i]= new JLabel(strAutor);

                if (strAutor.compareTo("Master") == 0) strAutor = topSongs.get(j).getNomUsuari();
                j++;
                //autor[i] = new JLabel(strAutor);


            }



            TOP[i].setForeground(lletrta);
            TOP[i].setFont(negreta);
            TOP[i].setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));



            //algo pasa amb el nom

            //NOM[i]= new JLabel("TOP"+i);
            NOM[i].setForeground(lletrta);
            NOM[i].setFont(negreta);
            NOM[i].setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));



           // AUTOR[i]= new JLabel("TOP"+i);
            AUTOR[i].setForeground(lletrta);
            AUTOR[i].setFont(negreta);
            AUTOR[i].setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));



            //NUMREP[i]= new JLabel("TOP"+i);
            NUMREP[i].setForeground(lletrta);
            NUMREP[i].setFont(negreta);
            NUMREP[i].setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));





            calaixTop[i].add(TOP[i]);
            calaixTop[i].setOpaque(false);

            calaixNom[i].add(NOM[i]);
            calaixNom[i].setOpaque(false);

            calaixAutor[i].add(AUTOR[i]);
            calaixAutor[i].setOpaque(false);

            calaixNumrep[i].add(NUMREP[i]);
            calaixNumrep[i].setOpaque(false);

            top.add(calaixTop[i]);
            nom.add(calaixNom[i]);
            autor.add(calaixAutor[i]);
            numrep.add(calaixNumrep[i]);



        }

        distincio.add(top, BorderLayout.WEST);
        distincio.add(nom,BorderLayout.CENTER);

        panelBaix.add(autor,BorderLayout.CENTER);
        //distincio.setBorder(BorderFactory.createEmptyBorder());
        panelBaix.add(numrep,BorderLayout.EAST);
        panelBaix.add(distincio,BorderLayout.WEST);
        //((GridLayout)calaixTop.getLayout()).setHgap(10);
        //((GridLayout)calaixTop.getLayout()).setVgap(10);





        boxBaix.add(panelBaix, BorderLayout.CENTER);

        fonsBox.add(boxDalt);
        fonsBox.add(boxBaix);

        //calaixos
        /*JPanel[] calaixos = new JPanel[5];
        JLabel[] top = new JLabel[5];
        JLabel[] nom = new JLabel[5];
        JLabel[] numrep = new JLabel[5];
        JLabel[] autor = new JLabel[5];
        JLabel[] data = new JLabel[5];*/


        //cada una
        /*for(int i = 0; i<5; i++) {
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
        }*/
        add(fonsBox);


    }
}
