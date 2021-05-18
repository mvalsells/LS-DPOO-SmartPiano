package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayerController extends Runnable implements ActionListener {

    ArrayList<Song> songsToBePlayed;

    public PlayerController(ArrayList<Song> songsToBePlayed) {

        this.songsToBePlayed = songsToBePlayed;

    }

    public void modifySongs(){}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
