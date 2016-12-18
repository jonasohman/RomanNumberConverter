package roman.model;

import java.util.ArrayList;
import java.util.List;

import roman.exception.RomanNumberException;

public class RomanNumberChain {
	private String lastChar;
	private List<Integer> numberChain;
	private boolean isFirstLetter;

	public RomanNumberChain() {
		init();
	}

	private void init() {
		this.isFirstLetter = true;
		this.lastChar = null;
		this.numberChain = new ArrayList<Integer>();
	}

	public String getLastChar() {
		return lastChar;
	}

	public void setLastChar(String lastChar) {
		this.lastChar = lastChar;
	}

	public List<Integer> getNumberChain() {
		return numberChain;
	}

	public void setNumberChain(List<Integer> numberChain) {
		this.numberChain = numberChain;
	}

	public void createChain(String romanNumberChain) throws RomanNumberException {
		init();
		for (int i = 0; i < romanNumberChain.length(); i++) {
			addRomanNumberToChain(romanNumberChain.charAt(i));
		}
	}

	private void addRomanNumberToChain(char number) throws RomanNumberException {
		int currentNumber = charToInt(number);
		if (!isFirstLetter) {
			int lastNumber = charToInt(this.getLastChar().charAt(0));

			if (currentNumber > lastNumber) {
				substractFromNumber(currentNumber, lastNumber);
			}
		}
		this.isFirstLetter = false;
		this.numberChain.add(charToInt(number));
		this.lastChar = String.valueOf(number);
	}

	private static int charToInt(char c) {
		if (c == 'I') {
			return 1;
		} else if (c == 'V') {
			return 5;
		} else if (c == 'X') {
			return 10;
		} else if (c == 'L') {
			return 50;
		} else if (c == 'C') {
			return 100;
		} else if (c == 'D') {
			return 500;
		} else if (c == 'M') {
			return 1000;
		} else {
			return 0;
		}
	}

	private void substractFromNumber(int currentNumber, int lastNumber) throws RomanNumberException {
		if ((currentNumber == 5 || currentNumber == 10) && lastNumber == 1) {
			this.numberChain.set(this.numberChain.size() - 1, -1);
		} else if ((currentNumber == 50 || currentNumber == 100) && lastNumber == 10) {
			this.numberChain.set(this.numberChain.size() - 1, -10);
		} else if ((currentNumber == 500 || currentNumber == 1000) && lastNumber == 100) {
			this.numberChain.set(this.numberChain.size() - 1, -100);
		} else {
			throw new RomanNumberException("Could not parse, check the order of numbers");
		}
	}

	public int calculateSumOfChain() {
		int sum = 0;
		for (int i : this.numberChain) {
			sum += i;
		}
		return sum;
	}
}
