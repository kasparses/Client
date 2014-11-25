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

public class CreateEvent extends JPanel {
	private JTextField textField_Location;
	private JTextField textField_ActivityID;
	private JTextField textField_Start;
	private JButton btnSubmit;
	private JButton btnLogout;
	private JLabel lblCBSlogo;
	private JButton btnMainMenu;
	private JLabel lblUserInfo;
	private JLabel lblEnd;
	private JLabel lblName;
	private JLabel lblText;
	private JTextField textField_End;
	private JTextField textField_Title;
	private JTextField textField_Text;
	private final JLabel lblType = new JLabel("Type");
	private final JTextField textField_Type = new JTextField();
	private final JLabel lblEventid = new JLabel("EventID");
	private final JTextField textField_EventID = new JTextField();
	private final JLabel lblDescription = new JLabel("Description");
	private final JTextField textField_Description = new JTextField();
	private JLabel lblCalendarname;
	private JTextField textField_CalendarName;

	/**
	 * Create the panel.
	 */
	public CreateEvent() {
		setPreferredSize(new Dimension(1366, 768));
		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		lblCBSlogo = new JLabel("");
		lblCBSlogo.setBounds(10, 698, 250, 59);
		add(lblCBSlogo);
		

		btnLogout = new JButton("Log out");
		btnLogout.setBounds(611, 684, 143, 59);
		btnLogout.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		add(btnLogout);

		textField_Location = new JTextField();
		textField_Location.setBounds(688, 198, 120, 34);
		textField_Location.setForeground(new Color(105, 105, 105));
		textField_Location.setColumns(10);
		add(textField_Location);

		JLabel lblEmail = new JLabel("Location");
		lblEmail.setBounds(483, 195, 109, 30);
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 26));
		add(lblEmail);

		textField_ActivityID = new JTextField();
		textField_ActivityID.setBounds(755, 238, 120, 34);
		textField_ActivityID.setForeground(new Color(105, 105, 105));
		textField_ActivityID.setColumns(10);
		add(textField_ActivityID);

		JLabel lblTeam = new JLabel("ActivityID");
		lblTeam.setBounds(483, 242, 159, 31);
		lblTeam.setFont(new Font("Arial", Font.BOLD, 26));
		lblTeam.setForeground(new Color(255, 255, 255));
		add(lblTeam);

		textField_Start = new JTextField();
		textField_Start.setBounds(755, 285, 120, 34);
		textField_Start.setForeground(new Color(105, 105, 105));
		textField_Start.setColumns(10);
		add(textField_Start);

		JLabel lblCreateddate = new JLabel("Start");
		lblCreateddate.setBounds(483, 288, 159, 31);
		lblCreateddate.setForeground(new Color(255, 255, 255));
		lblCreateddate.setFont(new Font("Arial", Font.BOLD, 26));
		add(lblCreateddate);

		btnSubmit = new JButton("Create event");
		btnSubmit.setBounds(570, 600, 239, 43);
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//Submit changes to databases
			//hvad sker der n�r �ndringer ved en bruger submittes
			}
		}
		);
		add(btnSubmit);

		
				
		btnMainMenu = new JButton("Main menu");
		btnMainMenu.setBounds(611, 641, 164, 44);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		add(btnMainMenu);

		lblUserInfo = new JLabel("Create event");
		lblUserInfo.setBounds(451, 90, 466, 91);
		lblUserInfo.setForeground(Color.WHITE);
		lblUserInfo.setFont(new Font("Arial", Font.BOLD, 78));
		add(lblUserInfo);

		lblEnd = new JLabel("End");
		lblEnd.setBounds(483, 337, 159, 31);
		lblEnd.setForeground(Color.WHITE);
		lblEnd.setFont(new Font("Arial", Font.BOLD, 26));
		add(lblEnd);

		lblName = new JLabel("Title");
		lblName.setBounds(483, 379, 159, 31);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Arial", Font.BOLD, 26));
		add(lblName);

		lblText = new JLabel("Text");
		lblText.setBounds(483, 429, 159, 31);
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font("Arial", Font.BOLD, 26));
		add(lblText);

		textField_End = new JTextField();
		textField_End.setBounds(755, 332, 120, 34);
		textField_End.setForeground(SystemColor.controlDkShadow);
		textField_End.setColumns(10);
		add(textField_End);

		textField_Title = new JTextField();
		textField_Title.setBounds(755, 379, 120, 34);
		textField_Title.setForeground(SystemColor.controlDkShadow);
		textField_Title.setColumns(10);
		add(textField_Title);

		textField_Text = new JTextField();
		textField_Text.setBounds(755, 426, 120, 34);
		textField_Text.setForeground(SystemColor.controlDkShadow);
		textField_Text.setColumns(10);
		add(textField_Text);
		lblType.setBounds(483, 471, 159, 31);
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Arial", Font.BOLD, 26));

		add(lblType);
		textField_Type.setBounds(755, 471, 120, 34);
		textField_Type.setForeground(SystemColor.controlDkShadow);
		textField_Type.setColumns(10);

		add(textField_Type);
		lblEventid.setBounds(483, 513, 159, 31);
		lblEventid.setForeground(Color.WHITE);
		lblEventid.setFont(new Font("Arial", Font.BOLD, 26));
		
		add(lblEventid);
		textField_EventID.setBounds(755, 513, 120, 34);
		textField_EventID.setForeground(SystemColor.controlDkShadow);
		textField_EventID.setColumns(10);
		
		add(textField_EventID);
		lblDescription.setBounds(483, 558, 159, 31);
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Arial", Font.BOLD, 26));
		
		add(lblDescription);
		textField_Description.setBounds(755, 555, 120, 34);
		textField_Description.setForeground(SystemColor.controlDkShadow);
		textField_Description.setColumns(10);
		
		add(textField_Description);
		//=======

		//>>>>>>> FETCH_HEAD

		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 0, 0);
		add(lblBackground);
		
		lblCalendarname = new JLabel("CalendarName");
		lblCalendarname.setBounds(939, 484, 70, 14);
		add(lblCalendarname);
		
		textField_CalendarName = new JTextField();
		textField_CalendarName.setBounds(1061, 481, 86, 20);
		add(textField_CalendarName);
		textField_CalendarName.setColumns(10);



	}
	
	public void addActionListener(ActionListener l) {
		btnSubmit.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
	}

	public JTextField getTextField_Location() {
		return textField_Location;
	}

	public JTextField getTextField_ActivityID() {
		return textField_ActivityID;
	}

	
	public JTextField getTextField_CalendarName() {
		return textField_CalendarName;
	}

	public JTextField getTextField_Start() {
		return textField_Start;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JTextField getTextField_End() {
		return textField_End;
	}

	public JTextField getTextField_Title() {
		return textField_Title;
	}

	public JTextField getTextField_Text() {
		return textField_Text;
	}

	public JTextField getTextField_Type() {
		return textField_Type;
	}

	public JTextField getTextField_EventID() {
		return textField_EventID;
	}

	public JTextField getTextField_Description() {
		return textField_Description;
	}
}