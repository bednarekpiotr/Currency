import java.util.Date;

/**
 * Created by Piotr on 2017-06-09.
 */
public class DataFromUser {


    private String currency;
    private Date startDate;
    private Date endDate;


    public DataFromUser() {
    }

    public Date getStartDate() {

        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }





    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
