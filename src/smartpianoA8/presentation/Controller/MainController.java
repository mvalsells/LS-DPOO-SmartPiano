package smartpianoA8.presentation.Controller;

import smartpianoA8.presentation.views.MainFrame;
import smartpianoA8.presentation.views.MainViewV2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private MainFrame mainFrame;
    private MasterController masterController;

    public MainController(MainFrame mainFrame){

        this.mainFrame = mainFrame;

    }

    public void registerController(MasterController masterController){
        this.masterController =masterController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
