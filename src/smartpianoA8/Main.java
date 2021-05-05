package smartpianoA8;

import smartpianoA8.presentation.views.StatisticsView;

import java.util.ArrayList;

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


        /*HtmlScrapping htmlScrapping = new HtmlScrapping();
        try {
            htmlScrapping.Scrapping();
        } catch (IOException e){
            e.printStackTrace();
        }*/

        /*Timer timer = new Timer();
        timer.schedule(new HtmlScrapping(), 0, 5000);

        System.out.println("leleleleel");*/

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