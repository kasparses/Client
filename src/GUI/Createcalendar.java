package GUI;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

/**
 * Creates the JPanel for CreateCalendar to the Screen 
 * @author Mathias
 *
 */
public class Createcalendar extends JPanel {
	private JLabel lblCreatecalendar;
	private JLabel lblName;
	private JButton btnCreateCalendar;
	private JTextField txtName;
	private JRadioButton rdbtnPublic;
	private JRadioButton rdbtnPrivate;
	private JButton btnMain;
	private JButton btnLogOut;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Create the panel.
	 */
	public Createcalendar() {
		setLayout(null);
		
		lblCreatecalendar = new JLabel("Create calendar");
		lblCreatecalendar.setForeground(Color.WHITE);
		lblCreatecalendar.setFont(new Font("Tahoma", Font.BOLD, 78));
		lblCreatecalendar.setBounds(374, 11, 635, 95);
		add(lblCreatecalendar);
		
		lblName = new JLabel("Enter the calendars name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblName.setBounds(331, 250, 396, 37);
		add(lblName);
		
		btnCreateCalendar = new JButton("Create calendar");
		btnCreateCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateCalendar.setContentAreaFilled(false);
		btnCreateCalendar.setForeground(Color.WHITE);
		btnCreateCalendar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCreateCalendar.setBounds(505, 430, 356, 75);
		add(btnCreateCalendar);
		
		txtName = new JTextField();
		txtName.setBounds(737, 260, 272, 23);
		txtName.setColumns(10);
		add(txtName);
		
		rdbtnPublic = new JRadioButton("Public calendar");
		rdbtnPublic.setOpaque(false);
		rdbtnPublic.setForeground(Color.WHITE);
		rdbtnPublic.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnPublic.setBounds(721, 310, 181, 33);
		add(rdbtnPublic);
		
		rdbtnPrivate = new JRadioButton("Private Calendar");
		rdbtnPrivate.setOpaque(false);
		rdbtnPrivate.setForeground(Color.WHITE);
		rdbtnPrivate.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnPrivate.setBounds(494, 310, 193, 33);
		add(rdbtnPrivate);
		
		//Creates the Buttongroup so just one of the buttons can be chosen
		ButtonGroup group = new ButtonGroup();
		group.add(getRdbtnPrivate());
		group.add(getRdbtnPublic());
		
		btnMain = new JButton("Main");
		btnMain.setForeground(Color.WHITE);
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMain.setContentAreaFilled(false);
		btnMain.setBounds(54, 210, 225, 45);
		add(btnMain);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(54, 286, 225, 45);
		add(btnLogOut);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Createcalendar.class.getResource("/Images2/CBSLogo3.png")));
		label.setBounds(0, 709, 250, 59);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Createcalendar.class.getResource("/Images2/MetalBackground.jpg")));
		label_1.setBounds(0, 0, 1366, 768);
		add(label_1);

	}
	//Creates the ActionListeners for the buttons
	public void addActionListener(ActionListener l) {
		btnCreateCalendar.addActionListener(l);
		btnLogOut.addActionListener(l);
		btnMain.addActionListener(l);
}
	//Getters & Setters for the buttons and text fields
	public JButton getBtnCreateCalendar() {
		return btnCreateCalendar;
	}
	
	public JTextField getTxtName() {
		return txtName;
	}
	
	public JRadioButton getRdbtnPublic() {
		return rdbtnPublic;
	}
	public JRadioButton getRdbtnPrivate() {
		return rdbtnPrivate;
	}

	public JButton getBtnMain() {
		return btnMain;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	
}
