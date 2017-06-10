/**
 * Created by Piotr on 2017-06-10.
 */
public class Utils {
    private final static String url = "http://api.nbp.pl/api/exchangerates/rates/c/";

    public static String getCurrencyValuesFromNBP(String currency, String startDateYear, String startDateMonth , String startDateDay, String endDateYear, String endDateMonth, String endDateDay) {

        System.out.println(url +currency+ "/" + startDateYear + "-" + startDateMonth + "-" + startDateDay + "/" + endDateYear+ "-" + endDateMonth + "-" + endDateDay + "/");
        return url +currency+ "/" + startDateYear + "-" + startDateMonth + "-" + startDateDay + "/" + endDateYear+ "-" + endDateMonth + "-" + endDateDay + "/";

    }
}
