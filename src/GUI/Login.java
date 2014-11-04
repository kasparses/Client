package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Login extends JPanel {
	private JLabel lblLogin;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		
		lblLogin = new JLabel("LogIn");
		lblLogin.setBounds(185, 11, 46, 14);
		add(lblLogin);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(46, 59, 46, 14);
		add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(46, 113, 46, 14);
		add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(163, 223, 89, 23);
		add(btnLogin);
			
	}
}
