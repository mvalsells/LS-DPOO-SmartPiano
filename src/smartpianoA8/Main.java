package smartpianoA8;

import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.BusinessFacadeImpl;
import smartpianoA8.persistence.*;
import smartpianoA8.persistence.dao.PlayListDAO;
import smartpianoA8.persistence.dao.SongDAO;
import smartpianoA8.persistence.dao.StatsDAO;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.*;
import smartpianoA8.presentation.Controller.PresentationController;

import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe principal per l'execució del programa
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou.
 * @implNote Es recomana borrar el cache de cançons de tant en tant
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

        //Connexió BBDD
        SQLConnector connectorSQL = new SQLConnector(jsonReader.getDbUser(),jsonReader.getDbPassword(),jsonReader.getDbAddress(),jsonReader.getDbPort(),jsonReader.getDbName());

        //DAOs BBDD
        UserDAO userDAO = new SQLUserDAO(connectorSQL);
        SongDAO songDAO = new SQLSongDAO(connectorSQL);
        PlayListDAO playListDAO = new SQLPlayListDAO(connectorSQL);
        StatsDAO statsDAO = new SQLStatsDAO(connectorSQL);

        MidiWritter midiWritter = new MidiWritterImpl(songDAO);

        //Business <-> Persitence
        HtmlScrapping htmlScrapping = new HtmlScrappingImpl(songDAO);
        Timer timer = new Timer();
        timer.schedule((TimerTask) htmlScrapping,0, jsonReader.gettimeScrapping()*60000L);

        //Business <-> Presentation
        BusinessFacade businessFacade = new BusinessFacadeImpl(userDAO, songDAO, playListDAO, statsDAO, midiParser);

        //Song song = new Song(0,0,null,null,null,"resources/midiFiles/ChristianTestLele/88196.mid",1,null,null);
        //ObtainNotesWhilePlaying obtainNotesWhilePlaying = new ObtainNotesWhilePlaying();
        //obtainNotesWhilePlaying.playAndGet(song);
/*
        try {
            businessFacade.login("marcv","1234Marc");
        } catch (UserManagerException e) {
            e.printStackTrace();
        }
*/
        PresentationController presentationController = new PresentationController(businessFacade,midiWritter);
       // presentationController.loginOK();
       // presentationController.changeView(JFMainFrame.PROFILE);

        presentationController.logoutOK();
        songDAO.registerPresentationFacade(presentationController);


//*/

        //
        // ------------------------------
        // END Main smart piano
        // ------------------------------


        // ------------------------------
        // START proves
        // ------------------------------
        //


        //*/
    }
}