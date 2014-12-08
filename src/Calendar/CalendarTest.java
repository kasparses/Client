package Calendar;

import Calendar.BorderCellRenderer;
import Calendar.CellBorder;
import Calendar.LinesBorder;
import GUI.Screen;
import TCPClient.TCPClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.awt.*;  
import JsonClasses.Login;
import JsonClasses.SaveNote;
import Logic.Logic;
import javax.swing.*;  
import javax.swing.table.*;  
import java.awt.event.*;
import javax.swing.border.*;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * This class controls the graphical functions of the main calendar window and the logical functions of inserting
 * events into the calendar. 
 */
public class CalendarTest{

	static JLabel lblMonth;
	static JButton btnPrev, btnNext;
	JTable tblCalendar;
	static JFrame frmMain;
	static Container pane;
	DefaultTableModel mtblCalendar; //Table model
	static JScrollPane stblCalendar; //The scrollpane
	static JPanel pnlCalendar;
	private static JLabel lblMonday;
	private static JLabel lblTuesday;
	private static JLabel lblWenseday;
	private static JLabel lblThuesday;
	private static JLabel lblFriday;
	private static JLabel lblSaturday;
	private static JLabel lblSunday;
	private static JLabel label;
	private static JLabel label_1;
	private static JLabel label_2;
	private static JLabel label_3;
	private static JLabel label_4;
	private static JLabel label_5;
	private static JLabel label_6;
	private static JLabel label_7;
	private static JLabel label_8;
	private static JLabel label_9;
	private static JLabel label_10;
	private static JLabel label_11;
	private static JLabel label_12;
	private static JLabel label_13;
	private static JLabel lblQuote;
	private static JLabel lblAuthor;
	private static JLabel lblTopic;
	private static JLabel lblDesc1;
	private static JLabel lblPicture1;
	private static JLabel lblCelsius1;
	private static JLabel lblDate1;
	private static JLabel lblDesc2;
	private static JLabel lblPicture2;
	private static JLabel lblCelsius2;
	private static JLabel lblDate2;
	private static JLabel lblDesc3;
	private static JLabel lblPicture3;
	private static JLabel lblCelsius3;
	private static JLabel lblDate3;
	private static JLabel lblDesc4;
	private static JLabel lblPicture4;
	private static JLabel lblCelsius4;
	private static JLabel lblDate4;
	private static JLabel lblDesc5;
	private static JLabel lblPicture5;
	private static JLabel lblCelsius5;
	private static JLabel lblDate5;
	private static JLabel lblDesc6;
	private static JLabel lblPicture6;
	private static JLabel lblCelsius6;
	private static JLabel lblDate6;
	private static JLabel lblDesc7;
	private static JLabel lblPicture7;
	private static JLabel lblCelsius7;
	private static JLabel lblDate7;
	private static JLabel label_14;

	/**
	 * Creates an object of the class data.
	 */
	Data d = new Data(); 
	/**
	 * Creates an Array which is to contain the header values of the JTable. 
	 */
	static String [] headers = new String[7]; 
	/**
	 * Creates an multidimensional Array which is to contain the row and column count of where events are inserted into the calendar
	 * so that it is possible to point at a specific event by selecting a cell in the JTable.
	 */
	int notes [][] = new int [20][7];


	/**
	 *  Creates an ArrayList of the class ColumnRow which is to save where events are inserted into the calendar together with the description of the events so that it is possible to select these events from the BorderCellRenderer class which is to colour the events.
	 */
	public static ArrayList<ColumnRow> columnRows = new ArrayList<ColumnRow>();  

	/**
	 * Creates an ArrayList of the class Event which is to contain all the events that are sent from the server to the client. 
	 */
	ArrayList<Event> lcs = new ArrayList<Event>();
	/**
	 * Creates an ArrayList of the class CalendarData which is to contain the information of the calendars that are sent from the database.
	 */
	ArrayList<CalendarData> lcs2 = new ArrayList<CalendarData>();
	/**
	 * Creates a boolean variable that is to prevent the ArrayList lcs from adding events each time the Jframe is run.
	 */
	boolean updatedlcs = false;
	/**
	 * Creates a boolean variable that is to prevent the ArrayList lcs2 from adding events each time the Jframe is run.
	 */
	boolean updatedlcs2 = false; 
	private int comboBoxSize;
	Gson gson = new GsonBuilder().create(); // Creates an object of the GsonBuilder
	TCPClient tcp = new TCPClient(); // Creates an object of the TCPClient which enables this class to send information directly to the server. 
	SaveNote SN = new SaveNote(); // Creates an object of the class SaveNote which enables this class to call this class.
	Login L = new Login(); // Creates an object of the class SaveNote which enables this class to call this class.

	// Buttons and labels
	private JButton btnGetNote;
	private JButton btnAddNote;
	private JTextField txtNotetext;
	private JLabel lblSelectCalendar;
	private JComboBox comboBox_Calendar;
	private JButton btnLoadSelectedCalendar;
	private JLabel label_background;
	private JButton btnCreateCalendar;
	private JButton btnDeleteCalendar;
	private JButton btnCreateEvent;
	private JButton btnLogOut;


	/**
	 * This method Creates a new frame and adds the buttons, Labels and headers. 
	 * @param newDate, a long variable with the value of the first day of the selected week in milliseconds. 
	 * @param JsonString3, a JSON string containing the events sent from the database. 
	 * @param JsonString5, a JSON string containing the information of the calendars sent from the database. 
	 * @param userName, a String of the username of the user who is currently logged in. 
	 * @wbp.parser.entryPoint
	 */
	public void run (long newDate, String JsonString3, String JsonString5, String userName){


		// sets the variable in the class data. 
		d.setUserName(userName);
		d.setJsonString(JsonString3);
		d.setNewDate(newDate);
		d.setJsonString5(JsonString5);

		//Look and feel
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}


