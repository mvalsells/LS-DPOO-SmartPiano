package smartpianoA8.persistence;

import smartpianoA8.presentation.views.Key;

import javax.sound.midi.*;

public class MidiWritterImpl implements MidiWritter {

    Sequence sequence;
    Sequencer sequencer;
    Track track;
    ShortMessage message;

    public MidiWritterImpl() throws InvalidMidiDataException {
        sequence = new Sequence(Sequence.PPQ, 24);
        message = new ShortMessage();
        track = sequence.createTrack();
        sequencer.setSequence(sequence);
        sequencer.setTickPosition(0);
        sequencer.recordEnable(track,-1);
        sequencer.startRecording();

    }

    public void createOnEvent(Key key) {

        try {
            message.setMessage(ShortMessage.NOTE_ON, message.getChannel(), key.getNote(), 127);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }




}
