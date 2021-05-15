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
import smartpianoA8.presentation.Controller.PianoCascadeController;
import smartpianoA8.presentation.Controller.PresentationController;
import smartpianoA8.presentation.views.JFSongsTable;
import smartpianoA8.presentation.views.customComponents.JPPiano;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe principal
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou.
 */
public class Main {
    /**
     * Mètode principal per executar el programa
     * @param args arguemnts de la linia cmd (N/A)
     * @throws InterruptedException interrupció de sortida del programam
     */
    public static void main(String[] args) throws InterruptedException {
        // ------------------------------
        // START Main smart piano
        // ------------------------------

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
        MidiWritter midiWritter = new MidiWritterImpl();

        //Connexió BBDD
        SQLConnector connectorSQL = new SQLConnector(jsonReader.getDbUser(),jsonReader.getDbPassword(),jsonReader.getDbAddress(),jsonReader.getDbPort(),jsonReader.getDbName());

        //DAOs BBDD
        UserDAO userDAO = new SQLUserDAO(connectorSQL);
        SongDAO songDAO = new SQLSongDAO(connectorSQL);
        PlayListDAO playListDAO = new SQLPlayListDAO(connectorSQL);
        StatsDAO statsDAO = new SQLStatsDAO(connectorSQL);

        //Business <-> Presentation
        BusinessFacade businessFacade = new BusinessFacadeImpl(userDAO, songDAO, playListDAO, statsDAO, midiParser);
        PresentationController presentationController = new PresentationController(businessFacade,midiWritter);
        presentationController.registerAllControlers();
/*
        //Song
        //Test vista canciones descargadas
        ArrayList<Song> midiSongs = businessFacade.getMasterSongs();
        System.out.println("lele");
        JFSongsTable songsView = new JFSongsTable(midiSongs);


        Song song = new Song(0,0,null,null,null,"resources/midiFiles/Master/Toccatina.mid",1,null,null);
        //Song song = new Song(0,0,null,null,null,"resources/midiFiles/papaya/myownfile copia.mid",1,null,null);
        ArrayList<ArrayList<Notes>> test = businessFacade.getMidiNotes(song);
        System.out.println("BPMMMM: " + businessFacade.getMidiBpm());
        System.out.println("NUM TRACKSSSSS: " + businessFacade.getNumTracks());
        System.out.println("TOTAL TICKSSSSS: " + businessFacade.getTotalTicks());
        System.out.println("SECONDS PER TICKKKKK: " + businessFacade.getSecondsPerTick());
        System.out.println("TOTAL SONG SECONDSSSSSS: " + businessFacade.getTotalSongSeconds());
        System.out.println("TOTAL SONG MICROSECONDS PER TICKKKKKK: " + businessFacade.getµsPerTickMidiNotes());



        //Partitura
        ArrayList<ArrayList<Notes>> partitura = businessFacade.getMidiNotes(song);




        //Business <-> Persitence
        HtmlScrapping htmlScrapping = new HtmlScrappingImpl(songDAO);
        Timer timer = new Timer();
        timer.schedule((TimerTask) htmlScrapping,0, jsonReader.gettimeScrapping()*60000L);
        Thread.sleep(3000);
        //ArrayList<Song> midiSongs = htmlScrapping.getMidiSongs();
        //System.out.println("lele");


*/


/*
        //
        // ------------------------------
        // END Main smart piano
        // ------------------------------


        // ------------------------------
        // START proves
        // ------------------------------
        //

        //----------- albert inici
        /*JPPiano piano = new JPPiano();
        JFrame main = new JFrame();
        main.add(piano);
        main.pack();
        main.setVisible(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //-----Albert fi

        // ---- Marc Inici ----
        //MainView mainView = new MainView();
        /*MainViewV2 mainView = new MainViewV2();
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

        JFStatisticsView stats = new JFStatisticsView(valorsMinuts,valorsCancons);*/

        //BERTU--------------------------------STATISTICS
     /* ArrayList<Song> topSongs = songDAO.getTop5();
      JFTop5View top5 = new JFTop5View(topSongs);


*/
        //JPPiano pianoView = new JPPiano();



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

        //JFPianoView pianoView = new JFPianoView();
        //JFWellcomeFrame wellcomeFrame = new JFWellcomeFrame();
        //WellcomeController wellcomeController = new WellcomeController();
        //PianoPlayingView pianoPlayingView = new PianoPlayingView();
        //pianoView.setVisible(true);
        //IniciView menuView = new IniciView();
        //menuView.setVisible(true);
        //smartpianoA8.presentation.views.JPLoginView loginView = new JPLoginView();
        ///registerView.setSize(400,400);
        /*smartpianoA8.presentation.views.JPRegisterView registerView = new smartpianoA8.presentation.views.JPRegisterView();
        registerView.setVisible(true);*/

        //*/
    }
}