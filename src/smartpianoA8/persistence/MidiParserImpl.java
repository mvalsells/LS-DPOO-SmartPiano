package smartpianoA8.persistence;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.entity.Notes;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class MidiParserImpl implements MidiParser {

    private BusinessFacade businessFacade;
    private ArrayList<ArrayList<Notes>> tracks;
    private long maxTick = 0;
    private HashMap<Long,ArrayList<Notes>> notesBySt = new HashMap<Long,ArrayList<Notes>>();
    private static final int NOTE_ON = 0x90;
    private static final int NOTE_OFF = 0x80;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    public MidiParserImpl(BusinessFacade businessFacade) {
        this.businessFacade = businessFacade;
        tracks = new ArrayList<ArrayList<Notes>>();
    }

    public void ParseMidi(String dir) {
        //tracks = new ArrayList<ArrayList<Notes>>();
        Track[] trx;
        File midiFile = new File(dir);
        Sequence sequence;

        try {
            sequence = MidiSystem.getSequence(midiFile);
            int trackNumber = 0;
            for (Track track : sequence.getTracks()) {

                int pitch = 0;
                int channel = 0;
                int velocity = 0;
                long time = 0;
                int note = 0;
                int octave = 0;
                trackNumber++;
                channel = trackNumber;
                ArrayList<Notes> notes = new ArrayList<Notes>();

                for (int i = 0; i < track.size(); i++) {
                    MidiEvent midiEvent = track.get(i);
                    time = midiEvent.getTick()/3;
                    MidiMessage midiMessage = midiEvent.getMessage();

                    if(midiMessage instanceof ShortMessage) {
                        ShortMessage shortMessage = (ShortMessage) midiMessage;

                        velocity = shortMessage.getData2();

                        if(shortMessage.getCommand() == NOTE_ON && velocity != 0) {
                            pitch = shortMessage.getData1();
                            velocity = shortMessage.getData2();
                            note = pitch % 12;
                            octave = (pitch / 12) - 1;
                            String noteName = NOTE_NAMES[note];
                            //if(pitch < 21 || pitch > 109)
                            if(velocity > 0) {
                                System.out.println("Note ON, key: " + pitch + ", noteName: " + noteName + octave + ", velocity: " + velocity);

                                Notes n = new Notes(time, channel, velocity, pitch, noteName + octave);
                                notes.add(n);
                                if (time > maxTick) {
                                    maxTick = time;
                                }

                            }
                            //MidiSystem.getSynthesizer();

                        } else if(shortMessage.getCommand() == NOTE_OFF) {
                            pitch = shortMessage.getData1();
                            velocity = shortMessage.getData2();
                            note = pitch % 12;
                            octave = (pitch / 12) - 1;
                            String noteName = NOTE_NAMES[note];
                            //if(pitch < 21 || pitch > 109)
                            System.out.println("Note OFF, key: " + pitch + ", noteName: " + noteName + octave + ", velocity: " + velocity);
                            for(Notes n : notes) {
                                if(n.getNote() == pitch & n.getEndTime() == 0) {
                                    n.setEndTime(time);
                                    if(time > maxTick) {
                                        maxTick = time;
                                    }
                                }
                            }


                        }else if(shortMessage.getCommand() == NOTE_ON && velocity == 0) {
                            pitch = shortMessage.getData1();
                            velocity = shortMessage.getData2();
                            note = pitch % 12;
                            octave = (pitch / 12) - 1;
                            String noteName = NOTE_NAMES[note];
                            //if(pitch < 21 || pitch > 109)
                            System.out.println("Note OFF, key: " + pitch + ", noteName: " + noteName + octave + ", velocity: " + velocity);
                            for(Notes n : notes) {
                                if(n.getNote() == pitch & n.getEndTime() == 0) {
                                    n.setEndTime(time);
                                    if(time > maxTick) {
                                        maxTick = time;
                                    }
                                }
                            }

                        } else {

                        }
                    } else {

                    }
                }
                tracks.add(notes);

            }
            sortNotes();


        } catch (InvalidMidiDataException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sortNotes() {
        for (ArrayList<Notes> a : tracks) {
            for (Notes n : a) {
                if(notesBySt.containsKey(n.getStartTime()))
                    notesBySt.get(n.getStartTime()).add(n);
                else {
                    ArrayList<Notes> an = new ArrayList<Notes>();
                    an.add(n);
                    notesBySt.put(n.getStartTime(), an);

                }
            }
        }
    }

    public int numTracks() {
        return tracks.size();
    }

    public ArrayList<ArrayList<Notes>> getTracks() {
        return tracks;
    }

    //public HashMap<Long,ArrayList<Notes>> getnotesBySt() {
    //    return notesBySt;
    //}

}
