package by.htp.task01.service.validation;

import java.util.regex.Pattern;

public final class DataValidatorService {
	public static final String NUMBER_REGULAR = "\\d+";
	public static final String YEAR_REGULAR = "[0-9]{4}";

	private DataValidatorService() {
	}

	public static boolean validateYear(String year) {

		return Pattern.matches(YEAR_REGULAR, year);
	}

	public static boolean validateString(String str) {
		if (str == null || str.isEmpty()) {

			return false;
		} else {

			return true;
		}
	}

	public static boolean validateNumber(String number) {

		return Pattern.matches(NUMBER_REGULAR, number);
	}
}
