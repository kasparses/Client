package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

public class Screen extends JFrame {
	
	public static final String LOGOUT = "name_271364461837793";
	public static final String LOGIN = "name_271353069859059";
	public static final String DELTECALENDAR = "name_271341061178742";
	public static final String CREATEEVENT = "name_403949887096492";
	public static final String CREATECALENDAR = "name_271288584224003";
	public static final String CALENDAR = "name_271270913019346";
	public static final String FORGOT = "name_1025140884411824";
	public static final String EVENTLIST = "name_1036762552199787";

	private JPanel contentPane;
	private Createcalendar createcalendar;
	private DeleteCalendar deleteCalendar;
	private Login login;
	private LogOut logOut;
	CardLayout c;
	private CreateEvent createEvent;
	private final ForgotLogin forgotLogin = new ForgotLogin();
	private final Eventlist eventlist = new Eventlist();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1390, 830);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(eventlist, "name_1036762552199787");
		
		createEvent = new CreateEvent();
		contentPane.add(createEvent, "name_403949887096492");

		logOut = new LogOut();
		contentPane.add(logOut, "name_271364461837793");
		
		login = new Login();
		contentPane.add(login, "name_271353069859059");
		
		deleteCalendar = new DeleteCalendar();
		contentPane.add(deleteCalendar, "name_271341061178742");
		
		contentPane.add(forgotLogin, "name_1025140884411824");

		createcalendar = new Createcalendar();
		contentPane.add(createcalendar, "name_271288584224003");

		c = (CardLayout) getContentPane().getLayout();
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public Createcalendar getCreatecalendar() {
		return createcalendar;
	}
	public void show(String card) {
		c.show(getContentPane(),  card);
	}

	public CreateEvent getCreateEvent() {
		return createEvent;
	}

	public DeleteCalendar getDeleteCalendar() {
		return deleteCalendar;
	}

	public Login getLogin() {
		return login;
	}

	public LogOut getLogOut() {
		return logOut;
	}

	public ForgotLogin getForgotLogin() {
		return forgotLogin;
	}

	public Eventlist getEventlist() {
		return eventlist;
	}
	
}
