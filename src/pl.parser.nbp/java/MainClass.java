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

       // do {
            System.out.println("Wybierz walutę spośród możliwych ");
            var = scanner.nextInt();
            System.out.println("Podaj datę początkową");
            System.out.println("Dzień: ");
            dfu.setStartDateDay(scanner.next());
            System.out.println("Miesiąc: ");
            dfu.setStartDateMonth(scanner.next());
            System.out.println("Rok: ");
            dfu.setStartDateYear(scanner.next());
            System.out.println("Podaj datę końcową ");
            System.out.println("Dzień: ");
            dfu.setEndDateDay(scanner.next());
            System.out.println("Miesiąc: ");
            dfu.setEndDateMonth(scanner.next());
            System.out.println("Rok: ");
            dfu.setEndDateYear(scanner.next());
        //}brak walidacji danych
       // while (true); //(var == 1 || var == 2 || var == 3 || var == 4) && day <= 31 && day >= 1 && endDay <= 31 && endDay >=1 );

        switch (var) {
            case (1): {
                System.out.println("Wybrano USD");
                currency="USD";
                break;
            }
            case (2): {
                System.out.println("Wybrano EUR");
                currency="EUR";
                break;
            }
            case (3): {
                System.out.println("Wybrano CHF");
                currency="CHF";
                break;
            }
            case (4): {
                System.out.println("Wybrano GBP");
                currency="GBP";
                break;
            }
            default: {
                System.out.println("Wybierz raz jeszcze ");
                break;
            }
        }

        URL url = Utils.getUrl(currency,dfu.getStartDateYear(),dfu.getStartDateMonth(),dfu.getStartDateDay(),dfu.getEndDateYear(),dfu.getEndDateMonth(),dfu.getEndDateDay());
        InputStream is = Utils.getInpusStream(url);
        Document doc = Utils.parseDocument(is);
        NodeList cenakupna = Utils.getNodetList(doc , "Bid");
        NodeList cenaSprzedazy = Utils.getNodetList(doc, "Ask");
        Utils.getValues(cenakupna,cenaSprzedazy);


    }
}
