package Calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


/**
 * This class establishes the array of all generated events
 * @author Mathias
 *
 */
public class Events {
    ArrayList<Event> events = new ArrayList<Event>();

    public ArrayList<Event> getEvents() {

    	
    	return events;
    }

    public void setEvents(ArrayList<Event> event) {
        this.events = event;
    }
    
    
    // Converts the array events to a text String
    @Override
    public String toString() {
        return Arrays.toString(events.toArray());
    }
}