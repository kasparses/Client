package GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Login extends JPanel {
	private JLabel lblLogin;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JTextField usernameTextField;
	private JTextField passwordTextField_1;

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
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(163, 56, 86, 20);
		add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField_1 = new JTextField();
		passwordTextField_1.setBounds(166, 110, 86, 20);
		add(passwordTextField_1);
		passwordTextField_1.setColumns(10);
			
	}
	public void addActionListener(ActionListener l) {
		btnLogin.addActionListener(l);
}
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public JTextField getUsernameTextField() {
		return usernameTextField;
	}
	public JTextField getPasswordTextField_1() {
		return passwordTextField_1;
	}
	
}
