package GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DelteCalendar extends JPanel {
	private JLabel lblDeletecalendar;
	private JLabel lblCalendarname;
	private JTextField txtCalendarname;
	private JButton btnDeletecalendar;

	/**
	 * Create the panel.
	 */
	public DelteCalendar() {
		setLayout(null);
		
		lblDeletecalendar = new JLabel("DeleteCalendar");
		lblDeletecalendar.setBounds(171, 11, 74, 14);
		add(lblDeletecalendar);
		
		lblCalendarname = new JLabel("CalendarName");
		lblCalendarname.setBounds(20, 70, 70, 14);
		add(lblCalendarname);
		
		txtCalendarname = new JTextField();
		txtCalendarname.setText("CalendarName");
		txtCalendarname.setBounds(172, 67, 86, 20);
		add(txtCalendarname);
		txtCalendarname.setColumns(10);
		
		btnDeletecalendar = new JButton("DeleteCalendar");
		btnDeletecalendar.setBounds(171, 226, 107, 23);
		add(btnDeletecalendar);

	}
	public void addActionListener(ActionListener l){
		btnDeletecalendar.addActionListener(l);
	}
	

	public JTextField getTxtCalendarname() {
		return txtCalendarname;
	}

	public JButton getBtnDeletecalendar() {
		return btnDeletecalendar;
	}
	

}
