package util;

public class Validations {
	public static Boolean isEmpty(String s) {
		return s.replace(" ", "").length() <= 0;
	}
	
	public static Boolean isNumeric(String n) {
		if (!n.equals(".")) {
			try {
				Double.parseDouble(n);
			} catch (NumberFormatException nfe) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
}
