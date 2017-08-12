package by.htp.task01.service.validation;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import by.htp.task01.service.validation.DataValidatorService;

public class TestValidationData {

	/*
	 * YearStr must be number
	 */
	@Test
	public void testValidBook(){
		boolean result = DataValidatorService.validBook("BookTitle", "MyGenre", "MyAuthor", "yearStr", "10");
		assertFalse(result);
	}
	
	@Test
	public void testValidUser(){
		boolean result = DataValidatorService.validUser(null, null);
		assertFalse(result);
	}

}
