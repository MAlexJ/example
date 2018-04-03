package com.malex.lecture_3_logic_operators;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * This class use of full logic operators like: || and &&
 */
public class FullLogicOperators {

	/**
	 * Constant
	 */
	private static final int LIMIT = 10;

	/**
	 * flag
	 */
	private boolean firstMethod;
	private boolean secondMethod;

	private boolean checkFirstNumber(int num) {
		// The method is invoke
		this.firstMethod = true;
		return num < LIMIT;
	}

	private boolean checkSecondNumber(int num) {
		// The method is invoke
		this.secondMethod = true;
		return num > LIMIT;
	}

	@Before
	public void before() {
		this.firstMethod = false;
		this.secondMethod = false;
	}

	@After
	public void after() {
		this.firstMethod = false;
		this.secondMethod = false;
	}

	// -------------------------
	//   A   |    B   |  A || B
	// -------------------------
	// True  | False  |  True
	// False | True   |  True
	// False | False  |  False
	// True  | True   |  True

	@Test
	public void test_1() {
		assertEquals(checkFirstNumber(1) || checkSecondNumber(11), true);
		assertTrue(this.firstMethod);
		assertFalse(this.secondMethod);
	}

	@Test
	public void test_2() {
		assertEquals(checkFirstNumber(1) || checkSecondNumber(1), true);
		assertTrue(this.firstMethod);
		assertFalse(this.secondMethod);
	}

	@Test
	public void test_3() {
		assertEquals(checkFirstNumber(100) || checkSecondNumber(11), true);
		assertTrue(this.firstMethod);
		assertTrue(this.secondMethod);
	}

	@Test
	public void test_4() {
		assertEquals(checkFirstNumber(100) || checkSecondNumber(1), false);
		assertTrue(this.firstMethod);
		assertTrue(this.secondMethod);
	}

	// -------------------------
	//   A   |    B   |  A && B
	// -------------------------
	// True  | False  |  False
	// False | True   |  False
	// False | False  |  False
	// True  | True   |  True

	@Test
	public void test_5() {
		// true && false
		assertEquals(checkFirstNumber(1) && checkSecondNumber(1), false);
		assertTrue(this.firstMethod);
		assertTrue(this.secondMethod);
	}

	@Test
	public void test_6() {
		// false && true
		assertEquals(checkFirstNumber(100) && checkSecondNumber(11), false);
		assertTrue(this.firstMethod);
		assertFalse(this.secondMethod); // #2: false
	}

	@Test
	public void test_7() {
		// false && true
		assertEquals(checkFirstNumber(100) && checkSecondNumber(1), false);
		assertTrue(this.firstMethod);
		assertFalse(this.secondMethod); // #2: false
	}

	@Test
	public void test_8() {
		// true && true
		assertEquals(checkFirstNumber(1) && checkSecondNumber(11), true);
		assertTrue(this.firstMethod);
		assertTrue(this.secondMethod);
	}

}
