package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;

/**
 * Creates the JPanel for CreateEvent to the Screen 
 * @author Mathias
 *
 */
public class CreateEvent extends JPanel {
	private JLabel lblCBSlogo;
	private JLabel lblUserInfo;
	private JLabel label;
	private final JTextField textField_Location = new JTextField();
	private final JLabel lblLocation = new JLabel("Location");
	private final JLabel lblStart = new JLabel("Start");
	private final JLabel lblEnd = new JLabel("End");
	private final JLabel lblText = new JLabel("Text");
	private final JLabel lblTitle = new JLabel("Title");
	private final JTextField textField_Title = new JTextField();
	private final JTextField textField_Text = new JTextField();
	private final JLabel lblDescription = new JLabel("Description");
	private final JTextField textField_Description = new JTextField();
	private final JButton btnCreateEvent = new JButton("Create Event");
	private final JLabel lblCalendarname = new JLabel("Calendar Name");
	private final JTextField textField_CalendarName = new JTextField();
	private final JComboBox comboBox_StartMinutes = new JComboBox();
	private final JComboBox comboBox_StartHour = new JComboBox();
	private final JComboBox comboBox_EndHour = new JComboBox();
	private final JComboBox comboBox_EndMinutes = new JComboBox();
	private final JLabel lblStartYear = new JLabel("Year:");
	private final JLabel lblEndYear = new JLabel("Year:");
	private final JComboBox comboBox_StartYear = new JComboBox();
	private final JComboBox comboBox_EndYear = new JComboBox();
	private final JLabel lblStartMonth = new JLabel("Month:");
	private final JLabel lblEndMonth = new JLabel("Month:");
	private final JLabel lblStartDay = new JLabel("Day:");
	private final JLabel lblEndDay = new JLabel("Day:");
	private final JComboBox comboBox_StartMonth = new JComboBox();
	private final JComboBox comboBox_EndMonth = new JComboBox();
	private final JComboBox comboBox_StartDay = new JComboBox();
	private final JComboBox comboBox_EndDay = new JComboBox();
	private final JLabel lblStartTime = new JLabel("Time:");
	private final JLabel lblEndTime = new JLabel("Time:");
	private final JLabel label_17 = new JLabel(":");
	private final JLabel label_18 = new JLabel(":");
	private final JButton btnMain = new JButton("Main");
	private final JButton btnLogout = new JButton("Log Out");

	/**
	 * Create the panel.
	 */
	public CreateEvent() {
		setPreferredSize(new Dimension(1366, 768));
		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		lblCBSlogo = new JLabel("");
		lblCBSlogo.setIcon(new ImageIcon(CreateEvent.class.getResource("/Images2/CBSLogo3.png")));
		lblCBSlogo.setBounds(0, 709, 250, 59);
		add(lblCBSlogo);

		lblUserInfo = new JLabel("Create event");
		lblUserInfo.setBounds(451, 11, 492, 90);
		lblUserInfo.setForeground(Color.WHITE);
		lblUserInfo.setFont(new Font("Arial", Font.BOLD, 78));
		add(lblUserInfo);
		textField_Location.setForeground(SystemColor.controlDkShadow);
		textField_Location.setColumns(10);
		textField_Location.setBounds(744, 134, 120, 34);
		
		add(textField_Location);
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Arial", Font.BOLD, 26));
		lblLocation.setBounds(472, 134, 160, 30);
		
		add(lblLocation);
		lblStart.setForeground(Color.WHITE);
		lblStart.setFont(new Font("Arial", Font.BOLD, 26));
		lblStart.setBounds(472, 179, 160, 30);
		
		add(lblStart);
		lblEnd.setForeground(Color.WHITE);
		lblEnd.setFont(new Font("Arial", Font.BOLD, 26));
		lblEnd.setBounds(472, 224, 160, 30);
		
		add(lblEnd);
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font("Arial", Font.BOLD, 26));
		lblText.setBounds(472, 314, 160, 30);
		
