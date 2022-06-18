package forkly;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class CustomerLogin {

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
					CustomerLogin window = new CustomerLogin();
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
	public CustomerLogin() {
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
		lblNewLabel.setBounds(103, 196, 139, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Montserrat Medium", Font.PLAIN, 18));
		lblPassword.setBounds(103, 268, 133, 32);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Montserrat", Font.PLAIN, 14));
		textField.setBounds(246, 198, 296, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Montserrat", Font.PLAIN, 14));
		passwordField.setBounds(246, 270, 296, 32);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("CUSTOMER LOGIN");
		lblNewLabel_1.setFont(new Font("Montserrat ExtraLight", Font.BOLD, 24));
		lblNewLabel_1.setBounds(204, 148, 236, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(232, 11, 164, 131);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
