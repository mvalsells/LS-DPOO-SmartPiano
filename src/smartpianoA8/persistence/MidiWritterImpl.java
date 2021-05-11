package smartpianoA8.persistence;

import smartpianoA8.business.entity.Song;
import smartpianoA8.presentation.views.Key;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;

public class MidiWritterImpl implements MidiWritter {

    Sequence sequence = null;
    Track pianoTrack;
    Sequencer sequencer;
    private boolean recording = false;
    private long startTime = 0;


    public MidiWritterImpl() {
    }

    public void startRecording() {
        try {

            sequence = new Sequence(Sequence.PPQ, 500);



            //sequencer = MidiSystem.getSequencer();
            pianoTrack = sequence.createTrack();
            //pianoTrack.add(createMidiEvent(ShortMessage.PROGRAM_CHANGE, 0,0,0,0));
            //sequencer.open();
            //sequencer.setSequence(sequence);
            sequencer = MidiSystem.getSequencer();
            sequencer.setSequence(sequence);
            sequencer.open();
            sequencer.recordEnable(pianoTrack, 0);
            sequencer.startRecording();
            System.out.println("Started recording...");
            recording = true;
            startTime = System.currentTimeMillis();
        } catch (InvalidMidiDataException | MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void endRecording() {
        recording = false;
        sequencer.stopRecording();
        try {
            Sequencer sequencerAux = MidiSystem.getSequencer();
            sequencerAux.open();
            sequencerAux.setSequence(sequence);
            sequencerAux.start();
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    public boolean getIsRecording() {
        return recording;
    }

    public void setOnMessage(int key, long startedNote) {
        pianoTrack.add(createMidiEvent(ShortMessage.NOTE_ON, 0, key, 127,/*System.currentTimeMillis()-startTime*/startedNote-startTime));
        System.out.println("Key: " + key + " ONNN");
    }

    public void setOffMessage(int key, long endedNote) {
        pianoTrack.add(createMidiEvent(ShortMessage.NOTE_OFF, 0, key, 127, endedNote-startTime));
        System.out.println("Key: " + key + " OFFF");
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
