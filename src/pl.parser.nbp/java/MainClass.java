import java.util.Date;
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

        do {
            System.out.println("Wybierz walutę spośród możliwych ");
            var = scanner.nextInt();
            System.out.println("Podaj datę początkową");
            Date temp = new Date();
            System.out.println("Dzień: ");
            temp.se



        }
        while (var != 1 && var != 2 && var != 3 && var != 4);
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