		add(lblText);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
		lblTitle.setBounds(472, 269, 160, 30);
		
		add(lblTitle);
		textField_Title.setForeground(SystemColor.controlDkShadow);
		textField_Title.setColumns(10);
		textField_Title.setBounds(744, 269, 120, 34);
		
		add(textField_Title);
		textField_Text.setForeground(SystemColor.controlDkShadow);
		textField_Text.setColumns(10);
		textField_Text.setBounds(744, 314, 201, 90);
		
		add(textField_Text);
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Arial", Font.BOLD, 26));
		lblDescription.setBounds(472, 415, 160, 30);
		
		add(lblDescription);
		textField_Description.setForeground(SystemColor.controlDkShadow);
		textField_Description.setColumns(10);
		textField_Description.setBounds(744, 415, 120, 34);
		
		add(textField_Description);
		btnCreateEvent.setForeground(Color.WHITE);
		btnCreateEvent.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCreateEvent.setContentAreaFilled(false);
		btnCreateEvent.setBounds(558, 609, 250, 59);
		
		add(btnCreateEvent);
		lblCalendarname.setForeground(Color.WHITE);
		lblCalendarname.setFont(new Font("Arial", Font.BOLD, 26));
		lblCalendarname.setBounds(472, 460, 201, 30);
		
		add(lblCalendarname);
		textField_CalendarName.setColumns(10);
		textField_CalendarName.setBounds(744, 460, 120, 34);
		
		add(textField_CalendarName);
		comboBox_StartMinutes.setBounds(1179, 187, 48, 20);
		
		add(comboBox_StartMinutes);
		comboBox_StartHour.setBounds(1121, 187, 48, 20);
		
		add(comboBox_StartHour);
		comboBox_EndHour.setBounds(1121, 232, 48, 20);
		
		add(comboBox_EndHour);
		comboBox_EndMinutes.setBounds(1179, 232, 48, 20);
		
		add(comboBox_EndMinutes);
		lblStartYear.setForeground(Color.WHITE);
		lblStartYear.setFont(new Font("Arial", Font.BOLD, 20));
		lblStartYear.setBounds(612, 185, 50, 24);
		
		add(lblStartYear);
		lblEndYear.setForeground(Color.WHITE);
		lblEndYear.setFont(new Font("Arial", Font.BOLD, 20));
		lblEndYear.setBounds(612, 230, 50, 24);
		
		add(lblEndYear);
		comboBox_StartYear.setBounds(685, 187, 64, 20);
		
		add(comboBox_StartYear);
		comboBox_EndYear.setBounds(685, 232, 64, 20);
		
		add(comboBox_EndYear);
		lblStartMonth.setForeground(Color.WHITE);
		lblStartMonth.setFont(new Font("Arial", Font.BOLD, 20));
		lblStartMonth.setBounds(772, 185, 67, 24);
		
		add(lblStartMonth);
		lblEndMonth.setForeground(Color.WHITE);
		lblEndMonth.setFont(new Font("Arial", Font.BOLD, 20));
		lblEndMonth.setBounds(772, 230, 67, 24);
		
		add(lblEndMonth);
		lblStartDay.setForeground(Color.WHITE);
		lblStartDay.setFont(new Font("Arial", Font.BOLD, 20));
		lblStartDay.setBounds(929, 185, 43, 24);
		
		add(lblStartDay);
		lblEndDay.setForeground(Color.WHITE);
		lblEndDay.setFont(new Font("Arial", Font.BOLD, 20));
		lblEndDay.setBounds(929, 230, 43, 24);
		
		add(lblEndDay);
		comboBox_StartMonth.setBounds(858, 187, 48, 20);
		
		add(comboBox_StartMonth);
		comboBox_EndMonth.setBounds(858, 232, 48, 20);
		
		add(comboBox_EndMonth);
		comboBox_StartDay.setBounds(982, 187, 50, 20);
		
