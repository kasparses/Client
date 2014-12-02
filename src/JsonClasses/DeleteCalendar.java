package JsonClasses;

public class DeleteCalendar implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "deleteCalendar";
	private String calendarName = "";
	private String userName = "";
	private int Active = 1;
	private String answer = "";
	private boolean active;

	//Getters and setters for everything

	public String getOverallID() {
		return overallID;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}

	public String getCalendarName() {
		return calendarName;
	}
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getActive() {
		return Active;
	}
	public void setActive(int active) {
		Active = active;
	}


}
