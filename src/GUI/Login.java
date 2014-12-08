package GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
/**
 * Creates the JPanel for Login to the Screen 
 * @author Mathias
 *
 */
public class Login extends JPanel {
	private JLabel lblLogin;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private final JButton btnForgotLogin = new JButton("Forgot Login?");
	private final JLabel label = new JLabel("");
	private JLabel label_1;
	private JTextField TextField_Username;
	private JPasswordField TextField_Password;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		
		lblLogin = new JLabel("Welcome");
		lblLogin.setBounds(503, 11, 359, 95);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 78));
		add(lblLogin);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(538, 257, 140, 32);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 26));
		add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(537, 305, 134, 32);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 26));
		add(lblPassword);
		
		btnLogin = new JButton("Log In");
		btnLogin.setBounds(551, 445, 264, 71);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogin.setContentAreaFilled(false);
		add(btnLogin);
		btnForgotLogin.setBounds(551, 542, 264, 71);
		btnForgotLogin.setForeground(Color.WHITE);
		btnForgotLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnForgotLogin.setContentAreaFilled(false);
		
		add(btnForgotLogin);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/Images2/CBSLogo3.png")));
		label_1.setBounds(0, 709, 250, 59);
		add(label_1);
		
		TextField_Username = new JTextField();
		TextField_Username.setOpaque(false);
		TextField_Username.setHorizontalAlignment(SwingConstants.CENTER);
		TextField_Username.setForeground(Color.BLACK);
		TextField_Username.setFont(new Font("Dialog", Font.PLAIN, 17));
		TextField_Username.setColumns(10);
		TextField_Username.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255)));
		TextField_Username.setBounds(690, 259, 164, 37);
		add(TextField_Username);
		
		TextField_Password = new JPasswordField();
		TextField_Password.setOpaque(false);
		TextField_Password.setHorizontalAlignment(SwingConstants.CENTER);
		TextField_Password.setColumns(10);
		TextField_Password.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255)));
		TextField_Password.setBounds(690, 302, 164, 37);
		add(TextField_Password);
		label.setIcon(new ImageIcon(Login.class.getResource("/Images2/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);
			
	}
	//Creates ActionsListeners for buttons
	public void addActionListener(ActionListener l) {
		btnLogin.addActionListener(l);
		btnForgotLogin.addActionListener(l);
}
	//Getters & setters
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public JTextField getTextField_Username() {
		return TextField_Username;
	}
	public JTextField getTextField_Password() {
		return TextField_Password;
	}
	public JButton getBtnForgotLogin() {
		return btnForgotLogin;
	}
	
}
