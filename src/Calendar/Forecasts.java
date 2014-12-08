package Calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


/**
 * Creates the array Forecast and returns it
 * @author Mathias
 *
 */
public class Forecasts {
    ArrayList<Forecast> forecasts = new ArrayList<Forecast>();

    public ArrayList<Forecast> getForecast() {

    	
    	return forecasts;
    }
    
    
}