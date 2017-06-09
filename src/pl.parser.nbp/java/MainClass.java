import java.util.Scanner;

/**
 * Created by Piotr on 2017-06-09.
 */
public class MainClass {


    public static void main(String[] args) {
        DataFromUser dfu = new DataFromUser();
        System.out.println("Witaj");

        System.out.println("1) USD");
        System.out.println("2) EUR");
        System.out.println("3) CHF");
        System.out.println("4) GBP");
        Scanner scanner = new Scanner(System.in);
        int var;

       // do {
            System.out.println("Wybierz walutę spośród możliwych ");
            var = scanner.nextInt();
            System.out.println("Podaj datę początkową");
            System.out.println("Dzień: ");
            dfu.setStartDateDay(scanner.nextInt());
            System.out.println("Miesiąc: ");
            dfu.setStartDateMonth(scanner.nextInt());
            System.out.println("Rok: ");
            dfu.setStartDateYear(scanner.nextInt());
            System.out.println("Podaj datę końcową ");
            System.out.println("Dzień: ");
            dfu.setEndDateDay(scanner.nextInt());
            System.out.println("Miesiąc: ");
            dfu.setEndDateMonth(scanner.nextInt());
            System.out.println("Rok: ");
            dfu.setEndDateYear(scanner.nextInt());
        //}brak walidacji danych
       // while (true); //(var == 1 || var == 2 || var == 3 || var == 4) && day <= 31 && day >= 1 && endDay <= 31 && endDay >=1 );

        switch (var) {
            case (1): {
                System.out.println("Wybrano USD");
                break;
            }
            case (2): {
                System.out.println("Wybrano EUR");
                break;
            }
            case (3): {
                System.out.println("Wybrano CHF");
                break;
            }
            case (4): {
                System.out.println("Wybrano GBP");
                break;
            }
            default: {
                System.out.println("Wybierz raz jeszcze ");
                break;
            }
        }

    }
}
