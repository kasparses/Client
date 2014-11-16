package JsonClasses;

public class UpdateLoginTime implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "LoginTime";
	private long LoginTime = 0;
	private String userName = "";
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
