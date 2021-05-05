package smartpianoA8;

import smartpianoA8.business.*;
import smartpianoA8.business.entity.MidiSong;
import smartpianoA8.business.entity.Notes;
import smartpianoA8.persistence.*;
import smartpianoA8.persistence.dao.PlayListDAO;
import smartpianoA8.persistence.dao.SongDAO;
import smartpianoA8.persistence.dao.StatsDAO;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.*;
import smartpianoA8.presentation.Controller.MasterController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // ------------------------------
        // START Main smart piano
        // ------------------------------
        ///*
        //Exit Status
        final int EXIT_UnableToReadConfigFile = 1;
        final int EXIT_UnableToConnectToDDBB = 2;


        //Llegir fitxer config
        JsonReadable jsonReader = new JsonReadableImpl();

        try {
            jsonReader.readJsonConfig();
        }catch (FileNotFoundException f){
            System.out.println("ERROR: No s'ha pogut llegir el fitxer de configuració");
            System.exit(EXIT_UnableToReadConfigFile);
        }

        //Connexió BBDD
        SQLConnector connectorSQL = new SQLConnector(jsonReader.getDbUser(),jsonReader.getDbPassword(),jsonReader.getDbAddress(),jsonReader.getDbPort(),jsonReader.getDbName());

        //DAOs BBDD
        UserDAO userDAO = new SQLUserDAO(connectorSQL);
        SongDAO songDAO = new SQLSongDAO(connectorSQL);
        PlayListDAO playListDAO = new SQLPlayListDAO(connectorSQL);
        StatsDAO statsDAO = new SQLStatsDAO(connectorSQL);

        //Business <-> Presentation
        BusinessFacade businessFacade = new BusinessFacadeImpl(userDAO, songDAO, playListDAO, statsDAO);
        MasterController pianoController = new MasterController(businessFacade);
        pianoController.registerAllControlers();
        //*/
        // ------------------------------
        // END Main smart piano
        // ------------------------------


        // ------------------------------
        // START proves
        // ------------------------------
        ///*

        //BERTU--------------------------------STATISTICS
        /*
        ArrayList<Integer> valorsCancons = new ArrayList<>();
        ArrayList<Float> valorsMinuts = new ArrayList<>();
        //rand valors
        float j = 0;
        for(int i = 0; i<24;i++){
            valorsCancons.add(i);
            valorsMinuts.add(j);
            j += 1.0f;
        }

        StatisticsView stats = new StatisticsView(valorsCancons, valorsMinuts);
        */
        //BERTU--------------------------------STATISTICS

        /*HtmlScrapping htmlScrapping = new HtmlScrapping();
        try {
            htmlScrapping.Scrapping();
        } catch (IOException e){
            e.printStackTrace();
        }*/

        HtmlScrapping htmlScrapping = new HtmlScrappingImpl();
        Timer timer = new Timer();
        timer.schedule((TimerTask) htmlScrapping,0,100);

        Thread.sleep(3000);
        ArrayList<MidiSong> midiSongs = htmlScrapping.getMidiSongs();

        System.out.println("lele");

        /*HtmlScrapping HtmlScrapping = new HtmlScrapping();
        Timer timer = new Timer();
        timer.schedule(HtmlScrapping, 0, 100);

        //Todo preguntar si se puede hacer asi - NO. implementar interficie para obtener cosas.
        Thread.sleep(5000);
        ArrayList<MidiSong> midiSongs = HtmlScrapping.getMidiSongs();
        //cada vez que hay nuevos datos decir a la vista que debe actualizarlos
        System.out.println("lele");*/

        //parser en persistence
        //MidiParserImpl midiParser = new MidiParserImpl("/Users/christianhasko/IdeaProjects/dpoo-2021-smartpiano-a8/NO-CODI/Unknown_-_pokemon.mid");

        MidiParser midiParser = new MidiParserImpl();
        midiParser.ParseMidi("/Users/christianhasko/IdeaProjects/dpoo-2021-smartpiano-a8/NO-CODI/Unknown_-_pokemon.mid");
        System.out.println(midiParser.getTracks());
        ArrayList<ArrayList<Notes>> test = midiParser.getTracks();

        System.out.println("lele");

        /*Timer timer = new Timer();
        timer.schedule(new HtmlScrapping(), 0, jsonReader.gettimeScrapping()* 1000L);*/



        //System.out.println("leleleleel");

        //PianoView pianoView = new PianoView();
        //WellcomeFrame wellcomeFrame = new WellcomeFrame();
        //WellcomeController wellcomeController = new WellcomeController();
        //PianoPlayingView pianoPlayingView = new PianoPlayingView();
        //pianoView.setVisible(true);
        //IniciView menuView = new IniciView();
        //menuView.setVisible(true);
        //smartpianoA8.presentation.views.LoginView loginView = new LoginView();
        ///registerView.setSize(400,400);
        /*smartpianoA8.presentation.views.RegisterView registerView = new smartpianoA8.presentation.views.RegisterView();
        registerView.setVisible(true);*/

        //*/
    }
}