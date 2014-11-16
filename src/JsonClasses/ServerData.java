package JsonClasses;

public class ServerData implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "";
	
	//Getters and setters for everything, bitch
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
}
