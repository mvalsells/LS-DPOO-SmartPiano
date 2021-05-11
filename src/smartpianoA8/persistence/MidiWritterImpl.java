package smartpianoA8.persistence;

import smartpianoA8.presentation.views.Key;

import javax.sound.midi.*;

public class MidiWritterImpl implements MidiWritter {

    Sequence sequence;
    Track pianoTrack;

    public MidiWritterImpl(int resolution) {
        try {
            sequence = new Sequence(Sequence.PPQ, resolution);

        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }



}
