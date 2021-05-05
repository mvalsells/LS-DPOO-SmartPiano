package smartpianoA8;

import smartpianoA8.business.BusinessFacade;

import smartpianoA8.business.BusinessFacadeImpl;
import smartpianoA8.business.HtmlScrapping;
import smartpianoA8.persistence.JsonReadable;
import smartpianoA8.persistence.JsonReadableImpl;
import smartpianoA8.persistence.dao.PlayListDAO;
import smartpianoA8.persistence.dao.SongDAO;
import smartpianoA8.persistence.dao.StatsDAO;
import smartpianoA8.persistence.dao.UserDAO;
import smartpianoA8.persistence.dao.sql.*;
import smartpianoA8.presentation.Controller.PianoController;
import smartpianoA8.presentation.Controller.WellcomeController;
import smartpianoA8.presentation.views.PianoView;
import smartpianoA8.presentation.views.WellcomeFrame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
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

        //Connexió BBDD
        SQLConnector connectorSQL = new SQLConnector(jsonReader.getDbUser(),jsonReader.getDbPassword(),jsonReader.getDbAddress(),jsonReader.getDbPort(),jsonReader.getDbName());

        //DAOs BBDD
        UserDAO userDAO = new SQLUserDAO(connectorSQL);
        SongDAO songDAO = new SQLSongDAO(connectorSQL);
        PlayListDAO playListDAO = new SQLPlayListDAO(connectorSQL);
        StatsDAO statsDAO = new SQLStatsDAO(connectorSQL);

        //Business <-> Presentation
        BusinessFacade businessFacade = new BusinessFacadeImpl(userDAO, songDAO, playListDAO, statsDAO);
        PianoController pianoController = new PianoController(businessFacade);
        pianoController.registerAllControlers();
        //*/
        // ------------------------------
        // END Main smart piano
        // ------------------------------


        // ------------------------------
        // START proves
        // ------------------------------
        ///*

        /*HtmlScrapping htmlScrapping = new HtmlScrapping();
        try {
            htmlScrapping.Scrapping();
        } catch (IOException e){
            e.printStackTrace();
        }*/

        Timer timer = new Timer();
        timer.schedule(new HtmlScrapping(), 0, 5000);

        System.out.println("leleleleel");

        //PianoView pianoView = new PianoView();
        //WellcomeFrame wellcomeFrame = new WellcomeFrame();
        //WellcomeController wellcomeController = new WellcomeController();

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