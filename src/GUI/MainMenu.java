package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MainMenu extends JPanel {
	private JLabel lblMainmenu;
	private JButton button;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public MainMenu() {
		setLayout(null);
		
		lblMainmenu = new JLabel("Mainmenu");
		lblMainmenu.setBounds(163, 11, 46, 14);
		add(lblMainmenu);
		
		button = new JButton("");
		button.setBounds(42, 54, 89, 23);
		add(button);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(42, 105, 89, 23);
		add(btnNewButton);

	}
}
