package roman.util;

public class Validator {

	public static boolean validateString(String stringToValidate) {
		if (!stringToValidate.matches("[a-zA-Z]+")) {
			return false;
		}
		return true;
	}

	public static boolean validateAsRomanNumber(String numberToValidate) {
		String romanNumber = numberToValidate.toUpperCase();
		for (int i = 0; i < romanNumber.length(); i++) {
			char c = romanNumber.charAt(i);
			if (!checkChar(c)) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkChar(char c) {
		if (c == 'I') {
			return true;
		} else if (c == 'V') {
			return true;
		} else if (c == 'X') {
			return true;
		} else if (c == 'L') {
			return true;
		} else if (c == 'C') {
			return true;
		} else if (c == 'D') {
			return true;
		} else if (c == 'M') {
			return true;
		} else {
			return false;
		}
	}

}
