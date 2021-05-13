package smartpianoA8.presentation.views;

import smartpianoA8.presentation.views.customComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPFavView extends JPMainView {
    // ---- Inici Atributs ----
    private JPNavBar jpNavBar;
    private JPanel jpMain;
    private JButton jbEditar;
    // ---- Fi Atributs ----
    // ---- Inici Constructors ----
    public JPFavView(){
        setLayout(new BorderLayout());



        //Main JPanel
        jpMain = new JPMainView();
        //jpMain.add(new JLColor("FAV", ColorScheme.PRIMARY));
        jpMain.setBackground(new Color(12,14,22));
        jpMain.setLayout(new BorderLayout());

        JPanel fons = new JPanel();
        fons.setLayout(new BorderLayout());

        JPanel partNord = new JPanel();
        partNord.setBackground(ColorScheme.PopUpsBackground);
        partNord.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        //partNord.setBorder(BorderFactory.createLineBorder(ColorScheme.PopUpsBackground));
        partNord.repaint();
        partNord.setLayout(new BorderLayout());

        JPanel separaciox = new JPanel();
        separaciox.setLayout(new GridLayout(1,3));

        String[] frases = {"Aqui encontraras todas las canciones","que mas te hayan gustado,", "reproducelas cuantas veces quieras,","sin perder tiempo" };

        JPanel[] separacioxx = new JPanel[3];
        JPanel separacioy = new JPanel();
        separacioy.setLayout(new GridLayout(4,1));
        JPanel[] separacioyy = new JPanel[4];
        JLabel[] noms = new JLabel[4];
        for(int i = 0; i<3; i++){
            separacioxx[i] = new JPanel();
            //separacioxx[i].setBorder(BorderFactory.createLineBorder(ColorScheme.MainView_Background));
            separacioxx[i].setBackground(ColorScheme.PopUpsBackground);
            if (i == 1){
                for(int j = 0; j<4; j++){
                    separacioyy[j] = new JPanel();
                    separacioyy[j].setBackground(ColorScheme.PopUpsBackground);
                    noms[j] = new JLabel();
                    //separacioyy[j].setBorder(BorderFactory.createLineBorder(ColorScheme.MainView_Background));
                    noms[j].setText(frases[j]);
                    noms[j].setForeground(ColorScheme.Secondary);
                    separacioyy[j].add(noms[j]);

                    separacioy.add(separacioyy[j]);

                }
                separacioxx[i].add(separacioy);

            }
            separaciox.add(separacioxx[i]);


        }


        //Part Sud
        JPanel partSud = new JPanel();
        partSud.setBackground(Color.RED);
        partSud.setLayout(new BorderLayout());

        JPanel panelEdit = new JPanel();
        panelEdit.setBackground(Color.GREEN);
        panelEdit.setLayout(new BorderLayout());

        JPanel edit = new JPanel();
        edit.setBackground(Color.BLUE);
        //edit.setLayout(new BorderLayout());

        JPanel panelcansonetes = new JPanel();
        panelcansonetes.setLayout(new BorderLayout());

        JPanel cansonetes = new JPanel();
        cansonetes.setLayout(new FlowLayout());



        jbEditar = new JBgeneral("edit", ColorScheme.ORANGE_START);
        edit.add(jbEditar);



        panelcansonetes.add(cansonetes,BorderLayout.SOUTH);

        panelEdit.add(edit,BorderLayout.EAST);
        partSud.add(panelcansonetes,BorderLayout.CENTER);
        partSud.add(panelEdit,BorderLayout.NORTH);

        //ads
        partNord.add(separaciox, BorderLayout.CENTER);
        //partNord.add(informacion, BorderLayout.NORTH);

        fons.add(partNord, BorderLayout.NORTH);
        fons.add(partSud, BorderLayout.CENTER);


        jpMain.add(fons);

        //Packing
        jpNavBar = new JPNavBar(JFMainFrame.FAVS);
        add(jpNavBar,BorderLayout.WEST);
        add(jpMain,BorderLayout.CENTER);
    }
    // ---- Fi Constructors ----
    // ---- Inici Mètodes ----
    public void registerControllers(ActionListener actionListener) {
        jpNavBar.registerController(actionListener);
        jbEditar.addActionListener(actionListener);
    }
}
