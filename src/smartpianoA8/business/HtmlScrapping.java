package smartpianoA8.business;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import smartpianoA8.persistence.dao.UserDAO;

import java.io.IOException;

public class HtmlScrapping {

    public static final String url1 = "https://www.mutopiaproject.org/cgibin/make-table.cgi?startat=";
    public static int page = 0;
    public static final String url2 = "&Instrument=Piano";

    public HtmlScrapping(/*UserDAO userDAO*/){
    }

    public void Scrapping() throws IOException {

        page=0;
        System.out.println(url1.concat(page+url2));

        if(getConnectionStatus(url1.concat(page+url2)) == 200) {
            Document document = getHtmlDocument(url1.concat(page+url2));
            //Elements entry = document.select("table-bordered result-table");
            //System.out.println("lele");

            for(Element table : document.select("table[class=table-bordered result-table]")) {

                for(Element row : table.select("tr")) {
                    Elements tds = row.select("td");
                    System.out.println(tds.get(0).text() + "->" + tds.get(1).text());
                }

            }






        }

    }


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
            System.err.println("Exception in obtainig status code: " + e.getMessage());
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
