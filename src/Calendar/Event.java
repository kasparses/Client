package Calendar;

import java.util.ArrayList;

/**
 * Created by jesperbruun on 10/10/14.
 * Til hver specifik event bliver de defineret saaledes. Every single specific event gets defined as follows
 */
public class Event implements java.io.Serializable{
	private  final long serialVersionUID = 1L;
	private int ID;
    private String activityid;
    private String eventid;
    private String type;
    private String title;
    private String description;
    private ArrayList<String> start;
    private ArrayList<String> end;
    private String location;
    private String note;

    // Setters og getters for the Event object
    public void setActivityid(String activityid){
        this.activityid = activityid;
    }
    public String getActivityid(){
        return activityid;
    }

    public void setEventid(String eventid){
        this.eventid = eventid;
    }
    public String getEventid(){
        return eventid;
    }

    public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }
    
    public void setStart(ArrayList<String> start){
        this.start = start;
    }
    public ArrayList<String> getStart(){
        return start;
    }

    public void setEnd(ArrayList<String> end){
        this.end = end;
    }
    public ArrayList<String> getEnd(){
        return end;
    }
    
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Event( int ID, String activityid, String eventid, String type, String title,
			String description, ArrayList<String> start,
			ArrayList<String> end, String location, String note) {
		super();
		this.ID = ID;
		this.activityid = activityid;
		this.eventid = eventid;
		this.type = type;
		this.title = title;
		this.description = description;
		this.start = start;
		this.end = end;
		this.location = location;
		this.note =note;
	}
    
    

}