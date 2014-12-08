package Calendar;

/**
 * Constructor to ForecastModel Arraylist
 * @author Mathias
 *
 */
public class Forecast {

    private String date;
    private String celsius;
    private String desc;

    // Function that sets the date, celsius and description to the Forecast object
    public Forecast(String date, String celsius, String desc) {
        this.date = date;
        this.celsius = celsius;
        this.desc = desc;
    }
    
    // Setters og getters for the Forecast class
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCelsius() {
        return celsius;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    // Returns the weather as a Json text String
    public String toString() {
        return "Forecast{" +
                "date='" + date + '\'' +
                ", celsius='" + celsius + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
