package smartpianoA8.presentation.views.customComponents;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Eventos extends KeyAdapter {
    boolean w;
    boolean s;
    boolean up;
    boolean down;

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int tecla = e.getKeyCode();
        if(tecla == KeyEvent.VK_DOWN){
            down = true;
        }
        if(tecla == KeyEvent.VK_W){
            w = true;
        }
        if(tecla == KeyEvent.VK_S){
            s = true;
        }
        if(tecla == KeyEvent.VK_UP){
            up = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        int tecla = e.getKeyCode();
        if(tecla == KeyEvent.VK_DOWN){
            down = false;
        }
        if(tecla == KeyEvent.VK_W){
            w = false;
        }
        if(tecla == KeyEvent.VK_S){
            s = false;
        }
        if(tecla == KeyEvent.VK_UP){
            up = false;
        }
    }
}