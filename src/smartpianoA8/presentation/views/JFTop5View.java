package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.ImageView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * Esta clase se encarga principalmente de mostrar el frame donde se encuentran el panel asociado al Top5,
 * además también podemos encotnrar la función para actalizar el Frame.
 *
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @version 1.0
 */
public class JFTop5View extends JFrame{
    private static final Color gris = new Color(40,45,53);
    private static final Color lletrta = new Color(186,189,191);
    private ArrayList<Song> topSongsComu;
    private JPanel fons;
    private JLabel[] TOP = new JLabel[6];
    private JLabel[] NOM = new JLabel[6];
    private JLabel[] NUMREP = new JLabel[6];
    private JLabel[] AUTOR = new JLabel[6];

    /**
     * Contructor de la clase JFTop5View
     * @param topSongs Parametro donde indica en el arraylist las posiciones de las canciones.
     */
    public JFTop5View(ArrayList<Song> topSongs){
        this.topSongsComu = topSongs;
        this.fons = new JPanel();

        setResizable(true);
        setTitle("Top 5 cançons");
        setLocationRelativeTo(null);
       // setSize(600,350);
        setMinimumSize(new Dimension(1400,450));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);

        Font negreta = new Font("ABeeZee", Font.PLAIN,14);


        //fons
        fons.setLayout(new BoxLayout(fons, BoxLayout.Y_AXIS));
        fons.setBackground(Color.white);



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

        JPanel[] calaixTop = new JPanel[6];
        JPanel[] calaixNom = new JPanel[6];
        JPanel[] calaixNumrep = new JPanel[6];
        JPanel[] calaixAutor = new JPanel[6];


        top.setBorder(BorderFactory.createEmptyBorder(0,0,130,30));
        nom.setBorder(BorderFactory.createEmptyBorder(0,0,130,180));
        autor.setBorder(BorderFactory.createEmptyBorder(0,50,130,150));
        numrep.setBorder(BorderFactory.createEmptyBorder(0,50,130,70));




        int j = 0;
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
                if(topSongsComu.get(j).getNumReproduccions() == 0){
                    TOP[i] = new JLabel("");
                    NOM[i] = new JLabel("");
                    NUMREP[i] = new JLabel("");
                    AUTOR[i] = new JLabel("");
                }else {
                    String strAutor = topSongsComu.get(j).getAutor();
                    TOP[i] = new JLabel("" + i);
                    NOM[i] = new JLabel(topSongsComu.get(j).getNom());
                    NUMREP[i] = new JLabel(String.valueOf(topSongsComu.get(j).getNumReproduccions()));

                    if (strAutor.compareTo("Master") != 0) {
                        strAutor = topSongsComu.get(j).getAutor();
                    } else {
                        strAutor = topSongsComu.get(j).getNomUsuari();
                    }

                    AUTOR[i] = new JLabel(strAutor);
                    j++;
                }

            }



            TOP[i].setForeground(lletrta);
            TOP[i].setFont(negreta);
            TOP[i].setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));



            //algo pasa amb el nom


            NOM[i].setForeground(lletrta);
            NOM[i].setFont(negreta);
            NOM[i].setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));




            AUTOR[i].setForeground(lletrta);
            AUTOR[i].setFont(negreta);
            AUTOR[i].setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));


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

        panelBaix.add(numrep,BorderLayout.EAST);
        panelBaix.add(distincio,BorderLayout.WEST);




        boxBaix.add(panelBaix, BorderLayout.CENTER);

        fonsBox.add(boxDalt);
        fonsBox.add(boxBaix);


        add(fonsBox);


    }//Cierre del constructor

    /**
     * Mètode per actualitzar els valors del top view
     * @param newTopSongs les noves top Songs en ArrayList<Song>
     */
    public void updateTop5View(ArrayList<Song> newTopSongs){
        this.topSongsComu = newTopSongs;

        /*for (int i=0; i<6;i++){
            String strAutor = topSongsComu.get(i).getAutor();
            TOP[i].setText();
            NOM[i] = new JLabel(topSongsComu.get(i).getNom());
            NUMREP[i] = new JLabel(String.valueOf(topSongsComu.get(i).getNumReproduccions()));

            if (strAutor.compareTo("Master") != 0) {
                strAutor = topSongsComu.get(i).getAutor();
            } else {
                strAutor = topSongsComu.get(i).getNomUsuari();
            }

            AUTOR[i] = new JLabel(strAutor);
        }*/


        fons.repaint();
        fons.revalidate();
    }//Cierre del método
}//Cierre de la clase
