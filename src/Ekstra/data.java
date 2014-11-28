package Ekstra;

import java.util.GregorianCalendar;


public class data {
	
	
	GregorianCalendar cal = new GregorianCalendar(); //Create calendar
    private int dayofWeek = cal.get(GregorianCalendar.DAY_OF_WEEK_IN_MONTH);
    private int weekofYear = cal.get(GregorianCalendar.WEEK_OF_YEAR);
    private int realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
    private int realMonth = cal.get(GregorianCalendar.MONTH); //Get month
    private int realYear = cal.get(GregorianCalendar.YEAR); //Get year
    private int currentMonth = realMonth; //Match month and year
    private int currentYear = realYear;
    private String QOTD;
    private String Author;
    private String Topic;
    

    
    		long newDate;
    String JsonString = "";
    String [] headers = new String[7];


    public long calculateNewDate(){
    	cal.set(GregorianCalendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
    	long newDate =  cal.getTimeInMillis();
    	return newDate;
    }
    
    
    
	public String getQOTD() {
		return QOTD;
	}



	public void setQOTD(String qOTD) {
		QOTD = qOTD;
	}



	public String getAuthor() {
		return Author;
	}



	public void setAuthor(String author) {
		Author = author;
	}



	public String getTopic() {
		return Topic;
	}



	public void setTopic(String topic) {
		Topic = topic;
	}



	public String[] getHeaders() {
		return headers;
	}



	public void setHeaders(String[] headers) {
		this.headers = headers;
	}



	public String getJsonString() {
		return JsonString;
	}


	public void setJsonString(String jsonString) {
		JsonString = jsonString;
	}


	public long getNewDate() {
		return newDate;
	}

	public void setNewDate(long newDate) {
		this.newDate = newDate;
	}

	public int getRealYear() {
		return realYear;
	}

	public void setRealYear(int realYear) {
		this.realYear = realYear;
	}

	public int getRealMonth() {
		return realMonth;
	}

	public void setRealMonth(int realMonth) {
		this.realMonth = realMonth;
	}

	public int getRealDay() {
		return realDay;
	}

	public void setRealDay(int realDay) {
		this.realDay = realDay;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}

	public int getDayofWeek() {
		return dayofWeek;
	}

	public void setDayofWeek(int dayofWeek) {
		this.dayofWeek = dayofWeek;
	}

	public int getWeekofYear() {
		return weekofYear;
	}

	public void setWeekofYear(int weekofYear) {
		this.weekofYear = weekofYear;
	}
	
	

}

