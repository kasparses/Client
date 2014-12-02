package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LogOut extends JPanel {
	private final JLabel lblYouAreNow = new JLabel("You are now logged out");
	private final JLabel lblSeeYouSoon = new JLabel("See you soon");
	private final JLabel label = new JLabel("");
	private final JButton btnLogIn = new JButton("Log In");
	private final JLabel label_1 = new JLabel("");

	/**
	 * Create the panel.
	 */
	public LogOut() {
		setLayout(null);
		lblYouAreNow.setForeground(Color.WHITE);
		lblYouAreNow.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblYouAreNow.setBounds(502, 116, 361, 37);
		
		add(lblYouAreNow);
		lblSeeYouSoon.setForeground(Color.WHITE);
		lblSeeYouSoon.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSeeYouSoon.setBounds(583, 220, 232, 37);
		
		add(lblSeeYouSoon);
		label.setIcon(new ImageIcon(LogOut.class.getResource("/Images2/CBSLogo3.png")));
		label.setBounds(0, 709, 250, 59);
		
		add(label);
		btnLogIn.setContentAreaFilled(false);
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogIn.setBounds(528, 338, 310, 67);
		
		add(btnLogIn);
		label_1.setIcon(new ImageIcon(LogOut.class.getResource("/Images2/MetalBackground.jpg")));
		label_1.setBounds(0, 0, 1366, 768);
		
		add(label_1);

	}
	public void addActionListener(ActionListener l){
		btnLogIn.addActionListener(l);
		

	}
	public JButton getBtnLogIn() {
		return btnLogIn;
	}

}
