package smartpianoA8.presentation.Controller;

import smartpianoA8.business.entity.Song;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;

public class ObtainNotesWhilePlayingController implements Receiver {

    private Receiver myReceiver;
    Sequence sequence;
    Sequencer sequencer;

    public ObtainNotesWhilePlayingController() {}

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
                System.out.println("NOTE: " + shortMessage.getData1() + " ON. At time: " + System.currentTimeMillis());
                sendOnNotes(shortMessage.getData1());
            }
            if (shortMessage.getCommand() == ShortMessage.NOTE_OFF) {
                System.out.println("NOTE: " + shortMessage.getData1() + " OFF. At time: " + System.currentTimeMillis());
                sendOffNotes(shortMessage.getData1());
            }
        }

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
