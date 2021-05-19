package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPTiraCancons extends JPMainView{

    private JButton jbMasButton[];

    private ArrayList<Song> songs;

    ImageIcon musicIcon = new ImageIcon("Imagen/ImagenesMenu/music.png");

    public JPTiraCancons(ArrayList<Song> songs, String titul){

        this.songs = songs;

        setLayout(new BorderLayout());

        JPanel jpAmbSongs = new JPMainView();
        jpAmbSongs.setLayout(new FlowLayout(FlowLayout.LEADING));

        if(songs==null) {

            JLabel jlNoHayCanciones = new JLColor("NO HAY CANCIONES EN TU PLAYLIST",Color.WHITE,new Font("Verdana",Font.BOLD,25));
            JLabel jlTitul = new JLColor(titul,Color.white);

            add(jlTitul,BorderLayout.NORTH);
            add(jlNoHayCanciones,BorderLayout.CENTER);
        }else  {
            jbMasButton = new JButton[songs.size()];

            for (int i = 0; i < songs.size(); i++) {

                JPanel jpCanço = new JPMainView();
                jpCanço.setLayout(new BoxLayout(jpCanço, BoxLayout.Y_AXIS));

                StringBuilder sbCommand = new StringBuilder();
                sbCommand.append(JPSongs.SONG_PRESSED);
                sbCommand.append(songs.get(i).getIdSong());
                jbMasButton[i] = new JButton();
                jbMasButton[i].setIcon(musicIcon);
                jbMasButton[i].setActionCommand(sbCommand.toString());
                jbMasButton[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
                jbMasButton[i].setOpaque(false);
                jbMasButton[i].setContentAreaFilled(false);
                jbMasButton[i].setBorderPainted(false);

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


                JLabel jlSongNomText = new JLColor(sbName.toString(), ColorScheme.PRIMARY);
                JLabel jlSongInfoText = new JLColor(songs.get(i).getAutor(), ColorScheme.Secondary);

                jpCanço.add(jbMasButton[i]);
                jpCanço.add(jlSongNomText);
                jpCanço.add(jlSongInfoText);

                jpAmbSongs.add(jpCanço);

            }
            JScrollPane jsp = new JScrollPane(jpAmbSongs,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            jsp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            jsp.setOpaque(false);
            jsp.getHorizontalScrollBar().setOpaque(false);
            jsp.getHorizontalScrollBar().getComponent(1).setVisible(false);
            jsp.getHorizontalScrollBar().getComponent(0).setVisible(false);
            JLabel jlTitul = new JLColor(titul,Color.white);

            add(jlTitul,BorderLayout.NORTH);
            add(jsp,BorderLayout.CENTER);
        }




    }

    public void registerController(ActionListener controller){

        for(int i=0; i< songs.size(); i++){

            jbMasButton[i].addActionListener(controller);
            //newButon[i].addActionListener(controller);

        }

    }
}
