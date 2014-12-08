package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
/**
 * Creates the JPanel for ForgotLogin to the Screen 
 * @author Mathias
 *
 */
public class ForgotLogin extends JPanel {
	private final JLabel lblForgotLogin = new JLabel("Forgot Login");
	private final JLabel lblEnterYourSecurity = new JLabel("Enter your security number:");
	private final JTextField textField_CPR = new JTextField();
	private final JButton btnGetLogin = new JButton("Get Login");
	private final JButton btnLogin = new JButton("Login");
	private final JLabel label = new JLabel("");
	private final JLabel label_1 = new JLabel("");

	/**
	 * Create the panel.
	 */
	public ForgotLogin() {
		setLayout(null);
		lblForgotLogin.setForeground(Color.WHITE);
		lblForgotLogin.setFont(new Font("Tahoma", Font.BOLD, 78));
		lblForgotLogin.setBounds(435, 11, 512, 95);
		
		add(lblForgotLogin);
		lblEnterYourSecurity.setForeground(Color.WHITE);
		lblEnterYourSecurity.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEnterYourSecurity.setBounds(319, 227, 422, 37);
		
		add(lblEnterYourSecurity);
		textField_CPR.setColumns(10);
		textField_CPR.setBounds(761, 235, 272, 23);
		
		add(textField_CPR);
		btnGetLogin.setForeground(Color.WHITE);
		btnGetLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnGetLogin.setContentAreaFilled(false);
		btnGetLogin.setBounds(505, 348, 356, 75);
		
		add(btnGetLogin);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBounds(505, 460, 356, 75);
		
		add(btnLogin);
		label.setIcon(new ImageIcon(ForgotLogin.class.getResource("/Images2/CBSLogo3.png")));
		label.setBounds(0, 709, 250, 59);
		
		add(label);
		label_1.setIcon(new ImageIcon(ForgotLogin.class.getResource("/Images2/MetalBackground.jpg")));
		label_1.setBounds(0, 0, 1366, 768);
		
		add(label_1);

	}
	//Creates ActionListeners for buttons
	public void addActionListener(ActionListener l){
		btnGetLogin.addActionListener(l);
		btnLogin.addActionListener(l);
		

	}
	//Getters & setters
	public JTextField getTextField_CPR() {
		return textField_CPR;
	}
	public JButton getBtnGetLogin() {
		return btnGetLogin;
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
	
}
