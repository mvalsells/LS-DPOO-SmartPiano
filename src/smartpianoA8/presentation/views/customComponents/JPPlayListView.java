package smartpianoA8.presentation.views.customComponents;

import smartpianoA8.business.entity.PlayList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPPlayListView extends JPMainView {

    private CardLayout cards;
    private JPanel jpCardPanel;

    public JPPlayListView(ArrayList<PlayList> hasPlayLists) {

        setBackground(new Color(12, 14, 22));
        setLayout(new BorderLayout());

        /*----------------------------------------Part Nord----------------------------------------*/

        JPanel panellNord = new JPMainView();
        panellNord.setLayout(new FlowLayout(FlowLayout.LEADING));

        String[] stringBox = new String[hasPlayLists.size()];

        for(int i = 0;i<hasPlayLists.size();i++){

            stringBox[i] = (hasPlayLists.get(i).getNom());

        }

        JComboBox jcTriarPlaylist = new JComboBox(stringBox);
        jcTriarPlaylist.setSelectedIndex(0);
        panellNord.add(jcTriarPlaylist);

        /*----------------------------------------Part centre(CardPanel)----------------------------------------*/
        cards = new CardLayout();
        jpCardPanel = new JPanel(cards);





    }

}
