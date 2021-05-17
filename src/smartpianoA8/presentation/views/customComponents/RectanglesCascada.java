package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.presentation.views.JPPianoView;

import java.awt.*;

public class RectanglesCascada extends Rectangle implements Runnable{
    private int note, velocity, channel, duration, startTime;
    private long endTime;
    boolean started = false;
    private final static int margin = 4;
    private JPPiano pianoView;



    public RectanglesCascada(int note, Long endTime, JPPiano pianoView){
        this.endTime = endTime;
        this.note = note;
        this.pianoView = pianoView;
    }

    @Override
    public void run(){
        //colorejar una tecla
        pianoView.pintarTecla(note);
        long inicial = System.currentTimeMillis();
        while(System.currentTimeMillis()-inicial <= endTime){
        }
        //tecla color inicial
        pianoView.despintarTecla(note);
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
