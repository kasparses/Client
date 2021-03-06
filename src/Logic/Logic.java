package Logic;
import Calendar.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import TCPClient.TCPClient;
import GUI.Screen;
import JsonClasses.CreateCalendar;
import JsonClasses.CreateEvent;
import JsonClasses.ForgotLogin;
import JsonClasses.Login;
import JsonClasses.LoginAnswer;
import JsonClasses.DeleteCalendar;
import JsonClasses.ServerData;
import JsonClasses.DailyUpdate;
import JsonClasses.Update;
import JsonClasses.GetCbsCalendar;

/**
 * The purpose of this class is to control what happens to the users input. 
 */
public class Logic {

	public static String Date1;
	public static String Celsius1;
	public static String Desc1;
	public static String Date2;
	public static String Celsius2;
	public static String Desc2;
	public static String Date3;
	public static String Celsius3;
	public static String Desc3;
	public static String Date4;
	public static String Celsius4;
	public static String Desc4;
	public static String Date5;
	public static String Celsius5;
	public static String Desc5;
	public static String Date6;
	public static String Celsius6;
	public static String Desc6;
	public static String Date7;
	public static String Celsius7;
	public static String Desc7;
	public static String Quote;
	public static String Author;
	public static String Topic;
	boolean active = false;

	/**
	 * Object of the class screen. 
	 */
	public static Screen screen;

	/**
	 * Object of the class TCPClient
	 */
	TCPClient tcp = new TCPClient();
	/**
	 * Object of GsonBuilder.
	 */
	Gson gson = new GsonBuilder().create();
	/**
	 * Object of the class Login
	 */
	Login L = new Login();
	/**
	 * Object of the class DeleteCalendar
	 */
	DeleteCalendar DC = new DeleteCalendar();
	/**
	 * Object of the class ServerData
	 */
	ServerData SD = new ServerData();
	/**
	 * Object of the class Update
	 */
	Update UD = new Update();
	/**
	 * Object of the class GetCbsCalendar
	 */
	GetCbsCalendar GCBS = new GetCbsCalendar();


	public Logic(){

		screen = new Screen();

		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getCreatecalendar().addActionListener(new CreateCalendarActionListener());
		screen.getDeleteCalendar().addActionListener(new DeleteCalendarActionListener());
		screen.getCreateEvent().addActionListener(new AddEventGUIActionListener());
		screen.getForgotLogin().addActionListener(new ForgotLoginActionListener());
		screen.getLogOut().addActionListener(new LogOutActionListener());



	}

	public void run() {

		screen.show(Screen.LOGIN);
		screen.setVisible(true);
	}


