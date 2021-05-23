package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.JPPiano;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe per obtenir notes de cançons, processar-les i enviar ordres de pintar el piano
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see Receiver
 */
public class ObtainNotesWhilePlayingController implements Receiver {

    private Receiver myReceiver;
    private Sequence sequence;
    private Sequencer sequencer;

    private PresentationController presentationController;
    private JPPiano jppiano;
    private int note;

    private Boolean printable ;
    private Boolean isWhite ;

    private final Integer[] negres = {49,51,54,56,58,61,63,66,68,70,73,75,78,80,82};

    public ObtainNotesWhilePlayingController(JPPiano jpPiano) {
        this.jppiano = jpPiano;
    }

    public void playAndGet(Song songToPlay) {
        File file = new File(songToPlay.getDirectori());

        try {

            sequence = MidiSystem.getSequence(file);

            sequencer = MidiSystem.getSequencer();
            sequencer.setSequence(sequence);
            sequencer.open();
            this.myReceiver = sequencer.getReceiver();
            sequencer.getTransmitter().setReceiver(this);
            sequencer.start();
            jppiano.setPlayButtonPressedIcon();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(new Frame(), "You don't have downloaded the song you're trying to play.\nDirectory: " + file + "\nYour program have to download it first with the HTMLScrapping feature if it's a program song.\nPlease, to solve this stay more time playing in the app. The song will be downloaded according to the time stablished in your config file.\nIf it's a user song and you don't have the midi file you can't play it.", "FILE NOT FOUND", JOptionPane.ERROR_MESSAGE);
        } catch (InvalidMidiDataException | MidiUnavailableException | IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void send(MidiMessage midiMessage, long timeStamp) {

        this.myReceiver.send(midiMessage, timeStamp);

        if (midiMessage instanceof ShortMessage) {
            ShortMessage shortMessage = (ShortMessage) midiMessage;

            // Notas en ON
            if (shortMessage.getCommand() == ShortMessage.NOTE_ON && shortMessage.getData2() != 0) {

                note = shortMessage.getData1();
                printable = isPrintable(note);
                isWhite = isBlanca(note);


                //colorejar una tecla
                note = canviaNote(note, isWhite);
                if(isWhite && printable){
                    jppiano.pintarTeclaBlanca(note);
                    jppiano.repainAllBlacks(note);
                }else if(!isWhite && printable){
                    jppiano.pintarTeclaNegra(note);
                }

                System.out.println("NOTE: (" + isWhite + ") " + note +" ON. At time: " + System.currentTimeMillis());
                //sendOnNotes(shortMessage.getData1());

            // Notas en OFF pero con señal de ON
            }else if (shortMessage.getCommand() == ShortMessage.NOTE_ON && shortMessage.getData2() == 0) {
                note = shortMessage.getData1();
                printable = isPrintable(note);
                isWhite = isBlanca(note);
                note = canviaNote(note, isWhite);
                if(isWhite && printable) {
                    jppiano.despintarTeclaBlanca(note);
                    jppiano.repainAllBlacks(note);
                }
                else if (!isWhite && printable){
                    jppiano.despintarTeclaNegra(note);
                }
                System.out.println("NOTE: (" + isWhite + ") " + note + " OFF. At time: " + System.currentTimeMillis());
                //sendOffNotes(shortMessage.getData1());
            // Notas en OFF normales
            }else if (shortMessage.getCommand() == ShortMessage.NOTE_OFF) {
                note = shortMessage.getData1();
                printable = isPrintable(note);
                isWhite = isBlanca(note);
                note = canviaNote(note, isWhite);
                if(isWhite && printable) {
                    jppiano.despintarTeclaBlanca(note);
                    jppiano.repainAllBlacks(note);
                }
                else if (!isWhite && printable){
                    jppiano.despintarTeclaNegra(note);
                }
                System.out.println("NOTE: (" + isWhite + ") " + note + " OFF. At time: " + System.currentTimeMillis());
                //sendOffNotes(shortMessage.getData1());
            }

        }

        if(sequencer.isRunning()){

        }else {
            close();
        }

    }

    public void registerPresentationController(PresentationController presentationController) {
        this.presentationController = presentationController;
    }

    private Boolean isPrintable(int note){
        if(note <= 72 && note >= 48) return true;
        return false;
    }

    private int canviaNote(int note, Boolean isBlanca){
        int newNote = 0;

        //la nota ja està entre 48 i 72, es pot printar directamet
        if(isBlanca) {
            switch (note){
                case 48:
                    return 0;
                case 50:
                    return 1;
                case 52:
                    return 2;
                case 53:
                    return 3;
                case 55:
                    return 4;
                case 57:
                    return 5;
                case 59:
                    return 6;
                case 60:
                    return 7;
                case 62:
                    return 8;
                case 64:
                    return 9;
                case 65:
                    return 10;
                case 67:
                    return 11;
                case 69:
                    return 12;
                case 71:
                    return 13;
                case 72:
                    return 14;
            }
        }else{
            switch (note){
                case 49:
                    return 0;
                case 51:
                    return 1;
                case 53:
                    return 2;
                case 56:
                    return 3;
                case 58:
                    return 4;
                case 61:
                    return 5;
                case 63:
                    return 6;
                case 66:
                    return 7;
                case 68:
                    return 8;
                case 70:
                    return 9;
            }
        }
        return newNote;
    }

    private Boolean isBlanca(int note){

        for(int i=0;i<negres.length-1;i++){

            if(note==negres[i]){return false;}

        }
        return true;
    }

    public int sendOnNotes(int note) {
        return note;
    }

    public int sendOffNotes(int note) {
        return note;
    }

    @Override
    public void close() {
        if(sequencer!=null) {
            jppiano.setPlayButtonUnpressedIcon();
            //sequencer.close();
            jppiano.repaintAllTeclas();
        }
    }

}