		add(comboBox_StartDay);
		comboBox_EndDay.setBounds(982, 232, 50, 20);
		
		add(comboBox_EndDay);
		lblStartTime.setForeground(Color.WHITE);
		lblStartTime.setFont(new Font("Arial", Font.BOLD, 20));
		lblStartTime.setBounds(1048, 185, 53, 24);
		
		add(lblStartTime);
		lblEndTime.setForeground(Color.WHITE);
		lblEndTime.setFont(new Font("Arial", Font.BOLD, 20));
		lblEndTime.setBounds(1048, 230, 53, 24);
		
		add(lblEndTime);
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Arial", Font.BOLD, 20));
		label_17.setBounds(1170, 230, 7, 24);
		
		add(label_17);
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Arial", Font.BOLD, 20));
		label_18.setBounds(1170, 185, 7, 24);
		
		add(label_18);
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMain.setForeground(Color.WHITE);
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMain.setContentAreaFilled(false);
		btnMain.setBounds(52, 214, 225, 45);
		
		add(btnMain);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(52, 290, 225, 45);
		
		add(btnLogout);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(CreateEvent.class.getResource("/Images2/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		add(label);

		//for loops for the radio buttons
		for (int c=0; c<=24; c++){
			 comboBox_StartHour.addItem(c);
	        }
		 for (int c2=0; c2<=60; c2+=5){
			 comboBox_StartMinutes.addItem(c2);
	        }
		 for (int c3=0; c3<=24; c3++){
			 comboBox_EndHour.addItem(c3);
	        }
		 for (int c4=0; c4<=60; c4+=5){
			 comboBox_EndMinutes.addItem(c4);
	        }

		 for (int c5 = 2014; c5<2017; c5++){
			 comboBox_StartYear.addItem(c5);
		 }
		 for (int c6 = 0; c6<=12; c6++){
			 comboBox_StartMonth.addItem(c6);
		 }
		 for (int c5 = 2014; c5<2017; c5++){
			 comboBox_EndYear.addItem(c5);
		 }
		 for (int c6 = 0; c6<=12; c6++){
			 comboBox_EndMonth.addItem(c6);
		 }
		 for (int c7 = 0; c7<=31; c7++){
			 comboBox_EndDay.addItem(c7);
		 }
		 for (int c8 = 0; c8<=31; c8++){
			 comboBox_StartDay.addItem(c8);
		 }


	}
	//Creates the ActionListeners for buttons
	public void addActionListener(ActionListener l) {
		btnCreateEvent.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMain.addActionListener(l);
	}
	//Getters & setters
	public JComboBox getComboBox_StartYear() {
		return comboBox_StartYear;
	}

	public JComboBox getComboBox_EndYear() {
		return comboBox_EndYear;
	}

	public JTextField getTextField_Location() {
		return textField_Location;
	}
	
	public JTextField getTextField_CalendarName() {
		return textField_CalendarName;
	}

	public JButton getBtnCreateEvent() {
		return btnCreateEvent;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnMain() {
		return btnMain;
	}

	public JTextField getTextField_Title() {
		return textField_Title;
	}

	public JTextField getTextField_Text() {
		return textField_Text;
	}

	public JTextField getTextField_Description() {
		return textField_Description;
	}

	public JComboBox getComboBox_StartMinutes() {
		return comboBox_StartMinutes;
	}

	public JComboBox getComboBox_StartHour() {
		return comboBox_StartHour;
	}

	public JComboBox getComboBox_EndHour() {
		return comboBox_EndHour;
	}

	public JComboBox getComboBox_EndMinutes() {
		return comboBox_EndMinutes;
	}

	public JComboBox getComboBox_StartMonth() {
		return comboBox_StartMonth;
	}

	public JComboBox getComboBox_EndMonth() {
		return comboBox_EndMonth;
	}

	public JComboBox getComboBox_StartDay() {
		return comboBox_StartDay;
	}

	public JComboBox getComboBox_EndDay() {
		return comboBox_EndDay;
	}
}