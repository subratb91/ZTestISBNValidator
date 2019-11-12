package com.example.app.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateISBNTest {

	@Test
	public void checkValid10DigitIsbn() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkIsbn("0140449116");
		assertTrue("First Value", result);
		result = validator.checkIsbn("0140177396");
		assertTrue("Second Value", result);
	}

	@Test
	public void checkValid13DigitIsbn() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkIsbn("9781853260087");
		assertTrue("First Value", result);
		result = validator.checkIsbn("9781853267338");
		assertTrue("Second Value", result);
	}

	@Test
	public void TenDigitIsbnNumbersEndingInXAreValid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkIsbn("012000030X");
		assertTrue(result);
	}

	@Test
	public void checkInvalid10DigitIsbn() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkIsbn("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void checkInvalid13DigitIsbn() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkIsbn("9781853267339");
		assertFalse(result);
	}

	@Test(expected = NumberFormatException.class)
	public void nineDigitsIsbnNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkIsbn("123456789");
	}

	@Test(expected = NumberFormatException.class)
	public void nonNumericIsbnNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkIsbn("helloworld");
	}

}
