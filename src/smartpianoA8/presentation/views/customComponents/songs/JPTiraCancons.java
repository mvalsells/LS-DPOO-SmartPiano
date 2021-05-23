package smartpianoA8.presentation.views.customComponents.songs;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.JLColor;
import smartpianoA8.presentation.views.customComponents.JPMainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 *
 * Esta clase se encarga principalmente de poder ejecutar el scrollPane de las canciones que tiene una playlist, es decir,
 * con una playlist indica las canciones que contiene.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2222.
 */
public class JPTiraCancons extends JPMainView {

    //private JButton[] jbButton;

    public static final String PAPELERA = "deleteSong-";

    private ActionListener controller;

    private JPanel jpAmbSongs;

    private JLabel jlNoHayCanciones;
    private JLabel jlTitul;
    private ArrayList<JPCanco> jpCanço;
    //private JLabel jlSongNomText;
    //private JLabel jlSongInfoText;

    private JScrollPane jsp;

    //private ArrayList<Song> songs;


    /**
     * Constructor de la clase JPTiraCancons
     */
    public JPTiraCancons(){

        setLayout(new BorderLayout());

        jpAmbSongs = new JPMainView();
        jpAmbSongs.setLayout(new FlowLayout());
        //jpAmbSongs.setLayout(new BoxLayout(jpAmbSongs,BoxLayout.X_AXIS));

        JPanel jpExtra = new JPMainView();
        jpExtra.setLayout(new BoxLayout(jpExtra,BoxLayout.Y_AXIS));

        jlNoHayCanciones = new JLColor("NO HAY CANCIONES EN TU PLAYLIST",Color.WHITE,new Font("Verdana",Font.BOLD,22));
        jlTitul = new JLColor("",Color.white);

        add(jlTitul,BorderLayout.NORTH);

        //jbButton = new ArrayList<>();

        /*jpCanço = new JPMainView();
        jpCanço.setLayout(new BoxLayout(jpCanço, BoxLayout.Y_AXIS));*/

        /*jlSongNomText = new JLColor("", ColorScheme.PRIMARY);
        jlSongInfoText = new JLColor("", ColorScheme.Secondary);*/


        jpAmbSongs.add(jlNoHayCanciones);

        jsp = new JScrollPane(jpAmbSongs,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jsp.setOpaque(false);
        jsp.getHorizontalScrollBar().setOpaque(false);
        //jsp.getHorizontalScrollBar().getComponent(1).setVisible(false);
        //jsp.getHorizontalScrollBar().getComponent(0).setVisible(false);
        add(jsp,BorderLayout.CENTER);


    }//Cierre del constructor

    /**
     * Funcio que omple el panell associat a un JScrollPane on es mostraran les cançons que conte una playlist. Rep per parametre les cançons de la playlist i el seu titul.
     * @param songs
     * @param titul
     */
    public void updateTira(ArrayList<Song> songs, String titul){

        jpAmbSongs.removeAll();

        //jbButton = new ArrayList<>();
        if(songs==null) {

            jlTitul.setText(titul);
            jpCanço = new ArrayList<>();

        }else  {
            //jbButton = new JButton[songs.size()];
            jpCanço = new ArrayList<>();

            jlTitul.setText(titul);

            for (int i = 0; i < songs.size(); i++) {

                StringBuilder sbCommand_1 = new StringBuilder();
                sbCommand_1.append(JPSongs.SONG_PRESSED);
                sbCommand_1.append(songs.get(i).getIdSong());

                /*jbButton[i] = new JButton();
                jbButton[i].setIcon(musicIcon);
                jbButton[i].setActionCommand(sbCommand.toString());
                jbButton[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
                jbButton[i].setOpaque(false);
                jbButton[i].setContentAreaFilled(false);
                jbButton[i].setBorderPainted(false);*/

                JButton jbCanco = new JButton();
                jbCanco.setActionCommand(sbCommand_1.toString());

                StringBuilder sbCommand_2 = new StringBuilder();
                sbCommand_2.append(PAPELERA);
                sbCommand_2.append(songs.get(i).getIdSong());

                JButton jbPapelera = new JButton();
                jbPapelera.setActionCommand(sbCommand_2.toString());

                String nomCanço = songs.get(i).getNom();
                StringBuilder sbName = new StringBuilder();

                if (songs.get(i).getNom().length() > 21) {
                    int k = 0;

                    while (k < songs.get(i).getNom().length()) {
                        if (k != 0) {
                            sbName.append("-<br/>");
                        } else if (k == 0) {
                            sbName.append("<html>");
                        }
                        sbName.append(nomCanço, k, Math.min(k + 21, songs.get(i).getNom().length()));

                        System.out.println(sbName.toString());

                        k += 22;

                    }
                    sbName.append("<html>");
                } else {
                    sbName.append(songs.get(i).getNom());
                }

                String nomAutor = songs.get(i).getAutor();
                StringBuilder sbAutor = new StringBuilder();

                if (songs.get(i).getAutor().length() > 21) {
                    int k = 0;

                    while (k < songs.get(i).getAutor().length()) {
                        if (k != 0) {
                            sbAutor.append("-<br/>");
                        } else if (k == 0) {
                            sbAutor.append("<html>");
                        }
                        sbAutor.append(nomAutor, k, Math.min(k + 21, songs.get(i).getAutor().length()));

                        System.out.println(sbAutor.toString());

                        k += 22;

                    }
                    sbAutor.append("<html>");
                } else {
                    sbAutor.append(songs.get(i).getAutor());
                }


                /*jlSongNomText.setText(sbName.toString());
                jlSongInfoText.setText(songs.get(i).getAutor());

                jpCanço.add(jbTMP);
                jpCanço.add(jlSongNomText);
                jpCanço.add(jlSongInfoText);*/

                jpCanço.add(new JPCanco(jbCanco,sbName.toString(),sbAutor.toString(),jbPapelera));
                //jpCanço.repaint();

                jpAmbSongs.add(jpCanço.get(i));
                //jpAmbSongs.repaint();
                //jpAmbSongs.revalidate();
            }



        }

        repaint();
    }//Cierre del método

    /**
     * Funció que donada una canço passada per parametre l'afegeix al panell per a ser mostrada i actualitza la vista
     * @param song
     */
    public void updateWhenAdd(Song song){


        StringBuilder sbCommand_1 = new StringBuilder();
        sbCommand_1.append(JPSongs.SONG_PRESSED);
        sbCommand_1.append(song.getIdSong());


        JButton jbTMP = new JButton();
        jbTMP.setActionCommand(sbCommand_1.toString());
        //jbTMP.addActionListener(controller);

        StringBuilder sbCommand_2 = new StringBuilder();
        sbCommand_2.append(PAPELERA);
        sbCommand_2.append(song.getIdSong());

        JButton jbPapelera = new JButton();
        jbPapelera.setActionCommand(sbCommand_2.toString());

        String nomCanço = song.getNom();
        StringBuilder sbName = new StringBuilder();

        if (song.getNom().length()-1 > 21) {
            int k = 0;

            while (k < song.getNom().length()) {
                if (k != 0) {
                    sbName.append("-<br/>");
                } else if (k == 0) {
                    sbName.append("<html>");
                }
                sbName.append(nomCanço, k, Math.min(k + 21, song.getNom().length()));

                System.out.println(sbName.toString());

                k += 22;

            }
            sbName.append("<html>");
        } else {
            sbName.append(song.getNom());
        }

        String nomAutor = song.getAutor();
        StringBuilder sbAutor = new StringBuilder();

        if (song.getAutor().length() > 21) {
            int k = 0;

            while (k < song.getAutor().length()) {
                if (k != 0) {
                    sbAutor.append("-<br/>");
                } else if (k == 0) {
                    sbAutor.append("<html>");
                }
                sbAutor.append(nomAutor, k, Math.min(k + 21, song.getAutor().length()));

                System.out.println(sbAutor.toString());

                k += 22;

            }
            sbAutor.append("<html>");
        } else {
            sbAutor.append(song.getAutor());
        }

        jpCanço.add( new JPCanco(jbTMP,sbName.toString(),sbAutor.toString(),jbPapelera));

        jpAmbSongs.add(jpCanço.get(jpCanço.size()-1));

        revalidate();

    }//Cierre del método

    /**
     * Funció que donada una canço passada per parametre l'elimina del panell i actualitza la vista
     * @param song
     */
    public void updateWhenRemove(Song song){

        for(int i=0;i<jpCanço.size();i++){

            Integer id = Integer.parseInt(jpCanço.get(i).getIDButton());

            if (id == song.getIdSong()){
                jpAmbSongs.remove(jpCanço.get(i));
            }
        }
        repaint();
    }//Cierre del método

    /**
     * Funció que passarà el ActionListener per a ser implementat en l'ultim butó afegit.
     * @param controller
     */
    public void registerControllerLastButton(ActionListener controller){

        jpCanço.get(jpCanço.size()-1).registerController(controller);

    }//Cierre del método

    /**
     * Funció que passarà el ActionListener per a ser implementat.
     * @param controller
     */
    public void registerController(ActionListener controller){

        if(jpCanço != null) {
            for (int i = 0; i < jpCanço.size(); i++) {

                jpCanço.get(i).registerController(controller);
                //newButon[i].addActionListener(controller);

            }
        }
    }//Cierre del método
}//Cierre de la clase
