package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JPanel {
	private JLabel lblMainmenu;
	private JButton btbLogout;
	private JButton btnCreateNewCalendar;
	private JButton btnDeleteCalendar;
	private JButton btnGetQuoteoftheday;
	private JButton btnGetForecast;
	private JButton btnSavenote;
	private JButton btnCreateevent;
	private JButton btnDeletenote;

	/**
	 * Create the panel.
	 */
	public MainMenu() {
		setLayout(null);
		
		lblMainmenu = new JLabel("Mainmenu");
		lblMainmenu.setBounds(163, 11, 46, 14);
		add(lblMainmenu);
		
		btbLogout = new JButton("Logout");
		btbLogout.setBounds(42, 54, 89, 23);
		add(btbLogout);
		
		btnCreateNewCalendar = new JButton("CreateNewCalendar");
		btnCreateNewCalendar.setBounds(42, 105, 129, 23);
		add(btnCreateNewCalendar);
		
		btnDeleteCalendar = new JButton("DeleteCalendar");
		btnDeleteCalendar.setBounds(42, 155, 107, 23);
		add(btnDeleteCalendar);
		
		btnGetQuoteoftheday = new JButton("Get quote of the day");
		btnGetQuoteoftheday.setBounds(42, 194, 133, 23);
		add(btnGetQuoteoftheday);
		
		btnGetForecast = new JButton("GetForecast");
		btnGetForecast.setBounds(42, 238, 91, 23);
		add(btnGetForecast);
		
		btnSavenote = new JButton("Savenote");
		btnSavenote.setBounds(203, 54, 89, 23);
		add(btnSavenote);
		
		btnCreateevent = new JButton("CreateEvent");
		btnCreateevent.setBounds(203, 105, 89, 23);
		add(btnCreateevent);
		
		btnDeletenote = new JButton("DeleteNote");
		btnDeletenote.setBounds(203, 155, 89, 23);
		add(btnDeletenote);
		
		

	}
	
	
	public void addActionListener(ActionListener l) {
		btnCreateevent.addActionListener(l);
		btnCreateNewCalendar.addActionListener(l);
		btnDeleteCalendar.addActionListener(l);
		btnDeletenote.addActionListener(l);
		btnGetForecast.addActionListener(l);
		btnGetQuoteoftheday.addActionListener(l);
		btnSavenote.addActionListener(l);
	}

	public JLabel getLblMainmenu() {
		return lblMainmenu;
	}

	public JButton getBtbLogout() {
		return btbLogout;
	}

	public JButton getBtnCreateNewCalendar() {
		return btnCreateNewCalendar;
	}

	public JButton getBtnDeleteCalendar() {
		return btnDeleteCalendar;
	}

	public JButton getBtnGetQuoteoftheday() {
		return btnGetQuoteoftheday;
	}

	public JButton getBtnGetForecast() {
		return btnGetForecast;
	}

	public JButton getBtnSavenote() {
		return btnSavenote;
	}

	public JButton getBtnCreateevent() {
		return btnCreateevent;
	}

	public JButton getBtnDeletenote() {
		return btnDeletenote;
	}
}
