package edu.virginia.cs2110;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginWindow extends JFrame{
	LoginWindow self;
	JButton submit;
	JPanel panel;
	JLabel label1, label2;
	
	JTextField userField;
	JPasswordField passField;
	
	JTextArea welcome;
	
	public LoginWindow() {
		initialize();
	}
	
	private void initialize() {
		label1 = new JLabel();
		label1.setText("Username:");
		userField = new JTextField("cs2110test@gmail.com");
		
		label2 = new JLabel();
		label2.setText("Password:");
		passField = new JPasswordField("softwaredevelopment");
		
		submit = new JButton("SUBMIT!!!");
		
		panel = new JPanel(new GridLayout(3,1));
		panel.add(label1);
		panel.add(userField);
		panel.add(label2);
		panel.add(passField);
		panel.add(submit);
		add(panel,BorderLayout.CENTER);
		
		self = this;
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = userField.getText().trim();
				char[] pass = passField.getPassword();
				String passStr = new String(pass);
				
				
				
				self.dispose();
				
				Client client = new Client(username, passStr);
				
				
				
				
			}
		});
		setTitle("GTalk Application");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
//	public void actionPerformed(ActionEvent ae) {
//	
//		
//		
//		
//		
//	}
	
	
	
	
}
