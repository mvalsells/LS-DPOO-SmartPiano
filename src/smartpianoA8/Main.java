package smartpianoA8;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.BusinessFacadeImpl;
import smartpianoA8.business.entity.Notes;
import smartpianoA8.business.entity.Song;
import smartpianoA8.persistence.*;
import smartpianoA8.persistence.dao.PlayListDAO;
import smartpianoA8.persistence.dao.SongDAO;
import smartpianoA8.persistence.dao.StatsDAO;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.*;
import smartpianoA8.presentation.Controller.MasterController;
import smartpianoA8.presentation.views.*;
import smartpianoA8.presentation.views.customComponents.JPPiano;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // ------------------------------
        // START Main smart piano
        // ------------------------------
/*
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

        MidiParser midiParser = new MidiParserImpl();

        //Connexió BBDD
        SQLConnector connectorSQL = new SQLConnector(jsonReader.getDbUser(),jsonReader.getDbPassword(),jsonReader.getDbAddress(),jsonReader.getDbPort(),jsonReader.getDbName());

        //DAOs BBDD
        UserDAO userDAO = new SQLUserDAO(connectorSQL);
        SongDAO songDAO = new SQLSongDAO(connectorSQL);
        PlayListDAO playListDAO = new SQLPlayListDAO(connectorSQL);
        StatsDAO statsDAO = new SQLStatsDAO(connectorSQL);

        //Business <-> Presentation
        BusinessFacade businessFacade = new BusinessFacadeImpl(userDAO, songDAO, playListDAO, statsDAO, midiParser);
        MasterController pianoController = new MasterController(businessFacade);
        pianoController.registerAllControlers();

        //Business <-> Persitence
        HtmlScrapping htmlScrapping = new HtmlScrappingImpl(songDAO);
        Timer timer = new Timer();
        timer.schedule((TimerTask) htmlScrapping,0, jsonReader.gettimeScrapping()*60000L);
        Thread.sleep(3000);
        //ArrayList<Song> midiSongs = htmlScrapping.getMidiSongs();
        //System.out.println("lele");

        ArrayList<Song> midiSongs = businessFacade.getMasterSongs();
        System.out.println("lele");

        //Test vista canciones descargadas
        SongsView songsView = new SongsView(midiSongs);


        //Song song = new Song(0,0,null,null,null,"resources/midiFiles/Master/Toccatina.mid",1,null,null);
        Song song = new Song(0,0,null,null,null,"resources/midiFiles/papaya/myownfile.mid",1,null,null);
        ArrayList<ArrayList<Notes>> test = businessFacade.getMidiNotes(song);
        System.out.println("BPMMMM: " + businessFacade.getMidiBpm());
        System.out.println("NUM TRACKSSSSS: " + businessFacade.getNumTracks());
        System.out.println("TOTAL TICKSSSSS: " + businessFacade.getTotalTicks());
        System.out.println("SECONDS PER TICKKKKK: " + businessFacade.getSecondsPerTick());
        System.out.println("TOTAL SONG SECONDSSSSSS: " + businessFacade.getTotalSongSeconds());

        //*/
        // ------------------------------
        // END Main smart piano
        // ------------------------------


        // ------------------------------
        // START proves
        // ------------------------------
        //
/*
        //----------- albert inici
        /*JPPiano piano = new JPPiano();
        JFrame main = new JFrame();
        main.add(piano);
        main.pack();
        main.setVisible(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
*/
        //-----Albert fi

        // ---- Marc Inici ----
        JPProfile mainView = new JPProfile();
        JFrame main = new JFrame();
        main.add(mainView);
        main.pack();
        main.setVisible(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//*/
        // ---- Marc fi ----



/*


        //BERTU--------------------------------STATISTICS

        /*ArrayList<Integer> valorsCancons = new ArrayList<>();
        ArrayList<Double> valorsMinuts = new ArrayList<>();
        //rand valors
        valorsMinuts.add(0.0);
        valorsMinuts.add(1.0);
        valorsMinuts.add(0.0);
        valorsMinuts.add(3.0);
        valorsMinuts.add(5.0);
        valorsMinuts.add(5.0);
        valorsMinuts.add(6.0);
        valorsMinuts.add(12.0);
        valorsMinuts.add(8.0);
        valorsMinuts.add(9.0);
        valorsMinuts.add(10.0);
        valorsMinuts.add(11.0);
        valorsMinuts.add(2.0);
        valorsMinuts.add(13.0);
        valorsMinuts.add(14.0);
        valorsMinuts.add(10.0);
        valorsMinuts.add(7.0);
        valorsMinuts.add(6.0);
        valorsMinuts.add(18.0);
        valorsMinuts.add(12.0);
        valorsMinuts.add(20.0);
        valorsMinuts.add(21.0);
        valorsMinuts.add(10.0);
        valorsMinuts.add(30.0);
        valorsCancons.add(0);
        valorsCancons.add(1);
        valorsCancons.add(1);
        valorsCancons.add(4);
        valorsCancons.add(6);
        valorsCancons.add(12);
        valorsCancons.add(24);
        valorsCancons.add(1);
        valorsCancons.add(5);
        valorsCancons.add(12);
        valorsCancons.add(4);
        valorsCancons.add(7);
        valorsCancons.add(14);
        valorsCancons.add(13);
        valorsCancons.add(8);
        valorsCancons.add(20);
        valorsCancons.add(16);
        valorsCancons.add(13);
        valorsCancons.add(6);
        valorsCancons.add(2);
        valorsCancons.add(0);
        valorsCancons.add(13);
        valorsCancons.add(17);
        valorsCancons.add(5);

        StatisticsView stats = new StatisticsView(valorsMinuts,valorsCancons);*/

        //BERTU--------------------------------STATISTICS
     /* ArrayList<Song> topSongs = songDAO.getTop5();
      Top5View top5 = new Top5View(topSongs);

/*
        /*HtmlScrapping htmlScrapping = new HtmlScrapping();
        try {
            htmlScrapping.Scrapping();
        } catch (IOException e){
            e.printStackTrace();
        }*/
        /*
        HtmlScrapping htmlScrapping = new HtmlScrappingImpl();
        Timer timer = new Timer();
        timer.schedule((TimerTask) htmlScrapping,0, jsonReader.gettimeScrapping()*60000L);

        Thread.sleep(3000);
        ArrayList<MidiSong> midiSongs = htmlScrapping.getMidiSongs();

        System.out.println("lele");
        */
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

        /*MidiParser midiParser = new MidiParserImpl();
        midiParser.ParseMidi("/Users/christianhasko/IdeaProjects/dpoo-2021-smartpiano-a8/NO-CODI/Unknown_-_pokemon.mid");
        System.out.println(midiParser.getTracks());
        ArrayList<ArrayList<Notes>> test = midiParser.getTracks();

        System.out.println("lele");*/

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