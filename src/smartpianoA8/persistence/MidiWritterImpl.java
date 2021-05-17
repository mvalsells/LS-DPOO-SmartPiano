package smartpianoA8.persistence;

import smartpianoA8.business.entity.Song;
import smartpianoA8.persistence.dao.SongDAO;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Calsse per la creació de cançons MIDI
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see MidiWritter
 */
public class MidiWritterImpl implements MidiWritter {

    Sequence sequence = null;
    Track pianoTrack;
    Sequencer sequencer;
    private boolean recording = false;
    private long startTime = 0;
    Sequencer finalSequencer;
    SongDAO songDAO;

    private static final int TYPE_SINGLE_TRACK = 0;
    private static final int TYPE_PARALLEL_TRACKS = 1;
    private static final int TYPE_SERIAL_TRACKS = 2;
    private File midiOutputFile;

    /**
     * Constructor amb la DAO de cançons de la BBDD
     * @param songDAO
     */
    public MidiWritterImpl(SongDAO songDAO) {
        this.songDAO = songDAO;
    }

    /**
     * Mètode per començar a enregistrar una cançó des del teclat
     */
    @Override
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

    /**
     * Mètode per finalitzar una gravació
     */
    @Override
    public void endRecording() {
        recording = false;
        sequencer.stopRecording();

        try {
            finalSequencer = MidiSystem.getSequencer();
            finalSequencer.open();
            finalSequencer.setSequence(sequence);
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mètode per establir el path d'un usuari
     * @param userName nom d'usuari
     */
    private void makeUserDirectory(String userName) {
        File directory = new File("resources/midiFiles/"+userName);
        if(!directory.exists()) {
            directory.mkdir();
        }
    }

    /**
     * Mètode per reproduir una cançó
     */
    @Override
    public void playRecording() {
        finalSequencer.start();
    }

    /**
     * Mètode per parar de reproduir una cançó
     */
    @Override
    public void stopPlayingRecording() {
        finalSequencer.stop();
    }

    /**
     * Mètode per guardar un enregistrament
     * @param userName nom d'usuari
     * @param songName nom de la cançó
     * @param isPublic identificador de si la cançó és pública 1 o no 0
     * @param totalTimeInMilis duració total en milisegons
     */
    @Override
    public void saveRecording(String userName, String songName, boolean isPublic, long totalTimeInMilis) {
        makeUserDirectory(userName);
        saveToFile(userName, songName);
        addSongToDatabase(userName, songName, isPublic, totalTimeInMilis-startTime);
    }

    /**
     * Mètode per afegir una cançó a la BBDD
     * @param userName nom de l'usuari
     * @param songName nom de la cançó
     * @param isPublic identificador de si la cançó és pública 1 o no 0
     * @param totalTimeInMinis duració en milisegons
     */
    private void addSongToDatabase(String userName, String songName, boolean isPublic, long totalTimeInMinis) {

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedString = localDate.format(formatter);

        int isPublic2 = 0;
        if(isPublic) {
            isPublic2 = 1;
        }

        Song newSong = new Song(0,totalTimeInMinis,songName,userName, formattedString, "resources/midiFiles/"+userName+"/"+songName+".mid", isPublic2, userName, null);

        songDAO.addSong(newSong, userName);

    }

    /**
     * Mètode per guardar una cançó en un fitxer
     * @param userName nom de l'usuari
     * @param songName nom de la cançó
     */
    private void saveToFile(String userName, String songName) {
        int midiFileType = 0;
        if(sequence.getTracks().length == 1) {
            midiFileType = TYPE_SINGLE_TRACK;
        }else {
            midiFileType = TYPE_PARALLEL_TRACKS;
        }

        int[] arrayMidiFiles = MidiSystem.getMidiFileTypes(sequence);
        try {
            if (arrayMidiFiles.length > 0) {
                midiOutputFile = new File("resources/midiFiles/"+userName+"/"+songName+".mid");
                MidiSystem.write(sequence, arrayMidiFiles[0], midiOutputFile);

                sequencer.addMetaEventListener(metaMsg -> {
                    if (metaMsg.getType() == 0x2F) {
                        sequencer.close();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mètode per saber si s'està enregistrant en un instant
     * @return true: sí false: no
     */
    @Override
    public boolean getIsRecording() {
        return recording;
    }

    /**
     * Mètode per avisar de quina nota s'ha pres
     * @param key nota
     * @param startedNote temps inicial
     */
    @Override
    public void setOnMessage(int key, long startedNote) {
        pianoTrack.add(createMidiEvent(ShortMessage.NOTE_ON, 0, key, 127,/*System.currentTimeMillis()-startTime*/startedNote-startTime));
        System.out.println("Key: " + key + " ONNN");
    }

    /**
     * Mètode per avisar de quina nota s'ha desactivat
     * @param key nota
     * @param endedNote temps final
     */
    @Override
    public void setOffMessage(int key, long endedNote) {
        pianoTrack.add(createMidiEvent(ShortMessage.NOTE_OFF, 0, key, 127, endedNote-startTime));
        System.out.println("Key: " + key + " OFFF");
    }

    /**
     * Mètode per crear un event de MIDI
     * @param command commanda
     * @param channel canal
     * @param data1 primera dada
     * @param data2 segona dada
     * @param instant instant
     * @return un Event Midi
     * @throws InvalidMidiDataException control pròpi per errors
     */
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
