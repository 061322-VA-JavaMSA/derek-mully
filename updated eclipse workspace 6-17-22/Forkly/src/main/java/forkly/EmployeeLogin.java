package forkly;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLogin window = new EmployeeLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 652, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 18));
		lblNewLabel.setBounds(103, 163, 139, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Montserrat Medium", Font.PLAIN, 18));
		lblPassword.setBounds(103, 244, 133, 32);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Montserrat", Font.PLAIN, 14));
		textField.setBounds(246, 165, 296, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Montserrat", Font.PLAIN, 14));
		passwordField.setBounds(246, 246, 296, 32);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("EMPLOYEE LOGIN");
		lblNewLabel_1.setFont(new Font("Montserrat ExtraLight", Font.BOLD, 24));
		lblNewLabel_1.setBounds(203, 80, 236, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(232, 11, 164, 131);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("CREATE ACCOUNT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(232, 332, 192, 52);
		frame.getContentPane().add(btnNewButton);
	}
}
