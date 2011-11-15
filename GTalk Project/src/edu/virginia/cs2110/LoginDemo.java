package edu.virginia.cs2110;
import javax.swing.*;






public class LoginDemo {
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createLoginWindow();
            }
        });
    }
	
	private static void createLoginWindow() {
		LoginWindow login = new LoginWindow();
        login.setSize(400,150);
        login.setVisible(true);
	}
	
}