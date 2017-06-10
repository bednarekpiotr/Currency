import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Piotr on 2017-06-09.
 */
public class MainClass {


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        DataFromUser dfu = new DataFromUser();
        System.out.println("Witaj");

        System.out.println("1) USD");
        System.out.println("2) EUR");
        System.out.println("3) CHF");
        System.out.println("4) GBP");
        Scanner scanner = new Scanner(System.in);
        int var;
        String currency = null;

        System.out.println("Wybierz walutę spośród możliwych ");
        var = scanner.nextInt();
        System.out.println("Podaj datę początkową");
        System.out.println("Dzień w formacie DD: ");
        dfu.setStartDateDay(scanner.next());
        System.out.println("Miesiąc w formacie MM: ");
        dfu.setStartDateMonth(scanner.next());
        System.out.println("Rok w formacie RRRR: ");
        dfu.setStartDateYear(scanner.next());
        System.out.println("Podaj datę końcową ");
        System.out.println("Dzień w formacie DD: ");
        dfu.setEndDateDay(scanner.next());
        System.out.println("Miesiąc w formacie MM: ");
        dfu.setEndDateMonth(scanner.next());
        System.out.println("Rok w formacie RRRR: ");
        dfu.setEndDateYear(scanner.next());
        //}brak walidacji danych

        switch (var) {
            case (1): {
                System.out.println("Wybrano USD");
                currency = "USD";
                break;
            }
            case (2): {
                System.out.println("Wybrano EUR");
                currency = "EUR";
                break;
            }
            case (3): {
                System.out.println("Wybrano CHF");
                currency = "CHF";
                break;
            }
            case (4): {
                System.out.println("Wybrano GBP");
                currency = "GBP";
                break;
            }
            default: {
                break;
            }
        }
        try {
            URL url = Utils.getUrl(currency, dfu.getStartDateYear(), dfu.getStartDateMonth(), dfu.getStartDateDay(), dfu.getEndDateYear(), dfu.getEndDateMonth(), dfu.getEndDateDay());
            InputStream is = Utils.getInpusStream(url);
            Document doc = Utils.parseDocument(is);
            NodeList cenakupna = Utils.getNodetList(doc, "Bid");
            NodeList cenaSprzedazy = Utils.getNodetList(doc, "Ask");
            Utils.getValues(cenakupna, cenaSprzedazy);
        }
        catch (Exception ex) {
            System.out.println("Cos poszło nie tak");
        }


    }
}
