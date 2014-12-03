package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Eventlist extends JPanel {
	private final JLabel lblEventList = new JLabel("Event List");
	private final JButton btnAdd = new JButton("Add");
	private final JButton btnMain = new JButton("Main");
	private final JButton btnLogOut = new JButton("Log Out");
	private final JLabel label = new JLabel("");
	private final JLabel label_1 = new JLabel("");

	/**
	 * Create the panel.
	 */
	
	
	
	public Eventlist() {
		setLayout(null);
		lblEventList.setForeground(Color.WHITE);
		lblEventList.setFont(new Font("Tahoma", Font.BOLD, 78));
		lblEventList.setBounds(490, 11, 385, 95);
		
		add(lblEventList);
		btnAdd.setOpaque(true);
		btnAdd.setForeground(new Color(0, 0, 205));
		btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnAdd.setBounds(1203, 136, 118, 29);
		
		add(btnAdd);
		btnMain.setForeground(Color.WHITE);
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMain.setContentAreaFilled(false);
		btnMain.setBounds(563, 525, 203, 59);
		
		add(btnMain);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(563, 596, 203, 59);
		
		add(btnLogOut);
		label.setIcon(new ImageIcon(Eventlist.class.getResource("/Images2/CBSLogo3.png")));
		label.setBounds(0, 709, 250, 59);
		
		add(label);
		label_1.setIcon(new ImageIcon(Eventlist.class.getResource("/Images2/MetalBackground.jpg")));
		label_1.setBounds(0, 0, 1366, 768);
		
		add(label_1);

	}
	public void addActionListener(ActionListener l) {
		btnMain.addActionListener(l);
		btnLogOut.addActionListener(l);
		btnAdd.addActionListener(l);

}
	public JButton getBtnMain() {
		return btnMain;
	}
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	

}
