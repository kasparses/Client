package Logic;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import TCPClient.TCPClient;
import sun.applet.Main;
import GUI.Screen;
import JsonClasses.CreateCalender;
import JsonClasses.Login;
import JsonClasses.LoginAnswer;
import JsonClasses.DeleteCalendar;
import JsonClasses.ServerData;
import JsonClasses.DailyUpdate;

public class Logic {
	private Screen screen;
	TCPClient tcp = new TCPClient();
	Gson gson = new GsonBuilder().create();
	Login L = new Login();
	DeleteCalendar DC = new DeleteCalendar();
	ServerData SD = new ServerData();
	
	

	public Logic(){
		screen = new Screen();


		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener());
		screen.getCreatecalendar().addActionListener(new CreateCalendarActionListener());
		screen.getDelteCalendar().addActionListener(new DelteCalendarActionListener());
		//		screen.getNoteList().addActionListener(new NoteListActionListener());
		////		screen.getUserList().addActionListener(new UserListActionListener());
		//		screen.getEventlist().addActionListener(new EventListActionListener());
		//		screen.getAddEventGUI().addActionListener(new AddEventGUIActionListener());
		//		screen.getAddUser().addActionListener(new AddUserActionListener());



	}
	public void run() {

		screen.show(Screen.LOGIN);
		screen.setVisible(true);
	}

	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try{

				String email = screen.getLogin().getUsernameTextField().getText();
				String password = screen.getLogin().getPasswordTextField_1().getText();
				
				L.setEmail(email);
				L.setPassword(password);

				String JsonString=tcp.bla(L);

				LoginAnswer LA = gson.fromJson(JsonString, LoginAnswer.class);  

				if (LA.getAnswer().equals("correct")){
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
				
				SD.setOverallID("getQuote");
				try {
					String JsonString = tcp.bla(SD);
					DailyUpdate DU = gson.fromJson(JsonString, DailyUpdate.class); 
				
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (e.getSource() == screen.getMainMenu().getBtnSavenote()){

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

}



