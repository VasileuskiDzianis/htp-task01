package by.htp.task01.service.validation;

import java.util.regex.Pattern;

public final class ValidationData {
	public static final String NUMBER_REGULAR = "\\d+";
	public static final String YEAR_REGULAR = "[0-9]{4}";
	
	private ValidationData() {}

	public static boolean validBook(String title, String genre, String author, String year, String quantity){
		if(validString(title) && validString(title) && validString(title) 
				&& validNumber(quantity) && validYear(year)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean validBook(String title, String genre, String author, String year, String quantity, String idBook){
		if(validString(title) && validString(title) && validString(title) 
				&& validNumber(quantity) && validYear(year) && validNumber(idBook)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean validYear(String year){
		return Pattern.matches(YEAR_REGULAR, year);
	}
	
	public static boolean validUser(String login, String password){
		if(validString(login) && validString(password)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean validString(String str){
		if(str == null || str.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean validNumber(String number){
		return Pattern.matches(NUMBER_REGULAR, number);
	}
	
}
