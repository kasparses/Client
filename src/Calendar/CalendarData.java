package Calendar;

/**
 * The purpose of this class is to store the information of the Calendars that are sent from the database. 
 *
 */
public class CalendarData implements java.io.Serializable{
	private  final long serialVersionUID = 1L;
	private int CalendarID;
    private int type;
    private String Name;
    private int Active;
    private String CreatedBy;   
    private int PrivatePublic;
    // Constructor for this class, which enables other classes who make an object of this class to immediately initialise variables with the object.  
	public CalendarData( int CalendarID, int type, String name, int Active, String CreatedBy, int PrivatePublic ) {
		super();
		this.CalendarID = CalendarID;
		this.type = type;
		this.Name = name;
		this.Active = Active;
		this.CreatedBy = CreatedBy;
		this.PrivatePublic = PrivatePublic;
		
	}
	// getters and setters for the variables in this class. 
	public int getCalendarID() {
		return CalendarID;
	}
	
	public void setCalendarID(int calendarID) {
		CalendarID = calendarID;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public int getActive() {
		return Active;
	}
	
	public void setActive(int active) {
		Active = active;
	}
	
	public String getCreatedBy() {
		return CreatedBy;
	}
	
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public int getPrivatePublic() {
		return PrivatePublic;
	}

	public void setPrivatePublic(int privatePublic) {
		PrivatePublic = privatePublic;
	}
    
    

}