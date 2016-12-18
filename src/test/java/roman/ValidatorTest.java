package roman;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import roman.util.Validator;

public class ValidatorTest {

	@Test
	public void validateStringTest() {
		String string1 = "Invalid'String";
		assertFalse(Validator.validateString(string1));
		String string2 = "Another_Invalid_String\n";
		assertFalse(Validator.validateString(string2));
		String string3 = "X V I";
		assertFalse(Validator.validateString(string3));
		String string4 = "XVI\"";
		assertFalse(Validator.validateString(string4));

		String actualNumber = "XVI";
		assertTrue(Validator.validateString(actualNumber));
	}

	@Test
	public void validateRomanNumberTest() {
		String string1 = "Randomtext";
		assertFalse(Validator.validateAsRomanNumber(string1));
		String string2 = "XVIHI";
		assertFalse(Validator.validateAsRomanNumber(string2));

		String string3 = "dcvi";
		assertTrue(Validator.validateAsRomanNumber(string3));
		String actualNumber = "XVI";
		assertTrue(Validator.validateAsRomanNumber(actualNumber));
	}

}