	/**
	 * The purpose of this class is to control the user input from the screen Login. 
	 */
	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getLogin().getBtnLogin()){ // If the user clicks on the button btnLogin.		
				try{

					//Initialises the inserted text from the user to variables
					String email = screen.getLogin().getTextField_Username().getText();
					String password = screen.getLogin().getTextField_Password().getText();

					//Sets the variables in the class Login. 
					L.setEmail(email);
					L.setPassword(password);

					//Sends the data from the Login class to the bla method from the TCPClient class and receives a JSON string. 	
					String JsonString=tcp.bla(L);

					//Converts the JSON string that is returned from the server into java variables in the LoginAnswer class. 
					LoginAnswer LA = gson.fromJson(JsonString, LoginAnswer.class);  

					// 
					if(LA.getActive().equals("active")){
						active = true;
					}
					if(LA.getActive().equals("inactive")){ //Show user an error message if the user is set to inactive. 
						JOptionPane.showMessageDialog(null, "Your account has been set inactive.\nPlease contact us via this email:\n"
								+ "help@cbs.dk"
								, "Error message",JOptionPane.PLAIN_MESSAGE);
						active = false;
					}
					if (LA.getAnswer().equals("correct") && active == true){ //If the user is active and user exists. 

						SD.setOverallID("DailyUpdate"); 
						String JsonString2 = tcp.bla(SD); // Send the data from the ServerData class to the server in order to run the DailyUpdate case in the giantSwitch. 
						DailyUpdate DU = gson.fromJson(JsonString2, DailyUpdate.class); //Converts the JSON string that is returned from the server into java variables in the DailyUpdate class. 

						//Variables to show the quote in the client (is called from the CalendarTest class)
						Quote = DU.getQotd();
						Author = DU.getAuthor();
						Topic = DU.getTopic();

						GCBS.setUserName(L.getEmail());
						String JsonString3 = tcp.bla(GCBS); // Send the data from the GetCbsCalendar class to the server in order to run the GetCbsCalendar case in the giantSwitch. 

						SD.setOverallID("getClientForecast");
						String JsonString4 = tcp.bla(SD); // Send the data from the ServerData class to the server in order to run the getClientForecast case in the giantSwitch. 


						JsonParser parser = new JsonParser();
						JsonArray jArray = parser.parse(JsonString4).getAsJsonArray();

						ArrayList<Forecast> lcs = new ArrayList<Forecast>();

						for(JsonElement obj : jArray )
						{
							Forecast cse = gson.fromJson( obj , Forecast.class);
							lcs.add(cse);

						}

						//Variables to show the quote in the client (is called from the CalendarTest class)
						Date1 = lcs.get(0).getDate();
						Celsius1 = lcs.get(0).getCelsius();
						Desc1 = lcs.get(0).getDesc();

						Date2 = lcs.get(1).getDate();
						Celsius2 = lcs.get(1).getCelsius();
						Desc2 = lcs.get(1).getDesc();

						Date3 = lcs.get(2).getDate();
						Celsius3 = lcs.get(2).getCelsius();
						Desc3 = lcs.get(2).getDesc();

						Date4 = lcs.get(3).getDate();
						Celsius4 = lcs.get(3).getCelsius();
						Desc4 = lcs.get(3).getDesc();

						Date5 = lcs.get(4).getDate();
						Celsius5 = lcs.get(4).getCelsius();
						Desc5 = lcs.get(4).getDesc();

						Date6 = lcs.get(5).getDate();
						Celsius6 = lcs.get(5).getCelsius();
						Desc6 = lcs.get(5).getDesc();

						Date7 = lcs.get(6).getDate();
						Celsius7 = lcs.get(6).getCelsius();
						Desc7 = lcs.get(6).getDesc();

						SD.setOverallID("getCalendar");

						String JsonString5 = tcp.bla(SD); // Send the data from the ServerData class to the server in order to run the getCalendar case in the giantSwitch. 

						Data d = new Data();
						screen.dispose(); // Disposes of the Login screen. 
						new CalendarTest().run(d.calculateNewDate(),JsonString3, JsonString5, L.getEmail()); //Starts the run method in the CalendarTest class to show the calendar. 

					}
					if(!LA.getAnswer().equals("correct")){ //Prints an error message if the user has entered incorrect login information. 
						JOptionPane.showMessageDialog(null, "\nPlease enter a valid username & password."
								, "Error message",JOptionPane.PLAIN_MESSAGE);
					}
				}	
				catch(Exception e3){
				}

			}	
			if (e.getSource() == screen.getLogin().getBtnForgotLogin()){ // If the user clicks on the button btnForgotLogin.	

				screen.show(Screen.FORGOT); //Shows the Forgot screen. 


			}
		}
	}

	/**
	 * The purpose of this class is to control the user input from the screen DeleteCalendar. 
	 */
	private class DeleteCalendarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getDeleteCalendar().getBtnDeletecalendar()){ // If the user clicks on the button btnDeletecalendar.	

				String calendarName = screen.getDeleteCalendar().getTxtCalendarname().getText();

				DC.setCalendarName(calendarName);
				DC.setUserName(L.getEmail());
				try {
					String JSonString = tcp.bla(DC);
					DeleteCalendar DCanswer = (DeleteCalendar)gson.fromJson(JSonString, DeleteCalendar.class);

					JOptionPane.showMessageDialog(null, DCanswer.getAnswer()
							, "Return message",JOptionPane.PLAIN_MESSAGE);
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

			if (e.getSource() == screen.getDeleteCalendar().getBtnLogOut()){ // If the user clicks on the button btnLogOut.	
				CalendarTest.getFrmMain().dispose();

				screen.show(Screen.LOGOUT);

			}
			if (e.getSource() == screen.getDeleteCalendar().getBtnMain()){ // If the user clicks on the button btnMain.	

				screen.dispose();

			}
		}
	}
	/**
	 * The purpose of this class is to control the user input from the screen CreateCalendar. 
	 */
	private class CreateCalendarActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getCreatecalendar().getBtnCreateCalendar()){ // If the user clicks on the button btnCreateCalendar.	

				CreateCalendar CC = new CreateCalendar();
				boolean empty = false;
				String name = screen.getCreatecalendar().getTxtName().getText();
				int type = 2; //2 betyder er det er en brugerskabt kalender og ikke den som er hentet fra CBS.
				int active = 1; // 1 betyder at den er aktiv. 2 betyder at den ikke er aktiv.

				if( name.equals("")) {

					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
					empty = true;
				}

				boolean PrivateOrPublic = false;
				int PrivateOrPublicValue = 0;


				if (screen.getCreatecalendar().getRdbtnPrivate().isSelected())
				{
					PrivateOrPublicValue = 2; //2 er lig med private.
					PrivateOrPublic = true;
				}
				if (screen.getCreatecalendar().getRdbtnPublic().isSelected())
				{
					PrivateOrPublicValue = 1; //1 er lig med public.
					PrivateOrPublic = true;
				}


				if( PrivateOrPublic == false){
					JOptionPane.showMessageDialog(null, "Please select whether your database is a public or a private database"
							, "Error message",JOptionPane.PLAIN_MESSAGE);

				}
				if (empty == false && PrivateOrPublic == true){
					CC.setCalendarName(name);
					CC.setPublicOrPrivate(PrivateOrPublicValue);
					CC.setType(type);
					CC.setActive(active);
					CC.setUserName(L.getEmail());

					try {
						String JsonString=tcp.bla(CC);
						CreateCalendar CCanswer = (CreateCalendar)gson.fromJson(JsonString, CreateCalendar.class);

						JOptionPane.showMessageDialog(null, CCanswer.getAnswer()
								, "Return message",JOptionPane.PLAIN_MESSAGE);
					} catch (UnknownHostException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}


				}

			}
			
			if (e.getSource() == screen.getCreatecalendar().getBtnLogOut()){ // If the user clicks on the button btnLogOut.	
				CalendarTest.getFrmMain().dispose();

				screen.show(Screen.LOGOUT);

			}
			if (e.getSource() == screen.getCreatecalendar().getBtnMain()){ // If the user clicks on the button Main.	
				System.out.println("calendar");
				screen.dispose();

			}
		}

	}
	/**
	 * The purpose of this class is to control the user input from the screen CreateEvent. 
	 */
	private class AddEventGUIActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {


			if (e.getSource() == screen.getCreateEvent().getBtnCreateEvent()){ // If the user clicks on the button btnCreateEvent.	

				boolean empty = false;
				boolean timeError = false;
				String description = screen.getCreateEvent().getTextField_Description().getText();

				String location = screen.getCreateEvent().getTextField_Location().getText();

				String title = screen.getCreateEvent().getTextField_Title().getText();
				String type = "1";
				String EventID = "1";
				String activityID = "1";

				String calendarName =  screen.getCreateEvent().getTextField_CalendarName().getText();
				String note = screen.getCreateEvent().getTextField_Text().getText();

				Object startYear = screen.getCreateEvent().getComboBox_StartYear().getSelectedItem();
				Object startMonth = screen.getCreateEvent().getComboBox_StartMonth().getSelectedItem();
				Object startDay = screen.getCreateEvent().getComboBox_StartDay().getSelectedItem();
				Object startHour = screen.getCreateEvent().getComboBox_StartHour().getSelectedItem();
				Object startMinutes = screen.getCreateEvent().getComboBox_StartMinutes().getSelectedItem();


				Object endYear = screen.getCreateEvent().getComboBox_EndYear().getSelectedItem();
				Object endMonth = screen.getCreateEvent().getComboBox_EndMonth().getSelectedItem();
				Object endDay = screen.getCreateEvent().getComboBox_EndDay().getSelectedItem();
				Object endHour = screen.getCreateEvent().getComboBox_EndHour().getSelectedItem();
				Object endMinutes = screen.getCreateEvent().getComboBox_EndMinutes().getSelectedItem();


				String endHourString = endHour.toString();
				String endMinutesString = endMinutes.toString();
				String endDayString = endDay.toString();
				String endMonthString = endMonth.toString();
				String endYearString = endYear.toString();

				String startHourString = startHour.toString();
				String startMinutesString = startMinutes.toString();
				String startDayString = startDay.toString();
				String startMonthString = startMonth.toString();
				String startYearString = startYear.toString();

				int endHourInt = Integer.parseInt(endHourString);
				int endMinutesInt = Integer.parseInt(endMinutesString);
				int endDayInt = Integer.parseInt(endDayString);
				int endMonthInt = Integer.parseInt(endMonthString);
				int endYearInt = Integer.parseInt(endYearString);

				int startHourInt = Integer.parseInt(startHourString);
				int startMinutesInt = Integer.parseInt(startMinutesString);
				int startDayInt = Integer.parseInt(startDayString);
				int startMonthInt = Integer.parseInt(startMonthString);
				int startYearInt = Integer.parseInt(startYearString);


				if(startHourInt> endHourInt){
					timeError = true;
				}
				if (startHourInt == endHourInt && startMinutesInt> endMinutesInt){
					timeError = true;
				}
				if (startDayInt > endDayInt){
					timeError = true;
				}
				if (startMonthInt > endMonthInt){
					timeError = true;
				}
				if(startYearInt> endYearInt){
					timeError = true;
				}
				
				if (timeError == true){
					JOptionPane.showMessageDialog(null, "\nYou cannot create an event that ends before it starts. "
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}

				if(startMinutes.equals("0")){
					startMinutes = "00";
				}

				if(endMinutes.equals("0")){
					endMinutes = "00";
				}

				String start = startYear.toString()+ "-"+ startMonth.toString()+ "-"+ startDay.toString()+ " "+startHour.toString()+":"+startMinutes+":00";
				String end = endYear.toString()+ "-"+ endMonth.toString()+ "-"+ endDay.toString()+ " "+endHour.toString()+":"+endMinutes+":00";


				if (title.equals("")||location.equals("")|| calendarName.equals("")|| description.equals(""))
				{
					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
					empty = true;
				}



				if (empty == false && timeError == false ){
					CreateEvent CE = new CreateEvent("createEvent", 0,activityID,EventID , type, title, description, start, end, location,  calendarName ,note);

					try {
						String CreateEvent = tcp.bla(CE);
						CreateEvent CEanswer = (CreateEvent)gson.fromJson(CreateEvent, CreateEvent.class);

						JOptionPane.showMessageDialog(null, CEanswer.getAnswer()
								, "Return message",JOptionPane.PLAIN_MESSAGE);

					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			
			if (e.getSource() == screen.getCreateEvent().getBtnMain()){ // If the user clicks on the button btnMain.	
				screen.dispose();
			}
			if (e.getSource() == screen.getCreateEvent().getBtnLogout()){ // If the user clicks on the button btnLogOut.	
				CalendarTest.getFrmMain().dispose();

				screen.show(Screen.LOGOUT);
			}

		}
	}

	/**
	 * The purpose of this class is to control the user input from the screen ForgotLogin. 
	 */
	private class ForgotLoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getForgotLogin().getBtnGetLogin()){

				String cPR = screen.getForgotLogin().getTextField_CPR().getText();
				String Forgot ="";
				ForgotLogin FL = new ForgotLogin();

				FL.setCPR(cPR);

				try {
					Forgot = tcp.bla(FL);
				} catch (IOException | SQLException e1) {
					e1.printStackTrace();
				}

				FL = gson.fromJson(Forgot, ForgotLogin.class);


				if (FL.getAnswer().equals("correct")){
					JOptionPane.showMessageDialog(null, "\nYour username is: "+FL.getEmail()+"\nYour password is: "+FL.getPassword()
							, "Message",JOptionPane.PLAIN_MESSAGE);
				}
				else if(!FL.getAnswer().equals("correct")){
					JOptionPane.showMessageDialog(null, "\nPlease enter a valid security number."
							, "Error",JOptionPane.PLAIN_MESSAGE);
				}
				if (cPR.equals("")){
					JOptionPane.showMessageDialog(null, "\nPlease fill out the field."
							, "Error",JOptionPane.PLAIN_MESSAGE);
				}

			}
			if (e.getSource() == screen.getForgotLogin().getBtnLogin()){

				screen.show(Screen.LOGIN);

			}

		}
	}
	/**
	 * The purpose of this class is to control the user input from the screen LogOut. 
	 */
	private class LogOutActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getLogOut().getBtnLogIn()){

				screen.show(Screen.LOGIN);

			}

		}
	}

	public Screen getScreen() {
		return screen;
	}



}
