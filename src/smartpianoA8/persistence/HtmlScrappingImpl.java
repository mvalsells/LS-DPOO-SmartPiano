package smartpianoA8.persistence;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import smartpianoA8.business.BusinessFacade;
import smartpianoA8.business.entity.Song;
import smartpianoA8.persistence.dao.SongDAO;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Classe per l'obtenció de cançons d'internet
 * @version 1.0
 * @author Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 * @see Runnable
 * @see TimerTask
 */
public class HtmlScrappingImpl extends TimerTask implements HtmlScrapping {



    private static final String url1 = "https://www.mutopiaproject.org/cgibin/make-table.cgi?startat=";
    private static int page = 0;
    private static final String url2 = "&Instrument=Piano";
    private ArrayList<Song> midiSongs;
    private int newData;
    private SongDAO songDAO;

    /**
     * Constructor amb l'interficie de cançons de la bbdd
     * @param songDAO interficie de cançons de la bbdd
     */
    public HtmlScrappingImpl(SongDAO songDAO){
        midiSongs = new ArrayList<Song>();
        newData = 0;
        this.songDAO = songDAO;
    }

    /**
     * Mètode per executar el recolector scrapper de cançons.
     * @see Thread
     * @see Runnable
     */
    @Override
    public void run() {

        int counter = 0;
        String author = null;
        String songName = null;
        String datePublished = null;
        String midiAddress = null;

        System.out.println(url1.concat(page+url2));

        newData = 0;


        try {
            if(getConnectionStatus(url1.concat(page+url2)) == 200) {
                Document document = getHtmlDocument(url1.concat(page+url2));
                //Elements entry = document.select("table-bordered result-table");
                //System.out.println("lele");

                System.out.println("\n\nThere are " + document.select("table[class=table-bordered result-table]").size() + " songs in a single table. (Songs per page)\n\n");

                for(Element table : document.select("table[class=table-bordered result-table]")) {

                    for(Element row : table.select("tr")) {

                        Elements tds = row.select("td");

                        //System.out.println(tds.get(0).text() + "->" + tds.get(1).text());

                        switch (counter) {
                            case 0:
                                songName = tds.get(0).text();
                                songName = songName.replaceAll("[\\№]","N.");
                                songName = songName.replaceAll("[\\-\\\"\\+\\?\\¿\\^:,]","");
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

                    String localMidiAddress = downloadMidiFile(midiAddress, songName);

                    if(datePublished.equals("")) {
                        Song song = new Song(0, 0, songName, author, "Unknown", localMidiAddress, 1, Song.Master, midiAddress);
                        //MidiSong midiSong = new MidiSong(songName, author, "Unknown", localMidiAddress);
                        if(!midiSongs.contains(song)) {
                            midiSongs.add(song);
                            newData = 1;
                            saveSong(song);
                            isNewData();
                        }
                    }else {
                        Song song = new Song(0, 0, songName, author, datePublished, localMidiAddress, 1, Song.Master, midiAddress);
                        //MidiSong midiSong = new MidiSong(songName, author, datePublished, localMidiAddress);
                        if(!midiSongs.contains(song)) {
                            midiSongs.add(song);
                            newData = 1;
                            saveSong(song);
                            isNewData();
                        }
                    }


                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        page = page + 2;

    }

    /**
     * Mètode per descarregar una cançó de la bbdd
     * @param addr url
     * @param songName nom de la cançó
     * @return url i ruta
     */
    private String downloadMidiFile(String addr, String songName) {

        String whereIsTheFile;
        File out = new File("resources/midiFiles/Master/"+songName+".mid");
        whereIsTheFile = "resources/midiFiles/Master/"+songName+".mid";

        try {
            URL url = new URL(addr);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            double fileSize = (double) httpURLConnection.getContentLengthLong();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(out);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024);
            byte[] buffer = new byte[1024];
            double downloaded = 0.00;
            int read = 0;
            double percentDownloaded = 0.00;

            while ((read = bufferedInputStream.read(buffer, 0, 1024)) >= 0) {
                bufferedOutputStream.write(buffer, 0, read);
                downloaded += read;
                percentDownloaded = (downloaded*100)/fileSize;
                String percent = String.format("%.4f", percentDownloaded);
                System.out.println("Downloaded: " + percent + "% of a file.");
            }
            bufferedOutputStream.close();
            bufferedInputStream.close();
            System.out.println("Download complete.");

        } catch (IOException e) {
            e.printStackTrace();
        }


        return whereIsTheFile;

    }

    /**
     * Mètode epr obtenir el midi de les cançons
     * @return ArrayList de cançons MIDI
     */
    @Override
    public ArrayList<Song> getMidiSongs() {
        return midiSongs;
    }

    @Override
    public boolean isNewData() {
        if(newData == 1) {
            return true;
        }else {
            return false;
        }
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
     * @param url direcció
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
     * @param url direcció
     * @return Documento con el HTML
     */
    private static Document getHtmlDocument(String url) {

        Document document = null;
        try {
            document = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.err.println("Exception in obtaining HTML from page" + ex.getMessage());
        }
        return document;
    }

    /**
     * Mètode per guardar uan cançó a la bbddd
     * @param song la cançó
     */
    private void saveSong(Song song){
        songDAO.addSongInMaster(song);
    }

}