		//Prepare frame
		frmMain = new JFrame ("DØK Calendar"); //Create frame
		frmMain.setTitle("D\u00D8K Calendar");
		frmMain.setSize(1366, 768); //Set size to 1366x768 pixels
		pane = frmMain.getContentPane(); //Get content pane
		pane.setLayout(null); //Apply null layout
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar);
		pnlCalendar = new JPanel(null);

		//Set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));

		//Add controls to pane
		pane.add(pnlCalendar);

		//Create controls
		lblMonth = new JLabel ("January");
		pnlCalendar.add(lblMonth);
		lblMonth.setBounds(590, 25, 405, 25);
		btnNext = new JButton ("Next");
		btnNext.setContentAreaFilled(false);
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNext.addActionListener(new btnNext_Action());
		btnPrev = new JButton ("Prev");
		btnPrev.setContentAreaFilled(false);
		btnPrev.setForeground(Color.WHITE);
		btnPrev.setFont(new Font("Tahoma", Font.BOLD, 20));

		//Register action listeners
		btnPrev.addActionListener(new btnPrev_Action());
		pnlCalendar.add(btnPrev);
		btnPrev.setBounds(349, 25, 94, 25);
		pnlCalendar.add(btnNext);
		btnNext.setBounds(917, 25, 94, 25);
		pnlCalendar.add(stblCalendar);

		//Set bounds
		pnlCalendar.setBounds(0, 0, 1360, 739);
		stblCalendar.setBounds(349, 91, 662, 377);

		//Make frame visible
		frmMain.setResizable(false);
		frmMain.setVisible(true);


		SimpleDateFormat date_format = new SimpleDateFormat("dd-M-yyyy"); // Example: 17-Now-14

		// This for loop inserts the date of the days of the week into the tables header. 
		for (int a=0; a<7; a++){
			Date currentDate = new Date(newDate);

			String ugeDag = date_format.format(currentDate);
			headers[a] = ugeDag;
			newDate +=86400000;

			mtblCalendar.addColumn(headers[a]);
		}



		tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background

		//No resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);

		tblCalendar.setCellSelectionEnabled(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		//Set row height. 
		tblCalendar.setRowHeight(23);

		// Creates labels for the weeks days and times. 
		lblMonday = new JLabel("Monday");
		lblMonday.setBounds(379, 66, 38, 14);
		pnlCalendar.add(lblMonday);

		lblTuesday = new JLabel("Tuesday");
		lblTuesday.setBounds(472, 66, 41, 14);
		pnlCalendar.add(lblTuesday);

		lblWenseday = new JLabel("Wednseday");
		lblWenseday.setBounds(557, 66, 57, 14);
		pnlCalendar.add(lblWenseday);

		lblThuesday = new JLabel("Thursday");
		lblThuesday.setBounds(659, 66, 45, 14);
		pnlCalendar.add(lblThuesday);

		lblFriday = new JLabel("Friday");
		lblFriday.setBounds(759, 66, 30, 14);
		pnlCalendar.add(lblFriday);

		lblSaturday = new JLabel("Saturday");
		lblSaturday.setBounds(848, 66, 44, 14);
		pnlCalendar.add(lblSaturday);

		lblSunday = new JLabel("Sunday");
		lblSunday.setBounds(942, 66, 36, 14);
		pnlCalendar.add(lblSunday);

		label = new JLabel("8:00");
		label.setBounds(317, 110, 28, 14);
		pnlCalendar.add(label);

		label_1 = new JLabel("9:00");
		label_1.setBounds(317, 133, 28, 14);
		pnlCalendar.add(label_1);

		label_2 = new JLabel("10:00");
		label_2.setBounds(311, 156, 28, 14);
		pnlCalendar.add(label_2);

		label_3 = new JLabel("11:00");
		label_3.setBounds(311, 179, 28, 14);
		pnlCalendar.add(label_3);

		label_4 = new JLabel("12:00");
		label_4.setBounds(311, 202, 28, 14);
		pnlCalendar.add(label_4);

		label_5 = new JLabel("13:00");
		label_5.setBounds(311, 225, 28, 14);
		pnlCalendar.add(label_5);

		label_6 = new JLabel("14:00");
		label_6.setBounds(311, 248, 28, 14);
		pnlCalendar.add(label_6);

		label_7 = new JLabel("15:00");
		label_7.setBounds(311, 271, 28, 14);
		pnlCalendar.add(label_7);

		label_8 = new JLabel("16:00");
		label_8.setBounds(311, 294, 28, 14);
		pnlCalendar.add(label_8);

		label_9 = new JLabel("17:00");
		label_9.setBounds(311, 317, 28, 14);
		pnlCalendar.add(label_9);

		label_10 = new JLabel("18:00");
		label_10.setBounds(311, 340, 28, 14);
		pnlCalendar.add(label_10);

		label_11 = new JLabel("19:00");
		label_11.setBounds(311, 363, 28, 14);
		pnlCalendar.add(label_11);

		label_12 = new JLabel("20:00");
		label_12.setBounds(311, 386, 28, 14);
		pnlCalendar.add(label_12);

		label_13 = new JLabel("21:00");
		label_13.setBounds(311, 409, 28, 14);
		pnlCalendar.add(label_13);

		lblQuote = new JLabel("");
		lblQuote.setBounds(349, 479, 518, 25);
		pnlCalendar.add(lblQuote);

		lblAuthor = new JLabel("");
		lblAuthor.setBounds(349, 504, 191, 20);
		pnlCalendar.add(lblAuthor);


		lblTopic = new JLabel("");
		lblTopic.setBounds(550, 504, 239, 20);
		pnlCalendar.add(lblTopic);

		//1th day weather
		lblPicture1 = new JLabel("");
		lblPicture1.setBounds(60, 589, 164, 124);
		pnlCalendar.add(lblPicture1);

		lblCelsius1 = new JLabel("");
		lblCelsius1.setBounds(60, 557, 164, 14);
		pnlCalendar.add(lblCelsius1);

		lblDate1 = new JLabel("");
		lblDate1.setBounds(60, 543, 164, 14);
		pnlCalendar.add(lblDate1);

		lblDesc1 = new JLabel("");
		lblDesc1.setBounds(60, 571, 164, 14);
		pnlCalendar.add(lblDesc1);

		//2th day weather
		lblPicture2 = new JLabel("");
		lblPicture2.setBounds(234, 589, 164, 124);
		pnlCalendar.add(lblPicture2);

		lblCelsius2 = new JLabel("");
		lblCelsius2.setBounds(234, 557, 163, 14);
		pnlCalendar.add(lblCelsius2);

		lblDate2 = new JLabel("");
		lblDate2.setBounds(234, 543, 163, 14);
		pnlCalendar.add(lblDate2);

		lblDesc2 = new JLabel("");
		lblDesc2.setBounds(234, 571, 163, 14);
		pnlCalendar.add(lblDesc2);

		//3th day weather
		lblPicture3 = new JLabel("");
		lblPicture3.setBounds(408, 589, 164, 124);
		pnlCalendar.add(lblPicture3);

		lblCelsius3 = new JLabel("");
		lblCelsius3.setBounds(408, 557, 164, 14);
		pnlCalendar.add(lblCelsius3);

		lblDate3 = new JLabel("");
		lblDate3.setBounds(408, 543, 164, 14);
		pnlCalendar.add(lblDate3);

		lblDesc3 = new JLabel("");
		lblDesc3.setBounds(408, 571, 164, 14);
		pnlCalendar.add(lblDesc3);

		//4th day weather
		lblPicture4 = new JLabel("");
		lblPicture4.setBounds(582, 589, 164, 124);
		pnlCalendar.add(lblPicture4);

		lblCelsius4 = new JLabel("");
		lblCelsius4.setBounds(582, 557, 164, 14);
		pnlCalendar.add(lblCelsius4);

		lblDate4 = new JLabel("");
		lblDate4.setBounds(582, 543, 164, 14);
		pnlCalendar.add(lblDate4);

		lblDesc4 = new JLabel("");
		lblDesc4.setBounds(582, 571, 164, 14);
		pnlCalendar.add(lblDesc4);

		//5th day weather
		lblPicture5 = new JLabel("");
		lblPicture5.setBounds(756, 589, 164, 124);
		pnlCalendar.add(lblPicture5);

		lblCelsius5 = new JLabel("");
		lblCelsius5.setBounds(756, 557, 166, 14);
		pnlCalendar.add(lblCelsius5);

		lblDate5 = new JLabel("");
		lblDate5.setBounds(756, 543, 166, 14);
		pnlCalendar.add(lblDate5);

		lblDesc5 = new JLabel("");
		lblDesc5.setBounds(756, 571, 166, 14);
		pnlCalendar.add(lblDesc5);

		//6th day weather
		lblPicture6 = new JLabel("");
		lblPicture6.setBounds(930, 589, 164, 124);
		pnlCalendar.add(lblPicture6);

		lblCelsius6 = new JLabel("");
		lblCelsius6.setBounds(930, 557, 164, 14);
		pnlCalendar.add(lblCelsius6);

		lblDate6 = new JLabel("");
		lblDate6.setBounds(930, 543, 164, 14);
		pnlCalendar.add(lblDate6);

		lblDesc6 = new JLabel("");
		lblDesc6.setBounds(930, 571, 164, 14);
		pnlCalendar.add(lblDesc6);

		//7th day weather
		lblPicture7 = new JLabel("");
		lblPicture7.setBounds(1104, 589, 164, 124);
		pnlCalendar.add(lblPicture7);

		lblCelsius7 = new JLabel("");
		lblCelsius7.setBounds(1104, 557, 164, 14);
		pnlCalendar.add(lblCelsius7);

		lblDate7 = new JLabel("");
		lblDate7.setBounds(1104, 543, 164, 14);
		pnlCalendar.add(lblDate7);

		lblDesc7 = new JLabel("");
		lblDesc7.setBounds(1104, 571, 164, 14);
		pnlCalendar.add(lblDesc7);

		label_14 = new JLabel("________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		label_14.setBounds(30, 515, 1302, 14);
		pnlCalendar.add(label_14);

		btnGetNote = new JButton("Show info for selected event");
		btnGetNote.setContentAreaFilled(false);
		btnGetNote.setForeground(Color.WHITE);
		btnGetNote.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGetNote.setEnabled(true);
		btnGetNote.setBounds(1032, 87, 265, 29);
		pnlCalendar.add(btnGetNote);
		btnGetNote.addActionListener(new btnGetNote());

		btnAddNote = new JButton("Add note to selected event");
		btnAddNote.setContentAreaFilled(false);
		btnAddNote.setForeground(Color.WHITE);
		btnAddNote.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddNote.setEnabled(true);
		btnAddNote.setBounds(1032, 124, 253, 29);
		pnlCalendar.add(btnAddNote);

		txtNotetext = new JTextField();
		txtNotetext.setBounds(1044, 176, 280, 20);
		pnlCalendar.add(txtNotetext);
		txtNotetext.setColumns(10);

		lblSelectCalendar = new JLabel("Select calendar");
		lblSelectCalendar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectCalendar.setForeground(Color.WHITE);
		lblSelectCalendar.setBounds(157, 61, 125, 20);
		pnlCalendar.add(lblSelectCalendar);

		comboBox_Calendar = new JComboBox();
		comboBox_Calendar.setBounds(175, 107, 110, 20);
		pnlCalendar.add(comboBox_Calendar);

		btnLoadSelectedCalendar = new JButton("Load selected calendar");
		btnLoadSelectedCalendar.setContentAreaFilled(false);
		btnLoadSelectedCalendar.setForeground(Color.WHITE);
		btnLoadSelectedCalendar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLoadSelectedCalendar.setBounds(82, 140, 219, 29);
		btnLoadSelectedCalendar.addActionListener(new btnLoadSelectedCalendar_Action());
		pnlCalendar.add(btnLoadSelectedCalendar);

		btnCreateCalendar = new JButton("Create Calendar");
		btnCreateCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logic.screen.setVisible(true);
				Logic.screen.show(Screen.CREATECALENDAR);

			}
		});
		btnCreateCalendar.setContentAreaFilled(false);
		btnCreateCalendar.setForeground(Color.WHITE);
		btnCreateCalendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreateCalendar.setBounds(30, 209, 195, 33);
		pnlCalendar.add(btnCreateCalendar);


		btnDeleteCalendar = new JButton("Delete Calendar");
		btnDeleteCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logic.screen.setVisible(true);
				Logic.screen.show(Screen.DELETECALENDAR);

			}
		});
		btnDeleteCalendar.setForeground(Color.WHITE);
		btnDeleteCalendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDeleteCalendar.setContentAreaFilled(false);
		btnDeleteCalendar.setBounds(30, 254, 193, 33);
		pnlCalendar.add(btnDeleteCalendar);

		btnCreateEvent = new JButton("Create Event");
		btnCreateEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logic.screen.setVisible(true);
				Logic.screen.show(Screen.CREATEEVENT);
			}
		});
		btnCreateEvent.setForeground(Color.WHITE);
		btnCreateEvent.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreateEvent.setContentAreaFilled(false);
		btnCreateEvent.setBounds(30, 299, 161, 33);
		pnlCalendar.add(btnCreateEvent);

		btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logic.screen.setVisible(true);
				Logic.screen.show(Screen.LOGOUT);
				frmMain.dispose();
			}
		});
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(32, 344, 111, 33);
		pnlCalendar.add(btnLogOut);

		label_background = new JLabel("");
		label_background.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images2/MetalBackground.jpg")));
		label_background.setBounds(0, 0, 1360, 739);
		pnlCalendar.add(label_background);

		btnAddNote.addActionListener(new btnAddNote());


		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(15);

		Color gridColor = UIManager.getColor("Table.gridColor");  
		TableColumnModel model = tblCalendar.getColumnModel();  

		// runs the method refreshCalendar.
		refreshCalendar (d.getWeekofYear(), d.getRealYear(), d.getJsonString(), d.getJsonString5(), d.getUserName()); //Refresh calendar
	}


	/**
	 * The purpose of this method is to clear the JTable of data and insert new data. 
	 * @param week, a integer value containing which week the calendar is to display. 
	 * @param year, a integer value containing which year the calendar is to display. 
	 * @param JSonString3, a JSON string containing the events sent from the database. 
	 * @param JsonString5, a JSON string containing the information of the calendars sent from the database. 
	 * @param userName, a String of the username of the user who is currently logged in. 
	 */
	public  void refreshCalendar(int week, int year, String JSonString3, String JsonString5, String userName){

		columnRows.clear(); // Clears the columnRows ArrayList.

		String [] weeks = new String[53];
		for(int d =0; d<weeks.length; d++){
			weeks [d] = "Week "+ Integer.toString(d);

		}
		int nod, som; //Number Of Days, Start Of Month

		//Allow/disallow buttons
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		if (week == 1 && year <= d.getRealYear()-10){btnPrev.setEnabled(false);} //Too early
		if (week == 52 && year >= d.getRealYear()+100){btnNext.setEnabled(false);} //Too late
		lblMonth.setText(weeks[week]); //Refresh the month label (at the top)
		lblMonth.setBounds(683-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar

		//Sets quote, author and topic
		lblQuote.setText("''"+Logic.Quote+"''");
		lblAuthor.setText("By: "+Logic.Author);
		lblTopic.setText("Topic: "+Logic.Topic);


		//Sets descriptions to day 1.
		lblDate1.setText(Logic.Date1);
		lblCelsius1.setText(Logic.Celsius1+" Celsius.");
		lblDesc1.setText("Weather: "+Logic.Desc1);

		//Sets pictures to Day 1. 
		if(Logic.Desc1.equals("broken clouds")){
			lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
		} else if(Logic.Desc1.equals("few clouds")){
			lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
		} else if(Logic.Desc1.equals("light rain")){
			lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
		} else if(Logic.Desc1.equals("sky is clear")){
			lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
		} else if(Logic.Desc1.equals("light snow")){
			lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
		} else if(Logic.Desc1.equals("overcast clouds")){
			lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/overcast clouds.png")));
		} else if(Logic.Desc1.equals("moderate rain")){
			lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/moderate rain.png")));
		} else if(Logic.Desc1.equals("scattered clouds")){
			lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/scattered clouds.png")));
		} else if(Logic.Desc1.equals("heavy intensity rain")){
			lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/heavy_rain.png")));
		} 




		//Sets descriptions to day 2.
		lblDate2.setText(Logic.Date2);
		lblCelsius2.setText(Logic.Celsius2+" Celsius.");
		lblDesc2.setText("Weather: "+Logic.Desc2);
		//Sets pictures to Day 2. 
		if(Logic.Desc2.equals("broken clouds")){
			lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
		} else if(Logic.Desc2.equals("few clouds")){
			lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
		} else if(Logic.Desc2.equals("light rain")){
			lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
		} else if(Logic.Desc2.equals("sky is clear")){
			lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
		} else if(Logic.Desc2.equals("light snow")){
			lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
		} else if(Logic.Desc2.equals("overcast clouds")){
			lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/overcast clouds.png")));
		} else if(Logic.Desc2.equals("moderate rain")){
			lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/moderate rain.png")));
		} else if(Logic.Desc2.equals("scattered clouds")){
			lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/scattered clouds.png")));
		} else if(Logic.Desc2.equals("heavy intensity rain")){
			lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/heavy_rain.png")));
		} 


		//Sets descriptions to day 3.
		lblDate3.setText(Logic.Date3);
		lblCelsius3.setText(Logic.Celsius3+" Celsius.");
		lblDesc3.setText("Weather: "+Logic.Desc3);
		//Sets pictures to Day 3. 
		if(Logic.Desc3.equals("broken clouds")){
			lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
		} else if(Logic.Desc3.equals("few clouds")){
			lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
		} else if(Logic.Desc3.equals("light rain")){
			lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
		} else if(Logic.Desc3.equals("sky is clear")){
			lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
		} else if(Logic.Desc3.equals("light snow")){
			lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
		} else if(Logic.Desc3.equals("overcast clouds")){
			lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/overcast clouds.png")));
		} else if(Logic.Desc3.equals("moderate rain")){
			lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/moderate rain.png")));
		} else if(Logic.Desc3.equals("scattered clouds")){
			lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/scattered clouds.png")));
		} else if(Logic.Desc3.equals("heavy intensity rain")){
			lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/heavy_rain.png")));
		} 

		//Sets descriptions to day 4.
		lblDate4.setText(Logic.Date4);
		lblCelsius4.setText(Logic.Celsius4+" Celsius.");
		lblDesc4.setText("Weather: "+Logic.Desc4);
		//Sets pictures to Day 4. 
		if(Logic.Desc4.equals("broken clouds")){
			lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
		} else if(Logic.Desc4.equals("few clouds")){
			lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
		} else if(Logic.Desc4.equals("light rain")){
			lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
		} else if(Logic.Desc4.equals("sky is clear")){
			lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
		} else if(Logic.Desc4.equals("light snow")){
			lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
		} else if(Logic.Desc4.equals("overcast clouds")){
			lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/overcast clouds.png")));
		} else if(Logic.Desc4.equals("moderate rain")){
			lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/moderate rain.png")));
		} else if(Logic.Desc4.equals("scattered clouds")){
			lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/scattered clouds.png")));
		} else if(Logic.Desc4.equals("heavy intensity rain")){
			lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/heavy_rain.png")));
		} 

		//Sets descriptions to day 5.
		lblDate5.setText(Logic.Date5);
		lblCelsius5.setText(Logic.Celsius5+" Celsius.");
		lblDesc5.setText("Weather: "+Logic.Desc5);
		//Sets pictures to Day 5. 
		if(Logic.Desc5.equals("broken clouds")){
			lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
		} else if(Logic.Desc5.equals("few clouds")){
			lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
		} else if(Logic.Desc5.equals("light rain")){
			lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
		} else if(Logic.Desc5.equals("sky is clear")){
			lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
		} else if(Logic.Desc5.equals("light snow")){
			lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
		} else if(Logic.Desc5.equals("overcast clouds")){
			lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/overcast clouds.png")));
		} else if(Logic.Desc5.equals("moderate rain")){
			lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/moderate rain.png")));
		} else if(Logic.Desc5.equals("scattered clouds")){
			lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/scattered clouds.png")));
		} else if(Logic.Desc5.equals("heavy intensity rain")){
			lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/heavy_rain.png")));
		} 

		//Sets descriptions to day 6.
		lblDate6.setText(Logic.Date6);
		lblCelsius6.setText(Logic.Celsius6+" Celsius.");
		lblDesc6.setText("Weather: "+Logic.Desc6);
		//Sets pictures to Day 6. 
		if(Logic.Desc6.equals("broken clouds")){
			lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
		} else if(Logic.Desc6.equals("few clouds")){
			lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
		} else if(Logic.Desc6.equals("light rain")){
			lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
		} else if(Logic.Desc6.equals("sky is clear")){
			lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
		} else if(Logic.Desc6.equals("light snow")){
			lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
		} else if(Logic.Desc6.equals("overcast clouds")){
			lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/overcast clouds.png")));
		} else if(Logic.Desc6.equals("moderate rain")){
			lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/moderate rain.png")));
		} else if(Logic.Desc6.equals("scattered clouds")){
			lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/scattered clouds.png")));
		} else if(Logic.Desc6.equals("heavy intensity rain")){
			lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/heavy_rain.png")));
		} 


		//Sets descriptions to day 7.
		lblDate7.setText(Logic.Date7);
		lblCelsius7.setText(Logic.Celsius7+" Celsius.");
		lblDesc7.setText("Weather: "+Logic.Desc7);
		//Sets pictures to Day 7. 
		if(Logic.Desc7.equals("broken clouds")){
			lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
		} else if(Logic.Desc7.equals("few clouds")){
			lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
		} else if(Logic.Desc7.equals("light rain")){
			lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
		} else if(Logic.Desc7.equals("sky is clear")){
			lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
		} else if(Logic.Desc7.equals("light snow")){
			lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
		} else if(Logic.Desc7.equals("overcast clouds")){
			lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/overcast clouds.png")));
		} else if(Logic.Desc7.equals("moderate rain")){
			lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/moderate rain.png")));
		} else if(Logic.Desc7.equals("scattered clouds")){
			lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/scattered clouds.png")));
		} else if(Logic.Desc7.equals("heavy intensity rain")){
			lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/heavy_rain.png")));
		} 

		Gson gson = new GsonBuilder().create();


		if(updatedlcs ==false){


			JsonParser parser = new JsonParser();
			JsonArray jArray = parser.parse(JSonString3).getAsJsonArray();



			for(JsonElement obj : jArray )
			{
				Event cse = gson.fromJson( obj , Event.class);
				lcs.add(cse); // Add the information from the JSON string JSonString3 to the lcs ArrayList. 


			}
			updatedlcs = true; // Sets the boolean variable updatedlcs to true to prevent adding the same information to the lcs ArrayList multiple times. 
		}

		if(updatedlcs2 ==false){
			JsonParser parser = new JsonParser();
			JsonArray jArray = parser.parse(JsonString5).getAsJsonArray();

			for(JsonElement obj : jArray )
			{
				CalendarData cse = gson.fromJson( obj , CalendarData.class);
				lcs2.add(cse); // Add the information from the JSON string JSonString5 to the lcs2 ArrayList.


			}
			updatedlcs2 = true; // Sets the boolean variable updatedlcs to true to prevent adding the same information to the lcs2 ArrayList multiple times. 
		}




		// Runs a for loop to insert the name of the calendar to the comboBox comboBox_calendar if the calendar is public or created by the current user. 
		for (int c=0; c<lcs2.size(); c++){
			if (lcs2.get(c).getActive()==1 && (lcs2.get(c).getPrivatePublic()==1 || lcs2.get(c).getCreatedBy().equals(userName) )){  // 1 means active and 1 means public.


				comboBox_Calendar.addItem(lcs2.get(c).getName());
			}
		}


		// Creates an array containing the possible start times of an event. 
		String [] startCalendarTime = new String[17];
		startCalendarTime[0] = "08:00";
		startCalendarTime[1] = "08:55";
		startCalendarTime[2] = "09:50";
		startCalendarTime[3] = "10:45";
		startCalendarTime[4] = "11:40";
		startCalendarTime[5] = "12:35";
		startCalendarTime[6] = "13:30";
		startCalendarTime[7] = "14:25";
		startCalendarTime[8] = "15:20";
		startCalendarTime[9] = "16:15";
		startCalendarTime[10] = "17:10";
		startCalendarTime[11] = "18:05";
		startCalendarTime[12] = "19:00";
		startCalendarTime[13] = "19:55";
		startCalendarTime[14] = "20:50";
		startCalendarTime[15] = "21:45";
		startCalendarTime[16] = "22:40";

		// Creates an array containing the possible end times of an event. 
		String [] endCalendarTime = new String[17];
		endCalendarTime[0] = "08:00";
		endCalendarTime[1] = "08:45";
		endCalendarTime[2] = "09:40";
		endCalendarTime[3] = "10:35";
		endCalendarTime[4] = "11:30";
		endCalendarTime[5] = "12:25";
		endCalendarTime[6] = "13:20";
		endCalendarTime[7] = "14:15";
		endCalendarTime[8] = "15:10";
		endCalendarTime[9] = "16:05";
		endCalendarTime[10] = "17:00";
		endCalendarTime[11] = "17:55";
		endCalendarTime[12] = "18:50";
		endCalendarTime[13] = "19:45";
		endCalendarTime[14] = "20:40";
		startCalendarTime[15] = "21:35";
		startCalendarTime[16] = "22:30";

		// Clear table
		for (int e=0; e<6; e++){
			for (int f=0; f<7; f++){
				mtblCalendar.setValueAt(null, e, f);
			}
		}

		// Initializes variables. 
		int column = 0;
		int row = 0;
		int startRow = 0;
		int endRow = 0;
		boolean match = false;

		tblCalendar.setDefaultRenderer(Object.class, new BorderCellRenderer());
		tblCalendar.setShowGrid(false);

		boolean isTop,isLeft,isBottom,isRight;


		int[] rows = new int[15];

		for(int å1 = 0; å1<rows.length; å1++){
			rows[å1] = å1;
		}

		int[] columns = new int[7];
		for(int ab1 = 0; ab1<columns.length; ab1++){
			columns[ab1] = ab1;
		}


		for(int i = 0; i<columns.length; i++){

		}
		for(int a = 0; a<rows.length; a++){

		}

		int rowMax    = rows.length;
		int columnMax = columns.length;

		for (int i=0;i<rowMax;i++) {
			int row1 = rows[i];
			isTop    = (i == 0       )? true: false;
			isBottom = (i == rowMax-1)? true: false;

			for (int j=0;j<columnMax;j++) {
				int column1 = columns[j];
				isLeft  = (j == 0          )? true: false;
				isRight = (j == columnMax-1)? true: false;


				MyData myData = (MyData)null;

				Color color = UIManager.getColor("Table.gridColor");

				if (myData == null) {
					myData = new MyData("", new LinesBorder(color,0));
				}
				LinesBorder border = (LinesBorder)myData.getBorder();

				Insets insets = new Insets(1,1,1,1);
				insets.top    = 1;    
				insets.left   = 1;     
				insets.bottom = 1;    
				insets.right  = 1; 


				boolean isReplace = true;
				Insets tmp = new Insets(0,0,0,0);
				if (isTop)    tmp.top    = Math.max(tmp.top    ,insets.top);
				if (isLeft)   tmp.left   = Math.max(tmp.left   ,insets.left);
				if (isBottom) tmp.bottom = Math.max(tmp.bottom ,insets.bottom);
				if (isRight)  tmp.right  = Math.max(tmp.right  ,insets.right);
				border.append(insets, isReplace);



				mtblCalendar.setValueAt(myData, row1, column1);
			}
		}
		tblCalendar.clearSelection();
		tblCalendar.revalidate();
		tblCalendar.repaint();

		// For loop for inserting events into the table. 
		for (int g=0; g<=lcs.size(); g++){
			if(lcs.get(g).getID() ==d.getCalendarID()){


				String dateStart =lcs.get(g).getStart().get(0); // Gets the start time of the event.
				String dateEnd = lcs.get(g).getEnd().get(0); // Gets the end time of the event.

				String daySplitEnd [] = dateEnd.split(""); // Splits the start date of the event up to allow for rearranging.
				String daySplit [] = dateStart.split(""); // Splits the end date of the event up to allow for rearranging.

				//Rearranges the date. 
				String day = daySplit[9]+ daySplit[10];
				String month = daySplit[6]+ daySplit[7];
				String år = daySplit[1]+daySplit[2]+daySplit[3]+daySplit[4];
				String dato = day+"-"+month+"-"+år;

				//Rearranges the start time.
				String startHours =daySplit[11]+daySplit[12];
				String startMinutes =daySplit[14]+daySplit[15];
				String startTime = startHours + ":"+startMinutes;
				
				//Rearranges the end time. 
				String endHours =daySplitEnd[11]+daySplitEnd[12];
				String endMinutes =daySplitEnd[14]+daySplitEnd[15];
				String endTime = endHours + ":"+endMinutes;

				//Loops through the header array to see if the date of the event matches the header. 
				for (int h = 0; h<headers.length; h++){
					if(dato.equals(headers[h])){        		
						column  = h;
						match = true;

					}
				}


				if(match == true){
					match = false;

					if (!lcs.get(g).getActivityid().equals("")){


						//Loops through the startCalendarTime array to see if the start time of the event matches the startCalendarTime array. 
						for (int st=0; st<startCalendarTime.length; st++){ //st = startTime
							if (startTime.equals(startCalendarTime[st])){
								startRow = st;


							}
						}
						//Loops through the endCalendarTime array to see if the end time of the event matches the startCalendarTime array.
						for (int et=0; et<endCalendarTime.length; et++){  //et = endTime
							if (endTime.equals(endCalendarTime[et])){
								endRow = et;


							}
						}
					}

					if (lcs.get(g).getActivityid().equals("1")){
						if(startHours.equals("08")){
							startRow =0;
						}
						if(startHours.equals("09")){
							startRow =1;
						}
						if(startHours.equals("10")){
							startRow =2;
						}
						if(startHours.equals("11")){
							startRow =3;
						}
						if(startHours.equals("12")){
							startRow =4;
						}
						if(startHours.equals("13")){
							startRow =5;
						}
						if(startHours.equals("14")){
							startRow =6;
						}
						if(startHours.equals("15")){
							startRow =7;
						}
						if(startHours.equals("16")){
							startRow =8;
						}
						if(startHours.equals("17")){
							startRow =9;
						}
						if(startHours.equals("18")){
							startRow =10;
						}
						if(startHours.equals("19")){
							startRow =11;
						}
						if(startHours.equals("20")){
							startRow =12;
						}
						if(startHours.equals("21")){
							startRow =13;
						}

						if(endHours.equals("08")){
							endRow =0;
						}
						if(endHours.equals("09")){
							endRow =2;
						}
						if(endHours.equals("10")){
							endRow =3;
						}
						if(endHours.equals("11")){
							endRow =4;
						}
						if(endHours.equals("12")){
							endRow =5;
						}
						if(endHours.equals("13")){
							endRow =6;
						}
						if(endHours.equals("14")){
							endRow =7;
						}
						if(endHours.equals("15")){
							endRow =8;
						}
						if(endHours.equals("16")){
							endRow =9;
						}
						if(endHours.equals("17")){
							endRow =10;
						}
						if(endHours.equals("18")){
							endRow =11;
						}
						if(endHours.equals("19")){
							endRow =12;
						}
						if(endHours.equals("20")){
							endRow =13;
						}
						if(endHours.equals("21")){
							endRow =14;
						}
						if(endHours.equals("22")){
							endRow =15;
						}

					}
					for (int k = startRow; k<endRow; k++){

						tblCalendar.setIntercellSpacing(new Dimension(0,0));

						boolean isTop1,isLeft1,isBottom1,isRight1; 		       

						int rowLength1 = endRow-startRow;

						int[] rows1    = new int[rowLength1];

						for(int å1 = 0; å1<rows1.length; å1++){
							rows1[å1] = startRow+å1;
						}

						int[] columns1 = new int[1];

						for(int ab1 = 0; ab1<columns1.length; ab1++){
							columns1[ab1] = column;
						}

						int rowMax1    = rows1.length;
						int columnMax1 = columns1.length;

						for (int i1=0;i1<rowMax1;i1++) {
							int rowb1 = rows1[i1];

							String value = "";
							if(i1==0){
								value = lcs.get(g).getDescription();
							}
							if(i1==1){
								value = startTime+ "-"+endTime;
							}
							if(i1>1){
								value = "";
							}
							isTop1    = (i1 == 0       )? true: false;
							isBottom1 = (i1 == rowMax1-1)? true: false;

							for (int j1=0;j1<columnMax1;j1++) {
								int columnb1 = columns1[j1];
								isLeft1  = (j1 == 0          )? true: false;
								isRight1 = (j1 == columnMax1-1)? true: false;

								Color color1 = UIManager.getColor("Table.gridColor");


								MyData myData = (MyData)null;  

								myData = new MyData(value, new LinesBorder(color1,0));

								Insets insets = new Insets(1,1,1,1);
								insets.top    = 1;     
								insets.left   = 1;     
								insets.bottom = 1;     
								insets.right  = 1;     

								LinesBorder border = (LinesBorder)myData.getBorder();

								boolean isReplace = true;
								Insets tmp = new Insets(0,0,0,0);
								if (isTop1)    tmp.top    = Math.max(tmp.top    ,insets.top);
								if (isLeft1)   tmp.left   = Math.max(tmp.left   ,insets.left);
								if (isBottom1) tmp.bottom = Math.max(tmp.bottom ,insets.bottom);
								if (isRight1)  tmp.right  = Math.max(tmp.right  ,insets.right);
								border.append(tmp, isReplace);


								notes [rowb1][columnb1] = g;


								mtblCalendar.setValueAt(myData, rowb1, columnb1);

								columnRows.add(new ColumnRow(rowb1,columnb1,lcs.get(g).getDescription()));

							}
						}
						tblCalendar.clearSelection();
						tblCalendar.revalidate();
						tblCalendar.repaint();
					}
				}
			}

		}

	}


	/**
	 *The purpose of this class is to control what happens when the user clicks on the button btnPrev.
	 */
	class btnPrev_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (d.getWeekofYear() == 1){ // If the current week is week 1 the new week is set to week 52. 

				d.setWeekofYear(52);            	
				d.setNewDate(d.getNewDate()-604800000); // subtract 604800000 milliseconds, which is equal to a full week, from the current week. 
				frmMain.dispose(); // Disposes the current frame to avoid an overload of several frames open at the same time. 
				run(d.getNewDate(), d.getJsonString(),d.getJsonString5(),d.getUserName()); // Runs the run method to start a new frame at the new week.  

			}
			else{ //Back one week

				d.setWeekofYear(d.getWeekofYear()-1); // subtract 1 from the current week. 
				d.setNewDate(d.getNewDate()-604800000);	// subtract 604800000 milliseconds, which is equal to a full week, from the current week.
				frmMain.dispose(); // Disposes the current frame to avoid an overload of several frames open at the same time. 
				run(d.getNewDate(), d.getJsonString(),d.getJsonString5(),d.getUserName()); // Runs the run method to start a new frame at the new week. 

			}
			refreshCalendar(d.getWeekofYear(), d.getCurrentYear(),d.getJsonString(),d.getJsonString5(), d.getUserName()); // Runs the refreshCalendar method to insert the new information into the Jtable.  
		}
	}
	/**
	 * The purpose of this class is to control what happens when the user clicks on the button btnNext.
	 */
	class btnNext_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (d.getWeekofYear() == 52){ // If the current week is week 52 the new week is set to week 1. 

				d.setWeekofYear(1);          
				d.setNewDate(d.getNewDate()+604800000); // adds 604800000 milliseconds, which is equal to a full week, to the current week.
				frmMain.dispose(); // Disposes the current frame to avoid an overload of several frames open at the same time. 
				run(d.getNewDate(),d.getJsonString(),d.getJsonString5(),d.getUserName()); // Runs the run method to start a new frame at the new week.  

			}
			else{ //Forward one week
				d.setWeekofYear(d.getWeekofYear()+1);
				d.setNewDate(d.getNewDate()+604800000); // adds 604800000 milliseconds, which is equal to a full week, to the current week.

				frmMain.dispose(); // Disposes the current frame to avoid an overload of several frames open at the same time. 
				run(d.getNewDate(), d.getJsonString(),d.getJsonString5(),d.getUserName()); // Runs the run method to start a new frame at the new week.  
			}
			refreshCalendar(d.getWeekofYear(), d.getCurrentYear(), d.getJsonString(),d.getJsonString5(), d.getUserName()); // Runs the refreshCalendar method to insert the new information into the Jtable. 
		}
	}
	/**
	 * The purpose of this class is to control what happens when the user clicks on the button btnGetNote.
	 */
	class btnGetNote implements ActionListener{
		public void actionPerformed (ActionEvent e){
																							
			int rowIndex = tblCalendar.getSelectedRow(); // Sets the integer rowIndex to the selected row.
			int colIndex = tblCalendar.getSelectedColumn(); // Sets the integer colIndex to the selected columns.
			int selection = notes[rowIndex][colIndex];

			JOptionPane.showMessageDialog(null, "Note: "+ lcs.get(selection).getNote()+ "\nLocation "+ lcs.get(selection).getLocation()+ 
					"\nStartTime: "+lcs.get(selection).getStart()+ "\nEndTime: "+lcs.get(selection).getEnd()

					, lcs.get(selection).getDescription(),JOptionPane.PLAIN_MESSAGE);

		}
	}
	/**
	 * The purpose of this class is to control what happens when the user clicks on the button btnAddNote.
	 */
	class btnAddNote implements ActionListener{
		public void actionPerformed (ActionEvent e){

			int rowIndex = tblCalendar.getSelectedRow();
			int colIndex = tblCalendar.getSelectedColumn();
			int selection = notes[rowIndex][colIndex];
			int superID = selection+1;



			SN.setSuperID(superID);
			SN.setNote(txtNotetext.getText());


			try {
				String JsonString=tcp.bla(SN);
				SaveNote SN = gson.fromJson(JsonString, SaveNote.class);
				lcs.get(selection).setNote(txtNotetext.getText());


				JOptionPane.showMessageDialog(null, SN.getAnswer()
						, "Note",JOptionPane.PLAIN_MESSAGE);
			} catch (UnknownHostException e1) {

				e1.printStackTrace();
			} catch (IOException e1) {

				e1.printStackTrace();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}




		}
	}
	/**
	 * The purpose of this class is to control what happens when the user clicks on the button btnLoadSelectedCalendar.
	 */
	class btnLoadSelectedCalendar_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			Object objectCalendarName = comboBox_Calendar.getSelectedItem();
			String stringCalendarName = objectCalendarName.toString();


			for(int bh2 = 0; bh2<lcs2.size(); bh2++){
				if(stringCalendarName.equals(lcs2.get(bh2).getName())){
					d.setCalendarID(lcs2.get(bh2).getCalendarID()) ;
				}
			}
			frmMain.dispose();
			run(d.getNewDate(),d.getJsonString(),d.getJsonString5(),d.getUserName());

		}
	}

	//Getters & setters
	public JButton getBtnCreateCalendar() {
		return btnCreateCalendar;
	}



	public static JFrame getFrmMain() {
		return frmMain;
	}



	public JButton getBtnDeleteCalendar() {
		return btnDeleteCalendar;
	}


	public JButton getBtnCreateEvent() {
		return btnCreateEvent;
	}



	public JButton getBtnLogOut() {
		return btnLogOut;
	}



	public JComboBox getComboBox_Calendar() {
		return comboBox_Calendar;
	}



	public void setComboBox_Calendar(JComboBox comboBox_Calendar) {
		this.comboBox_Calendar = comboBox_Calendar;
	}



	public JTextField getTxtNotetext() {
		return txtNotetext;
	}



	public void setTxtNotetext(JTextField txtNotetext) {
		this.txtNotetext = txtNotetext;
	}

	public ArrayList<ColumnRow> getColumnRows() {

		return columnRows;
	}



	public void setColumnRows(ArrayList<ColumnRow> columnRows) {
		this.columnRows = columnRows;
	}

	class MyData implements CellBorder {
		private Border border;
		private Object obj;

		public MyData(Object obj, Border border) {
			this.obj    = obj;
			this.border = border;
		}

		public void setObject(Object obj) {
			this.obj = obj;
		}   
		public String toString() {
			return obj.toString();
		}

		// CellBorder  
		public void setBorder(Border border) {
			this.border = border;
		}  
		public Border getBorder() {
			return border;
		}
		public void setBorder(Border border, int row, int col) {}
		public Border getBorder(int row, int col) { return null; }
	}
}