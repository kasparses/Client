package JsonClasses;

public class SaveNote implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "saveNote";
	private int superID;
	private String note;
	private String answer;
	
	
	
	//Getters and setters for everything, bitch
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public int getSuperID() {
		return superID;
	}
	public void setSuperID(int superID) {
		this.superID = superID;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
