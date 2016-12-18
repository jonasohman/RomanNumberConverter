package roman.service;

import roman.exception.RomanNumberException;

public interface RomanNumberConverterService {
	public Integer romanNumberToInteger(String romanNumber) throws RomanNumberException;
}
