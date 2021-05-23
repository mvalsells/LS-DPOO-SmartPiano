package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.customComponents.piano.JPPiano;

import java.awt.*;

public class RectanglesCascada extends Rectangle implements Runnable{
    private int note, velocity, channel, duration, startTime;
    private long endTime;
    boolean started = false;
    private final static int margin = 4;
    private JPPiano jppiano;
    private final Integer[] negres = {2,4,7,9,11,14,16,19,21,23,26,28,31,33,35};//començant per la 1
    private final Integer[] convertirBlanques = {};


    public RectanglesCascada(int note, Long endTime, JPPiano jppiano){
        this.endTime = endTime;
        this.note = note;
        this.jppiano = jppiano;

    }

    @Override
    public void run(){
        Boolean printable = isPrintable(note);
        Boolean isWhite = isBlanca(note);


        //colorejar una tecla
        note = canviaNote(note, isWhite);
        if(isWhite && printable){
            jppiano.pintarTeclaBlanca(note);
        }else if(!isWhite && printable){
            jppiano.pintarTeclaNegra(note);
        }

        //esperar el que dura la nota
        long inicial = System.currentTimeMillis();
        System.out.println("patata que anem");
        while(System.currentTimeMillis()-inicial <= endTime){

        }
        System.out.println("patata que cremem");
        //tecla color inicial
        if(isWhite && printable) {

            jppiano.despintarTeclaBlanca(note);
        }
        else if (!isWhite && printable){
            jppiano.despintarTeclaNegra(note);
        }
        return;
    }

    private Boolean isPrintable(int note){
        if(note <= 72 && note >= 48) return true;
        return false;
    }

    private int canviaNote(int note, Boolean isBlanca){
        int newNote = 0;

        //la nota ja està entre 48 i 72, es pot printar directamet
        if(isBlanca) {
            switch (note){
                case 48:
                    return 1;
                case 50:
                    return 2;
                case 52:
                    return 3;
                case 53:
                    return 4;
                case 55:
                    return 5;
                case 57:
                    return 6;
                case 59:
                    return 7;
                case 60:
                    return 8;
                case 62:
                    return 9;
                case 64:
                    return 10;
                case 65:
                    return 11;
                case 67:
                    return 12;
                case 69:
                    return 13;
                case 71:
                    return 14;
                case 72:
                    return 15;
            }
        }else{
            switch (note){
                case 49:
                    return 1;
                case 51:
                    return 2;
                case 53:
                    return 3;
                case 56:
                    return 4;
                case 58:
                    return 5;
                case 61:
                    return 6;
                case 63:
                    return 7;
                case 66:
                    return 8;
                case 68:
                    return 9;
                case 70:
                    return 10;
            }
        }
        return newNote;
    }

    public void move(){
        y++;
        this.setLocation(x,y);
    }

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
