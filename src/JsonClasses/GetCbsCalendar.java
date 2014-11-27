package JsonClasses;

public class GetCbsCalendar implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "GetCbsCalendar";
	private String userName = "";

	
	
	//Getters and setters for everything, bitch
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
