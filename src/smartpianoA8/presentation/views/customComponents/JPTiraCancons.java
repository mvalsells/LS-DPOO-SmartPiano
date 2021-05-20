package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPTiraCancons extends JPMainView{

    //private JButton[] jbButton;

    private ActionListener controller;

    private JPanel jpAmbSongs;

    private JLabel jlNoHayCanciones;
    private JLabel jlTitul;
    private JPCanco[] jpCanço;
    //private JLabel jlSongNomText;
    //private JLabel jlSongInfoText;

    private JScrollPane jsp;

    //private ArrayList<Song> songs;





    public JPTiraCancons(){

        setLayout(new BorderLayout());

        jpAmbSongs = new JPMainView();
        jpAmbSongs.setLayout(new FlowLayout());
        //jpAmbSongs.setLayout(new BoxLayout(jpAmbSongs,BoxLayout.X_AXIS));

        JPanel jpExtra = new JPMainView();
        jpExtra.setLayout(new BoxLayout(jpExtra,BoxLayout.Y_AXIS));

        jlNoHayCanciones = new JLColor("NO HAY CANCIONES EN TU PLAYLIST",Color.WHITE,new Font("Verdana",Font.BOLD,25));
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


    }

    public void updateTira(ArrayList<Song> songs, String titul){

        jpAmbSongs.removeAll();

        //jbButton = new ArrayList<>();
        if(songs==null) {

            jlTitul.setText(titul);

        }else  {
            //jbButton = new JButton[songs.size()];
            jpCanço = new JPCanco[songs.size()];

            jlTitul.setText(titul);

            for (int i = 0; i < songs.size(); i++) {

                StringBuilder sbCommand = new StringBuilder();
                sbCommand.append(JPSongs.SONG_PRESSED);
                sbCommand.append(songs.get(i).getIdSong());

                /*jbButton[i] = new JButton();
                jbButton[i].setIcon(musicIcon);
                jbButton[i].setActionCommand(sbCommand.toString());
                jbButton[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
                jbButton[i].setOpaque(false);
                jbButton[i].setContentAreaFilled(false);
                jbButton[i].setBorderPainted(false);*/

                JButton jbTMP = new JButton();
                jbTMP.setActionCommand(sbCommand.toString());
                jbTMP.addActionListener(controller);

                String nomCanço = songs.get(i).getNom();
                StringBuilder sbName = new StringBuilder();

                if (songs.get(i).getNom().length() > 24) {
                    int k = 0;

                    while (k < songs.get(i).getNom().length()) {
                        if (k != 0) {
                            sbName.append("-<br/>");
                        } else if (k == 0) {
                            sbName.append("<html>");
                        }
                        sbName.append(nomCanço, k, Math.min(k + 24, songs.get(i).getNom().length()));

                        System.out.println(sbName.toString());

                        k += 25;

                    }
                    sbName.append("<html>");
                } else {
                    sbName.append(songs.get(i).getNom());
                }


                /*jlSongNomText.setText(sbName.toString());
                jlSongInfoText.setText(songs.get(i).getAutor());

                jpCanço.add(jbTMP);
                jpCanço.add(jlSongNomText);
                jpCanço.add(jlSongInfoText);*/
                jpCanço[i] = new JPCanco(jbTMP,sbName.toString(),songs.get(i).getAutor());
                //jpCanço.repaint();

                jpAmbSongs.add(jpCanço[i]);
                //jpAmbSongs.repaint();
                //jpAmbSongs.revalidate();
            }



        }

        repaint();
    }

    /*public void updateWhenAdd(Song song,String type){

        switch (type){
            case JPPlaylistSettings.ADD:
                jpCanço.

                jlTitul.setText(titul);

                for (int i = 0; i < songs.size(); i++) {

                    StringBuilder sbCommand = new StringBuilder();
                    sbCommand.append(JPSongs.SONG_PRESSED);
                    sbCommand.append(songs.get(i).getIdSong());


                    JButton jbTMP = new JButton();
                    jbTMP.setActionCommand(sbCommand.toString());
                    jbTMP.addActionListener(controller);

                    String nomCanço = songs.get(i).getNom();
                    StringBuilder sbName = new StringBuilder();

                    if (songs.get(i).getNom().length() > 24) {
                        int k = 0;

                        while (k < songs.get(i).getNom().length()) {
                            if (k != 0) {
                                sbName.append("-<br/>");
                            } else if (k == 0) {
                                sbName.append("<html>");
                            }
                            sbName.append(nomCanço, k, Math.min(k + 24, songs.get(i).getNom().length()));

                            System.out.println(sbName.toString());

                            k += 25;

                        }
                        sbName.append("<html>");
                    } else {
                        sbName.append(songs.get(i).getNom());
                    }



                    jpCanço[i] = new JPCanco(jbTMP,sbName.toString(),songs.get(i).getAutor());


                    jpAmbSongs.add(jpCanço[i]);

                }



        }

        }

    }*/

    public void registerController(ActionListener controller){

        this.controller = controller;
        /*for(int i=0; i< jpCanço.length; i++){

            jbButton[i].addActionListener(controller);
            //newButon[i].addActionListener(controller);

        }*/

    }
}
