package smartpianoA8.business;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import smartpianoA8.business.entity.MidiSong;
import smartpianoA8.persistence.dao.UserDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

public class HtmlScrapping extends TimerTask {

    private static final String url1 = "https://www.mutopiaproject.org/cgibin/make-table.cgi?startat=";
    private static int page = 0;
    private static final String url2 = "&Instrument=Piano";
    private ArrayList<MidiSong> midiSongs = new ArrayList<MidiSong>();

    //TODO FALTA COMPROBAR SI YA EXISTE ESA CANCION SALTARLA

    @Override
    public void run() {

        int counter = 0;
        String author = null;
        String songName = null;
        String datePublished = null;
        String midiAddress = null;

        System.out.println(url1.concat(page+url2));


        try {
            if(getConnectionStatus(url1.concat(page+url2)) == 200) {
                Document document = getHtmlDocument(url1.concat(page+url2));
                //Elements entry = document.select("table-bordered result-table");
                //System.out.println("lele");

                System.out.println("\n\nThere are " + document.select("table[class=table-bordered result-table]").size() + " songs in a single table. (Songs per page)\n\n");

                for(Element table : document.select("table[class=table-bordered result-table]")) {

                    for(Element row : table.select("tr")) {

                        Elements tds = row.select("td");
                        //TODO save tds in an arraylist of midisong with all data for every row for every table.
                        //System.out.println(tds.get(0).text() + "->" + tds.get(1).text());

                        switch (counter) {
                            case 0:
                                songName = tds.get(0).text();
                                author = tds.get(1).text();
                                break;
                            case 1:
                                datePublished = tds.get(1).text();
                                break;
                            case 3:
                                Element link = tds.get(1).select("a").first();
                                midiAddress = link.attr("abs:href");
                                //midiAddress = tds.get(1).getElementsByAttribute("abd:href").text();
                                break;
                            default:
                        }

                        counter++;
                    }

                    counter = 0;
                    MidiSong midiSong = new MidiSong(songName, author, datePublished, midiAddress);
                    midiSongs.add(midiSong);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        page = page + 11;

    }



    //public HtmlScrapping(/*UserDAO userDAO*/){
    //}

    /*public void Scrapping() throws IOException {

        ArrayList<MidiSong> midiSongs = new ArrayList<MidiSong>();
        int counter = 0;
        String author = null;
        String songName = null;
        String datePublished = null;
        String midiAddress = null;

        page=0;
        System.out.println(url1.concat(page+url2));

        if(getConnectionStatus(url1.concat(page+url2)) == 200) {
            Document document = getHtmlDocument(url1.concat(page+url2));
            //Elements entry = document.select("table-bordered result-table");
            //System.out.println("lele");

            System.out.println("\n\nThere are " + document.select("table[class=table-bordered result-table]").size() + " songs in a single table. (Songs per page)\n\n");

            for(Element table : document.select("table[class=table-bordered result-table]")) {

                for(Element row : table.select("tr")) {

                    Elements tds = row.select("td");
                    //TODO save tds in an arraylist of midisong with all data for every row for every table.
                    System.out.println(tds.get(0).text() + "->" + tds.get(1).text());

                    switch (counter) {
                        case 0:
                            songName = tds.get(0).text();
                            author = tds.get(1).text();
                            break;
                        case 1:
                            datePublished = tds.get(1).text();
                            break;
                        case 3:
                            Element link = tds.get(1).select("a").first();
                            midiAddress = link.attr("abs:href");
                            //midiAddress = tds.get(1).getElementsByAttribute("abd:href").text();
                            break;
                        default:
                    }

                    counter++;
                }

                counter = 0;
                MidiSong midiSong = new MidiSong(songName, author, datePublished, midiAddress);
                midiSongs.add(midiSong);


            }

        }

    }*/


    /**
     * Compruebo el Status code de la respuesta que recibo al hacer la petición
     * 		200 OK			        300 Multiple Choices
     * 		301 Moved Permanently	305 Use Proxy
     * 		400 Bad Request		    403 Forbidden
     * 		404 Not Found		    500 Internal Server Error
     * 		502 Bad Gateway		    503 Service Unavailable
     * @param url
     * @return Status Code
     */
    private static int getConnectionStatus(String url) throws IOException {
        Connection.Response response = null;

        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException e) {
            System.err.println("Exception in obtainig status code: " + response.statusCode());
        }
        return response.statusCode();
    }

    /**
     * Devuelvo un objeto de la clase Document con el contenido del
     * HTML de la web que me permitirá parsearlo con los métodos de la librelia JSoup
     * @param url
     * @return Documento con el HTML
     */
    private static Document getHtmlDocument(String url) {

        Document document = null;
        try {
            document = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Exception in obtaining HTML from page" + ex.getMessage());
        }
        return document;
    }

}
