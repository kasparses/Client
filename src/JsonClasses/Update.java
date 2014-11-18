package JsonClasses;

public class Update implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "DailyUpdate";
	private long LoginTime = 0;
	
	//Getters and setters for everything, bitch
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public long getLoginTime() {
		return LoginTime;
	}
	public void setLoginTime(long loginTime) {
		LoginTime = loginTime;
	}
	
	
}
