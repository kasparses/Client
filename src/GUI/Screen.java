package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

public class Screen extends JFrame {
	
	public static final String MAINMENU = "name_271375820943970";
	public static final String LOGOUT = "name_271364461837793";
	public static final String LOGIN = "name_271353069859059";
	public static final String DELTECALENDAR = "name_271341061178742";
	public static final String DELETENOTE = "name_271324206063397";
	public static final String CREATENOTE = "name_271311829920778";
	public static final String CREATEEVENT = "name_271300909076732";
	public static final String CREATECALENDAR = "name_271288584224003";
	public static final String CALENDAR = "name_271270913019346";

	private JPanel contentPane;
	private Calendar calendar;
	private Createcalendar createcalendar;
	private CreateEvent createEvent;
	private CreateNote createNote;
	private DeleteNote deleteNote;
	private DelteCalendar delteCalendar;
	private Login login;
	private LogOut logOut;
	private MainMenu mainMenu;
	CardLayout c;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		mainMenu = new MainMenu();
		contentPane.add(mainMenu, "name_271375820943970");
		
		logOut = new LogOut();
		contentPane.add(logOut, "name_271364461837793");
		
		login = new Login();
		contentPane.add(login, "name_271353069859059");
		
		delteCalendar = new DelteCalendar();
		contentPane.add(delteCalendar, "name_271341061178742");
		
		deleteNote = new DeleteNote();
		contentPane.add(deleteNote, "name_271324206063397");
		
		createNote = new CreateNote();
		contentPane.add(createNote, "name_271311829920778");
		
		createEvent = new CreateEvent();
		contentPane.add(createEvent, "name_271300909076732");
		
		createcalendar = new Createcalendar();
		contentPane.add(createcalendar, "name_271288584224003");
		
		calendar = new Calendar();
		contentPane.add(calendar, "name_271270913019346");
		c = (CardLayout) getContentPane().getLayout();
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public Calendar getCalendar() {
		return calendar;
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

	public CreateNote getCreateNote() {
		return createNote;
	}

	public DeleteNote getDeleteNote() {
		return deleteNote;
	}

	public DelteCalendar getDelteCalendar() {
		return delteCalendar;
	}

	public Login getLogin() {
		return login;
	}

	public LogOut getLogOut() {
		return logOut;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}
	

}
