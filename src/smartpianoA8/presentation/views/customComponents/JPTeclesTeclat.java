package smartpianoA8.presentation.views.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class JPTeclesTeclat extends JPanel {
    public static int OCTAVES = 3;
    private final WhiteKey[] whites = new WhiteKey[7 * OCTAVES + 1];
    private final BlackKey[] blacks = new BlackKey[5 * OCTAVES];


    public JPTeclesTeclat(){
        JPanel teclat = new JPanel(null){
            @Override
            public Dimension getPreferredSize() {
                int count = getComponentCount();
                Component last = getComponent(count - 1);
                Rectangle bounds = last.getBounds();
                int width = 10 + bounds.x + bounds.width;
                int height = 10 + bounds.y + bounds.height;

                return new Dimension(width, height);
            }


        };
        teclat.setBackground(Color.BLACK);
        //teclat.addKeyListener(this);
        char lletresBlack = '0';
        for (int i = 0; i < blacks.length; i++) {
            blacks[i] = new BlackKey(i);

            if(lletresBlack < 'a'){
                blacks[i].setText(String.valueOf(lletresBlack));
                lletresBlack++;

            }else {
                lletresBlack = '0';
                blacks[i].setText(String.valueOf(lletresBlack));
            }
            blacks[i].setForeground(Color.WHITE);
            blacks[i].setFont(new Font("Verdana", Font.PLAIN, 6));
            teclat.add(blacks[i]);
        }

        char lletresWhite = 'a';
        for (int i = 0; i < whites.length; i++) {

            whites[i] = new WhiteKey(i);
            if(lletresWhite < 'z'){
                //whites[i].setAlignmentX(0);
                whites[i].setText(String.valueOf(lletresWhite));

                lletresWhite ++;
            }else {
                lletresWhite = 'a';
                whites[i].setText(String.valueOf(lletresWhite));
            }
            teclat.add(whites[i]);

        }
        add(teclat);
    }

    public void registerController(MouseListener mouseListener){
        for (BlackKey black : blacks) {
            black.addMouseListener(mouseListener);
        }
        for (WhiteKey white : whites) {
            white.addMouseListener(mouseListener);
        }
    }
}
