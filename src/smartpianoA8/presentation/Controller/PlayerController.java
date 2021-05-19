package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.JPPlayer;

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
    //Runnable runnable;
    private int actionToDo = 5;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private int currentSong = 0;

    public PlayerController() {}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

        while (true) {

            // thread para no colapsar jeje
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (actionToDo) {
                case 0:
                    //Case 0 is being played
                    playThePlayer();
                    isPlaying = true;
                    break;
                case 1:
                    //Case 1 is pause playing
                    pauseThePlayer();
                    isPlaying = false;
                    break;
                case 2:
                    //Case 2 is go to next song
                    nextTheSong();
                    break;
                case 3:
                    //Case 3 is previous song
                    previousTheSong();
                    break;
                case 4:
                    //Case 4 is end the entire playlist
                    endThePlayer();
                    isPlaying = false;
                    break;
                default:
                    break;
            }

        }

        /*for (int i = 0; i < songsToBePlayed.size(); i++) {

            songDirectory = new File(songsToBePlayed.get(i).getDirectori());

            try {

                currentSequence = MidiSystem.getSequence(songDirectory);
                currentSequencer = MidiSystem.getSequencer();
                currentSequencer.open();
                currentSequencer.setSequence(currentSequence);

                //no hace falta modificar
                //runnable = () -> {

                    currentSequencer.start();



                    //---------------------

                    currentSequencer.start();

                    ActionListener updateListener = new ActionListener(){
                        public void actionPerformed(ActionEvent arg0) {
                            position = (int)currentSequencer.getMicrosecondPosition();
                            //jpPlayer.updateProgressBar((int)currentSequencer.getMicrosecondPosition());
                            //progress.setValue((int)currentSequencer.getMicrosecondPosition());
                        }
                    };

                    Timer timer = new Timer(40,updateListener);
                    timer.start();

                    while (currentSequencer.isRunning()) {}

                    timer.stop();
                    currentSequencer.stop();


                    //----------------



                    //final JProgressBar progress = new JProgressBar(0,(int)currentSequencer.getMicrosecondLength());
                    //ActionListener updateListener = new ActionListener(){
                    //    public void actionPerformed(ActionEvent arg0) {
                    //        progress.setValue((int)currentSequencer.getMicrosecondPosition());
                    //    }
                    //};
                    //Timer timer = new Timer(40,updateListener);
                    currentSequencer.start();
                    //timer.start();
                    while(currentSequencer.isRunning()){}
                    //JOptionPane.showMessageDialog(null, progress);
                    currentSequencer.close();
                    //timer.stop();

                //};
                //runnable.run();


                //SwingUtilities.invokeLater(runnable);

                /*currentSequencer.start();

                while(currentSequencer.isRunning()) {



                }

            } catch (InvalidMidiDataException | IOException | MidiUnavailableException e) {
                e.printStackTrace();
            }
        }*/

    }

    public void setSongsToBePlayed(ArrayList<Song> songsToBePlayed) {
        this.songsToBePlayed = songsToBePlayed;
    }

    public void setActionToDo(int actionToDo) {
        this.actionToDo = actionToDo;
    }

    private void playThePlayer() {

        while (isPlaying) {

            for(currentSong = 0; currentSong < songsToBePlayed.size(); currentSong++) {

                songDirectory = new File(songsToBePlayed.get(currentSong).getDirectori());

                //TODO SEND MILISECONDS TO DAO presentationcontroller.settaltaltal -> businessfacade.settaltaltal ..... actualitzarBBDDEstadistiques(LocalTime duradaSong, String username);

                try {
                    currentSequence = MidiSystem.getSequence(songDirectory);
                    currentSequencer = MidiSystem.getSequencer();
                    currentSequencer.open();
                    currentSequencer.setSequence(currentSequence);
                } catch (InvalidMidiDataException e) {
                    e.printStackTrace();
                } catch (MidiUnavailableException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                currentSequencer.start();

                while (currentSequencer.isRunning()) {
                    if(actionToDo == 2) {
                        //currentSong++;
                        currentSequencer.close();
                        actionToDo = 0;
                        break;
                    } else if (actionToDo == 3) {
                        //currentSong--;
                        currentSong = currentSong - 2;
                        currentSequencer.close();
                        actionToDo = 0;
                        break;
                    } else if (actionToDo == 1) {
                        currentSequencer.stop();
                        currentSong = currentSong - 1;
                        isPaused = true;
                        break;
                    } else if (actionToDo == 4) {
                        currentSequencer.close();
                        break;
                    }
                }

                currentSequencer.close();

            }

        }

    }

    private void pauseThePlayer() {

        currentSequencer.stop();

    }

    private void nextTheSong() {

        currentSong++;
        currentSequencer.close();

    }

    private void previousTheSong() {

        currentSong--;
        currentSequencer.close();

    }

    private void endThePlayer() {

        currentSequencer.close();

    }

}
