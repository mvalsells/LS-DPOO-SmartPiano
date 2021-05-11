package smartpianoA8.persistence;

import smartpianoA8.presentation.views.Key;

import javax.sound.midi.*;

public class MidiWritterImpl implements MidiWritter {

    Sequence sequence;
    Track pianoTrack;
    Sequencer sequencer;

    public MidiWritterImpl() {
        try {
            sequence = new Sequence(Sequence.PPQ, 24);
            sequencer = MidiSystem.getSequencer();
            pianoTrack = sequence.createTrack();
            sequencer.startRecording();
        } catch (InvalidMidiDataException | MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void setOnMessage(Key key) {
        pianoTrack.add(createMidiEvent(ShortMessage.NOTE_ON, 0, key.getNote(), 127,sequencer.getTickPosition() * (sequence.getResolution() / 500)));
    }

    public void setOffMessage(Key key) {
        pianoTrack.add(createMidiEvent(ShortMessage.NOTE_OFF, 0, key.getNote(), 0, sequencer.getTickPosition() * (sequence.getResolution() / 500)));
    }

    private static MidiEvent createMidiEvent(int command, int channel, int data1, int data2, long instant) {
        ShortMessage shortMessage = new ShortMessage();
        try {
            shortMessage.setMessage(
                    command,
                    channel,
                    data1,
                    data2);
        } catch (InvalidMidiDataException e) {
        }
        return new MidiEvent(shortMessage, instant);
    }



}
