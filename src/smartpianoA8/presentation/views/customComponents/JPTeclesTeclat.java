package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class JPTeclesTeclat extends JPanel {
    public static int OCTAVES = 3;
    private final WhiteKey[] whites = new WhiteKey[7 * OCTAVES + 1];
    private final BlackKey[] blacks = new BlackKey[5 * OCTAVES];


    public JPTeclesTeclat(){
        setBackground(Color.BLACK);
        setLayout(null);
        //teclat.addKeyListener(this);
        for (int i = 0; i < blacks.length; i++) {
            blacks[i] = new BlackKey(i);
            add(blacks[i]);
        }
        for (int i = 0; i < whites.length; i++) {

            whites[i] = new WhiteKey(i);
            add(whites[i]);

        }
    }

    public void registerController(MouseListener mouseListener){
        for (BlackKey black : blacks) {
            black.addMouseListener(mouseListener);
        }
        for (WhiteKey white : whites) {
            white.addMouseListener(mouseListener);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        int count = getComponentCount();
        Component last = getComponent(count - 1);
        Rectangle bounds = last.getBounds();
        int width = 10 + bounds.x + bounds.width;
        int height = 10 + bounds.y + bounds.height;

        return new Dimension(width, height);
    }
}
