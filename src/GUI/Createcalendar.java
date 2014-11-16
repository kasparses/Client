package GUI;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Createcalendar extends JPanel {
	private JLabel lblCreatecalendar;
	private JLabel lblName;
	private JButton btnCreateCalendar;
	private JTextField txtName;
	private JRadioButton rdbtnPublic;
	private JRadioButton rdbtnPrivate;

	/**
	 * Create the panel.
	 */
	public Createcalendar() {
		setLayout(null);
		
		lblCreatecalendar = new JLabel("CreateCalendar");
		lblCreatecalendar.setBounds(174, 23, 76, 14);
		add(lblCreatecalendar);
		
		lblName = new JLabel("Name");
		lblName.setBounds(26, 82, 46, 14);
		add(lblName);
		
		btnCreateCalendar = new JButton("Create Calendar");
		btnCreateCalendar.setBounds(174, 244, 111, 23);
		add(btnCreateCalendar);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(184, 79, 86, 20);
		add(txtName);
		txtName.setColumns(10);
		
		rdbtnPublic = new JRadioButton("Public calendar");
		rdbtnPublic.setBounds(258, 160, 109, 23);
		add(rdbtnPublic);
		
		rdbtnPrivate = new JRadioButton("Private Calendar");
		rdbtnPrivate.setBounds(114, 160, 109, 23);
		add(rdbtnPrivate);
		

		ButtonGroup group = new ButtonGroup();
		group.add(getRdbtnPrivate());
		group.add(getRdbtnPublic());

	}
	public void addActionListener(ActionListener l) {
		btnCreateCalendar.addActionListener(l);
		
}
	
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
	
}
