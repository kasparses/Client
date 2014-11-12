package JsonClasses;

public class LoginAnswer implements java.io.Serializable
{
	private String answer = "";
	private String userAdmin = "";
	private String active = "";
	
	//Getters and setters for everything, bitch
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getUserAdmin() {
		return userAdmin;
	}
	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	

}
