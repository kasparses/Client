package Logic;
import Ekstra.CalendarTest;
import Ekstra.data;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import TCPClient.TCPClient;
import GUI.Screen;
import JsonClasses.CreateCalender;
import JsonClasses.CreateEvent;
import JsonClasses.Login;
import JsonClasses.LoginAnswer;
import JsonClasses.DeleteCalendar;
import JsonClasses.ServerData;
import JsonClasses.DailyUpdate;
import JsonClasses.Update;
import JsonClasses.GetCbsCalendar;
import Ekstra.*;

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
	
	private Screen screen;
	TCPClient tcp = new TCPClient();
	Gson gson = new GsonBuilder().create();
	Login L = new Login();
	DeleteCalendar DC = new DeleteCalendar();
	ServerData SD = new ServerData();
	Update UD = new Update();
	GetCbsCalendar GCBS = new GetCbsCalendar();

	public Logic(){
		screen = new Screen();

		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener());
		screen.getCreatecalendar().addActionListener(new CreateCalendarActionListener());
		screen.getDelteCalendar().addActionListener(new DelteCalendarActionListener());
		//		screen.getNoteList().addActionListener(new NoteListActionListener());
		////		screen.getUserList().addActionListener(new UserListActionListener());
		//		screen.getEventlist().addActionListener(new EventListActionListener());
		screen.getCreateEvent().addActionListener(new AddEventGUIActionListener());
		//		screen.getAddUser().addActionListener(new AddUserActionListener());



	}
	public void run() {

		screen.show(Screen.LOGIN);
		screen.setVisible(true);
	}

	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try{
				Date date = new Date();
				long date1 = date.getTime();


				String email = screen.getLogin().getUsernameTextField().getText();
				String password = screen.getLogin().getPasswordTextField_1().getText();

				L.setEmail(email);
				L.setPassword(password);

				String JsonString=tcp.bla(L);

				LoginAnswer LA = gson.fromJson(JsonString, LoginAnswer.class);  

				if (LA.getAnswer().equals("correct")){

					SD.setOverallID("DailyUpdate");
					String JsonString2 = tcp.bla(SD);
					DailyUpdate DU = gson.fromJson(JsonString2, DailyUpdate.class);
					
					//variabler til visning af quote i clienten (hentes af CalendarTest)
					Quote = DU.getQotd();
					Author = DU.getAuthor();
					Topic = DU.getTopic();


					GCBS.setUserName(L.getEmail());
					String JsonString3 = tcp.bla(GCBS);

					SD.setOverallID("getClientForecast");
					String JsonString4 = tcp.bla(SD);


					JsonParser parser = new JsonParser();
					JsonArray jArray = parser.parse(JsonString4).getAsJsonArray();

					ArrayList<Forecast> lcs = new ArrayList<Forecast>();

					for(JsonElement obj : jArray )
					{
						Forecast cse = gson.fromJson( obj , Forecast.class);
						lcs.add(cse);

					}
					
					//Variabler til visning af vejr i clienten (hentes af ClendarTest)
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


					data d = new data();  
					new CalendarTest().run(d.calculateNewDate(),JsonString3);

					//					screen.getMainMenu().setText("Hello " + name);

					screen.show(Screen.MAINMENU);
				}
				if(!LA.getAnswer().equals("correct")){
					JOptionPane.showMessageDialog(null, "\nPlease enter a valid username & password."
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
			}	
			catch(Exception e3){
			}
		}	
	}

	private class MainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getMainMenu().getBtnCreateevent()){

			}
			if (e.getSource() == screen.getMainMenu().getBtnCreateNewCalendar()){
				screen.show(Screen.CREATECALENDAR);
			}
			if (e.getSource() == screen.getMainMenu().getBtnDeleteCalendar()){
				screen.show(Screen.DELTECALENDAR);
			}
			if (e.getSource() == screen.getMainMenu().getBtnDeletenote()){

			}
			if (e.getSource() == screen.getMainMenu().getBtnGetForecast()){

			}
			if (e.getSource() == screen.getMainMenu().getBtnGetQuoteoftheday()){


			}
			if (e.getSource() == screen.getMainMenu().getBtnSavenote()){

			}
			if (e.getSource() == screen.getMainMenu().getBtnCreateevent()){
				screen.show(Screen.CREATEEVENT);
			}


		}
	}
	private class DelteCalendarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getDelteCalendar().getBtnDeletecalendar()){
				String calendarName = screen.getDelteCalendar().getTxtCalendarname().getText();
				DC.setCalendarName(calendarName);
				DC.setUserName(L.getEmail());
				try {
					String JSonString = tcp.bla(DC);


					JOptionPane.showMessageDialog(null, JSonString
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
	}
	private class CreateCalendarActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getCreatecalendar().getBtnCreateCalendar()){

				CreateCalender CC = new CreateCalender();
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
					CC.setCalenderName(name);
					CC.setPublicOrPrivate(PrivateOrPublicValue);
					CC.setType(type);
					CC.setActive(active);
					CC.setUserName(L.getEmail());

					try {
						String JsonString=tcp.bla(CC);
						JOptionPane.showMessageDialog(null, JsonString
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
		}

	}

	private class AddEventGUIActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {


			if (e.getSource() == screen.getCreateEvent().getBtnSubmit()){



				String description = screen.getCreateEvent().getTextField_Description().getText();
				String start = screen.getCreateEvent().getTextField_Start().getText();
				String location = screen.getCreateEvent().getTextField_Location().getText();
				String end = screen.getCreateEvent().getTextField_End().getText();
				String title = screen.getCreateEvent().getTextField_Title().getText();
				String type = screen.getCreateEvent().getTextField_Type().getText();
				String eventID = screen.getCreateEvent().getTextField_EventID().getText();
				String activityID = screen.getCreateEvent().getTextField_ActivityID().getText();
				String calendarName = screen.getCreateEvent().getTextField_CalendarName().getText();

				CreateEvent CE = new CreateEvent("createEvent", 0,activityID , eventID, type, title, description, start, end, location, calendarName );



				try {
					try {
						String JsonString5=tcp.bla(CE);
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}


				//
				////				if (Location.equals("")|| Createdby.equals("")|| start.equals("")|| end.equals("")|| name.equals("")|| text.equals(""))
				////				{
				////					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
				////							, "Error message",JOptionPane.PLAIN_MESSAGE);
				////				}
				////				else
				////				{


			}


		}
	}

}



