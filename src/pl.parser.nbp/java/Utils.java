import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Piotr on 2017-06-10.
 */
public class Utils {
    private final static String url = "http://api.nbp.pl/api/exchangerates/rates/c/";

    public static URL getUrl(String currency, String startDateYear, String startDateMonth, String startDateDay, String endDateYear, String endDateMonth, String endDateDay) throws MalformedURLException {

        //System.out.println(url +currency+ "/" + startDateYear + "-" + startDateMonth + "-" + startDateDay + "/" + endDateYear+ "-" + endDateMonth + "-" + endDateDay + "/");
        return new URL(url + currency + "/" + startDateYear + "-" + startDateMonth + "-" + startDateDay + "/" + endDateYear + "-" + endDateMonth + "-" + endDateDay+"?format=xml");

    }

    public static InputStream getInpusStream(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        return connection.getInputStream();

    }

    public static Document parseDocument(InputStream is) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(is);
        return doc;
    }

    public static NodeList getNodetList(Document doc, String tagname) {
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName(tagname);

        return nodeList;
    }

    public static void getValues(NodeList buyPrices, NodeList sellPrices) {
        double avverageBuyPrice = 0 , avverageSellPrice= 0, buyStandardDeviation =0 , sellStandardDeviation = 0;
        for (int i=0 ; i< buyPrices.getLength(); i++){
            avverageBuyPrice += Double.parseDouble(buyPrices.item(i).getTextContent());
            avverageSellPrice += Double.parseDouble(sellPrices.item(i).getTextContent());

        }
        avverageBuyPrice/=buyPrices.getLength();
        avverageSellPrice/=buyPrices.getLength();

        for (int i=0 ; i< buyPrices.getLength(); i++) {
            buyStandardDeviation += Math.pow((Double.parseDouble(buyPrices.item(i).getTextContent()))-avverageBuyPrice,2);
            sellStandardDeviation += Math.pow(Double.parseDouble(sellPrices.item(i).getTextContent())-avverageSellPrice,2);
        }

        buyStandardDeviation = Math.sqrt(buyStandardDeviation/buyPrices.getLength());
        sellStandardDeviation = Math.sqrt(sellStandardDeviation/sellPrices.getLength());

        System.out.println("Srednia cena kupna: " + avverageBuyPrice);
        System.out.println("Odchylenie standardowe dla kupna to: " + buyStandardDeviation);
        System.out.println("Srednia cena sprzedazy: " + avverageSellPrice);
        System.out.println("Odchylenie standardowe dla sprzedazyto : " + sellStandardDeviation);
    }


}
