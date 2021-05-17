package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.presentation.views.JPPianoView;

import java.awt.*;

public class RectanglesCascada extends Rectangle implements Runnable{
    private int note, velocity, channel, duration, startTime;
    private long endTime;
    boolean started = false;
    private final static int margin = 4;
    private JPPiano pianoView;
    private final Integer[] negres = {2,4,7,9,11,14,16,19,21,23,26,28,31,33,35};//començant per la 1


    public RectanglesCascada(int note, Long endTime, JPPiano pianoView){
        this.endTime = endTime;
        this.note = note;
        this.pianoView = pianoView;
    }

    @Override
    public void run(){

        /******************************pintar tecla*******************/

        //colorejar una tecla
        /*if(isBlanca(note)) {
            note = canviaNote(note, isBlanca(note));
            pianoView.pintarTeclaBlanca(note);
        }
        else{
            pianoView.pintarTeclaNegra(note);
        }*/


        long inicial = System.currentTimeMillis();
        while(System.currentTimeMillis()-inicial <= endTime){
        }

        /***************************despintar tecla********************/

        //tecla color inicial
        /*if(isBlanca(note)) {

            pianoView.despintarTeclaBlanca(note);
        }
        else{
            pianoView.despintarTeclaNegra(note);
        }*/



    }

    /*private int canviaNote(int note, Boolean isBlanca){
        if(isBlanca){
            if(note)
        }else{

        }

        return ;
    }*/

    /*public void move(){
        y++;
        this.setLocation(x,y);
    }*/

    private Boolean isBlanca(int note){
        for (Integer negre : negres) {
            if (note == negre) return true;
        }
        return false;
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
