package GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DeleteCalendar extends JPanel {
	private JLabel lblDeletecalendar;
	private JLabel lblCalendarname;
	private JTextField txtCalendarname;
	private JButton btnDeletecalendar;
	private JLabel label;
	private JLabel label_1;
	private JButton btnEventList;
	private JButton btnMain;
	private JButton btnLogOut;

	/**
	 * Create the panel.
	 */
	public DeleteCalendar() {
		setLayout(null);
		
		lblDeletecalendar = new JLabel("DeleteCalendar");
		lblDeletecalendar.setForeground(Color.WHITE);
		lblDeletecalendar.setFont(new Font("Tahoma", Font.BOLD, 78));
		lblDeletecalendar.setBounds(382, 11, 622, 95);
		add(lblDeletecalendar);
		
		lblCalendarname = new JLabel("CalendarName");
		lblCalendarname.setForeground(Color.WHITE);
		lblCalendarname.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCalendarname.setBounds(476, 278, 222, 37);
		add(lblCalendarname);
		
		txtCalendarname = new JTextField();
		txtCalendarname.setBounds(719, 285, 210, 30);
		add(txtCalendarname);
		txtCalendarname.setColumns(10);
		
		btnDeletecalendar = new JButton("Delete Calendar");
		btnDeletecalendar.setContentAreaFilled(false);
		btnDeletecalendar.setForeground(Color.WHITE);
		btnDeletecalendar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnDeletecalendar.setBounds(530, 435, 308, 70);
		add(btnDeletecalendar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(DeleteCalendar.class.getResource("/Images2/CBSLogo3.png")));
		label.setBounds(0, 709, 250, 59);
		add(label);
		
		btnEventList = new JButton("Event List");
		btnEventList.setForeground(Color.WHITE);
		btnEventList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEventList.setContentAreaFilled(false);
		btnEventList.setBounds(55, 137, 225, 45);
		add(btnEventList);
		
		btnMain = new JButton("Main");
		btnMain.setForeground(Color.WHITE);
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMain.setContentAreaFilled(false);
		btnMain.setBounds(55, 217, 225, 45);
		add(btnMain);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(55, 293, 225, 45);
		add(btnLogOut);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DeleteCalendar.class.getResource("/Images2/MetalBackground.jpg")));
		label_1.setBounds(0, 0, 1366, 768);
		add(label_1);

	}
	public void addActionListener(ActionListener l){
		btnDeletecalendar.addActionListener(l);
		btnEventList.addActionListener(l);
		btnLogOut.addActionListener(l);
		btnMain.addActionListener(l);

	}
	

	public JButton getBtnEventList() {
		return btnEventList;
	}
	public JButton getBtnMain() {
		return btnMain;
	}
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	public JTextField getTxtCalendarname() {
		return txtCalendarname;
	}

	public JButton getBtnDeletecalendar() {
		return btnDeletecalendar;
	}
	

}
