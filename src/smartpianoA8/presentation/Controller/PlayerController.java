package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerController implements Runnable, ActionListener {

    private ArrayList<Song> songsToBePlayed;
    private File songDirectory;
    private Sequence currentSequence;
    private Sequencer currentSequencer;
    Runnable runnable;

    public PlayerController(ArrayList<Song> songsToBePlayed) {

        this.songsToBePlayed = songsToBePlayed;

    }

    public void modifySongs(){}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

        for (int i = 0; i < songsToBePlayed.size(); i++) {

            songDirectory = new File(songsToBePlayed.get(i).getDirectori());

            try {

                currentSequence = MidiSystem.getSequence(songDirectory);
                currentSequencer = MidiSystem.getSequencer();
                currentSequencer.open();
                currentSequencer.setSequence(currentSequence);

                runnable = () -> {

                    final JProgressBar progress = new JProgressBar(0,(int)currentSequencer.getMicrosecondLength());
                    ActionListener updateListener = new ActionListener(){
                        public void actionPerformed(ActionEvent arg0) {
                            progress.setValue((int)currentSequencer.getMicrosecondPosition());
                        }
                    };
                    Timer timer = new Timer(40,updateListener);
                    currentSequencer.start();
                    timer.start();
                    JOptionPane.showMessageDialog(null, progress);
                    currentSequencer.close();
                    timer.stop();

                };
                runnable.run();
                //SwingUtilities.invokeLater(runnable);

                /*currentSequencer.start();

                while(currentSequencer.isRunning()) {



                }*/

            } catch (InvalidMidiDataException | IOException | MidiUnavailableException e) {
                e.printStackTrace();
            }
        }

    }
}
