package smartpianoA8.business.entity;

/**
 * Entity de nota MIDI
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public class Notes {

    private int channel = 0;
    private int note = 0;
    private int velocity = 0;
    private long endTime = 0;
    private long startTime = 0;
    private String noteName;

    /**
     * Constructor amb les dades
     * @param startTime long primitiu amb els milisegons d'inici
     * @param channel int canal de la nota
     * @param velocity int tics que dura la nota
     * @param pitch int to de la nota
     * @param noteName String nom de la nota en format alfabètica (C D E do re mi)
     */
    public Notes(long startTime, int channel, int velocity, int pitch, String noteName) {
        this.startTime = startTime;
        this.channel = channel;
        this.velocity = velocity;
        this.note = pitch;
        this.noteName = noteName;
    }

    /**
     * Getter del canal
     * @return int canal
     */
    public int getChannel() {
        return channel;
    }

    /**
     * Getter del to de la nota
     * @return int to
     */
    public int getNote() {
        return note;
    }

    /**
     * Getter de la velocitat o tics
     * @return int tics//velocitat
     */
    public int getVelocity() {
        return velocity;
    }

    /**
     * getter del temps inicial
     * @return long temps
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Getter del temps final
     * @return long temps final
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * Getter de la duració
     * @return logn duració
     */
    public long getDuration() {
        return endTime-startTime;
    }

    /**
     * Setter del temps final
     * @param endTime temps final
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    /**
     * Setter del temps inical
     * @param startTime long temps d'inici
     */
    public void modifyStartTime(long startTime) {
        this.startTime = startTime;
    }
}
