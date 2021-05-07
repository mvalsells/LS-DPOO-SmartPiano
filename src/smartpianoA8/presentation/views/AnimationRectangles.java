package smartpianoA8.presentation.views;

import java.awt.*;

public class AnimationRectangles extends Rectangle {
    private int note, velocity, chanel, duration, startTime, endTime;

    public AnimationRectangles(int chanel, int note, int velocity, int xposs, int duration, int endTime, int startTime){
        this.chanel=chanel;
        this.note=note;
        this.velocity=velocity;
        this.x = xposs;
        this.duration = duration;
        this.endTime = endTime;
        this.startTime = startTime;
        duration = endTime-startTime;
        this.y= (-duration);
        //setBounds(x);

    }


}
