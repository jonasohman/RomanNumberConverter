package roman.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import roman.exception.RomanNumberException;
import roman.service.RomanNumberConverterService;
import roman.service.RomanNumberConverterServiceImpl;

public class Main {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		RomanNumberConverterService converterService = new RomanNumberConverterServiceImpl();
		String number = "";
		String errorMessage = null;
		System.out.println("Welcome to the Roman numerical converter!\n");
		System.out.println("Convert Roman numbers by typing them in the terminal and press Enter\n");
		System.out.println("Quit by typing 'q' and press Enter\n");

		while (!number.equals("q")) {
			System.out.println("Enter a roman number:");
			try {
				number = reader.readLine().toUpperCase();
			} catch (IOException e) {
				System.out.println("Could not read input, try again!");
				continue;
			}
			if (number.equals("Q"))
				break;
			try {
				System.out.format("Converted %s into %d\n\n", number, converterService.romanNumberToInteger(number));
			} catch (RomanNumberException e) {
				errorMessage = e.getMessage();
			} finally {
				if (errorMessage != null)
					System.out.println(errorMessage);
			}
		}
		System.out.format("Thank you, hope to see you soon!");
	}

}
