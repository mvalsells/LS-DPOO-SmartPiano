package smartpianoA8.presentation.Controller;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.exceptions.PasswordException;
import smartpianoA8.business.exceptions.UserManagerException;
import smartpianoA8.presentation.views.*;
import smartpianoA8.presentation.views.customComponents.JPPiano;

import javax.sound.midi.*;

public class MasterController {
    BusinessFacade businessFacade;
    //Controllers
    WellcomeController wellcomeController;
    MainController mainController;
    //Frames
    WellcomeFrame wellcomeFrame;
    MainFrame mainFrame;

    //Views
    RegisterView registerView;
    LoginView loginView;
    MainView mainView;

    //Channel
    MidiChannel midiChannel;

    public MasterController(BusinessFacade businessFacade){
        this.businessFacade = businessFacade;
        //Channel
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            synth.loadAllInstruments(synth.getDefaultSoundbank());
            Instrument[] insts = synth.getLoadedInstruments();
            MidiChannel channels[] = synth.getChannels();
            //channel = channels[test.getChanel];
            midiChannel = channels[0];


            for (int i = 0; i < insts.length; i++) {
                if (insts[i].toString()
                        .startsWith("Instrument MidiPiano")) {
                    midiChannel.programChange(i);
                    break;
                }
            }
        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }

        //Views
        registerView = new RegisterView();  
        loginView = new LoginView();
        mainView = new MainView();

        //Frames
        wellcomeFrame = new WellcomeFrame(registerView,loginView);
        mainFrame = new MainFrame(mainView);

        //Controllers
        wellcomeController = new WellcomeController(wellcomeFrame);
        mainController = new MainController(mainFrame,midiChannel);
    }

    public void registerAllControlers(){
        //Register this controller to other controllers
        wellcomeController.registerController(this);
        mainController.registerController(this);

        //Register other controllers to their views
        wellcomeFrame.registerController(wellcomeController);
        mainFrame.registerControllerJPPiano(mainController,mainController,mainController);
    }
    //Change views

    //Business Faced Methods
    public void registerUser(String username, String email, String password, String type) throws PasswordException, UserManagerException {
        //TODO ho he comentat donat que s'ha d'afegir la password repetition i llavors no compila
        //  businessFacade.registerUser(username, email, password, type);
    }

}
