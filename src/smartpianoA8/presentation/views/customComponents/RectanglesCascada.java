package smartpianoA8.presentation.views.customComponents;

import java.awt.*;

public class RectanglesCascada extends Rectangle implements Runnable{
    private int note, velocity, channel, duration, startTime;
    private long endTime;
    boolean started = false;
    private final static int margin = 4;

    public RectanglesCascada(int note, Long endTime){
        this.endTime = endTime;
        this.note = note;
    }

    public void run(){

        long inicial = System.currentTimeMillis();
        while(System.currentTimeMillis()-inicial <= endTime){
        }

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
