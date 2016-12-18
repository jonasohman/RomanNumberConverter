package roman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import roman.exception.RomanNumberException;
import roman.model.RomanNumberChain;

public class NumberChainTest {

	@Test
	public void calculateBasicChainTest() {
		RomanNumberChain chain = new RomanNumberChain();
		try {
			chain.createChain("I");
			assertEquals(1, chain.calculateSumOfChain());
			chain.createChain("V");
			assertEquals(5, chain.calculateSumOfChain());
			chain.createChain("X");
			assertEquals(10, chain.calculateSumOfChain());
			chain.createChain("L");
			assertEquals(50, chain.calculateSumOfChain());
			chain.createChain("C");
			assertEquals(100, chain.calculateSumOfChain());
			chain.createChain("D");
			assertEquals(500, chain.calculateSumOfChain());
			chain.createChain("M");
			assertEquals(1000, chain.calculateSumOfChain());
		} catch (RomanNumberException e) {
			assertTrue(false);
		}
	}

	@Test
	public void calculateChainWithLess() {
		RomanNumberChain chain = new RomanNumberChain();
		try {
			chain.createChain("IV");
			assertEquals(4, chain.calculateSumOfChain());
			chain.createChain("IX");
			assertEquals(9, chain.calculateSumOfChain());
			chain.createChain("XL");
			assertEquals(40, chain.calculateSumOfChain());
			chain.createChain("XC");
			assertEquals(90, chain.calculateSumOfChain());
			chain.createChain("CD");
			assertEquals(400, chain.calculateSumOfChain());
			chain.createChain("CM");
			assertEquals(900, chain.calculateSumOfChain());
		} catch (RomanNumberException e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void advancedChainTest() {
		RomanNumberChain chain = new RomanNumberChain();
		
		try {
			chain.createChain("MCMLIV");
			assertEquals(1954, chain.calculateSumOfChain());
			chain.createChain("MCMXCIX");
			assertEquals(1999, chain.calculateSumOfChain());
			chain.createChain("MCMXCVIIII");
			assertEquals(1999, chain.calculateSumOfChain());
			chain.createChain("MDCCCCXCIX");
			assertEquals(1999, chain.calculateSumOfChain());
		} catch (RomanNumberException e) {
			assertTrue(false);
		}
		
		try {
			chain.createChain("MDCCCCXCIXM");
		} catch (RomanNumberException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void invalidRomanNumberTest() {
		RomanNumberChain chain = new RomanNumberChain();
		try {
			chain.createChain("MDCCCCXCIXM");
		} catch (RomanNumberException e) {
			assertTrue(true);
		}
		
		try {
			chain.createChain("123");
		} catch (RomanNumberException e) {
			assertTrue(true);
		}
		
		try {
			chain.createChain("-");
		} catch (RomanNumberException e) {
			assertTrue(true);
		}
		try {
			chain.createChain(",");
		} catch (RomanNumberException e) {
			assertTrue(true);
		}
		try {
			chain.createChain("'");
		} catch (RomanNumberException e) {
			assertTrue(true);
		}
		try {
			chain.createChain("?");
		} catch (RomanNumberException e) {
			assertTrue(true);
		}
		try {
			chain.createChain("A");
		} catch (RomanNumberException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testLowerCase() {
		RomanNumberChain chain = new RomanNumberChain();
		try {
			chain.createChain("iv");
			assertEquals(4, chain.calculateSumOfChain());
			chain.createChain("ix");
			assertEquals(9, chain.calculateSumOfChain());
			chain.createChain("xl");
			assertEquals(40, chain.calculateSumOfChain());
			chain.createChain("xc");
			assertEquals(90, chain.calculateSumOfChain());
			chain.createChain("cd");
			assertEquals(400, chain.calculateSumOfChain());
			chain.createChain("cm");
			assertEquals(900, chain.calculateSumOfChain());
		} catch (RomanNumberException e) {
			assertTrue(false);
		}
	}

}
