package smartpianoA8.persistence;

import smartpianoA8.business.entity.Notes;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe la creació i lectura de cançons MIDI
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see MidiParser
 */
public class MidiParserImpl implements MidiParser {

    private ArrayList<ArrayList<Notes>> tracks;
    private long maxTick = 0;
    private HashMap<Long,ArrayList<Notes>> notesBySt = new HashMap<Long,ArrayList<Notes>>();
    private static final int NOTE_ON = 0x90;
    private static final int NOTE_OFF = 0x80;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    private float MPQ = 0;
    private float BPM = 0;
    private float totalSongSeconds = 0;
    private float secondsPerTick = 0;
    private long totalTicks = 0;
    private int trackResolution = 0;
    private int ticks_per_quarter;
    private float us_per_quarter;
    private float us_per_tick;

    /**
     * Constructor
     */
    public MidiParserImpl() {
        tracks = new ArrayList<ArrayList<Notes>>();
    }


    /**
     * Mètode per la creació d'una cançó MIDI
     * @param dir ruta de la cançó
     * @return ArrayList d'ArrayList de notes, notes per cada track
     */
    public ArrayList<ArrayList<Notes>> parseMidi(String dir) {
        //tracks = new ArrayList<ArrayList<Notes>>();
        Track[] trx;
        File midiFile = new File(dir);
        Sequence sequence;

        try {
            sequence = MidiSystem.getSequence(midiFile);

            try {
                Sequencer sequencer = MidiSystem.getSequencer();
                sequencer.open();
                sequencer.setSequence(sequence);
                MPQ = sequencer.getTempoInMPQ();
                BPM = sequencer.getTempoInBPM();
                System.out.println("\nSong Tempo (MicroSeconds Per Quarter Note): " + MPQ);
                System.out.println("Song Tempo In BPM (Not Needed) " + sequencer.getTempoInBPM());
                //sequencer.start();
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }

            trackResolution = sequence.getResolution();

            ticks_per_quarter = sequence.getResolution();
            us_per_quarter = MPQ;
            us_per_tick = us_per_quarter / ticks_per_quarter;
            //Microsegundos que tiene un tick = us_per_tick
            System.out.println("Total µs_per_tick: " + us_per_tick);
            secondsPerTick = us_per_tick / 1000000;
            totalSongSeconds = sequence.getTickLength() * secondsPerTick;
            totalTicks = sequence.getTickLength();

            System.out.println("Total song seconds: " + totalSongSeconds);
            System.out.println("Seconds per tick: " + secondsPerTick);
            System.out.println("Total ticks in Midi File: " + sequence.getTickLength());
            System.out.println("ATTENTION, To get the time every tick takes in the song multiply the endTime-startTime * seconds_per_tick (getSecondsPerTick) (IN TICKS)\n");

            //System.out.println("Longitud de Canción: " + sequence.getTickLength() + " ticks. Resolución de: " + sequence.getResolution() + " PPQ - Pulses per quarter note");
            //System.out.println("Attention: Time in notes are saved as Ticks. startTime = 0 (starts at tick 0) endTime = 128 (end at tick 128). EVERY TICK HAVE A DURATION OF: PLAYBACK SECONDS ABOVE.");
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

                System.out.println("The Channels are the different instruments playing at same time in one song. Also, command channels. Max channels per MIDI: 16.");

                for (int i = 0; i < track.size(); i++) {
                    MidiEvent midiEvent = track.get(i);
                    time = midiEvent.getTick();
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
                                System.out.println("Channel: " + shortMessage.getChannel() + ", Note ON, key: " + pitch + ", noteName: " + noteName + octave + ", velocity: " + velocity + ", startTime: " + time);

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
                            System.out.println("Channel: " + shortMessage.getChannel() + ", Note OFF, key: " + pitch + ", noteName: " + noteName + octave + ", velocity: " + velocity + ", endTime: " + time);
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
                            System.out.println("Channel: " + shortMessage.getChannel() + ", Note OFF, key: " + pitch + ", noteName: " + noteName + octave + ", velocity: " + velocity + ", endTime: " + time);
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
        return tracks;
    }

    /**
     * Mètode que ordena les notes
     */
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

    /**
     * Getter del nombre de canals
     * @return nombre de canals
     */
    @Override
    public int numTracks() {
        return tracks.size();
    }

    /**
     * Getter dels BPM
     * @return BPM
     */
    @Override
    public float getBPM() {
        return BPM;
    }

    /**
     * Getter dels segons per tic
     * @return SpT
     */
    @Override
    public float getSecondsPerTick() {
        return secondsPerTick;
    }

    /**
     * Getter del temps total en segons de la cançó
     * @return temps total en segons
     */
    @Override
    public float getTotalSongSeconds() {
        return totalSongSeconds;
    }

    //@Override
    //public ArrayList<ArrayList<Notes>> getTracks() {
    //    return tracks;
    //}

    /**
     * Getter de la ressolució del canal
     * @return resolució del canal
     */
    @Override
    public int getTrackResolution() {
        return trackResolution;
    }

    /**
     * Getter dels tics totals de la cançó
     * @return tics totals
     */
    @Override
    public long getTotalTicks() {
        return totalTicks;
    }

    /**
     * Getter dels MPQ
     * @return MPQ
     */
    @Override
    public float getMPQ() {
        return MPQ;
    }

    /**
     * Getter dels microsegons per tic
     * @return uS per tic
     */
    public float getusPerTick() {
        return us_per_tick;
    }


    //public HashMap<Long,ArrayList<Notes>> getnotesBySt() {
    //    return notesBySt;
    //}

}
