package smartpianoA8.presentation.views.customComponents;

import java.awt.*;

public class RectanglesCascada extends Rectangle {
    private int note, velocity, channel, duration, startTime, endTime;
    boolean started = false;
    private final static int margin = 4;

    public RectanglesCascada(int channel, int note, int velocity, int x, int duration, int startTime){
        this.channel=channel;
        this.note=note;
        this.velocity=velocity;
        this.x = x;
        this.duration = duration;
        this.endTime = endTime;
        this.startTime = startTime;
        duration = endTime-startTime;
        this.y= (-duration);

        setBounds(x+margin, y,2*margin, duration);

    }

    public void move(){
        y++;
        this.setLocation(x,y);
    }


    public int getVelocity() {
        return velocity;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getChannel() {
        return channel;
    }

    public int getDuration() {
        return duration;
    }

    public int getNote() {
        return note;
    }
}
