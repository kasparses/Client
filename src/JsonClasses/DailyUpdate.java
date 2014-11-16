package JsonClasses;

public class DailyUpdate implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "dailyUpdate";
	private String date = "";
	private String apparentTemperature = "";
	private String summary = "";
	private String qotd = "";
	private String author = "";
	private String topic = "";
	private String msg_type = "";
	private String update_timestamp = "";
	
	//Getters and setters for everything, bitch
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getApparentTemperature() {
		return apparentTemperature;
	}
	public void setApparentTemperature(String apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getQotd() {
		return qotd;
	}
	public void setQotd(String qotd) {
		this.qotd = qotd;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
	public String getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(String update_timestamp) {
		this.update_timestamp = update_timestamp;
	}

	

}
