package roman.service;

import roman.exception.RomanNumberException;
import roman.model.RomanNumberChain;
import roman.util.Validator;

public class RomanNumberConverterServiceImpl implements RomanNumberConverterService {

	@Override
	public Integer romanNumberToInteger(String romanNumber) throws RomanNumberException {
		isStringValid(romanNumber);

		RomanNumberChain chain = new RomanNumberChain();
		chain.createChain(romanNumber);
		
		return chain.calculateSumOfChain();
	}

	private static void isStringValid(String number) throws RomanNumberException {
		if (!Validator.validateString(number))
			throw new RomanNumberException("Invalid input, only letters allowed");
		if (!Validator.validateAsRomanNumber(number))
			throw new RomanNumberException("Not a valid roman number");
	}

}
