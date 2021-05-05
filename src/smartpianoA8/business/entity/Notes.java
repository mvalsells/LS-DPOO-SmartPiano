package smartpianoA8.business.entity;

public class Notes {

    private int channel = 0;
    private int note = 0;
    private int velocity = 0;
    private long endTime = 0;
    private long startTime = 0;

    public Notes(long startTime, int channel, int velocity, int pitch) {
        this.startTime = startTime;
        this.channel = channel;
        this.velocity = velocity;
        this.note = pitch;
    }

    public int getChannel() {
        return channel;
    }

    public int getNote() {
        return note;
    }

    public int getVelocity() {
        return velocity;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public long getDuration() {
        return endTime-startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
