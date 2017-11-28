package util;

import javax.swing.JOptionPane;

public class Messages {
	public static void errorMessage(String message) {
		showMessage(message, "Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showMessage(String message, String title, int type) {
		JOptionPane.showMessageDialog(null, message, title, type);
	}
}
