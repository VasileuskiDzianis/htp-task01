package by.htp.task01.service.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataValidatorServiceTest {

	@Test
	public void testValidateYear() {
		assertTrue(DataValidatorService.validateYear("0000"));
		assertTrue(DataValidatorService.validateYear("2017"));
		assertFalse(DataValidatorService.validateYear("2a17"));
		assertFalse(DataValidatorService.validateYear("21117"));
		assertFalse(DataValidatorService.validateYear("117"));
	}

	@Test
	public void testValidateString() {
		assertTrue(DataValidatorService.validateString("Vasil Bykov"));
		assertFalse(DataValidatorService.validateString(""));
		assertFalse(DataValidatorService.validateString(null));
	}

	@Test
	public void testValidateNumber() {
		assertTrue(DataValidatorService.validateNumber("34677"));
		assertFalse(DataValidatorService.validateNumber(""));
		assertFalse(DataValidatorService.validateNumber("ad"));
		assertFalse(DataValidatorService.validateNumber("1O"));
	}
}
