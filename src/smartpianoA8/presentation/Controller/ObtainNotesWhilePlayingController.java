package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.customComponents.JPPiano;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;

public class ObtainNotesWhilePlayingController implements Receiver {

    private Receiver myReceiver;
    Sequence sequence;
    Sequencer sequencer;

    private PresentationController presentationController;
    private JPPiano jppiano;
    private int note;

    private Boolean printable ;
    private Boolean isWhite ;

    private final Integer[] negres = {2,4,7,9,11,14,16,19,21,23,26,28,31,33,35};//començant per la 1

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
        } catch (InvalidMidiDataException | IOException | MidiUnavailableException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void send(MidiMessage midiMessage, long timeStamp) {

        this.myReceiver.send(midiMessage, timeStamp);

        if (midiMessage instanceof ShortMessage) {
            ShortMessage shortMessage = (ShortMessage) midiMessage;



            if (shortMessage.getCommand() == ShortMessage.NOTE_ON) {

                note = shortMessage.getData1();
                printable = isPrintable(note);
                isWhite = isBlanca(note);


                //colorejar una tecla
                note = canviaNote(note, isWhite);
                if(isWhite && printable){
                    jppiano.pintarTeclaBlanca(note);
                }else if(!isWhite && printable){
                    jppiano.pintarTeclaNegra(note);
                }

                System.out.println("NOTE: " + shortMessage.getData1() + " ON. At time: " + System.currentTimeMillis());
                //sendOnNotes(shortMessage.getData1());
            }
            if (shortMessage.getCommand() == ShortMessage.NOTE_OFF) {
                note = shortMessage.getData1();
                printable = isPrintable(note);
                isWhite = isBlanca(note);
                note = canviaNote(note, isWhite);
                if(isWhite && printable) {

                    jppiano.despintarTeclaBlanca(note);
                }
                else if (!isWhite && printable){
                    jppiano.despintarTeclaNegra(note);
                }
                System.out.println("NOTE: " + shortMessage.getData1() + " OFF. At time: " + System.currentTimeMillis());
                //sendOffNotes(shortMessage.getData1());
            }
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
                    return 1;
                case 50:
                    return 2;
                case 52:
                    return 3;
                case 53:
                    return 4;
                case 55:
                    return 5;
                case 57:
                    return 6;
                case 59:
                    return 7;
                case 60:
                    return 8;
                case 62:
                    return 9;
                case 64:
                    return 10;
                case 65:
                    return 11;
                case 67:
                    return 12;
                case 69:
                    return 13;
                case 71:
                    return 14;
                case 72:
                    return 15;
            }
        }else{
            switch (note){
                case 49:
                    return 1;
                case 51:
                    return 2;
                case 53:
                    return 3;
                case 56:
                    return 4;
                case 58:
                    return 5;
                case 61:
                    return 6;
                case 63:
                    return 7;
                case 66:
                    return 8;
                case 68:
                    return 9;
                case 70:
                    return 10;
            }
        }
        return newNote;
    }

    private Boolean isBlanca(int note){
        for (Integer negre : negres) {
            if (note == negre) return true;
        }
        return false;
    }

    public int sendOnNotes(int note) {
        return note;
    }

    public int sendOffNotes(int note) {
        return note;
    }

    @Override
    public void close() {
        sequencer.close();
    }

}
